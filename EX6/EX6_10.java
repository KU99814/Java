//т程计皚ま

public class EX6_10
{
 public static void main(String args[])
  {
   int[] num = {1,2,4,5,10,100,2,-22}; //砞皚
   
   System.out.print("The smallest element's index is "+min(num)); //陪ボ
  }

 public static int min(int... num) //笲衡
  {
   int mIndex = 0;
   int m = num[0];
   //ゑ耕程
   for(int i=1;i<num.length;i++)
    {
     if(num[i]<m)
      {
       m = num[i];
       mIndex = i;
      }
    }

   return mIndex; //肚程ま
  }
}