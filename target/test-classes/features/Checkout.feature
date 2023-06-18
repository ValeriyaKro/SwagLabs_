Feature: Checkout functionality

  Background: User LogIn
    Given User is on the login page
    Then User enters username and password
    Then User is successfully logged in


  Scenario Outline: Placing an order
    Given User is on the Products page
    When User adds "<productName>" to the basket
    And User is on basket page and proceeds with checkout
    Then the user enters "<firstName>", "<lastName>" and "<postalCode>"
    Then User verifies "<productName>" on the payment page
    And User verifies payment information as "<paymentInfo>"
    And User verifies shipping information as "<shippingInfo>"
    And User verifies price total as "<itemTotal>", "<tax>", "<total>"
    Then after payment "Thank you for your order!" message is displayed

    Examples:

      | productName                            | firstName | lastName | postalCode | paymentInfo      | shippingInfo                | itemTotal                       | tax        | total          |
      | T-Shirt (Red), Bolt T-Shirt            | John      | Doe      | 12345      | SauceCard #31337 | Free Pony Express Delivery! | Item total: $31.98              | Tax: $2.56 | Total: $34.54  |
      | Onesie, Bolt T-Shirt, Backpack, Jacket | Tom       | Kings    | 75686      | SauceCard #31337 | Free Pony Express Delivery! | Item total: $103.96000000000001 | Tax: $8.32 | Total: $112.28 |