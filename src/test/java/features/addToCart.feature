# Author: your.email@your.domain.com
# Keywords Summary:

Feature: Verify the user is able to add a product to the cart

  Scenario: Verify the user is able to add a product with authorization
    Given The user provides the payload
    When The user sends a "POST" HTTP request method to the  "AddToCartpathApi"
    Then The system should return a 200 status code