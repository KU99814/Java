//Weighted 4X4 16 tail model
//��XWeightedTailModel16����@���ɮ�

import java.io.*;

public class EX28_6
{
 public static void main(String args[]) throws IOException,ClassNotFoundException
  {
   ObjectOutputStream output = 
      new ObjectOutputStream(new FileOutputStream("EX28_6.dat"));//��X�ɮת�stream
   
   WeightedTailModel16 model = new WeightedTailModel16();//�Ы�

   try{
    output.writeObject(model);//��Xobject
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