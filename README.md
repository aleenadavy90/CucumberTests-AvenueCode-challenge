This project automates the ToDo App Tasks functionality using Selenium Webdriver with Java, Cucumber and Junit framework.

### How to define features ###

The cucumber features goes in the features library and should have the ".feature" extension.
Look at features/mytask.feature. 
eg: 
Scenario: My Tasks link should be visible when the user is logged in
Given I am signed in as a user
Then I can see the My Tasks link on NavBar
And I can click on My Tasks link
Then I am navigated to Tasks page

### framework used ###

selenium-cucumber-Java with Junit framework.

selenium-cucumber is a behavior driven development (BDD) approach to write automation test script to test Web.

### Running the test ###

To run the tests simply run the TestRun.java file as Junit test which exists in the tests package.
It defines where the stepdefinition and features exists

