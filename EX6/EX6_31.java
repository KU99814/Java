//�ν�]�Ƥ��ѨD�̤p������

import java.util.Scanner;

public class EX6_31
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J
 
   System.out.print("Enter the first number: "); //��J�Ĥ@�Ӽ�
   int num1 = input.nextInt();

   System.out.print("Enter the second number: "); //��J�ĤG�Ӽ�
   int num2 = input.nextInt();

   int PN = primeNumber(num1,num2); //��X�̤j������
   
   int[][] table1 = new int[PN][2]; //�s���]�ƪ��}�C �ĤG����0�O��� 1�O��ƭӼ�
   int[][] table2 = new int[PN][2];
   
   getPrimeFactor(num1,table1); //�s�J��]��
   getPrimeFactor(num2,table2);

   int GCD = 1;//�̤j���]��
   
   //���X�̤j���]��
   for(int i=0;i<table1.length;i++) 
    {
     for(int j=0;j<table2.length;j++)
      {
       if(table1[i][0] == table2[j][0]) //�p�G���ۦP��]��
        {
         if(table1[i][1] > table2[j][1]) //��X�̤p���n����
          GCD*=(int)(Math.pow(table2[j][0],table2[j][1]));
         else 
          GCD*=(int)(Math.pow(table1[i][0],table1[i][1]));
         break;
        }
      }
    }
   int LCM = (num1*num2) /GCD;//��Ƭۭ��A���H�̤j���]��
   System.out.print("The LCM of "+num1+" and "+num2+" is "+LCM); //���
  } 

 public static int primeNumber(int num1,int num2) //��X�̦h��]�ƭӼ�
  {
   int list1 = 0;
   int list2 = 0;

   int max = 0;

   //�w�j����������
   if(num1>num2)
    max = num1;
   else
    max = num2;

   //�����]�ƺ����֦h
   for(int i=2;i<max+1;i++)
    {
     if(isPrime(i))
      {
       if(num1>=i && num1%i == 0)
        list1++;

       if(num1>=i && num2%i == 0)
        list2++;
      }
    }

   //�^�Ǧh��
   if(list1>list2)
    return list1;
   else
    return list2;
  }

 public static boolean isPrime(int num) //�P�_�O�_���
  {
   int divide = (int)Math.sqrt(num);//��ǰ���

   //�Y��㰣�h�_
   for(int i=2;i<=divide;i++)
    {
     if(num%i==0)
      return false;
    }

   return true;
  }

 public static void getPrimeFactor(int num , int[][] table) //�s�J��]��
  {
   int k = 0; //��K�ӽ�]��
   for(int i=2;i<=num;i++)
    {
     if(isPrime(i) && num % i == 0)
      {
       table[k][0] = i; 
       while(true)
        {
         num /= i;
         table[k][1]++; //�s�J��]�ƭӼ�
         if(num%i!=0)
          break;
        }
       k++;
      }
     if(num == 1)
      break;
    } 
  }
}
    
