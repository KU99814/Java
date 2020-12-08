//Summing the perimeters of geometric objects

public class EX11_8
{
 public static void main(String args[])
  {
   //宣告圖形
   GeometricObject[] g = {new Circle(5),
                          new Rectangle(20,30),
                          new Rectangle(5,5)};

   //顯示周長加總
   System.out.print("The sum of all geometric's perimeter are "+getSumOfPerimeter(g));
  }

 //周長加總
 public static double getSumOfPerimeter(GeometricObject[] g)
  {
   double sum = 0;
   for(int i=0;i<g.length;i++)
    sum += g[i].getPerimeter();
   return sum;
  }    
}
