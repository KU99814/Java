//Multiple client chat
//Client

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class EX30_13_Client extends JFrame
{
 private JTextField jtdName = new JTextField(24);//��J�m�W
 private JTextField jtdMessage = new JTextField(24); //��J�T��
 
 private JTextArea jtaServerMessage = new JTextArea();//��ܰT��

 private String userName = "";//�ϥΪ̦W��
 
 private String text = "";//��ܪ��T��

 private Socket socket;
 
 public EX30_13_Client()
  {
   //�ϥΪ�panel
   JPanel userPanel = new JPanel(new GridLayout(2,2));
   userPanel.add(new JLabel("Name:"));
   userPanel.add(jtdName);
   userPanel.add(new JLabel("Message:"));
   userPanel.add(jtdMessage);

   //�T��panel
   JPanel textPanel = new JPanel(new BorderLayout());
   textPanel.add(new JScrollPane(jtaServerMessage),BorderLayout.CENTER);

   //�T���]�����i�s�誽���J�ϥΪ̦W��
   jtdMessage.setEditable(false);
   jtaServerMessage.setEditable(false);
   
   //�ƪ�
   setLayout(new BorderLayout());
   add(userPanel,BorderLayout.NORTH);
   add(textPanel,BorderLayout.CENTER);

   //�ϥΪ̦W�٨ƥ�
   jtdName.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     //��J�ϥΪ̦W��
     if(!jtdName.getText().equals("") && jtdName.isEditable())
      {
       userName = jtdName.getText();
       jtdName.setEditable(false);
       jtdMessage.setEditable(true);
       //�}�l�s�u�P�ǰe�T��
       try{
        socket = new Socket("localhost",8000);
        DataInputStream fromServer = new DataInputStream(socket.getInputStream());
        DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
        toServer.writeUTF(userName);//�ǰe�ϥΪ̦W��
        text += fromServer.readUTF();//�����ثe�w�ǰe���T��
        jtaServerMessage.setText(text);
        new Thread(new getMessage()).start();//�}�l����server�T��
        jtdMessage.requestFocus();//���T����focus
       }
       catch(IOException ex){
       }
      }
    }
   });

   //�T����ƥ�
   jtdMessage.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     if(!jtdMessage.getText().equals("") && jtdMessage.isEditable())
      {
       try{
        DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
        toServer.writeUTF(userName +":"+jtdMessage.getText());//�ǰe��J�T��
        jtdMessage.setText("");//�����T��
       }
       catch(IOException ex){
       }
      }
    }
   });
  }

 //���Ttask
 class getMessage implements Runnable
  {
   public void run()
    {     
     try{
      DataInputStream fromServer = new DataInputStream(socket.getInputStream());

      //���H�ǰT�� �|�����ǰe���T��
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
   frame.setTitle("EX30_13_Client");//���D
   frame.setSize(500,500);//�j�p
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setVisible(true);//���
  }
}