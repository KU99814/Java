//bean game

import java.util.Scanner;

public class EX6_29
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J

   System.out.print("Enter the number of balls to drop: "); //��J�y��
   int ball = input.nextInt();

   System.out.print("Enter the number of slots in the bean machine: "); //��J�b���
   int slot = input.nextInt();
   int[] slots = new int[slot+1]; //slot�N��� ���+1����}��
   
   for(int i=0;i<ball;i++)
    {
     int path = 0;//���| �̫Ḩ�J����
     for(int j=0;j<slot;j++)
      {
       int via = (int)(Math.random()*2); //�H�H����k�M�w���k
       path += via; //��+0 �k�[�@
       if(via == 0) //��ܥ��k
        System.out.print("L");
       else
        System.out.print("R");
      }
     slots[path]++; //��J�y
     System.out.println();
    }

   int high = 0;//��n����

   for(int i=0;i<slots.length;i++)
    {
     if(slots[i]>high)
      high = slots[i];
    }
   
   for(int i=high;i>0;i--) //��ܲy�����G
    {
     for(int j=0;j<slots.length;j++)
      {
       if(slots[j]==(i))//�Y�y�Ƶ��󰪫� ��ܨô�1
        {
         System.out.print("0");
         slots[j]--;
        }
       else
        System.out.print(" ");
      }
     System.out.println();
    } 
  }
}   
