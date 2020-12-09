//顯示長條圖

import javax.swing.*;
import java.awt.*;

public class Histogram extends JPanel
{
 private int[] count;//計算數量

 //輸入陣列
 public void showHistogram(int[] count)
  {
   this.count = count;
   repaint();
  }

 //繪圖
 protected void paintComponent(Graphics g)
  {
   if(count == null) 
    return;

   super.paintComponent(g);
   
   //取得畫面長寬
   int width = getWidth();
   int height = getHeight();

   //根據陣列數分割
   int interval = (width - 30)/count.length;//間隔

   int individualWidth = (int)(((width - 40)/24)*0.60);//長條寬
   
   int maxCount = 0;
   for(int i=0;i<count.length;i++)
    {
     if(maxCount < count[i])
      maxCount = count[i];
    }

   int x = 30;
   
   g.drawLine(10,height - 15,width - 10,height - 15); //底線
   //劃出長條圖
   for(int i=0;i<count.length;i++)
    {
     int barHeight = (int)(((double)count[i] / (double)maxCount) * (height - 55));//底部Y

     //隨機顏色
     int R = (int)(Math.random()*256);
     int G = (int)(Math.random()*256);
     int B = (int)(Math.random()*256);
     
     //繪圖
     g.setColor(new Color(R,G,B));
     g.fillRect(x,height - 15 - barHeight,individualWidth,barHeight);
     g.setColor(Color.BLACK);
     g.drawString((char)(65+i) + "",x,height - 25 - barHeight);
     
     x += interval;
    }
  }

 public Dimension getPreferredSize()
  {
   return new Dimension(300,300);
  }
}