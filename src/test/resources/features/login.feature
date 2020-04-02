Feature: Salesforce Lightning Web Components

  Scenario: User can edit a datatable inline
    Given I navigate to Salesforce Developer page
    When I select component from the left nav
      | component | path                                                    |
      | datatable | Lightning Web Components>Components>lightning>datatable |
    And I open example "with Inline Edit" in Playground
    And I edit row 3 in preview pane
      | Label      | Website            | Phone          | CloseAt               | Balance |
      | Larry Page | https://google.com | (555)-755-6575 | Jan 1, 2022-12:57 PM | 770.54  |
    Then Row will be populated with data above
      