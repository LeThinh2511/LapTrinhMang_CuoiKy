package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Book;
import model.dao.BookDAO;

/**
 * Servlet implementation class AddNewBookController
 */
@WebServlet("/AddNewBookController")
public class AddNewBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookDAO bookDAO = new BookDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewBookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user") == null) {
			response.sendRedirect("Login.jsp");
			return;
		}
		request.getRequestDispatcher("AddNewBook.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html");
		String name = request.getParameter("name");
		Book newBook = new Book();
		newBook.setName(name);
		newBook.setDateAdded(new Date(System.currentTimeMillis()));
		bookDAO.addItem(newBook);
		response.sendRedirect(request.getContextPath() + "/bookList");
	}

}
