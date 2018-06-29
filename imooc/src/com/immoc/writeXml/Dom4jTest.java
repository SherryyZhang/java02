package com.immoc.writeXml;

import java.io.File;

import java.io.*;
import org.dom4j.*;
import org.dom4j.io.*;

public class Dom4jTest {

	public static void main(String[] args) {
		Dom4jTest d = new Dom4jTest();
		d.createXML();
	}
	private void createXML(){
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

	
	

}
