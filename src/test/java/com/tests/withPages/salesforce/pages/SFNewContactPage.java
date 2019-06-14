package com.tests.withPages.salesforce.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import static com.codeborne.selenide.Selenide.$;

public class SFNewContactPage {

    @FindBy(xpath = "//input[contains(@class, 'firstName')]")
    private SelenideElement firstNameInput;

    @FindBy(xpath = "//input[contains(@class, 'lastName')]")
    private SelenideElement lastNameInput;

    @FindBy(xpath = "//label/span[text()='Phone']/../following-sibling::input")
    private SelenideElement phoneInput;

    @FindBy(xpath = "//label/span[text()='Email']/../following-sibling::input")
    private SelenideElement emailInput;

    @FindBy(xpath = "//label/span[text()='Mailing Street']/../following-sibling::textarea")
    private SelenideElement mailingStreetInput;

    @FindBy(xpath = "//label/span[text()='Mailing City']/../following-sibling::input")
    private SelenideElement mailingCityInput;

    @FindBy(xpath = "//label/span[text()='Mailing State/Province']/../following-sibling::input")
    private SelenideElement mailingStateInput;

    @FindBy(xpath = "//label/span[text()='Mailing Zip/Postal Code']/../following-sibling::input")
    private SelenideElement mailingZipInput;

    @FindBy(xpath = "//label/span[text()='Birthday']/../following-sibling::input")
    private SelenideElement dobInput;

    @FindBy(xpath = "//button[@title='Save']")
    private SelenideElement saveContactButton;


    private By newContactName = By.xpath("//div[2]/h1/div/div/span[1]");


    public SFNewContactPage createNewContact( String fName, String lName, String phone, String email,
            String street, String city, String state, String zip, String DOB ) {
        firstNameInput.setValue(fName);
        Reporter.log("Set First Name to: " + fName);
        lastNameInput.setValue(lName);
        Reporter.log("Set Last Name to: " + lName);
        phoneInput.setValue(phone);
        Reporter.log("Set Phone to: " + phone);
        emailInput.setValue(email);
        Reporter.log("Set Email to: " + email);
        mailingStreetInput.setValue(street);
        Reporter.log("Set Mailing Street to: " + street);
        mailingCityInput.setValue(city);
        Reporter.log("Set Mailing City to: " + city);
        mailingStateInput.setValue(state);
        Reporter.log("Set Mailing State to: " + state);
        mailingZipInput.setValue(zip);
        Reporter.log("Set Zip Code to: " + zip);
        dobInput.setValue(DOB);
        Reporter.log("Set Birthday to: " + DOB);
        return this;
    }

    public void saveContact() {
        $(saveContactButton).waitUntil(Condition.appear, 3000);
        saveContactButton.click();
        Reporter.log("New Contact Saved");
    }

    public By getNewContactName() {
        return newContactName;
    }

}
