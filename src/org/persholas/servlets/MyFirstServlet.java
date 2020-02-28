package org.persholas.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyFirstServlet
 */
@WebServlet("/MyFirstServlet")
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyFirstServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		
		request.setAttribute("fName", firstname);
		request.setAttribute("lName", lastname);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/FirstModelServlet");
		rd.include(request, response);
		String welcome = "Welcome to my JSP page!";
		request.setAttribute("welcomes", welcome);
		
		if((boolean)request.getAttribute("newDept")) {
			rd = getServletContext().getRequestDispatcher("/index.jsp");
			rd.forward(request, response);	
		} else {
			rd = getServletContext().getRequestDispatcher("/invalidLogin.jsp");
			rd.forward(request, response);	
		}
		
		

		/*
		 * PrintWriter reWriter = response.getWriter();
		 * reWriter.print("<HTML><HEAD><style>\r\n" +
		 * "@keyframes twoD {from { transform:rotatey(0deg);\r\n" + "	\r\n" + "}\r\n"
		 * + "\r\n" + "to {\r\n" + "	transform: rotatey(180deg);\r\n" + "}\r\n" +
		 * "\r\n" + "}\r\n" + ".animation-2d {\r\n" + "	animation-name: twoD;\r\n" +
		 * "	animation-duration: 10s;\r\n" + "	width: 200px;\r\n" +
		 * "	height: 200px;\r\n" + "	background-color: aqua;\r\n" +
		 * "	text-align: center;\r\n" +
		 * "	animation-iteration-count: infinite;\r\n" + "}\r\n" + "\r\n" + "}\r\n" +
		 * ".wrap {\r\n" + "	perspective: 800px;\r\n" +
		 * "	perspective-origin: 50% 100px;\r\n" + "}\r\n" + "\r\n" + ".cube {\r\n" +
		 * "	position: relative;\r\n" + "	width: 200px;\r\n" +
		 * "	transform-style: preserve-3d;\r\n" + "	top: 200px;\r\n" +
		 * "	left: 200px;\r\n" + "}\r\n" + "\r\n" + ".cube div {\r\n" +
		 * "	position: absolute;\r\n" + "	width: 200px;\r\n" +
		 * "	height: 200px;\r\n" + "}\r\n" + "\r\n" + ".back {\r\n" +
		 * "	transform: translateZ(-100px) rotateY(180deg);\r\n" +
		 * "	background-color: red;\r\n" + "}\r\n" + "\r\n" + ".right {\r\n" +
		 * "	transform: rotateY(-270deg) translateX(100px);\r\n" +
		 * "	transform-origin: top right;\r\n" + "	background-color: orange;\r\n" +
		 * "}\r\n" + "\r\n" + ".left {\r\n" +
		 * "	transform: rotateY(270deg) translateX(-100px);\r\n" +
		 * "	transform-origin: center left;\r\n" + "	background-color: black;\r\n" +
		 * "}\r\n" + "\r\n" + ".top {\r\n" +
		 * "	transform: rotateX(-90deg) translateY(-100px);\r\n" +
		 * "	transform-origin: top center;\r\n" + "	background-color: yellow;\r\n" +
		 * "}\r\n" + "\r\n" + ".bottom {\r\n" +
		 * "	transform: rotateX(90deg) translateY(100px);\r\n" +
		 * "	transform-origin: bottom center;\r\n" +
		 * "	background-color: lightskyblue;\r\n" + "	\r\n" + "}\r\n" + "\r\n" +
		 * ".front {\r\n" + "	transform: translateZ(100px);\r\n" +
		 * "	background-color: blue;\r\n" + "}\r\n" + "\r\n" + ".image {\r\n" +
		 * "	height: 100%;\r\n" + "	width: 100%;\r\n" + "}\r\n" + "\r\n" +
		 * "@keyframes spin {from { transform:rotateY(0deg)rotateX(0deg);\r\n" +
		 * "	\r\n" + "}\r\n" + "\r\n" + "to {\r\n" +
		 * "	transform: rotateY(360deg) rotateX(360deg);\r\n" + "}\r\n" + "\r\n" +
		 * "}\r\n" + ".cube {\r\n" +
		 * "	animation: spin 100s infinite linear;\r\n }\r\n </style></HEAD>");
		 * reWriter.
		 * print("<Body bgcolor='red'> <font color='orange'><form action=\"/action_page.php\">\r\n"
		 * + "<H1>Enter your name if you dare</H1>" + "  First name:<br>\r\n" +
		 * "  <input type=\"text\" name=\"firstname\" value=\"John\">\r\n" +
		 * "  <br>\r\n" + "  Last name:<br>\r\n" +
		 * "  <input type=\"text\" name=\"lastname\" value=\"Smith\">\r\n" +
		 * "  <br><br>\r\n" + "  <input type=\"submit\" value=\"Submit\">\r\n" +
		 * "</form> </font>"); reWriter.print("Served at: ");
		 * reWriter.print(request.getContextPath()); reWriter.print(
		 * "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/l5sIspLfmXM\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\"></iframe>"
		 * + "				<div class=\"wrap\">\r\n" +
		 * "					<div class=\"cube\">\r\n" +
		 * "						<div class=\"front\"> </div>\r\n" +
		 * "						<div class=\"back\"></div>\r\n" +
		 * "						<div class=\"top\"></div>\r\n" +
		 * "						<div class=\"bottom\"></div>\r\n" +
		 * "						<div class=\"left\"></div>\r\n" +
		 * "						<div class=\"right\"></div>\r\n" +
		 * "					</div>\r\n" + "				</div>\r\n" +
		 * "			</div>\r\n" + "		</Body></html>");
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
