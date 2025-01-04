Feature: Open Google Map
Background: Common steps for all scenarios
  Given User Lunch Chrome browser
  When User open URL "https://www.google.com/maps/"

  Scenario: Opening Google Map
    Then Page Title Should be "Google Maps"
    When User click on search button and search as "bengaluru airport"
    And Close browser

  Scenario: Searching destination
    When User click on search button and search as "bengaluru airport"
    Then the user should see "Kempegowda International Airport Bengaluru" in the search results
    And Close browser

  Scenario: User gets directions between two locations
    Given the user click on direction button
    When the user enters "Bengaluru Airport" as the starting location
    And enters "MG Road Bengaluru" as the destination
    And clicks on driving icon
    Then the map should display the route between the two locations
    And the estimated travel time and distance should be shown






