package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;

public class DifferentElementsPageSelenide {

    //====================== fields ======================

    @FindBy(css = "label.label-checkbox")
    private ElementsCollection checkboxs;

    @FindBy(xpath = "//label[@class = 'label-checkbox' and contains(., 'Water')]")
    private SelenideElement checkboxWater;

    @FindBy(xpath = "//label[@class = 'label-checkbox' and contains(., 'Wind')]")
    private SelenideElement checkboxWind;

    @FindBy(css = "label.label-radio")
    private ElementsCollection radios;

    @FindBy(css = "[name = 'metal']")
    private SelenideElement metalRadio;

    @FindBy(xpath = "//label[@class = 'label-radio' and contains(., 'Selen')]")
    private SelenideElement radioSelen;

    @FindBy(css = "select.uui-form-element")
    private SelenideElement dropdown;

    @FindBy(xpath = "//div[@class = 'colors']/select/option[text() = 'Yellow']")
    private SelenideElement dropdownYellow;

    @FindBy(css = ".uui-button:not(.btn-login)")
    private ElementsCollection buttons;

    @FindBy(css = ".sidebar-menu")
    private SelenideElement leftSidebar;

    @FindBy(css = ".uui-side-bar.right-fix-panel")
    private SelenideElement rightSidebar;

    @FindBy(css = ".panel-body-list.logs > li")
    private ElementsCollection logs;

    //====================== methods ======================

    public void clickCheckBoxWater() {
        checkboxWater.click();
    }

    public void clickCheckBoxWind() {
        checkboxWind.click();
    }

    public void clickRadioSelen() {
        radioSelen.click();
    }

    public void selectColor(String color) {
        dropdown.selectOption(color);
    }

    //====================== checks ======================

    public void checkCheckbox() {
        checkboxs.shouldHaveSize(4);
    }

    public void checkRadio() {
        radios.shouldHaveSize(4);
    }

    public void checkDropdown() {
        dropdown.shouldBe(visible);
    }

    public void checkButtons() {
        buttons.shouldHaveSize(2);
    }

    public void checkLeftSidebar() {
        leftSidebar.shouldBe(visible);
    }

    public void checkRightSidebar() {
        rightSidebar.shouldBe(visible);
    }

    public void checkLogCheckbox(String item, Boolean exists) {
        logs.findBy(matchText(item)).shouldHave(matchText(exists.toString()));
    }

    public void checkLogRadio(String metal) {
        logs.findBy(matchText("metal")).shouldHave(matchText(metal));
    }

    public void checkLogDropDown(String color) {
        logs.findBy(matchText("Colors")).shouldHave(matchText(color));
    }
}
