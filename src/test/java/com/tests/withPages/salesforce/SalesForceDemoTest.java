package com.tests.withPages.salesforce;

import com.tests.withPages.salesforce.pages.SFCommon;
import com.tests.withPages.salesforce.pages.SFHomePage;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseUITest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SalesForceDemoTest extends BaseUITest {

    private final Logger log = LoggerFactory.getLogger(SalesForceDemoTest.class);

    @Test(dataProvider = "Authentication", description = "This test is used for demonstration of the Selenide framework.")
    public void salesForceDemoTest(String name, String password) {

        SFHomePage homePage = open("https://www.salesforce.com/", SFHomePage.class);

        homePage.moveToLoginPage()
                .loginWithUserNameAndPassword(name, password);



        SFCommon common = homePage.moveToCommonPage();
        common.clickContactsLink();

        $(By.xpath("//div[@title='New']")).click();
        Reporter.log("Clicked New Contact Button");

        $(By.xpath("//input[contains(@class, 'firstName')]")).setValue("Joe");
        $(By.xpath("//input[contains(@class, 'lastName')]")).setValue("AutoTest1");
        Reporter.log("Entered First Name Joe and Last Name AutoTest1");

        $(By.xpath("//button[@title='Save']")).click();
        Reporter.log("Clicked Save Contact Button");

        common.globalSearch("Joe AutoTest1");
        Reporter.log("Global Search return result: Joe AutoTest1");


        $(By.xpath("//div[2]/h1/div/div/span[1]"))
                .shouldHave(text("Joe AutoTest1"));
        Reporter.log("Contact Card Header contains Joe AutoTest1:"
                + $(By.xpath("//div[2]/h1/div/div/span[1]"))
                .shouldHave(text("Joe AutoTest1")));

    }

    @DataProvider(name = "Authentication")
    private Object[][] getCredentials() {
        return new Object[][] { { "lee.barnes@utopiasolutions.com", "UTopia##6512" } };
    }
}
