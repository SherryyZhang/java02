package com.immoc.writeXml;

import java.io.File;

import javax.xml.crypto.dsig.Transform;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DomTest {

	public static void main(String[] args) {
		DomTest d = new DomTest();
		d.createXml();
	}
	public DocumentBuilder getDocumentBuilder(){
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return db;
	}
	
	public void createXml(){
		DocumentBuilder db = getDocumentBuilder();
		Document d = db.newDocument();
		d.setXmlStandalone(true);
		Element bookstore = d.createElement("bookstore");
		Element book = d.createElement("book");
		Element name = d.createElement("name");
		name.setNodeValue("111");
		name.setTextContent("111");
		book.appendChild(name);
		bookstore.appendChild(book);
		book.setAttribute("number", "1");
		d.appendChild(bookstore);
		
		TransformerFactory tff = TransformerFactory.newInstance();
		Transformer tf;
		try {
			tf = tff.newTransformer();
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			tf.transform(new DOMSource(d), new StreamResult(new File("d:/d.txt")));
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		
		
	}

}
