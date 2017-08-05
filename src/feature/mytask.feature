
Feature: Tasks
Description: This feature is to test the Tasks functionality so that users can manage their tasks

Scenario: My Tasks link should be visible when the user is logged in
Given I am signed in as a user
Then I can see the My Tasks link on NavBar
And I can click on My Tasks link
Then I am navigated to Tasks page
	
Scenario: My Tasks link should be visible when the user is not logged in
Given I am not signed in as a user
Then I can still see the My Tasks link on NavBar
And I am able to click on My Tasks link
Then I am navigated to Sign in page 

Scenario: User should see the correct display message on the Tasks page
Given I am signed in as a valid user
When I am on the Tasks page
Then I should see the correct message 

Scenario: User should not be able to add task with more than 250 characters
Given I am signed in as a user with valid credentials
When I add a task with more than twofifty characters
Then The added task should not be more than twofifty characters

Scenario: User should be able to enter a task correctly
Given I am on the My Tasks page
When I hit enter on a valid task
And I click on the add button
Then The task should be entered
But I should not be able to enter an empty task



