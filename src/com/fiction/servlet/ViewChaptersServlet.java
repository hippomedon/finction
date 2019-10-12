package com.fiction.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiction.entity.ViewChapters;
import com.fiction.service.ViewChaptersService;

/**
 * Servlet implementation class ViewChaptersServlet
 */
@WebServlet("/sys/fiction/ViewChaptersServlet")
public class ViewChaptersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewChaptersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String table = request.getParameter("flag");
		/*System.out.println(flag);*/
		ViewChaptersService vcs = new ViewChaptersService();
		List<ViewChapters> listq =vcs.getAllView(table);
		request.setAttribute("listq", listq);
		request.getRequestDispatcher("zhangjie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
