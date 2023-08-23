package ptithcm.controller;
import ptithcm.entity.Staff;

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
@RequestMapping("/staff/")

public class StaffController {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("index")
	public String index(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Staff";
		Query query = session.createQuery(hql);
		List<Staff> list = query.list();
		model.addAttribute("staffs",list);
		return "staff/index";
	}
		
	@RequestMapping("report")
	public String report(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "SELECT r.staff.id, " +
				"SUM(case when r.type=1 then 1 else 0 end), "+
				"SUM(case when r.type=0 then 1 else 0 end)" +
				" FROM Record r "+
				" GROUP BY r.staff.id";
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		model.addAttribute("arrays", list);
		return "staff/report";
	}
}
