//圖形化 knight tour

import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KnightTourApp extends JFrame
{
 private KnightTourModel model = new KnightTourModel();//knight tour object
 private PaintKnightTour paintKnightTour = new PaintKnightTour();//繪出panel
 private JButton jbtSearch = new JButton("Search");//開始走訪按鈕
 static int num = 6;//行數
 
 public KnightTourApp()
  {
   JPanel panel = new JPanel();//操作panel 加入各種操作component
   panel.add(new JLabel("start knight tour by Hamiltonian Cycle "));//說明文字
   panel.add(jbtSearch);//加入走訪按鈕
   add(paintKnightTour,BorderLayout.CENTER);//加入繪圖panel
   add(panel,BorderLayout.SOUTH);//加入操作panel

   //按鈕事件
   jbtSearch.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){

     //取得Hamiltonian Cycle 路徑
     List<Integer> path =model.getHamiltonianCycle();

     paintKnightTour.displayPath(path);//將路徑匯入繪圖panel

     //如果路徑不存在 顯示null
     if(path==null)
      System.out.println("null");
    }
   });
  }

 //繪圖panel
 private static class PaintKnightTour extends JPanel
  {
   private List<Integer> path;//Hamiltonian Cycle路徑
   
   //default
   public PaintKnightTour()
    {
     setBorder(BorderFactory.createLineBorder(Color.black,1));//加入邊框
    }

   //加入路徑
   public void displayPath(List<Integer> path)
    {
     this.path = path;
     repaint();
    }

   //繪圖
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //繪出格線 橫線
     for(int i=0;i<num;i++)
      g.drawLine(0,i*getHeight()/num,getWidth(),i*getHeight()/num);
     
     //繪出格線 縱線
     for(int i=0;i<num;i++)
      g.drawLine(i*getWidth()/num,0,i*getWidth()/num,getHeight());
     
     //若無路徑 結束
     if(path == null)
      return;
     
     //繪出路徑
     for(int i=0;i<path.size()-1;i++)
      {
       int u=path.get(i);//起始點
       int v = path.get(i+1);//終點
       
       //線條 起點到終點
       g.drawLine((u%num)*getWidth()/num+getWidth()/(num*2),
          (u/num)*getHeight()/num+getHeight()/(num*2),
          (v%num)*getWidth()/num+getWidth()/(num*2),
          (v/num)*getHeight()/num+getHeight()/(num*2));
      }
    }
  }
}