package Stepdefnition;

import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.DataTable;
import io.cucumber.messages.types.TableRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Hooks;

import java.util.List;
import java.util.Map;

public class LoginstepDefnition {
    static LoginPage loginPage;
    WebDriver driver = null;

    public LoginstepDefnition() {
        this.driver = Hooks.driver;
        loginPage = PageFactory.initElements(Hooks.driver, LoginPage.class);
    }

    @Given("I am on the OpenWeather Signin Page")
    public void navigationtosigninpage() {
        loginPage = new LoginPage(driver);
        driver.get(loginPage.getPageUrl());
        loginPage.signInLink();

    }

    @Given("User enters Credentials to LogIn")
    public void enter_email_password() {
        loginPage.enterEmail("varshask1903@gmail.com");
        loginPage.enterPassword("Password#1");


    }


    @When("I click on the submit button")

    public void clicksubmitbutton() {
        loginPage.submitButton();
    }

    @Then("I should be logged in successfully")
    public void successfullogin() {
        String expectedSucessfullLoginText = "Signed in successfully.";

        Assert.assertEquals(loginPage.isLoginSuccess(), true);
        Assert.assertEquals(loginPage.loginSuccessMessage(), expectedSucessfullLoginText);

    }

    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @Then("I should see an error message indicating {string}")
    public void invalid_login_errormessage(String error_message) {
        Assert.assertEquals(loginPage.invalidLoginErrorMessage(), true);
    }

    @When("I click on the  \"Lost your password\"link")
    public void recoverpassword() {
        loginPage.recoverPassword();
    }

}





