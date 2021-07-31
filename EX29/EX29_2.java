//racing car by thread

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.concurrent.*;

public class EX29_2 extends JFrame
{
 private RaceCar[] raceCar = new RaceCar[4];//���lø�Ϫ���

 //��J�U�����l�t��
 private JTextField jt1 = new JTextField();
 private JTextField jt2 = new JTextField();
 private JTextField jt3 = new JTextField();
 private JTextField jt4 = new JTextField();

 //constructor
 public EX29_2()
  {
   JPanel p1 = new JPanel(new GridLayout(1,8));//��J�t�����

   //car 1
   p1.add(new JLabel("Car 1:"));
   p1.add(jt1);
   
   //car2
   p1.add(new JLabel("Car 2:"));
   p1.add(jt2);

   //car 3
   p1.add(new JLabel("Car 3:"));
   p1.add(jt3);

   //car 4
   p1.add(new JLabel("Car 4:"));
   p1.add(jt4);

   JPanel p2 = new JPanel(new GridLayout(4,1));//���l���O

   //�ЫئU���lø�Ϫ���å[�J���O
   for(int i =0;i<4;i++)
    {
     raceCar[i] = new RaceCar();
     p2.add(raceCar[i]);
    }

   setLayout(new BorderLayout());//�]�w�ƪ�

   //�N���panel�[�J�Dpanel
   add(p1,BorderLayout.NORTH);
   add(p2,BorderLayout.CENTER);

   
   //��J�t�רç��ܨ��l�t��
   jt1.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     int v1 = Integer.parseInt(jt1.getText());
     raceCar[0].setVector(v1);
    }
   });

   //��J�t�רç��ܨ��l�t��
   jt2.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     int v2 = Integer.parseInt(jt2.getText());
     raceCar[1].setVector(v2);
    }
   });
   
   //��J�t�רç��ܨ��l�t��
   jt3.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     int v1 = Integer.parseInt(jt3.getText());
     raceCar[2].setVector(v1);
    }
   });
   
   //��J�t�רç��ܨ��l�t��
   jt4.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     int v1 = Integer.parseInt(jt4.getText());
     raceCar[3].setVector(v1);
    }
   });
   
   //�Ұʰ���������l�}��
   new Thread(new Driver(raceCar[0])).start();
   new Thread(new Driver(raceCar[1])).start();
   new Thread(new Driver(raceCar[2])).start();
   new Thread(new Driver(raceCar[3])).start();
  }


 //���ʨ��l��task
 class Driver implements Runnable
  {
   RaceCar car;//���l����

   //constructor   
   public Driver(RaceCar car)
    {
     this.car = car;//��l�ƨ��l
    }
 
   //����
   public void run()
    {
     try{
      //���_��ø�����l����
      while(true)
       {
        car.repaint();
        Thread.sleep(10);
       }
     }
     catch(InterruptedException ex){}
    }
  }

 public static void main(String args[])
  {
   SwingUtilities.invokeLater(new Runnable(){
    public void run(){
     EX29_2 frame = new EX29_2();
     frame.setTitle("EX29_2");
     frame.setSize(800,400);
     frame.setLocationRelativeTo(null);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setVisible(true);
    }
   });
  }

 //���lø�Ϫ���
 class RaceCar extends JPanel
  {
   int x = 0;//���X�y��
   int y = 65;//���Y�y��
   int v = 5;//���l�t��
   
   //constructor
   public RaceCar()
    {
     //�[�J���
     setBorder(new LineBorder(Color.black,2));
    }

   //�t�׳]�w
   public void setVector(int v)
    {
     this.v = v;
    }

   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //����
     g.setColor(Color.red);
     g.fillOval(x+getWidth()/40,65,getWidth()/40,getWidth()/40);
     g.fillOval(x+getWidth()/40*3,65,getWidth()/40,getWidth()/40);

     //����
     g.setColor(Color.blue);
     g.fillRect(x,65-getWidth()/40,getWidth()/40*5,getWidth()/40);
     
     //����
     Polygon p = new Polygon();

     p.addPoint(x+getWidth()/40*2,y-getWidth()/40*2);
     p.addPoint(x+getWidth()/40*3,y-getWidth()/40*2);
     p.addPoint(x+getWidth()/40*4,y-getWidth()/40);
     p.addPoint(x+getWidth()/40,y-getWidth()/40);
     
     g.setColor(Color.green);
     g.fillPolygon(p);
     
     x+=v;//x�y�Ц첾
     
     //��F���I�N�^��_�I
     if(x+getWidth()/40*5>getWidth())
      x=0;
    }
  }
}