package donation.ngo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ngo {
	
	@Id
	private String name;
	private String password;
	private String phone;
	private String email;
	private String coverArea;
	private String description;
	private String imageUrl;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	
	public Ngo() {
		
	}

	public Ngo(String name, String password, String phone, String email, String coverArea,
			String description) {
		super();
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.coverArea = coverArea;
		this.description = description;
	}



	public Ngo(String name, String password, String phone, String email, String coverArea, String description,
			String imageUrl, String address, String city, String state, String zipcode) {
		super();
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.coverArea = coverArea;
		this.description = description;
		this.imageUrl = imageUrl;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCoverArea() {
		return coverArea;
	}

	public void setCoverArea(String coverArea) {
		this.coverArea = coverArea;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public String getImageUrl() {
		return imageUrl;
	}



	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getZipcode() {
		return zipcode;
	}



	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
	
}
