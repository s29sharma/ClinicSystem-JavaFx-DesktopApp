package application;

public class doctor {
	private int id_number;
	private String firstname;
	private String lastname;
	private String address;
	private String city;
	private String state;
	private String postalcode;
	private int phonenumber;

	public doctor() {

	}

	public doctor(String firstname, String lastname, String address, String city, String state, String postalcode,
			int phonenumber) {
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setAddress(address);
		this.setCity(city);
		this.setState(state);
		this.setPostalcode(postalcode);
		this.setPhonenumber(phonenumber);
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public int getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}

}
