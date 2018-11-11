package hw4;

import base.TestBaseSelenide;
import enums.Metals;
import enums.NatureForces;
import org.testng.annotations.Test;
import org.testng.annotations.*;
import pageObjects.DifferentElementsPageSelenide;
import pageObjects.HomePageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.Colors.YELLOW;
import static enums.HomePageMenu.*;
import static enums.HomePageMenu.SERVICE;
import static enums.Metals.*;
import static enums.NatureForces.WATER;
import static enums.NatureForces.WIND;
import static enums.ServiceMenu.DIFFERENT_ELEMENTS;
import static enums.Users.PITER_CHALOVSKII;

public class ServicePageInterfaceTestSelenidePageObject extends TestBaseSelenide {

    private HomePageSelenide homePageSelenide;
    private DifferentElementsPageSelenide differentElementsPageSelenide;

    @BeforeClass
    public void beforeClass() {
        homePageSelenide = page(HomePageSelenide.class);
        differentElementsPageSelenide = page(DifferentElementsPageSelenide.class);
    }

    @Test
    public void servicePageElementsTest() {

        //1 Navigate
        homePageSelenide.openHomePage();

        //2 Assert Title
        homePageSelenide.checkTitle(HOME);

        //3 Login
        homePageSelenide.login(PITER_CHALOVSKII);

        //4 Assert User name in the left-top side of screen that user is logined
        homePageSelenide.checkProfileName(PITER_CHALOVSKII);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        homePageSelenide.clickHeaderMenu(SERVICE);
        homePageSelenide.checkServiceHeaderMenu();

        //6 Click on Service subcategory in the left section and check that drop down contains options
        homePageSelenide.clickSidebarMenu(SERVICE);
        homePageSelenide.checkServiceSidebarMenu();

        //7 Open through the header menu Service -> Different Elements Page
        homePageSelenide.clickHeaderMenu(SERVICE);
        homePageSelenide.clickServiceHeaderMenu(DIFFERENT_ELEMENTS);
        differentElementsPageSelenide.checkTitle(DIFFERENT_ELEMENTS);

        //8 Check interface on Different elements page, it contains all needed elements
        differentElementsPageSelenide.checkCheckbox(NatureForces.values().length);
        differentElementsPageSelenide.checkRadio(Metals.values().length);
        differentElementsPageSelenide.checkDropdown();
        differentElementsPageSelenide.checkButtons(2);

        //9 Assert that there is Right Section
        differentElementsPageSelenide.checkRightSidebar();

        //10 Assert that there is Left Section
        differentElementsPageSelenide.checkLeftSidebar();

        //11 Select checkboxes
        differentElementsPageSelenide.clickCheckBox(WATER, WIND);

        //12 Assert that for each checkbox there is an individual log row and
        // value is corresponded to the status of checkbox. 
        differentElementsPageSelenide.checkLogCheckbox(WATER, true);
        differentElementsPageSelenide.checkLogCheckbox(WIND, true);

        //13 Select radio
        differentElementsPageSelenide.clickRadio(SELEN);

        //14 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        differentElementsPageSelenide.checkLogRadio(SELEN);

        //15 Select in dropdown
        differentElementsPageSelenide.selectColor(YELLOW);

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        differentElementsPageSelenide.checkLogDropDown(YELLOW);

        //17 Unselect and assert checkboxes
        differentElementsPageSelenide.clickCheckBox(WATER, WIND);

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to
        // the status of checkbox. checkbox
        differentElementsPageSelenide.checkLogCheckbox(WATER, false);
        differentElementsPageSelenide.checkLogCheckbox(WIND, false);
    }
}
