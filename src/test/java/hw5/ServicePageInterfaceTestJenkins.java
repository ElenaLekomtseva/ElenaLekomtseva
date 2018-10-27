package hw5;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBaseSelenide;
import pageObjects.DifferentElementsPageSelenide;
import pageObjects.HomePageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.Users.PITER_CHALOVSKII;

public class ServicePageInterfaceTestJenkins extends TestBaseSelenide {

    private HomePageSelenide homePageSelenide;
    private DifferentElementsPageSelenide differentElementsPageSelenide;

    @BeforeClass
    public void beforeClass() {
        homePageSelenide = page(HomePageSelenide.class);
        differentElementsPageSelenide = page(DifferentElementsPageSelenide.class);
    }

    @Test
    public void simpleTest() {

        //1 Navigate
        homePageSelenide.openPage();

        //2 Assert Title
        homePageSelenide.checkTitle();

        //3 Login
        homePageSelenide.login(PITER_CHALOVSKII.login, PITER_CHALOVSKII.password);

        //4 Assert User name in the left-top side of screen that user is loggined
        homePageSelenide.checkProfileName(PITER_CHALOVSKII.profileName);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        homePageSelenide.clickServiceHeaderMenu();
        homePageSelenide.checkServiceHeaderMenuItems();

        //6 Click on Service subcategory in the left section and check that drop down contains options
        homePageSelenide.clickServiceSidebarMenu();
        homePageSelenide.checkServiceSidebarMenuItems();

        //7 Open through the header menu Service -> Different Elements Page
        homePageSelenide.clickDifferentElementsHeaderMenu();

        //8 Check interface on Different elements page, it contains all needed elements
        differentElementsPageSelenide.checkCheckbox();
        differentElementsPageSelenide.checkRadio();
        differentElementsPageSelenide.checkDropdown();
        differentElementsPageSelenide.checkButtons();

        //9 Assert that there is Right Section
        differentElementsPageSelenide.checkRightSidebar();

        //10 Assert that there is Left Section
        differentElementsPageSelenide.checkLeftSidebar();

        //11 Select checkboxes
        differentElementsPageSelenide.clickCheckBoxWater();
        differentElementsPageSelenide.clickCheckBoxWind();

        //12 Assert that for each checkbox there is an individual log row and
        // value is corresponded to the status of checkbox. 
        differentElementsPageSelenide.checkLogCheckbox("Water", true);
        differentElementsPageSelenide.checkLogCheckbox("Wind", true);

        //13 Select radio
        differentElementsPageSelenide.clickRadioSelen();

        //14 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        differentElementsPageSelenide.checkLogRadio("Selen");

        //15 Select in dropdown
        differentElementsPageSelenide.selectColor("Yellow");

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        differentElementsPageSelenide.checkLogDropDown("Yellow");

        //17 Unselect and assert checkboxes
        differentElementsPageSelenide.clickCheckBoxWater();
        differentElementsPageSelenide.clickCheckBoxWind();

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to
        // the status of checkbox. checkbox
        differentElementsPageSelenide.checkLogCheckbox("Water", false);
        differentElementsPageSelenide.checkLogCheckbox("Wind", false);
    }
}
