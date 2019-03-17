package com.tests.withPages;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

import static com.codeborne.selenide.Selenide.page;

public class GooglePage {
    private final Logger log = LoggerFactory.getLogger(GooglePage.class);

    private SelenideElement q;

    public SearchResultsPage searchFor(String text) {
        q.val(text).pressEnter();
        log.info("Search for the keyword {}",text);
        return page(SearchResultsPage.class);
    }
}
