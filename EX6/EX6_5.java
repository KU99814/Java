//��X�}�C�����ƪ���

import java.util.Scanner;

public class EX6_5
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
   int[] num = new int[11];      //�s�񪺰}�C

   System.out.print("Enter number:");
   for(int i=0;i<11;i++) //��J�Ʀr
    {     
     num[i] = input.nextInt();
    }

   int[] duplicate = new int[11]; //�s��Ĥ@���X�{�L���ƪ��}�C
   int dupIndex = 0; //�X�{�L�@�����ƪ��Ӽ�

   //��X�X�{�L�@������
   for(int i=0;i<11;i++)
    {
     if(!search(num[i],dupIndex,duplicate))//�p�G�S��� �[�J
      {
       duplicate[dupIndex] = num[i];
       dupIndex++;
      }
    }

    //�Y���Ƽư}�C�Ƶ����J�}�C�� �N��S������
    if(dupIndex==11)
     System.out.print("There is no duplicate");
    else
     {
      System.out.print("There are duplicate numbers:"); //��ܭ��ƪ���
      
      for(int i=0;i<dupIndex;i++)//���Ƽư}�C�@loop
       {
        boolean check = false;//�ˬd�O�_�X�{�L
      
        for(int j=0;j<11;j++)
         {
          if(num[j]==duplicate[i])//�Y����X�{�L���ƦA�@�P�_
           {
            if(check)//�e���X�{�L�@�� �Y���
             {
              System.out.print(num[j]+" ");
              break;
             }
            else //�X�{�Ĥ@���� �ରtrue
             check = true;
           }
         }
       }
     }
  }

 //�j�M�O�_�s�b�}�C
 public static boolean search(int key,int index,int[] num)
  {
   for(int i=0;i<index;i++)
    {
     if(num[i]==key)
      {
       return true; //�Y���^��true
      }
    }     
   
   return false;//�Y�L�^��false
  }
}