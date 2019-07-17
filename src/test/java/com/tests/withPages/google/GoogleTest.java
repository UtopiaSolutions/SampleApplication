package com.tests.withPages.google;

import com.tests.withPages.google.pages.GooglePage;
import com.tests.withPages.google.pages.SearchResultsPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import test.BaseUITest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;


public class GoogleTest extends BaseUITest {

    private final Logger log = LoggerFactory.getLogger(GoogleTest.class);

    @Test(testName = "Test 1", description = "User Search")
    public void userCanSearch() {
        String searchKeyword = "selenide";

        GooglePage page = open("https://google.com/ncr", GooglePage.class);
        log.info("Navigating to https://google.com/ncr");

        SearchResultsPage results = page.searchFor(searchKeyword);

        results.checkResultsSize(1);
        results.getResults().get(0).shouldHave(text("Selenide: concise UI fakeUsers in Java"));
        log.info("The search text was {} exists in Selenide: concise UI fakeUsers in Java",searchKeyword);
    }
}