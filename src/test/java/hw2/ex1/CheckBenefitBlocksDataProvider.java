package hw2.ex1;

import dataProviders.DataProviders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class CheckBenefitBlocksDataProvider {

    @Test(dataProvider = "benefitBlocksDataProvider", dataProviderClass = DataProviders.class)
    public void benefitBlocksTest(String benefitText) {

        //0 Open test site by URL
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //1 Navigate
        driver.navigate().to("https://epam.github.io/JDI/");

        //2 asserting 4 texts below 4 pictures
        WebElement element = driver.findElement(By.xpath("//span[normalize-space(.) = '" +
                benefitText.replace("\n", "") + "']"));
        assertTrue(element.isDisplayed());

        driver.close();
        driver.quit();
    }
}
