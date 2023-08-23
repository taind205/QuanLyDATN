package ptithcm.entity;

import java.util.Date;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Staffs")

public class Staff {
	@Id
	private String id;
	private String name;
	private Boolean gender;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date birthday;
	private String photo;
	private String email;
	private String phone;
	private Double salary;
	private String Notes;
	@ManyToOne
	@JoinColumn(name="departid")
	private Depart depart;
	@OneToMany(mappedBy="staff", fetch=FetchType.EAGER)
	private Collection<Record> record;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	public Depart getDepart() {
		return depart;
	}
	public void setDepart(Depart depart) {
		this.depart = depart;
	}
	public Collection<Record> getRecord() {
		return record;
	}
	public void setRecord(Collection<Record> record) {
		this.record = record;
	}

}
