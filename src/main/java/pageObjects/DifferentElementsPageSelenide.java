package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.Colors;
import enums.Metals;
import enums.NatureForces;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;

public class DifferentElementsPageSelenide extends AbstractPageSelenide {

    //====================== fields ======================

    @FindBy(css = "label.label-checkbox")
    private ElementsCollection checkboxs;

    @FindBy(css = "label.label-radio")
    private ElementsCollection radios;

    @FindBy(css = "select.uui-form-element")
    private SelenideElement dropdown;

    @FindBy(css = ".uui-button:not(.btn-login)")
    private ElementsCollection buttons;

    @FindBy(css = ".sidebar-menu")
    private SelenideElement leftSidebar;

    @FindBy(css = ".uui-side-bar.right-fix-panel")
    private SelenideElement rightSidebar;

    @FindBy(css = ".panel-body-list.logs > li")
    private ElementsCollection logs;

    //====================== methods ======================

    @Step
    public void clickCheckBox(NatureForces... items) {
        for (NatureForces item : items) {
            checkboxs.get(item.getIndex()).click();
        }
    }

    @Step
    public void clickRadio(Metals item) {
        radios.get(item.getIndex()).click();
    }

    @Step
    public void selectColor(Colors item) {
        dropdown.selectOption(item.toString());
    }

    //====================== checks ======================

    @Step
    public void checkCheckbox(int size) {
        checkboxs.shouldHaveSize(size);

        for (SelenideElement checkbox : checkboxs) {
            checkbox.shouldBe(visible);
        }
    }

    @Step
    public void checkRadio(int size) {
        radios.shouldHaveSize(size);

        for (SelenideElement radio : radios) {
            radio.shouldBe(visible);
        }
    }

    @Step
    public void checkDropdown() {
        dropdown.shouldBe(visible);
    }

    @Step
    public void checkButtons(int size) {
        buttons.shouldHaveSize(size);

        for (SelenideElement button : buttons) {
            button.shouldBe(visible);
        }
    }

    @Step
    public void checkLeftSidebar() {
        leftSidebar.shouldBe(visible);
    }

    @Step
    public void checkRightSidebar() {
        rightSidebar.shouldBe(visible);
    }

    @Step
    public void checkLogCheckbox(NatureForces item, Boolean exists) {
        logs.findBy(matchText(item.getValue())).shouldHave(matchText(exists.toString()));
    }

    @Step
    public void checkLogRadio(Metals item) {
        logs.findBy(matchText("metal")).shouldHave(matchText(item.getValue()));
    }

    @Step
    public void checkLogDropDown(Colors item) {
        logs.findBy(matchText("Colors")).shouldHave(matchText(item.toString()));
    }
}
