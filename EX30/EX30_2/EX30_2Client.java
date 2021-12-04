//Network I/O Scanner and PrintWriter

import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class EX30_2Client extends JFrame
{
 private JTextField jtf = new JTextField(10);//��J�b�|

 private JTextArea jta = new JTextArea();//��ܷ��q��T

 private PrintWriter toServer;//�ǰe���
 private Scanner fromServer;//�������
 
 public static void main(String args[])
  {
   new EX30_2Client();//�Ы�client����
  }

 public EX30_2Client()
  {
   JPanel p = new JPanel();//��Jpanel
   p.setLayout(new BorderLayout());//�]�w�ƪ�
   p.add(new JLabel("Enter radius"),BorderLayout.WEST);//p�[�Jlabel
   p.add(jtf,BorderLayout.CENTER);//�[�J��J���
   jtf.setHorizontalAlignment(JTextField.RIGHT);//���

   setLayout(new BorderLayout());//frame �ƪ�
   add(p,BorderLayout.NORTH);//��Jpanel�[�J
   add(new JScrollPane(jta),BorderLayout.CENTER);//�[�J���b�btextarea

   jtf.addActionListener(new TextFieldListener());//��J��[�Jevent

   setTitle("Client");//���D
   setSize(500,300);//�����j�p
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   setVisible(true);//���

   try{
    Socket socket = new Socket("localhost",8000);//socket
    
    fromServer = new Scanner(socket.getInputStream());//�]�w�ǰe
    
    toServer = new PrintWriter(socket.getOutputStream());//�]�w����
   }
   catch(IOException ex){
    jta.append(ex.toString()+'\n');
   }
  }

 //��J��ƥ�
 private class TextFieldListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     try{
      double radius = Double.parseDouble(jtf.getText().trim());//�b�|

      //�ǰe�b�|��server
      toServer.println(radius);
      toServer.flush();
      
      double area = fromServer.nextDouble();//�qserver���o���n

      //��ܦbtextarea      
      jta.append("Radius is "+radius+"\n");
      jta.append("Area received from the server is "+area+'\n');
     }
     catch(Exception ex){
      System.err.println(ex);
     }
    }
  }
}