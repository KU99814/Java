public class Triangle
{
 // 三角形的三邊長
 double side1;
 double side2;
 double side3;

 Triangle() //初始邊長
  {
   side1 = 1;
   side2 = 1;
   side3 = 1;
  }

 Triangle(double newSide1,double newSide2,double newSide3) //指定三邊邊長
  {
   side1 = newSide1;
   side2 = newSide2;
   side3 = newSide3;
  }

 //get 回傳邊長 set 設定新邊長

 double getSide1() 
  {
   return side1;
  }

 void setSide1(double newSide1)
  {
   side1 = newSide1;
  }

 
 double getSide2() 
  {
   return side2;
  }

 void setSide2(double newSide2)
  {
   side2 = newSide2;
  }

 double getSide3() 
  {
   return side3;
  }

 void setSide3(double newSide3)
  {
   side3 = newSide3;
  }

 double getArea() //計算面積 
  {
   double p = (side1+side2+side3)/2;
   double s = p*(p-side1)*(p-side2)*(p-side3);
   
   s = Math.sqrt(s);

   return s;
  }

 double getPerimeter() //計算周長
  {
   return side1+side2+side3;
  }
}