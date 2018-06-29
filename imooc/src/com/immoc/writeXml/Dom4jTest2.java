package com.immoc.writeXml;

import java.io.*;

import javax.sql.rowset.spi.XmlWriter;

import org.dom4j.*;
import org.dom4j.io.*;

public class Dom4jTest2 {

	public static void main(String[] args) {
		Dom4jTest2 d = new Dom4jTest2();
		try {
			d.createXML();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*private void createXML(){
		//1.创建document对象，代表整个xml文档
		Document document = DocumentHelper.createDocument();
		//2.创建根节点rss
		Element rss = document.addElement("rss");
		//3.向rss节点中添加version属性
		rss.addAttribute("version", "2.0");
		//4.生成子节点及节点内容
		Element channel = rss.addElement("channel");
		Element title = channel.addElement("title");
		title.setText("<![CDATA[上海移动互联网产业促进中心正式揭牌 ]]>");
		//5.设置生成xml的格式
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("GBK");
		//6.生成xml文件
		File file = new File("rssnews.xml");
		XMLWriter writer;
		try {
			writer = new XMLWriter(new FileOutputStream(file), format);
			//设置是否转义，默认值是true，代表转义
			writer.setEscapeText(false);
			writer.write(document);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		*/
	public void createXML() throws Exception, FileNotFoundException{
		Document d = DocumentHelper.createDocument();
		Element e1=d.addElement("bookstore", "books");
		Element e2=e1.addElement("book", "book");
		Element e3 =e2.addElement("name", "1");
		OutputFormat f = OutputFormat.createCompactFormat();
		f.setEncoding("GBK");
		XMLWriter x =new XMLWriter(new FileOutputStream(new File("d:/f.xml")), f);
		x.write(d);
		x.close();
		
	}
	
	

	
	

}
