//Chat
//Client

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class EX30_12_Client extends JFrame
{
 private JTextArea jtaServer = new JTextArea();//輸入的文本欄
 private JTextArea jtaClient = new JTextArea();//顯示的文本欄
 
 private Socket socket; //socket

 private DataInputStream fromServer;
 private DataOutputStream toServer; 

 public EX30_12_Client()
  {
   //輸入文本panel
   JPanel clientPanel = new JPanel(new BorderLayout());
   clientPanel.add(new JScrollPane(jtaClient),BorderLayout.CENTER);
   clientPanel.setBorder(new TitledBorder("Client"));

   jtaServer.setEditable(false);//顯示文本不可編輯

   //顯示文本欄
   JPanel serverPanel = new JPanel(new BorderLayout());
   serverPanel.add(new JScrollPane(jtaServer),BorderLayout.CENTER);
   serverPanel.setBorder(new TitledBorder("Server"));

   //排版
   setLayout(new GridLayout(2,1));
   add(clientPanel);
   add(serverPanel);

   //textarea光標監聽
   jtaClient.addCaretListener(new CaretListener(){
    public void caretUpdate(CaretEvent e){
     try{
      //e.getDot() 獲得插入符的位置 
      int offset = e.getDot() ;
                 
      //將TextArea中的offset轉為行數
      int row = jtaClient.getLineOfOffset(offset);
                    
      int column = e.getDot() - jtaClient.getLineStartOffset(row);
      
      //讓光標固定在最後一行
      if(jtaClient.getLineCount() != row+1)
       {
        jtaClient.setCaretPosition(jtaClient.getText().length());
       }
     }
     catch (Exception ex){
      ex.printStackTrace();
     }
    }
   });
   
   //textarea事件
   jtaClient.addKeyListener(new KeyAdapter() {
    public void keyPressed(KeyEvent e) {
      try{
       //按enter換行與送出訊息
       if(e.getKeyCode() == KeyEvent.VK_ENTER) 
        {
         String allText = jtaClient.getText();
         String[] textArray = allText.split("\n");
         
         toServer.writeUTF(textArray[textArray.length-1]);
        }
       
      }
      catch(Exception ex){}
     }
   });

   new Thread(new ChatTask()).start();//開始接受文字
  }

 class ChatTask implements Runnable
  {
   public ChatTask()
    {
     try{
      //連線
      socket = new Socket("localhost",8000);
    
      toServer = new DataOutputStream(socket.getOutputStream());
      fromServer = new DataInputStream(socket.getInputStream());
     }
     catch(IOException ex){
     }
    }
   
   public void run()
    {
     try{
      while(true)
       {
        //接受文字並顯示
        jtaServer.setText(jtaServer.getText()+fromServer.readUTF()+"\n");
       }
     }
     catch(IOException ex){
     }
    }
  }

 public static void main(String args[])
  {
   EX30_12_Client frame = new EX30_12_Client();//frame
   frame.setTitle("EX30_12_Client");//標題
   frame.setSize(500,500);//大小
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setLocationRelativeTo(null);//相對位置
   frame.setVisible(true);//顯示
  }
}