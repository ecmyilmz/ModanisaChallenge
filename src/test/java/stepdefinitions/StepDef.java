package stepdefinitions;

import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.w3c.dom.html.HTMLDOMImplementation;

import java.io.IOException;
import java.util.Properties;

public class StepDef {

    @Given("^Empty ToDo list$")
    public void empty_todo_list() throws Throwable {
        HomePage.EmptyToDoList();
    }

    @Given("^ToDo list with \"([^\"]*)\" item$")
    public void todo_list_with_something_item(String strArg) throws Throwable {
       HomePage.WriteItem(strArg);
       HomePage.VerifyItem(strArg);

    }

    @Given("^ToDo list with marked item$")
    public void todo_list_with_marked_item() throws Throwable {
      HomePage.WriteItem("buy some milk");
      HomePage.VerifyItem("buy some milk");
      HomePage.ClickButton("checkBox" , "buy some milk");
      HomePage.VerifyDone("buy some milk");
    }

    @Given("^ToDo list with \"([^\"]*)\" and \"([^\"]*)\" item in order$")
    public void todo_list_with_something_and_something_item_in_order(String strArg1, String strArg2) throws Throwable {
        HomePage.WriteItem(strArg1);
        HomePage.WriteItem(strArg2);
        
    }

    @When("^I write \"([^\"]*)\" to ([^\"]*) and press ([^\"]*)$")
    public void i_write_something_to_and_press(String strArg1, String strArg2, String strArg3) throws Throwable  {
        HomePage.WriteItem(strArg1);
    }

    @When("^I click on (.+) next to \"([^\"]*)\" item$")
    public void i_click_on_next_to_something_item(String strArg1, String strArg2) throws Throwable {
        HomePage.VerifyItem(strArg2);
        HomePage.ClickButton(strArg1, strArg2);
    }

    @When("^I click on (.+) next to item$")
    public void i_click_on_next_to_item( String strArg1) throws Throwable {
        HomePage.ClickButton(strArg1 , "buy some milk");
    }

    @Then("^I should see \"([^\"]*)\" item in ToDo list$")
    public void i_should_see_something_item_in_todo_list(String strArg1) throws Throwable {
        HomePage.VerifyItem(strArg1);

    }

    @Then("^I should see \"([^\"]*)\" item insterted to ToDo list below \"([^\"]*)\" item$")
    public void i_should_see_something_item_insterted_to_todo_list_below_something_item(String strArg1, String strArg2) throws Throwable {
        HomePage.VerifySecondItem(strArg1, strArg2);
    }

    @Then("^I should see \"([^\"]*)\" item marked as DONE$")
    public void i_should_see_something_item_marked_as_done(String strArg1) throws Throwable {
       HomePage.VerifyDone(strArg1);
    }

    @Then("^I should see \"([^\"]*)\" item marked as UNDONE$")
    public void i_should_see_something_item_marked_as_undone(String strArg1) throws Throwable {
       HomePage.VerifyUndone(strArg1);
    }

    @Then("^List should be empty$")
    public void list_should_be_empty() throws Throwable {
        HomePage.EmptyToDoList();
    }

}
