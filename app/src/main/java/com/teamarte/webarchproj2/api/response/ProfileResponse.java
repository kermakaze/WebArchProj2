package com.teamarte.webarchproj2.api.response;


import com.google.gson.annotations.SerializedName;

public class ProfileResponse{

	@SerializedName("address")
	private String address;

	@SerializedName("fullName")
	private String fullName;

	@SerializedName("employmentStatus")
	private String employmentStatus;

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("password")
	private String password;

	@SerializedName("phoneNumber")
	private String phoneNumber;

	@SerializedName("digitalAddress")
	private String digitalAddress;

	@SerializedName("__v")
	private int V;


	@SerializedName("id")
	private String id;

	@SerializedName("ethnicGroup")
	private String ethnicGroup;

	@SerializedName("email")
	private String email;

	@SerializedName("maritalStatus")
	private String maritalStatus;

	@SerializedName("updatedAt")
	private String updatedAt;

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setFullName(String fullName){
		this.fullName = fullName;
	}

	public String getFullName(){
		return fullName;
	}

	public void setEmploymentStatus(String employmentStatus){
		this.employmentStatus = employmentStatus;
	}

	public String getEmploymentStatus(){
		return employmentStatus;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber(){
		return phoneNumber;
	}

	public void setDigitalAddress(String digitalAddress){
		this.digitalAddress = digitalAddress;
	}

	public String getDigitalAddress(){
		return digitalAddress;
	}

	public void setV(int V){
		this.V = V;
	}

	public int getV(){
		return V;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}



	public void setEthnicGroup(String ethnicGroup){
		this.ethnicGroup = ethnicGroup;
	}

	public String getEthnicGroup(){
		return ethnicGroup;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setMaritalStatus(String maritalStatus){
		this.maritalStatus = maritalStatus;
	}

	public String getMaritalStatus(){
		return maritalStatus;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	@Override
 	public String toString(){
		return 
			"ProfileResponse{" + 
			"address = '" + address + '\'' + 
			",fullName = '" + fullName + '\'' + 
			",employmentStatus = '" + employmentStatus + '\'' + 
			",createdAt = '" + createdAt + '\'' + 
			",password = '" + password + '\'' + 
			",phoneNumber = '" + phoneNumber + '\'' + 
			",digitalAddress = '" + digitalAddress + '\'' + 
			",__v = '" + V + '\'' + 
			",_id = '" + id + '\'' + 
			",id = '" + id + '\'' + 
			",ethnicGroup = '" + ethnicGroup + '\'' + 
			",email = '" + email + '\'' + 
			",maritalStatus = '" + maritalStatus + '\'' + 
			",updatedAt = '" + updatedAt + '\'' + 
			"}";
		}
}