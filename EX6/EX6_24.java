//矩陣相加

public class EX6_24
{
 public static void main(String args[])
  {
   int[][] matrix1 = {
     {1,2,3},
     {4,5,6},
     {7,8,9}};
   
   int[][] matrix2 = {
     {11,12,13},
     {14,15,16},
     {17,18,19}}; //設矩陣1，2
   
   int[][] sum = addmatrix(matrix1,matrix2);//矩陣相加

   System.out.println("The sum is "); //顯示
   for(int i=0;i<matrix1.length;i++)
    {
     for(int j=0;j<matrix1[i].length;j++)
      System.out.print(sum[i][j]+" ");
     System.out.println();
    }
  }

 //矩陣相加 method
 public static int[][] addmatrix(int[][] a,int[][] b)
  {
   int[][] sum = new int[a.length][a[0].length];//相加矩陣
   
   for(int i=0;i<a.length;i++) //相加
    {
     for(int j=0;j<a[i].length;j++)
      sum[i][j] = a[i][j] + b[i][j];
    }
   
   return sum;
  }
}
