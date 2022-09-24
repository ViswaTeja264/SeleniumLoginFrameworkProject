Feature: Application Login

Scenario: Login with valid credentials
Given Open any Browser
And Navigate to Login page
When User enters email as "viswateja209@gmail.com" and password as "@Viswa264" into the fields
And User clicks on Login button
Then Verify user is able to login based on Expected login credentials
	