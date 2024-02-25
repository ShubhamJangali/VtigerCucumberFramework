@regression
Feature: Create Lead Functionality

@TC_02
Scenario: ValidLogin_TC_02
Given user should be on login page
When user enters valid credentials and theme
And click on login button
Then user should be on home page
And user can see logout option
Then click on logout Button

@TC_03
Scenario: Valid_Login1_TC01
Given user should be on login page
When user enters valid credentials
And click on login button
Then user should be on home page
And Click on NewLead

@TC_04
Scenario: New_Lead_TC_01
Given user should be on New Lead page
When user enter last name 
And click on save button
Then click ok in alert


