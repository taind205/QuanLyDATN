package ptithcm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TaiKhoan")
public class TaiKhoan {
	@Id
	private String ID;
	private String MATKHAU;
	private String LOAITK;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getMATKHAU() {
		return MATKHAU;
	}
	public void setMATKHAU(String mATKHAU) {
		MATKHAU = mATKHAU;
	}
	public String getLOAITK() {
		return LOAITK;
	}
	public void setLOAITK(String lOAITK) {
		LOAITK = lOAITK;
	}
	
}