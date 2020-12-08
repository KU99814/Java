//Designing a class for complex numbers

public class EX12_4
{
 public static void main(String args[])
  {
   //宣告兩個複數
   complexNumber c1 = new complexNumber(4,2);
   complexNumber c2 = new complexNumber(2,3);

   //顯示加減乘除
   System.out.println(c1 + " + " + c2 + " = " + c1.add(c2));
   System.out.println(c1 + " - " + c2 + " = " + c1.subtract(c2));
   System.out.println(c1 + " * " + c2 + " = " + c1.multiply(c2));
   System.out.println(c1 + " / " + c2 + " = " + c1.divide(c2));
  }
}
