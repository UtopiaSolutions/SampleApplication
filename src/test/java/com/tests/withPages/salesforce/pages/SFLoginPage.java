package com.tests.withPages.salesforce.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import static com.codeborne.selenide.Selenide.page;

public class SFLoginPage {


    @FindBy(id = "username")
    private SelenideElement userNameText;

    @FindBy(id = "password")
    private SelenideElement passwordText;

    @FindBy(id="Login")
    private SelenideElement loginBtn;


    public SFLoginPage loginWithUserNameAndPassword(String username, String password) {

        userNameText.setValue(username);
        passwordText.setValue(password);
        loginBtn.click();

        Reporter.log("Entered username " + username + " and "  + " password  ********");
        return this;
    }

    public SFCommon moveToCommonPage() {
        Reporter.log("Redirecting to SalesForce Common Page.");
        return page(SFCommon.class);
    }


}
