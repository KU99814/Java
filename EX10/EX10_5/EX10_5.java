import java.util.*;

public class EX10_5
{
 public static void main(String args[])
  {
   MyStack stack1 = new MyStack(); //宣告MyStack1 存放數字
   MyStack stack2 = new MyStack(); //宣告MyStack2 //存放運算符號

   Scanner input = new Scanner(System.in); //宣告輸入

   System.out.print("輸入算式，輸入等號開始運算: ");
   
   while(true)                        //輸入算式
    {     
     stack1.push(input.nextInt());     //輸入數字
     String peek = "";
     if(!stack2.isEmpty())//檢查運算子
      peek = ((String)stack2.peek());

     //因為先乘除後加減 遇到乘除先運算     
     boolean signM = peek.equals("*");
     boolean signD = peek.equals("/");

     if((signM || signD) && stack1.getSize() > stack2.getSize())//若是乘除且數字都有
      {
       //根據乘除進行運算
       if(signM)//乘
        {
         stack2.pop();//取出運算子
         int p1= ((Integer)stack1.pop()).intValue(); //取出數字
         int p2= ((Integer)stack1.pop()).intValue();
      
         int num = p1*p2;//計算
         stack1.push(num);     //將數字放回
        }
      
       if(signD)//除
        {
         stack2.pop(); 
         int p1= ((Integer)stack1.pop()).intValue();      //轉換
         int p2= ((Integer)stack1.pop()).intValue();
       
         int num = p2/p1;//因為stack先進後出 後出的數字要放在前面
         stack1.push(num);     //將數字放回
        }
      }

     stack2.push(input.next());        //輸入運算元　+ - * /
     if(((String)stack2.peek()).equals("="))      //輸入等號停止
      break;
    }
   stack2.pop();  //排除等號

   //因為加減要按照順序 將stack內的數字倒出來
   MyStack stack3 = new MyStack(); //宣告MyStack3 用來放置數字

   while(stack1.getSize()!=0)//將數字放入
    {
     stack3.push(stack1.pop());
    }

   while(stack2.getSize()!=0)//將運算子也倒到stack1
    {
     stack1.push(stack2.pop());
    }

   while(stack3.getSize() > 1)//計算 直到剩下一個數字
    {
     String pop = ((String)stack1.pop());
     boolean signP = pop.equals("+");
     boolean signS = pop.equals("-");
       
     if(signP)
      {        
       int p1= ((Integer)stack3.pop()).intValue();      //轉換
       int p2= ((Integer)stack3.pop()).intValue();
      
       int num = p1+p2;
       stack3.push(num);     //輸入數字
      }
      
     if(signS)
      {
       int p1= ((Integer)stack3.pop()).intValue();      //轉換
       int p2= ((Integer)stack3.pop()).intValue();
      
       int num = p1-p2;
        System.out.println(num);
       stack3.push(num);     //輸入數字        
      }
    }
     
   System.out.print("the result is "+stack3.pop());              //顯示結果
  }
}