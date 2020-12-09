//�p��Q��

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;

public class EX16_6 extends JFrame
{
 JTextField jtfIA = new JTextField(10);  //��J���B
 JTextField jtfY = new JTextField(10);   //��J�~��
 JTextField jtfAI = new JTextField(10);  //��J�Q�v
 JTextField jtfIFV = new JTextField(10);  //��X�`���B

 JButton calculate = new JButton("Calculate");  //�p����s

 public EX16_6()
  {
   JPanel p1 = new JPanel(new GridLayout(4,2));  //�ŧi����
   
   //�ƪ� �[�Jcomponent
   p1.add(new JLabel("Investment Amount "));
   p1.add(jtfIA);
   p1.add(new JLabel("Years "));
   p1.add(jtfY);
   p1.add(new JLabel("Annual interest Rate "));
   p1.add(jtfAI);
   p1.add(new JLabel("Future a value"));
   p1.add(jtfIFV);
   jtfIFV.setEditable(false);
   
   //�q�k��J ���
   jtfIA.setHorizontalAlignment(JTextField.RIGHT);
   jtfY.setHorizontalAlignment(JTextField.RIGHT);
   jtfAI.setHorizontalAlignment(JTextField.RIGHT);
   jtfIFV.setHorizontalAlignment(JTextField.RIGHT);
   
   //�ؽu
   Border lineBorder = new LineBorder(Color.BLACK,2);   
   p1.setBorder(lineBorder);
   
   //���s����
   JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT,10,20));
   p2.setBorder(lineBorder);
   p2.add(calculate);

   setLayout(new BorderLayout(5,5));//�]�wlayout

   //�[�Jpanel
   add(p1,BorderLayout.CENTER);
   add(p2,BorderLayout.SOUTH);
   
   //�[�J���s�ʧ@ 
   calculate.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     //�p��
     int investmentAmount = Integer.parseInt(jtfIA.getText());
     int years = Integer.parseInt(jtfY.getText());
     double AnnualInterestRate = Double.parseDouble(jtfAI.getText());
     double result = investmentAmount*Math.pow((1+AnnualInterestRate/100/12),years*12);
     result = (double)((int)(result*100)) / 100;
     jtfIFV.setText(result+"");
    }
   });
  }

 public static void main(String args[])
  {
   EX16_6 frame = new EX16_6();//�ŧi����
   frame.setTitle("EX16_6");//���D
   frame.setSize(200,200);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}