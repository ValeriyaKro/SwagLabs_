package stepDefinition;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;


public class LoginSteps extends LoginPage {


    @Given("User is on the login page")
    public void userIsOnLoginPage() throws InterruptedException {
        pageUrl();
        loginPageVisible();
    }

    @When("User enters {string} and password")
    public void userEntersUsernameAndPassword(String username) {
        usernameField(username);
        passwordField();
    }

    @When("User enters username and password")
    public void userEntersUsernameAndPassword() {
        loggedInUser();

    }

    @When("User clicks on the login button")
    public void userClicksOnLoginButton() {
        loginButtonClick();
    }

    @Then("User should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {
        homePageVisible();
        closeBrowser();
    }

    @Given("User is logged in")
    public void userIsLoggedIn() throws InterruptedException {
        userIsOnLoginPage();
        loggedInUser();
    }

    @When("User clicks on the logout button")
    public void userClicksOnLogoutButton() throws InterruptedException {
        logout();
    }

    @Then("User should be logged out successfully")
    public void userShouldBeLoggedOutSuccessfully() throws InterruptedException {
       loginPageVisible();
    }


    @Then("User is successfully logged in")
    public void userIsSuccessfullyLoggedIn() {
        homePageVisible();
    }
}
