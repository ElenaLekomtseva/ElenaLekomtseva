package hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IndexPageContentTextSmokeOrRegressionTest {

    @Test(groups = {"regression"})
    public void firstIndexPageContentTextSmokeTest() {

        //1 Open test site by URL
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.navigate().to("https://epam.github.io/JDI/");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        WebElement profileElement = driver.findElement(By.cssSelector(".profile-photo"));
        profileElement.click();
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement(By.cssSelector(".login [type = 'submit']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        assertEquals(profileElement.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> menuElements = driver.findElements(
                By.xpath("//ul[@class = 'uui-navigation nav navbar-nav m-l8']/li/a"));
        assertEquals(menuElements.size(), 4);

        ArrayList<String> menuItems = new ArrayList<String>();
        menuItems.add("HOME");
        menuItems.add("CONTACT FORM");
        menuItems.add("SERVICE");
        menuItems.add("METALS & COLORS");
        for (WebElement element : menuElements) {
            assertTrue(element.isDisplayed());
            assertTrue(menuItems.contains(element.getText()));
        }

        //7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitsElements = driver.findElements(By.xpath("//div[@class = 'col-sm-3']"));
        assertEquals(benefitsElements.size(), 4);

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
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
        for (WebElement elemant : benefitsElements) {
            assertTrue(elemant.isDisplayed());
            assertTrue(benefitTexts.contains(elemant.getText()));
        }

        //9 Assert a text of the main header
        WebElement mainTitle = driver.findElement(By.cssSelector("h3.main-title"));
        assertTrue(mainTitle.isDisplayed());
        assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");

        WebElement maintText = driver.findElement(By.xpath("//p[@class = 'main-txt text-center']"));
        assertTrue(maintText.isDisplayed());
        assertTrue(maintText.getText().startsWith("LOREM IPSUM"));

        //10 Assert that there is the iframe in the center of page
        WebElement frame = driver.findElement(By.cssSelector("iframe"));
        assertTrue(frame.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        String windowHandler = driver.getWindowHandle();
        driver.switchTo().frame(frame);
        WebElement frameLogo = driver.findElement(By.xpath("//img[@id = 'epam_logo']"));
        assertTrue(frameLogo.isDisplayed());

        //12 Switch to original window back
        // other methods defaultContent() parentFrame()
        driver.switchTo().window(windowHandler);

        //13 Assert a text of the sub header
        WebElement textCenter = driver.findElement(By.xpath("//h3[@class = 'text-center']"));
        assertTrue(textCenter.isDisplayed());
        assertEquals(textCenter.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(textCenter.findElement(By.cssSelector("a")).getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        WebElement sideBar = driver.findElement(By.name("navigation-sidebar"));
        assertTrue(sideBar.isDisplayed());

        //16 Assert that there is Footer
        WebElement footer = driver.findElement(By.cssSelector("footer"));
        assertTrue(footer.isDisplayed());

        //17 Close Browser
        driver.close();
        driver.quit();
    }

    @Test(groups = {"regression"})
    public void secondIndexPageContentTextSmokeTest() {

        //1 Open test site by URL
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.navigate().to("https://epam.github.io/JDI/");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        WebElement profileElement = driver.findElement(By.cssSelector(".profile-photo"));
        profileElement.click();
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement(By.cssSelector(".login [type = 'submit']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        assertEquals(profileElement.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> menuElements = driver.findElements(
                By.xpath("//ul[@class = 'uui-navigation nav navbar-nav m-l8']/li/a"));
        assertEquals(menuElements.size(), 4);

        ArrayList<String> menuItems = new ArrayList<String>();
        menuItems.add("HOME");
        menuItems.add("CONTACT FORM");
        menuItems.add("SERVICE");
        menuItems.add("METALS & COLORS");
        for (WebElement element : menuElements) {
            assertTrue(element.isDisplayed());
            assertTrue(menuItems.contains(element.getText()));
        }

        //7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitsElements = driver.findElements(By.xpath("//div[@class = 'col-sm-3']"));
        assertEquals(benefitsElements.size(), 4);

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
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
        for (WebElement elemant : benefitsElements) {
            assertTrue(elemant.isDisplayed());
            assertTrue(benefitTexts.contains(elemant.getText()));
        }

        //9 Assert a text of the main header
        WebElement mainTitle = driver.findElement(By.cssSelector("h3.main-title"));
        assertTrue(mainTitle.isDisplayed());
        assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");

        WebElement maintText = driver.findElement(By.xpath("//p[@class = 'main-txt text-center']"));
        assertTrue(maintText.isDisplayed());
        assertTrue(maintText.getText().startsWith("LOREM IPSUM"));

        //10 Assert that there is the iframe in the center of page
        WebElement frame = driver.findElement(By.cssSelector("iframe"));
        assertTrue(frame.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        String windowHandler = driver.getWindowHandle();
        driver.switchTo().frame(frame);
        WebElement frameLogo = driver.findElement(By.xpath("//img[@id = 'epam_logo']"));
        assertTrue(frameLogo.isDisplayed());

        //12 Switch to original window back
        // other methods defaultContent() parentFrame()
        driver.switchTo().window(windowHandler);

        //13 Assert a text of the sub header
        WebElement textCenter = driver.findElement(By.xpath("//h3[@class = 'text-center']"));
        assertTrue(textCenter.isDisplayed());
        assertEquals(textCenter.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(textCenter.findElement(By.cssSelector("a")).getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        WebElement sideBar = driver.findElement(By.name("navigation-sidebar"));
        assertTrue(sideBar.isDisplayed());

        //16 Assert that there is Footer
        WebElement footer = driver.findElement(By.cssSelector("footer"));
        assertTrue(footer.isDisplayed());

        //17 Close Browser
        driver.close();
        driver.quit();
    }

    @Test(groups = {"smoke"})
    public void thirdIndexPageContentTextSmokeTest() {

        //1 Open test site by URL
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.navigate().to("https://epam.github.io/JDI/");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        WebElement profileElement = driver.findElement(By.cssSelector(".profile-photo"));
        profileElement.click();
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement(By.cssSelector(".login [type = 'submit']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        assertEquals(profileElement.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> menuElements = driver.findElements(
                By.xpath("//ul[@class = 'uui-navigation nav navbar-nav m-l8']/li/a"));
        assertEquals(menuElements.size(), 4);

        ArrayList<String> menuItems = new ArrayList<String>();
        menuItems.add("HOME");
        menuItems.add("CONTACT FORM");
        menuItems.add("SERVICE");
        menuItems.add("METALS & COLORS");
        for (WebElement element : menuElements) {
            assertTrue(element.isDisplayed());
            assertTrue(menuItems.contains(element.getText()));
        }

        //7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitsElements = driver.findElements(By.xpath("//div[@class = 'col-sm-3']"));
        assertEquals(benefitsElements.size(), 4);

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
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
        for (WebElement elemant : benefitsElements) {
            assertTrue(elemant.isDisplayed());
            assertTrue(benefitTexts.contains(elemant.getText()));
        }

        //9 Assert a text of the main header
        WebElement mainTitle = driver.findElement(By.cssSelector("h3.main-title"));
        assertTrue(mainTitle.isDisplayed());
        assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");

        WebElement maintText = driver.findElement(By.xpath("//p[@class = 'main-txt text-center']"));
        assertTrue(maintText.isDisplayed());
        assertTrue(maintText.getText().startsWith("LOREM IPSUM"));

        //10 Assert that there is the iframe in the center of page
        WebElement frame = driver.findElement(By.cssSelector("iframe"));
        assertTrue(frame.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        String windowHandler = driver.getWindowHandle();
        driver.switchTo().frame(frame);
        WebElement frameLogo = driver.findElement(By.xpath("//img[@id = 'epam_logo']"));
        assertTrue(frameLogo.isDisplayed());

        //12 Switch to original window back
        // other methods defaultContent() parentFrame()
        driver.switchTo().window(windowHandler);

        //13 Assert a text of the sub header
        WebElement textCenter = driver.findElement(By.xpath("//h3[@class = 'text-center']"));
        assertTrue(textCenter.isDisplayed());
        assertEquals(textCenter.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(textCenter.findElement(By.cssSelector("a")).getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        WebElement sideBar = driver.findElement(By.name("navigation-sidebar"));
        assertTrue(sideBar.isDisplayed());

        //16 Assert that there is Footer
        WebElement footer = driver.findElement(By.cssSelector("footer"));
        assertTrue(footer.isDisplayed());

        //17 Close Browser
        driver.close();
        driver.quit();
    }
}
