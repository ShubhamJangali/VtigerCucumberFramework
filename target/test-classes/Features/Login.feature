Feature: Login Functionality

Background:
Given user should be on login page

@TC_01
Scenario: Valid_Login1_TC01
When user enters valid credentials
And click on login button
Then user should be on home page
And user can see logout option
Then click on logout Button

@TC_02
Scenario: Valid_Login1_TC01
Given user should be on login page
When user enters valid credentials
And click on login button
Then user should be on home page
And Click on NewLead

@TC_03
Scenario: Valid_Login2_TC02
When user enters valid credentials
And click on login button
Then user should be on home page
And user can see logout option

@TC_04
Scenario: Valid_Login3_TC03
When user enters valid credentials userid "<user_id>" and password "<password>"
|TCID | user_id | password |
|TCID 1 | admin1 | pass1|
|TCID 2| admin2 | pass2|
And click on login button
Then user should be on home page
And user can see logout option

@TC_05
Scenario Outline: Valid_Login3_<TCID>
When user enters valid credentials userid as "<user_id>" and password as "<password>"
And click on login button
Then user should be on home page
And user can see logout option
Then click on logout Button
Examples:
|TCID | user_id | password |
|TCID 1 | admin1 | pass1|
|TCID 2| admin2 | pass2|
