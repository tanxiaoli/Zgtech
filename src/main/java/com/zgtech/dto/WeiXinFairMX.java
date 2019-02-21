package com.zgtech.dto;

public class WeiXinFairMX {
 private int id;
 private String peopleOpenId;
 private int favourable;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPeopleOpenId() {
	return peopleOpenId;
}
public void setPeopleOpenId(String peopleOpenId) {
	this.peopleOpenId = peopleOpenId;
}
public int getFavourable() {
	return favourable;
}
public void setFavourable(int favourable) {
	this.favourable = favourable;
}
@Override
public String toString() {
	return "WeiXinFairMX [id=" + id + ", peopleOpenId=" + peopleOpenId + ", favourable=" + favourable + "]";
}
 
}
