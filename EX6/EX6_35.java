//�K�ӦZ

public class EX6_35
{
 public static void main(String args[])
  {
   int[][] board = new int[8][8];//�ѽL �̭����Ʀr0���� 1���ӦZ

   int qNum = 0;//��U�ӦZ��
   int[] queens = new int[8];//��U�ӦZ����
   while(true)
   {
    for(int i=qNum;i<8;i++)
     {
      for(int j=0;j<8;j++)
       {
        if(board[i][j]==0)//�����s �Y�N���ӦZ�β��ʸ��|
         {
          board[i][j]=1;//��U�ӦZ
          putQueen(i,j,board);//�]�m���ʸ��|
          queens[qNum] = j;   //�x�s��
          qNum++;//�ӦZ��+1
          break;
         }
       }
      if(i==qNum)//�Y�C�Ƶ���ӦZ�� �N���C���i�� ���X
       break;
     }

    if(qNum==8)//�Y��8�� ���X
     break;
    else//�Y�_
     {
      //�����̫�@�ӬӦZ
      qNum--;
      cleanQueen(qNum,queens[qNum],board);

      //���U�@�Ӷ}�l���s��_
      while(true)
       {
        int j;
        for(j=queens[qNum]+1;j<8;j++)
         {
          if(board[qNum][j] == 0)//�Y�� ��U�ӦZ
           {
            board[qNum][j]=1;
            putQueen(qNum,j,board);
            queens[qNum] = j;   
            qNum++;
            break;
           }
         }
        if(j==8)//�Y���ҵL �A�^��W�@��
         {
          qNum--;
          cleanQueen(qNum,queens[qNum],board);
         }
        else
         break;
       }    
     }
   }
   
   //��ܴѽL
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

 //��U�ӦZ��񺡲��ʸ��|
 public static void putQueen(int a,int b,int[][] board)
  {
   //�񺡰}�C ����0��1�Y�i
   //�񺡦C
   for(int i=0;i<8;i++)
    if(i!=b)
     board[a][i]+=2;

   //�񺡦�
   for(int i=0;i<8;i++)
    if(i!=a)
     board[i][b]+=2;

   //�񺡹﨤
   //���W
   for(int i=1;i<8;i++)
    {
     if((a-i)<0 || (b-i)<0)
      break;
     board[a-i][b-i] += 2;
    }

   //�k�U
   for(int i=1;i<8;i++)
    {
     if((a+i)>7 || (b+i)>7)
      break;
     board[a+i][b+i]+=2;
    }

   //�񺡤Ϲ﨤
   //���U
   for(int i=1;i<8;i++)
    {
     if((a-i)<0 || (b+i)>7)
      break;
     board[a-i][b+i]+=2;
    }

   //�k�W
   for(int i=1;i<8;i++)
    {
     if((a+i)>7 || (b-i)<0)
      break;
     board[a+i][b-i]+=2;
    }   
  }

 //���U�ӦZ��M�����ʸ��|
 public static void cleanQueen(int a,int b,int[][] board)
  {
   //�M���Y��h������
   //���]���s�O�]�����ʩw���|�i�୫�|
   //�M���C
   for(int i=0;i<8;i++)
    if(i!=b)
     board[a][i]-=2;

   //�M����
   for(int i=0;i<8;i++)
    if(i!=a)
     board[i][b]-=2;

   //�M���﨤
   //���W
   for(int i=1;i<8;i++)
    {
     if((a-i)<0 || (b-i)<0)
      break;
     board[a-i][b-i] -= 2;
    }

   //�k�U
   for(int i=1;i<8;i++)
    {
     if((a+i)>7 || (b+i)>7)
      break;
     board[a+i][b+i]-=2;
    }

   //�M���Ϲ﨤
   //���U
   for(int i=1;i<8;i++)
    {
     if((a-i)<0 || (b+i)>7)
      break;
     board[a-i][b+i]-=2;
    }

   //�k�W
   for(int i=1;i<8;i++)
    {
     if((a+i)>7 || (b-i)<0)
      break;
     board[a+i][b-i]-=2;
    }

   board[a][b]=0;
  }
}