import javax.swing.*;

public class EX14_19 extends JFrame
{
 public EX14_19()
  {
   //�H���]�w�ɻP��
   int hour = (int)(Math.random()*12);
   int minute = (int)(Math.random()*60);
   
   StillClock c = new StillClock(hour,minute,0);//�ŧi����panel

   //�]�w���
   c.setHourHandVisible(true);
   c.setMinuteHandVisible(true);

   //�[�J
   add(c);
  }

 public static void main(String args[])
  {
   EX14_19 frame = new EX14_19();//�ŧi��J
   frame.setTitle("EX14_19");//���D
   frame.setSize(400,300);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}