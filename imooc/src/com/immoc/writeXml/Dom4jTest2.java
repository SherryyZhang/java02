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
		//1.����document���󣬴�������xml�ĵ�
		Document document = DocumentHelper.createDocument();
		//2.�������ڵ�rss
		Element rss = document.addElement("rss");
		//3.��rss�ڵ������version����
		rss.addAttribute("version", "2.0");
		//4.�����ӽڵ㼰�ڵ�����
		Element channel = rss.addElement("channel");
		Element title = channel.addElement("title");
		title.setText("<![CDATA[�Ϻ��ƶ���������ҵ�ٽ�������ʽ���� ]]>");
		//5.��������xml�ĸ�ʽ
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("GBK");
		//6.����xml�ļ�
		File file = new File("rssnews.xml");
		XMLWriter writer;
		try {
			writer = new XMLWriter(new FileOutputStream(file), format);
			//�����Ƿ�ת�壬Ĭ��ֵ��true������ת��
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
