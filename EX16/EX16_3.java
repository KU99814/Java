//Lights

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX16_3 extends JFrame
{
 //�I�����s�s �����ܿO��
 private JRadioButton jRed = new JRadioButton("Red");//��
 private JRadioButton jYellow = new JRadioButton("Yellow");//��
 private JRadioButton jGreen = new JRadioButton("Green");//��
 private JRadioButton jAll = new JRadioButton("All");//����

 public EX16_3()
  {
   final FigurePanel p1 = new FigurePanel();//��ܿOpanel
   JPanel p2 = new JPanel(new FlowLayout());//���spanel
   
   //�[�J���s
   p2.add(jRed);
   p2.add(jYellow);
   p2.add(jGreen);
   p2.add(jAll);

   //�N���s�k���@�s   
   ButtonGroup group= new ButtonGroup();
   group.add(jRed);
   group.add(jYellow);
   group.add(jGreen);
   group.add(jAll);

   //�[�J���s�ʧ@ ��ܿO��
   jRed.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p1.setRedLight();
    }
   });

   jYellow.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p1.setYellowLight();
    }
   });

   jGreen.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p1.setGreenLight();
    }
   });

   jAll.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p1.setAllLight();
    }
   });

   //�Ĥ@�Ӧr�[���u
   jRed.setMnemonic('R');
   jYellow.setMnemonic('Y');
   jGreen.setMnemonic('G');
   jAll.setMnemonic('A');
   
   jRed.setSelected(true);//��l���A

   setLayout(new BorderLayout());//�]�wlayout

   //�[�Jpanel
   add(p1,BorderLayout.CENTER);
   add(p2,BorderLayout.SOUTH);
  }

 public static void main(String args[])
  {
   EX16_3 frame = new EX16_3();//�ŧi����
   frame.setTitle("EX16_3");//���D
   frame.setSize(300,200);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 class FigurePanel extends JPanel
  {
   //��ܪ��A�ܼ�
   final int RED = 1;
   final int YELLOW = 2;
   final int GREEN = 3;
   final int ALL = 4;
   
   int light = 1;//�{�b�����A

   public void setRedLight() //���O
    {
     light = RED;
     repaint();
    }
   
   public void setYellowLight() //���O
    {
     light = YELLOW;
     repaint();
    }
   
   public void setGreenLight()  //��O
    {
     light = GREEN;
     repaint();
    }

   public void setAllLight() //���G
    {
     light = ALL;
     repaint();
    }

   //ø��   
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);

     //�_�l�y��
     int x = getWidth()/2;
     int y = 5;

     //�T�ӿO �Ů�
     g.setColor(Color.black);
     g.drawRect(x-10,y,20,20);
     g.drawRect(x-10,y+20,20,20);
     g.drawRect(x-10,y+40,20,20);
     //�ھڪ��Aø��   
     switch(light)
      {
       case RED :   g.setColor(Color.red);
                    g.fillRect(x-10,y,20,20);//�I�G���O
                    break;            
       case YELLOW :g.setColor(Color.yellow);
                    g.fillRect(x-10,y+20,20,20);//�I�G���O
                    g.setColor(Color.black);
                    g.drawLine(x-10,y+20,x+10,y+20);
                    break;
       case GREEN : g.setColor(Color.green);
                    g.fillRect(x-10,y+40,20,20);//�I�G��O
                    g.setColor(Color.black);
                    g.drawLine(x-10,y+40,x+10,y+40);
                    break;

       case ALL :   g.setColor(Color.red);
                    g.fillRect(x-10,y,20,20);
                    g.setColor(Color.yellow);
                    g.fillRect(x-10,y+20,20,20);
                    g.setColor(Color.green);
                    g.fillRect(x-10,y+40,20,20);
                    g.setColor(Color.black);
                    g.drawRect(x-10,y,20,20);
                    g.drawRect(x-10,y+20,20,20); break;
      }
     g.setColor(Color.black);
     g.drawRect(x-10,y,20,60); //��������
    }
  }
}      