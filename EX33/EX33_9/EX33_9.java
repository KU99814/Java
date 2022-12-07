//Using BorderFactory

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.*;

public class EX33_9 extends JFrame
{
 //排版方式點選
 private JRadioButton jrbNone,jrbLoweredBevel,
          jrbRaisedBevel,jrbEtched,jrbMatte,
          jrbEmpty,jrbCompound,jrbLine,jrbTitled;

 private JPanel jPanel = new JPanel(new GridLayout(3,3,5,5));

 public EX33_9()
  {
   //加入點選按鈕
   jPanel.add(jrbNone = new JRadioButton("None",true));
   jPanel.add(jrbLoweredBevel = new JRadioButton("Lowered Bevel"));
   jPanel.add(jrbRaisedBevel = new JRadioButton("Raised Bevel"));
   jPanel.add(jrbEtched = new JRadioButton("Etched"));
   jPanel.add(jrbMatte = new JRadioButton("Matte"));
   jPanel.add(jrbEmpty = new JRadioButton("Empty"));
   jPanel.add(jrbCompound = new JRadioButton("Compound"));
   jPanel.add(jrbLine = new JRadioButton("Line"));
   jPanel.add(jrbTitled = new JRadioButton("Titled"));

   //加入group
   ButtonGroup btgBorderStyle = new ButtonGroup();
   btgBorderStyle.add(jrbNone);
   btgBorderStyle.add(jrbLoweredBevel);
   btgBorderStyle.add(jrbRaisedBevel);
   btgBorderStyle.add(jrbEtched);
   btgBorderStyle.add(jrbMatte);
   btgBorderStyle.add(jrbEmpty);
   btgBorderStyle.add(jrbCompound);
   btgBorderStyle.add(jrbLine);
   btgBorderStyle.add(jrbTitled);

   setLayout(new BorderLayout(5,5));
   add(jPanel,BorderLayout.CENTER);
   add(new JButton("test"),BorderLayout.SOUTH);

   //加入點選事件
   ActionListener listener = new EventListener();
   jrbNone.addActionListener(listener);
   jrbLoweredBevel.addActionListener(listener);
   jrbRaisedBevel.addActionListener(listener);
   jrbEtched.addActionListener(listener);
   jrbMatte.addActionListener(listener);
   jrbEmpty.addActionListener(listener);
   jrbCompound.addActionListener(listener);
   jrbLine.addActionListener(listener);
   jrbTitled.addActionListener(listener);
  }

 //點選事件 影響Border style
 private class EventListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     Border border = new EmptyBorder(2,2,2,2);

     if(jrbNone.isSelected())     
      {
       border = null;
      }
     else if(jrbLoweredBevel.isSelected())
      {
        border = new BevelBorder(BevelBorder.LOWERED);
      }
     else if(jrbRaisedBevel.isSelected())
      {
        border = new BevelBorder(BevelBorder.RAISED);
      }
     else if(jrbEtched.isSelected())
      {
        border = new EtchedBorder();
      }
     else if(jrbLine.isSelected())
      {
        border = new LineBorder(Color.black,5);
      }
     else if(jrbMatte.isSelected())
      {
        border = new MatteBorder(15,15,15,15,
         new ImageIcon(getClass().getResource("caIcon.gif")));
      }
     else if(jrbEmpty.isSelected())
      {
        border = new EmptyBorder(2,2,2,2);
      }

     jPanel.setBorder(border);
    }
  }

 public static void main(String args[])
  {
   EX33_9 frame = new EX33_9();
   
   frame.setTitle("EX33_9");//標題
   frame.setSize(600,400);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}