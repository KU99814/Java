//Computing e

public class EX4_26
{
 public static void main(String args[])
  {
   double e = 1;
   double item = 1;//分母
 
   //計算自然指數e = 1+1/1!+1/2!+1/3!+...+1/i!  
   for(int i = 10000;i<=100000;i+=10000)
    {
     for(int j = 1;j<=i;j++)
     {
      item*=j;
      e += (1/item);
     }
     System.out.println("e ="+e+" i = "+i);
     e = 1;
     item = 1;
    }
  }
}