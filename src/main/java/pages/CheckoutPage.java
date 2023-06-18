package pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class CheckoutPage extends BasePage {

    private static final String cart = "shopping_cart_badge";
    private static final String checkoutButton = "checkout";
    private static final String continueButton = "continue";
    private static final String firstNameInput = "first-name";
    private static final String lastNameInput = "last-name";
    private static final String postalCodeInput = "postal-code";
    private static final String productsNameOnBasket = "inventory_item_name";
    private static final String paymentInfo = "summary_value_label";
    private static final String itemTotalId = "summary_subtotal_label";
    private static final String taxId = "summary_tax_label";
    private static final String totalId = "summary_total_label";
    private static final String finishButton = "finish";
    private static final String thankYou = "complete-header";


    public void openShoppingCart() {
        WebElement cartIcon = driver.findElement(By.className(cart));
        cartIcon.click();
    }

    public void clickCheckoutButton() {
        WebElement checkout = driver.findElement(By.id(checkoutButton));
        checkout.click();
    }

    public void fillCheckoutInformation(String firstName, String lastName, String postalCode) {
        WebElement firstNameField = driver.findElement(By.id(firstNameInput));
        WebElement lastNameField = driver.findElement(By.id(lastNameInput));
        WebElement postalCodeField = driver.findElement(By.id(postalCodeInput));

        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        postalCodeField.sendKeys(postalCode);

        WebElement continueBtn = driver.findElement(By.id(continueButton));
        continueBtn.click();
    }

    public void verifyProductOnBasket(String productNamesInput) throws InterruptedException {
        List<WebElement> productElements = driver.findElements(By.className(productsNameOnBasket));
        List<String> productNames = productElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        String[] inputProducts = productNamesInput.split(", ");
        wait(1000);
        for (String inputProduct : inputProducts) {
            boolean productFound = false;

            for (String productName : productNames) {
                if (productName.contains(inputProduct)) {
                    productFound = true;
                    break;
                }
            }
            Assert.assertTrue("Product not found: " + inputProduct, productFound);
        }
    }

    public void verifyPaymentInfo(String expectedPaymentInfo) {
        List<WebElement> elements = driver.findElements(By.className(paymentInfo));
        String actualPaymentInfo = elements.get(0).getText(); // Get the first element
        Assert.assertEquals(expectedPaymentInfo, actualPaymentInfo);
    }

    public void verifyShippingInfo(String expectedShippingInfo) {
        List<WebElement> elements = driver.findElements(By.className(paymentInfo));
        String actualPaymentInfo = elements.get(1).getText();
        Assert.assertEquals(expectedShippingInfo, actualPaymentInfo);
    }

    public void verifyTotalPrice(String expectedItemTotal, String expectedTax, String expectedTotal) {
        WebElement element = driver.findElement(By.className(itemTotalId));
        String actualItemTotal = element.getText();
        WebElement element2 = driver.findElement(By.className(taxId));
        String actualTax = element2.getText();
        WebElement element3 = driver.findElement(By.className(totalId));
        String actualTotal = element3.getText();
        Assert.assertEquals(expectedItemTotal, actualItemTotal);
        Assert.assertEquals(expectedTax, actualTax);
        Assert.assertEquals(expectedTotal, actualTotal);
    }
     public void finishPayment(){
         WebElement payment = driver.findElement(By.id(finishButton));
         payment.click();
     }

     public void verifyThankYouPage(String expectedMessage){
         WebElement element = driver.findElement(By.className(thankYou));
         String thankYouMessage = element.getText();
         Assert.assertEquals(expectedMessage, thankYouMessage);
     }
}


