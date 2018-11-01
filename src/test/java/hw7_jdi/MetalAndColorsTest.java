package hw7_jdi;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import dataProviders.DataProviders;
import dataProviders.MetalsAndColorsData;
import entities.User;
import org.testng.annotations.AfterMethod;
import pageObjects.UseJDI.EpamSite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static enums.HomePageMenu.*;
import static pageObjects.UseJDI.EpamSite.*;

public class MetalAndColorsTest extends TestNGBase {

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        WebSite.init(EpamSite.class);
    }

    @AfterMethod
    public static void afterMethod() {
        homePage.clearCache();
    }

    @Test(dataProvider = "metalsAndColorsDataProvider", dataProviderClass = DataProviders.class)
    public void metalAndColorsTest(MetalsAndColorsData data) {
        //1 Login on JDI site as User
        homePage.open();
        login(new User());
        homePage.checkOpened();

        //2 Open Metals & Colors page by Header menu
        selectHeaderMenu(METALS_AND_COLORS);
        metalsColorsPage.checkOpened();

        //3 Fill form Metals & Colors by data below
        metalsColorsPage.fillData(data);

        //Submit form Metals & Colors
        metalsColorsPage.submit();

        //4 Result sections should contains data  below
        checkFillResult(metalsColorsPage.getExpectedResult(data));
    }
}