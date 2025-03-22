package stepDefinitions;

import config.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ReviewProductPage;

public class ReviewProductSteps {
    private LoginPage loginPage = new LoginPage();
    private ReviewProductPage reviewProductPage = new ReviewProductPage();

    // Credentials
    String username = "bod@example.com";
    String password = "10203040";

    @Given("The user is logged in")
    public void the_user_is_logged_in() {
        DriverManager.getDriver();

        loginPage.clickMenuInHomepage();
        loginPage.clickSubmenuLogin();
        loginPage.inputUsernameField(username);
        loginPage.inputPasswordField(password);
        loginPage.clickLoginButton();
    }
    @Given("The user has opened the app")
    public void the_user_has_opened_the_app() {
        DriverManager.getDriver();
    }
    @When("The user click added review")
    public void the_user_click_added_review() {
        reviewProductPage.addReview5Star();
    }
    @When("The user click reducing review")
    public void the_user_click_reducing_review() {
        reviewProductPage.addReview1Star();
    }
    @Then("Review count will increase")
    public void review_count_will_increase() {
        reviewProductPage.verifyAlertReview();
        reviewProductPage.clickButtonContinue();
        reviewProductPage.setVerifyProductPage();
    }
    @Then("Review count will decrease")
    public void review_count_will_decrease() {
        reviewProductPage.verifyAlertReview();
        reviewProductPage.clickButtonContinue();
        reviewProductPage.setVerifyProductPage();
    }
}
