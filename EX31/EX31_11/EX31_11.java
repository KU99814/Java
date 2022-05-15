//Creating an internationalozed calculator
//�ݧ����p����\��

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.text.NumberFormat;

public class EX31_11 extends JFrame
{
 Display display = new Display();//��ܤ���
 AU au = new AU();//�p�⤸��
 KeyPad keyPad = new KeyPad(display,au);//��J����
 JComboBox jcboLocale = new JComboBox();//��ܦa��
 
 Locale locale = Locale.getDefault();

 Locale locales[] = Calendar.getAvailableLocales();

 //��l�ƿﶵ
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

   //�ﶵ�ƥ�
   jcboLocale.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     locale = locales[jcboLocale.getSelectedIndex()];
     display.setLocale(locale);
     display.reOutput(au.getNumber());
    }
   });

   //�ƪ�
   setLayout(new BorderLayout());
   add(display,BorderLayout.NORTH);
   add(keyPad,BorderLayout.CENTER);
   add(jcboLocale,BorderLayout.SOUTH);
  }

 //��ܤ���
 class Display extends JPanel
  {
   private JTextField jtf = new JTextField(10);//������
   private Locale locale;//�a��
   
   private String output = "0";//��ܤ�r

   private boolean inputNumAfterOperator = false;

   //constructor
   public Display()
    {
     //�]�w���i�s��
     jtf.setEditable(false);

     //�ƪ�
     setLayout(new FlowLayout());
     add(jtf);
    }

   //�]�w�a��
   public void setLocale(Locale locale)
    {
     this.locale = locale;
    }
   
   //���o��ܤ�r
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

   //�]�w��ܤ�r   
   public void setOutput(String output)
    {
     this.output = output;
     jtf.setText(this.output);
    }

   //�̲���ܵ��G
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

 //���s���O
 class KeyPad extends JPanel
  {
   String[] key = {"0","1","2","3",
                   "4","5","6","7",
                   "8","9","+","-",
                   "*","/","=","R"};

   Display display;//��ܤ���
   AU au;          //�p�⤸��

   //constructor
   public KeyPad(Display display,AU au)
    {
     this.display = display;
     this.au = au;

     //�ƪ�
     setLayout(new GridLayout(4,4));
     for(int i=0;i<16;i++)
      {
       JButton button = new JButton(key[i]);

       add(button);//�[�J���s

       //�[�J���s�ƥ�
       button.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
         String text = button.getText();
         
         //�B��l�ƥ�
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
         else if(text.equals("="))//����ƥ�
          {
           double num = Double.parseDouble(display.getOutput());
           au.calcular(num);
           display.result(au.getNumber());
          }
         else if(text.equals("R"))//���]
          {
           au.reset();
           display.setOutput("0");
          }
         else//��J�Ʀr
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

 //�p�⤸��
 class AU
  {
   private double number = 0;//�Ʀr
   private char operator = Character.MIN_VALUE;//�B��l

   //constructor
   public AU()
    {}

   //���o�Ʀr
   public double getNumber()
    {
     return number;
    }

   //���]   
   public void reset()
    {
     number = 0;
     operator = Character.MIN_VALUE;
    }

   //�]�w�B�⤸
   public void setOperator(char operator)
    {
     this.operator = operator;
    }

   //�p��
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
   
   frame.setSize(400,400);//�j�p
   frame.setTitle("EX31_10");//���D
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����
   frame.setVisible(true);//���
  }
}