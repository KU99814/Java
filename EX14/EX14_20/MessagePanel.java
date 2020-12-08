import javax.swing.*;
import java.awt.*;

public class MessagePanel extends JPanel
{
 private String message = "Welcome to Java";//顯示文字

 //座標  
 private int xCoordinate = 20; 
 private int yCoordinate = 20;

 private boolean centered;//是否在正中
 private int interval = 10; //移動變數

 //建構子
 public MessagePanel()
  {}

 public MessagePanel(String message)
  {
   this.message = message;
  }

 //取得文字
 public String getMessage()
  {
   return message;
  }

 //設定文字
 public void setMessage(String message)
  {
   this.message = message;
   repaint();
  }

 //取得X座標
 public int getXCoordinate()
  {
   return xCoordinate;
  }

 //設定X座標
 public void setXCoordinate(int xCoordinate)
  {
   this.xCoordinate = xCoordinate;
   repaint();
  }

 //取得Y座標
 public int getYCoordinate()
  {
   return yCoordinate;
  }

 //設定Y座標
 public void setYCoordinate(int yCoordinate)
  {
   this.yCoordinate = yCoordinate;
   repaint();
  }

 //判斷中心
 public boolean isCentered()
  {
   return centered;
  }

 //設定是否中心
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

 //繪圖
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);
   
   //設置在中心
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

 //左移
 public void moveLeft()
  {
   xCoordinate -= interval;
   repaint();
  }

 //右移
 public void moveRight()
  {
   xCoordinate += interval;
   repaint();
  }

 //上移
 public void moveUp()
  {
   yCoordinate -= interval;
   repaint();
  }

 //下移
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