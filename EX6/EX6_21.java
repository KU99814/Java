//�x�}�﨤�u���ۥ[

public class EX6_21
{
 public static void main(String args[])
  {
   int[][] num = {{1,2,4,5},{6,7,8,9},{10,11,12,13},{14,15,16,17}}; //�]�x�}

   System.out.print("The sum of the major diagonal is "+sumDiagonal(num)); //��ܵ��G
  }

 public static int sumDiagonal(int[][] list)
  {
   int sum = 0;

   for(int i=0;i<list.length;i++)  //�ѥ���k�o�D�﨤�u
    sum+=list[i][i];

   for(int i=0,j=list.length-1;i<list.length;i++,j--) //�ѥk�쥪�o�D�﨤�u
    sum+=list[i][j];

   return sum; //�^��
  }
}
     