package com.immoc.writeXml;

import java.io.File;

import javax.xml.crypto.dsig.Transform;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.dom4j.io.OutputFormat;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/*public class DomTest2 {

	public static void main(String[] args) {
		DomTest2 d = new DomTest2();
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

}*/
class DomTest2{
	
	
	public Document getDocument() throws ParserConfigurationException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		return factory.newDocumentBuilder().newDocument();
	}
	public void writeDomXml() throws Exception{
		Document doc = getDocument();
		doc.setXmlStandalone(true);
		Element  bookstore = doc.createElement("books");
		Element book = doc.createElement("book");
		Element name = doc.createElement("name");
		Element name2 = doc.createElement("name2");
		Element name3 = doc.createElement("name3");
		Element name4 = doc.createElement("name4");
		name.setAttribute("f","1111");
		name2.setTextContent("222");
		name3.setNodeValue("22233");
		book.appendChild(name);
		book.appendChild(name2);
		book.appendChild(name3);
		book.appendChild(name4);
		name4.setTextContent("4444");
		bookstore.appendChild(book);
		book.setAttribute("y", "book");
		doc.appendChild(bookstore);
		System.out.println(doc.getNodeName());
		TransformerFactory t = TransformerFactory.newInstance();
		Transformer tr = t.newTransformer();
		tr.setOutputProperty(OutputKeys.INDENT, "yes");
		tr.transform(new DOMSource(doc), new StreamResult(new File("D:/dom.xml")));
		
	}
	public static void main(String[] args){
		DomTest2 t = new DomTest2();
		try {
			t.writeDomXml();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Transformer t2() throws Exception{
		TransformerFactory t1 = TransformerFactory.newInstance();
		Transformer t2 =t1.newTransformer();
		return t2;
	}
	public void t() throws Exception{
		Document d = getDocument();
		Element e1 = d.createElement("1");
		Element e2 = d.createElement("2");
		e1.setNodeValue("1");
		e2.setTextContent("22");
		e2.appendChild(e1);
		d.appendChild(e2);
		Transformer t2 = t2();
		t2.setOutputProperty(OutputKeys.INDENT, "yes");
		t2.transform(new DOMSource(d), new StreamResult(new File("")));
		
	}
}
