package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePage {

    //====================== fields ======================

    @FindBy(css = ".profile-photo")
    private WebElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private WebElement login;

    @FindBy(css = "[id = 'Password']")
    private WebElement password;

    @FindBy(css = ".login [type = 'submit']")
    private WebElement submit;

    @FindBy(css = "h3.main-title")
    private WebElement mainTitle;

    @FindBy(css = "p.main-txt.text-center")
    private WebElement mainText;

    @FindBy(css = ".uui-navigation.m-l8 > li > a")
    private List<WebElement> menuElements;

    @FindBy(css = "div.col-sm-3")
    private List<WebElement> benefitsElements;

    @FindBy(css = "iframe")
    private WebElement frame;

    @FindBy(css = "img[id='epam_logo']")
    private WebElement frameLogo;

    @FindBy(css = "h3.text-center:not(.main-title)")
    private WebElement textCenter;

    @FindBy(css = ".text-center > a[href]")
    private WebElement textCenterLink;

    @FindBy(css = "[name = 'navigation-sidebar']")
    private WebElement sideBar;

    @FindBy(css = "footer")
    private WebElement footer;

    //====================== methods ======================

    public void openPage(WebDriver driver) {
        driver.navigate().to("https://epam.github.io/JDI/index.html");
    }

    public void login(String login, String password) {
        profileButton.click();
        this.login.sendKeys(login);
        this.password.sendKeys(password);
        submit.click();
    }

    public void switchToFrame(WebDriver driver) {
        driver.switchTo().frame(frame);
    }

    public void backOriginalWindow(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    //====================== checks ======================

    public void checkTitle(WebDriver driver) {
        assertEquals(driver.getTitle(), "Home Page");
    }

    public void checkMainTitle() {
        assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");
    }

    public void checkProfileName(String profileName) {
        assertEquals(profileButton.getText(), profileName);
    }

    public void checkMainText() {
        assertTrue(mainText.isDisplayed());
        assertTrue(mainText.getText().startsWith("LOREM IPSUM"));
    }

    public void checkMenuElements() {
        ArrayList<String> menuItems = new ArrayList<String>();
        menuItems.add("HOME");
        menuItems.add("CONTACT FORM");
        menuItems.add("SERVICE");
        menuItems.add("METALS & COLORS");

        assertEquals(menuElements.size(), menuItems.size());
        for (WebElement element : menuElements) {
            assertTrue(element.isDisplayed());
            assertTrue(menuItems.contains(element.getText()));
        }
    }

    public void checkBenefitElements() {
        ArrayList<String> benefitTexts = new ArrayList<String>();
        benefitTexts.add("To include good practices" + "\n" +
                "and ideas from successful" + "\n" +
                "EPAM project");
        benefitTexts.add("To be flexible and" + "\n" + "customizable");
        benefitTexts.add("To be multiplatform");
        benefitTexts.add("Already have good base" + "\n" +
                "(about 20 internal and" + "\n" +
                "some external projects)," + "\n" +
                "wish to get more…");

        assertEquals(benefitsElements.size(), benefitTexts.size());
        for (WebElement element : benefitsElements) {
            assertTrue(element.isDisplayed());
            assertTrue(benefitTexts.contains(element.getText()));
        }
    }

    public void checkFrame() {
        assertTrue(frame.isDisplayed());
    }

    public void checkLogoFrame() {
        assertTrue(frameLogo.isDisplayed());
    }

    public void checkTextCenter() {
        assertTrue(textCenter.isDisplayed());
        assertEquals(textCenter.getText(), "JDI GITHUB");
    }

    public void checkTextCenterLink() {
        assertEquals(textCenterLink.getAttribute("href"), "https://github.com/epam/JDI");
    }

    public void checkSideBar() { assertTrue(sideBar.isDisplayed()); }

    public void checkFooter() {
        assertTrue(footer.isDisplayed());
    }
}
