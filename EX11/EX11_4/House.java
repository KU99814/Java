import java.util.*;

public class House implements Cloneable,Comparable
{
 private int id; //編號
 private double area; //面積
 private Date whenBuilt; //何時建造

 //建構子
 public House()
  {
  }

 public House(int id,double area)
  {
   this.id = id;
   this.area = area;
   whenBuilt = new java.util.Date();
  }

 //取得編號
 public int getId()
  {
   return id;
  }

 //取得面積
 public double getArea()
  {
   return area;
  }

 //取得建造時間
 public Date getWhenBuilt()
  {
   return whenBuilt;
  }

 //設定建造時間
 public void setWhenBuilt(java.util.Date d)
  {
   whenBuilt = d;
  }

 //複製
 public House clone() throws CloneNotSupportedException
  {
   House o = (House)super.clone();
   Date newWhenBuilt = (Date)whenBuilt.clone();
   o.setWhenBuilt(newWhenBuilt);
   return o;
  }

 //比較
 public int compareTo(Object o)
  {
   return (int)(getArea()-((House)o).getArea());
  }
}  