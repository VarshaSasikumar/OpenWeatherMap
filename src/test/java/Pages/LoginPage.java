package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigFileReader;

public class LoginPage {

    WebDriver driver;

    ConfigFileReader configFileReader;
    @FindBy(linkText = "Sign in")
    WebElement signinlink;

    @FindBy(xpath = "//form[@action='/users/sign_in']//input[@id='user_email']")
    WebElement useremail;

    @FindBy(xpath = "//form[@action='/users/sign_in']//input[@id='user_password']")
    WebElement pwd;

    @FindBy(xpath = "//form[@action='/users/sign_in']//input[@type='submit']")
    WebElement submitbutton;

    @FindBy(linkText = "Click here to recover")
    WebElement forgotpassword;

    @FindBy(xpath = "//div[contains(text(),'Signed in successfully.')]")
    WebElement loginsuccessmessage;

    @FindBy(xpath = "//div[contains(text(),'Invalid Email or password.')]")
    WebElement loginerrormessage;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();
    }

    public String getPageUrl() {
        return configFileReader.getApplicationUrl();
    }
    public void signInLink() {
        signinlink.click();
    }
    public void enterEmail(String email) {
        useremail.sendKeys(email);
    }
    public void enterPassword(String password) {
        pwd.sendKeys(password);
    }
    public void submitButton() {
        submitbutton.click();
    }
    public boolean isLoginSuccess() {
        return loginsuccessmessage.isDisplayed();
    }
    public String loginSuccessMessage() {
        return loginsuccessmessage.getText();
    }

    public boolean invalidLoginErrorMessage() {
        return loginerrormessage.isDisplayed();
    }
    public void recoverPassword() {
        forgotpassword.click();
    }
}


