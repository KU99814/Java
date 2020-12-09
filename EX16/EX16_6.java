//計算利息

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;

public class EX16_6 extends JFrame
{
 JTextField jtfIA = new JTextField(10);  //輸入金額
 JTextField jtfY = new JTextField(10);   //輸入年數
 JTextField jtfAI = new JTextField(10);  //輸入利率
 JTextField jtfIFV = new JTextField(10);  //輸出總金額

 JButton calculate = new JButton("Calculate");  //計算按鈕

 public EX16_6()
  {
   JPanel p1 = new JPanel(new GridLayout(4,2));  //宣告版面
   
   //排版 加入component
   p1.add(new JLabel("Investment Amount "));
   p1.add(jtfIA);
   p1.add(new JLabel("Years "));
   p1.add(jtfY);
   p1.add(new JLabel("Annual interest Rate "));
   p1.add(jtfAI);
   p1.add(new JLabel("Future a value"));
   p1.add(jtfIFV);
   jtfIFV.setEditable(false);
   
   //從右輸入 對齊
   jtfIA.setHorizontalAlignment(JTextField.RIGHT);
   jtfY.setHorizontalAlignment(JTextField.RIGHT);
   jtfAI.setHorizontalAlignment(JTextField.RIGHT);
   jtfIFV.setHorizontalAlignment(JTextField.RIGHT);
   
   //框線
   Border lineBorder = new LineBorder(Color.BLACK,2);   
   p1.setBorder(lineBorder);
   
   //按鈕版面
   JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT,10,20));
   p2.setBorder(lineBorder);
   p2.add(calculate);

   setLayout(new BorderLayout(5,5));//設定layout

   //加入panel
   add(p1,BorderLayout.CENTER);
   add(p2,BorderLayout.SOUTH);
   
   //加入按鈕動作 
   calculate.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     //計算
     int investmentAmount = Integer.parseInt(jtfIA.getText());
     int years = Integer.parseInt(jtfY.getText());
     double AnnualInterestRate = Double.parseDouble(jtfAI.getText());
     double result = investmentAmount*Math.pow((1+AnnualInterestRate/100/12),years*12);
     result = (double)((int)(result*100)) / 100;
     jtfIFV.setText(result+"");
    }
   });
  }

 public static void main(String args[])
  {
   EX16_6 frame = new EX16_6();//宣告視窗
   frame.setTitle("EX16_6");//標題
   frame.setSize(200,200);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}