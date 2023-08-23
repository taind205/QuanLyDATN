package ptithcm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "HoiDong")
public class HoiDong {
	@Id
	private String IDHD;
	@ManyToOne
	@JoinColumn(name="IDCHUTICHHD")
	private GiangVien CHUTICHHD;
	@ManyToOne
	@JoinColumn(name="IDTHUKY")
	private GiangVien THUKY;
	@ManyToOne
	@JoinColumn(name="IDUV1")
	private GiangVien UV1;
	@ManyToOne
	@JoinColumn(name="IDUV2")
	private GiangVien UV2;
	@ManyToOne
	@JoinColumn(name="IDUV3")
	private GiangVien UV3;
	private String GHICHU;
	
	public String getIDHD() {
		return IDHD;
	}
	public void setIDHD(String iDHD) {
		IDHD = iDHD;
	}
	public GiangVien getCHUTICHHD() {
		return CHUTICHHD;
	}
	public void setCHUTICHHD(GiangVien cHUTICHHD) {
		CHUTICHHD = cHUTICHHD;
	}
	public GiangVien getTHUKY() {
		return THUKY;
	}
	public void setTHUKY(GiangVien tHUKY) {
		THUKY = tHUKY;
	}
	public GiangVien getUV1() {
		return UV1;
	}
	public void setUV1(GiangVien uV1) {
		UV1 = uV1;
	}
	public GiangVien getUV2() {
		return UV2;
	}
	public void setUV2(GiangVien uV2) {
		UV2 = uV2;
	}
	public GiangVien getUV3() {
		return UV3;
	}
	public void setUV3(GiangVien uV3) {
		UV3 = uV3;
	}
	public String getGHICHU() {
		return GHICHU;
	}
	public void setGHICHU(String gHICHU) {
		GHICHU = gHICHU;
	}

}
