//ArithmeticException and NumberformatException

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX18_2 extends JFrame
{
 private JTextField jtf1 = new JTextField(3);//輸入值1
 private JTextField jtf2 = new JTextField(3);//輸入值2
 private JTextField jtf3 = new JTextField(3);//顯示結果

 private JButton jbDivide = new JButton("Divide");//運算按鈕
 
 public EX18_2()
  {
   JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));//輸入panel

   //輸入panel加入component
   p1.add(new JLabel("Number 1 "));
   p1.add(jtf1);
   p1.add(new JLabel("Number 2 "));
   p1.add(jtf2);
   p1.add(new JLabel("Result"));
   p1.add(jtf3);

   //結果欄不能編輯
   jtf3.setEditable(false);

   //整合
   setLayout(new GridLayout(2,1));
   add(p1);
   add(jbDivide);

   //加入按鈕動作 運算
   jbDivide.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     try{
      //從欄位取得值
      int num1 = Integer.parseInt(jtf1.getText());
      int num2 = Integer.parseInt(jtf2.getText());
      
      int number = num1/num2;//運算並顯示結果
      jtf3.setText(number+"");
     }
     catch(ArithmeticException ex1)//運算錯誤
     {
      //跳出錯誤訊息
      JOptionPane.showMessageDialog(null,"Arithmetic error","Warning",JOptionPane.INFORMATION_MESSAGE);
     }
     catch(NumberFormatException ex2)//格式錯誤
     {
      //跳出錯誤訊息
      JOptionPane.showMessageDialog(null,"Number format errors","Warning",JOptionPane.INFORMATION_MESSAGE);
     }
    }
   });
  } 

 public static void main(String args[])
  {
   EX18_2 frame = new EX18_2();//宣告視窗
   frame.setTitle("EX18_2");//標題
   frame.setSize(400,100);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true); //顯示
  }
}
 