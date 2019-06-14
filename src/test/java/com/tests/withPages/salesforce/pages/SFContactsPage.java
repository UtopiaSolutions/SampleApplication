package com.tests.withPages.salesforce.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class SFContactsPage {

    @FindBy(xpath = "//div[@class='utility-bar']/div/div/a")
    private SelenideElement loginLink;

    @FindBy(xpath = "//div[@title='New']")
    private SelenideElement newContactButton;


    public SFLoginPage moveToLoginPage(){
        loginLink.click();
        return page(SFLoginPage.class);
    }

    public SFNewContactPage moveToNewContactPage() {
        return page(SFNewContactPage.class);
    }

    public void clickNewContactButton() {
        $(newContactButton).waitUntil(Condition.appear, 3000);
        newContactButton.click();
        Reporter.log("Clicked New Contact Button.");
    }

}
