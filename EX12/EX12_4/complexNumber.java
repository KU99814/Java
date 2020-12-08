public class complexNumber
{
 private int realPart;//實數
 private int imaginaryPart;//虛數

 //建構子
 public complexNumber()
  {
   this(1,1);
  }

 public complexNumber(int realPart,int imaginaryPart)
  {
   this.realPart = realPart;
   this.imaginaryPart = imaginaryPart;
  }

 //取得虛數
 public int getImaginaryPart()
  {
   return imaginaryPart;
  }

 //取得實數
 public int getRealPart()
  {
   return realPart;
  }

 //加法
 public complexNumber add(complexNumber c)
  {
   //實數相加 虛數相加
   int r = realPart + c.getRealPart();
   int i = imaginaryPart + c.getImaginaryPart();
   
   return new complexNumber(r,i);
  }

 //減法
 public complexNumber subtract(complexNumber c)
  {
   //實數相減 虛數相減
   int r = realPart - c.getRealPart();
   int i = imaginaryPart - c.getImaginaryPart();
   
   return new complexNumber(r,i);
  }

 //乘法
 public complexNumber multiply(complexNumber c)
  {
   int r = (realPart * c.getRealPart()) - (imaginaryPart * c.getImaginaryPart());
   int i = (realPart * c.getImaginaryPart()) + (imaginaryPart * c.getRealPart());
   
   return new complexNumber(r,i);
  }

 //除
 public complexNumber divide(complexNumber c)
  {
   int r = (realPart * c.getRealPart()) + (imaginaryPart * c.getImaginaryPart());
   r /= (int)(Math.pow(c.getRealPart(),2) + Math.pow(c.getImaginaryPart(),2));
   int i =  (imaginaryPart * c.getRealPart()) - (realPart * c.getImaginaryPart());
   i /= (int)(Math.pow(c.getRealPart(),2) + Math.pow(c.getImaginaryPart(),2));
   
   return new complexNumber(r,i);
  }

 //顯示
 public String toString()
  {
   return "("+realPart + " + " + imaginaryPart + "i)";
  }
}