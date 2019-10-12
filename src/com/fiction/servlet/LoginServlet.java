package com.fiction.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fiction.entity.AdminEntity;
import com.fiction.listener.AdminOnlineListenner;
import com.fiction.service.LoginService;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/sys/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		if(name==null&&pwd==null){
			Cookie[] cookies=request.getCookies();
			for(Cookie cookie:cookies){
				if("name".equals(cookie.getName())){
					name=URLDecoder.decode(cookie.getValue(),"UTF-8");
				}else if("pwd".equals(cookie.getName())){
					pwd=URLDecoder.decode(cookie.getValue(),"UTF-8");
				}
			}
		}
		String login=request.getParameter("login");
		LoginService ls = new LoginService();
		boolean flag = ls.login(name, pwd);
		if(flag){
			HttpSession session=request.getSession();
			List<AdminEntity> list = ls.AllAdmin(name);
			String phone = null;
			String email = null;
			for(AdminEntity ad:list){
				phone = ad.getAdminphone();
				email = ad.getAdminemail();
			}
			session.setAttribute("name",name);
			session.setAttribute("phone",phone);
			session.setAttribute("email",email);
			session.setAttribute("AdminOnlineListener",new AdminOnlineListenner());
			if("ok".equals(login)){
				Cookie cookieName=new Cookie("name",URLEncoder.encode(name,"UTF-8"));
				cookieName.setMaxAge(30*24*60*60);
				cookieName.setPath("/");
				Cookie cookiePwd=new Cookie("pwd",URLEncoder.encode(pwd,"UTF-8"));
				cookiePwd.setMaxAge(30*24*60*60);
				cookiePwd.setPath("/");
				response.addCookie(cookieName);
				response.addCookie(cookiePwd);
			}
			request.getRequestDispatcher("index.jsp")
				.forward(request, response);
		}else{
			response.sendRedirect("../login.jsp");
		}
	}

}
