//Demonstrating BorderLayout properties

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.regex.*;

public class EX33_3 extends JFrame
{
 //顯示排版按鈕
 private JButton jbNorth = new JButton("North");
 private JButton jbWest = new JButton("West");
 private JButton jbSouth = new JButton("South");
 private JButton jbEast = new JButton("East");
 private JButton jbCenter = new JButton("Center");

 //輸入gap文字框
 private JTextField jtfHGap = new JTextField();
 private JTextField jtfVGap = new JTextField();

 private BorderLayout borderLayout = new BorderLayout();

 private JPanel p1 = new JPanel(borderLayout);//展示排版

 public EX33_3()
  {
   //加入
   p1.add(jbNorth,BorderLayout.NORTH);
   p1.add(jbSouth,BorderLayout.SOUTH);
   p1.add(jbWest,BorderLayout.WEST);
   p1.add(jbEast,BorderLayout.EAST);
   p1.add(jbCenter,BorderLayout.CENTER);

   p1.setBorder(new TitledBorder("Container of Border Layout"));

   JPanel p2 = new JPanel(new GridLayout(2,1));//操作面板

   JPanel pHGap = new JPanel(new BorderLayout());
   pHGap.add(new JLabel("HGap         "),BorderLayout.WEST);
   pHGap.add(jtfHGap,BorderLayout.CENTER);
   
   JPanel pVGap = new JPanel(new BorderLayout());
   pVGap.add(new JLabel("VGap         "),BorderLayout.WEST);
   pVGap.add(jtfVGap,BorderLayout.CENTER);
   
   p2.add(pHGap);
   p2.add(pVGap);
   
   p2.setBorder(new TitledBorder("BorderLayout Properties"));

   //加入事件
   EventListener listener = new EventListener();   

   jtfHGap.addActionListener(listener);
   jtfVGap.addActionListener(listener);

   setLayout(new BorderLayout());
   add(p1,BorderLayout.CENTER);
   add(p2,BorderLayout.SOUTH);
  }

 //輸入事件
 private class EventListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     setBorderLayout();
    }
  }

 //排版
 private void setBorderLayout()
  {
   Pattern pattern = Pattern.compile("^[0-9]*$");//比較字串是否是數字

   //轉換字串為數字
   int h = 0;
   String hgapStr = jtfHGap.getText();
   if(pattern.matcher(hgapStr).matches() && !hgapStr.equals(""))
    h = Integer.parseInt(hgapStr);
   int v = 0;
   String vgapStr = jtfVGap.getText();
   if(pattern.matcher(vgapStr).matches() && !vgapStr.equals(""))
    v = Integer.parseInt(vgapStr);

   //設定layout
   borderLayout.setHgap(h);
   borderLayout.setVgap(v);
   p1.revalidate();
  }

 public static void main(String args[])
  {
   EX33_3 frame = new EX33_3();
   
   frame.setTitle("EX33_3");//標題
   frame.setSize(500,300);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}