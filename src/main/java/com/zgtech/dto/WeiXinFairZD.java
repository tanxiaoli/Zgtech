package com.zgtech.dto;

public class WeiXinFairZD {
	private int id;
	private String fairName;
	private String formIp;
	private int peopleCount;
	private int favourableCount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFairName() {
		return fairName;
	}
	public void setFairName(String fairName) {
		this.fairName = fairName;
	}
	public String getFormIp() {
		return formIp;
	}
	public void setFormIp(String formIp) {
		this.formIp = formIp;
	}
	public int getPeopleCount() {
		return peopleCount;
	}
	public void setPeopleCount(int peopleCount) {
		this.peopleCount = peopleCount;
	}
	public int getFavourableCount() {
		return favourableCount;
	}
	public void setFavourableCount(int favourableCount) {
		this.favourableCount = favourableCount;
	}
	@Override
	public String toString() {
		return "WeiXinFairZD [id=" + id + ", fairName=" + fairName + ", formIp=" + formIp + ", peopleCount="
				+ peopleCount + ", favourableCount=" + favourableCount + "]";
	}
	

}
