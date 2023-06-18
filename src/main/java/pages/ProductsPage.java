package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;
import java.util.stream.Collectors;

public class ProductsPage extends BasePage {

    private static final String addBackpack = "add-to-cart-sauce-labs-backpack";
    private static final String backpackId = "item_4_title_link";
    private static final String bikeId = "item_0_title_link";
    private static final String tshirtId = "item_1_title_link";
    private static final String redTshirtId = "item_3_title_link";
    private static final String jacketId = "item_5_title_link";
    private static final String babyBodyId = "item_2_title_link";
    private static final String removeBackpack = "remove-sauce-labs-backpack";
    private static final String addBikeLight = "add-to-cart-sauce-labs-bike-light";
    private static final String removeBikeLight = "remove-sauce-labs-bike-light";
    private static final String addTShirt = "add-to-cart-sauce-labs-bolt-t-shirt";
    private static final String removeTShirt = "remove-sauce-labs-bolt-t-shirt";
    private static final String addJacket = "add-to-cart-sauce-labs-fleece-jacket";
    private static final String removeJacket = "remove-sauce-labs-fleece-jacket";
    private static final String addBody = "add-to-cart-sauce-labs-onesie";
    private static final String removeBody = "remove-sauce-labs-onesie";
    private static final String addRedTShirt = "add-to-cart-test.allthethings()-t-shirt-(red)";
    private static final String removeRedTShirt = "remove-test.allthethings()-t-shirt-(red)";
    private static final String dropdownOpen = "product_sort_container";
    private static final String productNames = "inventory_item_name";
    private static final String productPrice = "inventory_item_price";


    public void checkBasketCount(int expectedBasketCount) {
        int actualBasketCount;
        List<WebElement> badges = driver.findElements(By.cssSelector(".shopping_cart_badge"));
        if (!badges.isEmpty()) {
            String countText = badges.get(0).getText();
            actualBasketCount = Integer.parseInt(countText);
        } else {
            actualBasketCount = 0; // If the badge doesn't exist, then the cart is empty.
        }
        Assert.assertEquals(expectedBasketCount, actualBasketCount);
    }

    private static final Map<String, String> productLocators = new HashMap<String, String>() {{
        put("Backpack", addBackpack);
        put("Bike Light", addBikeLight);
        put("Bolt T-Shirt", addTShirt);
        put("Jacket", addJacket);
        put("Onesie", addBody);
        put("T-Shirt (Red)", addRedTShirt);
    }};

    private static final Map<String, String> productNamesLocators = new HashMap<String, String>() {{
        put("Backpack", backpackId);
        put("Bike Light", bikeId);
        put("Bolt T-Shirt", tshirtId);
        put("Jacket", jacketId);
        put("Onesie", babyBodyId);
        put("T-Shirt (Red)", redTshirtId);
    }};

    private static final Map<String, String> removeLocators = new HashMap<String, String>() {{
        put("Backpack", removeBackpack);
        put("Bike Light", removeBikeLight);
        put("Bolt T-Shirt", removeTShirt);
        put("Jacket", removeJacket);
        put("Onesie", removeBody);
        put("T-Shirt (Red)", removeRedTShirt);
    }};

    public void addToCartAll(String productName) throws InterruptedException {
        String[] productNames = productName.split(", ");
        for (String name : productNames) {
            String locator = productLocators.get(name);
            wait(500);
            WebElement product = driver.findElement(By.id(locator));
            product.click();

            String removeLocator = removeLocators.get(name);
            Assert.assertEquals("Remove", driver.findElement(By.id(removeLocator)).getText());
        }
    }

    public void openProduct(String productName) {
        String[] productNames = productName.split(", ");
        for (String name : productNames) {
            String locator = productNamesLocators.get(name);
            WebElement product = driver.findElement(By.id(locator));
            product.click();

        }
    }

    public void removeFromBasket(String productName) {
        String[] productNames = productName.split(", ");
        for (String name : productNames) {
            String removeLocator = removeLocators.get(name);
            WebElement removeButton = driver.findElement(By.id(removeLocator));
            removeButton.click();
        }
    }

    public void checkButtonNameChange(String productName, String expectedText) {
        String[] productNames = productName.split(", ");
        for (String name : productNames) {
            String buttonLocator = productLocators.get(name);
            Assert.assertEquals(expectedText, driver.findElement(By.id(buttonLocator)).getText());
        }
    }

    public void selectSortingOption(String selectOption) {
        // Open the dropdown menu
        WebElement dropdownMenu = driver.findElement(By.className(dropdownOpen));
        dropdownMenu.click();

        WebElement sortByNameOption = driver.findElement(By.xpath("//option[contains(text(), '" + selectOption + "')]"));
        sortByNameOption.click();
    }

    public void productListByName(String isAscending) {

        List<WebElement> productElements = driver.findElements(By.className(productNames));
        List<String> productNames = productElements.stream().map(WebElement::getText).collect(Collectors.toList());

        // Create sorted copy of the product names
        List<String> sortedProductNames = new ArrayList<>(productNames);
        if (isAscending.equals("ascending")) {
            Collections.sort(sortedProductNames);
        } else {
            Collections.sort(sortedProductNames, Collections.reverseOrder());
        }
        Assert.assertEquals(sortedProductNames, productNames);
    }


    public void productListByPrice(String lowestPrice) {

        List<WebElement> productElements = driver.findElements(By.className(productPrice));
        List<Double> productPrices = productElements.stream().map(e -> Double.parseDouble(e.getText().replace("$", ""))).collect(Collectors.toList());

        // Create sorted copy of the product names
        List<Double> sortedProductPrices = new ArrayList<>(productPrices);
        if (lowestPrice.equals("lowest")) {
            Collections.sort(sortedProductPrices);
        } else {
            Collections.sort(sortedProductPrices, Collections.reverseOrder());
        }
        Assert.assertEquals(sortedProductPrices, productPrices);
    }

}
