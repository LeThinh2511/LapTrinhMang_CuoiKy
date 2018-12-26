package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Book;
import model.dao.BookDAO;

/**
 * Servlet implementation class ModifyBookController
 */
@WebServlet("/ModifyBookController")
public class ModifyBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO bookDAO = new BookDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyBookController() {
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
		if (request.getParameter("id") != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			Book book = bookDAO.getItem(id);
			request.setAttribute("book", book);
			request.getRequestDispatcher("ModifyBook.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html");
		int idBook = Integer.parseInt(request.getParameter("idBook"));
		String name = request.getParameter("name");
		Book book = bookDAO.getItem(idBook);
		if (book != null) {
			book.setName(name);
			bookDAO.editItem(book);
			response.sendRedirect(request.getContextPath() + "/bookList");
		}
	}

}
