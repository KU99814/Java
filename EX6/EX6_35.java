//八皇后

public class EX6_35
{
 public static void main(String args[])
  {
   int[][] board = new int[8][8];//棋盤 裡面的數字0為空 1為皇后

   int qNum = 0;//放下皇后數
   int[] queens = new int[8];//放下皇后之行
   while(true)
   {
    for(int i=qNum;i<8;i++)
     {
      for(int j=0;j<8;j++)
       {
        if(board[i][j]==0)//不為零 即代表有皇后或移動路徑
         {
          board[i][j]=1;//放下皇后
          putQueen(i,j,board);//設置移動路徑
          queens[qNum] = j;   //儲存行
          qNum++;//皇后數+1
          break;
         }
       }
      if(i==qNum)//若列數等於皇后數 代表整列不可放 跳出
       break;
     }

    if(qNum==8)//若放滿8個 跳出
     break;
    else//若否
     {
      //拿掉最後一個皇后
      qNum--;
      cleanQueen(qNum,queens[qNum],board);

      //往下一個開始重新找起
      while(true)
       {
        int j;
        for(j=queens[qNum]+1;j<8;j++)
         {
          if(board[qNum][j] == 0)//若有 放下皇后
           {
            board[qNum][j]=1;
            putQueen(qNum,j,board);
            queens[qNum] = j;   
            qNum++;
            break;
           }
         }
        if(j==8)//若整行皆無 再回到上一行
         {
          qNum--;
          cleanQueen(qNum,queens[qNum],board);
         }
        else
         break;
       }    
     }
   }
   
   //顯示棋盤
   for(int l=0;l<8;l++)
    {
     for(int j=0;j<8;j++)
      {
       if(board[l][j] == 1)
        System.out.print("Q");
     //  else if(board[l][j] == 2)
     //   System.out.print("X");
       else
        System.out.print(" ");
       System.out.print("|");
      }
     System.out.println("\n-------------------");
    }    
  }

 //放下皇后後填滿移動路徑
 public static void putQueen(int a,int b,int[][] board)
  {
   //填滿陣列 不為0或1即可
   //填滿列
   for(int i=0;i<8;i++)
    if(i!=b)
     board[a][i]+=2;

   //填滿行
   for(int i=0;i<8;i++)
    if(i!=a)
     board[i][b]+=2;

   //填滿對角
   //左上
   for(int i=1;i<8;i++)
    {
     if((a-i)<0 || (b-i)<0)
      break;
     board[a-i][b-i] += 2;
    }

   //右下
   for(int i=1;i<8;i++)
    {
     if((a+i)>7 || (b+i)>7)
      break;
     board[a+i][b+i]+=2;
    }

   //填滿反對角
   //左下
   for(int i=1;i<8;i++)
    {
     if((a-i)<0 || (b+i)>7)
      break;
     board[a-i][b+i]+=2;
    }

   //右上
   for(int i=1;i<8;i++)
    {
     if((a+i)>7 || (b-i)<0)
      break;
     board[a+i][b-i]+=2;
    }   
  }

 //取下皇后後清除移動路徑
 public static void cleanQueen(int a,int b,int[][] board)
  {
   //清除即減去相應數
   //不設為零是因為移動定路徑可能重疊
   //清除列
   for(int i=0;i<8;i++)
    if(i!=b)
     board[a][i]-=2;

   //清除行
   for(int i=0;i<8;i++)
    if(i!=a)
     board[i][b]-=2;

   //清除對角
   //左上
   for(int i=1;i<8;i++)
    {
     if((a-i)<0 || (b-i)<0)
      break;
     board[a-i][b-i] -= 2;
    }

   //右下
   for(int i=1;i<8;i++)
    {
     if((a+i)>7 || (b+i)>7)
      break;
     board[a+i][b+i]-=2;
    }

   //清除反對角
   //左下
   for(int i=1;i<8;i++)
    {
     if((a-i)<0 || (b+i)>7)
      break;
     board[a-i][b+i]-=2;
    }

   //右上
   for(int i=1;i<8;i++)
    {
     if((a+i)>7 || (b-i)<0)
      break;
     board[a+i][b-i]-=2;
    }

   board[a][b]=0;
  }
}