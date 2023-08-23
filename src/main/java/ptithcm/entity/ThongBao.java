package ptithcm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "ThongBao")
public class ThongBao {
	@Id @GeneratedValue
	private String IDTB;
	private String TENTB;
	private String DOITUONGTB;
	private String NOIDUNGTB;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
	private Date THOIGIANTB;
	
	@ManyToOne
	@JoinColumn(name="IDNV")
	private NhanVien NHANVIEN;

	//NOP MAPPING
	public String getTENDOITUONGTB() {
		if(DOITUONGTB.equals("SV"))
			return "Sinh viên";
		if(DOITUONGTB.equals("GV"))
			return "Giảng viên";
		if(DOITUONGTB.equals("NV"))
			return "Nhân viên";
		return null;
	}
	
	public String getIDTB() {
		return IDTB;
	}

	public void setIDTB(String iDTB) {
		IDTB = iDTB;
	}

	public String getTENTB() {
		return TENTB;
	}

	public void setTENTB(String tENTB) {
		TENTB = tENTB;
	}

	public String getDOITUONGTB() {
		return DOITUONGTB;
	}

	public void setDOITUONGTB(String dOITUONGTB) {
		DOITUONGTB = dOITUONGTB;
	}

	public String getNOIDUNGTB() {
		return NOIDUNGTB;
	}

	public void setNOIDUNGTB(String nOIDUNGTB) {
		NOIDUNGTB = nOIDUNGTB;
	}

	public Date getTHOIGIANTB() {
		return THOIGIANTB;
	}

	public void setTHOIGIANTB(Date tHOIGIANTB) {
		THOIGIANTB = tHOIGIANTB;
	}

	public NhanVien getNHANVIEN() {
		return NHANVIEN;
	}

	public void setNHANVIEN(NhanVien nHANVIEN) {
		NHANVIEN = nHANVIEN;
	}
	
}
