package pageObjects.cucumber;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
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
    @And("I login as user \"(.+)\"")
    public void login(String profile) {
        for (Users user : Users.values()) {
            if (user.profileName.equals(profile.toUpperCase())) {
                profileButton.click();
                this.login.sendKeys(user.login);
                this.password.sendKeys(user.password);
                submit.click();
                break;
            }
        }
    }

    @Step
    @When("I click on \"(.+)\" button in Header")
    public void clickHeaderMenu(String homePageMenuItem) {
        headerMenu.find(text(homePageMenuItem)).click();
    }

    @Step
    @When("I click on \"(.*)\" sidebar")
    public void clickServiceSidebarMenu(String homePageSiderbarMenuItem) {
        siderbarMenu.find(text(homePageSiderbarMenuItem)).click();
    }

    @Step
    @When("I click on \"(.+)\" button in Service dropdown")
    public void clickServiceHeaderMenu(String dropdownServiceHeaderMenuItem) {
        dropdownServiceHeaderMenu.find(text(dropdownServiceHeaderMenuItem)).click();
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
        profileButton.shouldHave(text(profileName.toUpperCase()));
    }

    @Step
    @Then("\"Service\" subcategory in the header contains options:")
    public void checkServiceHeaderMenu(List<String> options) {
        dropdownServiceHeaderMenu.shouldHave(texts(options));
    }

    @Step
    @Then("\"Service\" subcategory in the siderbar contains options:")
    public void checkServiceSidebarMenu(List<String> options) {
        dropdownServiceSidebarMenu.shouldHave(texts(options));
    }
}
