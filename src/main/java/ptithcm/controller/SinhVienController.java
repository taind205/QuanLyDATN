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
@RequestMapping("/sinhvien")
@SessionAttributes({"sv"})
public class SinhVienController {
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

	@RequestMapping()
	public String index(ModelMap model) {
		return thongbao(model);
	}

	@RequestMapping(params = "thongbao")
	public String thongbao(ModelMap model) { 
		model.addAttribute("dsthongbao", 
				getList("FROM ThongBao WHERE DOITUONGTB='SV'"));
		return "sinhvien/thongbao";
	}
	
	@RequestMapping(params="xemthongbao")
	public String xemthongbao(@RequestParam("id")String id, ModelMap model) {
		model.addAttribute("thongbao", getObj(ThongBao.class, id));
		return "sinhvien/xemthongbao";
	}
	
	@RequestMapping(params="dklamda")
	public String dklamda(ModelMap model, HttpServletRequest request) {
		String masv = (String) request.getAttribute("loginid");
		SinhVien sv = (SinhVien) getObj(SinhVien.class, masv);
		DieuKienLamDoAn dk = (DieuKienLamDoAn) getObj(DieuKienLamDoAn.class, 1);
		model.addAttribute("dk", dk);
		model.addAttribute("dscn", getList("FROM ChuyenNganh"));
		model.addAttribute("sv", sv);
		if(!sv.getDUDKXETTN() || !sv.getDUDKLAMDA())
			model.addAttribute("message2","Bạn chưa có đủ điều kiện làm đồ án tốt nghiệp.");
		else 
		{
			model.addAttribute("message2","Bạn có đủ điều kiện làm đồ án tốt nghiệp.");
			if(sv.getDAPHANCONGDA()==null || !sv.getDAPHANCONGDA())
				model.addAttribute("dudk", "1");
		}
		
		if(sv.getXACNHANLAMDA()!=null)
			if(sv.getXACNHANLAMDA())
			model.addAttribute("message2","Bạn đã xác nhận làm đồ án.");
			else model.addAttribute("message2","Bạn đã xác nhận không làm đồ án.");
		return "sinhvien/dklamda";
	}
	
	/*@RequestMapping(params="xnlamda", method=RequestMethod.GET)
	public String xnlamda(ModelMap model) {
		String masv = "SV009";
		model.addAttribute("sv", getObj(SinhVien.class, masv));
		return "sinhvien/xnlamda";
	}*/
	
	@RequestMapping(params="xnlamda", method=RequestMethod.POST)
	public String xnlamda(ModelMap model, HttpServletRequest request, @ModelAttribute("sv")SinhVien sv) {
		if(!getList("From DoAn WHERE SINHVIEN.MASV= '"
				+sv.getMASV()+"'").isEmpty())
		{
			model.addAttribute("message","Không thể thay đổi vì bạn đã được phân công đồ án.");
			return dklamda(model, request);
		}
		if(update(sv))
			model.addAttribute("message","Xác nhận thành công!");
		else model.addAttribute("message","Xác nhận thất bại.");
		return dklamda(model, request);
	}
	
	@RequestMapping(params = "ttda")
	public String ttda(ModelMap model, HttpServletRequest request) {
		String masv = (String) request.getAttribute("loginid");
		PhanBien pb=null;
		BaoVe bv=null;
		DoAn da=null;
		Double diemcuoicung = null;
		if(!getList("FROM DoAn WHERE SINHVIEN.MASV = '"
				+masv+"'").isEmpty())
		{
			da = (DoAn) getList("FROM DoAn WHERE SINHVIEN.MASV = '"
				+masv+"'").get(0);
			if(da.getDETAI()==null)
				model.addAttribute("message", "Bạn chưa được GVHD phân công đề tài.");
		}
		else model.addAttribute("message", "Bạn chưa được phân công đồ án.");
		if(!getList("FROM PhanBien WHERE DOAN.SINHVIEN.MASV = '"
						+masv+"'").isEmpty())
		{
			pb =  (PhanBien) getList("FROM PhanBien WHERE DOAN.SINHVIEN.MASV = '"
							+masv+"'").get(0);
		}
		if(!getList("FROM BaoVe WHERE DOAN.SINHVIEN.MASV = '"
						+masv+"'").isEmpty())
		{
			bv = (BaoVe) getList("FROM BaoVe WHERE DOAN.SINHVIEN.MASV = '"
							+masv+"'").get(0);
			if(bv.getDIEMHD() != null)
				diemcuoicung=( bv.getDIEMHD()*bv.getSOTV()+pb.getDIEMPHANBIEN()
				+da.getDIEMHUONGDAN() ) / (bv.getSOTV()+2);
		}
		
		if(diemcuoicung != null)
			diemcuoicung = Math.round((diemcuoicung) * 100.0) / 100.0;
		model.addAttribute("da", da);
		model.addAttribute("pb", pb);
		model.addAttribute("bv", bv);
		model.addAttribute("diemcuoicung", diemcuoicung);
		return "sinhvien/ttda";
	}
	
	@RequestMapping(params = "lichda")
	public String lichda(ModelMap model, HttpServletRequest request) {
		String masv = (String) request.getAttribute("loginid");
		PhanBien pb=null;
		BaoVe bv=null;
		DoAn da=null;
		
		if(!getList("FROM DoAn WHERE SINHVIEN.MASV = '"
				+masv+"'").isEmpty())
		{
			da = (DoAn) getList("FROM DoAn WHERE SINHVIEN.MASV = '"
				+masv+"'").get(0);
			model.addAttribute("lichgapgvhd", "1");
		}
		else model.addAttribute("message", "Chưa có lịch.");
		if(!getList("FROM PhanBien WHERE DOAN.SINHVIEN.MASV = '"
						+masv+"'").isEmpty())
		{
			pb =  (PhanBien) getList("FROM PhanBien WHERE DOAN.SINHVIEN.MASV = '"
							+masv+"'").get(0);
			model.addAttribute("lichpb", "1");
		}
		if(!getList("FROM BaoVe WHERE DOAN.SINHVIEN.MASV = '"
						+masv+"'").isEmpty())
		{
			bv = (BaoVe) getList("FROM BaoVe WHERE DOAN.SINHVIEN.MASV = '"
							+masv+"'").get(0);
			model.addAttribute("lichbv", "1");
		}
		model.addAttribute("da", da);
		model.addAttribute("pb", pb);
		model.addAttribute("bv", bv);
		return "sinhvien/lichda";
	}

	@RequestMapping(params = "ttcanhan")
	public String ttcanhan(ModelMap model, HttpServletRequest request) {
		String masv = (String) request.getAttribute("loginid");
		model.addAttribute("sv", getObj(SinhVien.class,masv));
		return "sinhvien/ttcanhan";
	}
	
	@RequestMapping(params = "ttcanhan", method=RequestMethod.POST)
	public String ttcanhan(ModelMap model, HttpServletRequest request, 
				@ModelAttribute("sv")SinhVien sv) {
		if(update(sv))
			model.addAttribute("message","Cập nhật thành công!");
		else model.addAttribute("message","Cập nhật thất bại.");
		return ttcanhan(model, request);
	}
	
	@RequestMapping(params = "doimk")
	public String doimk(ModelMap model) {
		model.addAttribute("passchange",new ChangePassword());
		return "sinhvien/doimk";
	}
	
	@RequestMapping(params = "doimk", method=RequestMethod.POST)
	public String doimk(ModelMap model, HttpServletRequest request, 
			@ModelAttribute("passchange")ChangePassword p) {
		String masv = (String) request.getAttribute("loginid");
		if(p.getOLDPASS()!=null)
		{
			if(p.getNEWPASS()==null)
				model.addAttribute("message","Vui lòng nhập mật khẩu muốn đổi.");
			else if(p.getCONFIRMPASS()==null)
				model.addAttribute("message","Vui lòng xác nhận mật khẩu mới.");
			else if(!p.getNEWPASS().equals(p.getCONFIRMPASS()) )
				model.addAttribute("message","Xác nhận mật khẩu mới không đúng.");
			else if(p.getNEWPASS().equals(p.getOLDPASS()) )
				model.addAttribute("message","Mật khẩu mới phải khác mật khẩu cũ.");
			else
			{
				TaiKhoan tk = (TaiKhoan) getObj(TaiKhoan.class, masv);
				if (tk.getMATKHAU().equals(p.getOLDPASS()) ) {
					tk.setMATKHAU(p.getNEWPASS());
					if(update(tk))
					model.addAttribute("message","Đổi mật khẩu thành công.");
					else model.addAttribute("message","Có lỗi xảy ra, chưa thể đổi mật khẩu.");
				}
				else model.addAttribute("message","Mật khẩu cũ không đúng.");
			}
		}
		else model.addAttribute("message","Vui lòng nhập mật khẩu cũ.");
		return doimk(model);
	}
	
	@RequestMapping(params = "dangxuat")
	public String dangxuat(ModelMap model) {
		return "redirect:dangnhap.htm";
	}
}
