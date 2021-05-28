//Weighted 4X4 16 tail model
//輸出WeightedTailModel16物件作為檔案

import java.io.*;

public class EX28_6
{
 public static void main(String args[]) throws IOException,ClassNotFoundException
  {
   ObjectOutputStream output = 
      new ObjectOutputStream(new FileOutputStream("EX28_6.dat"));//輸出檔案的stream
   
   WeightedTailModel16 model = new WeightedTailModel16();//創建

   try{
    output.writeObject(model);//輸出object
   }
   catch(IOException ex)
    {
     System.out.println("123"+ex.getMessage());
    }
   catch(Exception ex2)
    {
     System.out.println("Class Not Found Exception");
    }
   output.close();
  }
}