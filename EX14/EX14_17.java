//using MessagePanel class in FlowLayout

import javax.swing.*;
import java.awt.*;

public class EX14_17 extends JFrame
{
 public EX14_17()
  {
   setLayout(new BorderLayout());
   
   JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));//�]�wlayout
   
   //�ŧipanel
   MessagePanel message1 = new MessagePanel("message1");
   MessagePanel message2 = new MessagePanel("message2");
   MessagePanel message3 = new MessagePanel("message3");
   MessagePanel message4 = new MessagePanel("message4");

   //�]�w�r��
   message1.setFont(new Font("Californian FB",Font.PLAIN,20));
   message2.setFont(new Font("Californian FB",Font.PLAIN,20));
   message3.setFont(new Font("Californian FB",Font.PLAIN,20));
   message4.setFont(new Font("Californian FB",Font.PLAIN,20));

   //�]�w�I���C��
   message1.setBackground(Color.red);
   message2.setBackground(Color.cyan);
   message3.setBackground(Color.green);
   message4.setBackground(Color.white);

   //�[�Jpanel
   p1.add(message1);
   p1.add(message2);
   p1.add(message3);
   p1.add(message4);
   add(p1,BorderLayout.NORTH);
  }

 public static void main(String args[])
  {
   EX14_17 frame = new EX14_17();//�ŧi����
   frame.setTitle("EX14_17");//���D
   frame.setSize(900,100);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}

//��rpanel
class MessagePanel extends JPanel
{
 private String message = "Welcome to Java";//��ܤ�r

 //�y��  
 private int xCoordinate = 20; 
 private int yCoordinate = 20;

 private boolean centered;//�O�_�b����
 private int interval = 10; //�����ܼ�

 //�غc�l
 public MessagePanel()
  {}

 public MessagePanel(String message)
  {
   this.message = message;
  }

 //���o��r
 public String getMessage()
  {
   return message;
  }

 //�]�w��r
 public void setMessage(String message)
  {
   this.message = message;
   repaint();
  }

 //���oX�y��
 public int getXCoordinate()
  {
   return xCoordinate;
  }

 //�]�wX�y��
 public void setXCoordinate(int xCoordinate)
  {
   this.xCoordinate = xCoordinate;
   repaint();
  }

 //���oY�y��
 public int getYCoordinate()
  {
   return yCoordinate;
  }

 //�]�wY�y��
 public void setYCoordinate(int yCoordinate)
  {
   this.yCoordinate = yCoordinate;
   repaint();
  }

 //�P�_����
 public boolean isCentered()
  {
   return centered;
  }

 //�]�w�O�_����
 public void setCentered(boolean centered)
  {
   this.centered = centered;
   repaint();
  }

 public int getInterval()
  {
   return interval;
  }

 public void setInterval(int interval)
  {
   this.interval = interval;
   repaint();
  }

 //ø��
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);
   
   //�]�m�b����
   if(centered)
    {
     FontMetrics fm = g.getFontMetrics();
     
     int stringWidth = fm.stringWidth(message);
     int stringAscent = fm.getAscent();

     xCoordinate = getWidth()/2 - stringWidth/2;
     yCoordinate = getHeight()/2 + stringAscent/2;
    }

   g.drawString(message,xCoordinate,yCoordinate);
  }

 //����
 public void moveLeft()
  {
   xCoordinate -= interval;
   repaint();
  }

 //�k��
 public void moveRight()
  {
   xCoordinate += interval;
   repaint();
  }

 //�W��
 public void moveUp()
  {
   yCoordinate -= interval;
   repaint();
  }

 //�U��
 public void moveDown()
  {
   yCoordinate += interval;
   repaint();
  }

 public Dimension getPreferredSize()
  {
   return new Dimension(200,30);
  }
}