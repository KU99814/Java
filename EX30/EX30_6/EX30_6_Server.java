//Display and adding address
//server

import java.io.*;
import java.net.*;
import java.util.*;

public class EX30_6_Server
{
 private static int clientNumber = 0;//目前client數

 private static ArrayList<StudentAddress> list = new ArrayList<StudentAddress>();//資料list

 public static void main(String args[])
  {
   try{
    ObjectInputStream inputFromFile = 
      new ObjectInputStream(new FileInputStream("student.dat"));//從file取出資料

    //取出資料放入list中
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

   new EX30_6_Server();//建置server
  }

 public EX30_6_Server()
  {
   try{
    ServerSocket serverSocket = new ServerSocket(8000);
    System.out.println("Server started ");
    
    while(true)
     {
      //如果有兩個以上正在連線 不繼續獲取socket
      while(clientNumber>1)
       {}
      Socket socket = serverSocket.accept();//取得socket
      new Thread(new HandleAClient(socket)).start();//執行task
     }
   }
   catch(IOException ex){
     ex.printStackTrace();
    }  
  }

 //連線task
 class HandleAClient implements Runnable
  {
   private Socket socket;
   private ObjectOutputStream outputToFile;//傳出資料到file
   private ObjectOutputStream outputToClient;//傳出資料到client
   private ObjectInputStream inputFromClient;//從client取出資料

   //constructor
   public HandleAClient(Socket socket)
    {
     this.socket = socket;
     clientNumber++;     
    }

   //執行   
   public void run()
    {
     try{
      //client輸出入
      inputFromClient = new ObjectInputStream(socket.getInputStream());
      outputToClient = new ObjectOutputStream(socket.getOutputStream());

      boolean saveFile = inputFromClient.readBoolean();//判斷是否存檔
        
      //若是，將檔案存到list後存入檔案
      if(saveFile)
       {
        outputToFile = new ObjectOutputStream(new FileOutputStream("student.dat"));
        Object studentAddress = inputFromClient.readObject();
        list.add((StudentAddress)studentAddress);
        
        for(int i=0;i<list.size();i++)
         {
          outputToFile.writeObject(list.get(i));
         }
        outputToFile.flush();//因為可能會只存到快取 要從快取讀出
        outputToFile.close();//關閉
        System.out.println("A new student object is stored");
       }
      else//若否 顯示檔案內容
       {
        int index;//要顯示的檔案index
        boolean goToLast = inputFromClient.readBoolean();//判斷是否到最後
        
        index = inputFromClient.readInt();//取得index

        //控制index不要超過範圍
        if(index>=list.size() || goToLast)
         index = list.size()-1;
        else if(index<0)
         index = 0;       
          
        //根據檔案有無輸出內容
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

                
        outputToClient.writeInt(index);//回傳目前index
        outputToClient.flush();//放出讀取快取
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
      clientNumber--;//執行結束 client數-1
     }
    }
  }
}