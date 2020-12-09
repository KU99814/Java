//Comparing loans with various interest rate

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class EX16_13 extends JFrame
{
 JTextField t1 = new JTextField(5); //輸入總額
 JTextField t2 = new JTextField(2); //輸入年數
 JTextArea a1 = new JTextArea();  //輸出畫面

 JButton showTable = new JButton("Show Table"); //計算按鈕

 public EX16_13()
  {
   JPanel p1 = new JPanel(new FlowLayout());//輸入panel
   JPanel p2 = new JPanel(new BorderLayout());//顯示panel
   
   Border line = new LineBorder(Color.BLACK,2);//框線
 
   //加入框線
   p1.setBorder(line);

   //加入component
   p1.add(new JLabel("Loan Amount"));
   p1.add(t1);
   p1.add(new JLabel("Number of Years"));
   p1.add(t2);
   p1.add(showTable);

   a1.setEditable(false);//不能外部編輯

   JScrollPane Sp = new JScrollPane(a1); //加入滾動條

   p2.add(Sp);

   //加入動作 執行運算
   showTable.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     double loanAmount = Double.parseDouble(t1.getText());
     int year = Integer.parseInt(t2.getText());
    // year -= 2;
     if(year <=0)
      year = 1;
     String g = "Interest Rate\t\tMonthly Payment\t\tTotal Patment\n";//顯示項目

     //輸出數據和計算結果
     for(double rate = 5;rate <= 8;rate+=0.125)
      {
       double w = Math.pow((1+(rate/12/100)),(12*year));
       double month = ((rate/12/100)*loanAmount*w)/(w - 1);
       double total = month*12*year; 
       
       month = (double)((int)(month*100))/100;
       total = (double)((int)(total*100))/100;
       g += rate+"\t\t"+month+"\t\t\t"+total+"\n";
      }
      a1.setText(g);
     }
    });
   
   //加入panel
   setLayout(new BorderLayout());
   add(p1,BorderLayout.NORTH);
   add(p2,BorderLayout. CENTER);
  }

 public static void main(String args[])
  {
   EX16_13 frame = new EX16_13();//宣告視窗
   frame.setTitle("EX16_13");//標題
   frame.setSize(800,400);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}