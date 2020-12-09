//Generic Pair class

import java.util.*;

public class EX21_1
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//块

   System.out.print("Enter a Integer: ");
   int num = input.nextInt();//块计

   System.out.print("Enter a string: ");
   String s = input.next();//块﹃

   Pair<Integer,String> p = new Pair<Integer,String>(num,s);//籹class

   //method陪ボ挡狦
   System.out.println("The first is: "+p.getFirst());
   System.out.println("The second is: "+p.getSecond());
   p.<Integer,String>toString();
  } 
}

class Pair<T1,T2>
{
 private T1 e1;//材把计
 private T2 e2; //材把计

 //篶
 public Pair(T1 e1,T2 e2)
  {
   this.e1 = e1;
   this.e2 = e2;
  }

 //陪ボ材把计
 public T1 getFirst()
  {
   return e1;
  }
 
 //陪ボ材把计
 public T2 getSecond()
  {
   return e2;
  }

 //陪ボず场把计
 public <T1,T2> void toString()
  {
   System.out.println(e1+" "+e2);
  }
}