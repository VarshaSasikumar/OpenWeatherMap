package Stepdefnition;

import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.ConfigFileReader;
import utils.Hooks;

public class LoginstepDefnition {
    static LoginPage loginPage;
    static ConfigFileReader configFileReader;
    WebDriver driver = null;

    public LoginstepDefnition() {
        this.driver = Hooks.driver;
        loginPage = PageFactory.initElements(Hooks.driver, LoginPage.class);
        configFileReader = new ConfigFileReader();
    }

    @Given("I am on the OpenWeather Signin Page")
    public void navigationtosigninpage() {
        loginPage = new LoginPage(driver);
        driver.get(loginPage.getPageUrl());
        loginPage.signInLink();
    }

    @Given("User enters Credentials to LogIn")
    public void enter_email_password() {
        loginPage.enterUserName(configFileReader.getUserName());
        loginPage.enterPassword(configFileReader.getPassword());
    }

    @When("I click on the submit button")
    public void clicksubmitbutton() {
        loginPage.submitButton();
    }

    @Then("I should be logged in successfully")
    public void successfullogin() {
        String expectedSucessfullLoginText = "Signed in successfully.";
        Assert.assertTrue(loginPage.isLoginSuccess());
        Assert.assertEquals(loginPage.loginSuccessMessage(), expectedSucessfullLoginText);
    }

    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String email, String password) {
        loginPage.enterUserName(email);
        loginPage.enterPassword(password);
    }

    @Then("I should see an error message indicating {string}")
    public void invalid_login_errormessage(String error_message) {
        Assert.assertTrue(loginPage.invalidLoginErrorMessage());
    }

    @When("I click on the  \"Lost your password\"link")
    public void recoverpassword() {
        loginPage.recoverPassword();
    }

}





