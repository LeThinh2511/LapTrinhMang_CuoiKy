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
 * Servlet implementation class PhongBanEditController
 */
@WebServlet("/tao-moi-bai-hat")
public class SongNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BaiHatDAO baiHatDAO = new BaiHatDAO();
       
    public SongNewController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user") == null) {
			response.sendRedirect("Login.jsp");
			return;
		}
		
		request.getRequestDispatcher("SongNew.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html");
		
		String ten = request.getParameter("ten");
		BaiHat newBaiHat = new BaiHat();
		newBaiHat.setTen(ten);
		newBaiHat.setNgaytao(new Date(System.currentTimeMillis()));
		baiHatDAO.addItem(newBaiHat);
		
		response.sendRedirect(request.getContextPath() + "/bai-hat");
	}

}
