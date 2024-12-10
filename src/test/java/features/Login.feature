# Author: sagar.raipurkar@techspian.com
# Keywords Summary: Login functionality, valid credentials, status code verification

Feature: Verify the login functionality

  Scenario: User is able to log in with correct credentials
    Given The user provides the login payload
    When The user sends a POST HTTP request to the Login URL
    Then The system should return a valid status code
    
     