//��ܪ�����

import javax.swing.*;
import java.awt.*;

public class Histogram extends JPanel
{
 private int[] count;//�p��ƶq

 //��J�}�C
 public void showHistogram(int[] count)
  {
   this.count = count;
   repaint();
  }

 //ø��
 protected void paintComponent(Graphics g)
  {
   if(count == null) 
    return;

   super.paintComponent(g);
   
   //���o�e�����e
   int width = getWidth();
   int height = getHeight();

   //�ھڰ}�C�Ƥ���
   int interval = (width - 30)/count.length;//���j

   int individualWidth = (int)(((width - 40)/24)*0.60);//�����e
   
   int maxCount = 0;
   for(int i=0;i<count.length;i++)
    {
     if(maxCount < count[i])
      maxCount = count[i];
    }

   int x = 30;
   
   g.drawLine(10,height - 15,width - 10,height - 15); //���u
   //���X������
   for(int i=0;i<count.length;i++)
    {
     int barHeight = (int)(((double)count[i] / (double)maxCount) * (height - 55));//����Y

     //�H���C��
     int R = (int)(Math.random()*256);
     int G = (int)(Math.random()*256);
     int B = (int)(Math.random()*256);
     
     //ø��
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