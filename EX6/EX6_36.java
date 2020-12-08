import java.util.Scanner;

public class EX6_36
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
   int[][] grid = new int[9][9]; //�ƿW����l

   System.out.println("Enter a sudoku puzzle:");
   
   for(int i=0;i<9;i++)
    for(int j=0;j<9;j++)
     grid[i][j] = input.nextInt(); //��J�D��

   if(!isValid(grid))//�ˬd��J�O�_�X��
    System.out.println("Invalid Input");
   else//�Y�X�� �}�l���
    {
     int count = search(grid);
     System.out.println("Has " + count+ " solution"); 
    } 
  }

 public static int search(int[][] grid)
  {
   int[][] freeCellList = getFreeCellList(grid); //��X�Ů� 
   int k = 0; //�ثe�ĴX�ӪŮ�
   int count = 0; //���X�Ӹ�

   while(k>=0)
    {
     int i = freeCellList[k][0]; //��i��
     int j = freeCellList[k][1]; //��j�C
     
     //����J�Ʀr
     if(grid[i][j] == 0)
      grid[i][j] = 1;
     
     if(isValid(i,j,grid))//�p�G�ѵ�����
      {
       if((k+1) == freeCellList.length) //�p�G�Ҧ��Ů�w�Q��
        {
         System.out.println();
         printGrid(grid);//���
         System.out.println("\n");
         count++; //�ѵ�+1
         grid[i][j]++;
        }
       else
        k++;
      }
     else if(grid[i][j] < 9) //�p�G�D�ѵ��B�p��9
      grid[i][j] = grid[i][j] +1;
     else
      {
       while(grid[i][j] >= 9)//����if�O�]���p�G���e�@��O9�|�L���`��
        {
         grid[i][j] = 0;
         k--;
         if(k<0) //�Ҧ��i��Ѥw�X�{ ���X
          return count;
         i = freeCellList[k][0];
         j = freeCellList[k][1];
        }

       grid[i][j] = grid[i][j]+1;
      }
    }

   return count;
  }

 //���o�Ů檺i j ����
 public static int[][] getFreeCellList(int[][] grid)
  {
   int numberOfFreeCells = 0;//�Ů��

   //�M��Ů�
   for(int i=0;i<9;i++)
    for(int j=0;j<9;j++)
     if(grid[i][j] == 0)
      numberOfFreeCells++;
   
   int[][] freeCellList = new int[numberOfFreeCells][2];//�@�Ů�ƫŧi�^��array
   int count = 0;

   //�[�J����
   for(int i=0;i<9;i++)
    for(int j=0;j<9;j++)
     if(grid[i][j] == 0)
      {
       freeCellList[count][0] = i;
       freeCellList[count++][1] = j;
      }

   return freeCellList;
  }

 //��ܼƿW
 public static void printGrid(int[][] grid)
  {
   for(int i=0;i<9;i++)
    {
     for(int j=0;j<9;j++)
      System.out.print(grid[i][j]+" ");
     System.out.println();
    }
  }
  
 //����O�_����
 public static boolean isValid(int i,int j,int[][] grid)
  {
   //�ˬd��
   for(int column=0;column<9;column++)
    if(column != j && grid[i][column] == grid[i][j])
     return false;

   //�ˬd�C
   for(int row=0;row<9;row++)
    if(row != i && grid[row][j] == grid[i][j])
     return false;

    //�ˬd�E�c��
    for(int row=(i/3)*3;row<(i/3)*3+3;row++)
     for(int col=(j/3)*3;col<(j/3)*3+3;col++)
      if(row != i && col != j && grid[row][col] == grid[i][j])
       return false;
   
    return true;
   }

 //����O�_�ѵ�
 public static boolean isValid(int[][] grid)
  {
   for(int i=0;i<9;i++)
    for(int j=0;j<9;j++)
     if(grid[i][j] !=0 && !isValid(i,j,grid))
      return false;

   return true;
  }
}