//Game:Sudoku with recursive

import java.util.Scanner;

public class EX20_34
{
 public static void main(String args[])
  {
   int[][] grid = readAPuzzle();//��J�ƿW�D��

   if(!isValid(grid))//�ˬd�D�جO�_����
    System.out.println("Invalid input");
   else if(search(grid))//�j�M�ѵ�
    {
     System.out.println("The solution is found:");//��ܸѵ�
     printGrid(grid);
    }
   else//�Y�S���ѵ�
    System.out.println("No solution");
  }

 public static int[][] readAPuzzle()
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.println("Enter a Sudoku puzzle:");

   int[][] grid = new int[9][9];//�ŧi�ƿW�}�C

   //��J�ƿW�D��   
   for(int i=0;i<9;i++)
    for(int j=0;j<9;j++)
     grid[i][j] = input.nextInt();

   return grid;//�^��
  }

 //���o�Ů�
 public static int[][] getFreeCellList(int[][] grid)
  {
   int numberOfFreeCells = 0;//�Ů��

   //���o�Ů��
   for(int i=0;i<9;i++)
    for(int j=0;j<9;j++)
     if(grid[i][j] == 0)
      numberOfFreeCells++;
   
   //�ŧi�Ů�}�C
   int[][] freeCellList = new int[numberOfFreeCells][2];
   int count = 0;

   //���o�Ů��m
   for(int i=0;i<9;i++)
    for(int j=0;j<9;j++)
     if(grid[i][j] == 0)
      {
       freeCellList[count][0] = i;
       freeCellList[count++][1] = j;
      }

   return freeCellList;//�^�ǰ}�C
  }

 //��ܼƿW
 public static void printGrid(int[][] grid)
  {
   //�N�}�C�@�ӭ����
   for(int i=0;i<9;i++)
    {
     for(int j=0;j<9;j++)
      System.out.print(grid[i][j]+" ");
     System.out.println();
    }
  }

 //�P�_���w��O�_����
 public static boolean isValid(int i,int j,int[][] grid)
  {
   //�P�_�P�@��O�_���ۦP��
   for(int c = 0;c<9;c++)
    if(c != j&& grid[i][c] == grid[i][j])
     return false;
   
   //�P�_�P�@�C�O�_���ۦP��
   for(int r = 0;r<9;r++)
    if(r != i&& grid[r][j] == grid[i][j])
     return false;

   
   //�P�_�E�c�椺�O�_���ۦP��
   for(int r = (i/3)*3;r<(i/3)*3+3;r++)
    for(int c = (j/3)*3;c<(j/3)*3+3;c++)
     if(r != i && c != j && grid[r][c] == grid[i][j])
      return false;
   
   return true;//�����q�L�^�ǵ��G
  }

 //�P�_�ƿW�O�_����
 public static boolean isValid(int[][] grid)
  {
   //�ΰj��@�ӭӧP�_�O�_���Ů�M�L�Į�
   for(int i = 0;i<9;i++)
    for(int j = 0;j<9;j++)
     if(grid[i][j] != 0&&!isValid(i,j,grid))
      return false;
   
   return true;
  }

 //�j�M�ѵ�
 public static boolean search(int[][] grid)
  {
   int[][] freeCellList = getFreeCellList(grid);//�ťծ�l
   int num = freeCellList.length;//�Ů��

   //�{�b��l��m
   int i = 0;
   int j = 0;

   if(num>0)//�p�G���Ů�
    {
     //�N��m�]�b�Ĥ@�ӪŮ�
     i = freeCellList[0][0];
     j = freeCellList[0][1];

     //��J1~9���Ʀr
     for(int k=1;k<=9;k++)
      {
       grid[i][j] = k;
       if(isValid(i,j,grid))//�P�_�{�b�Ʀr�O�_����
        {
         if(search(grid))//���j ����̫�@�ӪŮ�]��W
          return true;
        }
      }
    }
   else //�Y�L�Ů� �Y�ѵ�
    return true;

   grid[i][j] = 0;//�䤣�� �]�^0

   return false;
  }
}