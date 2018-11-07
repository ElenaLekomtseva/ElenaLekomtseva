package pageObjects.UseJDI.pages;

import com.epam.jdi.uitests.core.interfaces.complex.tables.interfaces.CheckPageTypes;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import pageObjects.UseJDI.sections.MetalsColorsElementsForm;
import pageObjects.UseJDI.sections.ResultInfoPanel;

@JPage(url = "/metals-colors.html", title = "Metal and Colors", titleCheckType = CheckPageTypes.EQUAL)
public class MetalsColorsPage extends WebPage {

    public MetalsColorsElementsForm metalsColorsElementsForm;
    public ResultInfoPanel resultInfoPanel;
}
