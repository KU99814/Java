//Geometry: the Rectangle2D class

public class EX9_12
{
 public static void main(String args[])
  {
   Rectangle2D r1 = new Rectangle2D(2,2,5.5,4.9);
   
   System.out.println("The area is "+r1.getArea()); //��ܭ��n
   System.out.println("The perimeter is "+r1.getPerimeter()); //��ܩP��
   System.out.println("Is dot (3,3) contained in r1? "+r1.contains(3,3)); //��ܬO�_�]�t�o�I
   System.out.println("Is rectangle (4,5,10.5,3.2) contained in r1? "+
                       r1.contains(new Rectangle2D(4,5,10.5,3.2))); //��ܬO�_�]�t�o�x��
   System.out.println("Is rectangle (3,5,2.3,5.4) contained in r1? "+
                        r1.overlaps(new Rectangle2D(3,5,2.3,5.4))); //��ܬO�_�P�o�x�άۥ�
  }
}

class Rectangle2D
{
 private double x,y; //���߮y��
 private double width,height; //�e�P��

 public Rectangle2D()
  {
   this(0,0,1,1);
  }

 public Rectangle2D(double x,double y,double width,double height)
  {
   this.x = x;
   this.y = y;
   this.width = width;
   this.height = height;
  }

 //���o�y��
 public void setX(double x) 
  {
   this.x = x;
  }

 public void setY(double y)
  {
   this.y = y;
  }

 //���o���e
 public void setWidth(double width)
  {
   this.width = width;
  }

 public void setHeight(double height)
  {
   this.height = height;
  }

 //�^�Ǯy��
 public double getX()
  {
   return x;
  }

 public double getY()
  {
   return y;
  }

 //�^�Ǫ��e
 public double getWidth()
  {
   return width;
  }

 public double getHeight()
  {
   return height;
  }

 public double getArea() //�^�ǭ��n
  {
   return width * height;
  }

 public double getPerimeter() //�^�ǩP��
  {
   return 2*(width+height);
  }

 public boolean contains(double x1,double y1) //���ҬO�_�]�t(�I)
  {
   double dx1 = x - width/2;
   double dy1 = y - height/2;
   double dx2 = x + width/2;
   double dy2 = y + height/2;
   
   //�H����Υ|�IX Y ���̤j/�p�� �ˬd�I�O�_���b�o�d��
   return (x1 >=dx1 && x1 <= dx2 && y1 >= dy1 && y1 <= dy2);
  }

 public boolean contains(Rectangle2D r)//���ҬO�_�]�t(�����)
  {
   //�P�_�Q�]�t����Υ|�I�O�_���Q�]�t
   boolean bx = (x-width/2 <= r.getX()-r.getWidth()/2 && x+width/2 >= r.getX()+r.getWidth()/2);
   boolean by = (y-height/2 <= r.getY()-r.getHeight()/2 && y+height/2 >= r.getY()+r.getHeight()/2);

   return (bx && by);
  }

 public boolean overlaps(Rectangle2D r) //���ҬO�_�ۥ�
  {
   //���H��Ӫ���Ϊ��e��X���ۥ�̤p�Z��
   double Hpow = Math.pow(height+r.getHeight(),2);
   double Wpow = Math.pow(width-r.getWidth(),2);
   double min = Math.sqrt(Hpow+Wpow);
   
   //�p��⤤�߶Z��
   double dx = Math.pow(x-r.getX(),2);
   double dy = Math.pow(y-r.getY(),2);
   double distance = Math.sqrt(dx+dy);
   //�P�_�Z���O�_�Ӥj�H�άO�_���ۥ]�t
   return ( distance<min && !contains(r) && !r.contains(new Rectangle2D(x,y,width,height)));
  }
}