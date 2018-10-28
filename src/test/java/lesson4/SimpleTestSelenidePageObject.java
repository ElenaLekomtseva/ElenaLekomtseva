package lesson4;

import base.TestBaseSelenide;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageSelenide;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

public class SimpleTestSelenidePageObject extends TestBaseSelenide {

    private HomePageSelenide homePageSelenide;

    @BeforeClass
    public void beforeClass() {
        homePageSelenide = page(HomePageSelenide.class);
    }

    @Test
    public void simpleTest() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //2 Navigate
        homePageSelenide.openHomePage();

        //3 Assert Title
        assertEquals(getWebDriver().getTitle(), "Home Page");

        homePageSelenide.login("epam", "1234");

        //4 Login
        $(".profile-photo").click();
        $("[id = 'Name']").sendKeys("epam");
        $("[id = 'Password']").sendKeys("1234");
        $(".login [type = 'submit']").click();

        //$$(By.xpath(""));

        SelenideElement mainTitle = $("h3.main-title");
        mainTitle.shouldBe(Condition.visible);
        mainTitle.shouldHave(Condition.text("EPAM FRAMEWORK WISHES…"));
        //assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");

        //6 Check 4 images
        //$$(By.xpath("")).shouldHaveSize(4);
        //$$(By.xpath("")).shouldBe(CollectionCondition.sizeLessThan(5));
    }
}
