package ptithcm.controller;
import ptithcm.entity.Record;
import ptithcm.entity.Staff;
import ptithcm.entity.User;

import java.util.Date;
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
@RequestMapping("/record/")

public class RecordController {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("index")
	public String index(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Record";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		model.addAttribute("records", list);
		return "record/index";	
	}

	@RequestMapping(value="insert",method=RequestMethod.GET)
	public String insert(ModelMap model) {
		model.addAttribute("record", new Record());
		return "record/insert";
	}
	
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public String insert(ModelMap model, @ModelAttribute("record") Record record) throws IllegalStateException, SystemException {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			record.setDate(new Date());
			session.save(record);
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
		return "record/insert";
	}
	
	@ModelAttribute("staff")
	public List<Staff> getStaff(){
		Session session = factory.getCurrentSession();
		String hql = "FROM Staff";
		Query query = session.createQuery(hql);
		List<Staff> list = query.list();
		return list;
	}
	
	@RequestMapping(value="delete")
	public String delete(@RequestParam("id")Integer id, ModelMap model) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
	    Record r = (Record) session.load(Record.class, id);
		try {
			session.delete(r);
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
		String hql = "FROM Record";
		Query query = session2.createQuery(hql);
		List<Record> list = query.list();
		model.addAttribute("records", list);
		return "record/index";
	}
	
	@RequestMapping(value="update",method=RequestMethod.GET)
	public String update(@RequestParam("id")Integer id, ModelMap model) {
		model.addAttribute("id", id);
		Session session = factory.openSession();
		Record r = (Record) session.load(Record.class, id);
		model.addAttribute("record", r);
		//session.close();
		return "record/update";
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(ModelMap model, @ModelAttribute("record") Record r) throws IllegalStateException, SystemException {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(r);
			t.commit();
			model.addAttribute("message","Cập nhật thành công!");
		}
		catch (Exception e) {
			t.rollback();
			model.addAttribute("message","Cập nhật thất bại. "+e.getCause()+e.getMessage());
		}
		finally {
			session.close();
		}
		
		return "record/update";
	}
}
