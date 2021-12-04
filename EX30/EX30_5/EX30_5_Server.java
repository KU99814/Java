//Creating a stock ticker in an client
//Server

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class EX30_5_Server
{
 public static void main(String args[])
  {
   new EX30_5_Server();//�ŧiserver
  }

 public EX30_5_Server()
  {
   try{
    System.out.println("Start server..."); 
   
    ServerSocket serverSocket = new ServerSocket(8000);//server
    
    while(true)
     {
      Socket socket = serverSocket.accept();//client socket
      
      //Ū���ɮ�
      Scanner inputFromFile = new Scanner(new FileInputStream("EX30_5.txt"));
      
      //�ǰe�ɮר�client
      DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

      //�̧�Ū���ǰe
      for(int i=0;i<5;i++)
       {
        outputToClient.writeUTF(inputFromFile.nextLine());
        outputToClient.writeUTF(inputFromFile.nextLine());
        outputToClient.writeDouble(Double.parseDouble(inputFromFile.nextLine()));
        outputToClient.writeDouble(Double.parseDouble(inputFromFile.nextLine()));
       }
      
      //���������ɮ�
      inputFromFile.close();
      outputToClient.close();
     }
   }
   catch(IOException ex){
    ex.printStackTrace();
   }   
  }
}