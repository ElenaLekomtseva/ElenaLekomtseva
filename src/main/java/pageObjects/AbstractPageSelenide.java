package pageObjects;

import io.qameta.allure.Step;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public abstract class AbstractPageSelenide {

    @Step
    public void checkTitle(String title) {
        assertEquals(getWebDriver().getTitle(), title);
    }
}
