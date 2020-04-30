package secondThematic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Maskmap")
public class masks {
	private int id;
	private String hospitalId;
	private String hospitalName;
	private String hopsitalAddress;
	private String hopsitalPhone;
	private int MaskOfAdult;
	private int MaskOfchild;
	private String date;
	
	@Column(name="hospitalId")
	public String getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	@Column(name="hospitalName")
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	@Column(name="hopsitalAddress")
	public String getHopsitalAddress() {
		return hopsitalAddress;
	}
	public void setHopsitalAddress(String hopsitalAddress) {
		this.hopsitalAddress = hopsitalAddress;
	}
	@Column(name="hopsitalPhone")
	public String getHopsitalPhone() {
		return hopsitalPhone;
	}
	public void setHopsitalPhone(String hopsitalPhone) {
		this.hopsitalPhone = hopsitalPhone;
	}
	@Column(name="MaskOfAdult")
	public int getMaskOfAdult() {
		return MaskOfAdult;
	}
	public void setMaskOfAdult(int maskOfAdult) {
		MaskOfAdult = maskOfAdult;
	}
	@Column(name="MaskOfchild")
	public int getMaskOfchild() {
		return MaskOfchild;
	}
	public void setMaskOfchild(int maskOfchild) {
		MaskOfchild = maskOfchild;
	}
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="date")
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
