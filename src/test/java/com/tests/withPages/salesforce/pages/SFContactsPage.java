package com.tests.withPages.salesforce.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class SFContactsPage {


    @FindBy(xpath = "//div[@class='utility-bar']/div/div/a")
    private SelenideElement loginLink;



    public SFLoginPage moveToLoginPage(){
            loginLink.click();
        return page(SFLoginPage.class);
    }

}
