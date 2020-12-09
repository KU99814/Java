//��ܪ�����

import javax.swing.*;
import java.awt.*;

public class Histogram extends JPanel
{
 private int[] count;//�x�s�p��

 //�s�J�}�C
 public void showHistogram(int[] count)
  {
   this.count = count;
   repaint();
  }

 //ø��
 protected void paintComponent(Graphics g)
  {
   //�p�G�S���p��
   if(count == null) 
    return;

   super.paintComponent(g);
   
   //���o�e�����e
   int width = getWidth();
   int height = getHeight();

   //�ھڪ��e�p�ⶡ��P�����e
   int interval = (width - 40)/count.length;
   int individualWidth = (int)(((width - 40)/24)*0.60);
   
   //���̤j�Ȱ���ҭp��
   int maxCount = 0;
   for(int i=0;i<count.length;i++)
    {
     if(maxCount < count[i])
      maxCount = count[i];
    }

   int x = 30;//�_�lX
   
   g.drawLine(10,height - 45,width - 10,height - 45); //���u
   //���X������
   for(int i=0;i<count.length;i++)
    {
     int barHeight = (int)(((double)count[i] / (double)maxCount) * (height - 55));//��������Y
     
     //ø��
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