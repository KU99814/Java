import java.util.Scanner;

public class EX2_8
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
   
   System.out.print("Enter a number of ASCll:");
   int asc = input.nextInt(); //��JASCII�X

   char ASCll = (char)asc; //�ഫ���r��
  
   System.out.print("The ASCll code is "+ASCll); //��X
  }
}