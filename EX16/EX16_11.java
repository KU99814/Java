//Demonstrating JTextField properties

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class EX16_11 extends JFrame
{
 JTextField tf = new JTextField(10);   //��
 JTextField ColumnSize = new JTextField(10); //�ت�

 //�r����J��m
 JRadioButton jLeft = new JRadioButton("Left");  //��
 JRadioButton jCenter = new JRadioButton("Center"); //��
 JRadioButton jRight = new JRadioButton("Right"); //�k

 public EX16_11()
  {
   JPanel p1 = new JPanel();//��J��rpanel

   JPanel p2 = new JPanel(new GridLayout(1,2));
   JPanel p2_1 = new JPanel();//�վ��mpanel
   JPanel p2_2 = new JPanel();//�j�ppanel
   
   //�[�Jcomponent
   p1.add(new JLabel("Text Field"));
   p1.add(tf);

   Border lineBorder = new LineBorder(Color.BLACK,2);//�ŧi�ؽu

   //�N�I�����s�]���@�s
   ButtonGroup group = new ButtonGroup();
   group.add(jLeft);
   group.add(jCenter);
   group.add(jRight);

   //�[�J���s
   p2_1.add(jLeft);
   p2_1.add(jCenter);
   p2_1.add(jRight);
   
   //�]�w�ؽu
   p2_1.setBorder(lineBorder);
   p2_1.setBorder(new TitledBorder("Horizontal Alignment"));

   //�[�J��J���
   p2_2.add(new JLabel("Column Size "));
   p2_2.add(ColumnSize);

   p2_2.setBorder(lineBorder);

   //��
   jLeft.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     tf.setHorizontalAlignment(SwingConstants.LEFT);
    }
   });

   //��
   jCenter.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     tf.setHorizontalAlignment(SwingConstants.CENTER);
    }
   });

   //�k
   jRight.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     tf.setHorizontalAlignment(SwingConstants.RIGHT);
    }
   });

   //�[�J�ʧ@ �վ�j�p
   ColumnSize.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     int size = Integer.parseInt(ColumnSize.getText());
     tf.setColumns(size);
     pack();//���s�ƪ�
     System.out.println(tf.getColumns());
    }
   });

   //�[�Jpanel
   p2.add(p2_1);
   p2.add(p2_2);
   
   //�ƪ�
   setLayout(new BorderLayout());
   add(p1,BorderLayout.NORTH);
   add(p2,BorderLayout.CENTER);
  }

 public static void main(String args[])
  {
   EX16_11 frame = new EX16_11();//�ŧi����
   frame.setTitle("EX16_11");//���D
   frame.setSize(400,150);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}