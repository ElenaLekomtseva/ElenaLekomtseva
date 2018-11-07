package pageObjects.UseJDI.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ResultInfoPanel extends Section {

    @FindBy(css = ".results > li")
    private TextList resultRows;

    //====================== checks ======================

    public void checkFillResult(List<String> expectedValue) {
        Assert.assertEquals(expectedValue, resultRows.getTextList());
    }

}
