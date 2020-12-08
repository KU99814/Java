//Random character

public class EX3_16
{
 public static void main(String args[])
  {
   //隨機產生字元 Z-A+1是產生範圍
   char chars = (char)('A'+Math.random()*('Z' - 'A' + 1));

   System.out.print(chars);
  }
}
