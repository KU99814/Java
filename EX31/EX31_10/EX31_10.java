//flag and anthem

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class EX31_10 extends JFrame
{
 private final static int NUMBER_OF_NATIONS = 7;//�ﶵ��
 private int current = 0;//�ثe����
 private AudioClip currentAudioClip;//�{�b���񭵼�
 private ResourceBundle res = ResourceBundle.getBundle("MyResource");//�ޥθ귽

 private int[] delays = {480000,54000,59000,54000,59000,31000,68000,};//���j�ɶ�
 private Timer timer = new Timer(delays[0],new TimerListener());//�p�ɾ�

 private JLabel jlblImageLabel = new JLabel();//��X
 private JButton jbtResume = new JButton("Resume");//���ҫ��s
 private JButton jbtSuspend = new JButton("Suspend");//�Ȱ����s
 private JComboBox jcboNations = new JComboBox(new Object[]
  {"Denmark","Germany","China","India","Norway","UK","US"});//��a�ﶵ
 private Locale[] locales = {
            new Locale("da", "DK"),Locale.GERMANY,Locale.CHINA,
            new Locale("en", "IN"), 
            new Locale("no", "NO"),new Locale("en","UK"),Locale.US};//���y�ﶵ

 public EX31_10()
  {
   //����
   JPanel panel = new JPanel();
   panel.add(jbtResume);
   panel.add(jbtSuspend);
   panel.add(new JLabel("Select"));
   panel.add(jcboNations);
   add(jlblImageLabel,BorderLayout.CENTER);
   add(panel,BorderLayout.SOUTH);

   //���֭���
   jbtResume.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     start(); 
    }
   });

   //���ּȰ�   
   jbtSuspend.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     stop(); 
    }
   });

   //��ܰ�a
   jcboNations.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     stop(); 
     current = jcboNations.getSelectedIndex();
     presentNation(current);
     timer.start();
    }
   });

   //�_�l���A
   timer.start();
   res = ResourceBundle.getBundle("MyResource",locales[0]);
   jlblImageLabel.setIcon(new ImageIcon(getClass().getResource(
      "image/"+res.getString("country")+".gif")));//��X
   jlblImageLabel.setHorizontalAlignment(JLabel.CENTER);
   currentAudioClip = Applet.newAudioClip(
           getClass().getResource("audio/"+res.getString("country")+".mid"));//��q
   currentAudioClip.play();//�}�l����
  }

 //�p�ɾ�
 private class TimerListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     current = (current+1)%NUMBER_OF_NATIONS;
     presentNation(current);
    }
  }

 //���ܰ�q�P��X
 private void presentNation(int index)
  {
   res = ResourceBundle.getBundle("MyResource",locales[index]);//�귽���
   String country = res.getString("country");//�ɮצW��

   //���ܰ�X�P��q
   jlblImageLabel.setIcon(new ImageIcon(getClass().getResource(
      "image/"+country+".gif")
   ));
   jcboNations.setSelectedIndex(index);
   currentAudioClip = Applet.newAudioClip(
           getClass().getResource("audio/"+country+".mid"));
   currentAudioClip.play();
   timer.setDelay(delays[index]);
  }

 //����
 public void start()
  {
   timer.start();
   currentAudioClip.play();
  }

 //�Ȱ�
 public void stop()
  {
   timer.stop();
   currentAudioClip.stop();
  }

 public static void main(String args[])
  {
   EX31_10 frame = new EX31_10();//frame
   
   frame.setSize(400,400);//�j�p
   frame.setTitle("EX31_10");//���D
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����
   frame.setVisible(true);//���
  }
}