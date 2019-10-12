package com.fiction.servlet;

import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiction.entity.RankingList;
import com.fiction.service.RankingListService;

/**
 * Servlet implementation class RankingListServlet
 */
@WebServlet("/sys/bangdan/RankingListServlet")
public class RankingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RankingListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RankingListService rls = new RankingListService();
		String flag = request.getParameter("flag");
		if("getAllweek".equals(flag)){
			int page=Integer.parseInt(request.getParameter("page"));
			int count = rls.getweekCount();
			int pageNum = 0;
			if(count%10==0){
				pageNum = count/10;
			}else{
				pageNum = count/10+1;
			}
			if(page<1){
				page=1;
			}
			if(page>pageNum){
				page=pageNum;
			}
			List<RankingList> list=rls.getAllweek(page);
			request.setAttribute("pageNum",pageNum);
			request.setAttribute("count",count);
			request.setAttribute("page",page);
			request.setAttribute("list", list);
			request.getRequestDispatcher("week.jsp")
			.forward(request, response);
		}
		if("getAllmonth".equals(flag)){
			int page=Integer.parseInt(request.getParameter("page"));
			int count = rls.getmonthCount();
			int pageNum = 0;
			if(count%10==0){
				pageNum = count/10;
			}else{
				pageNum = count/10+1;
			}
			if(page<1){
				page=1;
			}
			if(page>pageNum){
				page=pageNum;
			}
			List<RankingList> list=rls.getAllmonth(page);
			request.setAttribute("pageNum",pageNum);
			request.setAttribute("count",count);
			request.setAttribute("page",page);
			request.setAttribute("list", list);
			request.getRequestDispatcher("month.jsp")
			.forward(request, response);
		}
		if("getAllyeat".equals(flag)){
			int page=Integer.parseInt(request.getParameter("page"));
			int count = rls.getYeatCount();
			int pageNum = 0;
			if(count%10==0){
				pageNum = count/10;
			}else{
				pageNum = count/10+1;
			}
			if(page<1){
				page=1;
			}
			if(page>pageNum){
				page=pageNum;
			}
			List<RankingList> list=rls.getAllYeat(page);
			request.setAttribute("pageNum",pageNum);
			request.setAttribute("count",count);
			request.setAttribute("page",page);
			request.setAttribute("list", list);
			request.getRequestDispatcher("yeat.jsp")
			.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
