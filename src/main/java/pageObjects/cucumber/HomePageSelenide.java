package pageObjects.cucumber;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.*;
import io.qameta.allure.Step;
import org.openqa.selenium.support.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class HomePageSelenide {

    //====================== fields ======================

    @FindBy(css = "h3.main-title")
    private SelenideElement mainTitle;

    @FindBy(css = "p.main-txt")
    private SelenideElement mainText;

    @FindBy(css = "div.benefit-icon")
    private ElementsCollection benefitsElements;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection textUnderBenefitsElements;

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

    @Step
    @And("(\\d+) pictures are displayed on Home page")
    public void checkPicturesOnHomePage(int count) {
        benefitsElements.shouldHaveSize(count);
    }

    @Step
    @And("(\\d+) text under pictures are displayed on Home page")
    public void checkTextUnderPicturesOnHomePage(int count) {
        benefitsElements.shouldHaveSize(count);
    }

    @Step
    @And("(\\d+) text above are displayed on Home page")
    public void checkMainContentOnHomePage(int count) {
        mainTitle.shouldHave(visible);
        mainText.shouldHave(visible);
    }
}
