//Converting a lowercase letter to an uppercase

public class EX2_7
{
 public static void main(String args[])
  {
   int lowercase1 = 'h'; //要轉換的字元

   int offset = 'a' - 'A'; //小寫到大寫的差距(大寫在小寫之前)
   char uppercase = (char)(lowercase1 - offset); //減去差距

   System.out.print("The uppercase is "+uppercase); //輸出結果
  }
}   