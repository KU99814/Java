//Sum of subset matching a specified value
//T(n) = O(n^2)

import java.lang.Math.*;
import java.util.*;

public class EX23_3
{
 public static void main(String args[])
  {
   //���հ}�C
   int[] a1 = {3,1,3,8,30,78,4};
   int[] a2 = {12,1,8,9};

   //�n�䪺�M
   int n1 = 6;

   int n2 = 24;

   //���G��X
   System.out.println(Arrays.toString(a1)+" "+n1+" "+subsetSum(a1,n1));
   System.out.println(Arrays.toString(a2)+" "+n2+" "+subsetSum(a2,n2));
  }

 //��X�O�_������զ��ƪ�subset��method
 //���n�a�|
 public static boolean subsetSum(int[] a,int N)
  {
   List<Integer> list = new ArrayList<Integer>();//�x�s��list

   //�j��   
   for(int i=0;i<a.length;i++)
    {
     int num = a[i];//�ثe��index
    
     if(num == N)//�p�G�����N�O�n�䪺�� true
      return true;
     else if(num<N)//�Y�p�� 
      {
       int length = list.size();//list�ثe����
       for(int j=0;j<length;j++)
        {
         int n = num+list.get(j);//�Nlist���ƥ[�J�s��
         if(n==N)//�Y�ŦX true
          return true;
         else if(n<N)//�Y�p�� �[�J
          list.add(n);
        }
       //�j�󪺼Ƥ����~��p��
       list.add(num);//�N�ثe�ƥ[�J
      }
    }
   
   return false;//�Y�䤣�� false
  }      
}