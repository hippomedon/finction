package com.fiction.servlet;

import java.sql.Connection;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiction.entity.AdminEntity;
import com.fiction.service.AdminService;

/**
 * Servlet implementation class adminServlet
 */
@WebServlet("/sys/admin/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Object getAlladmin;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
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
		AdminService as = new AdminService();
		if("getAlladmin".equals(flag)){
			getAlladminByPage(request, response, as);
		}else if("deleteadmin".equals(flag)){
			int admin_id=Integer.parseInt(request.getParameter("id"));
			as.deleteadmin(admin_id);
			response.sendRedirect("AdminServlet?page=1&flag=getAlladmin");
		}else if("getlikeadmin".equals(flag)){
			String like = request.getParameter("like"); 
			int page=Integer.parseInt(request.getParameter("page"));
			String name = request.getParameter("name");
			int count = as.getlikecount(name);
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
				List<AdminEntity> list = as.getLikeadmin(page,name);
				request.setAttribute("name", name);
				request.setAttribute("like", like);
				request.setAttribute("page", page);
				request.setAttribute("list", list);
				request.setAttribute("pageNum", pageNum);
				request.setAttribute("count", count);
				request.getRequestDispatcher("index.jsp")
				.forward(request, response);
			}else{
				count =0;
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
			
		}else if("detall".equals(flag)){
			String[] ids = request.getParameterValues("check");
			as.datall(ids);
			getAlladminByPage(request, response, as);
		}else if ("addadmin".equals(flag)) {
			String name = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			String email = request.getParameter("email");
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			String time = request.getParameter("time");
			as.addadmin(name, pwd, email, gender, phone, time);
			PrintWriter out = response.getWriter();       
	        out.println("<script>window.open ('"+request.getContextPath()+"/sys/admin/AdminServlet?flag=getAlladmin','_parent')</script>");
			/*getAlladminByPage(request, response, as);*/
		}else if("adminedit".equals(flag)){
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			String email = request.getParameter("email");
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			String time = request.getParameter("time");
			as.editadmin(id, name, pwd, email, gender, phone, time);
			PrintWriter out = response.getWriter();       
	        out.println("<script>window.open ('"+request.getContextPath()+"/sys/admin/AdminServlet?flag=getAlladmin','_parent')</script>");
			/*getAlladminByPage(request, response, as);*/
		}else if("getalladminById".equals(flag)){
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			String time = request.getParameter("time");
			request.setAttribute("id", id);
			request.setAttribute("name", name);
			request.setAttribute("email", email);
			request.setAttribute("gender", gender);
			request.setAttribute("phone", phone);
			request.setAttribute("time", time);
			request.getRequestDispatcher("admin-edit.jsp").forward(request, response);
		}else if("detalladmins".equals(flag)){
			String idAll = request.getParameter("idAll");
			if(idAll!=""){   //是否选择为空
				String[] id = idAll.split(",");//用逗号切割
				for(int i=0;i<id.length;i++){
					as.datall(id);//根据id删除
				}
				request.getRequestDispatcher("AdminServlet?flag=getAlladmin").forward(request, response);
			}else{
				request.getRequestDispatcher("AdminServlet?flag=getAlladmin").forward(request, response);
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
	protected void getAlladminByPage(HttpServletRequest request, HttpServletResponse response, AdminService as) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page=1;
		if(request.getParameter("page")!=null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		int count = as.getcount();
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
		List<AdminEntity> list = as.getAlladmin(page);
		request.setAttribute("page", page);
		request.setAttribute("list", list);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("count", count);
		request.getRequestDispatcher("index.jsp")
		.forward(request, response);
	}

}
