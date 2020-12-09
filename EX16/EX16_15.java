import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class EX16_15 extends JFrame
{
 //�ŧi�u�ʱ��H�վ��C��
 JScrollBar JRed = new JScrollBar(JScrollBar.HORIZONTAL,0,0,0,255);//��
 JScrollBar JGreen = new JScrollBar(JScrollBar.HORIZONTAL,0,0,0,255);//��
 JScrollBar JBlue = new JScrollBar(JScrollBar.HORIZONTAL,0,0,0,255);//��

 MessagePanel p2 = new MessagePanel();//��ܤ�rpanel
 
 public EX16_15()
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

   
   //�[�J�ʧ@ �����C���ܼ�
   JRed.addAdjustmentListener(new SetMessageColor());
   JGreen.addAdjustmentListener(new SetMessageColor());
   JBlue.addAdjustmentListener(new SetMessageColor());
   
   //��X����
   setLayout(new BorderLayout());
   add(p1,BorderLayout.NORTH);
   add(p2,BorderLayout.CENTER);
   add(p3,BorderLayout.SOUTH);
  }

 public static void main(String args[])
  {
   EX16_15 frame = new EX16_15();//�ŧi����
   frame.setTitle("EX16_15");//���D
   frame.setSize(300,400);//�j�p
   frame.setLocationRelativeTo(null);//������m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 //�u�ʱ��ʧ@
 class SetMessageColor implements AdjustmentListener
  {
   public void adjustmentValueChanged(AdjustmentEvent e)
    { 
     p2.repaint();//��ø
    }
  }

 class MessagePanel extends JPanel  //�r������
  {
   
   String message = "";//��ܤ�r
   boolean centered;  //�O�_�m��
   
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
     
     //�]�w�r��
     FontMetrics fm = g.getFontMetrics();
   
     //�q�u�ʱ����o�C��Ѽ�
     int R = JRed.getValue();
     int G = JGreen.getValue();
     int B = JBlue.getValue();

     String s = "Red "+R+" Green "+G+" Blue "+B;//��ܪ���r
       
     int stringWidth = fm.stringWidth(s);
     int stringAscent = fm.getAscent();

     
     setForeground(new Color(R,G,B));//�I���C��
       
     int xCoordinate = getWidth() / 2 - stringWidth/2;
     int yCoordinate = getHeight() / 2 + stringAscent/2;
     
     //ø�X��r   
     g.drawString(s,xCoordinate,yCoordinate);
    }
  }
}