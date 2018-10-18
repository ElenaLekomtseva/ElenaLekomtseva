package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    // 1. fields
    @FindBy(css = ".profile-photo")
    private WebElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private WebElement login;

    @FindBy(css = "[id = 'Password']")
    private WebElement password;

    @FindBy(css = ".login [type = 'submit']")
    private WebElement submit;

    // 2. methods
    public void login(String login, String password) {
        profileButton.click();
        this.login.sendKeys(login);
        this.password.sendKeys(password);
        submit.click();
    }
}
