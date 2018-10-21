package pageObjects;

import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.*;
import org.openqa.selenium.support.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class HomePageSelenideCucumber {

    // 1. fields
    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement login;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement password;

    @FindBy(css = ".login [type = 'submit']")
    private SelenideElement submit;


    //@Step("Open JDI Test")
    @When("I'm on the Home Page")
    public void openPage() {
        open("https://epam.github.io/JDI/index.html");
    }

    // 2. methods
    public void login(String login, String password) {
        profileButton.click();
        this.login.sendKeys(login);
        this.password.sendKeys(password);
        submit.click();
    }

    @Then("The browser title is Home Page")
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), "Home Page");
    }
}
