//ArrayIndexOutBoundException

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX18_3 extends JFrame
{
 private JTextField jtf1 = new JTextField();//��Jindex
 private JTextField jtf2 = new JTextField();//��ܸ̭����Ʀr

 private JButton jb1 = new JButton("Show Element");//��ܵ��G���s

 int[] num = new int[100];//�s��Ʀr�}�C
 
 public EX18_3()
  {
   JPanel p1 = new JPanel(new GridLayout(2,2));//��J�Ʀr����ܵ��G

   //�[�Jcomponent
   p1.add(new JLabel("Array Index"));
   p1.add(jtf1);
   
   p1.add(new JLabel("Array Element"));
   p1.add(jtf2);

   jtf2.setEditable(false);//�]�w�T��B��

   for(int i=0;i<100;i++)//��J�Ʀr
    num[i] = (int)(Math.random()*100);

   //��X
   setLayout(new BorderLayout());
   add(p1,BorderLayout.CENTER);
   add(jb1,BorderLayout.SOUTH);

   //�[�J���s�ʧ@ ��ܵ��G
   jb1.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     try{
      int index = Integer.parseInt(jtf1.getText());//���oindex
      jtf2.setText(num[index]+"");//���
     }
     catch(ArrayIndexOutOfBoundsException ex)//�W�L�d��
     {
      jtf2.setText("Out of Bound");//��ܿ��~�T��
     }
    }
   });
  }

 public static void main(String args[])
  {
   EX18_3 frame = new EX18_3();//�ŧi����
   frame.setTitle("EX18_3");//���D
   frame.setSize(400,100);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}