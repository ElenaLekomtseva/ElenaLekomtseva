package pageObjects.cucumber;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.HomePageMenu;
import enums.ServiceMenu;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class BasePageSelenide {

    //====================== fields ======================

    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement login;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement password;

    @FindBy(css = ".login [type = 'submit']")
    private SelenideElement submit;

    @FindBy(css = ".uui-navigation.m-l8 > li")
    private ElementsCollection headerMenu;

    @FindBy(css = ".dropdown-menu > li > a")
    private ElementsCollection dropdownServiceHeaderMenu;

    @FindBy(css = ".sidebar-menu > li")
    private ElementsCollection siderbarMenu;

    @FindBy(xpath = "//*[@class = 'sidebar-menu']//span[text() = 'Service']/../..//li[@ui = 'label']/a")
    private ElementsCollection dropdownServiceSidebarMenu;

    public BasePageSelenide() {
        page(this);
    }

    //====================== methods ======================

    @Step
    @And("I login as user \"(.+)\" password (.+)")
    public void login(String login, String password) {
        profileButton.click();
        this.login.sendKeys(login);
        this.password.sendKeys(password);
        submit.click();
    }

    @Step
    @When("I click on \"(.+)\" button in Header")
    public void clickHeaderMenu(String homePageMenuItem) {
        headerMenu.get(HomePageMenu.valueOf(homePageMenuItem).getIndex()).click();
    }

    @Step
    public void clickSidebarMenu(HomePageMenu item) {
        siderbarMenu.get(item.getIndex()).click();
    }

    @Step
    @When("I click on \"(.+)\" button in Service dropdown")
    public void clickServiceHeaderMenu(String dropdownServiceHeaderMenuItem) {
        dropdownServiceHeaderMenu.get(ServiceMenu.valueOf(dropdownServiceHeaderMenuItem).getIndex()).click();
    }

    //====================== checks ======================

    @Step
    @When("^\"(.+)\" page is opened")
    public void checkTitle(String title) {
        assertEquals(getWebDriver().getTitle(), title);
    }

    @Step
    @Then("\"(.+)\" user is loggined")
    public void checkProfileName(String profileName) {
        profileButton.shouldHave(text(profileName));
    }

    @Step
    public void checkServiceHeaderMenu() {
        List<String> serviceMenuValues = Stream.of(enums.ServiceMenu.values())
                .map(Enum::toString)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        dropdownServiceHeaderMenu.shouldHave(texts(serviceMenuValues));
    }

    @Step
    public void checkServiceSidebarMenu() {
        List<String> serviceMenuValues = Stream.of(enums.ServiceMenu.values())
                .map(Enum::toString)
                .collect(Collectors.toList());
        dropdownServiceSidebarMenu.shouldHave(texts(serviceMenuValues));
    }

}
