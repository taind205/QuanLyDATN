package ptithcm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Lop")
public class Lop {
	@Id
	private String MALOP;
	private String TENLOP;
	private String NIENKHOA;
	private String GHICHU;
	
	public String getNIENKHOA() {
		return NIENKHOA;
	}
	public void setNIENKHOA(String nIENKHOA) {
		NIENKHOA = nIENKHOA;
	}
	public String getMALOP() {
		return MALOP;
	}
	public void setMALOP(String mALOP) {
		MALOP = mALOP;
	}
	public String getTENLOP() {
		return TENLOP;
	}
	public void setTENLOP(String tENLOP) {
		TENLOP = tENLOP;
	}
	public String getGHICHU() {
		return GHICHU;
	}
	public void setGHICHU(String gHICHU) {
		GHICHU = gHICHU;
	}
}
