package servlets;

import controller.EmployeeController;
import model.DidacticFunction;
import model.Employee;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryInterface;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    private EmployeeController ctrl;

    @Override
    public void init() throws ServletException {
        EmployeeRepositoryInterface repo = new EmployeeRepository();
        ctrl = new EmployeeController(repo);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        String cnp = req.getParameter("cnp");
        DidacticFunction didacticFunction = DidacticFunction.ASISTENT;
        Integer salary = Integer.parseInt(req.getParameter("salary"));

        RequestDispatcher rd = req.getRequestDispatcher("/success.jsp");
        HttpSession session = req.getSession();

        try{
            ctrl.addEmployee(new Employee(firstName, lastName, cnp, didacticFunction, salary));
            session.setAttribute("result","Added");
        }catch(Exception e) {
            session.setAttribute("result", "Not added");
        }
        rd.forward(req,resp);
    }
}
