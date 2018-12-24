package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BaiHatDAO;

@WebServlet("/xoa-bai-hat")
public class SongDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BaiHatDAO baiHatDAO = new BaiHatDAO();

	public SongDeleteController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int ma = Integer.parseInt(request.getParameter("id"));
		

		int kq = baiHatDAO.deleteItem(ma);
		if (kq > 0) {
			response.sendRedirect(request.getContextPath() + "/bai-hat");
		} else {
			response.sendRedirect(request.getContextPath() + "/xoa-bai-hat");
		}
	}

}
