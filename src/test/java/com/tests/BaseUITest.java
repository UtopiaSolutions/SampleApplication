package com.tests;

import com.usf.TestLogHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseUITest {

    private final Logger log = LoggerFactory.getLogger(BaseUITest.class);

    @BeforeMethod
    public void beforeMethod(ITestResult result) throws Exception {
        TestLogHelper.startTestLogging(result.getMethod().getMethodName());
        log.info("Execution of test {} has started....", result.getMethod().getMethodName());
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) {
        try {
            if (!testResult.isSuccess()) {
                log.error("Test has failed",testResult.getThrowable());
            }

            log.info("Test {} has passed", testResult.getMethod().getMethodName());
        } finally {
            TestLogHelper.stopTestLogging();
        }
    }
}
