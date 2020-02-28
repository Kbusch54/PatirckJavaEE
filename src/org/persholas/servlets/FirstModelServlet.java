package org.persholas.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.perscholas.models.Department;
import org.perscholas.models.DepartmentService;

/**
 * Servlet implementation class FirstModelServlet
 */
@WebServlet("/FirstModelServlet")
public class FirstModelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Department> dep = DepartmentService.showAllDepartList();
		String name = request.getParameter("name");
		String state = request.getParameter("state");

		request.setAttribute("newDept", false);
		for (Department department : dep) {
			if (department.getName().equals(name) && department.getState().equals(state)) {
				request.setAttribute("newDept", true);
				break;
			}
		}
		DepartmentService.close();

		String welcome = "Welcome to my JSP page!";
		request.setAttribute("welcomes", welcome);
		String goodUser = "Kevin";
		String goodPass = "XXXXX";
		String justForFun = "Yippee!!";

		request.setAttribute("user", goodUser);
		request.setAttribute("pass", goodPass);
		request.setAttribute("fun", justForFun);

	}

}