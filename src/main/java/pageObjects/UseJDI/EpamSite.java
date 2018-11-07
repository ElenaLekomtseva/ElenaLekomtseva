package pageObjects.UseJDI;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import entities.User;
import enums.HomePageMenu;
import pageObjects.UseJDI.pages.MetalsColorsPage;
import pageObjects.UseJDI.sections.Header;
import pageObjects.UseJDI.sections.LoginForm;
import pageObjects.UseJDI.pages.HomePage;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

@JSite("https://epam.github.io/JDI/")
public class EpamSite extends WebSite {

    //====================== fields ======================

    public static HomePage homePage;
    public static MetalsColorsPage metalsColorsPage;

    public static LoginForm loginForm;
    public static Header header;

    @FindBy(css = ".profile-photo")
    private static Label profilePhoto;

    //====================== methods ======================

    public static void login(User user) {
        profilePhoto.click();
        loginForm.loginAs(user);
        Assert.assertEquals(profilePhoto.getText(), user.profileName);
    }

    public static void selectHeaderMenu(HomePageMenu item) {
        header.headerMenu.select(item);
    }

}
