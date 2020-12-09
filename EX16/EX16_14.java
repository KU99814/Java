//Using JComboBox and JList

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class EX16_14 extends JFrame
{
 JComboBox backColor = new JComboBox(new Object[]{"White","Black","Yellow","Red"}); //��ܭI���C��
 String[] g = {"Statistics ","Calculus ","Begining Progrtamming ","Database Design"}; //�����ܪ��r
 JList list = new JList(g);//���
 JLabel l1 = new JLabel(); //��ܤ�r

 public EX16_14()
  {
   list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);//�]�w����Ҧ�
  // System.out.println(list.getSelectionMode());
   JPanel p1 = new JPanel(new GridLayout(1,2));//�U�Ԧ����panel

   //�[�Jcomponent
   p1.add(new JLabel("Choose Background Color "));
   p1.add(backColor);

   JPanel p2 = new JPanel();
   p2.add(list);
   
   JPanel p3 = new JPanel();
   p3.add(l1);

   //�[�J�ʧ@ ��ܿ��I���C��
   backColor.addItemListener(new ItemListener(){
    public void itemStateChanged(ItemEvent e){
     int index = backColor.getSelectedIndex();
     if(index == 0)
      list.setBackground(Color.white);
     else if(index == 1)
      list.setBackground(Color.black);
     else if(index == 2)
      list.setBackground(Color.yellow);
     else if(index == 3)
      list.setBackground(Color.red);
    }
   });
  
   //�����ܦr
   list.addListSelectionListener(new ListSelectionListener(){
    public void valueChanged(ListSelectionEvent e){
     int[] indices = list.getSelectedIndices();//�����index
     
     String s = "";
     for(int i=0;i<indices.length;i++)//���ӿ��index���
      s+=g[indices[i]];
     l1.setText(s);
    }
   });

   //�[�J��Xpanel
   setLayout(new BorderLayout());
   add(p1,BorderLayout.NORTH);
   add(p2,BorderLayout.CENTER);
   add(p3,BorderLayout.SOUTH);
  }

 public static void main(String args[])
  {
   EX16_14 frame = new EX16_14();//�ŧi����
   frame.setTitle("EX16_14");//���D
   frame.setSize(400,200);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}