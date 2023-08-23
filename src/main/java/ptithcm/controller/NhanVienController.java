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
@RequestMapping("/nhanvien")
@SessionAttributes({"pb", "da", "bv", "hd", "sv", "gv", "cn", "nv"})
public class NhanVienController {
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
			System.out.println(e);
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
			System.out.println(e);
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
			System.out.println(e);
			return false;
		}
	}

	private int checkInput_HD(HoiDong hd)
	{
		ArrayList<String> tv = new ArrayList<String>();
		tv.add(hd.getCHUTICHHD().getIDGV());
		tv.add(hd.getTHUKY().getIDGV());
		tv.add(hd.getUV1().getIDGV());
		if(hd.getUV2()!=null)
		tv.add(hd.getUV2().getIDGV());
		else tv.add("NULL");
		if(hd.getUV3()!=null)
		tv.add(hd.getUV3().getIDGV());
			else tv.add("NULL");
		if(tv.get(0).equals(tv.get(1)) || tv.get(0).equals(tv.get(2))
				|| tv.get(0).equals(tv.get(3)) || tv.get(0).equals(tv.get(4))
				|| tv.get(1).equals(tv.get(2)) || tv.get(1).equals(tv.get(3))
				|| tv.get(1).equals(tv.get(4)) || tv.get(2).equals(tv.get(3))
				|| tv.get(2).equals(tv.get(3)) || 
				(tv.get(3).equals(tv.get(4)) && !tv.get(3).equals("NULL")) )
			return 1; //same element error
		else
			return 0;
	}
	
	private void kTDKSV(SinhVien sv)
	{
		DieuKienLamDoAn dk = (DieuKienLamDoAn) getObj(DieuKienLamDoAn.class, 1);
		if(sv.getDIEMTBTL()==null || sv.getSOTCTL()==null 
				||sv.getDIEMTBTL()<dk.getDIEMTBXETTN() 
				|| sv.getSOTCTL()<dk.getSTCTLXETTN())
			sv.setDUDKXETTN(false);
		else sv.setDUDKXETTN(true);
		
		ChuyenNganh cn = (ChuyenNganh) getList("FROM ChuyenNganh WHERE IDCN ="
				+ sv.getCHUYENNGANH().getIDCN() ).get(0);
		if(sv.getDIEMTBTL() ==null || sv.getSOTCTL()==null 
				|| sv.getDIEMTBTL()<cn.getDIEMLAMDA()
				|| sv.getSOTCTL()<cn.getSOTCLAMDA() )
			sv.setDUDKLAMDA(false);
		else sv.setDUDKLAMDA(true);
	}
	
	/*private Boolean deleteTwo(Object o1, Object o2)
	{
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(o1);
			session.flush();
			session.evict(o1);
			session.clear(); 
			session.delete(o2);
			session.flush();
			t.commit();
			session.close();
			return true;
		}
		catch (Exception e) {
			t.rollback();
			session.close();
			System.out.println(e);
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			System.out.println(4);
			return false;
		}
	}*/
	
	@RequestMapping()
	public String index(ModelMap model, HttpServletRequest request) {
		return thongbao(model, request);
	}

	@RequestMapping(params = "thongbao")
	public String thongbao(ModelMap model, HttpServletRequest request) { 
		String idnv = (String) request.getAttribute("loginid");
		model.addAttribute("dsthongbao", 
				getList("FROM ThongBao WHERE DOITUONGTB='NV'"));
		model.addAttribute("dstb2", 
				getList("FROM ThongBao WHERE IDNV= '"+idnv+"'"));
		return "nhanvien/thongbao";
	}
	
	@RequestMapping(params="xemthongbao")
	public String xemthongbao(@RequestParam("id")String id, ModelMap model) {
		model.addAttribute("thongbao", getObj(ThongBao.class, id));
		return "nhanvien/xemthongbao";
	}
	
	@RequestMapping(params = "xoatb")
	public String xoatb(ModelMap model, HttpServletRequest request, 
			@RequestParam("idtb")String id) {
		if(deleteObj(ThongBao.class, id))
		model.addAttribute("message","Xóa thành công!");
		else model.addAttribute("message","Xóa thất bại.");
		
		return thongbao(model, request);
	}
	
	@RequestMapping(params = "thietlapdklamda", method=RequestMethod.GET)
	public String thietlapdklamda(ModelMap model) {
		model.addAttribute("dk", getObj(DieuKienLamDoAn.class, 1));
		model.addAttribute("dscn", getList("FROM ChuyenNganh"));
	return "nhanvien/thietlapdklamda";
	}
	
	@RequestMapping(params = "thietlapdklamda", method=RequestMethod.POST)
	public String thietlapdklamda(ModelMap model, 
			@ModelAttribute("dk") DieuKienLamDoAn dk) 
					throws IllegalStateException, SystemException {
		
		if(update(dk))
			model.addAttribute("message","Cập nhật thành công!");
		else model.addAttribute("message","Cập nhật thất bại."); 
		
		return "nhanvien/thietlapdklamda";
	}
	
	@RequestMapping(params = "thongtinhd")
	public String thongtinhd(ModelMap model) {
		model.addAttribute("dshd", getList("FROM HoiDong"));
		return "nhanvien/thongtinhd";
	}
	
	@RequestMapping(params = "themhd", method=RequestMethod.GET)
	public String themhd(ModelMap model) {
		model.addAttribute("dsgv", getList("FROM GiangVien"));
		model.addAttribute("hd", new HoiDong());
		return "nhanvien/themhd";
	}
	
	@RequestMapping(params = "themhd", method=RequestMethod.POST)
	public String themhd(ModelMap model,
			@ModelAttribute("hd")HoiDong hd) {
		if(!getList("FROM HoiDong WHERE IDHD = '"+hd.getIDHD()+"'").isEmpty()) 
		{
			model.addAttribute("message","Mã hội đồng bị trùng.");
			model.addAttribute("dsgv", getList("FROM GiangVien"));
			return "nhanvien/themhd";
		}
		if(hd.getUV2().getIDGV().equals("NULL"))
		{
			System.out.print(hd.getUV2().getIDGV());
			System.out.print("UV2 NULL");
			hd.setUV2(null);
		}
		if(hd.getUV3().getIDGV().equals("NULL"))
		{
			System.out.print(hd.getUV3().getIDGV());
			System.out.print("UV3 NULL");
			hd.setUV3(null);
		}
		if(checkInput_HD(hd)==1)
		{
			model.addAttribute("message","Mỗi thành viên trong hội đồng chỉ được đảm nhận một vị trí.");
			model.addAttribute("dsgv", getList("FROM GiangVien"));
			return "nhanvien/themhd";
		}
		if(insert(hd))
			model.addAttribute("message","Thêm thành công!");
		else model.addAttribute("message","Thêm thất bại."); 
		return thongtinhd(model);
	}

	@RequestMapping(params = "suahd", method=RequestMethod.GET)
	public String suahd(ModelMap model,
			@RequestParam("idhd")String id) {
		model.addAttribute("dsgv", getList("FROM GiangVien"));
		model.addAttribute("hd", getObj(HoiDong.class, id));
		return "nhanvien/suahd";
	}
	
	@RequestMapping(params = "suahd", method=RequestMethod.POST)
	public String suahd(ModelMap model,
			@ModelAttribute("hd")HoiDong hd) {
		if(hd.getUV2().getIDGV().equals("NULL"))
		{
			System.out.print("UV2 NULL");
			hd.setUV2(null);
		}
		if(hd.getUV3().getIDGV().equals("NULL"))
		{
			System.out.print("UV3 NULL");
			hd.setUV3(null);
		}
		if(checkInput_HD(hd)==1)
		{
			model.addAttribute("message","Mỗi thành viên trong hội đồng chỉ được đảm nhận một vị trí.");
			model.addAttribute("dsgv", getList("FROM GiangVien"));
			return "nhanvien/suahd";
		}
		if(update(hd))
			model.addAttribute("message","Cập nhật thành công!");
		else model.addAttribute("message","Cập nhật thất bại."); 
		return thongtinhd(model);
	}

	@RequestMapping(params = "xoahd")
	public String xoahd(ModelMap model,
			@RequestParam("idhd")String id) {
		if(!getList("FROM BaoVe WHERE IDHD = '"+id+"'").isEmpty())
		{
			model.addAttribute("message","Không thể xóa vì hội đồng đã được phân công chấm đồ án.");
			return thongtinhd(model);
		}
		
		if(deleteObj(HoiDong.class, id))
		model.addAttribute("message","Xóa thành công!");
		else model.addAttribute("message","Xóa thất bại.");
		
		return thongtinhd(model);
	}


	@RequestMapping(params = "ttgvhd")
	public String ttgvhd(ModelMap model) {
		model.addAttribute("dsda", getList("FROM DoAn"));
		model.addAttribute("dssv", 
				getList("FROM SinhVien SV WHERE SV.XACNHANLAMDA=true AND SV.DAPHANCONGDA=false") );
		model.addAttribute("dssv2",getList("FROM SinhVien Where XACNHANLAMDA=false") );
		model.addAttribute("dssv3",getList("FROM SinhVien Where DUDKLAMDA=false") );
		model.addAttribute("dssv4",getList("FROM SinhVien Where DUDKLAMDA=true AND XACNHANLAMDA=NULL") );
		return "nhanvien/ttgvhd";
	}
	
	@RequestMapping(params = "pcgvhd", method=RequestMethod.GET)
	public String pcgvhd(ModelMap model,
			@RequestParam("idsv")String id) {
		model.addAttribute("dsgv", getList("FROM GiangVien"));
		model.addAttribute("sv", getObj(SinhVien.class, id));
		model.addAttribute("da", new DoAn());
		return "nhanvien/pcgvhd";
	}
	
	@RequestMapping(params = "pcgvhd", method=RequestMethod.POST)
	public String pcgvhd(ModelMap model,
			@ModelAttribute("da")DoAn da) {
		SinhVien sv = (SinhVien) getObj(SinhVien.class, da.getSINHVIEN().getMASV());
		sv.setDAPHANCONGDA(true);
		da.setDAPCGVPB(false);
		if(insertAndUpdate(da,sv))
			model.addAttribute("message","Phân công thành công.");
		else model.addAttribute("message","Phân công thất bại.");
		return ttgvhd(model);
	}

	@RequestMapping(params = "suagvhd", method=RequestMethod.GET)
	public String suagvhd(ModelMap model,
			@RequestParam("idda")Integer id) {
		
		DoAn da = (DoAn) getObj(DoAn.class, id);
		if(da.getDAPCGVPB())
		{
			model.addAttribute("message","Không thể sửa vì đồ án đã được phân công phản biện.");
			return ttgvhd(model);
		}
		model.addAttribute("da", da);
		model.addAttribute("dsgv", getList("FROM GiangVien"));
		System.out.print(da.getDAPCGVPB());
		return "nhanvien/suagvhd";
	}
	
	@RequestMapping(params = "suagvhd", method=RequestMethod.POST)
	public String suagvhd(ModelMap model,
			@ModelAttribute("da")DoAn da) {
		System.out.print(da.getDAPCGVPB());
		if(update(da))
			model.addAttribute("message","Cập nhật thành công!");
		else model.addAttribute("message","Cập nhật thất bại.");
		return ttgvhd(model);
	}
	
	@RequestMapping(params = "xoagvhd", method=RequestMethod.POST)
	public String xoagvhd(ModelMap model,
			@ModelAttribute("da")DoAn da) {
		System.out.print(da.getDAPCGVPB());
		if(da.getDAPCGVPB())
		{
			model.addAttribute("message","Không thể xóa vì đồ án đã được phân công phản biện.");
			return ttgvhd(model);
		}
		
		SinhVien sv = (SinhVien) getObj(SinhVien.class, da.getSINHVIEN().getMASV());
		sv.setDAPHANCONGDA(false);
		if(deleteAndUpdate(DoAn.class, da.getIDDA(),sv))
			model.addAttribute("message","Đã hủy phân công.");
		else model.addAttribute("message","Có lỗi xảy ra, chưa thể hủy phân công.");
		
		return ttgvhd(model);
	}
	
	@RequestMapping(params = "ttgvpb")
	public String ttgvpb(ModelMap model) {
		model.addAttribute("dspb", getList("FROM PhanBien"));
		model.addAttribute("dsda", 
				getList("FROM DoAn DA WHERE DA.DATYEUCAU=true AND DA.DAPCGVPB=false"));
		model.addAttribute("dsda2", 
				getList("FROM DoAn DA WHERE DA.DATYEUCAU=false"));
		return "nhanvien/ttgvpb";
	}
	
	@RequestMapping(params = "pcgvpb", method=RequestMethod.GET)
	public String pcgvpb(ModelMap model,
			@RequestParam("idda")Integer id) {
		DoAn da = (DoAn) getObj(DoAn.class, id);
		model.addAttribute("da", da);
		model.addAttribute("pb", new PhanBien());
		model.addAttribute("dsgv", 
				getList("FROM GiangVien GV WHERE GV.IDGV!= '"
						+ da.getGIANGVIENHD().getIDGV()+"'"));
		return "nhanvien/pcgvpb";
	}
	
	@RequestMapping(params = "pcgvpb", method=RequestMethod.POST)
	public String pcgvpb(ModelMap model,
			@ModelAttribute("pb")PhanBien pb) {
		DoAn da = (DoAn) getObj(DoAn.class, pb.getDOAN().getIDDA());
		da.setDAPCGVPB(true);
		pb.setDAPCBVDA(false);
		if(insertAndUpdate(pb,da))
			model.addAttribute("message","Đã phân công.");
		else model.addAttribute("message","Có lỗi xảy ra, chưa thể phân công.");
		return ttgvpb(model);
	}

	@RequestMapping(params = "suagvpb", method=RequestMethod.GET)
	public String suagvpb(ModelMap model,
			@RequestParam("idpb")Integer id) {
		PhanBien pb = (PhanBien) getObj(PhanBien.class, id); 
		if(pb.getDAPCBVDA())
		{
			model.addAttribute("message","Không thể sửa vì đồ án đã được phân công bảo vệ.");
			return ttgvpb(model);
		}
		model.addAttribute("pb", pb);
		model.addAttribute("dsgv", 
				getList("FROM GiangVien GV WHERE GV.IDGV!= '"
						+pb.getDOAN().getGIANGVIENHD().getIDGV()+"'"));
		return "nhanvien/suagvpb";
	}
	
	@RequestMapping(params = "suagvpb", method=RequestMethod.POST)
	public String suagvpb(ModelMap model,
			@ModelAttribute("pb")PhanBien pb) {
		if(update(pb))
			model.addAttribute("message","Cập nhật thành công!");
		else model.addAttribute("message","Cập nhật thất bại.");
		return ttgvpb(model);
	}
	
	@RequestMapping(params = "xoagvpb", method=RequestMethod.POST)
	public String xoagvpb(ModelMap model,
			@ModelAttribute("pb")PhanBien pb) {
		if(pb.getDAPCBVDA())
		{
			model.addAttribute("message","Không thể bỏ phân công vì đồ án đã được phân công bảo vệ.");
			return ttgvpb(model);
		}
		DoAn da = (DoAn) getObj(DoAn.class, pb.getDOAN().getIDDA());
		da.setDAPCGVPB(false);
		if(deleteAndUpdate(PhanBien.class, pb.getIDPB(),da))
			model.addAttribute("message","Đã hủy phân công.");
		else model.addAttribute("message","Có lỗi xảy ra, chưa thể hủy phân công.");
		
		return ttgvpb(model);
	}
	
	@RequestMapping(params = "ttbvda")
	public String ttbvda(ModelMap model) {
		model.addAttribute("dsbv", getList("FROM BaoVe"));
		model.addAttribute("dspb", 
				getList("FROM PhanBien PB WHERE PB.DATYEUCAU=true AND PB.DAPCBVDA=false"));
		model.addAttribute("dspb2", 
				getList("FROM PhanBien PB WHERE PB.DATYEUCAU=false"));
		return "nhanvien/ttbvda";
	}
	
	@RequestMapping(params = "pcbvda", method=RequestMethod.GET)
	public String pcbvda(ModelMap model,
			@RequestParam("idpb")Integer id) {
		PhanBien pb = (PhanBien) getObj(PhanBien.class, id);
		model.addAttribute("pb", pb);
		model.addAttribute("bv", new BaoVe());
		String idgv = pb.getDOAN().getGIANGVIENHD().getIDGV();
		String hql = "FROM HoiDong HD WHERE HD.CHUTICHHD.IDGV != '"+idgv
				+ "' AND HD.THUKY.IDGV != '" + idgv
				+ "' AND HD.UV1.IDGV != '" + idgv
				+ "' AND (HD.UV2 is null OR HD.UV2.IDGV != '"+idgv
				+ "') AND (HD.UV3 is null OR HD.UV3.IDGV != '"+idgv+"')";
		model.addAttribute("dshd", getList(hql));
		model.addAttribute("dshd2", getList("From HoiDong"));
		return "nhanvien/pcbvda";
	}
	
	@RequestMapping(params = "pcbvda", method=RequestMethod.POST)
	public String pcbvda(ModelMap model,
			@ModelAttribute("bv")BaoVe bv) {
		PhanBien pb = (PhanBien) getList("FROM PhanBien PB WHERE PB.DOAN.IDDA="
				+ bv.getDOAN().getIDDA()).get(0);
		pb.setDAPCBVDA(true);
		if(insertAndUpdate(bv,pb))
			model.addAttribute("message","Phân công thành công!");
		else model.addAttribute("message","Phân công thất bại.");
		
		return ttbvda(model);
	}

	@RequestMapping(params = "suabv", method=RequestMethod.GET)
	public String suabv(ModelMap model,
			@RequestParam("idbv")Integer id) {
		BaoVe bv = (BaoVe) getObj(BaoVe.class, id);
		model.addAttribute("bv", bv);
		String idgv = bv.getDOAN().getGIANGVIENHD().getIDGV();
		String hql = "FROM HoiDong HD WHERE HD.CHUTICHHD.IDGV != '"+idgv
				+ "' AND HD.THUKY.IDGV != '" + idgv
				+ "' AND HD.UV1.IDGV != '" + idgv
				+ "' AND (HD.UV2 is null OR HD.UV2.IDGV != '"+idgv
				+ "') AND (HD.UV3 is null OR HD.UV3.IDGV != '"+idgv+"')";
		model.addAttribute("dshd", getList(hql));
		model.addAttribute("dshd2", getList("From HoiDong"));
		return "nhanvien/suabv";
	}
	
	@RequestMapping(params = "suabv", method=RequestMethod.POST)
	public String suabv(ModelMap model,
			@ModelAttribute("bv")BaoVe bv) {
		if(update(bv))
			model.addAttribute("message","Cập nhật thành công!");
		else model.addAttribute("message","Cập nhật thất bại.");
		return ttbvda(model);
	}
	
	@RequestMapping(params = "xoabv", method=RequestMethod.POST)
	public String xoabv(ModelMap model,
			@ModelAttribute("bv")BaoVe bv) {
		PhanBien pb = (PhanBien) getList("FROM PhanBien PB WHERE IDDA= "
				+bv.getDOAN().getIDDA()).get(0);
		pb.setDAPCBVDA(false);
		if(deleteAndUpdate(BaoVe.class, bv.getIDBV(),pb))
			model.addAttribute("message","Đã hủy phân công.");
		else model.addAttribute("message","Có lỗi xảy ra, chưa thể hủy phân công.");
		return ttbvda(model);
	}
	
	
	@RequestMapping(params = "diembv")
	public String diembv(ModelMap model) {
		model.addAttribute("dsbv", getList("From BaoVe"));
		return "nhanvien/diembv";
	}
	
	@RequestMapping(params = "cndiembv", method=RequestMethod.GET)
	public String cndiembv(ModelMap model, 
			@RequestParam("idbv")Integer id) {
		BaoVe bv = (BaoVe) getObj(BaoVe.class, id);
		if(bv.getHOIDONG().getUV2()!=null)
			model.addAttribute("uv2","1");
		if(bv.getHOIDONG().getUV3()!=null)
			model.addAttribute("uv3","1");
		model.addAttribute("bv", bv);
		return "nhanvien/cndiembv";
	}
	
	@RequestMapping(params = "cndiembv", method=RequestMethod.POST)
	public String cndiembv(ModelMap model,
			@ModelAttribute("bv")BaoVe bv) {
		if(update(bv))
			model.addAttribute("message","Cập nhật thành công!");
		else model.addAttribute("message","Cập nhật thất bại.");
		return diembv(model);
	}
	

	@RequestMapping(params = "phatthongbao", method=RequestMethod.GET)
	public String phatthongbao(ModelMap model) {
		model.addAttribute("thongbao", new ThongBao());
		return "nhanvien/phatthongbao";
	}

	@RequestMapping(params = "phatthongbao", method=RequestMethod.POST)
	public String phatthongbao(ModelMap model, HttpServletRequest request, 
			@ModelAttribute("thongbao") ThongBao tb) 
					throws IllegalStateException, SystemException {
		tb.setTHOIGIANTB(new Date());
		tb.setNHANVIEN((NhanVien) getObj(NhanVien.class, (String) request.getAttribute("loginid") ) );
		if(insert(tb))
			model.addAttribute("message","Phát thông báo thành công!");
		else model.addAttribute("message","Phát thông báo thất bại.");
		return "nhanvien/phatthongbao";
	}
	
	@RequestMapping(params = "thongtinsv")
	public String thongtinsv(ModelMap model) {
		model.addAttribute("dssv", getList("FROM SinhVien"));
		return "nhanvien/thongtinsv";
	}
	
	@RequestMapping(params = "themsv", method=RequestMethod.GET)
	public String themsv(ModelMap model) {
		model.addAttribute("dscn", getList("FROM ChuyenNganh"));
		model.addAttribute("dslop", getList("FROM Lop"));
		model.addAttribute("sv", new SinhVien());
		return "nhanvien/themsv";
	}
	
	@RequestMapping(params = "themsv", method=RequestMethod.POST)
	public String themsv(ModelMap model,
			@ModelAttribute("sv")SinhVien sv) {
		if(!getList("FROM SinhVien WHERE MASV = '"+sv.getMASV()+"'").isEmpty()) 
		{
			model.addAttribute("message","Mã sinh viên bị trùng.");
			model.addAttribute("dscn", getList("FROM ChuyenNganh"));
			model.addAttribute("dslop", getList("FROM Lop"));
			return "nhanvien/themsv";
		}
		//else:
		sv.setDAPHANCONGDA(false);
		kTDKSV(sv);
		TaiKhoan tk = new TaiKhoan();
		tk.setID(sv.getMASV());
		tk.setMATKHAU("123");
		tk.setLOAITK("SV");
		if(insertTwo(sv,tk))
			model.addAttribute("message","Thêm thành công!");
		else model.addAttribute("message","Thêm thất bại."); 
		return thongtinsv(model);
	}

	@RequestMapping(params = "xoasv")
	public String xoasv(ModelMap model,
			@RequestParam("idsv")String id) {
		if(!getList("FROM DoAn WHERE MASV = '"+id+"'").isEmpty())
		{
			model.addAttribute("message","Không thể xóa vì sinh viên đã được phân công đồ án.");
			return thongtinsv(model);
		}
	    if(deleteObj(SinhVien.class, id))
	    	model.addAttribute("message","Xóa thành công!");
		else model.addAttribute("message","Xóa thất bại.");
	    
	    return thongtinsv(model);
	}
	
	// SUA TAI KHOAN SINH VIEN
	@RequestMapping(params = "suasv", method=RequestMethod.GET) 
	public String suasv(ModelMap model,
			@RequestParam("idsv")String id) {
		try {
			model.addAttribute("dscn", getList("FROM ChuyenNganh"));
			model.addAttribute("dslop", getList("FROM Lop"));
			TaiKhoan tk = (TaiKhoan) getObj(TaiKhoan.class, id);
			model.addAttribute("mk", tk.getMATKHAU());
			model.addAttribute("sv", getObj(SinhVien.class, id));
			Boolean dapcda = !getList("FROM DoAn Where MASV='"+id+"'").isEmpty();
			if(dapcda) 
				model.addAttribute("dapcda", "1");
			else model.addAttribute("chuapcda", "1");
			return "nhanvien/suasv";
		}
		catch (Exception e)
		{
			model.addAttribute("dssv", getList("FROM SinhVien"));			
			model.addAttribute("message", "Tài khoản không tồn tại.");
			return "nhanvien/thongtinsv";
		}	
	}
	
	@RequestMapping(params = "suasv", method=RequestMethod.POST)
	public String suasv(ModelMap model,
			@ModelAttribute("sv")SinhVien sv,
			@RequestParam("mk")String mk) {
		if(getList("FROM DoAn Where MASV='"+sv.getMASV()+"'").isEmpty())
			kTDKSV(sv);
		TaiKhoan tk = (TaiKhoan) getObj(TaiKhoan.class, sv.getMASV());
		tk.setMATKHAU(mk);
		if(updateTwo(sv,tk))
			model.addAttribute("message","Cập nhật thành công!");
		else model.addAttribute("message","Cập nhật thất bại."); 
		return thongtinsv(model);
	}
	
	@RequestMapping(params = "thongtingv")
	public String thongtingv(ModelMap model) {
		model.addAttribute("dsgv", getList("FROM GiangVien"));
		return "nhanvien/thongtingv";
	}
	
	@RequestMapping(params = "themgv", method=RequestMethod.GET)
	public String themgv(ModelMap model) {
		model.addAttribute("gv", new GiangVien());
		return "nhanvien/themgv";
	}
	
	@RequestMapping(params = "themgv", method=RequestMethod.POST)
	public String themgv(ModelMap model,
			@ModelAttribute("gv")GiangVien gv) {
		if(!getList("FROM GiangVien WHERE IDGV = '"+gv.getIDGV()+"'").isEmpty()) 
		{
			model.addAttribute("message","Mã giảng viên bị trùng.");
			return "nhanvien/themgv";
		}
		//else:
		TaiKhoan tk = new TaiKhoan();
		tk.setID(gv.getIDGV());
		tk.setMATKHAU("123");
		tk.setLOAITK("GV");
		if(insertTwo(gv,tk))
			model.addAttribute("message","Thêm thành công!");
		else model.addAttribute("message","Thêm thất bại.");
		return thongtingv(model);
	}

	@RequestMapping(params = "xoagv")
	public String xoagv(ModelMap model,
			@RequestParam("idgv")String id) {
		if(!getList("FROM HoiDong WHERE CHUTICHHD.IDGV = '"+id
				+"' OR THUKY.IDGV = '"+id+"' OR UV1.IDGV = '"+id
				+"' OR UV2.IDGV = '"+id+"' OR UV3.IDGV = '"+id+"'").isEmpty())
		{
			model.addAttribute("message","Không thể xóa vì giảng viên đã thuộc một hội đồng.");
			return thongtingv(model);
		}
		if(!getList("FROM PhanBien WHERE IDGVPB = '"+id+"'").isEmpty())
		{
			model.addAttribute("message","Không thể xóa vì giảng viên đã được phân công phản biện đồ án.");
			return thongtingv(model);
		}
		if(!getList("FROM DoAn WHERE IDGVHD = '"+id+"'").isEmpty())
		{
			model.addAttribute("message","Không thể xóa vì giảng viên đã được phân công hướng dẫn đồ án.");
			return thongtingv(model);
		}
		if(!getList("FROM DeTai WHERE IDGV = '"+id+"'").isEmpty())
		{
			model.addAttribute("message","Không thể xóa giảng viên vì đã có một đề tài thuộc giảng viên này.");
			return thongtingv(model);
		}
		if(deleteObj(GiangVien.class, id))
	    		model.addAttribute("message","Xóa thành công!");
		else model.addAttribute("message","Xóa thất bại.");
		return thongtingv(model);
	}
	
	// SUA TAI KHOAN GIANG VIEN
	@RequestMapping(params = "suagv", method=RequestMethod.GET) 
	public String suagv(ModelMap model,
			@RequestParam("idgv")String id) {
		try {
			TaiKhoan tk = (TaiKhoan) getObj(TaiKhoan.class, id);
			model.addAttribute("mk", tk.getMATKHAU());
			model.addAttribute("gv", getObj(GiangVien.class, id));
			return "nhanvien/suagv";
		}
		catch (Exception e)
		{
			model.addAttribute("dsgv", getList("FROM GiangVien"));			
			model.addAttribute("message", "Tài khoản không tồn tại.");
			return "nhanvien/thongtingv";
		}	
	}
	
	@RequestMapping(params = "suagv", method=RequestMethod.POST)
	public String suagv(ModelMap model,
			@ModelAttribute("gv")GiangVien gv,
			@RequestParam("mk")String mk) {
		TaiKhoan tk = (TaiKhoan) getObj(TaiKhoan.class, gv.getIDGV());
		tk.setMATKHAU(mk);
		if(updateTwo(gv,tk))
			model.addAttribute("message","Cập nhật thành công!");
		else model.addAttribute("message","Cập nhật thất bại.");
		return thongtingv(model);
	}
	
	@RequestMapping(params = "ttcnganh")
	public String ttcnganh(ModelMap model) {
		model.addAttribute("dscn", getList("FROM ChuyenNganh"));
		return "nhanvien/ttcnganh";
	}
	
	@RequestMapping(params = "themcn", method=RequestMethod.GET)
	public String themcn(ModelMap model) {
		model.addAttribute("cn", new ChuyenNganh());
		return "nhanvien/themcn";
	}
	
	@RequestMapping(params = "themcn", method=RequestMethod.POST)
	public String themcn(ModelMap model,
			@ModelAttribute("cn")ChuyenNganh cn) {
		if(!getList("FROM ChuyenNganh WHERE IDCN = "+cn.getIDCN()+"").isEmpty()) 
		{
			model.addAttribute("message","Mã chuyên ngành bị trùng.");
			return "nhanvien/themcn";
		}
		if(!getList("FROM ChuyenNganh WHERE TENCHUYENNGANH = '"+cn.getTENCHUYENNGANH()+"'").isEmpty()) 
		{
			model.addAttribute("message","Tên chuyên ngành bị trùng.");
			return "nhanvien/themcn";
		}
		
		if(insert(cn))
			model.addAttribute("message","Thêm thành công!");
		else model.addAttribute("message","Thêm thất bại.");
		return ttcnganh(model);
	}
	
	@RequestMapping(params = "suacn", method=RequestMethod.GET)
	public String suacn(ModelMap model,
			@RequestParam("idcn")Integer id) {
		model.addAttribute("cn", getObj(ChuyenNganh.class, id));
		return "nhanvien/suacn";
	}
	
	@RequestMapping(params = "suacn", method=RequestMethod.POST)
	public String suacn(ModelMap model,
			@ModelAttribute("cn")ChuyenNganh cn) {
		if(!getList("FROM ChuyenNganh WHERE TENCHUYENNGANH = '"+cn.getTENCHUYENNGANH()+"'").isEmpty()) 
		{
			model.addAttribute("message","Tên chuyên ngành bị trùng.");
			return "nhanvien/themcn";
		}
		if(update(cn))
			model.addAttribute("message","Cập nhật thành công!");
		else model.addAttribute("message","Cập nhật thất bại.");
		return ttcnganh(model);
	}
	
	@RequestMapping(params = "xoacn")
	public String xoacn(ModelMap model,
			@RequestParam("idcn")Integer id) {
		if(!getList("FROM SinhVien WHERE IDCN = "+id).isEmpty())
		{
			model.addAttribute("message","Không thể xóa chuyên ngành vì đã có một sinh viên thuộc chuyên ngành này.");
			return ttcnganh(model);
		}
		if(!getList("FROM DeTai WHERE IDCN = "+id).isEmpty())
		{
			model.addAttribute("message","Không thể xóa chuyên ngành vì đã có một đề tài thuộc chuyên ngành này.");
			return thongtingv(model);
		}
		if(deleteObj(ChuyenNganh.class, id))
			model.addAttribute("message","Xóa thành công!");
		else model.addAttribute("message","Xóa thất bại.");
			
		return ttcnganh(model);
	}
	
	@RequestMapping(params = "ttlop")
	public String ttlop(ModelMap model) {
		model.addAttribute("dslop", getList("FROM Lop"));
		return "nhanvien/ttlop";
	}
	
	@RequestMapping(params = "dslop")
	public String dslop(ModelMap model, @RequestParam("malop")String id) {
		model.addAttribute("dssv", getList("FROM SinhVien WHERE MALOP='"+id+"'"));
		return "nhanvien/thongtinsv";
	}
	
	@RequestMapping(params = "themlop", method=RequestMethod.GET)
	public String themlop(ModelMap model) {
		model.addAttribute("lop", new Lop());
		return "nhanvien/themlop";
	}
	
	@RequestMapping(params = "themlop", method=RequestMethod.POST)
	public String themlop(ModelMap model,
			@ModelAttribute("lop")Lop l) {
		if(!getList("FROM Lop WHERE MALOP = '"+l.getMALOP()+"'").isEmpty()) 
		{
			model.addAttribute("message","Mã lớp bị trùng.");
			return "nhanvien/themlop";
		}
		
		if(insert(l))
			model.addAttribute("message","Thêm thành công!");
		else model.addAttribute("message","Thêm thất bại.");
		return ttlop(model);
	}
	
	@RequestMapping(params = "sualop", method=RequestMethod.GET)
	public String sualop(ModelMap model,
			@RequestParam("malop")String id) {
		model.addAttribute("lop", getObj(Lop.class, id));
		return "nhanvien/sualop";
	}
	
	@RequestMapping(params = "sualop", method=RequestMethod.POST)
	public String sualop(ModelMap model,
			@ModelAttribute("lop")Lop l) {
		if(update(l))
			model.addAttribute("message","Cập nhật thành công!");
		else model.addAttribute("message","Cập nhật thất bại.");
		return ttlop(model);
	}
	
	@RequestMapping(params = "xoalop")
	public String xoalop(ModelMap model,
			@RequestParam("malop")String id) {
		if(!getList("FROM SinhVien WHERE MALOP = '"+id+"'").isEmpty())
		{
			model.addAttribute("message","Không thể xóa lớp vì đã có một sinh viên thuộc lớp này.");
			return ttlop(model);
		}
		if(deleteObj(Lop.class, id))
			model.addAttribute("message","Xóa thành công!");
		else model.addAttribute("message","Xóa thất bại.");
			
		return ttlop(model);
	}
	
	@RequestMapping(params = "ttcanhan")
	public String ttcanhan(ModelMap model, HttpServletRequest request) {
		String idnv= (String) request.getAttribute("loginid");
		model.addAttribute("nv", getObj(NhanVien.class,idnv));
		return "nhanvien/ttcanhan";
	}
	
	@RequestMapping(params = "ttcanhan", method=RequestMethod.POST)
	public String ttcanhan(ModelMap model, HttpServletRequest request, 
				@ModelAttribute("nv")NhanVien nv) {
		if(update(nv))
			model.addAttribute("message","Cập nhật thành công!");
		else model.addAttribute("message","Cập nhật thất bại.");
		return ttcanhan(model, request);
	}
	
	@RequestMapping(params = "doimk")
	public String doimk(ModelMap model) {
		model.addAttribute("passchange",new ChangePassword());
		return "nhanvien/doimk";
	}
	
	@RequestMapping(params = "doimk", method=RequestMethod.POST)
	public String doimk(ModelMap model, HttpServletRequest request, 
			@ModelAttribute("passchange")ChangePassword p) {
		String idnv = (String) request.getAttribute("loginid");
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
				TaiKhoan tk = (TaiKhoan) getObj(TaiKhoan.class, idnv);
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
