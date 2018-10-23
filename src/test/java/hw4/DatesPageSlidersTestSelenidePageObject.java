package hw4;

import base.TestBaseSelenide;
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
        homePageSelenide.openPage();

        //2 Assert Title
        homePageSelenide.checkTitle();

        //3 Login
        homePageSelenide.login(PITER_CHALOVSKII.login, PITER_CHALOVSKII.password);

        //4 Assert User name in the left-top side of screen that user is loggined
        homePageSelenide.checkProfileName(PITER_CHALOVSKII.profileName);

        //5 Open through the header menu Service -> Dates Page
        homePageSelenide.clickDatesHeaderMenu();

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position,
        // right slider - the most rigth position: From = 0, To = 100
        datesPageSelenide.initSlider();
        datesPageSelenide.setDragAndDropSliderX(0);
        datesPageSelenide.setDragAndDropSlidery(100);
        datesPageSelenide.checkLog();

        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values

        //8 Using drag-and-drop set Range sliders. left sliders - the most left position,
        // right slider - the most left position: From = 0, To = 0
        datesPageSelenide.setDragAndDropSliderX(0);
        datesPageSelenide.setDragAndDropSlidery(0);
        datesPageSelenide.checkLog();

        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values

        //10 Using drag-and-drop set Range sliders. left sliders - the most rigth position,
        // right slider - the most rigth position: From = 100, To = 100
        datesPageSelenide.setDragAndDropSliderX(100);
        datesPageSelenide.setDragAndDropSlidery(100);
        datesPageSelenide.checkLog();

        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values

        //12 Using drag-and-drop set Range sliders: From = 30, To = 70
        datesPageSelenide.setDragAndDropSliderX(30);
        datesPageSelenide.setDragAndDropSlidery(70);
        datesPageSelenide.checkLog();

        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
    }
}