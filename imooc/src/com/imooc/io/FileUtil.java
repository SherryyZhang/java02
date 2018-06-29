package com.imooc.io;

import java.io.File;

public class FileUtil {

	public static void listDiractory(File f){
		if(!f.exists()){
			
		}
		else if(f.isDirectory()){
			System.out.println(f.getName()+"============");
			File[] files=f.listFiles();
			if(files!=null&&files.length>0)
				for(File f1:files)
					if(f1.isDirectory())
							listDiractory(f1);
					else{
						for(String s:f.list())
							System.out.println(s);
						}
		}
		
	}

}
