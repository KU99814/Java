//���W�}�C�e�q

import java.util.Scanner;

public class EX6_15
{
 public static void main(String[] args)
  {
   Scanner input = new Scanner(System.in); //�ŧi��J

   System.out.print("Enter the length of array: "); //��J�Q�n������
   int amount = input.nextInt();

   int[] array = new int[amount]; //�s��ƪ��}�C

   System.out.println("The array capacity is "+array.length); //��ܪ�l����
   
   array = doubleCapacity(array); //���W
   System.out.println("The double capacity is "+array.length); //��ܭ��W����
  }

 public static int[] doubleCapacity(int[] list) //���W����
  {
   int[] doubleArray = new int[list.length*2];//�зs�}�C �⭿�j�p

   //�N�°}�C�Ʃ�J 
   for(int i=0;i<list.length;i++)
     doubleArray[i] = list[i];
   return doubleArray; //�^�ǪŰ}�C ����*2
  }
}
