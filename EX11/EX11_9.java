//Finding the largest matching object between array

public class EX11_9
{
 public static void main(String args[])
  {
   //ㄢInteger class 皚
   Integer[] a = new Integer[10];
   Integer[] b = new Integer[10];

   for(int i=0;i<10;i++)
    {
     a[i] =  i+1;//1~10
     b[i] = (int)(Math.random()*101);//繦诀0~100
    }

   //耞单计い程计 璝礚 肚-1
   System.out.print("The largest integer is "+equals(a,b));
  }

 //耞单计い程
 public static Object equals(Comparable[] a,Comparable[] b)
  {
   Comparable max = -1;//肚

   for(int i=0;i<10;i++)
    {
     for(int j=0;j<10;j++)
      {
       if(a[i].compareTo(b[j]) == 0)//璝Τ单计
        {
         if(a[i].compareTo(max) > 0)//璝肚
          max = a[i];//
        }
      }
    }
   
   return max;
  }
}