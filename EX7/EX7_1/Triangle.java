public class Triangle
{
 // �T���Ϊ��T���
 double side1;
 double side2;
 double side3;

 Triangle() //��l���
  {
   side1 = 1;
   side2 = 1;
   side3 = 1;
  }

 Triangle(double newSide1,double newSide2,double newSide3) //���w�T�����
  {
   side1 = newSide1;
   side2 = newSide2;
   side3 = newSide3;
  }

 //get �^����� set �]�w�s���

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

 double getArea() //�p�⭱�n 
  {
   double p = (side1+side2+side3)/2;
   double s = p*(p-side1)*(p-side2)*(p-side3);
   
   s = Math.sqrt(s);

   return s;
  }

 double getPerimeter() //�p��P��
  {
   return side1+side2+side3;
  }
}