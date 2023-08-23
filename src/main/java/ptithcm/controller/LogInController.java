package ptithcm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.SystemException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import ptithcm.entity.*;

@Transactional
@Controller
@RequestMapping("/dangnhap")
//@SessionAttributes({"sv"})
public class LogInController {
	@Autowired
	SessionFactory factory;
	
	//Never use getObj after delete
	private Object getObj(Class<?> c, String id)
	{
		Session session = factory.openSession();
		Object obj = session.load(c, id);
		return obj;
	}
	
	private Object getObj(Class<?> c, Integer id)
	{
		Session session = factory.openSession();
		Object obj = session.load(c, id);
		return obj;
	}
	
	private List<?> getList(String hql)
	{
		Session session = factory.openSession();
		Query query = session.createQuery(hql);
		List<?> list = query.list();
		session.close();
		return list;
	}
	
	private Boolean merge(Object obj)
	{
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.merge(obj);
			t.commit();
			session.close();
			return true;
		}
		catch (Exception e) {
			t.rollback();
			session.close();
			return false;
		}
	}
	
	private Boolean mergeTwo(Object o1, Object o2)
	{
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.merge(o1);
			session.merge(o2);
			t.commit();
			session.close();
			return true;
		}
		catch (Exception e) {
			t.rollback();
			session.close();
			return false;
		}
	}
	
	private Boolean insert(Object obj)
	{
		return merge(obj);
	}
	
	private Boolean insertTwo(Object o1, Object o2)
	{
		return mergeTwo(o1, o2);
	}
	
	private Boolean insertAndUpdate(Object o1, Object o2)
	{
		return mergeTwo(o1, o2);
	}
	
	private Boolean update(Object obj)
	{
		return merge(obj);
	}
	
	private Boolean updateTwo(Object o1, Object o2)
	{
		return mergeTwo(o1,o2);
	}
	
	private Boolean deleteObj(Class<?> c, String id)
	{
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Object o = session.load(c, id);
		try {
			session.delete(o);
			session.flush();
			t.commit();
			session.close();
			return true;
		}
		catch (Exception e) {
			t.rollback();
			session.close();
			System.out.println(e);
			return false;
		}
	}
	
	private Boolean deleteObj(Class<?> c, Integer id)
	{
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Object o = session.load(c, id);
		try {
			session.delete(o);
			session.flush();
			t.commit();
			session.close();
			return true;
		}
		catch (Exception e) {
			t.rollback();
			session.close();
			System.out.println(e);
			return false;
		}
	}
	
	private Boolean deleteAndUpdate(Class<?> c, Integer id, Object o2)
	{
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Object o = session.load(c, id);
		try {
			session.delete(o);
			session.flush();
			session.merge(o2);
			t.commit();
			session.close();
			return true;
		}
		catch (Exception e) {
			t.rollback();
			session.close();
			System.out.println(e+e.getMessage());
			return false;
		}
	}

	@RequestMapping(method=RequestMethod.GET)
	public String login(ModelMap model, HttpServletRequest request) {
		model.clear();
		model.addAttribute("login",new LogIn());
		return "index";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String login(HttpServletRequest request, 
			ModelMap model, @ModelAttribute("login")LogIn l) { 
		TaiKhoan tk=null;
		if(!getList("From TaiKhoan Where ID = '"+l.getTAIKHOAN()+"'").isEmpty())
		{
			tk = (TaiKhoan) getObj(TaiKhoan.class, l.getTAIKHOAN());
			if(l.getMATKHAU().equals(tk.getMATKHAU()) )
			{
				if(tk.getLOAITK().equals("SV"))
				{
					request.setAttribute("role", "SV");
					SinhVien sv = (SinhVien) getList("FROM SinhVien WHERE MASV ='"+tk.getID()+"'").get(0);
					request.setAttribute("loginname", sv.getHOSV()+" "+sv.getTENSV());
					request.setAttribute("loginid", sv.getMASV());
					return "redirect:sinhvien.htm";
				}
				if(tk.getLOAITK().equals("GV"))
				{
					request.setAttribute("role", "GV");
					GiangVien gv = (GiangVien) getList("FROM GiangVien WHERE IDGV ='"+tk.getID()+"'").get(0);
					request.setAttribute("loginname", gv.getHOGV()+" "+gv.getTENGV());
					request.setAttribute("loginid", gv.getIDGV());
					return "redirect:giangvien.htm";
				}
				if(tk.getLOAITK().equals("NV"))
				{
					request.setAttribute("role", "NV");
					NhanVien nv = (NhanVien) getList("FROM NhanVien WHERE IDNV ='"+tk.getID()+"'").get(0);
					request.setAttribute("loginname", nv.getHONV()+" "+nv.getTENNV());
					request.setAttribute("loginid", nv.getIDNV());
					return "redirect:nhanvien.htm";
				}
				if(tk.getLOAITK().equals("QTV"))
				{
					request.setAttribute("role", "QTV");
					request.setAttribute("loginname", "Quản trị viên");
					request.setAttribute("loginid", tk.getID());
					return "redirect:qtv.htm";
				}
			}
			else model.addAttribute("message","Sai mật khẩu.");
		}
		else model.addAttribute("message","Tài khoản không tồn tại.");
		return "index";
	}
}
