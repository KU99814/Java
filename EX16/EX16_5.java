//creating a bit/megabytes converter

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX16_5 extends JFrame
{
 private JTextField JBit = new JTextField(5);//��Jbit
 private JTextField JMegabytes = new JTextField(5);//��JMB

 public EX16_5()
  {
   setLayout(new GridLayout(2,2));//�]�wlayout

   //�[�Jcomponent
   add(new JLabel("Bits"));
   add(JBit);
   add(new JLabel("Megabytes"));
   add(JMegabytes);

   //���
   JBit.setHorizontalAlignment(JTextField.RIGHT);
   JMegabytes.setHorizontalAlignment(JTextField.RIGHT);

   //�[�J�ʧ@ �NBit�MMB�ഫ EnterĲ�o
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
   EX16_5 frame = new EX16_5();//�ŧi����
   frame.setTitle("EX16_5");//���D
   frame.setSize(200,100);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}