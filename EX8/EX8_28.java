//Common prefix

import java.util.Scanner;

public class EX8_28
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
   
   System.out.print("Enter first string: ");  //��J�Ĥ@�Ӧr
   String s1 = input.next();

   System.out.print("Enter second string: "); //��J�ĤG�Ӧr
   String s2 = input.next();
   
   String s = prefix(s1,s2); //����}�Y��r
   //������G
   if(s.length() < 1)
    System.out.print("The two string not has commom prefix");
   else
    System.out.print("The common is "+s);
  }

 //��prefix
 public static String prefix(String s1,String s2)
  {
   if(s1.length()==0 || s2.length()==0)//�p�G�䤤�@�Ӭ�0 �����Ŧr��
    return "";
   StringBuilder s = new StringBuilder();//�ŧistringbuilder�x�s�r��
   
   for(int i=0;i<s1.length() && i<s2.length();i++)//���Y�}�l���
    {
     if(s1.charAt(i)==s2.charAt(i))
      s.append(s1.charAt(i));
     else
      break;
    }

   return s.toString();//�^��
  }
}