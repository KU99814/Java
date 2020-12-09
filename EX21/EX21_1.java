//Generic Pair class

import java.util.*;

public class EX21_1
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter a Integer: ");
   int num = input.nextInt();//��J�Ʀr

   System.out.print("Enter a string: ");
   String s = input.next();//��J�r��

   Pair<Integer,String> p = new Pair<Integer,String>(num,s);//�s�J�ۻsclass

   //�Hmethod��ܵ��G
   System.out.println("The first is: "+p.getFirst());
   System.out.println("The second is: "+p.getSecond());
   p.<Integer,String>toString();
  } 
}

class Pair<T1,T2>
{
 private T1 e1;//�Ĥ@�ӰѼ�
 private T2 e2; //�ĤG�ӰѼ�

 //�غc�l
 public Pair(T1 e1,T2 e2)
  {
   this.e1 = e1;
   this.e2 = e2;
  }

 //��ܲĤ@�ӰѼ�
 public T1 getFirst()
  {
   return e1;
  }
 
 //��ܲĤG�ӰѼ�
 public T2 getSecond()
  {
   return e2;
  }

 //��ܤ����Ѽ�
 public <T1,T2> void toString()
  {
   System.out.println(e1+" "+e2);
  }
}