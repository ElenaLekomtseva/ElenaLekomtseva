package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.HomePageMenu;
import enums.ServiceMenu;
import enums.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class HomePageSelenide extends AbstractPageSelenide {

    //====================== fields ======================

    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement login;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement password;

    @FindBy(css = ".login [type = 'submit']")
    private SelenideElement submit;

    @FindBy(css = "h3.main-title")
    private SelenideElement mainTitle;

    @FindBy(css = ".uui-navigation.m-l8 > li")
    private ElementsCollection headerMenu;

    @FindBy(css = ".dropdown-menu > li > a")
    private ElementsCollection dropdownServiceHeaderMenu;

    @FindBy(css = ".sidebar-menu > li")
    private ElementsCollection siderbarMenu;

    @FindBy(xpath = "//*[@class = 'sidebar-menu']//span[text() = 'Service']/../..//li[@ui = 'label']/a")
    private ElementsCollection dropdownServiceSidebarMenu;

    //====================== methods ======================

    @Step
    public void openHomePage() {
        open("https://epam.github.io/JDI/index.html");
    }

    @Step
    public void login(enums.Users user) {
        profileButton.click();
        this.login.sendKeys(user.login);
        this.password.sendKeys(user.password);
        submit.click();
    }

    @Step
    public void clickHeaderMenu(HomePageMenu item) {
        headerMenu.get(item.getIndex()).click();
    }

    @Step
    public void clickSidebarMenu(HomePageMenu item) {
        siderbarMenu.get(item.getIndex()).click();
    }

    @Step
    public void clickServiceHeaderMenu(ServiceMenu item) {
        dropdownServiceHeaderMenu.get(item.getIndex()).click();
    }

    //====================== checks ======================

    @Step
    public void checkProfileName(Users profile) {
        profileButton.shouldHave(text(profile.profileName));
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