//flag and anthem

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class EX31_10 extends JFrame
{
 private final static int NUMBER_OF_NATIONS = 7;//選項數
 private int current = 0;//目前索引
 private AudioClip currentAudioClip;//現在撥放音樂
 private ResourceBundle res = ResourceBundle.getBundle("MyResource");//引用資源

 private int[] delays = {480000,54000,59000,54000,59000,31000,68000,};//間隔時間
 private Timer timer = new Timer(delays[0],new TimerListener());//計時器

 private JLabel jlblImageLabel = new JLabel();//國旗
 private JButton jbtResume = new JButton("Resume");//重啟按鈕
 private JButton jbtSuspend = new JButton("Suspend");//暫停按鈕
 private JComboBox jcboNations = new JComboBox(new Object[]
  {"Denmark","Germany","China","India","Norway","UK","US"});//國家選項
 private Locale[] locales = {
            new Locale("da", "DK"),Locale.GERMANY,Locale.CHINA,
            new Locale("en", "IN"), 
            new Locale("no", "NO"),new Locale("en","UK"),Locale.US};//國籍選項

 public EX31_10()
  {
   //介面
   JPanel panel = new JPanel();
   panel.add(jbtResume);
   panel.add(jbtSuspend);
   panel.add(new JLabel("Select"));
   panel.add(jcboNations);
   add(jlblImageLabel,BorderLayout.CENTER);
   add(panel,BorderLayout.SOUTH);

   //音樂重啟
   jbtResume.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     start(); 
    }
   });

   //音樂暫停   
   jbtSuspend.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     stop(); 
    }
   });

   //選擇國家
   jcboNations.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     stop(); 
     current = jcboNations.getSelectedIndex();
     presentNation(current);
     timer.start();
    }
   });

   //起始狀態
   timer.start();
   res = ResourceBundle.getBundle("MyResource",locales[0]);
   jlblImageLabel.setIcon(new ImageIcon(getClass().getResource(
      "image/"+res.getString("country")+".gif")));//國旗
   jlblImageLabel.setHorizontalAlignment(JLabel.CENTER);
   currentAudioClip = Applet.newAudioClip(
           getClass().getResource("audio/"+res.getString("country")+".mid"));//國歌
   currentAudioClip.play();//開始播放
  }

 //計時器
 private class TimerListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     current = (current+1)%NUMBER_OF_NATIONS;
     presentNation(current);
    }
  }

 //改變國歌與國旗
 private void presentNation(int index)
  {
   res = ResourceBundle.getBundle("MyResource",locales[index]);//資源文件
   String country = res.getString("country");//檔案名稱

   //改變國旗與國歌
   jlblImageLabel.setIcon(new ImageIcon(getClass().getResource(
      "image/"+country+".gif")
   ));
   jcboNations.setSelectedIndex(index);
   currentAudioClip = Applet.newAudioClip(
           getClass().getResource("audio/"+country+".mid"));
   currentAudioClip.play();
   timer.setDelay(delays[index]);
  }

 //播放
 public void start()
  {
   timer.start();
   currentAudioClip.play();
  }

 //暫停
 public void stop()
  {
   timer.stop();
   currentAudioClip.stop();
  }

 public static void main(String args[])
  {
   EX31_10 frame = new EX31_10();//frame
   
   frame.setSize(400,400);//大小
   frame.setTitle("EX31_10");//標題
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉
   frame.setVisible(true);//顯示
  }
}