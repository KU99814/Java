//shuffling letters in a string

import java.util.Scanner;

public class EX8_11
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter a string: "); //��J�r��
   String s = input.nextLine();   

   System.out.print("The shuffling letter is "+shuffle(s)); //���
  }

 public static String shuffle(String s) //shuffle
  {
   StringBuilder newS = new StringBuilder(s); //�ŧiStringBuilder
   String reS = ""; //�^�Ǧr��
   while(newS.length()>0)//�r����פj��0�N�~��
    {
     int r = (int)(Math.random()*newS.length());//�H�����1��index
     reS += newS.charAt(r);//���X��index�r��
     newS.deleteCharAt(r);//�R����index�r��
    }
   
   return reS; //�^��
  }
}