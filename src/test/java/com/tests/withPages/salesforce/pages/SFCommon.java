package com.tests.withPages.salesforce.pages;

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
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        contactsLink.sendKeys(Keys.ENTER);
        Reporter.log("Clicked Contacts Tab");
        return page(SFContactsPage.class);
    }

    public void globalSearch(String searchVal) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        globalSearch.setValue(searchVal).sendKeys(Keys.ENTER);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        $(By.linkText(searchVal)).click();
    }
}
