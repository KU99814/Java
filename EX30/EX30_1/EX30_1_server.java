//Random server

import java.io.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;

public class EX30_1_server
{
 public static void main(String args[])
  {
   System.out.println("Start Server");//

   try{
    ServerSocket serverSocket = new ServerSocket(8000);//server socket
    
    while(true)
     {
      Socket socket = serverSocket.accept();//������socket

      //�e�X���
      DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

      InetAddress inetAddress = socket.getInetAddress();//������}
      System.out.println("Client IP is:"+inetAddress.getHostAddress());//��ܦ�}
      double number = Math.random()*100-1;//�H�����ͼƦr
      outputToClient.writeDouble(number);//�ǰe�Ʀr
      System.out.println("generated "+number);//��ܲ��ͪ��Ʀr
     }
   }
   catch(IOException ex)   //�ҥ~
   {
    System.out.println(ex);
   }
  }
}