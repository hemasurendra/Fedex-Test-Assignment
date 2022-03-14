Feature: Verify calculate rate and transmit times future is working as expected


  @Regression
  Scenario Outline: Verify user is able to calculate the rate for a shipping
    Given A user is accessing Fedex portal
    When He attempts to calculate shipping price between <fromCity> and <toCity> cities
    And For a packaging <boxType> with single package
    Then Approximate rates along with delivery dates are displayed
    Examples:
    | fromCity  | toCity     | boxType        |
    | AMSTERDAM | CHENNAI    |FEDEX_10KG_BOX  |
    | AMSTERDAM | UTHRECHT   |FEDEX_BOX       |