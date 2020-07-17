package com.oci.fn.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.jira.cloud.pojo.*;
import com.oci.services.events.pojo.CloudEvent;
import com.oracle.bmc.Region;
import com.oracle.bmc.auth.BasicAuthenticationDetailsProvider;
import com.oracle.bmc.auth.ConfigFileAuthenticationDetailsProvider;
import com.oracle.bmc.auth.ResourcePrincipalAuthenticationDetailsProvider;
import com.oracle.bmc.secrets.SecretsClient;
import com.oracle.bmc.secrets.model.Base64SecretBundleContentDetails;
import com.oracle.bmc.secrets.requests.GetSecretBundleRequest;
import com.oracle.bmc.secrets.responses.GetSecretBundleResponse;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;


public class OciEventProcessor {
    ObjectMapper objectMapper = new ObjectMapper();
    private SecretsClient secretsClient = getSecretClient();

    public String handleRequest(CloudEvent cloudEvent) {

        // Json body of Cloud event from Oracle Notifications in serialized into cloudEvent object
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

    private String getJiraApiBody(CloudEvent cloudEvent) throws JsonProcessingException {
        Ticket jiraTicket = new Ticket();
        jiraTicket.setFields(new Fields());

        jiraTicket.getFields().setSummary("Event Occurred in OCI for : " + cloudEvent.getEventType());

        jiraTicket.getFields().setIssuetype(new Issuetype());
        jiraTicket.getFields().getIssuetype().setId("10002"); // Jira Task issue type is 1002

        jiraTicket.getFields().setProject(new Project());
        String jiraProjectId = System.getenv().get("JIRA_PROJECT_ID");
        System.out.println("jira project id from config is "+ jiraProjectId);

        jiraTicket.getFields().getProject().setKey(jiraProjectId); // should be your Jira Project key

        jiraTicket.getFields().setDescription(new Description());
        jiraTicket.getFields().getDescription().setContent(new ArrayList<Content>());
        jiraTicket.getFields().getDescription().setVersion(1);
        jiraTicket.getFields().getDescription().setType("doc");
        Content content = new Content();
        content.setType("paragraph");
        content.setContent(new ArrayList<Content_>());
        Content_ content_ = new Content_();

        String jsonCe = "Raw Event JSON is as follows \n" + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(cloudEvent);
        System.out.println(jsonCe);

        content_.setText(jsonCe);
        content_.setType("text");

        content.getContent().add(content_);
        jiraTicket.getFields().getDescription().getContent().add(content);

        String jsonBodyJira =  objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jiraTicket);
        System.out.println(jsonBodyJira);
        return jsonBodyJira;
    }

    private SecretsClient getSecretClient(){
        String version = System.getenv("OCI_RESOURCE_PRINCIPAL_VERSION");
        BasicAuthenticationDetailsProvider provider = null;
        if( version != null ) {
            provider = ResourcePrincipalAuthenticationDetailsProvider.builder().build();
        }
        else {
            try {
                // for local dev/testing
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

    private String getSecretForOcid(String secretOcid) {
        GetSecretBundleRequest getSecretBundleRequest = GetSecretBundleRequest
                .builder()
                .secretId(secretOcid)
                .stage(GetSecretBundleRequest.Stage.Current)
                .build();
        GetSecretBundleResponse getSecretBundleResponse = secretsClient
                .getSecretBundle(getSecretBundleRequest);
        Base64SecretBundleContentDetails base64SecretBundleContentDetails =
                (Base64SecretBundleContentDetails) getSecretBundleResponse.
                        getSecretBundle().getSecretBundleContent();
        String base64EncodedSecretString = base64SecretBundleContentDetails.getContent();

//        in case you need plain text of secret
//        System.out.println("Content from secret is " + base64EncodedSecretString);
//        byte[] decodedSecretByte = Base64.getDecoder().decode(base64EncodedSecretString);
//        String decodedSecretString =  new String(decodedSecretByte);

        return base64EncodedSecretString;
    }

    public static void main(String args[]) {


    }

}