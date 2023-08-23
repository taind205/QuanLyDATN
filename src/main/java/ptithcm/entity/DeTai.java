package ptithcm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DeTai")
public class DeTai {
	@Id @GeneratedValue
	private Integer IDDETAI;
	private String TENDETAI;
	private String CHITIETDETAI;
	private String GHICHU;

	@ManyToOne
	@JoinColumn(name="IDCN")
	private ChuyenNganh CHUYENNGANH;
	@ManyToOne
	@JoinColumn(name="IDGV")
	private GiangVien GIANGVIEN;
	
	public Integer getIDDETAI() {
		return IDDETAI;
	}
	public void setIDDETAI(Integer iDDETAI) {
		IDDETAI = iDDETAI;
	}
	public String getTENDETAI() {
		return TENDETAI;
	}
	public void setTENDETAI(String tENDETAI) {
		TENDETAI = tENDETAI;
	}
	public String getCHITIETDETAI() {
		return CHITIETDETAI;
	}
	public void setCHITIETDETAI(String cHITIETDETAI) {
		CHITIETDETAI = cHITIETDETAI;
	}
	public String getGHICHU() {
		return GHICHU;
	}
	public void setGHICHU(String gHICHU) {
		GHICHU = gHICHU;
	}
	public ChuyenNganh getCHUYENNGANH() {
		return CHUYENNGANH;
	}
	public void setCHUYENNGANH(ChuyenNganh cHUYENNGANH) {
		CHUYENNGANH = cHUYENNGANH;
	}
	public GiangVien getGIANGVIEN() {
		return GIANGVIEN;
	}
	public void setGIANGVIEN(GiangVien gIANGVIEN) {
		GIANGVIEN = gIANGVIEN;
	}
}
