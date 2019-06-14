package com.tests.withPages.salesforce.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class SFCommon {


    @FindBy(xpath = "//a[@title='Contacts']")
    private SelenideElement contactsLink;

    @FindBy(xpath = "//div[contains(@class, 'uiInput')]//input")
    private SelenideElement globalSearch;

    public SFContactsPage clickContactsLink(){
        $(contactsLink).waitUntil(Condition.appear, 3000);

        contactsLink.sendKeys(Keys.ENTER);
        Reporter.log("Clicked Contacts Tab");
        return page(SFContactsPage.class);
    }

    public void globalSearch(String searchVal) {
        $(globalSearch).waitUntil(Condition.appear, 3000);

        globalSearch.setValue(searchVal).sendKeys(Keys.ENTER);

        $(By.linkText(searchVal)).waitUntil(Condition.appear, 3000);
        $(By.linkText(searchVal)).click();
        Reporter.log("Clicked " + searchVal);
    }
}
