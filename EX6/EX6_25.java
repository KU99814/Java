//矩陣相減

public class EX6_25
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
     {17,18,19}}; //設矩陣1、2
   
   int[][] substract = substractmatrix(matrix1,matrix2);
   System.out.println("The substraction is "); //顯示
   for(int i=0;i<matrix1.length;i++)
    {
     for(int j=0;j<matrix1[i].length;j++)
      System.out.print(substract[i][j]+" ");
     System.out.println();
    }
  }

 public static int[][] substractmatrix(int[][] a,int[][] b)
  {
   int[][] substract = new int[a.length][a[0].length];
   
   for(int i=0;i<a.length;i++) //相減
    {
     for(int j=0;j<a[i].length;j++)
      substract[i][j] = a[i][j] - b[i][j];
    }
   
   return substract;
  }
}