//Transferring last 100 numbers in an Arraylist Client

import java.io.*;
import java.net.*;
import java.util.*;

public class EX30_8_Server
{
 public static void main(String args[]) throws IOException
  {
   RandomAccessFile inout = new RandomAccessFile("EX23_8.dat","rw");//���o�ɮ�

   inout.seek(inout.length()-8*100);//���ʨ�˼�100����
   
   try{
    ArrayList<Long> list = new ArrayList<Long>();//��X��list

    while(inout.getFilePointer()!=inout.length())//�P�_�ɮ׬O�_���Y
     {
      list.add(inout.readLong());//��J
     }
    
    System.out.println("Start server");//�}�l�s�u
    ServerSocket serverSocket = new ServerSocket(8000);
   
    while(true)
     {
      //�����s�u
      Socket socket = serverSocket.accept();

      //��X�ɮ�     
      ObjectOutputStream toClient = new ObjectOutputStream(socket.getOutputStream());
     
      toClient.writeObject(list);//��X
     
      toClient.close();
     }
    }
    catch(IOException ex){
     System.err.println(ex);
    }
  }
}