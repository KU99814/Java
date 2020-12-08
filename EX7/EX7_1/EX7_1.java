//使用Triangle class

public class EX7_1
{
 public static void main(String args[])
  {
   //宣告兩個三角形
   Triangle Triangle1 = new Triangle(4,5,6);
   Triangle Triangle2 = new Triangle(1.5,2.5,3.2);

   //使用class裡的method
   System.out.println("The Triangle1's area is "+Triangle1.getArea());//T1面積
   System.out.println("The Triangle1's perimeter is "+Triangle1.getPerimeter());//T1周長
   System.out.println("The Triangle2's area is "+Triangle2.getArea()); //T2面積
   System.out.println("The Triangle2's perimeter is "+Triangle2.getPerimeter());//T2周長
  }
}