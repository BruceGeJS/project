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

* 创建一个file，后缀名为cfg. 里面文本格式为每行：A=X结构，其中注释在最前面加上# 然后将该文件保存到map中（map(A，X);

*

 * @author Administrator

*

 */

public class Test01 {

         private String line = System.getProperty("line.separator");//获取环境属性 ;     行分隔符（在 UNIX 系统中是“/n”）

         private String separ = "="; //以"="区分

         static String filePath = "D:\\test\\b.properties";// 文件相对路径

 

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

         * 将map写入到file文件中。默认map（String A,String A')file中以A=A'来表示，map中每个键值对显示一行

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

         * 将文件转换成map存储

         *

          * @return

         */

         private Map<String, String> fTM() throws Exception{

                   Map<String, String> map = new HashMap<String, String>();

                   File file = new File(filePath);

                   InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");// 考虑到编码格式

                   BufferedReader reader = null;

                   try {

                   //      System.out.println("以行为单位读取文件内容，一次读一整行：");

                            reader = new BufferedReader(new FileReader(file));

                            String tempString = null;

                            int line = 1;

                            // 一次读入一行，直到读入null为文件结束

                            while ((tempString = reader.readLine()) != null) {

                                     // 显示行号

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

 