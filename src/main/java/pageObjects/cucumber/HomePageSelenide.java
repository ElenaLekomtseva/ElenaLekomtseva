package pageObjects.cucumber;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import enums.HomePageMenu;
import enums.ServiceMenu;
import io.qameta.allure.Step;
import org.openqa.selenium.support.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

import static enums.HomePageMenu.*;

public class HomePageSelenide {

    //====================== fields ======================

    @FindBy(css = "h3.main-title")
    private SelenideElement mainTitle;

    public BasePageSelenide basePage = new BasePageSelenide();
    public HomePageSelenide() {
        page(this);
    }

    //====================== methods ======================

    @Step
    @Given("I am on \"Home Page\"")
    public void openHomePage() {
        open("https://epam.github.io/JDI/index.html");
    }

    //====================== checks ======================

}
