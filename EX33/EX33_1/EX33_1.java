//Demonstrating FlowLayout properties

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.regex.*;

public class EX33_1 extends JFrame
{
 //選擇排版方向
 private JComboBox jcboAlign = new JComboBox(
    new String[]{"CENTER","LEFT","LEADING","RIGHT","TRAILING"});
 private JTextField jtfHGap = new JTextField(10);//輸入平行方向的距離
 private JTextField jtfVGap = new JTextField(10);//輸入垂直方向的距離
 private FlowLayout flowLayout = new FlowLayout();//layout
 private JPanel panel2 = new JPanel(flowLayout);//顯示面板

 //constructor
 public EX33_1()
  {
   JPanel panel1 = new JPanel(new GridLayout(3,1));//操作面板

   JPanel panel1_1 = new JPanel(new BorderLayout());
   panel1_1.add(new JLabel("Alignment"),BorderLayout.WEST);
   panel1_1.add(jcboAlign,BorderLayout.CENTER);
   
   JPanel panel1_2 = new JPanel(new BorderLayout());
   panel1_2.add(new JLabel("HGap         "),BorderLayout.WEST);
   panel1_2.add(jtfHGap,BorderLayout.CENTER);
   
   JPanel panel1_3 = new JPanel(new BorderLayout());
   panel1_3.add(new JLabel("VGap         "),BorderLayout.WEST);
   panel1_3.add(jtfVGap,BorderLayout.CENTER);

   panel1.add(panel1_1);
   panel1.add(panel1_2);
   panel1.add(panel1_3);
   
   panel1.setBorder(new TitledBorder("FlowLayout Properties"));

   panel2.setLayout(flowLayout);//顯示面板
   for(int i=0;i<15;i++)
    {
     panel2.add(new JButton("Component"+i));
    }

   add(panel2,BorderLayout.CENTER);
   add(panel1,BorderLayout.SOUTH);

   ActionListener listener = new EventListener();

   //操作事件
   jcboAlign.addItemListener(new ItemListener(){
    public void itemStateChanged(ItemEvent e){
     setFlowLayout();
    }
   });

   jtfHGap.addActionListener(listener);
   jtfVGap.addActionListener(listener);
  }

 //輸入事件
 private class EventListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     setFlowLayout();
    }
  }

 //排版
 private void setFlowLayout()
  {
   String selectItem = (String)jcboAlign.getSelectedItem();
   int align = FlowLayout.CENTER;

   //按照選擇決定排列位置
   if(selectItem.equals("CENTER"))
    align = FlowLayout.CENTER;
   else if(selectItem.equals("LEADING"))
    align = FlowLayout.LEADING;
   else if(selectItem.equals("LEFT"))
    align = FlowLayout.LEFT;
   else if(selectItem.equals("RIGHT"))
    align = FlowLayout.RIGHT;
   else if(selectItem.equals("TRAILING"))
    align = FlowLayout.TRAILING;
 
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
   flowLayout.setHgap(h);
   flowLayout.setVgap(v);
   flowLayout.setAlignment(align);
   panel2.revalidate();
  }

 public static void main(String args[])
  {
   EX33_1 frame = new EX33_1();
   
   frame.setTitle("EX33_1");//標題
   frame.setSize(550,400);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}