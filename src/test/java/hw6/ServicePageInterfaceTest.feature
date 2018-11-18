Feature: Service Page Interface tests

  Scenario: Service Page Interface check
    Given I am on "Home Page"
    Then "Home Page" page is opened
    And I login as user "Piter Chailovskii"
    Then "Piter Chailovskii" user is loggined
    And 4 pictures are displayed on Home page
    And 4 text under pictures are displayed on Home page
    And 2 text above are displayed on Home page

    When I click on "Service" button in Header
    Then "Service" subcategory in the header contains options:
      | Support             |
      | Dates               |
      | Complex Table       |
      | Simple Table        |
      | User Table          |
      | Table with pages    |
      | Different elements  |
      | Performance         |

    When I click on "Service" sidebar
    Then "Service" subcategory in the siderbar contains options:
      | Support             |
      | Dates               |
      | Complex Table       |
      | Simple Table        |
      | User Table          |
      | Table with pages    |
      | Different elements  |
      | Performance         |

    When I click on "Service" button in Header
    And I click on "Different elements" button in Service dropdown
    Then "Different Elements" page is opened
    And 4 checkboxes are displayed on Different elements page
    And 4 radios are displayed on Different elements page
    And 1 dropdown are displayed on Different elements page
    And 2 buttons are displayed on Different elements page
    And Right section is displayed
    And Left section is displayed

    When Select checkboxes:
      | Water |
      | Wind  |
    Then log rows are displayed and its status true:
      | Water |
      | Wind  |

    When Select radio Selen
    Then log row is displayed and selected radio Selen

    When Select in dropdown Yellow
    Then log row is displayed and selected dropdown Yellow

    When Unselect checkboxes:
      | Water |
      | Wind  |
    Then log rows are displayed and its status false:
      | Water |
      | Wind  |