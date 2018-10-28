package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selenide.actions;

public class DatesPageSelenide {

    //====================== fields ======================

    @FindBy(css = ".ui-slider")
    private SelenideElement slider;

    @FindBy(css = ".ui-slider-handle")
    private ElementsCollection sliderHandlers;

    @FindBy(css = ".panel-body-list.logs > li")
    private ElementsCollection logs;

    //====================== methods ======================

    private double getStep() {
        return (double) slider.getSize().width / 100.0;
    }

    private void moveHandler(SelenideElement handler, double position) {
        double currentPosition = Double.parseDouble(handler.text());
        double offset = (position - currentPosition + (position  <= currentPosition ? -1 : 0)) * getStep();
        actions().dragAndDropBy(handler.toWebElement(), (int) offset, 0).perform();
    }

    public void setDragAndDropSlider(double from, double to) {
        moveHandler(sliderHandlers.get(0), from);
        moveHandler(sliderHandlers.get(1), to);
    }

    //====================== checks ======================

    public void checkLog(Integer from, Integer to) {
        logs.findBy(matchText("From")).shouldHave(matchText(from.toString()));
        logs.findBy(matchText("To")).shouldHave(matchText(to.toString()));
    }
}
