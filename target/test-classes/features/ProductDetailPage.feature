Feature: Product detail page functionality

  Background: User LogIn
    Given User is on the login page
    Then User enters username and password
    Then User is successfully logged in


  Scenario Outline: User can add a product to the basket from PDP
    Given User is on the Products page
    And User opens "<product>" detailed page
    Then User adds "<product>" to the basket
    And The basket count should be <basket_count>
    Examples:
      | product  | basket_count |
      | Backpack | 1            |

  Scenario Outline: User can remove a product from PDP
    Given User is on the Products page
    And User opens "<product>" detailed page
    Then User adds "<product>" to the basket
    Then User removes "<product>" from the basket
    And The basket count should be <basket_count>

    Examples:
      | product  | basket_count |
      | Backpack | 0            |