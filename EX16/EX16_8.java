import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class EX16_8 extends JFrame
{
 GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();//Font class
 String[] FontName = e.getAvailableFontFamilyNames(); //�r��
 JComboBox jFN = new JComboBox(FontName); //��ܦr��

 String[] fontSize = new String[100];//�r���j�p�}�C
 JComboBox jFS = new JComboBox(); //��ܤj�p 1~100

 public MessagePanel p2 = new MessagePanel(); //�r��

 //�Ŀ���s 
 JCheckBox jchkCentered = new JCheckBox("Centered");//�m��
 JCheckBox jchkBold = new JCheckBox("Bold");//�[��
 JCheckBox jchkItalic = new JCheckBox("Italic");//����

 public EX16_8()
  {
   JPanel p1 = new JPanel(new FlowLayout()); //�ާ@panel
   JPanel p1_1 = new JPanel(new FlowLayout()); //�r������
   JPanel p1_2 = new JPanel(new FlowLayout()); //�j�p����

   //�N�w�q�r���j�p�}�C�å[�J�U�Կ��
   for(int i=0;i<100;i++)
    fontSize[i] = i+1+"";   
   jFS = new JComboBox(fontSize);

   Border lineBorder = new LineBorder(Color.BLACK,2);//�ŧi�ؽu
   
   //�]�m�ؽu
   p1.setBorder(lineBorder);
   p1_1.setBorder(lineBorder);
   p1_2.setBorder(lineBorder);
   
   //�Ncomponent�[�Jpanel
   p1_1.add(new JLabel("Font Name "));
   p1_1.add(jFN);
   p1_2.add(new JLabel("Font Size "));
   p1_2.add(jFS);

   //�[�J���ʧ@ ��ܦr��
   jFN.addItemListener(new ItemListener(){
    public void itemStateChanged(ItemEvent e) {
     setNewFont(); //����
    }
   });

   jFS.addItemListener(new ItemListener(){
    public void itemStateChanged(ItemEvent e) {
     setNewFont();
    }
   });
   
   //�Ʀn�ާ@panel
   p1.add(p1_1);
   p1.add(p1_2);

   //�Ĥ@�Ӧr�[���u
   jchkCentered.setMnemonic('C');
   jchkBold.setMnemonic('B');
   jchkItalic.setMnemonic('I');
  
   //�Ŀ�panel
   JPanel p3 = new JPanel(new FlowLayout());
   p3.add(jchkCentered);
   p3.add(jchkBold);
   p3.add(jchkItalic);
   
   //�[�J�Ŀ�ʧ@
   jchkCentered.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     p2.setCentered(jchkCentered.isSelected());
    }
   });
   
   jchkBold.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     setNewFont();
    }
   });

   jchkItalic.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     setNewFont();
    }
   });

   jFS.setSelectedIndex(12);

   //�]�wlayout �[�Jpanel
   setLayout(new GridLayout(3,1));
   add(p1);
   add(p2);
   add(p3);
  }

 public static void main(String args[])
  {
   EX16_8 frame = new EX16_8();//��ܵ���
   frame.setTitle("EX16_8");//���D
   frame.setSize(500,200);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 private void setNewFont()  //���ܤ�r
  {
   //�r��y��
   int fontStyle = Font.PLAIN;
   fontStyle += (jchkBold.isSelected() ? Font.BOLD : Font.PLAIN);
   fontStyle += (jchkItalic.isSelected() ? Font.ITALIC : Font.PLAIN);

   int index1 = jFN.getSelectedIndex(); //�r��
   int index2 = jFS.getSelectedIndex(); //�j�p
   p2.setFont(new Font(FontName[index1],fontStyle,index2+1));
  }

 class MessagePanel extends JPanel  //�r������
  {
   //��r��l�y��
   int xCoordinate = 20;
   int yCoordinate = 20;

   String message = "welcome to Java";//��ܤ�r
   boolean centered;//�P�_�O�_�m��

   //�غc�l   
   public MessagePanel()
    {}

   public void setCentered(boolean centered) //�O�_�m��
    {
     this.centered = centered;
     repaint();
    }

   //ø��   
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);

     FontMetrics fm = g.getFontMetrics();
       
     int stringWidth = fm.stringWidth(message);
     int stringAscent = fm.getAscent();
     
     //�P�_�O�_�m�� �վ�y��
     if(centered)
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