package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductsSteps extends ProductsPage {

    LoginPage loginPage;

    @Given("User is on the Products page")
    public void userIsOnProductsPage() {
        LoginPage.homePageVisible();
    }

    @When("User adds {string} to the basket")
    public void userAddsProductToBasket(String productName) throws InterruptedException {
        addToCartAll(productName);
    }

    @Then("The basket count should be {int}")
    public void theBasketCountShouldBe(int expectedBasketCount) {
        checkBasketCount(expectedBasketCount);
    }

    @When("User removes {string} from the basket")
    public void userRemovesFromTheBasket(String product) {
        removeFromBasket(product);
    }

    @Then("The Remove button for {string} should change back to {string}")
    public void theButtonForShouldChangeBackTo(String product, String expectedText) {
        checkButtonNameChange(product, expectedText);
    }


    @When("User clicks on {string}")
    public void userClicksOnSortByName(String selectOption) {
        selectSortingOption(selectOption);
    }

    @Then("Products should be sorted {string}")
    public void productsShouldBeSortedByName(String ascending) {
        productListByName(ascending);
    }

    @Then("Products should be sorted starting by {string} price")
    public void productsShouldBeSortedStartingByPrice(String price) {
        productListByPrice(price);
    }

    @And("User opens {string} detailed page")
    public void userOpensDetailedPage(String product) {
        openProduct(product);
    }
}
