//Generic Maximum element in an two-dimensional array

import java.util.*;

public class EX21_6
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入
 
   System.out.print("Enter the number of row: ");
   int row = input.nextInt();//輸入陣列列長度

   System.out.print("Enter the number of column: ");
   int column = input.nextInt();//輸入陣列行長度

   Integer[][] array = new Integer[row][column];//宣告陣列
   System.out.print("Enter numbers: ");//輸入陣列
   for(int i=0;i<row;i++)
    for(int j=0;j<column;j++)
    array[i][j] = input.nextInt();
   
   double max = EX21_6.<Integer>maxRowSum(array);//將每一列各自加總 求最大值
   System.out.println("The max number in array is "+max);//顯示
  }

 public static <E extends Number> double maxRowSum(E[][] list)
  {
   double max = 0;//預設最大值

   for(int i=0;i<list[0].length;i++)//第一列加總
    max+=list[0][i].doubleValue();
   
   for(int i=1;i<list.length;i++)
    {
     //將之後每一列加總
     double currentRow = 0;
     for(int j=0;j<list[i].length;j++)
      currentRow += list[i][j].doubleValue();

     //比較最大值
     if(max < currentRow)
      max = currentRow;
    }

   return max;
  }
}  