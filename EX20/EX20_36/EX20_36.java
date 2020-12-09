//Game:Sudoku with recursive no only solution

import java.util.Scanner;

public class EX20_36
{
 static int count = 0;//�ѵ���
 public static void main(String args[])
  {
   int[][] grid = readAPuzzle();//��J�ƿW�D��

   if(!isValid(grid))//�P�_�D�جO�_���~
    System.out.println("Invalid input");
   else 
    {
     int[][] freeCellList = getFreeCellList(grid);//���o�Ů�
     search(grid,freeCellList,0);//�j�M�ѵ�
    }

   if(count == 0)//�p�G�ѵ��Ƭ��s
    System.out.println("No solution");
  }

 //��J�ƿW�D��
 public static int[][] readAPuzzle()
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.println("Enter a Sudoku puzzle:");

   int[][] grid = new int[9][9];//�ŧi�ƿW�}�C

   for(int i=0;i<9;i++)
    for(int j=0;j<9;j++)
     grid[i][j] = input.nextInt();//��J

   return grid;//�^��
  }
 
 //���o�ťծ��
 public static int[][] getFreeCellList(int[][] grid)
  {
   int numberOfFreeCells = 0;//�ťծ�l��
   int i=0;
   int j=0;

   //�p��ťծ��
   for(i=0;i<9;i++)
    for(j=0;j<9;j++)
     if(grid[i][j] ==0)
       numberOfFreeCells++;
         
     //�ھڮ�ƫŧi�}�C
     int[][] freeCells = new int[numberOfFreeCells][2];
     int c = 0;//�{�b�ĴX�Ӯ�l

    for(i=0;i<9;i++)
     for(j=0;j<9;j++)
      {
       if(grid[i][j] ==0)
        {
         freeCells[c][0] = i;
         freeCells[c++][1] = j;
        }
      }
   
   return freeCells;//�^��
  }

 //��ܼƿW�}�C
 public static void printGrid(int[][] grid)
  {
   for(int i=0;i<9;i++)
    {
     for(int j=0;j<9;j++)
      System.out.print(grid[i][j]+" ");
     System.out.println();
    }
  }

 //�P�_��l���Ʀr�O�_����
 public static boolean isValid(int i,int j,int[][] grid)
  {
   for(int c = 0;c<9;c++)//�P�_����
    if(c != j&& grid[i][c] == grid[i][j])
     return false;
   
   //�P�_��C
   for(int r = 0;r<9;r++)
    if(r != i&& grid[r][j] == grid[i][j])
     return false;

   //�P�_�﨤
   for(int r = (i/3)*3;r<(i/3)*3+3;r++)
    for(int c = (j/3)*3;c<(j/3)*3+3;c++)
     if(r != i && c != j && grid[r][c] == grid[i][j])
      return false;
   
   return true;
  }

 //�P�_�ƿW����O�_����
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

 //�M��ѵ�
 public static boolean search(int[][] grid,int[][] freeCellList,int k)
  {
   
   int num = freeCellList.length;//�Ů��

   int i = 0;
   int j = 0;

   //�p�Gk�p��Ů�� 
   if(k<freeCellList.length)
    {
     //�Ů��m
     i = freeCellList[k][0];
     j = freeCellList[k][1];

     for(int l=1;l<=9;l++)
      {
       grid[i][j] = l;//��J�Ʀr
       if(isValid(i,j,grid))//�p�G����
        {
         if(search(grid,freeCellList,k+1))//���j���U�@�� 
          return true;
        }
      }
    }
   else//�p�GK�W�X�Ů��
    {
     count++;//�ѵ���+1
     System.out.println("The "+count+" solution is found:");//��ܸѵ�
     printGrid(grid);
     return false;//�]���o�Ӧ^�� ��X�ѵ��ᤣ�|�������� �|�@�����j���X�Ҧ��ѵ�
    }

   grid[i][j] = 0;

   return false;
  }
}