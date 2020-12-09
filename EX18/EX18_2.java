//ArithmeticException and NumberformatException

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX18_2 extends JFrame
{
 private JTextField jtf1 = new JTextField(3);//��J��1
 private JTextField jtf2 = new JTextField(3);//��J��2
 private JTextField jtf3 = new JTextField(3);//��ܵ��G

 private JButton jbDivide = new JButton("Divide");//�B����s
 
 public EX18_2()
  {
   JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));//��Jpanel

   //��Jpanel�[�Jcomponent
   p1.add(new JLabel("Number 1 "));
   p1.add(jtf1);
   p1.add(new JLabel("Number 2 "));
   p1.add(jtf2);
   p1.add(new JLabel("Result"));
   p1.add(jtf3);

   //���G�椣��s��
   jtf3.setEditable(false);

   //��X
   setLayout(new GridLayout(2,1));
   add(p1);
   add(jbDivide);

   //�[�J���s�ʧ@ �B��
   jbDivide.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     try{
      //�q�����o��
      int num1 = Integer.parseInt(jtf1.getText());
      int num2 = Integer.parseInt(jtf2.getText());
      
      int number = num1/num2;//�B�����ܵ��G
      jtf3.setText(number+"");
     }
     catch(ArithmeticException ex1)//�B����~
     {
      //���X���~�T��
      JOptionPane.showMessageDialog(null,"Arithmetic error","Warning",JOptionPane.INFORMATION_MESSAGE);
     }
     catch(NumberFormatException ex2)//�榡���~
     {
      //���X���~�T��
      JOptionPane.showMessageDialog(null,"Number format errors","Warning",JOptionPane.INFORMATION_MESSAGE);
     }
    }
   });
  } 

 public static void main(String args[])
  {
   EX18_2 frame = new EX18_2();//�ŧi����
   frame.setTitle("EX18_2");//���D
   frame.setSize(400,100);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true); //���
  }
}
 