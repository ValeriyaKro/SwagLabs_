Feature: Product listing functionality

  Background: User LogIn
    Given User is on the login page
    Then User enters username and password
    Then User is successfully logged in


  Scenario Outline: User can add a product to the basket
    Given User is on the Products page
    When User adds "<productName>" to the basket
    And The basket count should be <basket_count>

    Examples:
      | productName                                             | basket_count |
      | Backpack                                                | 1            |
      | Bike Light, Bolt T-Shirt                                | 2            |
      | Bolt T-Shirt, Backpack, Jacket                          | 3            |
      | Jacket, Onesie, T-Shirt (Red), Bike Light, Bolt T-Shirt | 5            |
      | Onesie                                                  | 1            |
      | T-Shirt (Red)                                           | 1            |

  Scenario Outline: User can remove a product from the basket
    Given User is on the Products page
    When User adds "<productToAdd>" to the basket
    When User removes "<productToRemove>" from the basket
    Then The Remove button for "<productToRemove>" should change back to "Add to cart"
    And The basket count should be <basket_count>

    Examples:
      | productToAdd                                            | productToRemove                   | basket_count |
      | Backpack                                                | Backpack                          | 0            |
      | Bike Light, Bolt T-Shirt                                | Bike Light                        | 1            |
      | Jacket, Onesie, T-Shirt (Red), Bike Light, Bolt T-Shirt | Onesie, T-Shirt (Red), Bike Light | 2            |


  Scenario: Check ascending sorting by name
    Given User is on the Products page
    When User clicks on 'Name (A to Z)'
    Then Products should be sorted "ascending"

  Scenario: Check descending sorting by name
    Given User is on the Products page
    When User clicks on 'Name (Z to A)'
    Then Products should be sorted "descending"


  Scenario: Check sorting by price - low to high
    Given User is on the Products page
    When User clicks on 'Price (low to high)'
    Then Products should be sorted starting by "lowest" price


  Scenario: Check sorting by highest price
    Given User is on the Products page
    When User clicks on 'Price (high to low)'
    Then Products should be sorted starting by "highest" price
