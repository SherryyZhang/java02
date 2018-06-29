package com.imooc.io;

import java.io.File;

public class Test1 {

	public static void main(String[] args) {
		File f= new File("E:\\我的文件");
		FileUtil.listDiractory(f);
		
	}

}
