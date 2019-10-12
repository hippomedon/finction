package com.fiction.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiction.entity.WholeFiction;
import com.fiction.service.WholeFictionService;
/**
 * Servlet implementation class WholeFictionServlet
 */
@WebServlet("/sys/fiction/WholeFictionServlet")
public class WholeFictionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WholeFictionServlet() {
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
		WholeFictionService wfs = new WholeFictionService();
		if("getAllFictionPage".equals(flag)){  //查询
			int page=1;
			if(request.getParameter("page")!=null){
				page = Integer.parseInt(request.getParameter("page"));
			}
			int count = wfs.getAllCount();
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
			List<WholeFiction> list = wfs.getAllFictionPage(page);
			request.setAttribute("list", list);
			request.setAttribute("page", page);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("count", count);
			request.getRequestDispatcher("fiction-whole.jsp").forward(request, response);
		}else if("addFiction".equals(flag)){
			/*response.setIntHeader("Refresh", 1);*/
			String name = request.getParameter("name");
			String writer = request.getParameter("writer");
			int now = Integer.parseInt(request.getParameter("now"));
			String status = request.getParameter("status");
			String time = request.getParameter("time");
			WholeFiction wf = new WholeFiction(name,writer,status,now,time);
			wfs.addFiction(wf);
			PrintWriter out = response.getWriter();       
	        out.println("<script>window.open ('"+request.getContextPath()+"/sys/fiction/WholeFictionServlet?flag=getAllFictionPage','_parent')</script>");
			/*response.setHeader("refresh", "0;URL=WholeFictionServlet?flag=getAllFictionPage");*/
		}else if("getFictionById".equals(flag)){
			int id = Integer.parseInt(request.getParameter("id"));
			WholeFiction wf =wfs.getFictionById(id);
			request.setAttribute("wf",wf);
			request.getRequestDispatcher("fiction-edit.jsp").forward(request, response);
		}else if("updataFiction".equals(flag)){
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String writer = request.getParameter("writer");
			int now = Integer.parseInt(request.getParameter("now"));
			String status = request.getParameter("status");
			String time = request.getParameter("time");
			WholeFiction wf = new WholeFiction(id,name,writer,status,now,time);
			wfs.updateFiction(wf);
			PrintWriter out = response.getWriter();       
	        out.println("<script>window.open ('"+request.getContextPath()+"/sys/fiction/WholeFictionServlet?flag=getAllFictionPage','_parent')</script>");
			/*response.setHeader("refresh", "0;URL=WholeFictionServlet?flag=getAllFictionPage");*/
		}else if("deleteFictionById".equals(flag)){
			int id = Integer.parseInt(request.getParameter("id"));
			wfs.deleteFictionById(id);
			request.getRequestDispatcher("WholeFictionServlet?flag=getAllFictionPage").forward(request, response);
		}else if("deleteAllFiction".equals(flag)){
			String idAll = request.getParameter("idAll");
			if(idAll!=""){   //是否选择为空
				String[] id = idAll.split(",");//用逗号切割
				for(int i=0;i<id.length;i++){
					wfs.deleteAllFiction(id);;//根据id删除
				}
				request.getRequestDispatcher("WholeFictionServlet?flag=getAllFictionPage").forward(request, response);
			}else{
				request.getRequestDispatcher("WholeFictionServlet?flag=getAllFictionPage").forward(request, response);
			}
		}else if("getFictionByName".equals(flag)){
				String like = request.getParameter("like");
				request.setAttribute("like", like);
				String fiction_name = request.getParameter("name");
				int page=1;
				if(request.getParameter("page")!=null){
					page = Integer.parseInt(request.getParameter("page"));
				}
				int count = wfs.getByNameCount(fiction_name);
				if(count!=0){
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
					List<WholeFiction> list  = wfs.getFictionByName(fiction_name, page);
					request.setAttribute("list", list);
					request.setAttribute("page", page);
					request.setAttribute("pageNum", pageNum);
					request.setAttribute("count", count);
					request.setAttribute("fiction_name", fiction_name);
					request.getRequestDispatcher("fiction-whole.jsp").forward(request, response);
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
					request.getRequestDispatcher("fiction-whole.jsp").forward(request, response);
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

}
