//�ϥ�Triangle class

public class EX7_1
{
 public static void main(String args[])
  {
   //�ŧi��ӤT����
   Triangle Triangle1 = new Triangle(4,5,6);
   Triangle Triangle2 = new Triangle(1.5,2.5,3.2);

   //�ϥ�class�̪�method
   System.out.println("The Triangle1's area is "+Triangle1.getArea());//T1���n
   System.out.println("The Triangle1's perimeter is "+Triangle1.getPerimeter());//T1�P��
   System.out.println("The Triangle2's area is "+Triangle2.getArea()); //T2���n
   System.out.println("The Triangle2's perimeter is "+Triangle2.getPerimeter());//T2�P��
  }
}