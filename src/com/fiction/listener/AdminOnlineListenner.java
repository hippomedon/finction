package com.fiction.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class AdminOnlineListenner
 *
 */
@WebListener
public class AdminOnlineListenner implements HttpSessionBindingListener, HttpSessionListener {

    /**
     * Default constructor. 
     */
    public AdminOnlineListenner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionBindingListener#valueBound(HttpSessionBindingEvent)
     */
    public void valueBound(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub//监听登录成功
    	HttpSession session=arg0.getSession();
    	String name=(String)session.getAttribute("name");
    	ServletContext sc=session.getServletContext();
    	List<String> list=(List<String>) sc.getAttribute("list");
    	if(list==null){
    		list=new ArrayList<String>();
    	}
    	list.add(name);
    	sc.setAttribute("list", list);
    
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub监听退出登录，将用户数据从servletcontext中移除
    	HttpSession session=arg0.getSession();
    	String name=(String) session.getAttribute("name");
    	ServletContext sc=session.getServletContext();
    	List<String> list=(List<String>) sc.getAttribute("list");
    	for(String s:list){
    		if(name.equals(s)){
    			list.remove(s);
    			break;
    		}
    	}
    	sc.setAttribute("list", list);
    }

	/**
     * @see HttpSessionBindingListener#valueUnbound(HttpSessionBindingEvent)
     */
    public void valueUnbound(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
