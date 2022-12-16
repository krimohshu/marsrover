@rover
Feature: Testing marsrover business logic

  @P0 @initialization
  Scenario Outline: Test the marsrover
    Then "GET" rover is on the <x_cordinate>, <y_cordinate> cordinates facing <facing>
    Examples: provided valid and invalid input
      | x_cordinate | y_cordinate | facing |
      | 0           | 0           | 1      |

  @P0 @moving_rover
  Scenario Outline: Test the marsrover
    When "SET" rover is on the <x_cordinate>, <y_cordinate> cordinates facing <facing>
    And rover process the command "<command>"
    Then "GET" rover is on the <x_new_cordinate>, <y_new_cordinate> cordinates facing <new_facing>
    Examples: provided valid and invalid input
      | x_cordinate | y_cordinate | facing | command   | x_new_cordinate | y_new_cordinate | new_facing |
      | 3           | 3           | 1      | LMLMLMLMM | 3               | 4               | 1          |


  @P1 @moving_rover
  Scenario Outline: Test the marsrover
    Given rover is initialized 5 and 5
    When "SET" rover is on the <x_cordinate>, <y_cordinate> cordinates facing <facing>
    And rover process the command "<command>"
    Then "GET" rover is on the <x_new_cordinate>, <y_new_cordinate> cordinates facing <new_facing>
    Examples: provided valid and invalid input
      | x_cordinate | y_cordinate | facing | command   | x_new_cordinate | y_new_cordinate | new_facing |
      | 1           | 2           | 1      | LMLMLMLMM | 1               | 3               | 1          |