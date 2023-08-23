package ptithcm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "DieuKienLamDoAn")
public class DieuKienLamDoAn {
	@Id @GeneratedValue
	private Integer IDDK;
	private String DIEUKIENLAMDATN;
	private String DIEUKIENXETTN;
	private Double DIEMTBXETTN;
	private Integer STCTLXETTN;
	
	public Integer getIDDK() {
		return IDDK;
	}
	public void setIDDK(Integer iDDK) {
		IDDK = iDDK;
	}
	public String getDIEUKIENLAMDATN() {
		return DIEUKIENLAMDATN;
	}
	public void setDIEUKIENLAMDATN(String dIEUKIENLAMDATN) {
		DIEUKIENLAMDATN = dIEUKIENLAMDATN;
	}
	public String getDIEUKIENXETTN() {
		return DIEUKIENXETTN;
	}
	public void setDIEUKIENXETTN(String dIEUKIENXETTN) {
		DIEUKIENXETTN = dIEUKIENXETTN;
	}
	public Double getDIEMTBXETTN() {
		return DIEMTBXETTN;
	}
	public void setDIEMTBXETTN(Double dIEMTBXETTN) {
		DIEMTBXETTN = dIEMTBXETTN;
	}
	public Integer getSTCTLXETTN() {
		return STCTLXETTN;
	}
	public void setSTCTLXETTN(Integer sTCTLXETTN) {
		STCTLXETTN = sTCTLXETTN;
	}
	
}
