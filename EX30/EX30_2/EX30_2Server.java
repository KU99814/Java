//Network I/O using Scanner and PrintWriter

import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class EX30_2Server extends JFrame
{
 private JTextArea jta = new JTextArea();//text area

 public EX30_2Server()
  {
   setLayout(new BorderLayout());//設定排版
   add(new JScrollPane(jta),BorderLayout.CENTER);//設定卷軸
   
   setTitle("Server");//標題
   setSize(500,200);//視窗大小
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   setVisible(true);//顯示
   
   try{
    ServerSocket serverSocket = new ServerSocket(8000);//socket server
    jta.append("Server started at "+new Date() +'\n');//顯示在文本
    
    Socket socket = serverSocket.accept();//獲取client socket

    Scanner inputFromClient = new Scanner(socket.getInputStream());//接收資料
    PrintWriter outputToClient = new PrintWriter(socket.getOutputStream());//傳送資料

    while(true)
     {      
      double radius = inputFromClient.nextDouble();//接收radius資料
      
      double area = radius*radius*Math.PI;//計算面積
      
      outputToClient.println(area);//傳送面積資料
      outputToClient.flush();
      
      //顯示在文本中
      jta.append("Radius received from client: "+radius+'\n');
      jta.append("Area found: "+area+'\n');
     }
   }
   catch(IOException ex){
    System.err.println(ex);
   }
  }

 public static void main(String args[])
  {
   new EX30_2Server();//創建server物件
  }
}