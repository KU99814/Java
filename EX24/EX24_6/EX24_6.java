//Matching grouping symbols
//�޸������A�����~ ���M�S���D ���o�{���|����

import java.util.*;
import java.io.*;

public class EX24_6
{
 public static void main(String args[]) throws Exception
  {
   File fileIn = new File(args[0]);//Ū���ɮ�

   Scanner input = new Scanner(fileIn);//�ŧi�ɮ׿�J

   Stack<Character> operatorUpperStack = new Stack<Character>();//��J�A��stack

   boolean isError = false;//�P�_�O�_�X��

   char[] operator = {'{','(','[','}',')',']'};//�A���}�C

   //�j��v��Ū��
   while(input.hasNext())
    {
     String token = input.nextLine();//Ū���@��r
     
     //�v�r���
     for(int i=0;i<token.length();i++)
      { 
       int index = -1;//�������A����index �A���H�~��-1
       for(int j=0;j<operator.length;j++)
        {
         if(token.charAt(i) == operator[j])
          {
           index = j;
           break;
          } 
        }

       if(index<3 && index>=0)//�p�G�O�W�A��
        operatorUpperStack.push(token.charAt(i));
       else if(index >=3)//�p�G�O�U�A��
        {
         if(operatorUpperStack.peek().equals(operator[index-3]))//�P�_�ثe���� �O�_�������W�A��
          operatorUpperStack.pop();
         else//�Y�_ ��ܿ��~�ø��XŪ�r�j��
          {
           isError = true;
           break;
          }
        }
      }
     if(isError)//�Y�����~ ���XŪ���j��
      break;
    }

   if(!operatorUpperStack.isEmpty())//�Ystack�w�M�� ��ܥ��T
    {
     System.out.println("This code is illegal");
    }
   else//�Y�_ ��ܿ��~
    System.out.println("This code is correct");
  }
}