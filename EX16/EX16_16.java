//�ϥ�Slider�զ�

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.*;

public class EX16_16 extends JFrame
{
 //�H�ƶ��վ��C��
 JSlider JRed = new JSlider(JScrollBar.HORIZONTAL,0,255,0);//��
 JSlider JGreen = new JSlider(JScrollBar.HORIZONTAL,0,255,0);//��
 JSlider JBlue = new JSlider(JScrollBar.HORIZONTAL,0,255,0);//��

 MessagePanel p2 = new MessagePanel();//��ܤ�rpanel
 
 public EX16_16()
  {
   //���Dpanel
   JPanel p1 = new JPanel();
   p1.add(new JLabel("Show Colors"));
   
   //�ާ@panel
   JPanel p3 = new JPanel(new GridLayout(3,2));

   //�ŧi�ó]�w�ؽu
   Border line = new LineBorder(Color.BLACK,2);
   p3.setBorder(line);
   p3.setBorder(new TitledBorder("Choose colors"));
   
   //�[�Jcomponent
   p3.add(new JLabel("Red"));
   p3.add(JRed);
   p3.add(new JLabel("Green"));
   p3.add(JGreen);
   p3.add(new JLabel("Blue"));
   p3.add(JBlue);
   
   //�[�J�ưʰʧ@
   JRed.addChangeListener(new SetMessageColor());
   JGreen.addChangeListener(new SetMessageColor());
   JBlue.addChangeListener(new SetMessageColor());
   
   //��Xpanel
   setLayout(new BorderLayout());
   add(p1,BorderLayout.NORTH);
   add(p2,BorderLayout.CENTER);
   add(p3,BorderLayout.SOUTH);
  }
 
 //�ưʰʧ@
 class SetMessageColor implements ChangeListener
  {
   public void stateChanged(ChangeEvent e)
    { 
     p2.repaint();
    }
  }

 public static void main(String args[])
  {
   EX16_16 frame = new EX16_16();//�ŧi����
   frame.setTitle("EX16_16");//���D
   frame.setSize(300,400);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 class MessagePanel extends JPanel  //�r������
  {
   
   String message = "";//��ܤ�r
   boolean centered;//�O�_�m��
   
   //�غc�l
   public MessagePanel()
    {}

   //�]�w��r
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
   
   //ø��
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //�r��
     FontMetrics fm = g.getFontMetrics();
   
     //�q�ƶ����o�C��Ѽ�
     int R = JRed.getValue();
     int G = JGreen.getValue();
     int B = JBlue.getValue();

     String s = "Red "+R+" Green "+G+" Blue "+B;//��ܤ�r
     
     //���o��r���e
     int stringWidth = fm.stringWidth(s);
     int stringAscent = fm.getAscent();

     //�]�w�C��
     setForeground(new Color(R,G,B));
       
     //��r�y��
     int xCoordinate = getWidth() / 2 - stringWidth/2;
     int yCoordinate = getHeight() / 2 + stringAscent/2;
     
     //ø�X   
     g.drawString(s,xCoordinate,yCoordinate);
    }
  }
}