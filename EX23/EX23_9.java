//Closest pair of points

import java.util.*;

public class EX23_9
{
 public static void main(String args[])
  {
   //�I�}�C
   double[][] points = {{2,5},{3,9},{6,11},{-9,17},{0,20},
                        {-3,8},{4,12},{4,1},{5,5},{7,14}};
  //���
  System.out.println("The closest pair is "+getClosePair(points));
  }
   
 //�̪��I 
 //�}�C
 public static Pair getClosePair(double[][] points)
  {
   Point[] p = new Point[points.length];//�Ы�point�}�C

   //�Ыذ}�C������
   for(int i=0;i<points.length;i++)
    {
     p[i] = new Point(points[i][0],points[i][1]);
    }

   return getClosePair(p);//�I�soverload
  }

 //�̪��I 
 //Point class
 public static Pair getClosePair(Point[] points)
  {
   Point[] pointY = new Point[points.length];//�ƻs�I�}�C ���@�U��Y�Ƨ�
   
   for(int i=0;i<points.length;i++)
    {
     pointY[i] = new Point(points[i].x,points[i].y);
    }

   Arrays.sort(points);//��x�Ƨ�
   Arrays.sort(pointY);//��Y�Ƨ�

  return distance(points,0,points.length-1,pointY);//�^�ǳ̪�Z����pair
 }

 //�^�ǳ̪�Z����pair ���j
 public static Pair distance(Point[] pointsOrderedOnX,int low,int high,Point[] pointsOrderedOnY)
  {
   if(low >=high)
    return null;
   else if(low+1==high)//�N��u�����I
    {
     return new Pair(pointsOrderedOnX[low],pointsOrderedOnX[high]);
    }

   int mid = (low+high)/2;

   //����̪��
   Pair leftPair = distance(pointsOrderedOnX,low,mid,pointsOrderedOnY);
   
   //�k��̪��
   Pair rightPair = distance(pointsOrderedOnX,mid+1,high,pointsOrderedOnY);

   double d = 0;//����̤p���Z��
   Pair p = null;//�̤p�Z������

   //�P�_�O�_���@�䬰��
   if(leftPair==null && rightPair==null)//����
    {
     d = 0;
     p = null;
    }
   else if(leftPair==null)//����
    {
     d = rightPair.getDistance();
     p = rightPair;
    }
   else if(rightPair==null)//�k��
    {
     d = leftPair.getDistance();
     p = leftPair;
    }
   else//�Ҧ�
    {
     double d1 = leftPair.getDistance();
     double d2 = rightPair.getDistance();

     d = Math.min(d1,d2);//���̤p�Z��
 
     //���̤p�Z���Ҧb���@��
     if(d1>d2)
      p = rightPair;
     else
      p = leftPair;
    }
   
   //��ostripL�MstripR
   List<Point> stripL = new ArrayList<Point>();
   List<Point> stripR = new ArrayList<Point>();

   //���I�y�� x-order
   double mx = pointsOrderedOnX[mid].x;
   double my = pointsOrderedOnX[mid].y;
   
   //����Y�y�ж��� �N�I�[�J��list��
   for(int i=0;i<pointsOrderedOnY.length;i++)
    {
     //���D��K ���X�I�y��
     double px = pointsOrderedOnY[i].x;
     double py = pointsOrderedOnY[i].y;
     
     //�ھ�x�y�Щ�m�I x�Z��<=d
     if(px<=mx && mx-px<=d)
      stripL.add(pointsOrderedOnY[i]);
     else if(px>mx && mx-px<=d)
      stripR.add(pointsOrderedOnY[i]);
    }

   int r = 0;//stripR index

   
   for(int i=0;i<stripL.size();i++)
    {
     Point pL = stripL.get(i);//stripL�����I
     //�ھ�y�y�Ч�t���I
     while(r<stripR.size() && stripR.get(r).y <= pL.y-d)
      r++;

     int r1 = r;
     
     //����Z�� ��X�̤p�Z��     
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

   return p;//�^��
  }

 //���o�I�Z��:double
 public static double distance(double x1,double y1,double x2,double y2)
  {
   double dx = Math.pow(x1-x2,2);
   double dy = Math.pow(y1-y2,2);

   return Math.sqrt(dx+dy);
  }

 //���o�I�Z��:Point
 public static double distance(Point p1,Point p2)
  {
   Pair p = new Pair(p1,p2);//�Ы�Pair
   return p.getDistance(); //��method��Z��
  }
}

//�@��
class Pair
{
 //�t���I
 Point p1;
 Point p2;

 //�غc�l
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

 //��ܸ�T
 public String toString()
  {
   return p1.x+","+p1.y+"  "+p2.x+","+p2.y;
  }

 //�D�X�Z��
 public double getDistance()
  {
   return (Math.sqrt(Math.pow(p1.x-p2.x,2)+Math.pow(p1.y-p2.y,2)));
  }
}

class Point implements Comparable //�Iclass
{
 //�y��
 double x;
 double y;

 //�غc�l
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

 //��ܸ�T
 public String toString()
  {
   return "("+x+","+y+")";
  }
}

class CompareY implements Comparator<Point> //���Y comparator
{
 public CompareY()
  {}

 //�����y �A���x
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