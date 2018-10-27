package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class HomePageSelenide {

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

    @FindBy(xpath = "//*[@class = 'dropdown-toggle' and contains(text(),'Service')]")
    private SelenideElement serviceHeaderMenu;

    @FindBy(css = ".dropdown-menu > li > a")
    private ElementsCollection serviceHeaderMenuItems;

    @FindBy(xpath = "//*[@class = 'sidebar-menu']//span[text() = 'Service']/parent::*")
    private SelenideElement serviceSidebarMenu;

    @FindBy(xpath = "//*[@class = 'sidebar-menu']//span[text() = 'Service']/../..//li[@ui = 'label']/a")
    private ElementsCollection serviceSidebarMenuItems;

    @FindBy(xpath = "//*[@class = 'dropdown-menu']/li/a[text() = 'Different elements']")
    private SelenideElement differentElementsHeaderMenu;

    @FindBy(xpath = "//*[@class = 'dropdown-menu']/li/a[text() = 'Dates']")
    private SelenideElement datesHeaderMenu;

    //====================== methods ======================

    public void openPage() {
        open("https://epam.github.io/JDI/index.html");
    }

    public void login(String login, String password) {
        profileButton.click();
        this.login.sendKeys(login);
        this.password.sendKeys(password);
        submit.click();
    }

    public void clickServiceHeaderMenu() {
        serviceHeaderMenu.click();
    }

    public void clickServiceSidebarMenu() {
        serviceSidebarMenu.click();
    }

    public void clickDifferentElementsHeaderMenu() {
        this.clickServiceHeaderMenu();
        differentElementsHeaderMenu.click();
    }

    public void clickDatesHeaderMenu() {
        this.clickServiceHeaderMenu();
        datesHeaderMenu.click();
    }

    //====================== checks ======================

    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    public void checkProfileName(String profileName) {
        profileButton.shouldHave(text(profileName));
    }

//    public void checkMainText() {
//        mainTitle.shouldBe(visible);
//        mainTitle.shouldHave(text("EPA FRAMEWORK WISHES"));
//    }

    public void checkServiceHeaderMenuItems() {
        ArrayList<String> serviceHeaderMenuNameItems = new ArrayList<String>();
        serviceHeaderMenuNameItems.add("SUPPORT");
        serviceHeaderMenuNameItems.add("DATES");
        serviceHeaderMenuNameItems.add("COMPLEX TABLE");
        serviceHeaderMenuNameItems.add("SIMPLE TABLE");
        serviceHeaderMenuNameItems.add("USER TABLE");
        serviceHeaderMenuNameItems.add("TABLE WITH PAGES");
        serviceHeaderMenuNameItems.add("DIFFERENT ELEMENTS");
        serviceHeaderMenuNameItems.add("PERFORMANCE");

        serviceHeaderMenuItems.shouldHave(texts(serviceHeaderMenuNameItems));
    }

    public void checkServiceSidebarMenuItems() {
        ArrayList<String> serviceSiderBarMenuNameItems = new ArrayList<String>();
        serviceSiderBarMenuNameItems.add("Support");
        serviceSiderBarMenuNameItems.add("Dates");
        serviceSiderBarMenuNameItems.add("Complex Table");
        serviceSiderBarMenuNameItems.add("Simple Table");
        serviceSiderBarMenuNameItems.add("User Table");
        serviceSiderBarMenuNameItems.add("Table with pages");
        serviceSiderBarMenuNameItems.add("Different elements");
        serviceSiderBarMenuNameItems.add("Performance");

        serviceSidebarMenuItems.shouldHave(texts(serviceSiderBarMenuNameItems));
    }
}
