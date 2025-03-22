package pages;

import config.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private AndroidDriver driver;
    private WebDriverWait  wait;

    //Constructor
    public LoginPage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    //Locator
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/menuIV")
    private WebElement menuInHomepage;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='Login Menu Item']")
    private WebElement submenuLogin;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
    private WebElement usernameField;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/passwordET")
    private WebElement passwordField;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/loginBtn")
    private  WebElement loginButton;

    // Helper Method for Waiting Element
    private WebElement waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickMenuInHomepage() {
        waitForElementToBeVisible(menuInHomepage).click();
    }

    public void clickSubmenuLogin() {
        waitForElementToBeVisible(submenuLogin).click();
    }

    public void inputUsernameField(String username) {
        waitForElementToBeVisible(usernameField).sendKeys(username);
    }

    public void inputPasswordField(String password) {
        waitForElementToBeVisible(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        waitForElementToBeVisible(loginButton).click();
    }
}
