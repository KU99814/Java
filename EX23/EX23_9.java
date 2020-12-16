//Closest pair of points

import java.util.*;

public class EX23_9
{
 public static void main(String args[])
  {
   //點陣列
   double[][] points = {{2,5},{3,9},{6,11},{-9,17},{0,20},
                        {-3,8},{4,12},{4,1},{5,5},{7,14}};
  //顯示
  System.out.println("The closest pair is "+getClosePair(points));
  }
   
 //最近點 
 //陣列
 public static Pair getClosePair(double[][] points)
  {
   Point[] p = new Point[points.length];//創建point陣列

   //創建陣列內物件
   for(int i=0;i<points.length;i++)
    {
     p[i] = new Point(points[i][0],points[i][1]);
    }

   return getClosePair(p);//呼叫overload
  }

 //最近點 
 //Point class
 public static Pair getClosePair(Point[] points)
  {
   Point[] pointY = new Point[points.length];//複製點陣列 等一下按Y排序
   
   for(int i=0;i<points.length;i++)
    {
     pointY[i] = new Point(points[i].x,points[i].y);
    }

   Arrays.sort(points);//按x排序
   Arrays.sort(pointY);//按Y排序

  return distance(points,0,points.length-1,pointY);//回傳最近距離的pair
 }

 //回傳最近距離的pair 遞迴
 public static Pair distance(Point[] pointsOrderedOnX,int low,int high,Point[] pointsOrderedOnY)
  {
   if(low >=high)
    return null;
   else if(low+1==high)//代表只有兩點
    {
     return new Pair(pointsOrderedOnX[low],pointsOrderedOnX[high]);
    }

   int mid = (low+high)/2;

   //左邊最近對
   Pair leftPair = distance(pointsOrderedOnX,low,mid,pointsOrderedOnY);
   
   //右邊最近對
   Pair rightPair = distance(pointsOrderedOnX,mid+1,high,pointsOrderedOnY);

   double d = 0;//兩邊最小的距離
   Pair p = null;//最小距離的邊

   //判斷是否有一邊為空
   if(leftPair==null && rightPair==null)//都空
    {
     d = 0;
     p = null;
    }
   else if(leftPair==null)//左空
    {
     d = rightPair.getDistance();
     p = rightPair;
    }
   else if(rightPair==null)//右空
    {
     d = leftPair.getDistance();
     p = leftPair;
    }
   else//皆有
    {
     double d1 = leftPair.getDistance();
     double d2 = rightPair.getDistance();

     d = Math.min(d1,d2);//取最小距離
 
     //取最小距離所在的一邊
     if(d1>d2)
      p = rightPair;
     else
      p = leftPair;
    }
   
   //獲得stripL和stripR
   List<Point> stripL = new ArrayList<Point>();
   List<Point> stripR = new ArrayList<Point>();

   //中點座標 x-order
   double mx = pointsOrderedOnX[mid].x;
   double my = pointsOrderedOnX[mid].y;
   
   //按照Y座標順序 將點加入兩list中
   for(int i=0;i<pointsOrderedOnY.length;i++)
    {
     //為求方便 取出點座標
     double px = pointsOrderedOnY[i].x;
     double py = pointsOrderedOnY[i].y;
     
     //根據x座標放置點 x距離<=d
     if(px<=mx && mx-px<=d)
      stripL.add(pointsOrderedOnY[i]);
     else if(px>mx && mx-px<=d)
      stripR.add(pointsOrderedOnY[i]);
    }

   int r = 0;//stripR index

   
   for(int i=0;i<stripL.size();i++)
    {
     Point pL = stripL.get(i);//stripL中的點
     //根據y座標找配對點
     while(r<stripR.size() && stripR.get(r).y <= pL.y-d)
      r++;

     int r1 = r;
     
     //比較距離 找出最小距離     
     while(r1 < stripR.size() && Math.abs(stripR.get(r1).y - pL.y)<=d)
      {
       if(distance(pL,stripR.get(r1)) < d)
        {
         d = distance(pL,stripR.get(r1));
         p.p1 = pL;
         p.p2 = stripR.get(r1);
        
        }
        r1++;
      }
    }

   return p;//回傳
  }

 //取得點距離:double
 public static double distance(double x1,double y1,double x2,double y2)
  {
   double dx = Math.pow(x1-x2,2);
   double dy = Math.pow(y1-y2,2);

   return Math.sqrt(dx+dy);
  }

 //取得點距離:Point
 public static double distance(Point p1,Point p2)
  {
   Pair p = new Pair(p1,p2);//創建Pair
   return p.getDistance(); //用method找距離
  }
}

//一對
class Pair
{
 //配對點
 Point p1;
 Point p2;

 //建構子
 public Pair()
  {
   p1 = new Point();
   p2 = new Point();
  }

 public Pair(Point p1,Point p2)
  {
   this.p1 = p1;
   this.p2 = p2;
  }

 public Pair(double x1,double y1,double x2,double y2)
  {
   p1 = new Point(x1,y1);
   p2 = new Point(x2,y2);
  }

 //顯示資訊
 public String toString()
  {
   return p1.x+","+p1.y+"  "+p2.x+","+p2.y;
  }

 //求出距離
 public double getDistance()
  {
   return (Math.sqrt(Math.pow(p1.x-p2.x,2)+Math.pow(p1.y-p2.y,2)));
  }
}

class Point implements Comparable //點class
{
 //座標
 double x;
 double y;

 //建構子
 public Point()
  {
   x = 0;
   y = 0;
  }

 public Point(double x,double y)
  {
   this.x = x;
   this.y = y;
  }

 //override
 public int compareTo(Object o)
  {
   if(x>((Point)o).x)
    return 1;
   else if(x<((Point)o).x)
    return -1;
   else
    {
     if(y>((Point)o).y)
      return 1;
     else if(y<((Point)o).y)
      return -1;
     else
      return 0;
    }
  }

 //顯示資訊
 public String toString()
  {
   return "("+x+","+y+")";
  }
}

class CompareY implements Comparator<Point> //比較Y comparator
{
 public CompareY()
  {}

 //先比較y 再比較x
 public int compare(Point o1,Point o2)
  {
   if(o1.y>o2.y)
    return 1;
   else if(o1.y<o2.y)
    return -1;
   else
    {
     if(o1.x>o2.x)
      return 1;
     else if(o1.x<o2.x)
      return -1;
     else
      return 0;
    }
  }
}