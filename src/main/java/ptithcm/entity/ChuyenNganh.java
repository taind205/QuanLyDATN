package ptithcm.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ChuyenNganh")
public class ChuyenNganh {
	@Id @GeneratedValue
	private Integer IDCN;
	private String TENCHUYENNGANH;
	private Double DIEMLAMDA;
	private Integer SOTCLAMDA;
	private String GHICHU;

	@OneToMany(mappedBy="CHUYENNGANH", fetch=FetchType.EAGER)
	private Collection<SinhVien> SINHVIEN;

	public Integer getIDCN() {
		return IDCN;
	}

	public void setIDCN(Integer iDCN) {
		IDCN = iDCN;
	}

	public String getTENCHUYENNGANH() {
		return TENCHUYENNGANH;
	}

	public void setTENCHUYENNGANH(String tENCHUYENNGANH) {
		TENCHUYENNGANH = tENCHUYENNGANH;
	}

	public Double getDIEMLAMDA() {
		return DIEMLAMDA;
	}

	public void setDIEMLAMDA(Double dIEMLAMDA) {
		DIEMLAMDA = dIEMLAMDA;
	}

	public Integer getSOTCLAMDA() {
		return SOTCLAMDA;
	}

	public void setSOTCLAMDA(Integer sOTCLAMDA) {
		SOTCLAMDA = sOTCLAMDA;
	}

	public String getGHICHU() {
		return GHICHU;
	}

	public void setGHICHU(String gHICHU) {
		GHICHU = gHICHU;
	}

	public Collection<SinhVien> getSINHVIEN() {
		return SINHVIEN;
	}

	public void setSINHVIEN(Collection<SinhVien> sINHVIEN) {
		SINHVIEN = sINHVIEN;
	}
	
}
