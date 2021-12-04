//Transferring last 100 numbers in an Arraylist Client

import java.io.*;
import java.net.*;
import java.util.*;

public class EX30_8_Server
{
 public static void main(String args[]) throws IOException
  {
   RandomAccessFile inout = new RandomAccessFile("EX23_8.dat","rw");//取得檔案

   inout.seek(inout.length()-8*100);//移動到倒數100的數
   
   try{
    ArrayList<Long> list = new ArrayList<Long>();//輸出用list

    while(inout.getFilePointer()!=inout.length())//判斷檔案是否到頭
     {
      list.add(inout.readLong());//輸入
     }
    
    System.out.println("Start server");//開始連線
    ServerSocket serverSocket = new ServerSocket(8000);
   
    while(true)
     {
      //接收連線
      Socket socket = serverSocket.accept();

      //輸出檔案     
      ObjectOutputStream toClient = new ObjectOutputStream(socket.getOutputStream());
     
      toClient.writeObject(list);//輸出
     
      toClient.close();
     }
    }
    catch(IOException ex){
     System.err.println(ex);
    }
  }
}