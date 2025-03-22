package pages;

import config.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuyProductPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    //Constructor
    public BuyProductPage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    //Locator
    @FindBy(xpath = "(//android.widget.ImageView[@content-desc='Product Image'])[1]")
    private WebElement chooseProduct;

    public void setChooseProduct() {
        waitForElementToBeVisible(chooseProduct).click();
    }

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/plusIV")
    private WebElement addItem;

    public void setAddItem() {
        waitForElementToBeVisible(addItem).click();
    }

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
    private WebElement addToCartButton;

    public void clickAddToCartButton() {
        waitForElementToBeVisible(addToCartButton).click();
    }

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/cartIV")
    private WebElement cartButton;

    public void clickCartButton() {
        waitForElementToBeVisible(cartButton).click();
    }

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private WebElement textMyCart;

    public void verifyTextMyCart() {
        waitForElementToBeVisible(textMyCart).isDisplayed();
    }

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/titleTV")
    private WebElement productName;

    public void verifyProductName() {
        waitForElementToBeVisible(productName).isDisplayed();
    }

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/priceTV")
    private WebElement productPrice;

    public void verifyProductPrice() {
        waitForElementToBeVisible(productPrice).isDisplayed();
    }

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/removeBt")
    private WebElement remoteItemButton;

    public void checkRemoteItemButton() {
        waitForElementToBeVisible(remoteItemButton).isEnabled();
    }

    public void clickRemoteItemButton() {
        waitForElementToBeVisible(remoteItemButton).click();
    }

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/itemsTV")
    private WebElement totalItem;

    public void verifyTotalItem() {
        waitForElementToBeVisible(totalItem).isDisplayed();
    }

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/totalPriceTV")
    private WebElement totalPrice;

    public void verifyTotalPrice() {
        waitForElementToBeVisible(totalPrice).isDisplayed();
    }

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
    private WebElement checkoutButton;

    public void clickCheckoutButton() {
        waitForElementToBeVisible(checkoutButton).click();
    }

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/checkoutTitleTV")
    private WebElement checkoutPage;

    public void verifyCheckoutPage() {
        waitForElementToBeVisible(checkoutPage).isDisplayed();
    }

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/loginTV")
    private WebElement loginPage;

    public void verifyLoginPage() {
        waitForElementToBeVisible(loginPage).isDisplayed();
    }

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/noItemTitleTV")
    private WebElement textNoItems;

    public void verifyTextNoItems() {
        waitForElementToBeVisible(textNoItems).isDisplayed();
    }

    // Helper Method for Waiting Element
    private WebElement waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }




}