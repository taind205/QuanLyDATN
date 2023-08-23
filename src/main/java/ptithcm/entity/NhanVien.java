package ptithcm.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "NhanVien")
public class NhanVien {
	@Id
	private String IDNV;
	private String HONV;
	private String TENNV;
	private String SDT;
	private String EMAIL;
	@OneToMany(mappedBy="NHANVIEN", fetch=FetchType.EAGER)
	private Collection<ThongBao> thongbao;
	
	public String getIDNV() {
		return IDNV;
	}
	public void setIDNV(String iDNV) {
		IDNV = iDNV;
	}
	public String getHONV() {
		return HONV;
	}
	public void setHONV(String hONV) {
		HONV = hONV;
	}
	public String getTENNV() {
		return TENNV;
	}
	public void setTENNV(String tENNV) {
		TENNV = tENNV;
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
	
}
