package pageObjects.cucumber;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;

public class DifferentElementsPageSelenide {

    //====================== fields ======================

    @FindBy(css = "label.label-checkbox")
    private ElementsCollection checkboxs;

    @FindBy(css = "label.label-radio")
    private ElementsCollection radios;

    @FindBy(css = "select.uui-form-element")
    private ElementsCollection dropdown;

    @FindBy(css = ".uui-button:not(.btn-login)")
    private ElementsCollection buttons;

    @FindBy(css = ".sidebar-menu")
    private SelenideElement leftSidebar;

    @FindBy(css = ".uui-side-bar.right-fix-panel")
    private SelenideElement rightSidebar;

    @FindBy(css = ".panel-body-list.logs > li")
    private ElementsCollection logs;

    public BasePageSelenide basePage = new BasePageSelenide();

    public DifferentElementsPageSelenide() {
        page(this);
    }

    //====================== methods =====================

    @Step
    @When("(Select|Unselect) checkboxes {values}")
    public void clickCheckBox(List<String> values) {
        for (String value : values) {
            checkboxs.find(text(value)).click();
        }
    }

    @Step
    @When("Select radio (.+)")
    public void clickRadio(String value) {
        radios.find(text(value)).click();
    }

    @Step
    @When("Select in dropdown {word}")
    public void selectColor(String value) {
        dropdown.get(0).selectOption(value);
    }

    //====================== checks ======================

    @Step
    @And("^(\\d+) (checkboxes|radios|dropdown|buttons) are displayed on Different elements page")
    public void checkElementDisplayed(int count, String nameElements) {
        ElementsCollection elements = null;
        switch (nameElements) {
            case "checkboxes":
                elements = checkboxs;
                break;
            case "radios":
                elements = radios;
                break;
            case "dropdown":
                elements = dropdown;
                break;
            case "buttons":
                elements = buttons;
                break;
        }

        elements.shouldHaveSize(count);
        elements.filter(visible).shouldHaveSize(count);
    }

    @Step
    @And("(.+) section is displayed")
    public void checkSection(String nameSection) {
        switch (nameSection) {
            case "Right":
                rightSidebar.shouldBe(visible);
                break;
            case "Left":
                leftSidebar.shouldBe(visible);
                break;
        }
    }

    @Step
    @Then("Log rows are displayed, checkbox name and its status {word} is corresponding to {values}")
    public void checkLogCheckbox(String exists, List<String> values) {
        for (String value : values) {
            logs.findBy(matchText(value)).shouldHave(matchText(exists));
        }
    }

    @Step
    @When("Log row is displayed, radiobutton name and selected (.+)")
    public void checkLogRadio(String value) {
        logs.findBy(matchText("metal")).shouldHave(matchText(value));
    }

    @Step
    @When("Log row is displayed, dropdown name and selected (.+)")
    public void checkLogDropDown(String value) {
        logs.findBy(matchText("Colors")).shouldHave(matchText(value));
    }
}
