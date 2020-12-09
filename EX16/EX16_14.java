//Using JComboBox and JList

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class EX16_14 extends JFrame
{
 JComboBox backColor = new JComboBox(new Object[]{"White","Black","Yellow","Red"}); //選擇背景顏色
 String[] g = {"Statistics ","Calculus ","Begining Progrtamming ","Database Design"}; //選擇顯示的字
 JList list = new JList(g);//選單
 JLabel l1 = new JLabel(); //顯示文字

 public EX16_14()
  {
   list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);//設定選取模式
  // System.out.println(list.getSelectionMode());
   JPanel p1 = new JPanel(new GridLayout(1,2));//下拉式選單panel

   //加入component
   p1.add(new JLabel("Choose Background Color "));
   p1.add(backColor);

   JPanel p2 = new JPanel();
   p2.add(list);
   
   JPanel p3 = new JPanel();
   p3.add(l1);

   //加入動作 選擇選單背景顏色
   backColor.addItemListener(new ItemListener(){
    public void itemStateChanged(ItemEvent e){
     int index = backColor.getSelectedIndex();
     if(index == 0)
      list.setBackground(Color.white);
     else if(index == 1)
      list.setBackground(Color.black);
     else if(index == 2)
      list.setBackground(Color.yellow);
     else if(index == 3)
      list.setBackground(Color.red);
    }
   });
  
   //選擇顯示字
   list.addListSelectionListener(new ListSelectionListener(){
    public void valueChanged(ListSelectionEvent e){
     int[] indices = list.getSelectedIndices();//選取的index
     
     String s = "";
     for(int i=0;i<indices.length;i++)//按照選取index顯示
      s+=g[indices[i]];
     l1.setText(s);
    }
   });

   //加入整合panel
   setLayout(new BorderLayout());
   add(p1,BorderLayout.NORTH);
   add(p2,BorderLayout.CENTER);
   add(p3,BorderLayout.SOUTH);
  }

 public static void main(String args[])
  {
   EX16_14 frame = new EX16_14();//宣告視窗
   frame.setTitle("EX16_14");//標題
   frame.setSize(400,200);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}