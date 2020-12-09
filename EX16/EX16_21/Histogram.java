//顯示長條圖

import javax.swing.*;
import java.awt.*;

public class Histogram extends JPanel
{
 private int[] count;//儲存計數

 //存入陣列
 public void showHistogram(int[] count)
  {
   this.count = count;
   repaint();
  }

 //繪圖
 protected void paintComponent(Graphics g)
  {
   //如果沒有計數
   if(count == null) 
    return;

   super.paintComponent(g);
   
   //取得畫面長寬
   int width = getWidth();
   int height = getHeight();

   //根據長寬計算間格與長條寬
   int interval = (width - 40)/count.length;
   int individualWidth = (int)(((width - 40)/24)*0.60);
   
   //取最大值做比例計算
   int maxCount = 0;
   for(int i=0;i<count.length;i++)
    {
     if(maxCount < count[i])
      maxCount = count[i];
    }

   int x = 30;//起始X
   
   g.drawLine(10,height - 45,width - 10,height - 45); //底線
   //劃出長條圖
   for(int i=0;i<count.length;i++)
    {
     int barHeight = (int)(((double)count[i] / (double)maxCount) * (height - 55));//長條頂部Y
     
     //繪圖
     g.drawRect(x,height - 45 - barHeight,individualWidth,barHeight);
     g.drawString((char)(65+i) + "",x,height - 30);
     
     x += interval;
    }
  }

 public Dimension getPreferredSize()
  {
   return new Dimension(300,300);
  }
}