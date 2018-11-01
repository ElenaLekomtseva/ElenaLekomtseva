package pageObjects.UseJDI.pages;

import com.epam.jdi.uitests.core.interfaces.complex.tables.interfaces.CheckPageTypes;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.*;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import org.openqa.selenium.support.FindBy;
import dataProviders.MetalsAndColorsData;

import java.util.ArrayList;
import java.util.List;

import static enums.Vegetables.*;

@JPage(url = "/metals-colors.html", title = "Metal and Colors", titleCheckType = CheckPageTypes.EQUAL)
public class MetalsColorsPage extends WebPage {

    //====================== fields ======================

    @FindBy(css = "#odds-selector > p")
    private CheckList oddsSummary;

    @FindBy(css = "#even-selector > p")
    private CheckList evenSummary;

    @FindBy(css = "#elements-checklist > p")
    private CheckList elements;

    @JDropdown(
            root = @FindBy(css = "#colors"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(tagName = "button")
    )
    private Dropdown colors;

    @JDropdown(
            root = @FindBy(css = ".metals"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(css = ".filter-option"),
            expand = @FindBy(css = ".caret")
    )
    private Dropdown metals;

    @JDropdown(
            root = @FindBy(css = "#salad-dropdown"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(tagName = "button")
    )
    private Dropdown vegetables;

    @FindBy(css = "#submit-button")
    private Button submitChange;

    //====================== methods ======================

    public void fillData(MetalsAndColorsData data) {
        //summary
        if (data.summary.size() > 0) {
            oddsSummary.check(data.summary.get(0).toString());
            evenSummary.check(data.summary.get(1).toString());
        }

        //elements
        for (String element : data.elements) {
            elements.check(element);
        }

        //color
        colors.select(data.color);

        //metals
        metals.select(data.metals);

        //vegetables
        if (vegetables.getValue().equals(VEGETABLES.toString())) {
            vegetables.select(VEGETABLES.toString());
        }
        for (String vegetable : data.vegetables) {
            vegetables.select(vegetable);
        }
    }

    public void submit() {
        submitChange.click();
    }

    public List<String> getExpectedResult(MetalsAndColorsData data) {
        List<String> fillData = new ArrayList<>();
        fillData.add("Summary: " + String.valueOf(data.summary.get(0) + data.summary.get(1)));
        fillData.add("Elements: " + String.join(", ", data.elements));
        fillData.add("Color: " + data.color);
        fillData.add("Metal: " + data.metals);
        fillData.add("Vegetables: " + String.join(", ", data.vegetables));

        return fillData;
    }
}
