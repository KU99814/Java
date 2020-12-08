import java.util.Scanner;

public class EX6_36
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入
   int[][] grid = new int[9][9]; //數獨的格子

   System.out.println("Enter a sudoku puzzle:");
   
   for(int i=0;i<9;i++)
    for(int j=0;j<9;j++)
     grid[i][j] = input.nextInt(); //輸入題目

   if(!isValid(grid))//檢查輸入是否合格
    System.out.println("Invalid Input");
   else//若合格 開始找解
    {
     int count = search(grid);
     System.out.println("Has " + count+ " solution"); 
    } 
  }

 public static int search(int[][] grid)
  {
   int[][] freeCellList = getFreeCellList(grid); //找出空格 
   int k = 0; //目前第幾個空格
   int count = 0; //有幾個解

   while(k>=0)
    {
     int i = freeCellList[k][0]; //第i行
     int j = freeCellList[k][1]; //第j列
     
     //先填入數字
     if(grid[i][j] == 0)
      grid[i][j] = 1;
     
     if(isValid(i,j,grid))//如果解答有效
      {
       if((k+1) == freeCellList.length) //如果所有空格已被填滿
        {
         System.out.println();
         printGrid(grid);//顯示
         System.out.println("\n");
         count++; //解答+1
         grid[i][j]++;
        }
       else
        k++;
      }
     else if(grid[i][j] < 9) //如果非解答且小於9
      grid[i][j] = grid[i][j] +1;
     else
      {
       while(grid[i][j] >= 9)//不用if是因為如果之前一格是9會無限循環
        {
         grid[i][j] = 0;
         k--;
         if(k<0) //所有可能解已出現 跳出
          return count;
         i = freeCellList[k][0];
         j = freeCellList[k][1];
        }

       grid[i][j] = grid[i][j]+1;
      }
    }

   return count;
  }

 //取得空格的i j 索引
 public static int[][] getFreeCellList(int[][] grid)
  {
   int numberOfFreeCells = 0;//空格數

   //尋找空格
   for(int i=0;i<9;i++)
    for(int j=0;j<9;j++)
     if(grid[i][j] == 0)
      numberOfFreeCells++;
   
   int[][] freeCellList = new int[numberOfFreeCells][2];//一空格數宣告回傳array
   int count = 0;

   //加入索引
   for(int i=0;i<9;i++)
    for(int j=0;j<9;j++)
     if(grid[i][j] == 0)
      {
       freeCellList[count][0] = i;
       freeCellList[count++][1] = j;
      }

   return freeCellList;
  }

 //顯示數獨
 public static void printGrid(int[][] grid)
  {
   for(int i=0;i<9;i++)
    {
     for(int j=0;j<9;j++)
      System.out.print(grid[i][j]+" ");
     System.out.println();
    }
  }
  
 //檢驗是否有效
 public static boolean isValid(int i,int j,int[][] grid)
  {
   //檢查行
   for(int column=0;column<9;column++)
    if(column != j && grid[i][column] == grid[i][j])
     return false;

   //檢查列
   for(int row=0;row<9;row++)
    if(row != i && grid[row][j] == grid[i][j])
     return false;

    //檢查九宮格
    for(int row=(i/3)*3;row<(i/3)*3+3;row++)
     for(int col=(j/3)*3;col<(j/3)*3+3;col++)
      if(row != i && col != j && grid[row][col] == grid[i][j])
       return false;
   
    return true;
   }

 //檢驗是否解答
 public static boolean isValid(int[][] grid)
  {
   for(int i=0;i<9;i++)
    for(int j=0;j<9;j++)
     if(grid[i][j] !=0 && !isValid(i,j,grid))
      return false;

   return true;
  }
}