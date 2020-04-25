package com.altersoftware.hotel;
 
import java.io.File;
 
public class FileRename {
	public static void main(String[] args) {
		File srcDir = new File("C:\\Users\\improve\\Desktop\\Picosmos_优化");
		renmaeRecursion(srcDir);
	}
	
	//使用递归遍历更改文件扩展名
	private static void renmaeRecursion(File srcDir) {
		File[] files = srcDir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				renmaeRecursion(file);
			}else {
				String fileName = file.getName();
				System.out.println(file.getParentFile());
				//String[] strings = fileName.split("\\.");
				//增加判断逻辑，避免误操作.png文件
				if (!fileName.contains(".png")) {
					String newName = fileName.substring(0, fileName.lastIndexOf(".")) + ".png";
					file.renameTo(new File(file.getParentFile(),newName));
				}
			}
		}
		
 	}
}