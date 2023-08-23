package ptithcm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "SinhVien")
public class SinhVien {
	@Id
	private String MASV;
	private String HOSV;
	private String TENSV;
	private String PHAI;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date NGAYSINH;
	@ManyToOne
	@JoinColumn(name="MALOP")
	private Lop LOP;
	@ManyToOne
	@JoinColumn(name="IDCN")
	private ChuyenNganh CHUYENNGANH;
	private String SDT;
	private String EMAIL;
	private Double DIEMTBTL;
	private Integer SOTCTL;
	private Boolean DUDKXETTN;
	private Boolean DUDKLAMDA;
	private Boolean XACNHANLAMDA;
	private Boolean DAPHANCONGDA;
	
	public Boolean getDAPHANCONGDA() {
		return DAPHANCONGDA;
	}
	public void setDAPHANCONGDA(Boolean dAPHANCONGDA) {
		DAPHANCONGDA = dAPHANCONGDA;
	}
	public String getMASV() {
		return MASV;
	}
	public void setMASV(String mASV) {
		MASV = mASV;
	}
	public String getHOSV() {
		return HOSV;
	}
	public void setHOSV(String hOSV) {
		HOSV = hOSV;
	}
	public String getTENSV() {
		return TENSV;
	}
	public void setTENSV(String tENSV) {
		TENSV = tENSV;
	}
	public String getPHAI() {
		return PHAI;
	}
	public void setPHAI(String pHAI) {
		PHAI = pHAI;
	}
	public Date getNGAYSINH() {
		return NGAYSINH;
	}
	public void setNGAYSINH(Date nGAYSINH) {
		NGAYSINH = nGAYSINH;
	}
	public Lop getLOP() {
		return LOP;
	}
	public void setLOP(Lop lOP) {
		LOP = lOP;
	}
	public ChuyenNganh getCHUYENNGANH() {
		return CHUYENNGANH;
	}
	public void setCHUYENNGANH(ChuyenNganh cHUYENNGANH) {
		CHUYENNGANH = cHUYENNGANH;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public Double getDIEMTBTL() {
		return DIEMTBTL;
	}
	public void setDIEMTBTL(Double dIEMTBTL) {
		DIEMTBTL = dIEMTBTL;
	}
	public Integer getSOTCTL() {
		return SOTCTL;
	}
	public void setSOTCTL(Integer sOTCTL) {
		SOTCTL = sOTCTL;
	}
	public Boolean getDUDKXETTN() {
		return DUDKXETTN;
	}
	public void setDUDKXETTN(Boolean dUDKXETTN) {
		DUDKXETTN = dUDKXETTN;
	}
	public Boolean getDUDKLAMDA() {
		return DUDKLAMDA;
	}
	public void setDUDKLAMDA(Boolean dUDKLAMDA) {
		DUDKLAMDA = dUDKLAMDA;
	}
	public Boolean getXACNHANLAMDA() {
		return XACNHANLAMDA;
	}
	public void setXACNHANLAMDA(Boolean xACNHANLAMDA) {
		XACNHANLAMDA = xACNHANLAMDA;
	}
	
}
