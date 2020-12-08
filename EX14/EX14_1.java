//Displaying nine rectangles as a grid

import javax.swing.*;
import java.awt.*;

public class EX14_1 extends JFrame 
{
 public EX14_1()
  {
   JPanel p1 = new NineRectangle();//�ŧipanel
   add(p1);
  }

 public static void main(String args[])
  {
   EX14_1 frame = new EX14_1();//�ŧi����
   frame.setSize(300,150);//�j�p
   frame.setTitle("EX14_1"); //���D
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true); //���
  }
}

//��ܪ����grid
class NineRectangle extends JPanel
{
 //ø��
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);//���n
   
   int width = getSize().width;   //�e����
   int height = getSize().height; //�e���e
   
   int w = (int)(width/3); //���
   int h = (int)(height/3);


   //�E�Ӫ����
   g.setColor(Color.black);//��
   g.fillRect(w*0,h*0,w,h);

   g.setColor(Color.red);//��
   g.fillRect(w*1,h*0,w,h);

   g.setColor(Color.blue);//��
   g.fillRect(w*2,h*0,w,h);

   g.setColor(Color.white);//��
   g.fillRect(w*0,h*1,w,h);

   g.setColor(Color.yellow);//��
   g.fillRect(w*1,h*1,w,h);

   g.setColor(Color.green);//��
   g.fillRect(w*2,h*1,w,h);

   g.setColor(Color.gray);//��
   g.fillRect(w*0,h*2,w,h);
   
   g.setColor(Color.pink);//����
   g.fillRect(w*1,h*2,w,h);

   g.setColor(Color.orange);//��
   g.fillRect(w*2,h*2,w,h);
  }
}