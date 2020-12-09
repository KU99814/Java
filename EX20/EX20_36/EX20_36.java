//Game:Sudoku with recursive no only solution

import java.util.Scanner;

public class EX20_36
{
 static int count = 0;//解答數
 public static void main(String args[])
  {
   int[][] grid = readAPuzzle();//輸入數獨題目

   if(!isValid(grid))//判斷題目是否錯誤
    System.out.println("Invalid input");
   else 
    {
     int[][] freeCellList = getFreeCellList(grid);//取得空格
     search(grid,freeCellList,0);//搜尋解答
    }

   if(count == 0)//如果解答數為零
    System.out.println("No solution");
  }

 //輸入數獨題目
 public static int[][] readAPuzzle()
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.println("Enter a Sudoku puzzle:");

   int[][] grid = new int[9][9];//宣告數獨陣列

   for(int i=0;i<9;i++)
    for(int j=0;j<9;j++)
     grid[i][j] = input.nextInt();//輸入

   return grid;//回傳
  }
 
 //取得空白格位
 public static int[][] getFreeCellList(int[][] grid)
  {
   int numberOfFreeCells = 0;//空白格子數
   int i=0;
   int j=0;

   //計算空白格數
   for(i=0;i<9;i++)
    for(j=0;j<9;j++)
     if(grid[i][j] ==0)
       numberOfFreeCells++;
         
     //根據格數宣告陣列
     int[][] freeCells = new int[numberOfFreeCells][2];
     int c = 0;//現在第幾個格子

    for(i=0;i<9;i++)
     for(j=0;j<9;j++)
      {
       if(grid[i][j] ==0)
        {
         freeCells[c][0] = i;
         freeCells[c++][1] = j;
        }
      }
   
   return freeCells;//回傳
  }

 //顯示數獨陣列
 public static void printGrid(int[][] grid)
  {
   for(int i=0;i<9;i++)
    {
     for(int j=0;j<9;j++)
      System.out.print(grid[i][j]+" ");
     System.out.println();
    }
  }

 //判斷格子內數字是否有效
 public static boolean isValid(int i,int j,int[][] grid)
  {
   for(int c = 0;c<9;c++)//判斷直行
    if(c != j&& grid[i][c] == grid[i][j])
     return false;
   
   //判斷橫列
   for(int r = 0;r<9;r++)
    if(r != i&& grid[r][j] == grid[i][j])
     return false;

   //判斷對角
   for(int r = (i/3)*3;r<(i/3)*3+3;r++)
    for(int c = (j/3)*3;c<(j/3)*3+3;c++)
     if(r != i && c != j && grid[r][c] == grid[i][j])
      return false;
   
   return true;
  }

 //判斷數獨整體是否有效
 public static boolean isValid(int[][] grid)
  {
   for(int i = 0;i<9;i++)
    for(int j = 0;j<9;j++)
     if(grid[i][j] != 0&&!isValid(i,j,grid))
      return false;
   
   return true;
  }

 public static boolean check(int[][] grid)
  {
   for(int i = 0;i<9;i++)
    for(int j = 0;j<9;j++)
     if(grid[i][j] == 0)
      return false;
   
   return true;
  }

 //尋找解答
 public static boolean search(int[][] grid,int[][] freeCellList,int k)
  {
   
   int num = freeCellList.length;//空格數

   int i = 0;
   int j = 0;

   //如果k小於空格數 
   if(k<freeCellList.length)
    {
     //空格位置
     i = freeCellList[k][0];
     j = freeCellList[k][1];

     for(int l=1;l<=9;l++)
      {
       grid[i][j] = l;//填入數字
       if(isValid(i,j,grid))//如果有效
        {
         if(search(grid,freeCellList,k+1))//遞迴做下一格 
          return true;
        }
      }
    }
   else//如果K超出空格數
    {
     count++;//解答數+1
     System.out.println("The "+count+" solution is found:");//顯示解答
     printGrid(grid);
     return false;//因為這個回傳 找出解答後不會直接結束 會一直遞迴到找出所有解答
    }

   grid[i][j] = 0;

   return false;
  }
}