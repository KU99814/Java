//���r�C��

public class EX6_28
{
 public static void main(String args[])
  {
   int[][] TicTacToe = new int[3][3]; //�s��0 1���}�C

   //��mXO
   for(int i=0;i<3;i++)
    {
     for(int j=0;j<3;j++)
      {
       TicTacToe[i][j] = (int)(Math.random()*2); //�H���M�wXO
       System.out.print(TicTacToe[i][j]); 
      }
     System.out.println();
    }

   for(int i=0;i<3;i++) //�����C
    {
     if(TicTacToe[i][0]==TicTacToe[i][1] && TicTacToe[i][1]==TicTacToe[i][2])
      {
       if(TicTacToe[i][0]==1)
        System.out.println("All 1's on row "+(i+1));
       else if(TicTacToe[i][0]==0)
        System.out.println("All 0's on row "+(i+1));
      }
    }

   for(int j=0;j<3;j++) //������
    {
     if(TicTacToe[0][j]==TicTacToe[1][j] && TicTacToe[1][j]==TicTacToe[2][j])
      {
       if(TicTacToe[0][j]==1)
        System.out.println("All 1's on column "+(j+1));
       else if(TicTacToe[0][j]==0)
        System.out.println("All 0's on column "+(j+1));
      }
    }
   //�����D�﨤
  if(TicTacToe[0][0]==TicTacToe[1][1] && TicTacToe[1][1]==TicTacToe[2][2])
   {
    if(TicTacToe[0][0]==1)
     System.out.println("All 1's on diagonals ");
    else if(TicTacToe[0][0]==0)
     System.out.println("All 0's on diagonals ");
   }

   //�����ϥD�﨤
  if(TicTacToe[0][2]==TicTacToe[1][1] && TicTacToe[1][1]==TicTacToe[2][0])
   {
    if(TicTacToe[0][2]==1)
     System.out.println("All 1's on diagonals ");
    else if(TicTacToe[0][2]==0)
     System.out.println("All 0's on diagonals ");
   }
 }
}
   
   