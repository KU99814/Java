import java.util.*;

public class House implements Cloneable,Comparable
{
 private int id; //�s��
 private double area; //���n
 private Date whenBuilt; //��ɫسy

 //�غc�l
 public House()
  {
  }

 public House(int id,double area)
  {
   this.id = id;
   this.area = area;
   whenBuilt = new java.util.Date();
  }

 //���o�s��
 public int getId()
  {
   return id;
  }

 //���o���n
 public double getArea()
  {
   return area;
  }

 //���o�سy�ɶ�
 public Date getWhenBuilt()
  {
   return whenBuilt;
  }

 //�]�w�سy�ɶ�
 public void setWhenBuilt(java.util.Date d)
  {
   whenBuilt = d;
  }

 //�ƻs
 public House clone() throws CloneNotSupportedException
  {
   House o = (House)super.clone();
   Date newWhenBuilt = (Date)whenBuilt.clone();
   o.setWhenBuilt(newWhenBuilt);
   return o;
  }

 //���
 public int compareTo(Object o)
  {
   return (int)(getArea()-((House)o).getArea());
  }
}  