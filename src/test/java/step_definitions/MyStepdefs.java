package step_definitions;

import common.utils.TestData;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import pages.DemoPageContainer;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Iterator;

public class MyStepdefs {

    private DemoPageContainer demoPageContainer;

    public MyStepdefs(DemoPageContainer demoPageContainer) {
        this.demoPageContainer = demoPageContainer;
    }

    @Given("^I launch the task url$")
    public void i_launch_the_task_url() throws Throwable {
        demoPageContainer.todopage.visitPage();
    }

    @When("^click active link$")
    public void click_active_link() throws Throwable {
        demoPageContainer.todopage.clicklinks();
    }

    @Then("^Add task details should be displayed$")
    public void add_task_details_should_be_displayed() throws Throwable {
        demoPageContainer.todopage.validatelinks();
    }

    @And("^I add the task details \"([^\"]*)\" in todo field$")
    public void i_add_the_task_details_something_in_todo_field(String taskdetails) throws Throwable {
        demoPageContainer.todopage.addtesk(taskdetails);

    }




    @When("^I delete the task from todos page$")
    public void i_delete_the_task_from_todos_page() throws Throwable {
     demoPageContainer.deletingtask.clickactive();
     demoPageContainer.deletingtask.deleteactivetask();
    }

    @When("^I delete the all task from todos page$")
    public void i_delete_the_all_task_from_todos_page() throws Throwable {
        demoPageContainer.deletingtask.deletealltask();
    }


    @Then("^Deleted task should not be display$")
    public void deleted_task_should_not_be_display() throws Throwable {
        throw new PendingException();
    }

    @And("^i select all task$")
    public void i_select_all_task() throws Throwable {
        demoPageContainer.deletingtask.addtask();
       demoPageContainer.deletingtask.selectalltask();
    }


    @When("^I clear completed task$")
    public void i_clear_completed_task() throws Throwable {
        demoPageContainer.cleartask.cleacompleted();

    }

    @Then("^All task should be cleared from the list$")
    public void all_task_should_be_cleared_from_the_list() throws Throwable {
        throw new PendingException();
    }

    @And("^I select all completed task$")
    public void i_select_all_completed_task() throws Throwable {
        demoPageContainer.cleartask.selectcompletetask();
    }



}
