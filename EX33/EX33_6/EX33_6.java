//Using tabbed panes

import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX33_6 extends JFrame
{
 private JTabbedPane jtpFigures = new JTabbedPane(); //����pane
 private FigurePanel squarePanel = new FigurePanel();
 private FigurePanel rectanglePanel = new FigurePanel();
 private FigurePanel circlePanel = new FigurePanel();
 private FigurePanel ovalPanel = new FigurePanel();

 private JRadioButton jrbTop = new JRadioButton("Top",true);
 private JRadioButton jrbLeft = new JRadioButton("Left");
 private JRadioButton jrbRight = new JRadioButton("Right");
 private JRadioButton jrbBottom = new JRadioButton("Bottom");

 public EX33_6()
  {
   //�]�w��ܹϮ�
   squarePanel.setType(FigurePanel.LINE);
   rectanglePanel.setType(FigurePanel.RECTANGLE);
   circlePanel.setType(FigurePanel.ROUND_RECTANGLE);
   ovalPanel.setType(FigurePanel.OVAL);
   
   ButtonGroup btg = new ButtonGroup();
   btg.add(jrbTop);
   btg.add(jrbLeft);
   btg.add(jrbRight);
   btg.add(jrbBottom);

   JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
   radioPanel.add(jrbTop);
   radioPanel.add(jrbLeft);
   radioPanel.add(jrbRight);
   radioPanel.add(jrbBottom);

   add(jtpFigures,BorderLayout.CENTER);
   add(radioPanel,BorderLayout.SOUTH);

   jtpFigures.add(squarePanel,"Line");
   jtpFigures.add(rectanglePanel,"Rectangle");
   jtpFigures.add(circlePanel,"Round Rectangle");
   jtpFigures.add(ovalPanel,"Oval");

   jtpFigures.setToolTipTextAt(0,"Square");
   jtpFigures.setToolTipTextAt(1,"Rectangle");
   jtpFigures.setToolTipTextAt(2,"Circle");
   jtpFigures.setToolTipTextAt(3,"Oval");

   //�I��ƥ� �M�w�������Ҧ�m
   jrbTop.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     jtpFigures.setTabPlacement(JTabbedPane.TOP);
     jtpFigures.revalidate();
    }
   });

   jrbLeft.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     jtpFigures.setTabPlacement(JTabbedPane.LEFT);
     jtpFigures.revalidate();
    }
   });

   jrbRight.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     jtpFigures.setTabPlacement(JTabbedPane.RIGHT);
     jtpFigures.revalidate();
    }
   });

   jrbBottom.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     jtpFigures.setTabPlacement(JTabbedPane.BOTTOM);
     jtpFigures.revalidate();
    }
   });
  }

 public static void main(String args[])
  {
   EX33_6 frame = new EX33_6();
   
   frame.setTitle("EX33_6");//���D
   frame.setSize(500,300);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

//ø�Ϫ�panel
class FigurePanel extends JPanel
{
 //�֦���ø�s����
 public static final int LINE = 1;  //line
 public static final int RECTANGLE = 2;  //rectangle
 public static final int ROUND_RECTANGLE = 3; //round rectangle
 public static final int OVAL = 4; //oval

 private int type = 1;//��ܪ�ø�s����
 private boolean filled = false;//�O�_��R

 //�غc�l
 public FigurePanel()
  {}

 //�غc�l
 public FigurePanel(int type)
  {
   this.type = type;
  }

 //�غc�l
 public FigurePanel(int type,boolean filled)
  {
   this.type = type;
   this.filled = filled;
  }

 //ø��
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);
   
   int width = getSize().width;
   int height = getSize().height;

   //paint graphic by type
   switch(type)
    {
     case LINE:  g.setColor(Color.BLACK);
                 g.drawLine(10,10,width - 10,height - 10);
                 g.drawLine(width - 10,10,10,height - 10);
                 break;
     case RECTANGLE:  
                 g.setColor(Color.BLUE);
                 if(filled)
                  g.fillRect((int)(0.1*width),(int)(0.1*height),
                    (int)(0.8*width),(int)(0.8 * height));
                 else
                  g.drawRect((int)(0.1*width),(int)(0.1*height),
                    (int)(0.8*width),(int)(0.8 * height));
                 break;
     case ROUND_RECTANGLE:
                 g.setColor(Color.RED);
                 if(filled)
                  g.fillRoundRect((int)(0.1*width),(int)(0.1*height),
                    (int)(0.8*width),(int)(0.8 * height),20,20);
                 else
                  g.drawRoundRect((int)(0.1*width),(int)(0.1*height),
                    (int)(0.8*width),(int)(0.8 * height),20,20);
                 break;
     case OVAL: g.setColor(Color.BLACK);
                 if(filled)
                  g.fillOval((int)(0.1*width),(int)(0.1*height),
                    (int)(0.8*width),(int)(0.8 * height));
                 else
                  g.drawOval((int)(0.1*width),(int)(0.1*height),
                    (int)(0.8*width),(int)(0.8 * height));
                 break;
    }
  } 
 public void setType(int type)
  {
   this.type = type;
   repaint();
  }
}
}

