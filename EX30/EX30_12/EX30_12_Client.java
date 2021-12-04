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
 private JTextArea jtaServer = new JTextArea();//��J���奻��
 private JTextArea jtaClient = new JTextArea();//��ܪ��奻��
 
 private Socket socket; //socket

 private DataInputStream fromServer;
 private DataOutputStream toServer; 

 public EX30_12_Client()
  {
   //��J�奻panel
   JPanel clientPanel = new JPanel(new BorderLayout());
   clientPanel.add(new JScrollPane(jtaClient),BorderLayout.CENTER);
   clientPanel.setBorder(new TitledBorder("Client"));

   jtaServer.setEditable(false);//��ܤ奻���i�s��

   //��ܤ奻��
   JPanel serverPanel = new JPanel(new BorderLayout());
   serverPanel.add(new JScrollPane(jtaServer),BorderLayout.CENTER);
   serverPanel.setBorder(new TitledBorder("Server"));

   //�ƪ�
   setLayout(new GridLayout(2,1));
   add(clientPanel);
   add(serverPanel);

   //textarea���к�ť
   jtaClient.addCaretListener(new CaretListener(){
    public void caretUpdate(CaretEvent e){
     try{
      //e.getDot() ��o���J�Ū���m 
      int offset = e.getDot() ;
                 
      //�NTextArea����offset�ର���
      int row = jtaClient.getLineOfOffset(offset);
                    
      int column = e.getDot() - jtaClient.getLineStartOffset(row);
      
      //�����ЩT�w�b�̫�@��
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
   
   //textarea�ƥ�
   jtaClient.addKeyListener(new KeyAdapter() {
    public void keyPressed(KeyEvent e) {
      try{
       //��enter����P�e�X�T��
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

   new Thread(new ChatTask()).start();//�}�l������r
  }

 class ChatTask implements Runnable
  {
   public ChatTask()
    {
     try{
      //�s�u
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
        //������r�����
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
   frame.setTitle("EX30_12_Client");//���D
   frame.setSize(500,500);//�j�p
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setVisible(true);//���
  }
}