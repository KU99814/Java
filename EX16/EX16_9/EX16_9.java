import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;

public class EX16_9 extends JFrame
{
 ImageIcon grapes = new ImageIcon("grapes.gif");//��ܹϤ�

 JButton jbt = new JButton("Grapes",grapes);//��ܹϤ������s

 //�Ϥ���m���
 JComboBox JHorizontal = new JComboBox(new Object[]{"LEADING","LEFT","CENTER","RIGHT",
                                                    "TRAILING"});//������m���

 JComboBox JVertical = new JComboBox(new Object[]{"TOP","CENTER","BOTTOM"});//������m���

 //��r��m���
 JComboBox JHorizontalText = new JComboBox(new Object[]{"LEADING","LEFT","CENTER","RIGHT",
                                                    "TRAILING"});//������m���

 JComboBox JVerticalText = new JComboBox(new Object[]{"TOP","CENTER","BOTTOM"});//������m���

 public EX16_9()
  {
   //�ƪ�
   JPanel p1 = new JPanel(new BorderLayout());
   p1.add(jbt,BorderLayout.CENTER);
   
   Border lineBorder = new LineBorder(Color.BLACK,2);//�ŧi�ؽu

   JPanel p2 = new JPanel(new GridLayout(1,2));  //��m����

   JPanel p2_1 = new JPanel(new GridLayout(1,2)); //�Ϥ���m

   JPanel p2_1_1 = new JPanel(new GridLayout(2,1)); //��r
   JPanel p2_1_2 = new JPanel(new GridLayout(2,1)); //���

   JPanel p2_2 = new JPanel(new GridLayout(1,2));  //��r��m
   JPanel p2_2_1 = new JPanel(new GridLayout(2,1)); //��r
   JPanel p2_2_2 = new JPanel(new GridLayout(2,1)); //���

   p2.setBorder(lineBorder); //�]�w�ؽu
   p2_1.setBorder(lineBorder);
   p2_1.setBorder(new TitledBorder("Horizontal Alignment"));
   
   p2_1_1.setBorder(lineBorder);
   p2_1_2.setBorder(lineBorder);

   //�[�Jcomponent
   p2_1_1.add(new JLabel("Horizontal"));
   p2_1_1.add(new JLabel("Vertical"));
   
   //���
   p2_1_2.add(JHorizontal);
   p2_1_2.add(JVertical);
   
   p2_1.add(p2_1_1);
   p2_1.add(p2_1_2);

   //��r��m����
   p2_2.setBorder(lineBorder);
   p2_2.setBorder(new TitledBorder("Text Position"));
   
   p2_2_1.setBorder(lineBorder);
   p2_2_2.setBorder(lineBorder);

   //�[�Jcomponent
   p2_2_1.add(new JLabel("Horizontal"));
   p2_2_1.add(new JLabel("Vertical"));

   p2_2_2.add(JHorizontalText);
   p2_2_2.add(JVerticalText);
   
   p2_2.add(p2_2_1);
   p2_2.add(p2_2_2);

   //�J��
   p2.add(p2_1);
   p2.add(p2_2);
   
   setLayout(new GridLayout(2,1));
   add(p1);
   add(p2);
   
   //�[�J���ʧ@ �վ�Ϥ�������m
   JHorizontal.addItemListener(new ItemListener(){
    public void itemStateChanged(ItemEvent e) {
     int index = JHorizontal.getSelectedIndex();
     switch(index) {
      case 0: jbt.setHorizontalAlignment(SwingConstants.LEADING);
              break;
      case 1: jbt.setHorizontalAlignment(SwingConstants.LEFT);
              break;
      case 2: jbt.setHorizontalAlignment(SwingConstants.CENTER);
              break;
      case 3: jbt.setHorizontalAlignment(SwingConstants.RIGHT);
              break;
      case 4: jbt.setHorizontalAlignment(SwingConstants.TRAILING);
              break;
     }
    } 
   });

   //�վ�Ϥ�������m
   JVertical.addItemListener(new ItemListener(){
    public void itemStateChanged(ItemEvent e) {
     int index = JVertical.getSelectedIndex();
     
     switch(index) {
      case 0: jbt.setVerticalAlignment(SwingConstants.TOP);
              break;
      case 1: jbt.setVerticalAlignment(SwingConstants.CENTER);
              break;
      case 2: jbt.setVerticalAlignment(SwingConstants.BOTTOM);
              break;
     }
    }
   });

   //�վ��r������m
   JHorizontalText.addItemListener(new ItemListener(){
    public void itemStateChanged(ItemEvent e) {
     int index = JHorizontalText.getSelectedIndex();
     switch(index) {
      case 0: jbt.setHorizontalTextPosition(SwingConstants.LEADING);
              break;
      case 1: jbt.setHorizontalTextPosition(SwingConstants.LEFT);
              break;
      case 2: jbt.setHorizontalTextPosition(SwingConstants.CENTER);
              break;
      case 3: jbt.setHorizontalTextPosition(SwingConstants.RIGHT);
              break;
      case 4: jbt.setHorizontalTextPosition(SwingConstants.TRAILING);
              break;
     }
    }
   });

   //�վ��r������m
   JVerticalText.addItemListener(new ItemListener(){
    public void itemStateChanged(ItemEvent e) {
     int index = JVerticalText.getSelectedIndex();
     switch(index) {
      case 0: jbt.setVerticalTextPosition(SwingConstants.TOP);
              break;
      case 1: jbt.setVerticalTextPosition(SwingConstants.CENTER);
              break;
      case 2: jbt.setVerticalTextPosition(SwingConstants.BOTTOM);
              break;
     }
    }
   });
  }

 public static void main(String args[])
  {
   EX16_9 frame = new EX16_9();//�ŧi����
   frame.setTitle("EX16_9");//���D
   frame.setSize(400,300);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}