//Comparing loans with various interest rate

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class EX16_13 extends JFrame
{
 JTextField t1 = new JTextField(5); //��J�`�B
 JTextField t2 = new JTextField(2); //��J�~��
 JTextArea a1 = new JTextArea();  //��X�e��

 JButton showTable = new JButton("Show Table"); //�p����s

 public EX16_13()
  {
   JPanel p1 = new JPanel(new FlowLayout());//��Jpanel
   JPanel p2 = new JPanel(new BorderLayout());//���panel
   
   Border line = new LineBorder(Color.BLACK,2);//�ؽu
 
   //�[�J�ؽu
   p1.setBorder(line);

   //�[�Jcomponent
   p1.add(new JLabel("Loan Amount"));
   p1.add(t1);
   p1.add(new JLabel("Number of Years"));
   p1.add(t2);
   p1.add(showTable);

   a1.setEditable(false);//����~���s��

   JScrollPane Sp = new JScrollPane(a1); //�[�J�u�ʱ�

   p2.add(Sp);

   //�[�J�ʧ@ ����B��
   showTable.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     double loanAmount = Double.parseDouble(t1.getText());
     int year = Integer.parseInt(t2.getText());
    // year -= 2;
     if(year <=0)
      year = 1;
     String g = "Interest Rate\t\tMonthly Payment\t\tTotal Patment\n";//��ܶ���

     //��X�ƾکM�p�⵲�G
     for(double rate = 5;rate <= 8;rate+=0.125)
      {
       double w = Math.pow((1+(rate/12/100)),(12*year));
       double month = ((rate/12/100)*loanAmount*w)/(w - 1);
       double total = month*12*year; 
       
       month = (double)((int)(month*100))/100;
       total = (double)((int)(total*100))/100;
       g += rate+"\t\t"+month+"\t\t\t"+total+"\n";
      }
      a1.setText(g);
     }
    });
   
   //�[�Jpanel
   setLayout(new BorderLayout());
   add(p1,BorderLayout.NORTH);
   add(p2,BorderLayout. CENTER);
  }

 public static void main(String args[])
  {
   EX16_13 frame = new EX16_13();//�ŧi����
   frame.setTitle("EX16_13");//���D
   frame.setSize(800,400);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}