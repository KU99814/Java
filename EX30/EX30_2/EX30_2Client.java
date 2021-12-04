//Network I/O Scanner and PrintWriter

import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class EX30_2Client extends JFrame
{
 private JTextField jtf = new JTextField(10);//輸入半徑

 private JTextArea jta = new JTextArea();//顯示溝通資訊

 private PrintWriter toServer;//傳送資料
 private Scanner fromServer;//接收資料
 
 public static void main(String args[])
  {
   new EX30_2Client();//創建client物件
  }

 public EX30_2Client()
  {
   JPanel p = new JPanel();//輸入panel
   p.setLayout(new BorderLayout());//設定排版
   p.add(new JLabel("Enter radius"),BorderLayout.WEST);//p加入label
   p.add(jtf,BorderLayout.CENTER);//加入輸入欄位
   jtf.setHorizontalAlignment(JTextField.RIGHT);//對齊

   setLayout(new BorderLayout());//frame 排版
   add(p,BorderLayout.NORTH);//輸入panel加入
   add(new JScrollPane(jta),BorderLayout.CENTER);//加入卷軸在textarea

   jtf.addActionListener(new TextFieldListener());//輸入欄加入event

   setTitle("Client");//標題
   setSize(500,300);//視窗大小
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   setVisible(true);//顯示

   try{
    Socket socket = new Socket("localhost",8000);//socket
    
    fromServer = new Scanner(socket.getInputStream());//設定傳送
    
    toServer = new PrintWriter(socket.getOutputStream());//設定接收
   }
   catch(IOException ex){
    jta.append(ex.toString()+'\n');
   }
  }

 //輸入欄事件
 private class TextFieldListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     try{
      double radius = Double.parseDouble(jtf.getText().trim());//半徑

      //傳送半徑到server
      toServer.println(radius);
      toServer.flush();
      
      double area = fromServer.nextDouble();//從server取得面積

      //顯示在textarea      
      jta.append("Radius is "+radius+"\n");
      jta.append("Area received from the server is "+area+'\n');
     }
     catch(Exception ex){
      System.err.println(ex);
     }
    }
  }
}