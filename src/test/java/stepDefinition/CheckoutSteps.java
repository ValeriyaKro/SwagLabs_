package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CheckoutPage;

public class CheckoutSteps extends CheckoutPage {


    @And("User is on basket page and proceeds with checkout")
    public void userIsOnBasketPageAndProceedsWithCheckout() {
        openShoppingCart();
        clickCheckoutButton();
    }

    @Then("the user enters {string}, {string} and {string}")
    public void theUserEntersAnd(String firstName, String lastName, String postalCode) {
        fillCheckoutInformation(firstName, lastName, postalCode);
    }

    @Then("User verifies {string} on the payment page")
    public void userVerifiesTheProductsInThePaymentPage(String product) throws InterruptedException {
        verifyProductOnBasket(product);
    }


    @Then("User verifies payment information as {string}")
    public void userVerifiesPaymentInformationAs(String expectedPaymentInfo) {
        verifyPaymentInfo(expectedPaymentInfo);
    }

    @Then("User verifies shipping information as {string}")
    public void userVerifiesShippingInformationAs(String expectedShippingInfo) {
        verifyShippingInfo(expectedShippingInfo);
    }

    @Then("User verifies price total as {string}, {string}, {string}")
    public void userVerifiesPriceTotalAs(String expectedItemTotal, String expectedTax, String expectedTotal) {
        verifyTotalPrice(expectedItemTotal, expectedTax, expectedTotal);
    }


    @Then("after payment {string} message is displayed")
    public void afterPaymentMessageIsDisplayed(String thankYouMessage) {
        finishPayment();
        verifyThankYouPage(thankYouMessage);
    }
}
