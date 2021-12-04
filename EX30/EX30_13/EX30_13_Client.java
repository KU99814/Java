//Multiple client chat
//Client

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class EX30_13_Client extends JFrame
{
 private JTextField jtdName = new JTextField(24);//輸入姓名
 private JTextField jtdMessage = new JTextField(24); //輸入訊息
 
 private JTextArea jtaServerMessage = new JTextArea();//顯示訊息

 private String userName = "";//使用者名稱
 
 private String text = "";//顯示的訊息

 private Socket socket;
 
 public EX30_13_Client()
  {
   //使用者panel
   JPanel userPanel = new JPanel(new GridLayout(2,2));
   userPanel.add(new JLabel("Name:"));
   userPanel.add(jtdName);
   userPanel.add(new JLabel("Message:"));
   userPanel.add(jtdMessage);

   //訊息panel
   JPanel textPanel = new JPanel(new BorderLayout());
   textPanel.add(new JScrollPane(jtaServerMessage),BorderLayout.CENTER);

   //訊息設為不可編輯直到輸入使用者名稱
   jtdMessage.setEditable(false);
   jtaServerMessage.setEditable(false);
   
   //排版
   setLayout(new BorderLayout());
   add(userPanel,BorderLayout.NORTH);
   add(textPanel,BorderLayout.CENTER);

   //使用者名稱事件
   jtdName.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     //輸入使用者名稱
     if(!jtdName.getText().equals("") && jtdName.isEditable())
      {
       userName = jtdName.getText();
       jtdName.setEditable(false);
       jtdMessage.setEditable(true);
       //開始連線與傳送訊息
       try{
        socket = new Socket("localhost",8000);
        DataInputStream fromServer = new DataInputStream(socket.getInputStream());
        DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
        toServer.writeUTF(userName);//傳送使用者名稱
        text += fromServer.readUTF();//接收目前已傳送的訊息
        jtaServerMessage.setText(text);
        new Thread(new getMessage()).start();//開始接收server訊息
        jtdMessage.requestFocus();//讓訊息欄focus
       }
       catch(IOException ex){
       }
      }
    }
   });

   //訊息欄事件
   jtdMessage.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     if(!jtdMessage.getText().equals("") && jtdMessage.isEditable())
      {
       try{
        DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
        toServer.writeUTF(userName +":"+jtdMessage.getText());//傳送輸入訊息
        jtdMessage.setText("");//接收訊息
       }
       catch(IOException ex){
       }
      }
    }
   });
  }

 //收訊task
 class getMessage implements Runnable
  {
   public void run()
    {     
     try{
      DataInputStream fromServer = new DataInputStream(socket.getInputStream());

      //當有人傳訊時 會接收傳送的訊息
      while(true)
       {
        text += fromServer.readUTF()+"\n";
        jtaServerMessage.setText(text);
       }
     }
     catch(IOException ex){
     }
    }
  }

 public static void main(String args[])
  {
   EX30_13_Client frame = new EX30_13_Client();//frame
   frame.setTitle("EX30_13_Client");//標題
   frame.setSize(500,500);//大小
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setLocationRelativeTo(null);//相對位置
   frame.setVisible(true);//顯示
  }
}