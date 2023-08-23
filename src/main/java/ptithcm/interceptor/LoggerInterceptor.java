package ptithcm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ptithcm.controller.LogIn;

public class LoggerInterceptor extends HandlerInterceptorAdapter {
	private String loginname;
	private String loginid;
	private String role;
	
	@Override 
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) 
					throws Exception 
	{
		System.out.println(request.getRequestURI());
		System.out.println(request.getContextPath());
		if(role!=null)
		{
			if(request.getRequestURI().equals(request.getContextPath()+"/sinhvien.htm"))
				{
				if(role.equals("SV"))
					{
						System.out.println("Log in as sv success");
						request.setAttribute("loginname", loginname);
						request.setAttribute("loginid", loginid);
						request.setAttribute("role", role);
					}
				else {
					System.out.println("Different role, go to log in page");
					loginid=null;
					loginname=null;
					role=null;
					}
				}
			else if(request.getRequestURI().equals(request.getContextPath()+"/giangvien.htm"))
				{
				if(role.equals("GV"))
					{
						System.out.println("Log in as gv success");
						request.setAttribute("loginname", loginname);
						request.setAttribute("loginid", loginid);
						request.setAttribute("role", role);
					}
				else {
					System.out.println("Different role, go to log in page");
					loginid=null;
					loginname=null;
					role=null;
					}
				}
			else if(request.getRequestURI().equals(request.getContextPath()+"/nhanvien.htm"))
				{
				if(role.equals("NV"))
					{
						System.out.println("Log in as nv success");
						request.setAttribute("loginname", loginname);
						request.setAttribute("loginid", loginid);
						request.setAttribute("role", role);
					}
				else {
					System.out.println("Different role, go to log in page");
					loginid=null;
					loginname=null;
					role=null;
					}
				}
			else if(request.getRequestURI().equals(request.getContextPath()+"/qtv.htm"))
				{
				if(role.equals("QTV"))
					{
						System.out.println("Log in as qtv success");
						request.setAttribute("loginname", loginname);
						request.setAttribute("loginid", loginid);
						request.setAttribute("role", role);
					}
				else 
					{
					System.out.println("Different role, go to log in page");
					loginid=null;
					loginname=null;
					role=null;
					}
				}
			else 
				{
				System.out.println("Request URI is invalid =>> Log out or new");
				loginid=null;
				loginname=null;
				role=null;
				}
		}
		else 
		{
			System.out.println("No role =>> Log out or new");
			loginid=null;
			loginname=null;
			role=null;
		}
		System.out.println("LoggerInterceptor.preHandle() finish"); 
		return true; 
		}
	
	@Override 
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception 
	{ 
		if(loginname==null)
			loginname=(String) request.getAttribute("loginname");
		if(loginid==null)
			loginid=(String) request.getAttribute("loginid");
		if(role==null)
			role=(String) request.getAttribute("role");
		if(role==null)
		{
			System.out.println("No role => go to dang nhap");
			if(!request.getRequestURI().equals(request.getContextPath()+"/dangnhap.htm") )
				modelAndView.setViewName("redirect:dangnhap.htm");
		}
		else System.out.println("Log in as "+role+". "+loginname+" "+loginid);
		System.out.println("LoggerInterceptor.postHandle() finish");
		
	}
	
	@Override 
	public void afterCompletion(HttpServletRequest request, 
			HttpServletResponse response, Object handler,
			Exception ex) throws Exception 
	{ 
		System.out.println("LoggerInterceptor.afterCompletion()");
		}
}
