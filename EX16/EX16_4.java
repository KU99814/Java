//Creating a calculator

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX16_4 extends JFrame
{
 //��J�Ʀr0
 private JTextField jNumber1 = new JTextField(3);//�Ĥ@��
 private JTextField jNumber2 = new JTextField(3);//�ĤG��
 private JTextField jNumber3 = new JTextField(3);//�ĤT��

 private JTextField jResult = new JTextField(5);//���G��

 //�B����s
 private JButton add = new JButton("Add");//�[
 private JButton subtract = new JButton("Subtract");//��
 private JButton multiply = new JButton("Multiply");//��
 private JButton divide = new JButton("Divide");//��

 public EX16_4()
  {
   JPanel p1 = new JPanel(new FlowLayout());//��J���panel

   //�[�Jcomponent
   p1.add(new JLabel("Number 1"));
   p1.add(jNumber1);
   p1.add(new JLabel("Number 2"));
   p1.add(jNumber2);
   p1.add(new JLabel("Number 3"));
   p1.add(jNumber3);
   p1.add(new JLabel("Result"));
   p1.add(jResult);

   JPanel p2 = new JPanel(new FlowLayout());//���spanel

   //�[�J���s
   p2.add(add);
   p2.add(subtract);
   p2.add(multiply);
   p2.add(divide);

   jResult.setEditable(false);//�N���G��]������s��

   //���s�Ĥ@�Ӧr�[���u
   add.setMnemonic('A');
   subtract.setMnemonic('S');
   multiply.setMnemonic('M');
   divide.setMnemonic('D');
   
   //���s�[�J�ʧ@
   //�^���U���Ʀr�ᰵ�[���
   add.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     double n1 = Double.parseDouble(jNumber1.getText());
     double n2 = Double.parseDouble(jNumber2.getText());
     double n3 = Double.parseDouble(jNumber3.getText());
     jResult.setText((n1+n2+n3)+"");
    }
   });
   
   subtract.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     double n1 = Double.parseDouble(jNumber1.getText());
     double n2 = Double.parseDouble(jNumber2.getText());
     double n3 = Double.parseDouble(jNumber3.getText());
     jResult.setText((n1-n2-n3)+"");
    }
   });

   multiply.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     double n1 = Double.parseDouble(jNumber1.getText());
     double n2 = Double.parseDouble(jNumber2.getText());
     double n3 = Double.parseDouble(jNumber3.getText());
     jResult.setText((n1*n2*n3)+"");
    }
   });

   divide.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     double n1 = Double.parseDouble(jNumber1.getText());
     double n2 = Double.parseDouble(jNumber2.getText());
     double n3 = Double.parseDouble(jNumber3.getText());
     jResult.setText((n1/n2/n3)+"");
    }
   });

   setLayout(new BorderLayout());//�]�wlayout
   //�[�Jpanel
   add(p1,BorderLayout.NORTH);
   add(p2,BorderLayout.SOUTH);
  }

 public static void main(String args[])
  {
   EX16_4 frame = new EX16_4();//�ŧi����
   frame.setTitle("EX16_4");//���D
   frame.setSize(500,200);//�j�p
   frame.pack();//�վ�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}