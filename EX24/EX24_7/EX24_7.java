//Game:the 24-card game
//用顯示的數字拼出算式

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.*;

public class EX24_7 extends JFrame
{
 private JButton jbRefresh = new JButton("Refresh"); //刷新紐
 private JButton jbVerify = new JButton("Verify"); //確認紐
 
 //卡片圖片
 private static ImageIcon[] numberIcon = new ImageIcon[4];
 private JLabel[] jlbimageView = new JLabel[4];
 static int[] number = new int[4];

 //輸入算式
 private JTextField jtfExpression = new JTextField(12);

 //確認數字是否包含
 static boolean isContain = false;

 public EX24_7()
  {
   JPanel p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT,10,20));//刷新按鈕panel
   JPanel p2 = new JPanel(new GridLayout(1,4,5,5));//顯示撲克牌panel
   JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT,10,20));

   setLayout(new BorderLayout());//設定排版
   
   //將元件放入刷新按鈕panel
   p1.add(new JLabel("corrent answer must be 24"));
   p1.add(jbRefresh);

   //刷新按鈕事件
   jbRefresh.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
      for(int i=0;i<4;i++)
       {
        getNumber(i);//取得數字
        jlbimageView[i].setIcon(numberIcon[i]);//顯示撲克牌
       }
     }
    });

   //初始化顯示撲克牌
   for(int i=0;i<4;i++)
    {
     getNumber(i);
     jlbimageView[i] = new JLabel(numberIcon[i]);
     p2.add(jlbimageView[i]);
    }

   ////將元件放入輸入算式panel
   p3.add(new JLabel("Enter an expression:"));
   p3.add(jtfExpression);
   p3.add(jbVerify);

   //確認按鈕事件
   jbVerify.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     String expression = jtfExpression.getText();//取得算式
     
     try{
      int answer = evaluateExpression(expression);//計算答案
      if(isContain)//確認數字是否都有用到
       {
        //確認答案是否正確
        if(answer == 24)
         JOptionPane.showMessageDialog(null,"this is corrent");
        else
         JOptionPane.showMessageDialog(null,"this is false");
       }
      else
       JOptionPane.showMessageDialog(null,"數字不合");
     }
     catch(Exception ex){
      JOptionPane.showMessageDialog(null,"算式錯誤");//算式錯誤例外
     }
    }
   });
  
   //將panel整合
   add(p1,BorderLayout.NORTH);
   add(p2,BorderLayout.CENTER);
   add(p3,BorderLayout.SOUTH);
  }

 public static void main(String args[])
  {
   EX24_7 frame = new EX24_7();//宣告frame
   frame.setTitle("EX24_7");//標題
   frame.setSize(400,300);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉
   frame.setVisible(true);//顯示
  }

 //取得撲克牌
 public static void getNumber(int i)
  {
   //決定數字 確保不重複
   while(true)
    {
     boolean ok = true;
     number[i] = (int)(Math.random()*52+1);//隨機決定
     for(int j=0;j<i;j++)
      {
       if(number[i]==number[j])//檢查是否重複
        {
         ok = false;
         break;
        }
      }
     
     if(ok)//若不重複作下一步
      break;
    }

   numberIcon[i] = new ImageIcon("card/"+number[i]+".png");//取得圖片

   number[i] %=13;//圖片代表的數字
   if(number[i]==0)
    number[i] = 13;
  }

 //算式運算
 public static int evaluateExpression(String expression)
  {
   Stack<Integer> operandStack = new Stack<Integer>();//數字stack

   Stack<Character> operatorStack = new Stack<Character>();//括號、運算子stack

      
   java.util.StringTokenizer tokens = new java.util.StringTokenizer(expression,"()+-/*",true);//算式分隔

   //
   while(tokens.hasMoreTokens())
    {
     String token = tokens.nextToken().trim();//目前字元
     
     if(token.length() == 0)//若為空格 跳過
      continue;
     else if(token.charAt(0) == '+' || token.charAt(0) == '-')//加減的話 先作前一個運算子的運算
      {
       while(!operatorStack.isEmpty() &&
             (operatorStack.peek().equals('+') ||
              operatorStack.peek().equals('-') ||
              operatorStack.peek().equals('*') ||
              operatorStack.peek().equals('/')))
        {
         processAnOperator(operandStack,operatorStack);//進行運算
        }

       operatorStack.push(new Character(token.charAt(0)));//字元放入運算子stack
      }
     else if(token.charAt(0) == '*' || token.charAt(0) == '/')//乘除的話看之前是否有乘除運算要先作
      {
       while(!operatorStack.isEmpty() &&
             (operatorStack.peek().equals('*') ||
              operatorStack.peek().equals('/')))
        {
         processAnOperator(operandStack,operatorStack);//進行運算
        }
       operatorStack.push(new Character(token.charAt(0)));//字元放入運算子stack
      }
     //括號內要優先運算
     else if(token.trim().charAt(0) == '(')
      operatorStack.push(new Character('('));//上括號放入stack
     else if(token.trim().charAt(0) == ')')//下括號作到上括號為止的運算
      {
       while(!operatorStack.peek().equals('('))
        {
         processAnOperator(operandStack,operatorStack);
        }

       operatorStack.pop();//排出上括號
      }
     else//其他數字
      {
       isContain = false;//判斷是否包含所有數字
       operandStack.push(new Integer(token));//放入stack
       int op = ((Integer)(operandStack.peek())).intValue();
       for(int i=0;i<4;i++)//陣列逐個比較
        {
         if(number[i] == op)
          isContain = true;
        }
       if(!isContain)//若有預想外的數字 跳出
        {
         return 0;
        }
      }
    }

   //進行剩下的運算
   while(!operatorStack.isEmpty())
    {
     processAnOperator(operandStack,operatorStack);
    }

   return ((Integer)(operandStack.pop())).intValue();//回傳答案
  }

 //四則運算 使用兩個stack
 public static void processAnOperator(Stack<Integer> operandStack,
                                      Stack<Character> operatorStack)
  {
   //運算後數字放回operandStack
   //加法
   if(operatorStack.peek().equals('+'))
    {
     operatorStack.pop();
     int op1 = ((Integer)(operandStack.pop())).intValue();
     int op2 = ((Integer)(operandStack.pop())).intValue();
     operandStack.push(new Integer(op2+op1));
    }
   //減法
   else if(operatorStack.peek().equals('-'))
    {
     operatorStack.pop();
     int op1 = ((Integer)(operandStack.pop())).intValue();
     int op2 = ((Integer)(operandStack.pop())).intValue();
     operandStack.push(new Integer(op2-op1));
    }
   //乘法
   else if(operatorStack.peek().equals('*'))
    {
     operatorStack.pop();
     int op1 = ((Integer)(operandStack.pop())).intValue();
     int op2 = ((Integer)(operandStack.pop())).intValue();
     operandStack.push(new Integer(op2*op1));
    }
   //除法
   else if(operatorStack.peek().equals('/'))
    {
     operatorStack.pop();
     int op1 = ((Integer)(operandStack.pop())).intValue();
     int op2 = ((Integer)(operandStack.pop())).intValue();
     operandStack.push(new Integer(op2/op1));
    }
  }
}