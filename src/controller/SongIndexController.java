package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BaiHat;
import model.dao.BaiHatDAO;

/**
 * Servlet implementation class PhongBanIndexController
 */
@WebServlet("/bai-hat")
public class SongIndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SongIndexController() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user") == null) {
			response.sendRedirect("Login.jsp");
			return;
		}

		// view
		BaiHatDAO baiHatDAO = new BaiHatDAO();
		String key = (request.getParameter("key") == null) ? "" : request
				.getParameter("key");
		int page = 0;
		int totals = baiHatDAO.countTotal(key);
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
		}

		ArrayList<BaiHat> items = baiHatDAO.getList(key, page * 5, 5);
		System.out.println("length: " + items.size());
		for (BaiHat pb : items) {
			System.out.println(pb.getMa());
		}
		request.setAttribute("totals", String.valueOf(totals));
		request.setAttribute("items", items);
		request.getRequestDispatcher("SongIndex.jsp").forward(request,
				response);
		return;
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
