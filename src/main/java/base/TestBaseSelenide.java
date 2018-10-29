package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public class TestBaseSelenide {

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "CHROME";
    }
}
