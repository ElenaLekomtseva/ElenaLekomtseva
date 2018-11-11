package pageObjects;

import enums.HomePageMenu;
import enums.ServiceMenu;
import io.qameta.allure.Step;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public abstract class AbstractPageSelenide {

    @Step
    public void checkTitle(HomePageMenu item) {
        assertEquals(getWebDriver().getTitle(), item.getTitle());
    }

    public void checkTitle(ServiceMenu item) {
        assertEquals(getWebDriver().getTitle(), item.getTitle());
    }
}
