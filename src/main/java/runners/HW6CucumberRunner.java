package runners;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@CucumberOptions(features = "src/test/java/hw6", glue = "pageObjects/cucumber")
public class HW6CucumberRunner extends AbstractTestNGCucumberTests {
    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @AfterMethod
    public void afterMethod() {
        closeWebDriver();
    }
}