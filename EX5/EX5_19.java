//�DISBN

import java.util.Scanner;

public class EX5_19
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J
   
   System.out.print("Enter a ISBN number: "); //��JISBN�X���E��
   int ISBN = input.nextInt();

   System.out.print("The ISBN is: "+getISBN(ISBN));//���
  }

 public static String getISBN(int isbnFirstNineDigits)
  {
   String ISBN = "";
   int sum = 0;

   if(isbnFirstNineDigits /(int)(Math.pow(10,8)) == 0) //�p�G�̫e���O�s �N���[�s
    {
     ISBN += "0";
     ISBN += isbnFirstNineDigits;
    }
   else //�_�h�����[
    {
     ISBN += isbnFirstNineDigits;
    }
 
   for(int i = 9;i>=1;i--) //�B��
    {
     sum += (isbnFirstNineDigits % 10)*i;
     isbnFirstNineDigits /= 10;
    }

   sum %= 11;

   if(sum == 10) //�p�G�l�ƬO�Q �[X
    ISBN += 'X';
   else
    ISBN += sum;

   return ISBN;
  }
}