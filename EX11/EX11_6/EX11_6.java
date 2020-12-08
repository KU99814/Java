//Enabling Rectangle comparable

public class EX11_6
{
 public static void main(String args[])
  {
   //宣告長方形
   Rectangle r1 = new Rectangle(10,20);
   Rectangle r2 = new Rectangle(5,40);

   //判斷大小
   System.out.print("The two Rectangle is equal? " + r1.equals(r2));
  }
}