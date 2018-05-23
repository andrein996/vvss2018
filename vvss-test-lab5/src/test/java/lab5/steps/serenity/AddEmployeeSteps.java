package lab5.steps.serenity;

import lab5.pages.AddPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class AddEmployeeSteps {

    AddPage page;

    @Step
    public void enters(String firstName,String lastName, String cnp, String salary) {
        page.enter_keywords(firstName, lastName, cnp, salary);
    }

    @Step
    public void starts_adding() {
        page.addEmployee();
    }

    @Step
    public void should_see_result(String definition) {
        assertThat(page.getResult(), hasItem(containsString(definition)));
    }

    @Step
    public void is_the_home_page() {
        page.open();
    }

    @Step
    public void adds(String firstName,String lastName, String cnp, String salary) {
        enters(firstName, lastName, cnp, salary);
        starts_adding();
    }

}
