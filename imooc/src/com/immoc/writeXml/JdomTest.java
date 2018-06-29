package com.immoc.writeXml;

import java.io.File;

import javax.xml.crypto.dsig.Transform;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.dom4j.Document;


public class JdomTest {

	public static void main(String[] args) {
		JdomTest d = new JdomTest();
		d.createXML();
	}
	
	private void createXML() {
		//1.生成一个根节点
		Element rss = new Element("rss");
		//2.为节点添加属性
		rss.setAttribute("version", "2.0");
		//3.生成一个document对象
		Document document = new Document(rss);
		
		Element channel = new Element("channel");
		rss.addContent(channel);
		Element title = new Element("title");
		title.setText("<![CDATA[上海移动互联网产业促进中心正式揭牌 ]]>");
		channel.addContent(title);
		
		Format format = Format.getCompactFormat();
		format.setIndent("");
		format.setEncoding("GBK");
		
		//4.创建XMLOutputter的对象
		XMLOutputter outputer = new XMLOutputter(format);
		try {
			//5.利用outputer将document对象转换成xml文档
			outputer.output(document, new FileOutputStream(new File("rssnews.xml")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
