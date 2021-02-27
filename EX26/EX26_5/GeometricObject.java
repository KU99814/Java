//�X��abstract class implement comparable

public abstract class GeometricObject implements Comparable<GeometricObject>
{
 private String color = "white"; //�C��
 private boolean filled; //�O�_��
 private java.util.Date dateCreated;  //�гy�ɶ�

 //�غc�l
 public GeometricObject()
  {
   dateCreated = new java.util.Date();
  }

 //���o�C��
 public String getColor()
  {
   return color;
  }

 //�]�w�C��
 public void setColor(String color)
  {
   this.color = color;
  }

 public boolean isFilled()//�P�_�O�_��
  {
   return filled;
  }

 public void setFilled(boolean filled)//�M�w�O�_��
  {
   this.filled = filled;
  }
  
 public java.util.Date getDateCreated()//���o�гy�ɶ�
  {
   return dateCreated;
  }

 public String toString()//�^�Ǫ��A
  {
   return "created on "+ dateCreated + "\ncolor: "+ color +
   " and filled: "+filled+" Area: "+getArea()+"\n";
  }


 //abstract method
 public abstract int compareTo(GeometricObject o);//���

 public abstract double getArea();//���o���n

 public abstract double getPerimeter();//���o�P��
}