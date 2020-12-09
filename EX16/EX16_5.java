//creating a bit/megabytes converter

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX16_5 extends JFrame
{
 private JTextField JBit = new JTextField(5);//輸入bit
 private JTextField JMegabytes = new JTextField(5);//輸入MB

 public EX16_5()
  {
   setLayout(new GridLayout(2,2));//設定layout

   //加入component
   add(new JLabel("Bits"));
   add(JBit);
   add(new JLabel("Megabytes"));
   add(JMegabytes);

   //對齊
   JBit.setHorizontalAlignment(JTextField.RIGHT);
   JMegabytes.setHorizontalAlignment(JTextField.RIGHT);

   //加入動作 將Bit和MB轉換 Enter觸發
   JBit.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     double m = Double.parseDouble(JBit.getText()) * 1.19209289550781*Math.pow(10,-7);
     JMegabytes.setText(m+"");
    }
   });

   JMegabytes.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     double b = Double.parseDouble(JMegabytes.getText()) / 1.19209289550781*Math.pow(10,7);
     JBit.setText(b+"");
    }
   });
  }

 public static void main(String args[])
  {
   EX16_5 frame = new EX16_5();//宣告視窗
   frame.setTitle("EX16_5");//標題
   frame.setSize(200,100);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}