//Loan server for multiple client

import java.io.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class EX30_3_Server
{
 public static void main(String args[])
  {
   new EX30_3_Server();//創建server物件
  }

 public EX30_3_Server()
  {
   System.out.println("Start Server");//顯示開始

   try{
    ServerSocket serverSocket = new ServerSocket(8000);//server socket

    int clientNo = 1;
    
    while(true)
     {
      
      Socket socket = serverSocket.accept();//接收的socket
      clientNo++;
      
      HandleAClient task = new HandleAClient(socket,clientNo);//創建task

      new Thread(task).start();//啟動執行緒
     }
   }
   catch(IOException ex)   //例外
   {
    System.out.println(ex);
   }
  }

 //handle a client tasket
 class HandleAClient implements Runnable
  {
   private Socket socket;//執行的client socket
   private int clientNo; //client編號
   
   //constructor
   public HandleAClient(Socket socket,int clientNo)
    {
     this.socket = socket;
     this.clientNo = clientNo;
    }

   //執行   
   public void run()
    {
     try{
      System.out.println("Client No."+clientNo);
      //送出資料
      DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

      InetAddress inetAddress = socket.getInetAddress();//網路位址
      System.out.println("Client IP is:"+inetAddress.getHostAddress());//顯示位址
      double number = Math.random()*100-1;//隨機產生數字
      outputToClient.writeDouble(number);//傳送數字
      System.out.println("generated "+number);//顯示產生的數字
     }
     catch(IOException ex)
     {
      System.out.println(ex);
     }
    }
  }
}