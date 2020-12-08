//Displaying the ACSII character table

public class EX4_14
{
 public static void main(String args[])
  {
   int count = 0; //計算個數以換排
   for(int i = '!';i <= '~';i++) //以迴圈依序輸出字元
    {
     if(count > 9)
      {
       System.out.print("\n");
       count = 0;
      }
     char c = (char)(i); 
  
     System.out.print(c+" ");
     count++;
    }
  }
}