@Assignment
Feature: Create Lead Functionality

@TC_02
Scenario: Theme_Selection
Given user should be on login page
When user enters valid credentials and theme
And click on login button
Then user should be on home page
And user can see logout option
Then click on logout Button

@TC_04
Scenario: Alert
Given user should be on New Lead page
When user enter last name 
And click on save button
Then click ok in alert

@TC_05
Scenario: Activity_01
Given user should be on login page
When user enters valid credentials
And click on login button
Then user should be on home page
And move mouse to showmenu
Then click on New Vendor


