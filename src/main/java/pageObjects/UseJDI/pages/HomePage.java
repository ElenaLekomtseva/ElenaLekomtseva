package pageObjects.UseJDI.pages;

import com.epam.jdi.uitests.core.interfaces.complex.tables.interfaces.CheckPageTypes;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;

@JPage(url = "/index.html", title = "Home Page", titleCheckType = CheckPageTypes.EQUAL)
public class HomePage extends WebPage {}