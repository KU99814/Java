//Transferring last 100 numbers in an Arraylist Client

import java.io.*;
import java.net.*;
import java.util.*;

public class EX30_8_Client
{
 public static void main(String args[]) throws IOException
  {
   RandomAccessFile inout = new RandomAccessFile("EX23_8_Client.dat","rw");//���o�ɮ�

   inout.seek(0);//���s�w��
   Socket socket = new Socket("localhost",8000);//socket

   //�����Ӧ�server���ɮ�
   ObjectInputStream fromServer = new ObjectInputStream(socket.getInputStream());

   try{
    ArrayList<Long> list = (ArrayList<Long>)fromServer.readObject();//����list
    
    //��ܱ����ƶq
    System.out.println(list.size());

    //��ܽ�ƻP��X�ɮ�
    for(int i=0;i<list.size();i++)
     {
      System.out.print(list.get(i)+" ");
      inout.writeLong(list.get(i));
     }
     fromServer.close();
    }
    catch(IOException ex){
     System.err.println(ex);
    }
    catch(ClassNotFoundException ex){
     System.err.println(ex);
    }
  }
}