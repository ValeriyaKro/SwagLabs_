package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {

    private static final String emailField = "user-name";
    private static final String passField = "password";
    private static final String loginbtn = "login-button";
    private static final String loginLogo = "login_logo";
    private static final String welcomeTitle = ".title";
    private static final String burgerMenu = "react-burger-menu-btn";
    private static final String logoutLink = "logout_sidebar_link";


    public static void usernameField(String username) {
        WebElement usernameField = driver.findElement(By.id(emailField));
        usernameField.sendKeys(username);
    }

    public static void username() {
        WebElement usernameField = driver.findElement(By.id(emailField));
        String user = getProperty("user");
        usernameField.sendKeys(user);
    }

    public static void passwordField() {
        WebElement passwordField = driver.findElement(By.id(passField));
        String password = getProperty("password");
        passwordField.sendKeys(password);
    }

    public static void loggedInUser() {
        WebElement usernameField = driver.findElement(By.id(emailField));
        String user = getProperty("user");
        usernameField.sendKeys(user);
        passwordField();
        loginButtonClick();
        homePageVisible();

    }

    public static void pageUrl() {
        String url = getProperty("login_url");
        driver.get(url);
    }

    public static void loginButtonClick() {
        WebElement loginButton = driver.findElement(By.id(loginbtn));
        loginButton.click();
    }

    public static void loginPageVisible() throws InterruptedException {
        wait(500);
        WebElement welcomeMessage = driver.findElement(By.className(loginLogo));
        Assert.assertTrue(welcomeMessage.getText().contains("Swag Labs"));
    }

    public static void homePageVisible() {
        WebElement welcomeMessage = driver.findElement(By.cssSelector(welcomeTitle));
        Assert.assertTrue(welcomeMessage.getText().contains("Products"));
    }

    public void logout() throws InterruptedException {
        driver.findElement(By.id(burgerMenu)).click();
        wait(3000);
        driver.findElement(By.id(logoutLink)).click();


    }
}
