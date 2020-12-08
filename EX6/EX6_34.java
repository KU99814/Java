//8X8���r�C��

public class EX6_34
{
 public static void main(String args[])
  {
   int[][] board = new int[8][8];

   for(int i=0;i<board.length;i++) //��J1�M�s
    {
     for(int j=0;j<board[i].length;j++)
      {
       board[i][j] = (int)(Math.random()*2); //�H���M�w0��1
       System.out.print(board[i][j]);//���
      }
     System.out.println();//�_��
    }

   int[][] count = new int[2][board.length]; //�P�_�O�_�s�@�u
   //0:�C:1 �� 
   int[] diaCount = new int[2];//�P�_�﨤

   //�N�C�@�� �C �﨤�U�۬ۥ[
   for(int i=0;i<board.length;i++) //�P�@��
    for(int j=0;j<board.length;j++)
     count[0][i] += board[i][j];

   for(int j=0;j<board.length;j++) //�P�_�C
    for(int i=0;i<board.length;i++)
     count[1][j]+= board[i][j];

   for(int i=0;i<board.length;i++)  //�P�_���׹﨤
    diaCount[0] += board[i][i];

   for(int i =0;i<board.length;i++) //�P�_�k�׹﨤
    diaCount[1] += board[i][7-i];
   
   for(int i=0;i<board.length;i++) //��ܵ��G
    {
     if(count[0][i] == board.length)//�p�G��8 �h�o�C����1
      System.out.println("All 1's on "+i+" row");
     else if(count[0][i] == 0)//�p�G���s �o�C����0
      System.out.println("All 0's on "+i+" row");
     
     if(count[1][i] == board.length)//�p�G��8 �h�o�����1
      System.out.println("All 1's on "+i+" column");
     else if(count[1][i] == 0)//�p�G���s �o�����0
      System.out.println("All 0's on "+i+" column");
    }

   ////�p�G��8 �h�﨤����1 �Ϥ��Y��0�h����0
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

   