package com.SCMXPert.sbmongodb.document;

import java.util.Arrays;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Customer")
public class Customer {


	
	@Id
	private ObjectId id;
	
	private String Customer_Id;
	private String Name1;
	private String Name2;
	private String Type;
	private String External_Number;
	private String[] Business_Partner_Id;
	private String[] Device_Id;
	private String DUNS;
	private String G10;
	@Field(value = "Departments")
	private String[] Departments;
	@Field(value = "Addresses")
	private List<Addresses> Addresses;
	@Field(value = "Contact")
	private List<Contact> Contact;
	@Field(value = "Route")
	private List<Route> Route;
	@Field(value = "Goods")
	private List<Goods> Goods;
	public List<Goods> getGoods() {
		return Goods;
	}
	public void setGoods(List<Goods> goods) {
		this.Goods = goods;
	}
	public String getCustomer_Id() {
		return Customer_Id;
	}
	public void setCustomer_Id(String customer_Id) {
		Customer_Id = customer_Id;
	}
	public String getName1() {
		return Name1;
	}
	public void setName1(String name1) {
		Name1 = name1;
	}
	public String getName2() {
		return Name2;
	}
	public void setName2(String name2) {
		Name2 = name2;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getExternal_Number() {
		return External_Number;
	}
	public void setExternal_Number(String external_Number) {
		External_Number = external_Number;
	}
	public String[] getBusiness_Partner_Id() {
		return Business_Partner_Id;
	}
	public void setBusiness_Partner_Id(String[] business_Partner_Id) {
		Business_Partner_Id = business_Partner_Id;
	}
	public String[] getDevice_Id() {
		return Device_Id;
	}
	public void setDevice_Id(String[] device_Id) {
		Device_Id = device_Id;
	}
	public String getDUNS() {
		return DUNS;
	}
	public void setDUNS(String dUNS) {
		DUNS = dUNS;
	}
	public String getG10() {
		return G10;
	}
	public void setG10(String g10) {
		G10 = g10;
	}
	public String[] getDepartments() {
		return Departments;
	}
	public void setDepartments(String[] Departments) {
		Departments = Departments;
	}
	public List<Addresses> getAddresses() {
		return Addresses;
	}
	public void setAddresses(List<Addresses> addresses) {
		this.Addresses = addresses;
	}
	public List<Contact> getContact() {
		return Contact;
	}
	public void setContact(List<Contact> contact) {
		this.Contact = contact;
	}
	public List<Route> getRoute() {
		return Route;
	}
	public void setRoute(List<Route> route) {
		this.Route = route;
	}
	@Override
	public String toString() {
		return "Customer [Customer_Id=" + Customer_Id + ", Name1=" + Name1 + ", Name2=" + Name2 + ", Type=" + Type
				+ ", External_Number=" + External_Number + ", Business_Partner_Id="
				+ Arrays.toString(Business_Partner_Id) + ", Device_Id=" + Arrays.toString(Device_Id) + ", DUNS=" + DUNS
				+ ", G10=" + G10 + ", Departments=" + Arrays.toString(Departments) + ", Addresses=" + Addresses
				+ ", Contact=" + Contact + ", Route=" + Route + ", Goods=" + Goods + "]";
	}


	
	
	
}
