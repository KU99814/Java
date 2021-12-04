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

 private static StringBuilder messageText = new StringBuilder();//�����T��

 private static ArrayList<Socket> list = new ArrayList<Socket>();//�s�u��socket

 public static void main(String args[])
  {
   try{
    serverSocket = new ServerSocket(8000);//�]�wserver socket
    
    while(true)
     {
      Socket socket = serverSocket.accept();//����socket

      DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());
      DataInputStream fromClient = new DataInputStream(socket.getInputStream());

      System.out.println(fromClient.readUTF()+" connecting");//�����ϥΪ̦W��
      toClient.writeUTF(messageText.toString());//�ǰe�ثe�����T��
      list.add(socket);//�[�Jsocket

      new Thread(new ChatTask(socket)).start();//�����T��thread
     }
   }
   catch(IOException ex){
   }
  }

 //�����T��task
 static class ChatTask implements Runnable
  {
   private Socket socket;//�s�u��socket
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

      //�����T��
      while(true)
       {
        String message = fromClient.readUTF();
        
        lock.lock();//�W��
 
        messageText.append(message+"\n");//�����T��
        sendMessage(message);//�ǰe�T��

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
   
   //�ǰe�T����Ҧ��s�u
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