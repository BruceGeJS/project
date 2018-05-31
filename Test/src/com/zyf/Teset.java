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
 * Reader and Writer����ȡ���txt�ļ���ȥ���ظ�Ԫ�أ���д��һ���µ�txt�ļ�����
 * 
 * @author Administrator
 * 
 */
public class Teset {

	/**
	 * ��ȡָ��Ŀ¼�µ�txt�ļ�������ӵ�set���棨��ȥ���ظ�Ԫ�أ�
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
						new FileInputStream(newPath), encoding);// ���ǵ������ʽ
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					if (!lineTxt.trim().equals("")) {
//						lineTxt = lineTxt.substring(arg0)
						setStr.add(lineTxt);
						System.out.println(fl+":f1");
						System.out.println(lineTxt+":������");
					}
				}
				read.close();
			}
		} catch (Exception e) {
			System.out.println("��ȡ�ļ����ݳ���");
			e.printStackTrace();
		}

		return setStr;
	}

	/**
	 * ��set���������д�뵽һ���µ�txt�ļ�����
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