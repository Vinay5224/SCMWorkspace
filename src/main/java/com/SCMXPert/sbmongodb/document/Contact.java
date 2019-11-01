
package com.SCMXPert.sbmongodb.document;

import java.util.List;

public class Contact {
	
	private String Type;
	private String Contact_Name;
	private List<Phone> phone;
	private String Email_Id;
	
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getContact_Name() {
		return Contact_Name;
	}
	public void setContact_Name(String contact_Name) {
		Contact_Name = contact_Name;
	}
	public List<Phone> getPhone() {
		return phone;
	}
	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}
	public String getEmail_Id() {
		return Email_Id;
	}
	public void setEmail_Id(String email_Id) {
		Email_Id = email_Id;
	}
	

	
}

/*  public class PhoneC { 
	  
	  public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		Number = number;
	}

	private   String Phone;
	    
	    private String Type;
	    
	    private String Number;
	    
	     
	    
	    }
  
public String getType() {
	return Type;
}
public void setType(String type) {
	Type = type;
}
public String getContact_Name() {
	return Contact_Name;
}
public void setContact_Name(String contact_Name) {
	Contact_Name = contact_Name;
}
public String getEmail_Id() {
	return Email_Id;
}
public void setEmail_Id(String email_Id) {
	Email_Id = email_Id;
}
public ArrayList<PhoneC> getPhone() {
	return Phone;
}
public void setPhone(ArrayList<PhoneC> phone) {
	Phone = phone;
}
private String Type;

private String Contact_Name; // private //

private String Email_Id;
private ArrayList <PhoneC> Phone; // setter and getters }*/