//井字遊戲

public class EX6_28
{
 public static void main(String args[])
  {
   int[][] TicTacToe = new int[3][3]; //存放0 1的陣列

   //放置XO
   for(int i=0;i<3;i++)
    {
     for(int j=0;j<3;j++)
      {
       TicTacToe[i][j] = (int)(Math.random()*2); //隨機決定XO
       System.out.print(TicTacToe[i][j]); 
      }
     System.out.println();
    }

   for(int i=0;i<3;i++) //偵測列
    {
     if(TicTacToe[i][0]==TicTacToe[i][1] && TicTacToe[i][1]==TicTacToe[i][2])
      {
       if(TicTacToe[i][0]==1)
        System.out.println("All 1's on row "+(i+1));
       else if(TicTacToe[i][0]==0)
        System.out.println("All 0's on row "+(i+1));
      }
    }

   for(int j=0;j<3;j++) //偵測行
    {
     if(TicTacToe[0][j]==TicTacToe[1][j] && TicTacToe[1][j]==TicTacToe[2][j])
      {
       if(TicTacToe[0][j]==1)
        System.out.println("All 1's on column "+(j+1));
       else if(TicTacToe[0][j]==0)
        System.out.println("All 0's on column "+(j+1));
      }
    }
   //偵測主對角
  if(TicTacToe[0][0]==TicTacToe[1][1] && TicTacToe[1][1]==TicTacToe[2][2])
   {
    if(TicTacToe[0][0]==1)
     System.out.println("All 1's on diagonals ");
    else if(TicTacToe[0][0]==0)
     System.out.println("All 0's on diagonals ");
   }

   //偵測反主對角
  if(TicTacToe[0][2]==TicTacToe[1][1] && TicTacToe[1][1]==TicTacToe[2][0])
   {
    if(TicTacToe[0][2]==1)
     System.out.println("All 1's on diagonals ");
    else if(TicTacToe[0][2]==0)
     System.out.println("All 0's on diagonals ");
   }
 }
}
   
   