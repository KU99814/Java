//display subset

import java.util.Scanner;

public class EX20_25
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J
   
   System.out.print("Enter a number n: ");
   int n = input.nextInt();//��J���X�����X�Ӽ�

   System.out.println("The subset of set 1 to "+n+" is: ");//��ܩҦ��l���X
   String[] s = displaySubset(n);//�l���X�}�C
   for(int i=0;i<s.length;i++)//�̰}�C��ܤl���X
    {
     System.out.print("{");
     System.out.print(s[i]);
     System.out.println("}");
    }
  }

 //���j ����l���X
 public static String[] displaySubset(int value)
  {
   if(value==1)//base case
    {
     String[] s  = {"1",""};
     return s;
    }
   else
    {
     String[] s1 = displaySubset(value-1); //����e�@�l��
     String[] s2 = new String[s1.length];//�o�����j��o���s�l��
     for(int i=0;i<s1.length;i++)//�N�e�@�l���U�[1�ƧY�s�l��
      {
       if(s1[i].length()<=0)
        s2[i] = value+"";
       else
        s2[i] = s1[i]+","+value;
      }
     String[] rs = new String[s1.length+s2.length];//�^�ǰ}�C ���ר�̬ۥ[

     //�[�J�s�¨�}�C
     for(int i=0;i<s1.length;i++)
      rs[i] = s1[i];
     for(int i=0;i<s2.length;i++)
      rs[s1.length+i] = s2[i];
 
     //�^��
     return rs;
    }
  }
}