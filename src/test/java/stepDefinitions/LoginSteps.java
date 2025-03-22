package stepDefinitions;

import config.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import pages.LoginPage;

import static config.DriverManager.driver;

public class LoginSteps {
    private LoginPage loginPage = new LoginPage();

    @Given("The User has opened the app")
    public void the_user_has_opened_the_app() {
        DriverManager.getDriver();
    }
    @And("The User click menu")
    public void the_user_click_menu() {
        loginPage.clickMenuInHomepage();
    }
    @And("The User click login submenu")
    public void the_user_click_login_submenu() {
        loginPage.clickSubmenuLogin();
    }
    @When("The User input username {string}")
    public void the_user_input_username(String username) {
        loginPage.inputUsernameField(username);
    }
    @And("The User input password {string}")
    public void the_user_input_password(String password) {
        loginPage.inputPasswordField(password);
    }
    @And("The User click login button")
    public void the_user_click_login_button() {
        loginPage.clickLoginButton();
    }
    @Then("{string}")
    public void user_melihat_halaman_utama(String expected) {
        switch (expected) {
            case "User Successfully Logs In":
                WebElement clickHomepage = driver.findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/menuIV"));
                clickHomepage.click();

                WebElement verifyLogoutSubmenuAppear = driver.findElement(AppiumBy.accessibilityId("Logout Menu Item"));
                Assert.assertTrue("Login Submenu not Appear", verifyLogoutSubmenuAppear.isDisplayed());

                break;
            case "User Failed to Login": {
                WebElement errorMessage = driver.findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/passwordErrorTV"));

                String actualErrorText = errorMessage.getText();
                String expectedErrorText = "Sorry this user has been locked out.";
                Assert.assertEquals("Message Error not Match", expectedErrorText, actualErrorText);

                System.out.println("Expected Message: " + expectedErrorText);
                System.out.println("Actual Message: " + actualErrorText);

                break;
            }
            case "Message Username is Required Appear": {
                WebElement errorMessageUsernameIsRequired = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/nameErrorTV']"));

                String actualErrorText = errorMessageUsernameIsRequired.getText();
                String expectedErrorText = "Username is required";
                Assert.assertEquals("Message Error not Match", expectedErrorText, actualErrorText);

                System.out.println("Expected Message: " + expectedErrorText);
                System.out.println("Actual Message: " + actualErrorText);

                break;
            }
            case "Message Enter Password Appear": {
                WebElement errorMessageEnterPassword = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/passwordErrorTV']"));

                String actualErrorText = errorMessageEnterPassword.getText();
                String expectedErrorText = "Enter Password";
                Assert.assertEquals("Message Error not Match", expectedErrorText, actualErrorText);

                System.out.println("Expected Message: " + expectedErrorText);
                System.out.println("Actual Message: " + actualErrorText);
                break;
            }
        }
    }
}