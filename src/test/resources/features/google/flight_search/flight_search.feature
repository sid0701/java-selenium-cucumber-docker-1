Feature: Verify Flight Search Page

  @FlightSearch
  Scenario Outline: Verify Navigation Tab Labels
    Given user is on Google Flight Search <Language> Language Page
    Then user verifies the actual navigation tab labels are same as <Tab Label>

    Examples:
      | Language  | Tab Label                                          |
      | English   | Travel; Explore; Flights; Hotels; Vacation rentals |
      | Indonesia | Perjalanan;Jelajahi;Pesawat;Hotel;Rental akomodasii |
