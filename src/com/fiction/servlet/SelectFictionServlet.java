package com.fiction.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*import javax.servlet.http.HttpSession;
import javax.websocket.Session;*/

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/*import org.apache.jasper.runtime.ProtectedFunctionMapper;*/

import com.fiction.entity.SelectFiction;
import com.fiction.service.SelectFictionService;
import com.sun.xml.internal.bind.v2.runtime.Name;

/**
 * Servlet implementation class SelectFictionServlet
 */
@WebServlet("/sys/fiction/SelectFictionServlet")
public class SelectFictionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectFictionServlet() {
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
		SelectFictionService sfs = new SelectFictionService();
		
		if("getAllSelectPage".equals(flag)||"ZhanByNameTwo".equals(flag)){
			getAllSelectPage(request, response, sfs);
		}else if("addSelect".endsWith(flag)){
			SelectFiction sf = upload(request, response);
			sfs.addSelect(sf);
			getAllSelectPage(request, response, sfs);
		}else if("getSelectById".equals(flag)){
			int id = Integer.parseInt(request.getParameter("id"));
			SelectFiction sf =sfs.getSelectById(id);
			request.setAttribute("sf",sf);
			
			request.getRequestDispatcher("select-edit.jsp").forward(request, response);
		}else if("updateSelect".equals(flag)){
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String writer = request.getParameter("writer");
			String zuixin = request.getParameter("zuixin");
			String time = request.getParameter("time");
			String jianjie = request.getParameter("jianjie");
			SelectFiction sf = new SelectFiction(id,name,writer,zuixin,time,jianjie);
			sfs.updateSelect(sf);
			/*SelectFictionServlet?flag=getAllSelectPage*/
			request.getRequestDispatcher("select-fiction.jsp").forward(request, response);
		}else if("deleteSelectById".equals(flag)){
			int id = Integer.parseInt(request.getParameter("id"));
			sfs.deleteSelectById(id);
			request.getRequestDispatcher("SelectFictionServlet?flag=getAllSelectPage").forward(request, response);
		}else if("deleteAllSelect".equals(flag)){
			String idAll = request.getParameter("idAll");
			if(idAll!=""){   //是否选择为空
				System.out.println(idAll+"4456");
				String[] id = idAll.split(",");//用逗号切割
				for(int i=0;i<id.length;i++){
					sfs.deleteAllSelect(id);;//根据id删除
				}
				request.getRequestDispatcher("SelectFictionServlet?flag=getAllSelectPage").forward(request, response);
			}else{
				request.getRequestDispatcher("SelectFictionServlet?flag=getAllSelectPage").forward(request, response);
			}
		}else if("getSelectByName".equals(flag)){
			String like = request.getParameter("like");
			request.setAttribute("like", like);
			String selectqq_name = request.getParameter("name");
			int page=1;
			if(request.getParameter("page")!=null){
				page = Integer.parseInt(request.getParameter("page"));
			}
			int count = sfs.getByNameCount(selectqq_name);
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
				List<SelectFiction> list  = sfs.getSelectByName(selectqq_name, page);
				request.setAttribute("list", list);
				request.setAttribute("page", page);
				request.setAttribute("pageNum", pageNum);
				request.setAttribute("count", count);
				request.setAttribute("selectqq_name", selectqq_name);
				request.getRequestDispatcher("select-fiction.jsp").forward(request, response);
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
				request.getRequestDispatcher("select-fiction.jsp").forward(request, response);
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
	protected void getAllSelectPage(HttpServletRequest request, HttpServletResponse response,SelectFictionService sfs) throws ServletException, IOException {
		int page=1;
		if(request.getParameter("page")!=null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		int count = sfs.getAllCount();
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
		
		
		//这里是点击全部小说中书名（其中获取书名，页数）跳到查看小说中特定行小说并展开章节
		String selectqq_name = request.getParameter("name");
		if(selectqq_name!=null){
			sfs.getSelectByName(selectqq_name,page);
			List<SelectFiction> list = sfs.getAllSelectPage(page);
			for(SelectFiction sf:list){
				if(selectqq_name.equals(sf.getSelectqq_Name())){
					request.setAttribute("selectqq_name", selectqq_name);
					/*HttpSession session = request.getSession();*/
					
				}
			}
		}
		
		List<SelectFiction> list = sfs.getAllSelectPage(page);
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("count", count);
		request.getRequestDispatcher("select-fiction.jsp").forward(request, response);
	}
	protected SelectFiction upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//上传路径
		String path = request.getSession().getServletContext().getRealPath("/")+"/sys/images";
		String name = "";
		String writer = "";
		String zuixin = "";
		String time = "";
		String jianjie = "";
		String image = "";	
		boolean isUpload = ServletFileUpload.isMultipartContent(request);
		if(isUpload){
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload load = new ServletFileUpload(factory);
			try {
				List<FileItem> list = load.parseRequest(request);
				for(FileItem file:list){
					if(file.isFormField()){
						String fileName = file.getFieldName();
						if("name".equals(fileName)){
							name = file.getString("UTF-8");
						}else if("writer".equals(fileName)){
							writer = file.getString("UTF-8");
						}else if("zuixin".equals(fileName)){
							zuixin = file.getString("UTF-8");
						}else if("time".equals(fileName)){
							time = file.getString("UTF-8");
						}else if("jianjie".equals(fileName)){
							jianjie =file.getString("UTF-8");
						}
					}else{
						image = file.getName();
						/*InputStream inputStream = file.getInputStream();
						OutputStream outputStream = new FileOutputStream(path+image);*/
						File f = new File(path,image);
						file.write(f);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		SelectFiction sf = new SelectFiction(name,writer,zuixin,time,jianjie,image);
		return sf;
	}
}
