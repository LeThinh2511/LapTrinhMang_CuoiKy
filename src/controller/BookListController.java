package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Book;
import model.dao.BookDAO;

/**
 * Servlet implementation class BookListController
 */
@WebServlet("/BookListController")
public class BookListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookListController() {
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
		System.out.println("book list controller");
		// view
		BookDAO bookDAO = new BookDAO();
		String key = (request.getParameter("key") == null) ? "" : request
				.getParameter("key");
		int page = 0;
		int totals = bookDAO.countTotal(key);
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
		}

		ArrayList<Book> books = bookDAO.getList(key, page * 5, 5);
		System.out.println("length: " + books.size());
		for (Book book : books) {
			System.out.println(book.getIdBook());
		}
		request.setAttribute("totals", String.valueOf(totals));
		request.setAttribute("books", books);
		request.getRequestDispatcher("BookList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
