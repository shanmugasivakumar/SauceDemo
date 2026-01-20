Feature: Add highest priced product to cart

  Scenario: User adds highest priced product to cart
    Given user is logged in
    When user adds the highest priced product to the cart
    Then cart should show 1 item
    And highest priced product should be present in the cart
