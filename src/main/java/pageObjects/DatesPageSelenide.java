package pageObjects;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import sun.security.krb5.Config;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selenide.actions;

public class DatesPageSelenide {

    //====================== fields ======================

    @FindBy(css = ".ui-slider-horizontal")
    private SelenideElement slider;

    @FindBy(css = ".ui-slider-handle")
    private ElementsCollection leftSliderHandler;

    @FindBy(css = ".ui-slider-handle > span")
    private ElementsCollection leftSliderHandlerText;

    @FindBy(css = ".panel-body-list.logs > li")
    private ElementsCollection logs;

    @FindBy(css = ".uui-slider")
    private SelenideElement slider2;

    //====================== methods ======================

    private double step = 0;

    public void initSlider() {
        int leftX = leftSliderHandler.get(0).getLocation().x;
        int leftXP = Integer.parseInt(leftSliderHandlerText.get(0).text());

        int rightX = leftSliderHandler.get(1).getLocation().x;
        int rightXP = Integer.parseInt(leftSliderHandlerText.get(1).text());

        step = (double) (rightX - leftX) / (rightXP - leftXP);
    }

    public void setDragAndDropSliderX(int x) {
        int leftXP = Integer.parseInt(leftSliderHandlerText.get(0).text());
        leftXP += x == leftXP ? 0 : 1;

        double offSetX = (x - leftXP) * step;
        WebElement left = leftSliderHandler.get(0).toWebElement();
        actions().dragAndDropBy(left, (int) offSetX, left.getLocation().y).perform();
        //leftSliderHandler.get(0).dragAndDropTo(leftSliderHandler.get(1));/
        //WebElement left = leftSliderHandler.get(0).toWebElement();
        //actions().dragAndDropBy(left, 40, left.getLocation().y).perform();/
    }

    public void setDragAndDropSlidery(int y) {
        int leftYP = Integer.parseInt(leftSliderHandlerText.get(1).text());
        leftYP += y == leftYP ? 0 : 1;

        double offSetY = (y - leftYP) * step;
        WebElement left = leftSliderHandler.get(1).toWebElement();
        actions().dragAndDropBy(left, (int) offSetY, left.getLocation().y).perform();
    }

    //====================== checks ======================

    public void checkFromInLog(Integer from) {
        logs.findBy(matchText("From")).shouldHave(matchText(from.toString()));
    }

    public void checkToInLog(Integer to) {
        logs.findBy(matchText("To")).shouldHave(matchText(to.toString()));
    }
}
