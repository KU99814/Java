//Game:Sudoku with recursive

import java.util.Scanner;

public class EX20_34
{
 public static void main(String args[])
  {
   int[][] grid = readAPuzzle();//輸入數獨題目

   if(!isValid(grid))//檢查題目是否有效
    System.out.println("Invalid input");
   else if(search(grid))//搜尋解答
    {
     System.out.println("The solution is found:");//顯示解答
     printGrid(grid);
    }
   else//若沒有解答
    System.out.println("No solution");
  }

 public static int[][] readAPuzzle()
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.println("Enter a Sudoku puzzle:");

   int[][] grid = new int[9][9];//宣告數獨陣列

   //輸入數獨題目   
   for(int i=0;i<9;i++)
    for(int j=0;j<9;j++)
     grid[i][j] = input.nextInt();

   return grid;//回傳
  }

 //取得空格
 public static int[][] getFreeCellList(int[][] grid)
  {
   int numberOfFreeCells = 0;//空格數

   //取得空格數
   for(int i=0;i<9;i++)
    for(int j=0;j<9;j++)
     if(grid[i][j] == 0)
      numberOfFreeCells++;
   
   //宣告空格陣列
   int[][] freeCellList = new int[numberOfFreeCells][2];
   int count = 0;

   //取得空格位置
   for(int i=0;i<9;i++)
    for(int j=0;j<9;j++)
     if(grid[i][j] == 0)
      {
       freeCellList[count][0] = i;
       freeCellList[count++][1] = j;
      }

   return freeCellList;//回傳陣列
  }

 //顯示數獨
 public static void printGrid(int[][] grid)
  {
   //將陣列一個個顯示
   for(int i=0;i<9;i++)
    {
     for(int j=0;j<9;j++)
      System.out.print(grid[i][j]+" ");
     System.out.println();
    }
  }

 //判斷指定格是否有效
 public static boolean isValid(int i,int j,int[][] grid)
  {
   //判斷同一行是否有相同數
   for(int c = 0;c<9;c++)
    if(c != j&& grid[i][c] == grid[i][j])
     return false;
   
   //判斷同一列是否有相同數
   for(int r = 0;r<9;r++)
    if(r != i&& grid[r][j] == grid[i][j])
     return false;

   
   //判斷九宮格內是否有相同數
   for(int r = (i/3)*3;r<(i/3)*3+3;r++)
    for(int c = (j/3)*3;c<(j/3)*3+3;c++)
     if(r != i && c != j && grid[r][c] == grid[i][j])
      return false;
   
   return true;//全部通過回傳結果
  }

 //判斷數獨是否有效
 public static boolean isValid(int[][] grid)
  {
   //用迴圈一個個判斷是否有空格和無效格
   for(int i = 0;i<9;i++)
    for(int j = 0;j<9;j++)
     if(grid[i][j] != 0&&!isValid(i,j,grid))
      return false;
   
   return true;
  }

 //搜尋解答
 public static boolean search(int[][] grid)
  {
   int[][] freeCellList = getFreeCellList(grid);//空白格子
   int num = freeCellList.length;//空格數

   //現在格子位置
   int i = 0;
   int j = 0;

   if(num>0)//如果有空格
    {
     //將位置設在第一個空格
     i = freeCellList[0][0];
     j = freeCellList[0][1];

     //輸入1~9的數字
     for(int k=1;k<=9;k++)
      {
       grid[i][j] = k;
       if(isValid(i,j,grid))//判斷現在數字是否有效
        {
         if(search(grid))//遞迴 直到最後一個空格也填上
          return true;
        }
      }
    }
   else //若無空格 即解答
    return true;

   grid[i][j] = 0;//找不到 設回0

   return false;
  }
}