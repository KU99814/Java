//Pattern mathching
//T(n) = O(n^2)

import java.util.*;

public class EX23_4
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�t�ο�J

   System.out.print("Enter a text: ");//��J�d��峹
   String text = input.nextLine();
   
   System.out.print("Enter a string: ");//��J�d��r��
   String s = input.next();
   
   int index = match(text,s);//�d��

   //�����G���
   if(index<0)//�Y�L
    System.out.println("no match");
   else//�Y��
    System.out.println("match in "+index);
  }

 //�ǰt�r��
 public static int match(String text,String s)
  {
   for(int i=0;i<text.length();i++)
    {
     int k=0;//���ŦX�r������
     for(int j = i;j<text.length();j++)
      {
       if(text.charAt(j)==s.charAt(k))//�Y�r���ŦX
        k++;//����+1
       else//�Y���� ���X
        break;
       if(k == s.length())//�Y�w�F���� �]���X
        break;
      }
     
     if(k == s.length())//�Y���ײŦX �^�ǰ_�lindex
      return i;
    }
 
   return -1;//�Y�S���ŦX -1
  }
}