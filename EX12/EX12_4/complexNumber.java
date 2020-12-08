public class complexNumber
{
 private int realPart;//���
 private int imaginaryPart;//���

 //�غc�l
 public complexNumber()
  {
   this(1,1);
  }

 public complexNumber(int realPart,int imaginaryPart)
  {
   this.realPart = realPart;
   this.imaginaryPart = imaginaryPart;
  }

 //���o���
 public int getImaginaryPart()
  {
   return imaginaryPart;
  }

 //���o���
 public int getRealPart()
  {
   return realPart;
  }

 //�[�k
 public complexNumber add(complexNumber c)
  {
   //��Ƭۥ[ ��Ƭۥ[
   int r = realPart + c.getRealPart();
   int i = imaginaryPart + c.getImaginaryPart();
   
   return new complexNumber(r,i);
  }

 //��k
 public complexNumber subtract(complexNumber c)
  {
   //��Ƭ۴� ��Ƭ۴�
   int r = realPart - c.getRealPart();
   int i = imaginaryPart - c.getImaginaryPart();
   
   return new complexNumber(r,i);
  }

 //���k
 public complexNumber multiply(complexNumber c)
  {
   int r = (realPart * c.getRealPart()) - (imaginaryPart * c.getImaginaryPart());
   int i = (realPart * c.getImaginaryPart()) + (imaginaryPart * c.getRealPart());
   
   return new complexNumber(r,i);
  }

 //��
 public complexNumber divide(complexNumber c)
  {
   int r = (realPart * c.getRealPart()) + (imaginaryPart * c.getImaginaryPart());
   r /= (int)(Math.pow(c.getRealPart(),2) + Math.pow(c.getImaginaryPart(),2));
   int i =  (imaginaryPart * c.getRealPart()) - (realPart * c.getImaginaryPart());
   i /= (int)(Math.pow(c.getRealPart(),2) + Math.pow(c.getImaginaryPart(),2));
   
   return new complexNumber(r,i);
  }

 //���
 public String toString()
  {
   return "("+realPart + " + " + imaginaryPart + "i)";
  }
}