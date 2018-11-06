Feature: Home Page tests

  Scenario: Service Page Interface test
    Given I am on "Home Page"
    Then "Home Page" page is opened
    And I login as user "epam" password 1234
    Then "PITER CHAILOVSKII" user is loggined
    And 4 pictures are displayed on Home page
    And 4 text under pictures are displayed on Home page
    And 2 text above are displayed on Home page

    When I click on "SERVICE" button in Header
    Then "Service" subcategory in the header contains options <Dropdown Values>
    When I click on "SERVICE" sidebar
    Then "Service" subcategory in the header contains options <Dropdown Values>
      | Dropdown Values     |
      | Support             |
      | Dates               |
      | Complex Table       |
      | Simple Table        |
      | User Table          |
      | Table with pages    |
      | Different elements  |
      | Performance         |

    When I click on "SERVICE" button in Header
    And I click on "DIFFERENT_ELEMENTS" button in Service dropdown
    Then "DIFFERENT_ELEMENTS" page is opened
    And 4 checkboxes are displayed on Different elements page
    And 4 radios are displayed on Different elements page
    And 1 dropdown are displayed on Different elements page
    And 2 buttons are displayed on Different elements page
    And Right section is displayed
    And Left section is displayed

    When Select checkboxes "Water", "Wind"
    Then Log rows are displayed, checkbox name and its status is corresponding to selected

    When Select radio "Selen"
    Then Log row is displayed, radiobutton name and its status is corresponding to selected

    When Select in dropdown "Yellow"
    Then Log row is displayed, dropdown name and selected value is corresponding to selected

    When Unselect checkboxes "Water", "Wind"
    Then Log rows are displayed, checkbox name and its status is corresponding to selected