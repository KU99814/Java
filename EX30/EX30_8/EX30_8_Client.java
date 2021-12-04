//Transferring last 100 numbers in an Arraylist Client

import java.io.*;
import java.net.*;
import java.util.*;

public class EX30_8_Client
{
 public static void main(String args[]) throws IOException
  {
   RandomAccessFile inout = new RandomAccessFile("EX23_8_Client.dat","rw");//取得檔案

   inout.seek(0);//重新定位
   Socket socket = new Socket("localhost",8000);//socket

   //接收來自server的檔案
   ObjectInputStream fromServer = new ObjectInputStream(socket.getInputStream());

   try{
    ArrayList<Long> list = (ArrayList<Long>)fromServer.readObject();//接收list
    
    //顯示接收數量
    System.out.println(list.size());

    //顯示質數與輸出檔案
    for(int i=0;i<list.size();i++)
     {
      System.out.print(list.get(i)+" ");
      inout.writeLong(list.get(i));
     }
     fromServer.close();
    }
    catch(IOException ex){
     System.err.println(ex);
    }
    catch(ClassNotFoundException ex){
     System.err.println(ex);
    }
  }
}