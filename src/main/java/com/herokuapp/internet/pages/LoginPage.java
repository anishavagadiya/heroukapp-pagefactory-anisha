package com.herokuapp.internet.pages;

import com.herokuapp.internet.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(name = "username")
    WebElement userNameField;
    @CacheLookup
    @FindBy(name = "password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(xpath = "//button/i[text() =' Login']")
    WebElement loginButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'example']/h2[contains(text(), 'Secure Area')]")
    WebElement secureAreaText;
    @CacheLookup
    @FindBy(xpath = "//div[1]//div[@class = 'flash error' and contains(text(),'Your username is invalid!')]")
    WebElement invalidUsernameMessage;
    @CacheLookup
    @FindBy(xpath = "//div[1]//div[@class = 'flash error' and contains(text(),'Your password is invalid!')]")
    WebElement invalidPasswordMessage;


    public void enterUserName(String userName) {
        Reporter.log("Enter UserName " + userName + " to username " + userNameField.toString());
        sendTextToElement(userNameField, userName);
    }

    public void enterPassword(String password) {
        Reporter.log("Enter password " + password + " to password field " + passwordField.toString());
        sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton() {
        Reporter.log("ClickOn Login Button");
        clickOnElement(loginButton);
    }

    public String getErrorMessage() {
        Reporter.log("Error Message Displayed");
        return getTextFromElement(secureAreaText);
    }

    public String getInvalidUsernameMessage() {
        Reporter.log("InValid Message Displayed");
        return getTextFromElement(invalidUsernameMessage);
    }

    public String getInvalidPasswordMessage() {
        Reporter.log("InValid Message Displayed");
        return getTextFromElement(invalidPasswordMessage);


    }


}
