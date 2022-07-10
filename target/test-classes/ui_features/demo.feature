Feature: Test Scenario



      @TC01
      Scenario Outline: Add the task details
            Given I launch the task url
            And I add the task details "<Taskdetails>" in todo field
            When click active link
            Then Add task details should be displayed

            Examples:
                  | Taskdetails             |
                  | Add customer details1    |
                  | Activate post paid line1 |
                  | Activate pre paid line1  |


      @TC02
      Scenario: Deleting the added active task details
            Given I launch the task url
            And I add the task details "added customer profile" in todo field
            When I delete the task from todos page
            Then Deleted task should not be display

      @TC03
      Scenario: Deleting completed task from the list
            Given I launch the task url
            And I add the task details "Add customer details1" in todo field
            And i select all task
            When I delete the all task from todos page
            Then Deleted task should not be display


      @TC04

      Scenario: Cleare complete Task
            Given I launch the task url
            And I add the task details "Add customer details1" in todo field
            And I select all completed task
            When I clear completed task
            Then All task should be cleared from the list









