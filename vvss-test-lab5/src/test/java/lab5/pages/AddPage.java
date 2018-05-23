package lab5.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.ArrayList;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

@DefaultUrl("http://localhost:8080/AddServlet.html")
public class AddPage extends PageObject {

    @FindBy(name="first_name")
    private WebElementFacade firstName;

    @FindBy(name="last_name")
    private WebElementFacade lastName;

    @FindBy(name="cnp")
    private WebElementFacade cnp;

    @FindBy(name="salary")
    private WebElementFacade salary;

    @FindBy(name="addBtn")
    private WebElementFacade addBtn;


    public void enter_keywords(String firstName, String lastName, String cnp, String salary) {
        this.firstName.type(firstName);
        this.lastName.type(lastName);
        this.cnp.type(cnp);
        this.salary.type(salary);
    }

    public void addEmployee() {
        addBtn.click();
    }

    public List<String> getResult() {
        WebElementFacade definitionList = find(By.id("res"));
        String text = definitionList.getText();
        List<String> list = new ArrayList<>();
        list.add(text);
        return list;
    }
}
