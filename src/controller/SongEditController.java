package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BaiHat;
import model.dao.BaiHatDAO;

/**
 * Servlet implementation class PhongBanDetailsController
 */
@WebServlet("/chinh-sua-bai-hat")
public class SongEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BaiHatDAO baiHatDAO = new BaiHatDAO();

	public SongEditController() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user") == null) {
			response.sendRedirect("Login.jsp");
			return;
		}

		if (request.getParameter("id") != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			BaiHat baihat = baiHatDAO.getItem(id);
			request.setAttribute("item", baihat);
			request.getRequestDispatcher("SongEdit.jsp").forward(request,
					response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html");

		int ma = Integer.parseInt(request.getParameter("ma"));
		String ten = request.getParameter("ten");

		BaiHat baiHatInDb = baiHatDAO.getItem(ma);
		if (baiHatInDb != null) {
			baiHatInDb.setTen(ten);
			baiHatDAO.editItem(baiHatInDb);
			System.out.println("Da edit");

			response.sendRedirect(request.getContextPath() + "/bai-hat");
		}
	}

}
