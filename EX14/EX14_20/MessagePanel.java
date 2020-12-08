import javax.swing.*;
import java.awt.*;

public class MessagePanel extends JPanel
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