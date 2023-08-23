package ptithcm.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;

import ptithcm.entity.GiangVien;
import ptithcm.entity.NhanVien;
import ptithcm.entity.SinhVien;
import ptithcm.entity.TaiKhoan;
//import ptithcm.entity.User;

@Transactional
@Controller
@RequestMapping("/qtv")
public class QTVController {
	@Autowired
	SessionFactory factory;

	private List<?> getList(String hql)
	{
		Session session = factory.openSession();
		Query query = session.createQuery(hql);
		List<?> list = query.list();
		session.close();
		return list;
	}
	
	@RequestMapping()
	public String index(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVien";
		Query query = session.createQuery(hql);
		List<NhanVien> list = query.list();
		model.addAttribute("dsnhanvien", list);
		return "qtv/xemthongtinnhanvien";
	}

	@RequestMapping(params = "capnhatthongtindn")
	public String capnhatthongtindn(ModelMap model) {
		model.addAttribute("id", "");
	return "qtv/capnhatthongtindn";
	}
	
	@RequestMapping(params = "themtk", method=RequestMethod.GET)
	public String themtk(ModelMap model) { 
		model.addAttribute("taikhoan", new TaiKhoan());
	return "qtv/themtk";
	}
	
	@RequestMapping(params= "themtk", method=RequestMethod.POST)
	public String themtk(ModelMap model, @ModelAttribute("taikhoan") TaiKhoan tk,
			@RequestParam("hovatendem") String hovatendem, @RequestParam("ten")String ten,
			@RequestParam("sdt")String sdt, @RequestParam("email")String email) {
		if(!getList("From TaiKhoan WHERE ID = '"+tk.getID()+"'").isEmpty() )
		{
			model.addAttribute("message","Tài khoản đã tồn tại.");
			return "qtv/themtk";
		}
		//else:
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			model.addAttribute("message","Thêm mới thành công!");
			if(tk.getLOAITK().equals("SV"))
			{
				SinhVien sv = new SinhVien();
				sv.setMASV(tk.getID());
				sv.setHOSV(hovatendem);
				sv.setTENSV(ten);
				sv.setSDT(sdt);
				sv.setEMAIL(email);	
				session.save(sv);
				session.save(tk);
			}
			else if(tk.getLOAITK().equals("GV"))
			{
				GiangVien gv = new GiangVien();
				gv.setIDGV(tk.getID());
				gv.setHOGV(hovatendem);
				gv.setTENGV(ten);
				gv.setSDT(sdt);
				gv.setEMAIL(email);	
				session.save(gv);
				session.save(tk);
			}
			else if(tk.getLOAITK().equals("NV"))
			{
				NhanVien nv = new NhanVien();
				nv.setIDNV(tk.getID());
				nv.setHONV(hovatendem);
				nv.setTENNV(ten);
				nv.setSDT(sdt);
				nv.setEMAIL(email);	
				session.save(nv);
				session.save(tk);
			}
			else if(tk.getLOAITK().equals("QTV"))
			{
				session.save(tk);
			}
			else 
				model.addAttribute("message","Loại tài khoản không đúng.");
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
			model.addAttribute("message","Thêm mới thất bại.");
		}
		finally {
			session.close();
		}
		return "qtv/themtk";
	}
	
	/*@RequestMapping(params = "chinhsuatk")
	public String chinhsuatkold(ModelMap model, 
			@RequestParam("id") String id) {
		System.out.print(id);
	return "qtv/chinhsuatk";
	}*/
	
	@RequestMapping(params="id", method=RequestMethod.GET)
	public String chinhsuatk(ModelMap model, @RequestParam("id")String id) {
		Session session = factory.openSession();
		TaiKhoan tk = null;
		if(!getList("From TaiKhoan WHERE ID = '"+id+"'").isEmpty() )
			 tk = (TaiKhoan) session.load(TaiKhoan.class, id);
		if(tk!=null)
		{
			model.addAttribute("taikhoan", tk);
			return "qtv/chinhsuatk";
		}
		else 
		{
			model.addAttribute("message","Tài khoản không tồn tại.");
			return capnhatthongtindn(model);
		}
	}
	
	@RequestMapping(params="chinhsuatk",method=RequestMethod.POST)
	public String chinhsuatk(ModelMap model, 
			@ModelAttribute("taikhoan") TaiKhoan tk) throws IllegalStateException, SystemException {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(tk);
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
		return "qtv/chinhsuatk";
	}
	
	@RequestMapping(params="xoatk",method=RequestMethod.POST)
	public String xoatk(ModelMap model, HttpServletRequest request, 
			@ModelAttribute("taikhoan") TaiKhoan tk) {
		String id = tk.getID();
		if(tk.getLOAITK().equals("SV"))
		{
			if(!getList("FROM DoAn WHERE MASV = '"+id+"'").isEmpty())
			{
				model.addAttribute("message","Không thể xóa tài khoản vì sinh viên đã được phân công đồ án.");
				return capnhatthongtindn(model);
			}
		}
		else if(tk.getLOAITK().equals("GV"))
		{
			if(!getList("FROM HoiDong WHERE CHUTICHHD.IDGV = '"+id
					+"' OR THUKY.IDGV = '"+id+"' OR UV1.IDGV = '"+id
					+"' OR UV2.IDGV = '"+id+"' OR UV3.IDGV = '"+id+"'").isEmpty())
			{
				model.addAttribute("message","Không thể xóa tài khoản vì giảng viên đã thuộc một hội đồng.");
				return capnhatthongtindn(model);
			}
			if(!getList("FROM PhanBien WHERE IDGVPB = '"+id+"'").isEmpty())
			{
				model.addAttribute("message","Không thể xóa tài khoản vì giảng viên đã được phân công phản biện đồ án.");
				return capnhatthongtindn(model);
			}
			if(!getList("FROM DoAn WHERE IDGVHD = '"+id+"'").isEmpty())
			{
				model.addAttribute("message","Không thể xóa tài khoản vì giảng viên đã được phân công hướng dẫn đồ án.");
				return capnhatthongtindn(model);
			}
			if(!getList("FROM DeTai WHERE IDGV = '"+id+"'").isEmpty())
			{
				model.addAttribute("message","Không thể xóa tài khoản vì đã có một đề tài thuộc giảng viên này.");
				return capnhatthongtindn(model);
			}
		}
		else if(tk.getLOAITK().equals("NV"))
		{
			if(!getList("FROM ThongBao WHERE IDNV = '"+id+"'").isEmpty())
			{
				model.addAttribute("message","Không thể xóa tài khoản vì đã có một thông báo thuộc nhân viên này.");
				return capnhatthongtindn(model);
			}
		}
		else if(id.equals(request.getAttribute("loginid") ) )
		{
			model.addAttribute("message","Không thể tài khoản đang đăng nhập.");
			return capnhatthongtindn(model);
		}
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(tk);
			t.commit();
			model.addAttribute("message","Xóa thành công!");
		}
		catch (Exception e) {
			t.rollback();
			model.addAttribute("message","Xóa thất bại.");
		}
		finally {
			session.close();
		}
		return "qtv/capnhatthongtindn";
	}
	
	@RequestMapping(params = "dangxuat")
	public String dangxuat(ModelMap model) {
		return "redirect:dangnhap.htm";
	}
	
}
