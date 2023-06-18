import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import static pages.BasePage.closeBrowser;
import static pages.BasePage.launchBrowser;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepDefinition"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        tags = ""
)


public class CucumberTestsRunner extends AbstractTestNGCucumberTests {



    @BeforeMethod
    public static void setUp() {
        launchBrowser();


    }

    @AfterMethod
    public static void tearDown() {
       closeBrowser();
    }

}

