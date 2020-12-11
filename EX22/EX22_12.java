//sort points in a plane

import java.util.*;

public class EX22_12
{
 public static void main(String args[])
  {
   ArrayList<Point> list = new ArrayList<Point>(); //�s��point

   //���H���y�Ъ��I100��
   for(int i = 0;i<100;i++)
    {
     int x = (int)(Math.random()*100);
     int y = (int)(Math.random()*100);
     list.add(new Point(x,y));
    }

   Collections.sort(list); //�Ƨ�
   System.out.println("The order of x-coordinates is :");
   for(int i = 0;i<list.size();i++)
    System.out.println(list.get(i).toString());

   CompareY compareY = new CompareY(); //���Y�y��

   //�Ƨ�
   for(int i=0;i<list.size();i++)
    {
     for(int j=i+1;j<list.size();j++)
      {
       //swap
       if(compareY.compare(list.get(i),list.get(j))==1)
        {
         Point p1 = list.get(i);
         Point p2 = list.get(j);
         list.set(i,p2);
         list.set(j,p1);
        }
      }
    }

   System.out.println("The order of y-coordinates is :");//��ܶ���

   for(int i = 0;i<list.size();i++)
    System.out.println(list.get(i).toString());
  }
}

class Point implements Comparable //�Iclass
{
 //x y �y��
 int x;
 int y;

 //�غc�l
 public Point()
  {
   x = 0;
   y = 0;
  }

 public Point(int x,int y)
  {
   this.x = x;
   this.y = y;
  }

 //��� �����X�A���Y
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

 public String toString()//��ܦr��
  {
   return "("+x+","+y+")";
  }
}

class CompareY implements Comparator<Point> //���Y class
{
 //�غc�l
 public CompareY()
  {}

 //��� �����Y�y��
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