package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BuyProductPage;
import pages.LoginPage;

public class BuyProductSteps {
    private BuyProductPage buyProductPage = new BuyProductPage();

    @When("The User choose a product")
    public void the_user_choose_a_product() {
        buyProductPage.setChooseProduct();
    }
    @And("The User add item")
    public void the_user_add_item() {
        buyProductPage.setAddItem();
    }
    @And("The User click add to cart button")
    public void the_user_click_add_to_cart_button() {
        buyProductPage.clickAddToCartButton();
    }
    @And("The User click cart")
    public void the_user_click_cart() {
        buyProductPage.clickCartButton();
        buyProductPage.verifyTextMyCart();
        buyProductPage.verifyProductName();
        buyProductPage.verifyProductPrice();
        buyProductPage.checkRemoteItemButton();
    }
    @And("The User click remove item")
    public void the_user_click_remove_item() {
        buyProductPage.clickRemoteItemButton();
    }
    @And("The User click proceed to checkout")
    public void the_user_click_proceed_to_checkout() {
        buyProductPage.verifyTotalItem();
        buyProductPage.verifyTotalPrice();
        buyProductPage.clickCheckoutButton();
    }
    @Then("The User will be redirect to checkout page")
    public void the_user_will_be_redirect_to_checkout_page() {
        buyProductPage.verifyCheckoutPage();
    }
    @Then("The User will be redirect to login page")
    public void the_user_will_be_redirect_to_login_page() {
        buyProductPage.verifyLoginPage();
    }
    @Then("Item will be deleted")
    public void item_will_be_deleted() {
        buyProductPage.verifyTextNoItems();
    }
}