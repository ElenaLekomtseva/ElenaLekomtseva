package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
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
    private SelenideElement menuService;

    @FindBy(xpath = "//*[@class = 'dropdown-menu']/li/a[text() = 'Dates']")
    private SelenideElement menuServiceDates;

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

    public void clickDates() {
        menuService.click();
        menuServiceDates.click();
    }

    //====================== checks ======================

    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    public void checkProfileName(String profileName) {
        profileButton.shouldHave(text(profileName));
    }

    public void checkMainText() {
        mainTitle.shouldBe(visible);
        mainTitle.shouldHave(text("EPA FRAMEWORK WISHES…"));
    }
}
