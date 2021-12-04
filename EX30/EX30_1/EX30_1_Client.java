//Random client

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX30_1_Client extends JFrame
{
 private JLabel label = new JLabel("Your lucky number is ");//顯示的label

 public static void main(String args[])
  {
   new EX30_1_Client();//創建client物件
  }

 public EX30_1_Client()
  {
   add(label);//加入label到frame
   
   setTitle("EX30_1_Client");//設定標題
   setSize(400,100);//視窗大小
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   setVisible(true);//顯示

   try{
    Socket socket = new Socket("localhost",8000);//socket
    
    DataInputStream fromServer = new DataInputStream(socket.getInputStream());//資料接收

    label.setText(label.getText()+fromServer.readDouble());//將label的文字加上接收的數字
   }
   catch(IOException ex){    //例外
    System.out.println(ex);
   }
  }
}