package hw3;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pageObjects.HomePage;

import java.util.concurrent.TimeUnit;

import static enums.Users.PITER_CHALOVSKII;

public class IndexPageContentTestPageObject extends TestBase {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.close();
        driver.quit();
    }

    @Test
    public void simpleTest() {

        //1 Navigate
        homePage.openPage(driver);

        //2 Assert Browser title
        homePage.checkTitle(driver);

        //3 Perform login
        homePage.login(PITER_CHALOVSKII.login, PITER_CHALOVSKII.password);

        //4 Assert User name in the left-top side of screen that user is loggined
         homePage.checkProfileName(PITER_CHALOVSKII.profileName);

        //5 Assert Browser title
        homePage.checkTitle(driver);

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        homePage.checkMenuElements();

        //7 Assert that there are 4 images on the Index Page and they are displayed
        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePage.checkBenefitElements();

        //9 Assert a text of the main header
        homePage.checkMainTitle();
        homePage.checkMainText();

        //10 Assert that there is the iframe in the center of page
        homePage.checkFrame();

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        homePage.switchToFrame(driver);
        homePage.checkLogoFrame();

        //12 Switch to original window back
        homePage.backOriginalWindow(driver);

        //13 Assert a text of the sub header
        homePage.checkTextCenter();

        //14 Assert that JDI GITHUB is a link and has a proper URL
        homePage.checkTextCenterLink();

        //15 Assert that there is Left Section
        homePage.checkSideBar();

        //16 Assert that there is Footer
        homePage.checkFooter();
    }
}
