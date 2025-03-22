package stepDefinitions;

import config.DriverManager;
import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.LogoutPage;

import java.time.Duration;

import static config.DriverManager.driver;

public class LogoutSteps {
    private LoginPage loginPage = new LoginPage();
    private LogoutPage logoutPage = new LogoutPage();

    // Credentials
    String username = "bod@example.com";
    String password = "10203040";

    @Given("The User is logged in")
    public void the_user_is_logged_in() {
        DriverManager.getDriver();

        loginPage.clickMenuInHomepage();
        loginPage.clickSubmenuLogin();
        loginPage.inputUsernameField(username);
        loginPage.inputPasswordField(password);
        loginPage.clickLoginButton();
    }
    @When("The User click the menu")
    public void the_user_click_the_menu() {
        loginPage.clickMenuInHomepage();
    }
    @And("The User click the logout submenu")
    public void the_user_click_the_logout_submenu() {
        logoutPage.clickSubmenuLogout();
        logoutPage.verifyAlertConfirmationLogout();
        logoutPage.verifyMessageAlertConfirmatioLogout();
    }
    @And("The User click logout button")
    public void the_user_click_logout_button() {
        logoutPage.clickLogoutButton();
    }
    @And("The User click cancel button")
    public void the_user_click_cancel_button() {
        logoutPage.clickCancelButton();
    }
    @Then("The User is successfully logged out")
    public void the_user_is_successfully_logged_out() {
        loginPage.clickMenuInHomepage();

        WebElement verifyLoginSubmenuAppear = driver.findElement(AppiumBy.accessibilityId("Login Menu Item"));
        Assert.assertTrue("Logout Submenu not Appear", verifyLoginSubmenuAppear.isDisplayed());
    }
    @Then("The User is successfully cancel logged out")
    public void the_user_is_successfully_cancel_logged_out() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // ensure the alert not appear again
        boolean isAlertGone = wait.until(ExpectedConditions.invisibilityOfElementLocated(
                AppiumBy.id("com.saucelabs.mydemoapp.android:id/alertTitle")
        ));

        Assert.assertTrue("Failed Closing Alert Logout", isAlertGone);
    }
}