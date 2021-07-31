//racing car by thread

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.concurrent.*;

public class EX29_2 extends JFrame
{
 private RaceCar[] raceCar = new RaceCar[4];//車子繪圖物件

 //輸入各輛車子速度
 private JTextField jt1 = new JTextField();
 private JTextField jt2 = new JTextField();
 private JTextField jt3 = new JTextField();
 private JTextField jt4 = new JTextField();

 //constructor
 public EX29_2()
  {
   JPanel p1 = new JPanel(new GridLayout(1,8));//輸入速度欄位

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

   JPanel p2 = new JPanel(new GridLayout(4,1));//車子面板

   //創建各車子繪圖物件並加入面板
   for(int i =0;i<4;i++)
    {
     raceCar[i] = new RaceCar();
     p2.add(raceCar[i]);
    }

   setLayout(new BorderLayout());//設定排版

   //將兩種panel加入主panel
   add(p1,BorderLayout.NORTH);
   add(p2,BorderLayout.CENTER);

   
   //輸入速度並改變車子速度
   jt1.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     int v1 = Integer.parseInt(jt1.getText());
     raceCar[0].setVector(v1);
    }
   });

   //輸入速度並改變車子速度
   jt2.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     int v2 = Integer.parseInt(jt2.getText());
     raceCar[1].setVector(v2);
    }
   });
   
   //輸入速度並改變車子速度
   jt3.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     int v1 = Integer.parseInt(jt3.getText());
     raceCar[2].setVector(v1);
    }
   });
   
   //輸入速度並改變車子速度
   jt4.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     int v1 = Integer.parseInt(jt4.getText());
     raceCar[3].setVector(v1);
    }
   });
   
   //啟動執行緒讓車子開動
   new Thread(new Driver(raceCar[0])).start();
   new Thread(new Driver(raceCar[1])).start();
   new Thread(new Driver(raceCar[2])).start();
   new Thread(new Driver(raceCar[3])).start();
  }


 //移動車子的task
 class Driver implements Runnable
  {
   RaceCar car;//車子物件

   //constructor   
   public Driver(RaceCar car)
    {
     this.car = car;//初始化車子
    }
 
   //執行
   public void run()
    {
     try{
      //不斷重繪讓車子移動
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

 //車子繪圖物件
 class RaceCar extends JPanel
  {
   int x = 0;//基準X座標
   int y = 65;//基準Y座標
   int v = 5;//車子速度
   
   //constructor
   public RaceCar()
    {
     //加入邊框
     setBorder(new LineBorder(Color.black,2));
    }

   //速度設定
   public void setVector(int v)
    {
     this.v = v;
    }

   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //車輪
     g.setColor(Color.red);
     g.fillOval(x+getWidth()/40,65,getWidth()/40,getWidth()/40);
     g.fillOval(x+getWidth()/40*3,65,getWidth()/40,getWidth()/40);

     //車身
     g.setColor(Color.blue);
     g.fillRect(x,65-getWidth()/40,getWidth()/40*5,getWidth()/40);
     
     //車頂
     Polygon p = new Polygon();

     p.addPoint(x+getWidth()/40*2,y-getWidth()/40*2);
     p.addPoint(x+getWidth()/40*3,y-getWidth()/40*2);
     p.addPoint(x+getWidth()/40*4,y-getWidth()/40);
     p.addPoint(x+getWidth()/40,y-getWidth()/40);
     
     g.setColor(Color.green);
     g.fillPolygon(p);
     
     x+=v;//x座標位移
     
     //到達終點就回到起點
     if(x+getWidth()/40*5>getWidth())
      x=0;
    }
  }
}