//using tabbed pane 2

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.regex.*;

public class EX33_7 extends JFrame
{
 private JTabbedPane jtpOperation = new JTabbedPane();//改為分頁
 private CardLayout cardLayout = new CardLayout(20,10);
 private JPanel cardPanel = new JPanel(cardLayout);

 //輸入數字 
 //整數
 private JTextField jtfNum1 = new JTextField(5);
 private JTextField jtfNum2 = new JTextField(5);
 private JTextField jtfResult = new JTextField(5);//顯示結果
 
 //分數
 private JTextField jtfRationNum1 = new JTextField(5);
 private JTextField jtfRationNum2 = new JTextField(5);
 private JTextField jtfRationResult = new JTextField(5);//顯示結果

 //運算按鈕
 private JButton jbAdd = new JButton("Add");
 private JButton jbSubtract = new JButton("Subtract");
 private JButton jbMultiply = new JButton("Multiply");
 private JButton jbDivide = new JButton("Divide");

 private JLabel title = new JLabel("Integer Operation");

 //數字類別
 private final int INTEGER = 0;
 private final int RATION = 1;

 private int type = INTEGER;

 public EX33_7()
  {
   jtfResult.setEditable(false);
   jtfRationResult.setEditable(false);

   JPanel pTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
   pTitle.add(new JLabel("Integer Operation"));

   JPanel pInteger = new JPanel(new BorderLayout());
   JPanel pRation = new JPanel(new BorderLayout());   

   JPanel pInputInteger = new JPanel();
   pInputInteger.add(new JLabel("Number 1"));
   pInputInteger.add(jtfNum1);
   pInputInteger.add(new JLabel("Number 2"));
   pInputInteger.add(jtfNum2);
   pInputInteger.add(new JLabel("Result"));
   pInputInteger.add(jtfResult);

   JPanel pInputRation = new JPanel();
   pInputRation.add(new JLabel("Number 1"));
   pInputRation.add(jtfRationNum1);
   pInputRation.add(new JLabel("Number 2"));
   pInputRation.add(jtfRationNum2);
   pInputRation.add(new JLabel("Result"));
   pInputRation.add(jtfRationResult);

   pInteger.add(new JLabel("Integer Operation"),BorderLayout.NORTH);
   pInteger.add(pInputInteger,BorderLayout.CENTER);

   pRation.add(new JLabel("Rational Operation"),BorderLayout.NORTH);
   pRation.add(pInputRation,BorderLayout.CENTER);

   jtpOperation.add(pInteger,"Integer Operation");
   jtpOperation.add(pRation,"Rational Operation");

   JPanel pClickOperation = new JPanel();
   pClickOperation.add(jbAdd);
   pClickOperation.add(jbSubtract);
   pClickOperation.add(jbMultiply);
   pClickOperation.add(jbDivide);
   
   setLayout(new BorderLayout());
   add(jtpOperation,BorderLayout.CENTER);
   add(pClickOperation,BorderLayout.SOUTH);
   
   EventListener opEvent = new EventListener();
   jbAdd.addActionListener(opEvent);
   jbSubtract.addActionListener(opEvent);
   jbMultiply.addActionListener(opEvent);
   jbDivide.addActionListener(opEvent);
  }

 //輸入事件
 private class EventListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     String op = e.getActionCommand();

     if(jtpOperation.getSelectedIndex()==INTEGER)
      {     
       Pattern pattern = Pattern.compile("^[0-9]*$");//比較字串是否是數字

       //轉換字串為數字
       int num1 = 0;
       String num1Str = jtfNum1.getText();
       if(pattern.matcher(num1Str).matches() && !num1Str.equals(""))
        num1 = Integer.parseInt(num1Str);
       int num2 = 0;
       String num2Str = jtfNum2.getText();
       if(pattern.matcher(num2Str).matches() && !num2Str.equals(""))
        num2 = Integer.parseInt(num2Str);

       //根據按鍵決定操作
       if(op.equals("Add"))
        {
         int result = num1 + num2;

         jtfResult.setText(result+"");
        }
       else if(op.equals("Subtract"))
        {
         int result = num1 - num2;

         jtfResult.setText(result+"");
        }
       else if(op.equals("Multiply"))
        {
         int result = num1 * num2;

         jtfResult.setText(result+"");
        }
       else if(op.equals("Divide"))
        {
         if(num2 == 0)
          {
           jtfResult.setText("illegal");
          }
         else
          {
           int result = num1 / num2;

           jtfResult.setText(result+"");
          }
        }
      }
     else
      {        
       //轉換字串為分數
       Rational numRation1 = new Rational();
       String num1RationStr = jtfRationNum1.getText();
       if(checkRation(num1RationStr) && !num1RationStr.equals(""))
        {
         String[] nums = num1RationStr.split("/");
         int numerator = Integer.parseInt(nums[0]);
         int denominator = Integer.parseInt(nums[1]);
         if(denominator!=0)
          {
           numRation1 = new Rational(numerator,denominator);
          }
        }
       Rational numRation2 = new Rational();
       String num2RationStr = jtfRationNum2.getText();
       if(checkRation(num2RationStr) && !num2RationStr.equals(""))
        {
         String[] nums = num2RationStr.split("/");
         int numerator = Integer.parseInt(nums[0]);
         int denominator = Integer.parseInt(nums[1]);
         if(denominator!=0)
          {
           numRation2 = new Rational(numerator,denominator);
          }
        }

       //根據按鍵決定操作
       if(op.equals("Add"))
        {
         Rational result = numRation1.add(numRation2);

         jtfRationResult.setText(result.toString());
        }
       else if(op.equals("Subtract"))
        {
         Rational result = numRation1.subtract(numRation2);

         jtfRationResult.setText(result.toString());
        }
       else if(op.equals("Multiply"))
        {
         Rational result = numRation1.multiply(numRation2);

         jtfRationResult.setText(result.toString());
        }
       else if(op.equals("Divide"))
        {
         Rational result = numRation1.divide(numRation2);

         jtfRationResult.setText(result.toString());
        }  
      }
    }
  }

 //判斷是否分數
 public boolean checkRation(String rationNum)
  {
   String[] nums = rationNum.split("/");//以除數區分 分數的話會分出兩個字串
   if(nums.length!=2)
    return false;
   
   //判斷分出的字串是否整數
   Pattern pattern = Pattern.compile("^[0-9]*$");//比較字串是否是數字

   if(!pattern.matcher(nums[0]).matches() || !pattern.matcher(nums[1]).matches())
    {
     return false;
    }

   return true;
  }

 public static void main(String args[])
  {
   EX33_7 frame = new EX33_7();
   
   frame.setTitle("EX33_7");//標題
   frame.setSize(550,200);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}
