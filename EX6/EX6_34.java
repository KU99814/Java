//8X8井字遊戲

public class EX6_34
{
 public static void main(String args[])
  {
   int[][] board = new int[8][8];

   for(int i=0;i<board.length;i++) //輸入1和零
    {
     for(int j=0;j<board[i].length;j++)
      {
       board[i][j] = (int)(Math.random()*2); //隨機決定0或1
       System.out.print(board[i][j]);//顯示
      }
     System.out.println();//斷行
    }

   int[][] count = new int[2][board.length]; //判斷是否連一線
   //0:列:1 行 
   int[] diaCount = new int[2];//判斷對角

   //將每一行 列 對角各自相加
   for(int i=0;i<board.length;i++) //同一行
    for(int j=0;j<board.length;j++)
     count[0][i] += board[i][j];

   for(int j=0;j<board.length;j++) //判斷列
    for(int i=0;i<board.length;i++)
     count[1][j]+= board[i][j];

   for(int i=0;i<board.length;i++)  //判斷左斜對角
    diaCount[0] += board[i][i];

   for(int i =0;i<board.length;i++) //判斷右斜對角
    diaCount[1] += board[i][7-i];
   
   for(int i=0;i<board.length;i++) //顯示結果
    {
     if(count[0][i] == board.length)//如果為8 則這列全為1
      System.out.println("All 1's on "+i+" row");
     else if(count[0][i] == 0)//如果為零 這列全為0
      System.out.println("All 0's on "+i+" row");
     
     if(count[1][i] == board.length)//如果為8 則這行全為1
      System.out.println("All 1's on "+i+" column");
     else if(count[1][i] == 0)//如果為零 這行全為0
      System.out.println("All 0's on "+i+" column");
    }

   ////如果為8 則對角全為1 反之若為0則全為0
     if(diaCount[0] == board.length)
      System.out.println("All 1's on diagonal");
     else if(diaCount[0] == 0)
      System.out.println("All 0's on diagonal");
     
     if(diaCount[1] == board.length)
      System.out.println("All 1's on subdiagonal");
     else if(diaCount[1] == 0)
      System.out.println("All 0's on subdiagonal");
  }
}

   