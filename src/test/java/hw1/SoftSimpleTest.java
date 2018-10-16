package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SoftSimpleTest {

    @Test
    public void simpleTest() {

        SoftAssert softAssert = new SoftAssert();

        //1 Open test site by URL
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.navigate().to("https://epam.github.io/JDI/");

        //2 Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        WebElement profileElement = driver.findElement(By.cssSelector(".profile-photo"));
        profileElement.click();
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement(By.cssSelector(".login [type = 'submit']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        softAssert.assertEquals(profileElement.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> menuElements = driver.findElements(
                By.xpath("//ul[@class = 'uui-navigation nav navbar-nav m-l8']/li/a"));
        softAssert.assertEquals(menuElements.size(), 4);

        //"HOME"
        softAssert.assertTrue(menuElements.get(0).isDisplayed());
        softAssert.assertEquals(menuElements.get(0).getText(), "HOME");

        //"CONTACT FORM"
        softAssert.assertTrue(menuElements.get(1).isDisplayed());
        softAssert.assertEquals(menuElements.get(1).getText(), "CONTACT FORM");

        //"SERVICE"
        softAssert.assertTrue(menuElements.get(2).isDisplayed());
        softAssert.assertEquals(menuElements.get(2).getText(), "SERVICE");

        //"METALS & COLORS"
        softAssert.assertTrue(menuElements.get(3).isDisplayed());
        softAssert.assertEquals(menuElements.get(3).getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitsElements = driver.findElements(By.xpath("//div[@class = 'col-sm-3']"));
        softAssert.assertEquals(benefitsElements.size(), 4);

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        softAssert.assertTrue(benefitsElements.get(0).isDisplayed());
        softAssert.assertEquals(benefitsElements.get(0).getText(), "To include good practices" + "\n" +
                "and ideas from successful" + "\n" +
                "EPAM project");
        softAssert.assertTrue(benefitsElements.get(1).isDisplayed());
        softAssert.assertEquals(benefitsElements.get(1).getText(), "To be flexible and" + "\n" + "customizable");
        softAssert.assertTrue(benefitsElements.get(2).isDisplayed());
        softAssert.assertEquals(benefitsElements.get(2).getText(), "To be multiplatform");
        softAssert.assertTrue(benefitsElements.get(3).isDisplayed());
        softAssert.assertEquals(benefitsElements.get(3).getText(), "Already have good base" + "\n" +
                "(about 20 internal and" + "\n" +
                "some external projects)," + "\n" +
                "wish to get more…");

        //9 Assert a text of the main header
        WebElement mainTitle = driver.findElement(By.cssSelector("h3.main-title"));
        softAssert.assertTrue(mainTitle.isDisplayed());
        softAssert.assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");

        WebElement maintText = driver.findElement(By.xpath("//p[@class = 'main-txt text-center']"));
        softAssert.assertTrue(maintText.isDisplayed());
        softAssert.assertTrue(maintText.getText().startsWith("LOREM IPSUM"));

        //10 Assert that there is the iframe in the center of page
        WebElement frame = driver.findElement(By.cssSelector("iframe"));
        softAssert.assertTrue(frame.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        String windowHandler = driver.getWindowHandle();
        driver.switchTo().frame(frame);
        WebElement frameLogo =  driver.findElement(By.xpath("//img[@id = 'epam_logo']"));
        softAssert.assertTrue(frameLogo.isDisplayed());

        //12 Switch to original window back
        driver.switchTo().window(windowHandler);

        //13 Assert a text of the sub header
        WebElement textCenter = driver.findElement(By.xpath("//h3[@class = 'text-center']"));
        softAssert.assertTrue(textCenter.isDisplayed());
        softAssert.assertEquals(textCenter.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        softAssert.assertEquals(textCenter.findElement(By.cssSelector("a")).getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        WebElement sideBar = driver.findElement(By.name("navigation-sidebar"));
        softAssert.assertTrue(sideBar.isDisplayed());

        //16 Assert that there is Footer
        WebElement footer = driver.findElement(By.cssSelector("footer"));
        softAssert.assertTrue(footer.isDisplayed());

        //17 Close Browser
        driver.close();
        driver.quit();
    }
}
