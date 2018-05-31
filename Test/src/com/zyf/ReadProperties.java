package com.zyf;
import java.io.BufferedInputStream;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.io.InputStream;

import java.util.HashMap;

import java.util.Map;

import java.util.Properties;

import java.util.Map.Entry;

 

public class ReadProperties {

 

         private static Map<Object, Object> contains = new HashMap<Object, Object>();

         private static Map<Object, Object> contains2 = new HashMap<Object, Object>();

         private static Properties p = null;

         private static Map<Object, Object> NEWcontains = new HashMap<Object, Object>();  //不重复的

         private static Map<Object, Object> oldcontains = new HashMap<Object, Object>();  //重复的

        

         public static void main(String[] args) {

                   /**

                   * 读取properties

                    */

                   InputStream in = null;

                   try {

                            in = new BufferedInputStream(new FileInputStream("D:"+File.separator

                                                  +File.separator+"zuixin_messages_zh_CN.properties"));

                            p = new Properties();

                            p.load(in);

                            contains = p;

                           

                            in = new BufferedInputStream(new FileInputStream("D:"+File.separator

                                               +File.separator+"qinjin_messages_zh_CN.properties"));

                            p = new Properties();

                            p.load(in);

                            contains2 = p;

                   } catch (FileNotFoundException e) {

                            e.printStackTrace();

                   } catch (IOException e) {

                            e.printStackTrace();

                   } finally {

                            try {

                                     in.close();

                            } catch (IOException e) {

                                     e.printStackTrace();

                            }

                   }

        /**

         *  循环遍历

         */

                   int i = 1;

                   for (Entry<Object, Object> item : contains2.entrySet()) {

                            if(contains.containsKey(item.getKey())){

                                     oldcontains.put(item.getKey(), item.getValue());

                            }else{

                                     contains.put(item.getKey(), item.getValue());

                            }

                           

                   }

//               for (Entry<Object, Object> item : contains.entrySet()){

//                         System.out.println(item.getKey()+"="+item.getValue());

//               }

                   System.out.println("--------------------------分割线----------------------------");

                   System.out.println("--------------------------分割线----------------------------");

                   System.out.println("--------------------------分割线----------------------------");

                   for (Entry<Object, Object> item : oldcontains.entrySet()){

                            System.out.println(item.getKey()+"="+item.getValue());

                   }

                  

 

         }

}

 

 

 

 

 

 

 

 

 

 
