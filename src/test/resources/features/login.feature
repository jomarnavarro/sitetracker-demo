Feature: Salesforce Lightning Web Components

  Scenario Outline: User can edit a datatable inline
    Given I navigate to Salesforce Developer page
    When I select <component> from <path> in left nav
    And I open <component_type> in Playground
    And I edit <row_number> in preview pane
      | Label      | Website            | Phone          | CloseAt               | Balance |
      | Larry Page | https://google.com | (555)-755-6575 | Jan 01, 2022 12:57 PM | 770.54  |
    Then <row_number> will be populated with data above

    Examples:
      | component | path                                                    | component_type             | row_number |
      | component | Lightning Web Components>Components>lightning>datatable | Datatable from Inline Edit | 3          |
      