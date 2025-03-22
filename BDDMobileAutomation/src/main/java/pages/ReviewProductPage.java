package pages;

import config.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReviewProductPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public ReviewProductPage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    //Locator
    @FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.saucelabs.mydemoapp.android:id/start5IV'])[1]")
    private WebElement review5Star;

    @FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.saucelabs.mydemoapp.android:id/start1IV'])[1]")
    private WebElement review1Star;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/sortTV")
    private WebElement alertReview;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/closeBt")
    private WebElement buttonContinue;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private WebElement verifyProductPage;

    // Helper Method for Waiting Element
    private WebElement waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void addReview5Star() {
        waitForElementToBeVisible(review5Star).click();
    }
    public void addReview1Star() {
        waitForElementToBeVisible(review1Star).click();
    }
    public void verifyAlertReview() {
        waitForElementToBeVisible(alertReview).isDisplayed();
    }
    public void clickButtonContinue() {
        waitForElementToBeVisible(buttonContinue).click();
    }
    public void setVerifyProductPage() {
        waitForElementToBeVisible(verifyProductPage).isDisplayed();
    }


}