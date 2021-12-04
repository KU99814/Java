//MultiPle client chat
//Server

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class EX30_13_Server
{
 private static ServerSocket serverSocket;

 private static StringBuilder messageText = new StringBuilder();//全部訊息

 private static ArrayList<Socket> list = new ArrayList<Socket>();//連線的socket

 public static void main(String args[])
  {
   try{
    serverSocket = new ServerSocket(8000);//設定server socket
    
    while(true)
     {
      Socket socket = serverSocket.accept();//接受socket

      DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());
      DataInputStream fromClient = new DataInputStream(socket.getInputStream());

      System.out.println(fromClient.readUTF()+" connecting");//接收使用者名稱
      toClient.writeUTF(messageText.toString());//傳送目前全部訊息
      list.add(socket);//加入socket

      new Thread(new ChatTask(socket)).start();//接收訊息thread
     }
   }
   catch(IOException ex){
   }
  }

 //接收訊息task
 static class ChatTask implements Runnable
  {
   private Socket socket;//連線的socket
   private DataInputStream fromClient;

   private static Lock lock = new ReentrantLock();//lock 

   //constructor
   public ChatTask(Socket socket)
    {
     this.socket = socket;
    }

   public void run()
    {
     try{
      fromClient = new DataInputStream(socket.getInputStream());

      //接收訊息
      while(true)
       {
        String message = fromClient.readUTF();
        
        lock.lock();//上鎖
 
        messageText.append(message+"\n");//接收訊息
        sendMessage(message);//傳送訊息

        lock.unlock();
       }
     }
     catch(IOException ex){
      list.remove(socket);
     }
     finally{
      
      lock.unlock();
     }
    }
   
   //傳送訊息改所有連線
   public void sendMessage(String message)
    {
     try{
      for(int i=0;i<list.size();i++)
       {
        DataOutputStream toClient = new DataOutputStream(list.get(i).getOutputStream());
       
        toClient.writeUTF(message);
       }
     }
     catch(IOException ex){
     }
    }
  } 
}