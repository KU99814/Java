//reversing the numbers enters

import java.util.Scanner;

public class EX6_1
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J

   int[] num = new int[5]; //�s��Ʀr���}�C

   System.out.print("Enter five numbers: ");
   for(int i=0;i<5;i++)
    num[i] = input.nextInt(); //�N�Ʀr�̦�Ʃ�J�}�C

   System.out.print("THe origion series is: ");//����A�˫e�ƦC
   for(int i=0;i<5;i++)
    System.out.print(num[i]+" ");

   
   reverse(num);

   System.out.print("\nTHe reverse series is: ");//����A�˫�ƦC
   for(int i=0;i<5;i++)
    System.out.print(num[i]+" ");
  }

 //�N�Ʀr�A�˪�method
 public static void reverse(int[] num)
  {
   //�}�Cindex
   int low = 0;//�Y
   int high = num.length-1;//��
   
   //�@�j���A��
   while(true)
   {
    //�Y�Y��index�ۥ� ���X�j��
    if(high<=low)
     break;
    
    //�ܼƥ洫
    int temp = num[low];
    num[low] = num[high];
    num[high] = temp;

    //�Y��index���Y
    high--;
    low++;
   }
  }
}