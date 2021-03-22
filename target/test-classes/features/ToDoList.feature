Feature: Todo List

  Scenario: 1 Verify that item can be added to the to-do list
    Given Empty ToDo list
    When I write "buy some milk" to textBox and press ENTER
    Then I should see "buy some milk" item in ToDo list

  Scenario: 2 Verify that items can be added to the to-do list
    Given ToDo list with "buy some milk" item
    When I write "enjoy the assignment" to textBox and press ENTER
    Then I should see "enjoy the assignment" item insterted to ToDo list below "buy some milk" item

  Scenario: 3 Verify that the item on the to-do list has been done
    Given ToDo list with "buy some milk" item
    When I click on checkBox next to "buy some milk" item
    Then I should see "buy some milk" item marked as DONE

  Scenario: 4 Verify that the item on the to-do list has been undone
    Given ToDo list with marked item
    When I click on checkBox next to item
    Then I should see "buy some milk" item marked as UNDONE

  Scenario: 5 Verify that the item in the to-do list can be deleted
    Given ToDo list with "rest for a while" item
    When I click on deleteButton next to "rest for a while" item
    Then List should be empty

  Scenario: 6 Verify that only one item in the to-do list can be deleted
    Given ToDo list with "rest for a while" and "drink water" item in order
    When I click on deleteButton next to "rest for a while" item
    Then I should see "drink water" item in ToDo list

