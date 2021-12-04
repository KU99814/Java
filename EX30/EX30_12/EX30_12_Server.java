//Chat
//Server

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class EX30_12_Server extends JFrame
{
 private JTextArea jtaServer = new JTextArea();//輸入的文本欄
 private JTextArea jtaClient = new JTextArea();//顯示的文本欄
 
 private ServerSocket serverSocket;//server socket
 private Socket socket; //socket

 private DataInputStream fromClient;
 private DataOutputStream toClient; 

 public EX30_12_Server()
  {
   //輸入文本panel
   JPanel serverPanel = new JPanel(new BorderLayout());
   serverPanel.add(new JScrollPane(jtaServer),BorderLayout.CENTER);
   serverPanel.setBorder(new TitledBorder("Server"));

   jtaClient.setEditable(false);//顯示文本不可編輯

   //顯示文本欄
   JPanel clientPanel = new JPanel(new BorderLayout());
   clientPanel.add(new JScrollPane(jtaClient),BorderLayout.CENTER);
   clientPanel.setBorder(new TitledBorder("Client"));

   //排版
   setLayout(new GridLayout(2,1));
   add(serverPanel);
   add(clientPanel);

   //textarea光標監聽
   jtaServer.addCaretListener(new CaretListener(){
    public void caretUpdate(CaretEvent e){
     try{
      //e.getDot() 獲得插入符的位置 
      int offset = e.getDot() ;
                 
      //將TextArea中的offset轉為行數
      int row = jtaServer.getLineOfOffset(offset);
                    
      int column = e.getDot() - jtaServer.getLineStartOffset(row);
      
      //讓光標固定在最後一行
      if(jtaServer.getLineCount() != row+1)
       {
        jtaServer.setCaretPosition(jtaServer.getText().length());
       }
     }
     catch (Exception ex){
      ex.printStackTrace();
     }
    }
   });
   
   //textarea事件
   jtaServer.addKeyListener(new KeyAdapter() {
    public void keyPressed(KeyEvent e) {
      try{
       //按enter換行與送出訊息
       if(e.getKeyCode() == KeyEvent.VK_ENTER) 
        {
         String allText = jtaServer.getText();
         String[] textArray = allText.split("\n");
         
         toClient.writeUTF(textArray[textArray.length-1]);
        }
       
      }
      catch(Exception ex){}
     }
   });

   try{
    //連線
    System.out.println("waiting connecting...");
    serverSocket = new ServerSocket(8000);
    socket = serverSocket.accept();
    
    toClient = new DataOutputStream(socket.getOutputStream());
    fromClient = new DataInputStream(socket.getInputStream());
    
    System.out.println("start connecting");
   }
   catch(IOException ex){
   }

   new Thread(new ChatTask()).start();//開始接受文字
  }

 class ChatTask implements Runnable
  {
   public ChatTask()
    {}
   
   public void run()
    {
     try{
      while(true)
       {
        //接受文字並顯示
        jtaClient.setText(jtaClient.getText()+fromClient.readUTF()+"\n");
       }
     }
     catch(IOException ex){
     }
    }
  }

 public static void main(String args[])
  {
   EX30_12_Server frame = new EX30_12_Server();//frame
   frame.setTitle("EX30_12_Server");//標題
   frame.setSize(500,500);//大小
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setLocationRelativeTo(null);//相對位置
   frame.setVisible(true);//顯示
  }
}