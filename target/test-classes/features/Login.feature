# Author: sagar.raipurkar@techspian.com
# Keywords Summary: Login functionality, valid credentials, status code verification

@login
Feature: Verify the login functionality	

Scenario Outline: User is not able to log in with an invalid emailId
Given The user provides the login payload with an invalid "<userEmail>" but with an correct "<userPassword>"
  When The user sends a "POST" HTTP request to the "LoginpathApi"
Then The system should return a 400 Unauthorized status code
And The system should return an appropriate error message such as "Incorrect email or password."

Examples:
			| userEmail 					 | userPassword |
			| John1@mailinator.com | Sagar@91			 | 
			
Scenario Outline: User is not able to log in with an incorrect password
Given The user provides the login payload with a valid "<userEmail>" but an incorrect "<userPassword>"
  When The user sends a "POST" HTTP request to the "LoginpathApi"
Then The system should return a 400 Unauthorized status code
And The system should return an appropriate error message such as "Incorrect email or password."

Examples:
			| userEmail 					 | userPassword |
			| John@mailinator.com | Sagar@911		 | 
			
Scenario Outline: User is able to log in with valid credentials
Given The user provides the login payload with "<userEmail>" "<userPassword>"
    When The user sends a "POST" HTTP request to the "LoginpathApi"
    Then The system should return a valid status code
Examples:
			| userEmail 					 | userPassword |
			| John@mailinator.com  | Sagar@91 |
			
			
#Scenario: Verify the user is able to add a product with authorization
    #Given The user provides the payload
    #When The user sends a "POST" HTTP request to the "AddToCartpathApi"
    #Then The system should return a 200 status code