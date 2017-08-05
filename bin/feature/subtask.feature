
Feature: SubTasks
Description: This feature is to test the SubTasks functionality which makes the Tasks feature more manageable.

Scenario: User should be able to see subtasks button on the tasks page
Given I am on the MyTasks page
Then I should be able to see Manage SubTasks button
When I click on the button
Then I should see a subtask modal dialog box

Scenario: User should be able to see the number of subtasks on the button
Given I am on the MyTasks page
Then I should be able to see Manage SubTasks button
And I should see updated no of subtasks when I add/delete a subtask







