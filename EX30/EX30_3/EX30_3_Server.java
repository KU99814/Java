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
   new EX30_3_Server();//�Ы�server����
  }

 public EX30_3_Server()
  {
   System.out.println("Start Server");//��ܶ}�l

   try{
    ServerSocket serverSocket = new ServerSocket(8000);//server socket

    int clientNo = 1;
    
    while(true)
     {
      
      Socket socket = serverSocket.accept();//������socket
      clientNo++;
      
      HandleAClient task = new HandleAClient(socket,clientNo);//�Ы�task

      new Thread(task).start();//�Ұʰ����
     }
   }
   catch(IOException ex)   //�ҥ~
   {
    System.out.println(ex);
   }
  }

 //handle a client tasket
 class HandleAClient implements Runnable
  {
   private Socket socket;//���檺client socket
   private int clientNo; //client�s��
   
   //constructor
   public HandleAClient(Socket socket,int clientNo)
    {
     this.socket = socket;
     this.clientNo = clientNo;
    }

   //����   
   public void run()
    {
     try{
      System.out.println("Client No."+clientNo);
      //�e�X���
      DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

      InetAddress inetAddress = socket.getInetAddress();//������}
      System.out.println("Client IP is:"+inetAddress.getHostAddress());//��ܦ�}
      double number = Math.random()*100-1;//�H�����ͼƦr
      outputToClient.writeDouble(number);//�ǰe�Ʀr
      System.out.println("generated "+number);//��ܲ��ͪ��Ʀr
     }
     catch(IOException ex)
     {
      System.out.println(ex);
     }
    }
  }
}