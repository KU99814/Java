//算出二維陣列的和

public class EX6_20
{
 public static void main(String args[])
  {
   int[][] num = {{1,2,4,5},{6,7,8,9},{10,11,12,13},{14,15,16,17}}; //設陣列

   System.out.print("The sum of the array is "+sum(num)); //顯示
  }

 //陣列所有數加總
 public static int sum(int[][] number)
  {
   int sum = 0;
   for(int i=0;i<number.length;i++) //計算 
    {
     for(int j=0;j<number[i].length;j++)
      sum+=number[i][j];
    }
   
   return sum;
  }
}