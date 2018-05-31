package com.zyf;

 

import java.io.BufferedReader;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileReader;

import java.io.FileWriter;

import java.io.IOException;

import java.io.InputStreamReader;

import java.util.HashMap;

import java.util.Map;

 

/**

* ����һ��file����׺��Ϊcfg. �����ı���ʽΪÿ�У�A=X�ṹ������ע������ǰ�����# Ȼ�󽫸��ļ����浽map�У�map(A��X);

*

 * @author Administrator

*

 */

public class Test01 {

         private String line = System.getProperty("line.separator");//��ȡ�������� ;     �зָ������� UNIX ϵͳ���ǡ�/n����

         private String separ = "="; //��"="����

         static String filePath = "D:\\test\\b.properties";// �ļ����·��

 

         public static void main(String[] args) throws Exception{

                   Test01 fileToMap1 = new Test01();

                   Map<String, String> mapObj = fileToMap1.fTM();

                   try {

                            fileToMap1.mapToFileDefault(mapObj, new File(filePath), fileToMap1.separ);

                   } catch (IOException e) {

                            e.printStackTrace();

                   }

         }

 

        

         /**

         * ��mapд�뵽file�ļ��С�Ĭ��map��String A,String A')file����A=A'����ʾ��map��ÿ����ֵ����ʾһ��

         *

          * @throws IOException

         */

         private File mapToFileDefault(Map<String, String> map, File file, String separ) throws IOException {

                   StringBuffer buffer = new StringBuffer();

                   FileWriter writer = new FileWriter(file, false);

                   for (Map.Entry entry : map.entrySet()) {

                            String key = (String) entry.getKey();

                            String value = (String) entry.getValue();

                            buffer.append(key + "=" + value).append(line);

                   }

                   writer.write(buffer.toString());

                   writer.close();

                   return file;

 

         }

 


 

         /**

         * ���ļ�ת����map�洢

         *

          * @return

         */

         private Map<String, String> fTM() throws Exception{

                   Map<String, String> map = new HashMap<String, String>();

                   File file = new File(filePath);

                   InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");// ���ǵ������ʽ

                   BufferedReader reader = null;

                   try {

                   //      System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");

                            reader = new BufferedReader(new FileReader(file));

                            String tempString = null;

                            int line = 1;

                            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����

                            while ((tempString = reader.readLine()) != null) {

                                     // ��ʾ�к�

                            //      System.out.println("line " + line + ": " + tempString);

                                     if (!tempString.startsWith("#") && !"".equals(tempString)) {

                                               String[] strArray = tempString.split("=");

                                               map.put(strArray[0], strArray[1]);

                                     }

                                     line++;

                            }

                            reader.close();

                   } catch (IOException e) {

                            e.printStackTrace();

                   } finally {

                            if (reader != null) {

                                     try {

                                               reader.close();

                                     } catch (IOException e1) {

                                     }

                            }

                   }

                   /*for (Map.Entry entry : map.entrySet()) {

                            System.out.println(entry.getKey() + "=" + entry.getValue());

                   }*/

                   return map;

         }

 

}

 