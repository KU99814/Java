//�L�X�H���j�g�r���M0~9���

public class EX5_23
{
 public static void main(String args[])
  {
   int count = 0;
 
   for(int i = 0;i<100;i++)//100��
    {
     char ch1 = getRandomUpperCaseLetter(); //�M�w�H���j�g�r
     System.out.print(ch1+" ");
     count++;

     if(count%10==0)
      System.out.println();
    }
   
   for(int i = 0;i<100;i++) //100��
    {
     char ch2 = getRandomDigitalCharacter(); //�H���Ʀr
     System.out.print(ch2+" ");
     count++;

     if(count%10==0)
      System.out.println();
    }
  }

 //�^���H�����r�� �bCH1��CH2����
 public static char getRandomCharacter(char ch1,char ch2)
  {
   return (char)(ch1+Math.random()*(ch2-ch1+1));
  }

 //�^���H���j�g�r����method
 public static char getRandomUpperCaseLetter()
  {
   return getRandomCharacter('A','Z');
  }
 
 //�^���H���Ʀr
 public static char getRandomDigitalCharacter()
  {
   return getRandomCharacter('0','9');
  }
}