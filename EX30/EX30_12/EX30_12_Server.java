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
 private JTextArea jtaServer = new JTextArea();//��J���奻��
 private JTextArea jtaClient = new JTextArea();//��ܪ��奻��
 
 private ServerSocket serverSocket;//server socket
 private Socket socket; //socket

 private DataInputStream fromClient;
 private DataOutputStream toClient; 

 public EX30_12_Server()
  {
   //��J�奻panel
   JPanel serverPanel = new JPanel(new BorderLayout());
   serverPanel.add(new JScrollPane(jtaServer),BorderLayout.CENTER);
   serverPanel.setBorder(new TitledBorder("Server"));

   jtaClient.setEditable(false);//��ܤ奻���i�s��

   //��ܤ奻��
   JPanel clientPanel = new JPanel(new BorderLayout());
   clientPanel.add(new JScrollPane(jtaClient),BorderLayout.CENTER);
   clientPanel.setBorder(new TitledBorder("Client"));

   //�ƪ�
   setLayout(new GridLayout(2,1));
   add(serverPanel);
   add(clientPanel);

   //textarea���к�ť
   jtaServer.addCaretListener(new CaretListener(){
    public void caretUpdate(CaretEvent e){
     try{
      //e.getDot() ��o���J�Ū���m 
      int offset = e.getDot() ;
                 
      //�NTextArea����offset�ର���
      int row = jtaServer.getLineOfOffset(offset);
                    
      int column = e.getDot() - jtaServer.getLineStartOffset(row);
      
      //�����ЩT�w�b�̫�@��
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
   
   //textarea�ƥ�
   jtaServer.addKeyListener(new KeyAdapter() {
    public void keyPressed(KeyEvent e) {
      try{
       //��enter����P�e�X�T��
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
    //�s�u
    System.out.println("waiting connecting...");
    serverSocket = new ServerSocket(8000);
    socket = serverSocket.accept();
    
    toClient = new DataOutputStream(socket.getOutputStream());
    fromClient = new DataInputStream(socket.getInputStream());
    
    System.out.println("start connecting");
   }
   catch(IOException ex){
   }

   new Thread(new ChatTask()).start();//�}�l������r
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
        //������r�����
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
   frame.setTitle("EX30_12_Server");//���D
   frame.setSize(500,500);//�j�p
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setVisible(true);//���
  }
}