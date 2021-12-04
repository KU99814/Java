//Display and adding address
//server

import java.io.*;
import java.net.*;
import java.util.*;

public class EX30_6_Server
{
 private static int clientNumber = 0;//�ثeclient��

 private static ArrayList<StudentAddress> list = new ArrayList<StudentAddress>();//���list

 public static void main(String args[])
  {
   try{
    ObjectInputStream inputFromFile = 
      new ObjectInputStream(new FileInputStream("student.dat"));//�qfile���X���

    //���X��Ʃ�Jlist��
    while(true)
    {
     list.add((StudentAddress)(inputFromFile.readObject()));
    }   
   }
   catch(IOException ex){
     System.out.println("get data: "+list.size());
    }
   catch(ClassNotFoundException ex){
     ex.printStackTrace();
    }

   new EX30_6_Server();//�ظmserver
  }

 public EX30_6_Server()
  {
   try{
    ServerSocket serverSocket = new ServerSocket(8000);
    System.out.println("Server started ");
    
    while(true)
     {
      //�p�G����ӥH�W���b�s�u ���~�����socket
      while(clientNumber>1)
       {}
      Socket socket = serverSocket.accept();//���osocket
      new Thread(new HandleAClient(socket)).start();//����task
     }
   }
   catch(IOException ex){
     ex.printStackTrace();
    }  
  }

 //�s�utask
 class HandleAClient implements Runnable
  {
   private Socket socket;
   private ObjectOutputStream outputToFile;//�ǥX��ƨ�file
   private ObjectOutputStream outputToClient;//�ǥX��ƨ�client
   private ObjectInputStream inputFromClient;//�qclient���X���

   //constructor
   public HandleAClient(Socket socket)
    {
     this.socket = socket;
     clientNumber++;     
    }

   //����   
   public void run()
    {
     try{
      //client��X�J
      inputFromClient = new ObjectInputStream(socket.getInputStream());
      outputToClient = new ObjectOutputStream(socket.getOutputStream());

      boolean saveFile = inputFromClient.readBoolean();//�P�_�O�_�s��
        
      //�Y�O�A�N�ɮצs��list��s�J�ɮ�
      if(saveFile)
       {
        outputToFile = new ObjectOutputStream(new FileOutputStream("student.dat"));
        Object studentAddress = inputFromClient.readObject();
        list.add((StudentAddress)studentAddress);
        
        for(int i=0;i<list.size();i++)
         {
          outputToFile.writeObject(list.get(i));
         }
        outputToFile.flush();//�]���i��|�u�s��֨� �n�q�֨�Ū�X
        outputToFile.close();//����
        System.out.println("A new student object is stored");
       }
      else//�Y�_ ����ɮפ��e
       {
        int index;//�n��ܪ��ɮ�index
        boolean goToLast = inputFromClient.readBoolean();//�P�_�O�_��̫�
        
        index = inputFromClient.readInt();//���oindex

        //����index���n�W�L�d��
        if(index>=list.size() || goToLast)
         index = list.size()-1;
        else if(index<0)
         index = 0;       
          
        //�ھ��ɮצ��L��X���e
        if(list.size()>0)
         {
          outputToClient.writeObject(list.get(index));
          outputToClient.flush();
         }
        else
         {
          outputToClient.writeObject(new StudentAddress("","","","",""));
          outputToClient.flush();
         }

                
        outputToClient.writeInt(index);//�^�ǥثeindex
        outputToClient.flush();//��XŪ���֨�
        outputToClient.close();      
       }

      inputFromClient.close();
     }
     catch(ClassNotFoundException ex){
      ex.printStackTrace();
     }
     catch(IOException ex){
      ex.printStackTrace();
     }
     catch(Exception ex){
      ex.printStackTrace();
     }
     finally{
      clientNumber--;//���浲�� client��-1
     }
    }
  }
}