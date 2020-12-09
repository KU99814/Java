//Demonstrating JTextArea properties

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class EX16_12 extends JFrame
{
 JTextArea jta = new JTextArea();//�奻
 
 JCheckBox wrap = new JCheckBox("Wrap");//�Ŀ�O�_����

 //�I�ﴫ��覡
 JRadioButton wrapWords = new JRadioButton("Wrap Words");
 JRadioButton wrapCharacters = new JRadioButton("Wrap Characters");

 public EX16_12()
  {
   JPanel p1 = new JPanel();//��ܤ�rpanel
   JPanel p2 = new JPanel(new FlowLayout());//�ާ@����
   
   //��l���A
   jta.setLineWrap(false);
   jta.setWrapStyleWord(true);
   jta.setEditable(true);
 

   JScrollPane SJta = new JScrollPane(jta);//�ŧi�å[�J�u�ʱ�
   
   //��ܤ�r
   String text = "bkdjcbvkjgbfdsikjbfdskjblbfdskjbdskjfbi\n"+
                 "bifsbadikjverwivbuikfvsbushfduhfwoiarsd\n"+
                 "nbfvdskjbkjdboivehsdcoixhsgfdkjhxuawsxi\n"+
                 "bsiyadbfuidbivfsiudvhsbfvhfwsoahofshfgi\n"+
                 "nsudkfvbkufkugbasilhukjfcvkgo;aoijaiuuj\n"+
                 "nbulifvdsiogbriohfbdoihifdhoifbhdoihsdcih";
  jta.setText(text);//���
   
   //�[�Jcomponent
   p1.add(SJta);
   
   //�ŧi�ó]�w�ؽu
   Border lineBorder = new LineBorder(Color.BLACK,2);
   p2.setBorder(lineBorder);
   p2.setBorder(new TitledBorder("Wrap Options"));
   
   //�I����s�]���@�s
   ButtonGroup group = new ButtonGroup();
   group.add(wrapWords);
   group.add(wrapCharacters);

   //�[�J���s
   p2.add(wrap);
   p2.add(wrapWords);
   p2.add(wrapCharacters);

   //�[�J�ʧ@
   wrap.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     jta.setLineWrap(wrap.isSelected());//����]�m
    }
   });
   
   //�H�U��Ӭ�����覡����
   wrapWords.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     jta.setWrapStyleWord(true);
    }
   });
   
   wrapCharacters.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     jta.setWrapStyleWord(false);
    }
   });
  
   //�[�Jpanel
   setLayout(new GridLayout(2,1));
   add(p1);
   add(p2);
  }

 public static void main(String args[])
  {
   EX16_12 frame = new EX16_12();//�ŧi����
   frame.pack();//�վ�j�p
   frame.setTitle("EX16_12");//���D
   frame.setSize(300,500);//�ؤo
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}