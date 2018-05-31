package com.zyf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Reader and Writer（读取多个txt文件，去掉重复元素，再写入一个新的txt文件。）
 * 
 * @author Administrator
 * 
 */
public class Teset {

	/**
	 * 读取指定目录下的txt文件，并添加到set里面（即去掉重复元素）
	 * 
	 * @param path
	 * @return setStr
	 */
	public static Set<String> Reader(String path) {
		Set<String> setStr = new HashSet<String>();

		try {
			String encoding = "GBK";
			File file = new File(path);
			String[] fileList = file.list();

			for (String fl : fileList) {
				String newPath = path + "\\" + fl;
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(newPath), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					if (!lineTxt.trim().equals("")) {
//						lineTxt = lineTxt.substring(arg0)
						setStr.add(lineTxt);
						System.out.println(fl+":f1");
						System.out.println(lineTxt+":行数据");
					}
				}
				read.close();
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}

		return setStr;
	}

	/**
	 * 将set里面的数据写入到一个新的txt文件里面
	 * 
	 * @param str
	 * @throws IOException
	 */
	public static void Writer(Set<String> str) throws IOException {
		FileWriter fileWriter = new FileWriter("D:\\test\\Result.txt");
		int count = 0;
		for (String string : str) {
			if (!string.trim().equals("")) {
				count++;
				fileWriter.write(string.trim() + "\r\n");
			}
		}
		System.out.println(count);
		fileWriter.flush();
		fileWriter.close();
	}

	public static void main(String[] args) throws IOException {
		Writer(Reader("D:\\test"));
	}

}