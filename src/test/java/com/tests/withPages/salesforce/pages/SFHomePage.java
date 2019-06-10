package com.tests.withPages.salesforce.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class SFHomePage {


    @FindBy(xpath = "//div[@class='utility-bar']/div/div/a")
    private SelenideElement loginLink;



    public SFLoginPage moveToLoginPage(){
            loginLink.click();
        return page(SFLoginPage.class);
    }

    public SFCommon moveToCommonPage() {
        return page(SFCommon.class);
    }

    public SFNewContactPage moveToNewContactPage() {
        return page(SFNewContactPage.class);
    }

}
