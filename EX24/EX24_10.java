//Converting infix to postfix

import java.util.*;

public class EX24_10
{
 public static void main(String args[])
  {
   if(args.length < 1)
    {
     System.out.println("Usage: java EvaluateExpression expression");//算式輸入錯誤
     System.exit(0);
    }

   String expression = "";//算式字串

   for(int i=0;i<args.length;i++)
    expression += args[i]; //將輸入的字串彙整成一個

   try{
    System.out.println(infixToPostfix(expression));//顯示後敘式算式
   }
   catch(Exception ex){
    System.out.println("Wrong expression");
   }
  }

 //中敘試轉後敘式
 public static String infixToPostfix(String expression)
  {
   Stack<String> operandStack = new Stack<String>();//算式stack 不須運算以string儲存

   Stack<Character> operatorStack = new Stack<Character>();//運算子
   
   java.util.StringTokenizer tokens = new java.util.StringTokenizer(expression,"()+-/*",true);//以運算子分割為複數字串

   //依序處理字串
   while(tokens.hasMoreTokens())
    {
     String token = tokens.nextToken().trim();//省略空格
     
     if(token.length() == 0)//空格不處理
      continue;
     //加減的話 先處理之前的運算子
     else if(token.charAt(0) == '+' || token.charAt(0) == '-')
      {
       while(!operatorStack.isEmpty() &&
             (operatorStack.peek().equals('+') ||
              operatorStack.peek().equals('-') ||
              operatorStack.peek().equals('*') ||
              operatorStack.peek().equals('/')))
        {
         processAnOperator(operandStack,operatorStack);//將數字與運算子結合為後敘式
        }

       operatorStack.push(new Character(token.charAt(0)));//運算子加入operatorStack
      }
     //乘除可以先處理
     else if(token.charAt(0) == '*' || token.charAt(0) == '/')
      {
       //若前面有乘除 前面的先處理
       while(!operatorStack.isEmpty() &&
             (operatorStack.peek().equals('*') ||
              operatorStack.peek().equals('/')))
        {
         processAnOperator(operandStack,operatorStack);//將數字與運算子結合為後敘式
        }
       operatorStack.push(new Character(token.charAt(0)));//運算子加入operatorStack
      }
     //上括號加入stack
     else if(token.trim().charAt(0) == '(')
      operatorStack.push(new Character('('));
     else if(token.trim().charAt(0) == ')')
      {
       //將數字與運算子結合為後敘式 直到上括號
       while(!operatorStack.peek().equals('('))
        {
         processAnOperator(operandStack,operatorStack);
        }

       operatorStack.pop();//上括號排出
      }
     else
      operandStack.push(token);
    }

   //將數字與運算子結合為後敘式 直到運算子stack為空
   while(!operatorStack.isEmpty())
    {
     processAnOperator(operandStack,operatorStack);
    }

   return (String)(operandStack.pop());//回傳結果
  }

 //將算式轉為後敘
 public static void processAnOperator(Stack<String> operandStack,
                                      Stack<Character> operatorStack)
  {
   //加法
   if(operatorStack.peek().equals('+'))
    {
     operatorStack.pop();
     String op1 = (String)(operandStack.pop());//數1
     String op2 = (String)(operandStack.pop());//數2
     operandStack.push((op2+" "+op1)+" + ");//數1 數2 + 放回operandStack
    }
   //減法
   else if(operatorStack.peek().equals('-'))
    {
     operatorStack.pop();
     String op1 = (String)(operandStack.pop());//數1
     String op2 = (String)(operandStack.pop());//數2
     operandStack.push((op2+" "+op1)+" - ");//數1 數2 - 放回operandStack
    }
   //乘
   else if(operatorStack.peek().equals('*'))
    {
     operatorStack.pop();
     String op1 = (String)(operandStack.pop());//數1
     String op2 = (String)(operandStack.pop());//數2
     operandStack.push((op2+" "+op1)+" * ");//數1 數2 * 放回operandStack
    }
   //除
   else if(operatorStack.peek().equals('/'))
    {
     operatorStack.pop();
     String op1 = (String)(operandStack.pop());//數1
     String op2 = (String)(operandStack.pop());//數2
     operandStack.push((op2+" "+op1)+" / ");//數1 數2 / 放回operandStack
    }
  }
}