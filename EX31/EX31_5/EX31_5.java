//Computing loan amortization schedule

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.text.NumberFormat;
import java.util.*;

public class EX31_5 extends JFrame
{
 private JTextField jtfLoanAmount = new JTextField(5);//��J�ɿ��ƥ�
 private JTextField jtfNumberOfYears = new JTextField(5);//�~��
 private JTextField jtfAnnualInterestRate = new JTextField(5);//�~�Q��

 private JButton jbtDisplay = new JButton("Display Loan Schedule");//���s �}�l�p��

 private JTextArea jtaDisplay = new JTextArea();//��ܰ�

 public EX31_5()
  {
   //��Jpanel
   JPanel p1_1 = new JPanel(new GridLayout(3,2));
   p1_1.add(new JLabel("Loan Amount"));
   p1_1.add(jtfLoanAmount);
   p1_1.add(new JLabel("Number Of Years"));
   p1_1.add(jtfNumberOfYears);
   p1_1.add(new JLabel("Annual Interest Rate"));
   p1_1.add(jtfAnnualInterestRate);
   p1_1.setBorder(new TitledBorder("Enter Loan Amount,Number of Years"+
                        ",and Annual Interest Rate"));
   
   //��X��J
   JPanel p1 = new JPanel(new GridLayout(1,2));   
   p1.add(p1_1);
   p1.add(jbtDisplay);

   JScrollPane jsp = new JScrollPane(jtaDisplay);//�ƶb
   
   //���Panel
   JPanel p2 = new JPanel(new BorderLayout());
   p2.add(jsp,BorderLayout.CENTER);

   setLayout(new BorderLayout());

   add(p1,BorderLayout.NORTH);
   add(p2,BorderLayout.CENTER);

   //���s
   jbtDisplay.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){

     //�p��Q��
     double rate =  Integer.parseInt(jtfAnnualInterestRate.getText());    
     int year = Integer.parseInt(jtfNumberOfYears.getText());  
     double loanAmount = Double.parseDouble(jtfLoanAmount.getText());   

     double w = Math.pow((1+(rate/12/100)),(12*year)); //����ƼW�[���Q�v
     double month = ((rate/12/100)*loanAmount*w)/(w - 1); //�H�Q�v�p��C���`�B
     double total = month*12*year; //�`���

     double monthlyInterestRate = rate/12; 

     double balance = loanAmount;   
  
     //�ഫ���Φ�
     NumberFormat currencyForm = NumberFormat.getCurrencyInstance(Locale.US);    
 
     StringBuilder str = new StringBuilder();

     //�ର����
     String monthFormat = currencyForm.format(month);
     String paymentFormat = currencyForm.format(total);
     str.append("Monthly Payment: "+monthFormat +"\n");//��ܤ��~
     str.append("Total Payment: "+paymentFormat +"\n\n"); //����`�~

     str.append("Payment#\tInterest\tPrincipal\tBalance\n");
     //�p��
     for(int pay = 1;pay <= year*12;pay++)
      {
       double Interest = (monthlyInterestRate*balance*100)/100/100;
       balance -= (month-Interest);
       double principal = (month-Interest);
      
       //��X�ର����
       String interestFormat = currencyForm.format(Interest);
       String principleFormat = currencyForm.format(principal);
       String balanceFormat = currencyForm.format(balance);
       str.append(pay+"\t"+interestFormat +"\t"+principleFormat 
                  +"\t"+balanceFormat +" \n");
      }
     
     jtaDisplay.setText(str.toString());
    }
   });
  }

 public static void main(String args[])
  {
   EX31_5 frame = new EX31_5();//frame
   frame.setTitle("EX31_5");//���D
   frame.setSize(500,500);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);
  }
}