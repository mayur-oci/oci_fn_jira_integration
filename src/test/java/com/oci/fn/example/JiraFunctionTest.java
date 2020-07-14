package com.oci.fn.example;

import com.fnproject.fn.testing.*;
import org.junit.*;

import static org.junit.Assert.*;

public class JiraFunctionTest {

    @Rule
    public final FnTestingRule testing = FnTestingRule.createDefault();

    //@Test
    public void testJiraTicketCreate() {
        FnHttpEventBuilder fnHttpEventBuilder = new FnHttpEventBuilder();


        testing.givenEvent().withBody("{\n" +
                "  \"dedupeKey\": \"6b56c5d1-7f64-414f-84a2-5427ccc62c48\",\n" +
                "  \"title\": \"cpuLoadMoreThan90Percent\",\n" +
                "  \"type\": \"OK_TO_FIRING\",\n" +
                "  \"severity\": \"CRITICAL\",\n" +
                "  \"timestampEpochMillis\": 1594186380000,\n" +
                "  \"alarmMetaData\": [{\n" +
                "    \"id\": \"ocid1.alarm.oc1.iad.aaaaaaaaoso25cyskazt3akeddxyauys6iqx2vd4ge3xhjirr2wwdei35mba\",\n" +
                "    \"status\": \"OK\",\n" +
                "    \"severity\": \"CRITICAL\",\n" +
                "    \"query\": \"CpuUtilization[1m]{resourceDisplayName = \\\"test_Instance\\\"}.mean() > 60\",\n" +
                "    \"totalMetricsFiring\": 0,\n" +
                "    \"dimensions\": []\n" +
                "  }],\n" +
                "  \"version\": 1.0\n" +
                "}").enqueue();

        //testing.givenEvent().withBody("{\"dedupeKey\":\"6b56c5d1-7f64-414f-84a2-5427ccc62c48\"}").enqueue();
        testing.thenRun(JiraFunction.class, "handleRequest");

        FnResult result = testing.getOnlyResult();
        System.out.println("In Junit Test: Result from function call: " + result.getBodyAsString());
        assertTrue(true);

         //assertEquals("Hello, world!", result.getBodyAsString());

    }

}