package lab5.features.search;

import lab5.steps.serenity.AddEmployeeSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "features/add/AddData.csv")
public class AddEmployee {

    @Managed(uniqueSession = true)
    private WebDriver webdriver = new ChromeDriver();

    @Steps
    private AddEmployeeSteps addEmployeeSteps;

    private String firstName;
    private String lastName;
    private String cnp;
    private String salary;

    private String result;

    @Issue("#ADD")
    @Test
    public void adding_data_should_display_the_correct_message() {
        addEmployeeSteps.is_the_home_page();
        addEmployeeSteps.adds(getFirstName(), getLastName(), getCnp(), getSalary());
        addEmployeeSteps.should_see_result(getResult());
    }

    @Qualifier
    public String getQualifier() {
        return cnp;
    }

    public WebDriver getWebdriver() {
        return webdriver;
    }

    public void setWebdriver(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public AddEmployeeSteps getAddEmployeeSteps() {
        return addEmployeeSteps;
    }

    public void setTudor(AddEmployeeSteps addEmployeeSteps) {
        this.addEmployeeSteps = addEmployeeSteps;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
