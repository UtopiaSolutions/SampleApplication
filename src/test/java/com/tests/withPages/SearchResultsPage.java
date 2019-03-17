package com.tests.withPages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.texts;

public class SearchResultsPage {

    private final Logger log = LoggerFactory.getLogger(SearchResultsPage.class);

    @FindBy(css = "#ires .g")
    private ElementsCollection results;

    public void checkResultsSize(int expectedSize) {

        results.shouldHave(sizeGreaterThan(expectedSize));
        log.info("Results size is greater than "+ expectedSize);
    }

    public void checkResults(String... expectedTexts) {
        results.shouldHave(texts(expectedTexts));
    }

    public ElementsCollection getResults() {
        return results;
    }
}
