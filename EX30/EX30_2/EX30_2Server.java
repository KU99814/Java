//Network I/O using Scanner and PrintWriter

import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class EX30_2Server extends JFrame
{
 private JTextArea jta = new JTextArea();//text area

 public EX30_2Server()
  {
   setLayout(new BorderLayout());//�]�w�ƪ�
   add(new JScrollPane(jta),BorderLayout.CENTER);//�]�w���b
   
   setTitle("Server");//���D
   setSize(500,200);//�����j�p
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   setVisible(true);//���
   
   try{
    ServerSocket serverSocket = new ServerSocket(8000);//socket server
    jta.append("Server started at "+new Date() +'\n');//��ܦb�奻
    
    Socket socket = serverSocket.accept();//���client socket

    Scanner inputFromClient = new Scanner(socket.getInputStream());//�������
    PrintWriter outputToClient = new PrintWriter(socket.getOutputStream());//�ǰe���

    while(true)
     {      
      double radius = inputFromClient.nextDouble();//����radius���
      
      double area = radius*radius*Math.PI;//�p�⭱�n
      
      outputToClient.println(area);//�ǰe���n���
      outputToClient.flush();
      
      //��ܦb�奻��
      jta.append("Radius received from client: "+radius+'\n');
      jta.append("Area found: "+area+'\n');
     }
   }
   catch(IOException ex){
    System.err.println(ex);
   }
  }

 public static void main(String args[])
  {
   new EX30_2Server();//�Ы�server����
  }
}