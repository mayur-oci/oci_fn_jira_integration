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

        testing.givenEvent().withBody(getEventString()).enqueue();

        testing.thenRun(OciEventProcessor.class, "handleRequest");

        FnResult result = testing.getOnlyResult();
        System.out.println("In Junit Test: Result from function call: " + result.getBodyAsString());
        assertTrue(result.isSuccess());
    }

    private String getEventString(){
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

}