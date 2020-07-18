package com.oci.fn.demo;

import com.fnproject.fn.testing.FnHttpEventBuilder;
import com.fnproject.fn.testing.FnResult;
import com.fnproject.fn.testing.FnTestingRule;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FunctionOciEventToJsonTickeTest {

    @Rule
    public final FnTestingRule testing = FnTestingRule.createDefault();

    @Test
    public void testJiraTicketCreate() {
        FnHttpEventBuilder fnHttpEventBuilder = new FnHttpEventBuilder();

        testing.givenEvent().withBody(getObjCreatedEventString()).enqueue();

        testing.thenRun(OciEventProcessor.class, "handleRequest");

        FnResult result = testing.getOnlyResult();
        System.out.println("In Junit Test: Result from function call: " + result.getBodyAsString());
        assertTrue(result.isSuccess());
    }

    private String getDbReminderEventString(){
       return
       "{\n" +
               "\t\"cloudEventsVersion\": \"0.1\",\n" +
               "\t\"eventId\": \"60600c06-d6a7-4e85-b56a-1de3e6042f57\",\n" +
               "\t\"eventType\": \"com.oraclecloud.databaseservice.autonomous.container.database.maintenance.reminder\",\n" +
               "\t\"source\": \"databaseservice\",\n" +
               "\t\"eventTypeVersion\": \"1.0\",\n" +
               "\t\"eventTime\": \"2019-06-27T21:16:04.000Z\",\n" +
               "\t\"contentType\": \"application/json\",\n" +
               "\t\"extensions\": {\n" +
               "\t\t\"compartmentId\": \"ocid1.compartment.oc1.......unique_id\"\n" +
               "\t},\n" +
               "\t\"data\": {\n" +
               "\t\t\"compartmentId\": \"ocid1.compartment.oc1.......unique_id\",\n" +
               "\t\t\"compartmentName\": \"example_name\",\n" +
               "\t\t\"resourceName\": \"my_container_database\",\n" +
               "\t\t\"resourceId\": \"AutonomousPodBackup-.....unique_id\",\n" +
               "\t\t\"availabilityDomain\": \"all\",\n" +
               "\t\t\"freeFormTags\": {\n" +
               "\t\t\t\"Department\": \"Finance\"\n" +
               "\t\t},\n" +
               "\t\t\"definedTags\": {\n" +
               "\t\t\t\"Operations\": {\n" +
               "\t\t\t\t\"CostCenter\": \"42\"\n" +
               "\t\t\t}\n" +
               "\t\t},\n" +
               "\t\t\"additionalDetails\": {\n" +
               "\t\t\t\"lifecycleState\": \"ACTIVE\",\n" +
               "\t\t\t\"timeCreated\": \"2019-06-27T21:15:59.000Z\",\n" +
               "\t\t\t\"timeUpdated\": \"2019-06-27T21:16:04.389Z\",\n" +
               "\t\t\t\"dbUniqueName\": \"dwrrdtsr_phx289\",\n" +
               "\t\t\t\"dbHomeId\": \"ocid1.autonomouspodhome.oc1.phx......unique_id\",\n" +
               "\t\t\t\"dbName\": \"dwrrdtsr\"\n" +
               "\t\t}\n" +
               "\t}\n" +
               "}" ;
    }


    private String getObjCreatedEventString() {
        return "{\n" +
                "  \"eventType\" : \"com.oraclecloud.objectstorage.createobject\",\n" +
                "  \"cloudEventsVersion\" : \"0.1\",\n" +
                "  \"eventTypeVersion\" : \"2.0\",\n" +
                "  \"source\" : \"ObjectStorage\",\n" +
                "  \"eventTime\" : \"2020-07-18T02:21:19Z\",\n" +
                "  \"contentType\" : \"application/json\",\n" +
                "  \"data\" : {\n" +
                "    \"compartmentId\" : \"ocid1.compartment.oc1..aaaaaaaa2z4wup7a4enznwxi3mkk55cperdk3fcotagepjnan5utdb3tvakq\",\n" +
                "    \"compartmentName\" : \"mayursandbox\",\n" +
                "    \"resourceName\" : \"sddslave_qs_org.csv\",\n" +
                "    \"resourceId\" : \"/n/intrandallbarnes/b/demoBucket/o/sddslave_qs_org.csv\",\n" +
                "    \"availabilityDomain\" : \"IAD-AD-2\",\n" +
                "    \"additionalDetails\" : {\n" +
                "      \"bucketName\" : \"demoBucket\",\n" +
                "      \"versionId\" : \"bb1a1623-57f7-495d-afdd-d25d5aff7f09\",\n" +
                "      \"archivalState\" : \"Available\",\n" +
                "      \"namespace\" : \"intrandallbarnes\",\n" +
                "      \"bucketId\" : \"ocid1.bucket.oc1.iad.aaaaaaaaru7ge55pubirhhe3urvb65c7dhxexnbhljgm3h6cp7owk7bx6h7a\",\n" +
                "      \"eTag\" : \"2d15a51e-0595-4b32-9dc6-f74454879401\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"eventID\" : \"be1c1a93-8856-328e-0527-d2e0375f49e2\",\n" +
                "  \"extensions\" : {\n" +
                "    \"compartmentId\" : \"ocid1.compartment.oc1..aaaaaaaa2z4wup7a4enznwxi3mkk55cperdk3fcotagepjnan5utdb3tvakq\"\n" +
                "  }\n" +
                "}";
    }

    }