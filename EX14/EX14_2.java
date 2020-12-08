//Displaying nine rectangles as a grid using an array

import javax.swing.*;
import java.awt.*;

public class EX14_2 extends JFrame 
{
 public EX14_2()
  {
   JPanel p = new NineRectangle();//�ŧi
   
   add(p);
  }

 public static void main(String args[])
  {
   EX14_2 frame = new EX14_2();//�ŧi����
   frame.setSize(300,150);//�ŧi�j�p
   frame.setTitle("EX14_2");//���D
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}

//ø�s�����panel
class NineRectangle extends JPanel
{
 //�غc�l
 public NineRectangle()
  {}

 //ø��
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);
   
   //����Ϊ��e
   int width = getSize().width/3;   //�e����/3
   int height = getSize().height/3; //�e���e/3

 
   //�E�Ӫ�����C��
   Color[] color = {Color.red,Color.blue,Color.white,
                    Color.yellow,Color.green,Color.gray,
                    Color.pink,Color.orange,Color.black};

   int c = 0;//�C��index
   for(int i=0;i<3;i++)
    {
     for(int j=0;j<3;j++)
      {   
       g.setColor(color[c]);//�]�w�C��
       g.fillRect(width*i,height*j,width,height); //ø�s�����
       c++;//�U�@��index
      }
    }
  }
}