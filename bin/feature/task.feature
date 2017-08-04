
Feature: Tasks
Description: This feature is to test the Tasks functionality so that users can manage their tasks

Scenario: My Tasks link should be visible when the user is logged in
Given User is signed in to the homepage
Then I can see the My Tasks link on NavBar
And I can click on My Tasks link
Then I am navigated to Tasks page
	
Scenario: My Tasks link should be visible when the user is not logged in
Given User is not signed in to the homepage
Then I can still see the My Tasks link on NavBar
And I am able to click on My Tasks link
Then I am navigated to Sign in page 

Scenario: User should see the correct display message on the Tasks page
Given User is signed in with valid credntials
When User is on the Tasks page
Then I should see the correct message 

Scenario: User should not be able to add task with more than 250 characters
Given User is signed with valid credentials
When I add a task with more than twofifty characters
Then The task should not be more than twofifty characters



