//Adding new features into EX16_1

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class EX16_10 extends JFrame
{
 //�I�����s ����C��
 private JRadioButton jRed = new JRadioButton("Red");//��
 private JRadioButton jYellow = new JRadioButton("Yellow");//��
 private JRadioButton jWhite = new JRadioButton("White");//��
 private JRadioButton jGray = new JRadioButton("Gray");//��
 private JRadioButton jGreen = new JRadioButton("Green");//��

 //�U�Կ�� �I���C��
 private JComboBox selectFore = new JComboBox(new Object[]{"black","blue"});

 //�Ŀ���s
 JCheckBox jchkCentered = new JCheckBox("Centered");//�m��
 JCheckBox jchkBold = new JCheckBox("Bold");//�[��
 JCheckBox jchkItalic = new JCheckBox("Italic");//����

 JTextField jtf = new JTextField(6);//��J��r

 MessagePanel p2 = new MessagePanel(); //��ܤ�r

 public EX16_10()
  {
   setLayout(new BorderLayout());//�]�wlayout

   Border lineBorder = new LineBorder(Color.BLACK,2);//�ŧi�ؽu

   //�ާ@panel
   JPanel p1 = new JPanel(new FlowLayout());
   p1.setBorder(lineBorder);//�]�w�ؽu
   p1.setBorder(new TitledBorder("Select the Options"));

   //�[�Jcomponent
   p1.add(new JLabel("Select a foreground color"));
   p1.add(selectFore);
   p1.add(new JLabel("Select a background color "));

   //�[�J���s
   p1.add(jRed);
   p1.add(jYellow);
   p1.add(jWhite);
   p1.add(jGray);
   p1.add(jGreen);
   p1.add(jchkCentered);
   p1.add(jchkBold);
   p1.add(jchkItalic);

   //�N�I�����s�k���@�s
   ButtonGroup group1 = new ButtonGroup();
   group1.add(jRed);
   group1.add(jYellow);
   group1.add(jWhite);
   group1.add(jGray);
   group1.add(jGreen);

   JPanel p3 = new JPanel();//��J��rpanel

   //�[�Jcomponent
   p3.add(new JLabel("Enter a new message"));
   p3.add(jtf);

   //�[�J���s�ʧ@ �]�w�C��
   //����
   jRed.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p2.setBackground(Color.red);
    }
   });

   //����
   jYellow.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p2.setBackground(Color.yellow);
    }
   });

   //�զ�
   jWhite.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p2.setBackground(Color.white);
    }
   });

   //�Ǧ�
   jGray.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p2.setBackground(Color.gray);
    }
   });

   //���
   jGreen.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p2.setBackground(Color.green);
    }
   });
   
   //�[�J���s�ʧ@ �]�w�r��
   //�m��
   jchkCentered.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     p2.setCentered(jchkCentered.isSelected());
    }
   });
   
   //�[��
   jchkBold.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     setNewFont();
    }
   });

   //����
   jchkItalic.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     setNewFont();
    }
   });

   //���forebround
   selectFore.addItemListener(new ItemListener(){
    public void itemStateChanged(ItemEvent e) {
     int index = selectFore.getSelectedIndex();
     if(index == 0)
      p2.setForeground(Color.black);
     else if(index == 1)
      p2.setForeground(Color.blue);
    }
   });   

   //�[�J�ʧ@ ��J��r�����
   jtf.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     p2.setMessage(jtf.getText());
     jtf.requestFocusInWindow();
    }
   });

   //�N�Ҧ�panel�[�J
   add(p1,BorderLayout.NORTH);
   add(p2,BorderLayout.CENTER);
   add(p3,BorderLayout.SOUTH);
  }

 public static void main(String args[])
  {
   EX16_10 frame = new EX16_10();//�ŧi����
   frame.setTitle("EX16_10");//���D
   frame.setSize(1000,300);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 private void setNewFont()  //���ܤ�r
  {
   int fontStyle = Font.PLAIN;
   fontStyle += (jchkBold.isSelected() ? Font.BOLD : Font.PLAIN);
   fontStyle += (jchkItalic.isSelected() ? Font.ITALIC : Font.PLAIN);

   Font font = p2.getFont();
   p2.setFont(new Font(font.getName(),fontStyle,font.getSize()));
  }

 class MessagePanel extends JPanel  //�r������
  {
   //��r�y��
   int xCoordinate = 20;
   int yCoordinate = 20;

   String message = "";//��ܤ�r
   boolean centered;//�O�_�m��
   
   //�غc�l
   public MessagePanel()
    {}

   public void setMessage(String message)
    {
     this.message = message;
     repaint();
    } 

   public void setCentered(boolean centered) //�O�_�m��
    {
     this.centered = centered;
     repaint();
    }
   
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     FontMetrics fm = g.getFontMetrics();
     
     //��X�r�e�M��
     int stringWidth = fm.stringWidth(message);
     int stringAscent = fm.getAscent();     

     if(centered)//�̬O�_�m�����ܦ�m
      {
       xCoordinate = getWidth() / 2 - stringWidth/2;
       yCoordinate = getHeight() / 2 + stringAscent/2;
      }

     else
      {
       xCoordinate = 20;
       yCoordinate = 20;
      }
     
     g.drawString(message,xCoordinate,yCoordinate);//��ܤ�r
    }
  }
}
   