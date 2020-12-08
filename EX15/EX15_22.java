//Game:bean machian animation

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX15_22 extends JFrame
{
 public EX15_22()
  {
   add(new BeanMachine());//�ŧi�å[�Jpanel
  }

 public static void main(String args[])
  {
   EX15_22 frame = new EX15_22();//�ŧi����
   frame.setTitle("EX15_22");//���D
   frame.setSize(300,400);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}

//�y�ipanel
class BeanMachine extends JPanel
{
 //�y�y�а}�C
 int[] ballX = new int[10];
 int[] ballY = new int[10];

 //�ثe��ʨD�y��
 int startBallX = 0;
 int startBallY = 0;

 boolean start = true;//�}�l�H��

 //�O�y��
 int count = 0;
 int rount = 0;//�p���
 int[] rowY = new int[8];//��

 public BeanMachine()
  {
   //�p�ɾ�
   Timer timer = new Timer(100,new TimerListener());
   timer.start();//�}�l�ʧ@
  }

 //�p�ɨƥ�
 public class TimerListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     repaint();//��ø
    }
  }

 //ø��
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);

   //�J�f
   g.drawLine(getWidth()/2-10,getHeight()/2-120,getWidth()/2-10,getHeight()/2-100);
   g.drawLine(getWidth()/2+10,getHeight()/2-120,getWidth()/2+10,getHeight()/2-100);

   //�׽u
   g.drawLine(getWidth()/2-10,getHeight()/2-100,getWidth()/2-80,getHeight()/2+40);
   g.drawLine(getWidth()/2+10,getHeight()/2-100,getWidth()/2+80,getHeight()/2+40);

   //����
   g.drawLine(getWidth()/2-80,getHeight()/2+40,getWidth()/2-80,getHeight()/2+100);
   g.drawLine(getWidth()/2+80,getHeight()/2+40,getWidth()/2+80,getHeight()/2+100);
   g.drawLine(getWidth()/2-80,getHeight()/2+100,getWidth()/2+80,getHeight()/2+100);

   //���
   for(int i=1;i<8;i++)
    g.drawLine(getWidth()/2-80+(20*i),getHeight()/2+40,getWidth()/2-80+(20*i),getHeight()/2+100);

   //�W�l
   for(int i=1;i<8;i++)
    {
     int x = getWidth()/2-10*(i-1);
     int y = getHeight()/2-80 + 20*(i-1); 
     for(int j=1;j<=i;j++)
      g.fillOval(x-5+(j-1)*20,y-10,10,10);
    }

   //�_�l�w�q���
   if(count==0)
    {
     for(int i=0;i<8;i++)
      rowY[i] = getHeight()/2+100-10;
    }
   
   if(start && count<10) //�}�l���A
    {
     startBallX = getWidth()/2-5;     //�s���y��
     startBallY = getHeight()/2-120+10;
     rount = 0;//�M�w������
     start = false;
    }

   else if(!start && count<10)//�������A
    {
     g.setColor(Color.red);
     g.fillOval(startBallX,startBallY,10,10);//�e�y
     
     if(startBallY < getHeight()/2+40) //�y�������e�����
      {
       if((startBallY -(getHeight()/2-80))%20==0) //�I��W�l�ɪ��B�z
        {
         int i = (int)(Math.random()*2);  //�M�w���k
         if(i==0)
          startBallX -=10;
         else if(i==1)
          startBallX +=10;

         rount+=i;
        }
       startBallY+=10; 
      }
     else
      {
       if(startBallY!=rowY[rount]) //�M�w�̲׸��I
        startBallY+=10;
       else
        {
         ballX[count] = startBallX;
         ballY[count] = startBallY;
         rowY[rount]-=10;
         count++;
         start = true;
        }
      }
    }
   
   g.setColor(Color.red);  //ø�X�C�@���y
   for(int i=0;i<count;i++)
    {
     g.fillOval(ballX[i],ballY[i],10,10);
    } 
  }
}