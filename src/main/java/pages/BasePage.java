package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BasePage {

    protected static WebDriver driver;

    private static final Properties properties = new Properties();


    private static void loadPropertiesFile() {
        try {
            FileInputStream locator = new FileInputStream("src/main/resources/config.properties");
            properties.load(locator);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void launchBrowser() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C://Users//user_//projects//chromedriver//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }



    public static void closeBrowser() {
        driver.quit();
    }


    public static String getProperty(String key) {
        loadPropertiesFile();
        return properties.getProperty(key);
    }

    public static void wait(int time) throws InterruptedException {
        Thread.sleep(time);
    }
}
