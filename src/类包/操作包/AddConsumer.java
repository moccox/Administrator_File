/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 类包.操作包;

import java.io.*;

/**
 *
 * @author Administrator
 */
public class AddConsumer {
    
    public AddConsumer(String a,String b,String c,String d){
         try{ 
             File f=new File("Consumer.txt"); //相对路径打开文件
             if(!f.exists()){
                 throw new FileNotFound();
             }
             FileWriter FW=new FileWriter(f.getAbsolutePath(),true); //绝对路径打开文件
             String Data=a+","+b+","+c+","+d+'\n';
             FW.write(Data);
             FW.close();
         }catch(FileNotFound ex){
             System.out.println("文件\"Consumer.txt\"不存在！");
         }catch(Exception ex){
             System.out.println("未知错误！");
         }
    }

    private static class FileNotFound extends Exception {

        public FileNotFound() {
            super();
        }
    }
}
