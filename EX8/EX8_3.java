//check Palindrome ignore case

import java.util.Scanner;

public class EX8_3
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //«Å§i¿é¤J

   System.out.print("Enter a string: "); //¿é¤J¦r¦ê
   String s = input.nextLine();

   String reverseS = reverse(s); //ÄA­Ë

   if(s.equalsIgnoreCase(reverseS)) //¥H©¿²¤¤j¤p¼gªº¤è¦¡°»´ú
    System.out.println(s + " is a palindrome");
   else
    System.out.println(s + " is not a palindrome");
  }

 public static String reverse(String s) //ÄA­Ë¦r¦ê
  {
   int length = s.length() - 1;
   String re = "";

   for(int i = length;i>=0;i--)
    {
     re += s.charAt(i);     
    }
 
   return re;
  }
}     