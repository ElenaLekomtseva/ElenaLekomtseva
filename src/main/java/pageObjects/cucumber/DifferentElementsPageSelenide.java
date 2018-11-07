package pageObjects.cucumber;

import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Given;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class DifferentElementsPageSelenide {

    //====================== fields ======================

    public BasePageSelenide basePage = new BasePageSelenide();
    public DifferentElementsPageSelenide() {
        page(this);
    }

    //====================== methods ======================

    //====================== checks ======================

}
