package pages;

import config.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    //Constructor
    public LogoutPage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    //Locator
    @FindBy(xpath = "//android.widget.TextView[@content-desc='Logout Menu Item']")
    private WebElement submenuLogout;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/alertTitle")
    private WebElement alertConfirmationLogout;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='android:id/message']")
    private WebElement messageAlertConfirmatioLogout;

    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    private WebElement logoutButton;

    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button2']")
    private WebElement cancelButton;

    // Helper Method for Waiting Element
    private WebElement waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickSubmenuLogout() {
        waitForElementToBeVisible(submenuLogout).click();
    }

    public void verifyAlertConfirmationLogout() {
        waitForElementToBeVisible(alertConfirmationLogout).isDisplayed();
    }

    public void verifyMessageAlertConfirmatioLogout() {
        waitForElementToBeVisible(messageAlertConfirmatioLogout).isDisplayed();
    }
    public void clickLogoutButton() {
        waitForElementToBeVisible(logoutButton).click();
    }

    public void clickCancelButton() {
        waitForElementToBeVisible(cancelButton).click();
    }
}