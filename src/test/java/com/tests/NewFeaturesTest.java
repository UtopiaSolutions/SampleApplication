package com.tests;

import org.testng.annotations.Test;
import test.BaseUITest;


public class NewFeaturesTest extends BaseUITest {

    @Test
    public void featureTest(){
        System.out.println("<------------------------------------------->");
        System.out.println();
        System.out.println("CORE PROPERTIES:");
        properties.getCoreConfigs().forEach((key, value) -> System.out.println(key + ":" + value));
        System.out.println();
        System.out.println("<------------------------------------------->");
        System.out.println();
        System.out.println("CLIENT PROPERTIES:");
        properties.getClientConfigs().forEach((key, value) -> System.out.println(key + ":" + value));
        System.out.println();
        System.out.println("<------------------------------------------->");
        System.out.println();
        System.out.println("METADATA-LOCATION");
        System.out.println(properties.getConfigValue("metadata-location"));
        System.out.println();
        System.out.println("<------------------------------------------->");

    }
}
