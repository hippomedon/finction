package com.fiction.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiction.entity.UserEntity;
import com.fiction.service.UserService;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/sys/user/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		UserService us = new UserService();
		if("getAlluser".equals(flag)){
			getAlladminByPage(request, response, us);
		}else if("deleteuser".equals(flag)){
			int admin_id=Integer.parseInt(request.getParameter("id"));
			us.deleteuser(admin_id);
			response.sendRedirect("UserServlet?page=1&flag=getAlluser");
		}else if("getLikeuser".equals(flag)){
			String like = request.getParameter("like"); 
			request.setAttribute("like", like);
			String name = request.getParameter("name");
			int page=1;
			if(request.getParameter("page")!=null){
				page = Integer.parseInt(request.getParameter("page"));
			}
			int count = us.getLikecount(name);
			if(count!=0){
				int pageNum=0;
				if(count%10==0){
					pageNum=count/10;
				}else{
					pageNum=count/10+1;
				}
				if(page<1){
					page=1;
				}
				if(page>pageNum){
					page=pageNum;
				}
				List<UserEntity> list = us.getLikeuser(page,name);
				request.setAttribute("name", name);
				request.setAttribute("page", page);
				request.setAttribute("list", list);
				request.setAttribute("pageNum", pageNum);
				request.setAttribute("count", count);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else{
				count=0;
				page=1;
				int pageNum = 0;
				if(count%10==0){
					pageNum = count/10;
				}else{
					pageNum = count/10+1;
				}
				if(page<1){
					page = 1;
				}else if(page>pageNum){
					page = pageNum;
				}
				request.setAttribute("page", page);
				request.setAttribute("pageNum", pageNum);
				request.setAttribute("count", count);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}else if("detalluser".equals(flag)){
			String idAll = request.getParameter("idAll");
			if(idAll!=""){   //是否选择为空
				String[] id = idAll.split(",");//用逗号切割
				for(int i=0;i<id.length;i++){
					us.datalluser(id);//根据id删除
				}
				request.getRequestDispatcher("UserServlet?flag=getAlluser").forward(request, response);
			}else{
				request.getRequestDispatcher("UserServlet?flag=getAlluser").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void getAlladminByPage(HttpServletRequest request, HttpServletResponse response, UserService us) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page=1;
		if(request.getParameter("page")!=null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		int count = us.getcount();
		int pageNum=0;
		if(count%10==0){
			pageNum=count/10;
		}else{
			pageNum=count/10+1;
		}
		if(page<1){
			page=1;
		}
		if(page>pageNum){
			page=pageNum;
		}
		List<UserEntity> list = us.getAlluser(page);
		request.setAttribute("page", page);
		request.setAttribute("list", list);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("count", count);
		request.getRequestDispatcher("index.jsp")
		.forward(request, response);
	}

}
