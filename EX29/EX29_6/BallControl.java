//整體panle

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BallControl extends JPanel
{
 private BallPanel ballPanel = new BallPanel();//繪出球的panel

 private JButton jbtSuspend = new JButton("Suspend");//暫停按鈕
 private JButton jbtResume = new JButton("Resume");//重新開始按鈕
 private JButton jbtStart = new JButton("Start");//讓球開始動作按鈕
 private JButton jbtAdd = new JButton("+1");//增加球按鈕
 private JButton jbtSubtract = new JButton("-1");//減少球按鈕
 
 private JScrollBar jsbDelay = new JScrollBar(JScrollBar.HORIZONTAL,0,0,0,100);//調整速度拉條

 //constructor
 public BallControl()
  {
   JPanel panel = new JPanel();//按鈕panel

   //將按鈕加入
   panel.add(jbtSuspend);
   panel.add(jbtResume);
   panel.add(jbtStart);
   panel.add(jbtAdd);
   panel.add(jbtSubtract);

   ballPanel.setBorder(new javax.swing.border.LineBorder(Color.red));//設定框線
   
   ballPanel.setDelay(jsbDelay.getMinimum());//delay時間

   //將各panel整合 
   setLayout(new BorderLayout());
   add(jsbDelay,BorderLayout.NORTH);
   add(ballPanel,BorderLayout.CENTER);
   add(panel,BorderLayout.SOUTH);

   //加入暫停按鈕事件  
   jbtSuspend.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
      ballPanel.suspend();//ball panel暫停
    }
   });

   //加入重新開始事件
   jbtResume.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     ballPanel.resume();//ball panel重新開始繪圖
    }
   });

   //加入讓新加入球開始運動按鈕事件
   jbtStart.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     ballPanel.start();
    }
   });

   //加入新加入球按鈕事件
   jbtAdd.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     ballPanel.addNumber();
    }
   });

   //加入減少球按鈕事件
   jbtSubtract.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     ballPanel.subNumber();
    }
   });

   //加入拉條控制速度事件
   jsbDelay.addAdjustmentListener(new AdjustmentListener(){
    public void adjustmentValueChanged(AdjustmentEvent e){
     ballPanel.setDelay(e.getValue());
    }
   });

   new Thread(ballPanel).start();//執行緒開始執行
  }
}