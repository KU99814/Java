//Creating a calculator

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX16_4 extends JFrame
{
 //輸入數字0
 private JTextField jNumber1 = new JTextField(3);//第一欄
 private JTextField jNumber2 = new JTextField(3);//第二欄
 private JTextField jNumber3 = new JTextField(3);//第三欄

 private JTextField jResult = new JTextField(5);//結果欄

 //運算按鈕
 private JButton add = new JButton("Add");//加
 private JButton subtract = new JButton("Subtract");//減
 private JButton multiply = new JButton("Multiply");//乘
 private JButton divide = new JButton("Divide");//除

 public EX16_4()
  {
   JPanel p1 = new JPanel(new FlowLayout());//輸入欄位panel

   //加入component
   p1.add(new JLabel("Number 1"));
   p1.add(jNumber1);
   p1.add(new JLabel("Number 2"));
   p1.add(jNumber2);
   p1.add(new JLabel("Number 3"));
   p1.add(jNumber3);
   p1.add(new JLabel("Result"));
   p1.add(jResult);

   JPanel p2 = new JPanel(new FlowLayout());//按鈕panel

   //加入按鈕
   p2.add(add);
   p2.add(subtract);
   p2.add(multiply);
   p2.add(divide);

   jResult.setEditable(false);//將結果欄設為不能編輯

   //按鈕第一個字加底線
   add.setMnemonic('A');
   subtract.setMnemonic('S');
   multiply.setMnemonic('M');
   divide.setMnemonic('D');
   
   //按鈕加入動作
   //擷取各欄位數字後做加減乘除
   add.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     double n1 = Double.parseDouble(jNumber1.getText());
     double n2 = Double.parseDouble(jNumber2.getText());
     double n3 = Double.parseDouble(jNumber3.getText());
     jResult.setText((n1+n2+n3)+"");
    }
   });
   
   subtract.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     double n1 = Double.parseDouble(jNumber1.getText());
     double n2 = Double.parseDouble(jNumber2.getText());
     double n3 = Double.parseDouble(jNumber3.getText());
     jResult.setText((n1-n2-n3)+"");
    }
   });

   multiply.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     double n1 = Double.parseDouble(jNumber1.getText());
     double n2 = Double.parseDouble(jNumber2.getText());
     double n3 = Double.parseDouble(jNumber3.getText());
     jResult.setText((n1*n2*n3)+"");
    }
   });

   divide.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     double n1 = Double.parseDouble(jNumber1.getText());
     double n2 = Double.parseDouble(jNumber2.getText());
     double n3 = Double.parseDouble(jNumber3.getText());
     jResult.setText((n1/n2/n3)+"");
    }
   });

   setLayout(new BorderLayout());//設定layout
   //加入panel
   add(p1,BorderLayout.NORTH);
   add(p2,BorderLayout.SOUTH);
  }

 public static void main(String args[])
  {
   EX16_4 frame = new EX16_4();//宣告視窗
   frame.setTitle("EX16_4");//標題
   frame.setSize(500,200);//大小
   frame.pack();//調整大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}