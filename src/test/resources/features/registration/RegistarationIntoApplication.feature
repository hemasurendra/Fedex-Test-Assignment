Feature: Verify registration Module is working as expected


  @Regression
  Scenario Outline: Verify user registration process is successful
    Given A user is accessing Fedex portal
    When he attempts register with <userType> details for <countryCode>
    Then user <registrationStatus> successfully registered
    Examples:
      |  userType  |  countryCode | registrationStatus|
      | valid      |   NL         | is                |
      | invalid    |   GB         | is not            |