Feature: Booking hotel search

  Background:
    Given User is on "https://www.booking.com/searchresults.en-gb.html" page with maximized browser

  Scenario Outline: Search for "<hotel>" in the Search Page
    When User types "<hotel>" in Destination input field
    Then Clicks on the "<hotel>" is the dropdown
    And Clicks on the Search button
    Then Search result consists of "<hotel>" and "<rate>"
    Examples:
      | hotel                   | rate |
      | Rixos Premium Dubai JBR | 9.1  |
      | Hilton Dubai Jumeirah   | 7.8  |