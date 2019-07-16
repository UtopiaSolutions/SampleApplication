package com.tests;

import com.usf.metadata.Metadata;
import com.usf.utils.parsers.Parser;
import com.usf.utils.reporting.ExtentTestManager;
import org.testng.annotations.Test;
import test.BaseUITest;

import java.util.Iterator;
import java.util.Map;

import static com.usf.utils.ConfigurationReader.getConfigValue;


public class NewFeaturesTest extends BaseUITest {

    @Test
    public void featureTest(){
        ExtentTestManager.startTest("Test2", "TestToo");
        Parser parser = new Parser(getConfigValue("metadata-path"), "metadata.xml");

        parser.parseFile();

        System.out.println(Metadata.getInstance().getValue("username"));


        Iterator it = Metadata.getInstance().getMetadata().entrySet().iterator();
        System.out.println();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.print("METADATA ~~>\t" + pair.getKey() + ": " + pair.getValue() + "\n");
            it.remove(); // avoids a ConcurrentModificationException
        }
        System.out.println();
    }
}
