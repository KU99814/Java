import javax.swing.*;
import java.awt.*;

public class EX13_9 extends JFrame
{
 private int[] r =  new int[3];//�n��ܪ��Ϥ����X

 private ImageIcon card1;   //���J�Ϥ�
 private ImageIcon card2;
 private ImageIcon card3;              

 public EX13_9()
  {
   setLayout(new FlowLayout(FlowLayout.LEFT));              //�]�wlayout
   setPicture();
   
   //Ū���Ϥ�
   card1 = new ImageIcon("card/"+r[0]+".png");   
   card2 = new ImageIcon("card/"+r[1]+".png");
   card3 = new ImageIcon("card/"+r[2]+".png"); 

   add(new JLabel(card1));                                     //���J�Ϥ�
   add(new JLabel(card2));
   add(new JLabel(card3));
  }

 //����n��ܪ��Ϥ�
 private void setPicture()
  {
   int i = 0;
   while(i<3)
    {
     boolean distinct = true;//�P�_�O�_����
     r[i] = (int)(Math.random()*54)+1;//54��1
     for(int j=0;j<i;j++)//�קK����
      {
       if(r[i]==r[j] && i!=j)
        distinct = false;
      }

     if(distinct)
      i++;
    }
  }

 public static void main(String args[])
  {
   EX13_9 frame = new EX13_9(); //�ŧi����
   frame.setTitle("EX13_9");//���D
   frame.setSize(300,150);//�j�p
   frame.setLocationRelativeTo(null);//��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}