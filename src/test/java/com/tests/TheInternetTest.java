package com.tests;

import com.tests.withPages.theInternet.HomePage;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseUITest;

import static com.codeborne.selenide.Condition.disappears;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TheInternetTest extends BaseUITest {

    private final Logger log = LoggerFactory.getLogger(TheInternetTest.class);

    @Test(dataProvider = "Authentication", description = "This is not a valid test. This is used for demonstration of the Selenide framework.", groups = "Hemant")
    public void invalidAuthenticationWithRandomData(String name, String password) {

        HomePage homePage = open("http://the-internet.herokuapp.com", HomePage.class);

        homePage.moveToFormAuthenticationPage()
                .loginWithUserNameAndPassword(name, password)
                .getSuccessMessage()
                .shouldHave(text("Your username is invalid!")); //Sample of Declarative Assertion using Selenide (USF-7)
    }

    @DataProvider(name = "Authentication")
    private Object[][] getCredentials() {
        return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_1", "Test@123" }};
    }

    @Test
    public void testIfCorrectTextValueIsSelectedInDropdown() {

        HomePage homePage = open("http://the-internet.herokuapp.com", HomePage.class);

        homePage
                .moveToDropdownPage()
                .selectOption("Option 2")
                .getDropdown()
                .shouldHave(text("Option 2"));
    }

    @Test
    public void testIfUserCanUploadFiles() {

        HomePage homePage = open("http://the-internet.herokuapp.com", HomePage.class);

        homePage
                .moveToFileUploadPage()
                .uploadFile("SampleFileToUpload.txt")
                .checkFileUploaded();

    }

    @Test
    public void testTheDynamicLocators() {

        open("http://the-internet.herokuapp.com");
        $(By.linkText("Dynamic Loading")).click();
        $("div.example a:nth-of-type(1)").click();
        $("#start>button").click();

        $("#loading").waitUntil(disappears, 10000);

        $("div#finish>h4").shouldHave(text("Hello World!"));
    }


    @Test
    public void validAuthentication() {
        String url = "http://the-internet.herokuapp.com";
        String userName = "tomsmith";
        String password = "SuperSecretPassword!";
        String successMessage = "You logged into a secure area!";
        open(url);
        log.info("Navigating to the url {}", url);

        $(By.linkText("Form Authentication")).click();
        log.info("Clicking on Form Authentication");

        $("#username").setValue(userName);
        log.info("Setting username as {}", userName);

        $("#password").setValue(password);
        log.info("Setting password as {}", password);


        $(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        log.info("Clicked on SignIn");

        $("#flash").shouldHave(text(successMessage));
        log.info("Success message {} is displayed", successMessage);
    }


    @Test
    public void howSelenideWorks2() {


        open("http://the-internet.herokuapp.com");
        $(By.linkText("Form Authentication")).click();
        $("#username").setValue("tomsmith");
        $("#password").setValue("SuperSecretPassword!");
        $(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();

        $("#flash").shouldHave(text("You logged into a secure area!"));


    }


}
