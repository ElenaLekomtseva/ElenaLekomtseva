package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selenide.actions;

public class DatesPageSelenide extends AbstractPageSelenide {

    //====================== fields ======================

    @FindBy(css = ".ui-slider")
    private SelenideElement slider;

    @FindBy(css = ".ui-slider-handle")
    private ElementsCollection sliderHandlers;

    @FindBy(css = ".panel-body-list.logs > li")
    private ElementsCollection logs;

    //====================== methods ======================

    @Step
    private double getStep() {
        return (double) slider.getSize().width / 100.0;
    }

    @Step
    private void moveHandler(SelenideElement handler, double position) {
        double currentPosition = Double.parseDouble(handler.text());
        double factor = currentPosition >= position ? 1 : 0;
        double offset = (position - currentPosition - factor) * getStep();

        actions().dragAndDropBy(handler.toWebElement(), (int) offset, 0).perform();
    }

    @Step
    public void setDragAndDropSlider(double from, double to) {
        if (from <= Double.parseDouble(sliderHandlers.get(0).text())) {
            moveHandler(sliderHandlers.get(0), from);
            moveHandler(sliderHandlers.get(1), to);
        } else {
            moveHandler(sliderHandlers.get(1), to);
            moveHandler(sliderHandlers.get(0), from);
        }
    }

    //====================== checks ======================

    @Step
    public void checkLog(Integer from, Integer to) {
        logs.findBy(matchText("From")).shouldHave(matchText(from.toString()));
        logs.findBy(matchText("To")).shouldHave(matchText(to.toString()));
    }
}
