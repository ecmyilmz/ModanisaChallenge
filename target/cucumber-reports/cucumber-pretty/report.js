$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("classpath:features/ToDoList.feature");
formatter.feature({
  "name": "Todo List",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "1 Verify that item can be added to the to-do list",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Empty ToDo list",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDef.empty_todo_list()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I write \"buy some milk\" to textBox and press ENTER",
  "keyword": "When "
});
formatter.match({
  "location": "StepDef.i_write_something_to_and_press(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see \"buy some milk\" item in ToDo list",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDef.i_should_see_something_item_in_todo_list(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "2 Verify that items can be added to the to-do list",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "ToDo list with \"buy some milk\" item",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDef.todo_list_with_something_item(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I write \"enjoy the assignment\" to textBox and press ENTER",
  "keyword": "When "
});
formatter.match({
  "location": "StepDef.i_write_something_to_and_press(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see \"enjoy the assignment\" item insterted to ToDo list below \"buy some milk\" item",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDef.i_should_see_something_item_insterted_to_todo_list_below_something_item(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "3 Verify that the item on the to-do list has been done",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "ToDo list with \"buy some milk\" item",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDef.todo_list_with_something_item(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on checkBox next to \"buy some milk\" item",
  "keyword": "When "
});
formatter.match({
  "location": "StepDef.i_click_on_next_to_something_item(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see \"buy some milk\" item marked as DONE",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDef.i_should_see_something_item_marked_as_done(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "4 Verify that the item on the to-do list has been undone",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "ToDo list with marked item",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDef.todo_list_with_marked_item()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on checkBox next to item",
  "keyword": "When "
});
formatter.match({
  "location": "StepDef.i_click_on_next_to_item(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see \"buy some milk\" item marked as UNDONE",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDef.i_should_see_something_item_marked_as_undone(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "5 Verify that the item in the to-do list can be deleted",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "ToDo list with \"rest for a while\" item",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDef.todo_list_with_something_item(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on deleteButton next to \"rest for a while\" item",
  "keyword": "When "
});
formatter.match({
  "location": "StepDef.i_click_on_next_to_something_item(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "List should be empty",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDef.list_should_be_empty()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "6 Verify that only one item in the to-do list can be deleted",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "ToDo list with \"rest for a while\" and \"drink water\" item in order",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDef.todo_list_with_something_and_something_item_in_order(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on deleteButton next to \"rest for a while\" item",
  "keyword": "When "
});
formatter.match({
  "location": "StepDef.i_click_on_next_to_something_item(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see \"drink water\" item in ToDo list",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDef.i_should_see_something_item_in_todo_list(String)"
});
formatter.result({
  "status": "passed"
});
});