public class EX11_7 
{
 public static void main(String args[])
  {
   Octagon geoObject = new Octagon(5);              //�гy�@��Object
   Octagon geoObjectCopy = (Octagon)geoObject.clone();       //�ƻs�W�@��Object

   displayGeometricObject(geoObject);               //��ܭ��n�P�P��

   System.out.print("The two object equal is "+(geoObject.compareTo(geoObjectCopy)==0));  //���

  }

 //��ܭ��n
 public static void displayGeometricObject(Octagon object)
  {
   System.out.println("The area of this Octagon is "+object.getArea());
   System.out.println("The perimeter of this octagon is " + object.getPerimeter());
  }
}