import javax.swing.*;
import java.awt.*;

public class EX14_18 extends JFrame
{
 public EX14_18()
  {
   setLayout(new GridLayout(1,2));//�]�wlayout

   //�[�J����panel
   add(new StillClock(4,20,45));
   add(new StillClock(22,46,15));
  }

 public static void main(String args[])
  {
   EX14_18 frame = new EX14_18();//�ŧi����
   frame.setTitle("EX14_18");//���D
   frame.setSize(400,300);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}
