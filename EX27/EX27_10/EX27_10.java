//4X4 16 tail model

import java.io.*;

public class EX27_10 
{
 public static void main(String args[])throws IOException,ClassNotFoundException
  {
   ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("EX27_10.dat"));//輸出檔案的stream
   
   TailModel16 model = new TailModel16();//創建

   try{
    output.writeObject(model);//輸出object
   }
   catch(IOException ex)
    {
     System.out.println(ex.getMessage());
    }
   catch(Exception ex2)
    {
     System.out.println("Class Not Found Exception");
    }
   output.close();
  }
}
