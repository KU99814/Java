//ArrayIndexOutBoundException

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX18_3 extends JFrame
{
 private JTextField jtf1 = new JTextField();//輸入index
 private JTextField jtf2 = new JTextField();//顯示裡面的數字

 private JButton jb1 = new JButton("Show Element");//顯示結果按鈕

 int[] num = new int[100];//存放數字陣列
 
 public EX18_3()
  {
   JPanel p1 = new JPanel(new GridLayout(2,2));//輸入數字並顯示結果

   //加入component
   p1.add(new JLabel("Array Index"));
   p1.add(jtf1);
   
   p1.add(new JLabel("Array Element"));
   p1.add(jtf2);

   jtf2.setEditable(false);//設定禁止運算

   for(int i=0;i<100;i++)//輸入數字
    num[i] = (int)(Math.random()*100);

   //整合
   setLayout(new BorderLayout());
   add(p1,BorderLayout.CENTER);
   add(jb1,BorderLayout.SOUTH);

   //加入按鈕動作 顯示結果
   jb1.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     try{
      int index = Integer.parseInt(jtf1.getText());//取得index
      jtf2.setText(num[index]+"");//顯示
     }
     catch(ArrayIndexOutOfBoundsException ex)//超過範圍
     {
      jtf2.setText("Out of Bound");//顯示錯誤訊息
     }
    }
   });
  }

 public static void main(String args[])
  {
   EX18_3 frame = new EX18_3();//宣告視窗
   frame.setTitle("EX18_3");//標題
   frame.setSize(400,100);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}