Feature: Testing marsrover business logic

  @rover @P0 @initialization
  Scenario Outline: Test the marsrover
    Given rover is initialized
    Then rover is on the <x_cordinate>, <y_cordinate> cordinates
    Examples: provided valid and invalid input
      | x_cordinate | y_cordinate |
      | 0           | 0           |


