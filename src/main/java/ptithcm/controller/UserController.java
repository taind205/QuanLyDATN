package ptithcm.controller;
import ptithcm.entity.User;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Transactional
@Controller
@RequestMapping("/user/")

public class UserController {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("index")
	public String index(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM User";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		model.addAttribute("users", list);
		return "user/index";	
	}

	@RequestMapping(value="insert",method=RequestMethod.GET)
	public String insert(ModelMap model) {
		model.addAttribute("user", new User());
		return "user/insert";
	}
	
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public String insert(ModelMap model, @ModelAttribute("user") User user) throws IllegalStateException, SystemException {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(user);
			t.commit();
			model.addAttribute("message","Thêm mới thành công!");
		}
		catch (Exception e) {
			t.rollback();
			model.addAttribute("message","Thêm mới thất bại.");
		}
		finally {
			session.close();
		}
		return "user/insert";
	}
	
	@RequestMapping(value="delete")
	public String delete(@RequestParam("username")String id, ModelMap model) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
	    User u = (User) session.load(User.class, id);
		try {
			session.delete(u);
			session.flush();
			t.commit();
			model.addAttribute("message","Xóa thành công");
		}
		catch (Exception e) {
			t.rollback();
			model.addAttribute("message","Xóa thất bại.");
		}
		finally {
			session.close();
		}
		
		Session session2 = factory.getCurrentSession();
		String hql = "FROM User";
		Query query = session2.createQuery(hql);
		List<User> list = query.list();
		model.addAttribute("users", list);
		return "user/index";
	}
	
	@RequestMapping(value="update",method=RequestMethod.GET)
	public String update(@RequestParam("username")String id, ModelMap model) {
		model.addAttribute("username", id);
		Session session = factory.openSession();
		User u = (User) session.load(User.class, id);
		model.addAttribute("user", u);
		//session.close();
		return "user/update";
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(ModelMap model, @ModelAttribute("user") User user) throws IllegalStateException, SystemException {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(user);
			t.commit();
			model.addAttribute("message","Cập nhật thành công!");
		}
		catch (Exception e) {
			t.rollback();
			model.addAttribute("message","Cập nhật thất bại.");
		}
		finally {
			session.close();
		}
		return "user/update";
	}
	
	
}
