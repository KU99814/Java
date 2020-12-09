//Amount from coins

import java.util.Scanner;

public class EX20_26
{
 public static void main(String args[]) throws IllegalArgumentException
  {
   Scanner input = new Scanner(System.in);//�ŧi��J
   
   System.out.print("Enter the number of set: "); //��J�w���������ƶq
   int num = input.nextInt();

   int[] a = new int[num];

   System.out.print("Enter the set of cent: ");  //��J�w������
   for(int i=0;i<num;i++)
    {
     a[i] = input.nextInt();
    
     if(a[i]<0)
      throw new IllegalArgumentException("The number is negative");
    }

   linearSort(a);//�q�s�Ƨ� ���B�q�p��j

   for(int i=0;i<num;i++)
    System.out.print(a[i]+" ");

   System.out.print("Enter a amount: "); //��J�`��
   int amount = input.nextInt();
   
   int[] coinCount = coin(amount,a,num-1); //�H���j�D�X���X�زզX

   //�D�X�̤p�զX
   int min = -1;
   for(int i=0;i<coinCount.length;i++)
    {
     if(coinCount[i]>min)
      min = coinCount[i];
    }
   if(min == -1) //�Y���t �h�L�զX
    System.out.print("No present");
   else
    {
     for(int i=0;i<coinCount.length;i++)
      {
       if(coinCount[i]<min&&coinCount[i]>0)
        min = coinCount[i];
      }
     System.out.print("THe minimum number of coins are "+min);//��̤ܳp�w����
    }
   
  }

 //sort
 public static void linearSort(int[] set)
  {
   for(int i=0;i<set.length-1;i++)
    {
     for(int j=i+1;j<set.length;j++)
      {
       if(set[i]>set[j])
        {
         int temp = set[i];
         set[i] = set[j];
         set[j] = temp;
        }
      }
    }
  }

 //���j ���o�զX�w����
 public static int[] coin(int amount,int[] a,int length) throws IllegalArgumentException
  {
   int c = length;//�w���}�C����

   if(length==-1)//base case
    return new int[0];
   else //�q���B�̤j�}�l��h �i�o�̤p�w����
    {
     int count = 0;//�w����
     int nowAmount = amount;//�`��
     while(nowAmount>0)//�����`�Ƥp�󵥩�s
      {
       if(c<0)//�Y�C����p���B�B�l�B����0 �w���Ƴ]��-1
        {
         count = -1;
         break;
        }

       if(a[c]<0)
        {
         throw new IllegalArgumentException("The value is negative");
        }

       if(nowAmount>=a[c])//��h���B����p���B
        {
         nowAmount -= a[c];
         count++;
        }
       else
        c--;
      }
     
     try{
      int[] b = coin(amount,a,length-1);//���j���o���p���B�w���ư}�C
      int[] rb = new int[b.length+1];//�[�W�o�@���w���ƪ��s�}�C

      //�[�J�s�}�C
      for(int i=0;i<b.length;i++)
       rb[i] = b[i];
      rb[rb.length-1] = count;//�[�J�o���w����
      return rb;  //�^��
     }
     catch(IllegalArgumentException ex){ //�ҥ~
      System.out.println("There is not present");
     }
     return new int[0];
    }
  }
}