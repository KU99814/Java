//幾何abstract class implement comparable

public abstract class GeometricObject implements Comparable<GeometricObject>
{
 private String color = "white"; //顏色
 private boolean filled; //是否填滿
 private java.util.Date dateCreated;  //創造時間

 //建構子
 public GeometricObject()
  {
   dateCreated = new java.util.Date();
  }

 //取得顏色
 public String getColor()
  {
   return color;
  }

 //設定顏色
 public void setColor(String color)
  {
   this.color = color;
  }

 public boolean isFilled()//判斷是否填滿
  {
   return filled;
  }

 public void setFilled(boolean filled)//決定是否填滿
  {
   this.filled = filled;
  }
  
 public java.util.Date getDateCreated()//取得創造時間
  {
   return dateCreated;
  }

 public String toString()//回傳狀態
  {
   return "created on "+ dateCreated + "\ncolor: "+ color +
   " and filled: "+filled+" Area: "+getArea()+"\n";
  }


 //abstract method
 public abstract int compareTo(GeometricObject o);//比較

 public abstract double getArea();//取得面積

 public abstract double getPerimeter();//取得周長
}