# Using OCI Events, Notifications, and Functions for automating Jira ticketing

Function Event Handler: OciEventProcessor of package com.oci.fn.demo
POJOs for Jira Cloud in the package com.jira.cloud.pojo
POJOs for OCI CloudEvent in the package com.oci.services.events.pojo

## Code Details

Let us dive into the code in top-down fashion starting with the function handler. The function handler is the method that gets invoked on function invocation. It is as shown below.
```Java

public String handleRequest(CloudEvent cloudEvent) {
 
    // Json body of Cloud event from Oracle Event Service in serialized into cloudEvent object by Fn SDK implicitly
    System.err.println("Inside Java jira function with input as " + cloudEvent.getEventType() + "  " + cloudEvent.getData().getResourceName());
 
    String response = jiraCreateTicket(cloudEvent);
 
    if (response != null) return response;
 
    return null;
}
 
private String jiraCreateTicket(CloudEvent cloudEvent) {
 
    try {
        //create jira ticket body as per CloudEvent
        String jsonBodyJira = getJiraApiBody(cloudEvent);
 
        String jiraCloudEndpoint = System.getenv().get("JIRA_CLOUD_URL");
        String ocidForSecretForJiraAuthToken = System.getenv().get("JIRA_CLOUD_SECRET_OCID");
        String jiraAuthToken= getSecretForOcid(ocidForSecretForJiraAuthToken); // base64 encoded form of <YourJiraUsername:YourJiraAuthToken>
 
        // actual REST call to JIRA cloud
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, jsonBodyJira);
        Request request = new Request.Builder()
                .url(jiraCloudEndpoint)
                .method("POST", body)
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Basic "+ jiraAuthToken)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
 
    } catch (JsonProcessingException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}
```

The parameter CloudEvent is POJO(Plain Old Java Objects) for CloudEvent JSON schema. These POJOs are basically Java classes whose objects actually hold serialized JSON for CloudEvent. The conversion from JSON to this POJO happens implicitly with the help of Java fn-SDK. If instead of CloudEvent POJO you had String as an argument to this function, it would receive raw JSON. Both options are available to the developer.

We do not want to hard code configurable values like the endpoint of Jira Cloud URL and OCID for the secret of Jira Auth Token(created in the previous step). We are using function config values for it. We will see how to set them when we deploy the function on OCI. These Config values are available as environment variables in the function code.

```Java
String jiraCloudEndpoint = System.getenv().get("JIRA_CLOUD_URL");
String ocidForSecretForJiraAuthToken = System.getenv().get("JIRA_CLOUD_SECRET_OCID");
```

Now let me explain the mechanisms used by the handler to get the actual secret.

We need to have the following dependencies(part of OCI Java SDK) in the pom.xml
```xml
<dependency>
 <groupId>com.oracle.oci.sdk</groupId>
 <artifactId>oci-java-sdk-vault</artifactId>
 <version>1.15.3</version>
</dependency>
<dependency>
 <groupId>com.oracle.oci.sdk</groupId>
 <artifactId>oci-java-sdk-secrets</artifactId>
 <version>1.17.5</version>
</dependency>
<dependency>
 <groupId>com.oracle.oci.sdk</groupId>
 <artifactId>oci-java-sdk-common</artifactId>
 <version>1.17.5</version>
</dependency>
```

We need to create SecretClient to access the OCI secret service, using Resource Principal Authentication.


```Java
private SecretsClient getSecretClient(){
    String version = System.getenv("OCI_RESOURCE_PRINCIPAL_VERSION");
    BasicAuthenticationDetailsProvider provider = null;
    if( version != null ) {
        provider = ResourcePrincipalAuthenticationDetailsProvider.builder().build();
    }
    else {
        try {
            // for local dev/testing
            // the user profile you choose here must belong to a group with these Authorizations in a policy, unless the user is Admin
            // 'allow group <group name> to use secret-family in compartment < of your secret>'
            provider = new ConfigFileAuthenticationDetailsProvider("~/.oci/config", "nonAdmin");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    secretsClient = new SecretsClient(provider);
    secretsClient.setRegion(Region.US_ASHBURN_1);
 
    System.out.println("Created client for secrets retrieval "+ secretsClient);
    return secretsClient;
}
```

Now we can fetch the actual secret given its OCID, in a secure way as follows. Note, we get base64 encoded secret and not plain-text of the secret. And this is what we need to authenticate our function as a client with Jira Cloud.

```Java
private SecretsClient getSecretClient(){
    String version = System.getenv("OCI_RESOURCE_PRINCIPAL_VERSION");
    BasicAuthenticationDetailsProvider provider = null;
    if( version != null ) {
        provider = ResourcePrincipalAuthenticationDetailsProvider.builder().build();
    }
    else {
        try {
            // for local dev/testing
            // the user profile you choose here must belong to a group with these Authorizations in a policy, unless the user is Admin
            // 'allow group <group name> to use secret-family in compartment < of your secret>'
            provider = new ConfigFileAuthenticationDetailsProvider("~/.oci/config", "nonAdmin");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    secretsClient = new SecretsClient(provider);
    secretsClient.setRegion(Region.US_ASHBURN_1);
 
    System.out.println("Created client for secrets retrieval "+ secretsClient);
    return secretsClient;
}

```




