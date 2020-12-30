//Game:the 24-card game
//����ܪ��Ʀr���X�⦡

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.*;

public class EX24_7 extends JFrame
{
 private JButton jbRefresh = new JButton("Refresh"); //��s��
 private JButton jbVerify = new JButton("Verify"); //�T�{��
 
 //�d���Ϥ�
 private static ImageIcon[] numberIcon = new ImageIcon[4];
 private JLabel[] jlbimageView = new JLabel[4];
 static int[] number = new int[4];

 //��J�⦡
 private JTextField jtfExpression = new JTextField(12);

 //�T�{�Ʀr�O�_�]�t
 static boolean isContain = false;

 public EX24_7()
  {
   JPanel p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT,10,20));//��s���spanel
   JPanel p2 = new JPanel(new GridLayout(1,4,5,5));//��ܼ��J�Ppanel
   JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT,10,20));

   setLayout(new BorderLayout());//�]�w�ƪ�
   
   //�N�����J��s���spanel
   p1.add(new JLabel("corrent answer must be 24"));
   p1.add(jbRefresh);

   //��s���s�ƥ�
   jbRefresh.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
      for(int i=0;i<4;i++)
       {
        getNumber(i);//���o�Ʀr
        jlbimageView[i].setIcon(numberIcon[i]);//��ܼ��J�P
       }
     }
    });

   //��l����ܼ��J�P
   for(int i=0;i<4;i++)
    {
     getNumber(i);
     jlbimageView[i] = new JLabel(numberIcon[i]);
     p2.add(jlbimageView[i]);
    }

   ////�N�����J��J�⦡panel
   p3.add(new JLabel("Enter an expression:"));
   p3.add(jtfExpression);
   p3.add(jbVerify);

   //�T�{���s�ƥ�
   jbVerify.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     String expression = jtfExpression.getText();//���o�⦡
     
     try{
      int answer = evaluateExpression(expression);//�p�⵪��
      if(isContain)//�T�{�Ʀr�O�_�����Ψ�
       {
        //�T�{���׬O�_���T
        if(answer == 24)
         JOptionPane.showMessageDialog(null,"this is corrent");
        else
         JOptionPane.showMessageDialog(null,"this is false");
       }
      else
       JOptionPane.showMessageDialog(null,"�Ʀr���X");
     }
     catch(Exception ex){
      JOptionPane.showMessageDialog(null,"�⦡���~");//�⦡���~�ҥ~
     }
    }
   });
  
   //�Npanel��X
   add(p1,BorderLayout.NORTH);
   add(p2,BorderLayout.CENTER);
   add(p3,BorderLayout.SOUTH);
  }

 public static void main(String args[])
  {
   EX24_7 frame = new EX24_7();//�ŧiframe
   frame.setTitle("EX24_7");//���D
   frame.setSize(400,300);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����
   frame.setVisible(true);//���
  }

 //���o���J�P
 public static void getNumber(int i)
  {
   //�M�w�Ʀr �T�O������
   while(true)
    {
     boolean ok = true;
     number[i] = (int)(Math.random()*52+1);//�H���M�w
     for(int j=0;j<i;j++)
      {
       if(number[i]==number[j])//�ˬd�O�_����
        {
         ok = false;
         break;
        }
      }
     
     if(ok)//�Y�����Ƨ@�U�@�B
      break;
    }

   numberIcon[i] = new ImageIcon("card/"+number[i]+".png");//���o�Ϥ�

   number[i] %=13;//�Ϥ��N���Ʀr
   if(number[i]==0)
    number[i] = 13;
  }

 //�⦡�B��
 public static int evaluateExpression(String expression)
  {
   Stack<Integer> operandStack = new Stack<Integer>();//�Ʀrstack

   Stack<Character> operatorStack = new Stack<Character>();//�A���B�B��lstack

      
   java.util.StringTokenizer tokens = new java.util.StringTokenizer(expression,"()+-/*",true);//�⦡���j

   //
   while(tokens.hasMoreTokens())
    {
     String token = tokens.nextToken().trim();//�ثe�r��
     
     if(token.length() == 0)//�Y���Ů� ���L
      continue;
     else if(token.charAt(0) == '+' || token.charAt(0) == '-')//�[��� ���@�e�@�ӹB��l���B��
      {
       while(!operatorStack.isEmpty() &&
             (operatorStack.peek().equals('+') ||
              operatorStack.peek().equals('-') ||
              operatorStack.peek().equals('*') ||
              operatorStack.peek().equals('/')))
        {
         processAnOperator(operandStack,operatorStack);//�i��B��
        }

       operatorStack.push(new Character(token.charAt(0)));//�r����J�B��lstack
      }
     else if(token.charAt(0) == '*' || token.charAt(0) == '/')//�������ܬݤ��e�O�_�������B��n���@
      {
       while(!operatorStack.isEmpty() &&
             (operatorStack.peek().equals('*') ||
              operatorStack.peek().equals('/')))
        {
         processAnOperator(operandStack,operatorStack);//�i��B��
        }
       operatorStack.push(new Character(token.charAt(0)));//�r����J�B��lstack
      }
     //�A�����n�u���B��
     else if(token.trim().charAt(0) == '(')
      operatorStack.push(new Character('('));//�W�A����Jstack
     else if(token.trim().charAt(0) == ')')//�U�A���@��W�A������B��
      {
       while(!operatorStack.peek().equals('('))
        {
         processAnOperator(operandStack,operatorStack);
        }

       operatorStack.pop();//�ƥX�W�A��
      }
     else//��L�Ʀr
      {
       isContain = false;//�P�_�O�_�]�t�Ҧ��Ʀr
       operandStack.push(new Integer(token));//��Jstack
       int op = ((Integer)(operandStack.peek())).intValue();
       for(int i=0;i<4;i++)//�}�C�v�Ӥ��
        {
         if(number[i] == op)
          isContain = true;
        }
       if(!isContain)//�Y���w�Q�~���Ʀr ���X
        {
         return 0;
        }
      }
    }

   //�i��ѤU���B��
   while(!operatorStack.isEmpty())
    {
     processAnOperator(operandStack,operatorStack);
    }

   return ((Integer)(operandStack.pop())).intValue();//�^�ǵ���
  }

 //�|�h�B�� �ϥΨ��stack
 public static void processAnOperator(Stack<Integer> operandStack,
                                      Stack<Character> operatorStack)
  {
   //�B���Ʀr��^operandStack
   //�[�k
   if(operatorStack.peek().equals('+'))
    {
     operatorStack.pop();
     int op1 = ((Integer)(operandStack.pop())).intValue();
     int op2 = ((Integer)(operandStack.pop())).intValue();
     operandStack.push(new Integer(op2+op1));
    }
   //��k
   else if(operatorStack.peek().equals('-'))
    {
     operatorStack.pop();
     int op1 = ((Integer)(operandStack.pop())).intValue();
     int op2 = ((Integer)(operandStack.pop())).intValue();
     operandStack.push(new Integer(op2-op1));
    }
   //���k
   else if(operatorStack.peek().equals('*'))
    {
     operatorStack.pop();
     int op1 = ((Integer)(operandStack.pop())).intValue();
     int op2 = ((Integer)(operandStack.pop())).intValue();
     operandStack.push(new Integer(op2*op1));
    }
   //���k
   else if(operatorStack.peek().equals('/'))
    {
     operatorStack.pop();
     int op1 = ((Integer)(operandStack.pop())).intValue();
     int op2 = ((Integer)(operandStack.pop())).intValue();
     operandStack.push(new Integer(op2/op1));
    }
  }
}