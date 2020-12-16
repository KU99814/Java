//Number of prime numbers

import java.io.*;
import java.math.*;
import java.util.*;

public class EX23_8
{
 public static void main(String args[]) throws IOException
  {
   RandomAccessFile inout = new RandomAccessFile("EX23_8.dat","rw");//���o�ɮ�

   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter number:");
   long num = input.nextLong();//��J��M�d��

   printPrime(inout,num);//��X��ƨ��ɮ�
   
   inout.seek(0);//���]���w
   int count = 0;//�O��
   while(inout.getFilePointer()!=inout.length())//�P�_�ɮ׬O�_���Y
    {
     Long now = inout.readLong();//��X
     if(now > num)
      break;
     count++;
    }

   System.out.println("The number of Prime less than "+num+" is "+count);//��ܭӼ�
   
   inout.close();//����
  }

 //��X��ƿ�X���ɮ�
 public static void printPrime(RandomAccessFile inout,long num) throws IOException
  {
   long nowNum = 2;//��l��
   if(inout.length()!=0)//�Y�ɮ׫D��
    {
     inout.seek(inout.length()-4*2);//�ӥX�̥����
     nowNum = inout.readLong();
     if(nowNum>=num)//�Y�j��ؼм� ���ݦA��
      return;
    }
   else//�Y��
    inout.writeLong(nowNum);//����J1��
   List<Long> list = findPrime(inout,num,nowNum);//��X�s�ƦC��list
   
   for(long newNum: list)
    {
     inout.writeLong(newNum);//�N�s�ƿ�i�ɮ�
    }
  }

 //��X���
 public static List<Long> findPrime(RandomAccessFile inout,long n,long number) throws IOException
  {
   java.util.List<Long> list = new java.util.ArrayList<Long>();//�x�s���list �����
   java.util.List<Long> relist = new java.util.ArrayList<Long>();//�x�s�s���list �^�ǥ�

   inout.seek(0);//���]���w
   while(inout.getFilePointer()!=inout.length())
    {
     list.add(inout.readLong());//�N�ɮפ��e�[�J�}�C
    }
   
   number++;

   while(number <= n)
    {
     boolean isPrime = true;//�P�_���

     long squareRoot = (long)(Math.sqrt(number));

     //�j�� �Ylist�����Ƥp��squareRoot �P�_�O�_����
     for(int k = 0;k < list.size() && list.get(k) <= squareRoot;k++)
      {
       if(number % list.get(k) == 0)
        {
         isPrime = false;
         break;
        }
      }

     if(isPrime)//�Y�O��� �[�Jlist
      {
       list.add(number);
       relist.add(number);
      }

     number++;
    }
   
   return relist;//�^��
  }
}