//Computing loan amortization schedule

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.text.NumberFormat;
import java.util.*;

public class EX31_5 extends JFrame
{
 private JTextField jtfLoanAmount = new JTextField(5);//輸入借錢數目
 private JTextField jtfNumberOfYears = new JTextField(5);//年數
 private JTextField jtfAnnualInterestRate = new JTextField(5);//年利息

 private JButton jbtDisplay = new JButton("Display Loan Schedule");//按鈕 開始計算

 private JTextArea jtaDisplay = new JTextArea();//顯示區

 public EX31_5()
  {
   //輸入panel
   JPanel p1_1 = new JPanel(new GridLayout(3,2));
   p1_1.add(new JLabel("Loan Amount"));
   p1_1.add(jtfLoanAmount);
   p1_1.add(new JLabel("Number Of Years"));
   p1_1.add(jtfNumberOfYears);
   p1_1.add(new JLabel("Annual Interest Rate"));
   p1_1.add(jtfAnnualInterestRate);
   p1_1.setBorder(new TitledBorder("Enter Loan Amount,Number of Years"+
                        ",and Annual Interest Rate"));
   
   //整合輸入
   JPanel p1 = new JPanel(new GridLayout(1,2));   
   p1.add(p1_1);
   p1.add(jbtDisplay);

   JScrollPane jsp = new JScrollPane(jtaDisplay);//滑軸
   
   //顯示Panel
   JPanel p2 = new JPanel(new BorderLayout());
   p2.add(jsp,BorderLayout.CENTER);

   setLayout(new BorderLayout());

   add(p1,BorderLayout.NORTH);
   add(p2,BorderLayout.CENTER);

   //按鈕
   jbtDisplay.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){

     //計算利息
     double rate =  Integer.parseInt(jtfAnnualInterestRate.getText());    
     int year = Integer.parseInt(jtfNumberOfYears.getText());  
     double loanAmount = Double.parseDouble(jtfLoanAmount.getText());   

     double w = Math.pow((1+(rate/12/100)),(12*year)); //按月數增加的利率
     double month = ((rate/12/100)*loanAmount*w)/(w - 1); //以利率計算每月總額
     double total = month*12*year; //總月數

     double monthlyInterestRate = rate/12; 

     double balance = loanAmount;   
  
     //轉換的形式
     NumberFormat currencyForm = NumberFormat.getCurrencyInstance(Locale.US);    
 
     StringBuilder str = new StringBuilder();

     //轉為美金
     String monthFormat = currencyForm.format(month);
     String paymentFormat = currencyForm.format(total);
     str.append("Monthly Payment: "+monthFormat +"\n");//顯示月薪
     str.append("Total Payment: "+paymentFormat +"\n\n"); //顯示總薪

     str.append("Payment#\tInterest\tPrincipal\tBalance\n");
     //計算
     for(int pay = 1;pay <= year*12;pay++)
      {
       double Interest = (monthlyInterestRate*balance*100)/100/100;
       balance -= (month-Interest);
       double principal = (month-Interest);
      
       //輸出轉為美金
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
   frame.setTitle("EX31_5");//標題
   frame.setSize(500,500);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);
  }
}