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
@Table(name = "BaoVe")
public class BaoVe {
	@Id @GeneratedValue
	private Integer IDBV;
	@ManyToOne
	@JoinColumn(name="IDDA")
	private DoAn DOAN;
	@ManyToOne
	@JoinColumn(name="IDHD")
	private HoiDong HOIDONG;
	
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private Date THOIGIANBV;
	private String DIADIEMBV;
	private Double DIEMCTHD;
	private Double DIEMTK;
	private Double DIEMUV1;
	private Double DIEMUV2;
	private Double DIEMUV3;
	private String NHANXET;
	
	// Not mapping
	public Double getDIEMHD(){
		int n=0;
		if(DIEMUV1!=null)
			n=n+3;
		if(DIEMUV2!=null)
			n++;
		if(DIEMUV3!=null)
			n++;
		if(n==0)
			return null;
		if(n==3)
			return Math.round(((DIEMCTHD+DIEMTK+DIEMUV1)/3) * 100.0) / 100.0;
		if(n==4)
			return Math.round(((DIEMCTHD+DIEMTK+DIEMUV1+DIEMUV2)/4) * 100.0) / 100.0;
		if(n==5)
			return Math.round(((DIEMCTHD+DIEMTK+DIEMUV1+DIEMUV2+DIEMUV3)/5) * 100.0) / 100.0;
		return null;
	}
	
	// Not mapping
		public Integer getSOTV(){
			int n=0;
			if(DIEMCTHD!=null)
				n++;
			if(DIEMTK!=null)
				n++;
			if(DIEMUV1!=null)
				n++;
			if(DIEMUV2!=null)
				n++;
			if(DIEMUV3!=null)
				n++;
			return n;
		}
	
	public Integer getIDBV() {
		return IDBV;
	}
	public void setIDBV(Integer iDBV) {
		IDBV = iDBV;
	}
	public DoAn getDOAN() {
		return DOAN;
	}
	public void setDOAN(DoAn dOAN) {
		DOAN = dOAN;
	}
	public HoiDong getHOIDONG() {
		return HOIDONG;
	}
	public void setHOIDONG(HoiDong hOIDONG) {
		HOIDONG = hOIDONG;
	}
	public Date getTHOIGIANBV() {
		return THOIGIANBV;
	}
	public void setTHOIGIANBV(Date tHOIGIANBV) {
		THOIGIANBV = tHOIGIANBV;
	}
	public String getDIADIEMBV() {
		return DIADIEMBV;
	}
	public void setDIADIEMBV(String dIADIEMBV) {
		DIADIEMBV = dIADIEMBV;
	}
	
	public Double getDIEMCTHD() {
		return DIEMCTHD;
	}
	public void setDIEMCTHD(Double dIEMCTHD) {
		DIEMCTHD = dIEMCTHD;
	}
	public Double getDIEMTK() {
		return DIEMTK;
	}
	public void setDIEMTK(Double dIEMTK) {
		DIEMTK = dIEMTK;
	}
	public Double getDIEMUV1() {
		return DIEMUV1;
	}
	public void setDIEMUV1(Double dIEMUV1) {
		DIEMUV1 = dIEMUV1;
	}
	public Double getDIEMUV2() {
		return DIEMUV2;
	}
	public void setDIEMUV2(Double dIEMUV2) {
		DIEMUV2 = dIEMUV2;
	}
	public Double getDIEMUV3() {
		return DIEMUV3;
	}
	public void setDIEMUV3(Double dIEMUV3) {
		DIEMUV3 = dIEMUV3;
	}
	public String getNHANXET() {
		return NHANXET;
	}
	public void setNHANXET(String nHANXET) {
		NHANXET = nHANXET;
	}
	
}
