package cubes.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="locations")
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String address;
	@Column
	private int phone1;
	@Column
	private int phone2;
	@Column
	private String email;
	@Column(name = "worktime")
	private String workTime;
	@Column(name = "worktime_saturday")
	private String workTimeSaturday;
	@Column(name = "worktime_sunday")
	private String workTimeSunday;
	
	public Location() {
		
	}
	
	public Location(String address, int phone1, int phone2, String email, String workTime, String workTimeSaturday,
			String workTimeSunday) {
		
		this.address = address;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.email = email;
		this.workTime = workTime;
		this.workTimeSaturday = workTimeSaturday;
		this.workTimeSunday = workTimeSunday;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone1() {
		return phone1;
	}

	public void setPhone1(int phone1) {
		this.phone1 = phone1;
	}

	public int getPhone2() {
		return phone2;
	}

	public void setPhone2(int phone2) {
		this.phone2 = phone2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWorkTime() {
		return workTime;
	}

	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}

	public String getWorkTimeSaturday() {
		return workTimeSaturday;
	}

	public void setWorkTimeSaturday(String workTimeSaturday) {
		this.workTimeSaturday = workTimeSaturday;
	}

	public String getWorkTimeSunday() {
		return workTimeSunday;
	}

	public void setWorkTimeSunday(String workTimeSunday) {
		this.workTimeSunday = workTimeSunday;
	}
	
	
	
	
	

}
