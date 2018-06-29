package com.immoc.writeXml;

public class Book {

	String name;
	String id;
	String auth;
	
	public Book(String name, String id, String auth) {
		super();
		this.name = name;
		this.id = id;
		this.auth = auth;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	
}
