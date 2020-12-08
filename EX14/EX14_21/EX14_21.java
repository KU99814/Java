import javax.swing.*;
import java.awt.*;

public class EX14_21 extends JFrame
{
 public EX14_21()
  {
   add(new TicTacToe());
  }
 public static void main(String args[])
  {
   EX14_21 frame = new EX14_21();   //宣告視窗
   frame.setTitle("14_21");//標題
   frame.setSize(300,300);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}
class TicTacToe extends JPanel
{
 ImageIcon cross = new ImageIcon("x.gif");   //載入X圖
 ImageIcon not = new ImageIcon("o.gif");     //載入O圖
 
 Image x = cross.getImage();
 Image o = not.getImage();

 //建構子
 public TicTacToe()
  {}

 //繪圖
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);

   int w = getWidth()/3;
   int h = getHeight()/3;
   
   for(int i=0;i<3;i++)
    {
     for(int j=0;j<3;j++)
      {
       int type = (int)(Math.random()*3);//隨機出現OX、空格
       if(type == 1)
        g.drawImage(x,w*i,h*j,w,h,this);
       else if(type==2)
        g.drawImage(o,w*i,h*j,w,h,this);
      }
    }
  }
}
