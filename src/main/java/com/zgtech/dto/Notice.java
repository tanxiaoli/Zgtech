package com.zgtech.dto;

public class Notice {
private int id;
private String user;
private String words;
@Override
public String toString() {
	return "Notice [id=" + id + ", user=" + user + ", words=" + words + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public String getWords() {
	return words;
}
public void setWords(String words) {
	this.words = words;
}
}
