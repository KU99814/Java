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
      Socket socket = serverSocket.accept();//接收的socket

      //送出資料
      DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

      InetAddress inetAddress = socket.getInetAddress();//網路位址
      System.out.println("Client IP is:"+inetAddress.getHostAddress());//顯示位址
      double number = Math.random()*100-1;//隨機產生數字
      outputToClient.writeDouble(number);//傳送數字
      System.out.println("generated "+number);//顯示產生的數字
     }
   }
   catch(IOException ex)   //例外
   {
    System.out.println(ex);
   }
  }
}