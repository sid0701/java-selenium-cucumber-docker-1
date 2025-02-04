Feature: Search for a keyword on Google Home

  Scenario Outline: Verify news results for a keyword searched on Google
    Given user is on Google Home Page
    When user searches for <Keyword> on Google Search Box
    And user selects <Index> suggestion
    And user clicks on <Tab_Name> Tab on Results Page
    Then user verifies that results are greater than <Count>

    Examples:
      | Keyword    | Index | Count | Tab_Name |
      | Java       | 3     | 10000 | News     |
#      | Python     | 4     | 2000  | News     |
#      | Javascript | 6     | 500   | News     |
