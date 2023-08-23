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
@RequestMapping("/giangvien")
@SessionAttributes({"pb", "da", "dt", "gv"})
public class GiangVienController {
	@Autowired
	SessionFactory factory;
	
	//Never use getObj after delete, but can use with merge (insert/update)
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
				getList("FROM ThongBao WHERE DOITUONGTB='GV'"));
		return "giangvien/thongbao";
	}
	
	@RequestMapping(params="xemthongbao")
	public String xemthongbao(@RequestParam("id")String id, ModelMap model) {
		model.addAttribute("thongbao", getObj(ThongBao.class, id));
		return "giangvien/xemthongbao";
	}
	
	@RequestMapping(params = "hoidong")
	public String hoidong(ModelMap model, HttpServletRequest request) {
		String idgv = (String) request.getAttribute("loginid");
		String hql = "FROM HoiDong HD WHERE HD.CHUTICHHD.IDGV = '"+idgv
				+ "' OR HD.THUKY.IDGV = '" + idgv
				+ "' OR HD.UV1.IDGV = '" + idgv
				+ "' OR (HD.UV2 != null AND HD.UV2.IDGV = '"+idgv
				+ "') OR (HD.UV3 != null AND HD.UV3.IDGV = '"+idgv+"')";
		model.addAttribute("dshd", getList(hql));
		String hql2 = "FROM BaoVe WHERE HOIDONG.CHUTICHHD.IDGV = '"+idgv
				+ "' OR HOIDONG.THUKY.IDGV = '" + idgv
				+ "' OR HOIDONG.UV1.IDGV = '" + idgv
				+ "' OR (HOIDONG.UV2 != null AND HOIDONG.UV2.IDGV = '"+idgv
				+ "') OR (HOIDONG.UV3 != null AND HOIDONG.UV3.IDGV = '"+idgv+"')";
		model.addAttribute("dsbv", getList(hql2));
		return "giangvien/hoidong";
	}
	
	@RequestMapping(params = "lichhdpb")
	public String lichhdpb(ModelMap model, HttpServletRequest request) {
		String idgv = (String) request.getAttribute("loginid");
		String hql = "FROM DoAn WHERE GIANGVIENHD.IDGV = '"+ idgv+"'";
		model.addAttribute("dsda", getList(hql));
		String hql2 = "FROM PhanBien WHERE GIANGVIENPB.IDGV = '"+idgv+"'";
		model.addAttribute("dspb", getList(hql2));
		return "giangvien/lichhdpb";
	}


	@RequestMapping(params = "dspcdt")
	public String dspcdt(ModelMap model, HttpServletRequest request) {
		String idgv = (String) request.getAttribute("loginid");
		model.addAttribute("dsda1", getList("FROM DoAn WHERE GIANGVIENHD.IDGV = '"+idgv
				+"' AND DETAI = null"));
		model.addAttribute("dsda2", getList("FROM DoAn WHERE GIANGVIENHD.IDGV = '"+idgv
				+"' AND DETAI != null"));
		return "giangvien/dspcdt";
	}
	
	@RequestMapping(params = "pcdt", method=RequestMethod.GET)
	public String pcdt(ModelMap model, HttpServletRequest request, 
			@RequestParam("idda")Integer id) {
		String idgv = (String) request.getAttribute("loginid");
		DoAn da = (DoAn) getObj(DoAn.class, id);
		if(da.getDAPCGVPB())
		{
			model.addAttribute("message","Không thể sửa vì đồ án đã được phân công phản biện.");
			return dspcdt(model, request);
		}
		model.addAttribute("da", da);
		model.addAttribute("dsdt", 
				getList("FROM DeTai WHERE GIANGVIEN.IDGV='"+idgv
						+"' AND CHUYENNGANH.IDCN = "
						+da.getSINHVIEN().getCHUYENNGANH().getIDCN()) );
		return "giangvien/pcdt";
	}
	
	@RequestMapping(params = "pcdt", method=RequestMethod.POST)
	public String pcdt(ModelMap model, HttpServletRequest request, 
			@ModelAttribute("da")DoAn da) {
		if(da.getDAPCGVPB())
		{
			model.addAttribute("message","Không thể sửa vì đồ án đã được phân công phản biện.");
			return dspcdt(model, request);
		}
		if(update(da))
			model.addAttribute("message","Đã phân công.");
		else model.addAttribute("message","Có lỗi xảy ra, chưa thể phân công.");
		return dspcdt(model, request);
	}

	@RequestMapping(params = "huypcdt")
	public String huypcdt(ModelMap model, HttpServletRequest request, 
			@RequestParam("idda")Integer id) {
		DoAn da = (DoAn) getObj(DoAn.class,id);
		if(da.getDAPCGVPB())
		{
			model.addAttribute("message","Không thể hủy phân công vì đồ án đã được phân công phản biện.");
			return dspcdt(model, request);
		}
		da.setDETAI(null);
		if(update(da))
			model.addAttribute("message","Đã hủy phân công.");
		else model.addAttribute("message","Có lỗi xảy ra, chưa thể hủy phân công.");
		return dspcdt(model, request);
	}
	
	@RequestMapping(params = "detai")
	public String detai(ModelMap model, HttpServletRequest request) {
		String idgv = (String) request.getAttribute("loginid");
		model.addAttribute("dsdt", getList("FROM DeTai WHERE GIANGVIEN.IDGV = '"+idgv+"'"));
		return "giangvien/detai";
	}
	
	@RequestMapping(params = "themdt", method=RequestMethod.GET)
	public String themdt(ModelMap model) {
		model.addAttribute("dt", new DeTai());
		model.addAttribute("dscn", getList("FROM ChuyenNganh"));
		return "giangvien/themdt";
	}
	
	@RequestMapping(params = "themdt", method=RequestMethod.POST)
	public String themdt(ModelMap model, HttpServletRequest request, 
			@ModelAttribute("dt")DeTai dt) {
		String idgv = (String) request.getAttribute("loginid");
		dt.setGIANGVIEN((GiangVien) getObj(GiangVien.class, idgv));
		if(insert(dt))
			model.addAttribute("message","Thêm thành công.");
		else model.addAttribute("message","Thêm thất bại.");
		return detai(model, request);
	}

	@RequestMapping(params = "suadt", method=RequestMethod.GET)
	public String suadt(ModelMap model,
			@RequestParam("iddt")Integer id) {
		model.addAttribute("dt", getObj(DeTai.class, id));
		model.addAttribute("dscn", getList("FROM ChuyenNganh"));
		return "giangvien/suadt";
	}
	
	@RequestMapping(params = "suadt", method=RequestMethod.POST)
	public String suadt(ModelMap model, HttpServletRequest request, 
			@ModelAttribute("dt")DeTai dt) {
		if(update(dt))
			model.addAttribute("message","Cập nhật thành công!");
		else model.addAttribute("message","Cập nhật thất bại.");
		return detai(model, request);
	}

	@RequestMapping(params = "xoadt")
	public String xoadt(ModelMap model, HttpServletRequest request, 
			@RequestParam("iddt")Integer id) {
		if(!getList("FROM DoAn WHERE DeTai.IDDETAI = "+id).isEmpty())
		{
			model.addAttribute("message","Không thể xóa vì đề tài đã được phân công cho sinh viên.");
			return detai(model, request);
		}
		if(deleteObj(DeTai.class, id))
			model.addAttribute("message","Xóa thành công!");
		else model.addAttribute("message","Xóa thất bại.");
		return detai(model, request);
	}
	
	@RequestMapping(params = "dsdiemhdpb")
	public String dsdiemhdpb(ModelMap model, HttpServletRequest request) {
		String idgv = (String) request.getAttribute("loginid");
		model.addAttribute("dsda", getList("FROM DoAn WHERE GIANGVIENHD.IDGV = '"+idgv
				+"' AND DETAI != null"));
		model.addAttribute("dspb", getList("FROM PhanBien WHERE GIANGVIENPB.IDGV = '"+idgv+"'"));
		return "giangvien/dsdiemhdpb";
	}
	
	@RequestMapping(params = "cndiemhd", method=RequestMethod.GET)
	public String cndiemhd(ModelMap model, HttpServletRequest request, 
			@RequestParam("idda")Integer id) {
		DoAn da = (DoAn) getObj(DoAn.class,id);
		if(da.getDAPCGVPB())
		{
			model.addAttribute("message","Không thể cập nhật vì đồ án đã được phân công phản biện.");
			return dsdiemhdpb(model, request);
		}
		model.addAttribute("da", da);
		return "giangvien/cndiemhd";
	}
	
	@RequestMapping(params = "cndiemhd", method=RequestMethod.POST)
	public String cndiemhd(ModelMap model, HttpServletRequest request, 
			@ModelAttribute("da")DoAn da) {
			
		if(update(da))
			model.addAttribute("message","Cập nhật thành công!");
		else model.addAttribute("message","Cập nhật thất bại.");
		return dsdiemhdpb(model, request);
	}
	
	@RequestMapping(params = "cndiempb", method=RequestMethod.GET)
	public String cndiempb(ModelMap model, HttpServletRequest request, 
			@RequestParam("idpb")Integer id) {
		PhanBien pb = (PhanBien) getObj(PhanBien.class,id);
		if(pb.getDAPCBVDA())
		{
			model.addAttribute("message","Không thể cập nhật vì đồ án đã được phân công bảo vệ.");
			return dsdiemhdpb(model, request);
		}
		model.addAttribute("pb", pb);
		return "giangvien/cndiempb";
	}
	
	@RequestMapping(params = "cndiempb", method=RequestMethod.POST)
	public String cndiempb(ModelMap model, HttpServletRequest request, 
			@ModelAttribute("pb")PhanBien pb) {
		
		if(update(pb))
			model.addAttribute("message","Cập nhật thành công!");
		else model.addAttribute("message","Cập nhật thất bại.");
		return dsdiemhdpb(model,request);
	}

	@RequestMapping(params = "ttcanhan")
	public String ttcanhan(ModelMap model, HttpServletRequest request) {
		String idgv = (String) request.getAttribute("loginid");
		model.addAttribute("gv", getObj(GiangVien.class,idgv));
		return "giangvien/ttcanhan";
	}
	
	@RequestMapping(params = "ttcanhan", method=RequestMethod.POST)
	public String ttcanhan(ModelMap model, HttpServletRequest request, 
				@ModelAttribute("gv")GiangVien gv) {
		if(update(gv))
			model.addAttribute("message","Cập nhật thành công!");
		else model.addAttribute("message","Cập nhật thất bại.");
		return ttcanhan(model, request);
	}
	
	@RequestMapping(params = "doimk")
	public String doimk(ModelMap model) {
		model.addAttribute("passchange",new ChangePassword());
		return "giangvien/doimk";
	}
	
	@RequestMapping(params = "doimk", method=RequestMethod.POST)
	public String doimk(ModelMap model, HttpServletRequest request, 
			@ModelAttribute("passchange")ChangePassword p) {
		String idgv = (String) request.getAttribute("loginid");
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
				TaiKhoan tk = (TaiKhoan) getObj(TaiKhoan.class, idgv);
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
