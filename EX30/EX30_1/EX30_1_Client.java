//Random client

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX30_1_Client extends JFrame
{
 private JLabel label = new JLabel("Your lucky number is ");//��ܪ�label

 public static void main(String args[])
  {
   new EX30_1_Client();//�Ы�client����
  }

 public EX30_1_Client()
  {
   add(label);//�[�Jlabel��frame
   
   setTitle("EX30_1_Client");//�]�w���D
   setSize(400,100);//�����j�p
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   setVisible(true);//���

   try{
    Socket socket = new Socket("localhost",8000);//socket
    
    DataInputStream fromServer = new DataInputStream(socket.getInputStream());//��Ʊ���

    label.setText(label.getText()+fromServer.readDouble());//�Nlabel����r�[�W�������Ʀr
   }
   catch(IOException ex){    //�ҥ~
    System.out.println(ex);
   }
  }
}