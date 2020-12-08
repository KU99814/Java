//印出隨機大寫字母和0~9位數

public class EX5_23
{
 public static void main(String args[])
  {
   int count = 0;
 
   for(int i = 0;i<100;i++)//100個
    {
     char ch1 = getRandomUpperCaseLetter(); //決定隨機大寫字
     System.out.print(ch1+" ");
     count++;

     if(count%10==0)
      System.out.println();
    }
   
   for(int i = 0;i<100;i++) //100個
    {
     char ch2 = getRandomDigitalCharacter(); //隨機數字
     System.out.print(ch2+" ");
     count++;

     if(count%10==0)
      System.out.println();
    }
  }

 //回傳隨機的字母 在CH1到CH2之間
 public static char getRandomCharacter(char ch1,char ch2)
  {
   return (char)(ch1+Math.random()*(ch2-ch1+1));
  }

 //回傳隨機大寫字母的method
 public static char getRandomUpperCaseLetter()
  {
   return getRandomCharacter('A','Z');
  }
 
 //回傳隨機數字
 public static char getRandomDigitalCharacter()
  {
   return getRandomCharacter('0','9');
  }
}