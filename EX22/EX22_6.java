//Storing numbers in a linked list

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX22_6
{
 static class ListFrame extends JFrame //介面的Frame
  {
   LinkedList<Integer> list = new LinkedList<Integer>(); //存放數字的list

   JTextField jtfNumber = new JTextField(8); //輸入數字

   JTextArea jtaDisplay = new JTextArea(); //顯示數列

   JButton jbSort = new JButton("Sort"); //排序按鈕
   JButton jbShuffle = new JButton("Shuffle");//弄亂按鈕
   JButton jbReverse = new JButton("Reverse"); //顛倒按鈕
   
   public ListFrame()
    {
     setLayout(new GridLayout(3,1,5,5));
     JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));//輸入數字面板
     p1.add(new JLabel("Enter a number: "));
     p1.add(jtfNumber);


     jtfNumber.addActionListener(new ActionListener(){ //實作功能
      public void actionPerformed(ActionEvent e){
       int num = Integer.parseInt(jtfNumber.getText());

       //避免重複
       if(!list.contains(num))
        list.add(num);
       
       //顯示
       printText();
       jtfNumber.setText("");//輸入欄回復空格
      }
     });

     //顯示面板
     jtaDisplay.setEditable(false);//不可編輯
     jtaDisplay.setLineWrap(true);
     jtaDisplay.setWrapStyleWord(true);

     JPanel p2 = new JPanel(new BorderLayout());//顯示panel
     p2.add(jtaDisplay,BorderLayout.CENTER);

     //按鈕面板
     JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
     p3.add(jbSort);
     p3.add(jbShuffle);
     p3.add(jbReverse);

     //加入sort按鈕事件
     jbSort.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
       Collections.sort(list); //排序

       //顯示
       printText();
      }
     });

     //加入按鈕事件
     jbShuffle.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
       Collections.shuffle(list);//打亂

       //顯示
       printText();
      }
     });

     //加入reverse事件
     jbReverse.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
       Collections.reverse(list); //顛倒

       //顯示
       printText();
      }
     });
     
     //整合
     add(p1);
     add(p2);
     add(p3);
    }

   //在文字面板顯示
   public void printText()
    {
     String s = "";//顯示字串
     for(int i = 0;i<list.size();i++)
      s += list.get(i) + " "; //依序加入
     jtaDisplay.setText(s); //顯示
    }
  }

 public static void main(String args[])
  {
   ListFrame frame = new ListFrame();//宣告視窗
   frame.pack();
   frame.setSize(400,200);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setTitle("EX22_6");//標題
   frame.setVisible(true);//顯示
  }
}