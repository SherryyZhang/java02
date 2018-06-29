package com.immoc.writeXml;


import java.util.ArrayList;

import org.xml.sax.helpers.DefaultHandler;

public class Saxparserhandler extends DefaultHandler {

	String value = null;
	Book book = null;
	private ArrayList<Book> booklist = new ArrayList<Book>();
	public ArrayList<Book> getBooklist() {
		return booklist;
	}	
	
}
