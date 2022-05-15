//Creating an internationalozed calculator
//待完善計算機功能

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.text.NumberFormat;

public class EX31_11 extends JFrame
{
 Display display = new Display();//顯示元件
 AU au = new AU();//計算元件
 KeyPad keyPad = new KeyPad(display,au);//輸入元件
 JComboBox jcboLocale = new JComboBox();//選擇地區
 
 Locale locale = Locale.getDefault();

 Locale locales[] = Calendar.getAvailableLocales();

 //初始化選項
 public void initializeComboBox()
  {
   for(int i=0;i<locales.length;i++)
    {
     jcboLocale.addItem(locales[i].getDisplayName());
    }

   display.setLocale(locale);
  }

 //constructor 
 public EX31_11()
  {
   initializeComboBox();

   //選項事件
   jcboLocale.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     locale = locales[jcboLocale.getSelectedIndex()];
     display.setLocale(locale);
     display.reOutput(au.getNumber());
    }
   });

   //排版
   setLayout(new BorderLayout());
   add(display,BorderLayout.NORTH);
   add(keyPad,BorderLayout.CENTER);
   add(jcboLocale,BorderLayout.SOUTH);
  }

 //顯示介面
 class Display extends JPanel
  {
   private JTextField jtf = new JTextField(10);//顯示欄位
   private Locale locale;//地區
   
   private String output = "0";//顯示文字

   private boolean inputNumAfterOperator = false;

   //constructor
   public Display()
    {
     //設定不可編輯
     jtf.setEditable(false);

     //排版
     setLayout(new FlowLayout());
     add(jtf);
    }

   //設定地區
   public void setLocale(Locale locale)
    {
     this.locale = locale;
    }
   
   //取得顯示文字
   public String getOutput()
    {
     return output;
    }

   public boolean getInputBool()
    {
     return inputNumAfterOperator;
    }

   public void setInputBool(boolean inputBool)
    {
     inputNumAfterOperator = inputBool;
    }

   //設定顯示文字   
   public void setOutput(String output)
    {
     this.output = output;
     jtf.setText(this.output);
    }

   //最終顯示結果
   public void result(double num)
    {
     NumberFormat currencyForm = NumberFormat.getCurrencyInstance(locale);
     
     output = "0";
     jtf.setText(currencyForm.format(num));
    }

   public void reOutput(double num)
    {
     NumberFormat currencyForm = NumberFormat.getCurrencyInstance(locale);
     jtf.setText(currencyForm.format(num));
    }
  }

 //按鈕面板
 class KeyPad extends JPanel
  {
   String[] key = {"0","1","2","3",
                   "4","5","6","7",
                   "8","9","+","-",
                   "*","/","=","R"};

   Display display;//顯示元件
   AU au;          //計算元件

   //constructor
   public KeyPad(Display display,AU au)
    {
     this.display = display;
     this.au = au;

     //排版
     setLayout(new GridLayout(4,4));
     for(int i=0;i<16;i++)
      {
       JButton button = new JButton(key[i]);

       add(button);//加入按鈕

       //加入按鈕事件
       button.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
         String text = button.getText();
         
         //運算子事件
         if(text.equals("+") || text.equals("-") || 
            text.equals("*") || text.equals("/"))
          {
           double num = Double.parseDouble(display.getOutput());
           if(!display.getInputBool())
            {
             au.calcular(num);
             au.setOperator(text.charAt(0));
             display.setOutput("0");
            }
           else
            {
             au.setOperator(text.charAt(0));
            }
          }
         else if(text.equals("="))//等於事件
          {
           double num = Double.parseDouble(display.getOutput());
           au.calcular(num);
           display.result(au.getNumber());
          }
         else if(text.equals("R"))//重設
          {
           au.reset();
           display.setOutput("0");
          }
         else//輸入數字
          {
           double num = Double.parseDouble(text);
           double now = Double.parseDouble(display.getOutput());
           now = now*10 + num;
           String nowText = String.valueOf(now);
           display.setOutput(nowText);
          }
         }
       });
      }
    }
  }

 //計算元件
 class AU
  {
   private double number = 0;//數字
   private char operator = Character.MIN_VALUE;//運算子

   //constructor
   public AU()
    {}

   //取得數字
   public double getNumber()
    {
     return number;
    }

   //重設   
   public void reset()
    {
     number = 0;
     operator = Character.MIN_VALUE;
    }

   //設定運算元
   public void setOperator(char operator)
    {
     this.operator = operator;
    }

   //計算
   public double calcular(double num2)
    {
     switch(operator)
      {
       
       case '+':number +=num2;
                break;
       case '-':number -=num2;
                break;
       case '*':number *=num2;
                break;
       case '/':number /=num2;
                break;
       default:number = num2;
      }

      operator = Character.MIN_VALUE;

      return number;
    }
  }

 public static void main(String args[])
  {
   EX31_11 frame = new EX31_11();//frame
   
   frame.setSize(400,400);//大小
   frame.setTitle("EX31_10");//標題
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉
   frame.setVisible(true);//顯示
  }
}