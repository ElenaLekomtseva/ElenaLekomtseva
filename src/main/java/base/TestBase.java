package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;
import static java.lang.System.currentTimeMillis;

public class TestBase {

    private long time;

    @BeforeSuite
    public void beforeSuit() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        time = currentTimeMillis();
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println(currentTimeMillis() - time);
    }
}
