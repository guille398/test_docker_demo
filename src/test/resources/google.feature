@SmokeTest
Feature: Selenium Test
  As a client, I want to test the RESTool App

  Scenario Outline: Add a Character at the list
  	Given a Chrome browser navigates to Search page https://dsternlicht.github.io/RESTool/#/characters?search=
    When I click on +Add Item
    And I enter a valid data: <THUMBNAIL>, <NAME>, <REAL NAME>, <LOCATION>, <ALIVE>
    And I click on Submit Item
    And  I type on search box the value <NAME>
    And I click on Search Submit
    Then the app shows a card which includes the name <NAME>, the real name <REAL NAME>, and current location <LOCATION>

    Examples:
      | THUMBNAIL      | NAME      | REAL NAME  | LOCATION      | ALIVE  |
      | THUMBNAIL TEST | Robert B  | Chespirito | Kings Landing |   NO   |

  Scenario: Search an existing Character at the list
  	Given a Chrome browser navigates to Search page https://dsternlicht.github.io/RESTool/#/characters?search=
    When I type on search box the value Robert B
    And I click on Search Submit
    Then the app shows a card which includes the name Robert B, the real name Chespirito, and current location Kings Landing


  Scenario: Delete an existing Character at the list
  	Given a Chrome browser navigates to Search page https://dsternlicht.github.io/RESTool/#/characters?search=
    When I type on search box the value Robert B
    And I click on Search Submit
    And I click on Delete button
    Then I check than Robert B don't exist anymore

