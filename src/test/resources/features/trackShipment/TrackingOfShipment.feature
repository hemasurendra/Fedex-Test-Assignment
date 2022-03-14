Feature: Verify Tracking of shipment is working as expected

  @Regression
  Scenario: Verify user can track the shipment from home page
    Given A user is accessing Fedex portal
    When he attempts to search for invalid shipment using tracking number 123456 from HomePage
    Then tracking error message is displayed

  @Regression
  Scenario: Verify user can track the shipment from searchOption
    Given A user is accessing Fedex portal
    When he attempts to search for invalid shipment using tracking number 123456 from Search Option
    Then tracking error message is displayed


  @Regression
  Scenario: Verify user can track the shipment from MenuBar
    Given A user is accessing Fedex portal
    When he attempts to search for invalid shipment using tracking number 123456 from MenuBar
    Then tracking error message is displayed