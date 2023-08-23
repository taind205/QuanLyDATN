package ptithcm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "GiangVien")
public class GiangVien {
	@Id
	private String IDGV;
	private String HOGV;
	private String TENGV;
	private String PHAI;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date NGAYSINH;
	private String SDT;
	private String EMAIL;
	private String HOCVI;
	
	public String getIDGV() {
		return IDGV;
	}
	public void setIDGV(String iDGV) {
		IDGV = iDGV;
	}
	public String getHOGV() {
		return HOGV;
	}
	public void setHOGV(String hOGV) {
		HOGV = hOGV;
	}
	public String getTENGV() {
		return TENGV;
	}
	public void setTENGV(String tENGV) {
		TENGV = tENGV;
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
	public String getHOCVI() {
		return HOCVI;
	}
	public void setHOCVI(String hOCVI) {
		HOCVI = hOCVI;
	}
	
}
