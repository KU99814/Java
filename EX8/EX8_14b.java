//Summing integer use Command Line by ""

public class EX8_14b
{
 public static void main(String args[])
  {
   int sum = 0;

   String[] token = args[0].split(" ");//�H�Ů���j���ƭ�String���}�C

   for(int i=0;i<token.length;i++)//���ۤ@�ӭ��ରint
    sum += Integer.parseInt(token[i]);
   
   System.out.print("The total is "+sum); //���
  }
}