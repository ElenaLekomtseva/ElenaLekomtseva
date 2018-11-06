package pageObjects.cucumber;

import com.codeborne.selenide.ElementsCollection;
import cucumber.api.PendingException;
import cucumber.api.Transpose;
import cucumber.api.java.en.*;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;

public class UserTableSelenide {

    //====================== fields ======================

    @FindBy(css = "#user-table > tbody > tr")
    ElementsCollection tableRows;

    @FindBy(css = "#user-table > tbody > tr > td:nth-child(1)")
    ElementsCollection numberColumns;

    @FindBy(css = "#user-table > tbody > tr > td:nth-child(2)")
    ElementsCollection typeColumns;

    @FindBy(css = "#user-table > tbody > tr > td:nth-child(3)")
    ElementsCollection userColumns;

    @FindBy(css = "#user-table > tbody > tr > td:nth-child(4) > img")
    ElementsCollection imgDescriptionColumns;

    @FindBy(css = "#user-table > tbody > tr > td:nth-child(4) > div")
    ElementsCollection textDescriptionColumns;

    @FindBy(css = "#user-table > tbody > tr > td:nth-child(4) > div > input")
    ElementsCollection checkboxDescriptionColumns;

    @FindBy(css = ".logs > li")
    ElementsCollection logs;

    public BasePageSelenide basePage = new BasePageSelenide();

    public UserTableSelenide() {
        page(this);
    }

    //====================== methods ======================

    @When("I select 'vip' checkbox for \"(.+)\"")
    public void selectVipUser(String user) {
        for (int i = 0; i < userColumns.size(); i++) {
            if (userColumns.get(i).getText().equals(user)) {
                checkboxDescriptionColumns.get(i).click();
                break;
            }
        }
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
    public void checkTableContains(@Transpose List<List<String>> content) {
        numberColumns.shouldHave(texts(
                content.get(0).stream().filter(s -> !s.equals("Number")).collect(Collectors.toList())));

        userColumns.shouldHave(texts(
                content.get(1).stream().filter(s -> !s.equals("User")).collect(Collectors.toList())));

        /*System.out.println(textDescriptionColumns.texts());
        textDescriptionColumns.shouldHave(texts(
                content.get(2).stream().filter(s -> !s.equals("Description")).collect(Collectors.toList())));*/
    }

    @Step
    @When("1 log row has \"(.+)\" text in log section")
    public void checkLog(String log) {
        logs.get(0).shouldHave(text(log));
    }

    private int index = -1;
    @When("I click on dropdown in column (.+) for user (.+)")
    public void clickUserType(String type, String user) {
        for (int i = 0; i < userColumns.size(); i++) {
            if (userColumns.get(i).getText().equals(user)) {
                index = i;
                break;
            }
        }

        if (index > -1) {
            typeColumns.get(index).click();
        }
    }

    @Then("droplist contains values")
    public void clickUserType(@Transpose List<String> content) {
        if (index > -1) {
            System.out.println(String.join("\n", content));
            System.out.println(typeColumns.get(index).text());
            typeColumns.get(index).shouldHave(text(String.join("\n", content)));
        }
    }
}
