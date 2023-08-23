package ptithcm.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "DoAn")
public class DoAn {
	@Id @GeneratedValue
	private Integer IDDA;
	@ManyToOne
	@JoinColumn(name="MASV")
	private SinhVien SINHVIEN;
	@ManyToOne
	@JoinColumn(name="IDGVHD")
	private GiangVien GIANGVIENHD;
	@ManyToOne
	@JoinColumn(name="IDDETAI")
	private DeTai DETAI;
	
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private Date THOIGIANGAPGVHD;
	private String DIADIEMGAPGVHD;
	private Double DIEMHUONGDAN;
	private String NHANXETGVHD;
	private Boolean DATYEUCAU;
	private Boolean DAPCGVPB;
	private Double DIEMCUOICUNG;
	
	public Double getDIEMCUOICUNG() {
		return DIEMCUOICUNG;
	}
	public void setDIEMCUOICUNG(Double dIEMCUOICUNG) {
		DIEMCUOICUNG = dIEMCUOICUNG;
	}
	public Integer getIDDA() {
		return IDDA;
	}
	public void setIDDA(Integer iDDA) {
		IDDA = iDDA;
	}
	public SinhVien getSINHVIEN() {
		return SINHVIEN;
	}
	public void setSINHVIEN(SinhVien sINHVIEN) {
		SINHVIEN = sINHVIEN;
	}
	public GiangVien getGIANGVIENHD() {
		return GIANGVIENHD;
	}
	public void setGIANGVIENHD(GiangVien gIANGVIENHD) {
		GIANGVIENHD = gIANGVIENHD;
	}
	public DeTai getDETAI() {
		return DETAI;
	}
	public void setDETAI(DeTai dETAI) {
		DETAI = dETAI;
	}
	public Date getTHOIGIANGAPGVHD() {
		return THOIGIANGAPGVHD;
	}
	public void setTHOIGIANGAPGVHD(Date tHOIGIANGAPGVHD) {
		THOIGIANGAPGVHD = tHOIGIANGAPGVHD;
	}
	public String getDIADIEMGAPGVHD() {
		return DIADIEMGAPGVHD;
	}
	public void setDIADIEMGAPGVHD(String dIADIEMGAPGVHD) {
		DIADIEMGAPGVHD = dIADIEMGAPGVHD;
	}
	public Double getDIEMHUONGDAN() {
		return DIEMHUONGDAN;
	}
	public void setDIEMHUONGDAN(Double dIEMHUONGDAN) {
		DIEMHUONGDAN = dIEMHUONGDAN;
	}
	public String getNHANXETGVHD() {
		return NHANXETGVHD;
	}
	public void setNHANXETGVHD(String nHANXETGVHD) {
		NHANXETGVHD = nHANXETGVHD;
	}
	public Boolean getDATYEUCAU() {
		return DATYEUCAU;
	}
	public void setDATYEUCAU(Boolean dATYEUCAU) {
		DATYEUCAU = dATYEUCAU;
	}
	public Boolean getDAPCGVPB() {
		return DAPCGVPB;
	}
	public void setDAPCGVPB(Boolean dAPCGVPB) {
		DAPCGVPB = dAPCGVPB;
	}

}
