//矩陣對角線的相加

public class EX6_21
{
 public static void main(String args[])
  {
   int[][] num = {{1,2,4,5},{6,7,8,9},{10,11,12,13},{14,15,16,17}}; //設矩陣

   System.out.print("The sum of the major diagonal is "+sumDiagonal(num)); //顯示結果
  }

 public static int sumDiagonal(int[][] list)
  {
   int sum = 0;

   for(int i=0;i<list.length;i++)  //由左到右得主對角線
    sum+=list[i][i];

   for(int i=0,j=list.length-1;i<list.length;i++,j--) //由右到左得主對角線
    sum+=list[i][j];

   return sum; //回傳
  }
}
     