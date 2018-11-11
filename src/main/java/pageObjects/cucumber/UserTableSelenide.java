package pageObjects.cucumber;

import com.codeborne.selenide.ElementsCollection;
import cucumber.api.java.en.*;
import io.cucumber.datatable.DataTable;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;

public class UserTableSelenide {

    //====================== fields ======================

    @FindBy(css = "#user-table > tbody > tr")
    private ElementsCollection tableRows;

    @FindBy(css = "#user-table > tbody > tr > td:nth-child(1)")
    private ElementsCollection numberColumns;

    @FindBy(css = "#user-table > tbody > tr > td:nth-child(2)")
    private ElementsCollection typeColumns;

    @FindBy(css = "#user-table > tbody > tr > td:nth-child(3)")
    private ElementsCollection userColumns;

    @FindBy(css = "#user-table > tbody > tr > td:nth-child(4) > img")
    private ElementsCollection imgDescriptionColumns;

    @FindBy(css = "#user-table > tbody > tr > td:nth-child(4) > div > span")
    private ElementsCollection textDescriptionColumns;

    @FindBy(css = "#user-table > tbody > tr > td:nth-child(4) > div > input")
    private ElementsCollection checkboxDescriptionColumns;

    @FindBy(css = ".logs > li")
    private ElementsCollection logs;

    private int lastRow = -1;

    public BasePageSelenide basePage = new BasePageSelenide();

    public UserTableSelenide() {
        page(this);
    }

    //====================== methods ======================

    private int findIndexRowByUserName(String user) {
        for (int i = 0; i < userColumns.size(); i++) {
            if (userColumns.get(i).getText().equals(user)) {
                return i;
            }
        }

        return -1;
    }

    @Step
    @When("I select 'vip' checkbox for \"(.+)\"")
    public void selectVipUser(String user) {
        lastRow = findIndexRowByUserName(user);
        checkboxDescriptionColumns.get(lastRow).click();
    }

    @Step
    @When("I click on dropdown in column (.+) for user (.+)")
    public void clickUserType(String type, String user) {
        lastRow = findIndexRowByUserName(user);
        typeColumns.get(lastRow).click();
    }

    //====================== checks ======================

    @Step
    @And("^(\\d+) (NumberType Dropdowns|User names|Description images|Description texts under images|checkboxes) are displayed on Users Table on User Table Page")
    public void checkColumnTable(int count, String column) {
        ElementsCollection columnRows = null;
        switch (column) {
            case "NumberType Dropdowns":
                columnRows = typeColumns;
                break;
            case "User names":
                columnRows = userColumns;
                break;
            case "Description images":
                columnRows = imgDescriptionColumns;
                break;
            case "Description texts under images":
                columnRows = textDescriptionColumns;
                break;
            case "checkboxes":
                columnRows = checkboxDescriptionColumns;
                break;
        }

        columnRows.shouldHaveSize(count);
        columnRows.filter(visible).shouldHaveSize(count);
    }

    @Step
    @And("User table contains following values:")
    public void checkTableContains(DataTable content) {
        numberColumns.shouldHave(texts(content.column(0).subList(1, content.height())));
        userColumns.shouldHave(texts(content.column(1).subList(1, content.height())));
        textDescriptionColumns.shouldHave(texts(content.column(2).subList(1, content.height())));
    }

    @Step
    @When("1 log row has \"(.+)\" text in log section")
    public void checkLog(String log) {
        logs.get(0).shouldHave(text(log));
    }

    @Step
    @Then("droplist contains values:")
    public void checkContainsUserType(List<String> content) {
        typeColumns.get(lastRow).shouldHave(and("Droplist contains values",
                matchText(content.get(1)), matchText(content.get(2)), matchText(content.get(3))));
    }
}
