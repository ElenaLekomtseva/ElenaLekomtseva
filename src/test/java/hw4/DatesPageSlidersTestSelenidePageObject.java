package hw4;

import base.TestBaseSelenide;
import enums.HomePageMenu;
import enums.ServiceMenu;
import org.testng.annotations.*;
import pageObjects.DatesPageSelenide;
import pageObjects.HomePageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.Users.PITER_CHALOVSKII;

public class DatesPageSlidersTestSelenidePageObject extends TestBaseSelenide {

    private HomePageSelenide homePageSelenide;
    private DatesPageSelenide datesPageSelenide;

    @BeforeClass
    public void beforeClass() {
        homePageSelenide = page(HomePageSelenide.class);
        datesPageSelenide = page(DatesPageSelenide.class);
    }

    @Test
    public void simpleTest() {

        //1 Navigate
        homePageSelenide.openHomePage();

        //2 Assert Title
        homePageSelenide.checkTitle();

        //3 Login
        homePageSelenide.login(PITER_CHALOVSKII.login, PITER_CHALOVSKII.password);

        //4 Assert User name in the left-top side of screen that user is loggined
        homePageSelenide.checkProfileName(PITER_CHALOVSKII.profileName);

        //5 Open through the header menu Service -> Dates Page
        //7 Open through the header menu Service -> Different Elements Page
        homePageSelenide.clickHeaderMenu(HomePageMenu.SERVICE);
        homePageSelenide.clickServiceHeaderMenu(ServiceMenu.DATES);

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position,
        // right slider - the most rigth position: From = 0, To = 100
        datesPageSelenide.setDragAndDropSlider(0, 100);

        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkLog(0, 100);

        //8 Using drag-and-drop set Range sliders. left sliders - the most left position,
        // right slider - the most left position: From = 0, To = 0
        datesPageSelenide.setDragAndDropSlider(0, 0);

        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkLog(0, 0);

        //10 Using drag-and-drop set Range sliders. left sliders - the most rigth position,
        // right slider - the most rigth position: From = 100, To = 100
        datesPageSelenide.setDragAndDropSlider(100, 100);

        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        // error
        datesPageSelenide.checkLog(100, 100);

        //12 Using drag-and-drop set Range sliders: From = 30, To = 70
        datesPageSelenide.setDragAndDropSlider(30, 70);

        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkLog(30, 70);
    }
}