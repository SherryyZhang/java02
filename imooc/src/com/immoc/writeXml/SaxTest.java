package com.immoc.writeXml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.TransferHandler;
import javax.xml.crypto.dsig.Transform;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

public class SaxTest {

	public static void main(String[] args) {
		SaxTest d = new SaxTest();
		d.createXml();
	}
	public void createXml(){
		ArrayList<Book> booklist = parseXML();
		
		
		SAXTransformerFactory tff = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
		
		Transformer tf;
		try {
			TransformerHandler th = tff.newTransformerHandler();
			tf = th.getTransformer();
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			File f =new File("d:/newbook1.xml");
			if(!f.exists())
				f.createNewFile();			
			Result r = new StreamResult(new FileOutputStream(f));
			th.setResult(r);
			AttributesImpl i = new AttributesImpl();
			th.startDocument();
			th.startElement("", "", "bookstore", i);
			th.endElement("", "", "bookstore");
			th.endDocument();
			
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		
	}
	public ArrayList<Book> parseXML(){
		SAXParserFactory sf = SAXParserFactory.newInstance();
		Saxparserhandler h = null;
		SAXParser p;
		try {
			p = sf.newSAXParser();
			h = new Saxparserhandler();
			p.parse("book.xml", h);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return h.getBooklist();
				
		
	}

}
