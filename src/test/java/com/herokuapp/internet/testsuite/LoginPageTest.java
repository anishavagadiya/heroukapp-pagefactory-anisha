package com.herokuapp.internet.testsuite;

import com.herokuapp.internet.pages.LoginPage;
import com.herokuapp.internet.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void inIt(){
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void UserSholdLoginSuccessfullyWithValidCredentials() {
        loginPage.enterUserName("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        String expectedText = "Secure Area";
        Assert.assertEquals(loginPage.getErrorMessage(),expectedText,"Secure Area Text is not diaplayed");

    }
    @Test(groups = {"smoke", "regression"})
    public void verifyTheUsernameErrorMessage(){
        loginPage.enterUserName("tomsmith1");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();

        String expectedUsernameMessage = "Your username is invalid!\n"+"×";
        Assert.assertEquals(loginPage.getInvalidUsernameMessage(),expectedUsernameMessage,"Invalid username text is not displayed");
    }
    @Test(groups = "regression")
    public void verifyThePasswordErrorMessage(){
        loginPage.enterUserName("tomsmith");
        loginPage.enterPassword("SuperSecretPassword");
        loginPage.clickOnLoginButton();
        String expectedPasswordMessage = "Your password is invalid!\n"+"×";
        Assert.assertEquals(loginPage.getInvalidPasswordMessage(),expectedPasswordMessage,"Invalid password text is not displayed");
    }


}
