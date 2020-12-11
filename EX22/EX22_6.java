//Storing numbers in a linked list

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX22_6
{
 static class ListFrame extends JFrame //������Frame
  {
   LinkedList<Integer> list = new LinkedList<Integer>(); //�s��Ʀr��list

   JTextField jtfNumber = new JTextField(8); //��J�Ʀr

   JTextArea jtaDisplay = new JTextArea(); //��ܼƦC

   JButton jbSort = new JButton("Sort"); //�Ƨǫ��s
   JButton jbShuffle = new JButton("Shuffle");//�˶ë��s
   JButton jbReverse = new JButton("Reverse"); //�A�˫��s
   
   public ListFrame()
    {
     setLayout(new GridLayout(3,1,5,5));
     JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));//��J�Ʀr���O
     p1.add(new JLabel("Enter a number: "));
     p1.add(jtfNumber);


     jtfNumber.addActionListener(new ActionListener(){ //��@�\��
      public void actionPerformed(ActionEvent e){
       int num = Integer.parseInt(jtfNumber.getText());

       //�קK����
       if(!list.contains(num))
        list.add(num);
       
       //���
       printText();
       jtfNumber.setText("");//��J��^�_�Ů�
      }
     });

     //��ܭ��O
     jtaDisplay.setEditable(false);//���i�s��
     jtaDisplay.setLineWrap(true);
     jtaDisplay.setWrapStyleWord(true);

     JPanel p2 = new JPanel(new BorderLayout());//���panel
     p2.add(jtaDisplay,BorderLayout.CENTER);

     //���s���O
     JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
     p3.add(jbSort);
     p3.add(jbShuffle);
     p3.add(jbReverse);

     //�[�Jsort���s�ƥ�
     jbSort.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
       Collections.sort(list); //�Ƨ�

       //���
       printText();
      }
     });

     //�[�J���s�ƥ�
     jbShuffle.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
       Collections.shuffle(list);//����

       //���
       printText();
      }
     });

     //�[�Jreverse�ƥ�
     jbReverse.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
       Collections.reverse(list); //�A��

       //���
       printText();
      }
     });
     
     //��X
     add(p1);
     add(p2);
     add(p3);
    }

   //�b��r���O���
   public void printText()
    {
     String s = "";//��ܦr��
     for(int i = 0;i<list.size();i++)
      s += list.get(i) + " "; //�̧ǥ[�J
     jtaDisplay.setText(s); //���
    }
  }

 public static void main(String args[])
  {
   ListFrame frame = new ListFrame();//�ŧi����
   frame.pack();
   frame.setSize(400,200);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setTitle("EX22_6");//���D
   frame.setVisible(true);//���
  }
}