public class EX11_7 
{
 public static void main(String args[])
  {
   Octagon geoObject = new Octagon(5);              //創造一個Object
   Octagon geoObjectCopy = (Octagon)geoObject.clone();       //複製上一個Object

   displayGeometricObject(geoObject);               //顯示面積與周長

   System.out.print("The two object equal is "+(geoObject.compareTo(geoObjectCopy)==0));  //比較

  }

 //顯示面積
 public static void displayGeometricObject(Octagon object)
  {
   System.out.println("The area of this Octagon is "+object.getArea());
   System.out.println("The perimeter of this octagon is " + object.getPerimeter());
  }
}