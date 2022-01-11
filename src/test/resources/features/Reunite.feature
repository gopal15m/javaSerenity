Feature: Reuninte details

  @getDetails
  Scenario Outline: Send a request to get details
    Given I send a request to the ULR <id> to get details
    Then the response status code <statuscode>
    Examples:
    |id |statuscode |
    |1 |200 |