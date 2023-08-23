package ptithcm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "PhanBien")
public class PhanBien {
	@Id @GeneratedValue
	private Integer IDPB;
	public Integer getIDPB() {
		return IDPB;
	}
	public void setIDPB(Integer iDPB) {
		IDPB = iDPB;
	}
	@ManyToOne
	@JoinColumn(name="IDDA")
	private DoAn DOAN;
	@ManyToOne
	@JoinColumn(name="IDGVPB")
	private GiangVien GIANGVIENPB;
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private Date THOIGIANPB;
	private String DIADIEMPB;
	private Double DIEMPHANBIEN;
	private String NHANXETGVPB;
	private Boolean DATYEUCAU;
	private Boolean DAPCBVDA;
	
	public DoAn getDOAN() {
		return DOAN;
	}
	public void setDOAN(DoAn dOAN) {
		DOAN = dOAN;
	}
	public GiangVien getGIANGVIENPB() {
		return GIANGVIENPB;
	}
	public void setGIANGVIENPB(GiangVien gIANGVIENPB) {
		GIANGVIENPB = gIANGVIENPB;
	}
	public Date getTHOIGIANPB() {
		return THOIGIANPB;
	}
	public void setTHOIGIANPB(Date tHOIGIANPB) {
		THOIGIANPB = tHOIGIANPB;
	}
	public String getDIADIEMPB() {
		return DIADIEMPB;
	}
	public void setDIADIEMPB(String dIADIEMPB) {
		DIADIEMPB = dIADIEMPB;
	}
	public Double getDIEMPHANBIEN() {
		return DIEMPHANBIEN;
	}
	public void setDIEMPHANBIEN(Double dIEMPHANBIEN) {
		DIEMPHANBIEN = dIEMPHANBIEN;
	}
	public String getNHANXETGVPB() {
		return NHANXETGVPB;
	}
	public void setNHANXETGVPB(String nHANXETGVPB) {
		NHANXETGVPB = nHANXETGVPB;
	}
	public Boolean getDATYEUCAU() {
		return DATYEUCAU;
	}
	public void setDATYEUCAU(Boolean dATYEUCAU) {
		DATYEUCAU = dATYEUCAU;
	}
	public Boolean getDAPCBVDA() {
		return DAPCBVDA;
	}
	public void setDAPCBVDA(Boolean dAPCBVDA) {
		DAPCBVDA = dAPCBVDA;
	}

}
