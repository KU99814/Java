//Using JSplitPane

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class EX33_8 extends JFrame
{
 //��ܭ��O
 private FigurePanel squarePanel = new FigurePanel();
 private FigurePanel rectanglePanel = new FigurePanel();
 private FigurePanel circlePanel = new FigurePanel();
 private FigurePanel ovalPanel = new FigurePanel();

 public EX33_8()
  {
   //�]�w�n��ܤ���
   squarePanel.setType(FigurePanel.LINE);
   rectanglePanel.setType(FigurePanel.RECTANGLE);
   circlePanel.setType(FigurePanel.ROUND_RECTANGLE);
   ovalPanel.setType(FigurePanel.OVAL);

   //�]�w�j�p
   circlePanel.setSize(200,150);
   ovalPanel.setSize(300,150);
   rectanglePanel.setSize(250,150);
   squarePanel.setSize(250,150);

   //��J���Ϊ���
   JSplitPane jSplitPane2 = new JSplitPane(
     JSplitPane.HORIZONTAL_SPLIT,true,ovalPanel,circlePanel);

   jSplitPane2.setDividerLocation(100);

   JSplitPane jSplitPane3 = new JSplitPane(
     JSplitPane.HORIZONTAL_SPLIT,rectanglePanel,squarePanel);
   
   jSplitPane3.setDividerLocation(300);
   
   JSplitPane jSplitPane1 = new JSplitPane(
     JSplitPane.VERTICAL_SPLIT,jSplitPane2,jSplitPane3);
   
   jSplitPane1.setDividerLocation(150);
   
   add(jSplitPane1,BorderLayout.CENTER);
  }

 public static void main(String args[])
  {
   EX33_8 frame = new EX33_8();
   
   frame.setTitle("EX33_8");//���D
   frame.setSize(600,400);//�j�p
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