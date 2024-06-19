Feature: check for invalid credentials
Scenario Outline: Login with invalid credentials

Given User is on google page
When User enters username as "<email>" and "<password>"
Then Usershould not able to login
And valid details should be given by user

Examples:
|email|password|
|prashanthiankam@gmail.com|12345|