//Converting infix to postfix

import java.util.*;

public class EX24_10
{
 public static void main(String args[])
  {
   if(args.length < 1)
    {
     System.out.println("Usage: java EvaluateExpression expression");//�⦡��J���~
     System.exit(0);
    }

   String expression = "";//�⦡�r��

   for(int i=0;i<args.length;i++)
    expression += args[i]; //�N��J���r��J�㦨�@��

   try{
    System.out.println(infixToPostfix(expression));//��ܫ�Ԧ��⦡
   }
   catch(Exception ex){
    System.out.println("Wrong expression");
   }
  }

 //���Ը����Ԧ�
 public static String infixToPostfix(String expression)
  {
   Stack<String> operandStack = new Stack<String>();//�⦡stack �����B��Hstring�x�s

   Stack<Character> operatorStack = new Stack<Character>();//�B��l
   
   java.util.StringTokenizer tokens = new java.util.StringTokenizer(expression,"()+-/*",true);//�H�B��l���ά��ƼƦr��

   //�̧ǳB�z�r��
   while(tokens.hasMoreTokens())
    {
     String token = tokens.nextToken().trim();//�ٲ��Ů�
     
     if(token.length() == 0)//�Ů椣�B�z
      continue;
     //�[��� ���B�z���e���B��l
     else if(token.charAt(0) == '+' || token.charAt(0) == '-')
      {
       while(!operatorStack.isEmpty() &&
             (operatorStack.peek().equals('+') ||
              operatorStack.peek().equals('-') ||
              operatorStack.peek().equals('*') ||
              operatorStack.peek().equals('/')))
        {
         processAnOperator(operandStack,operatorStack);//�N�Ʀr�P�B��l���X����Ԧ�
        }

       operatorStack.push(new Character(token.charAt(0)));//�B��l�[�JoperatorStack
      }
     //�����i�H���B�z
     else if(token.charAt(0) == '*' || token.charAt(0) == '/')
      {
       //�Y�e�������� �e�������B�z
       while(!operatorStack.isEmpty() &&
             (operatorStack.peek().equals('*') ||
              operatorStack.peek().equals('/')))
        {
         processAnOperator(operandStack,operatorStack);//�N�Ʀr�P�B��l���X����Ԧ�
        }
       operatorStack.push(new Character(token.charAt(0)));//�B��l�[�JoperatorStack
      }
     //�W�A���[�Jstack
     else if(token.trim().charAt(0) == '(')
      operatorStack.push(new Character('('));
     else if(token.trim().charAt(0) == ')')
      {
       //�N�Ʀr�P�B��l���X����Ԧ� ����W�A��
       while(!operatorStack.peek().equals('('))
        {
         processAnOperator(operandStack,operatorStack);
        }

       operatorStack.pop();//�W�A���ƥX
      }
     else
      operandStack.push(token);
    }

   //�N�Ʀr�P�B��l���X����Ԧ� ����B��lstack����
   while(!operatorStack.isEmpty())
    {
     processAnOperator(operandStack,operatorStack);
    }

   return (String)(operandStack.pop());//�^�ǵ��G
  }

 //�N�⦡�ର���
 public static void processAnOperator(Stack<String> operandStack,
                                      Stack<Character> operatorStack)
  {
   //�[�k
   if(operatorStack.peek().equals('+'))
    {
     operatorStack.pop();
     String op1 = (String)(operandStack.pop());//��1
     String op2 = (String)(operandStack.pop());//��2
     operandStack.push((op2+" "+op1)+" + ");//��1 ��2 + ��^operandStack
    }
   //��k
   else if(operatorStack.peek().equals('-'))
    {
     operatorStack.pop();
     String op1 = (String)(operandStack.pop());//��1
     String op2 = (String)(operandStack.pop());//��2
     operandStack.push((op2+" "+op1)+" - ");//��1 ��2 - ��^operandStack
    }
   //��
   else if(operatorStack.peek().equals('*'))
    {
     operatorStack.pop();
     String op1 = (String)(operandStack.pop());//��1
     String op2 = (String)(operandStack.pop());//��2
     operandStack.push((op2+" "+op1)+" * ");//��1 ��2 * ��^operandStack
    }
   //��
   else if(operatorStack.peek().equals('/'))
    {
     operatorStack.pop();
     String op1 = (String)(operandStack.pop());//��1
     String op2 = (String)(operandStack.pop());//��2
     operandStack.push((op2+" "+op1)+" / ");//��1 ��2 / ��^operandStack
    }
  }
}