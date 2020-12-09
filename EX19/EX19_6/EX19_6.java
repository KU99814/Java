//Object IO

import java.awt.*;
import javax.swing.*;
import java.io.*;

public class EX19_6
{
 public static void main(String args[]) throws Exception
  {
   //�ɮ׿�X
   ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("EX19_6.dat"));

   output.writeObject(new TestFrame()); //��Xframe
   output.close();//�ɮ�����

   //�ɮ׿�J
   ObjectInputStream input = new ObjectInputStream(new FileInputStream("EX19_6.dat"));

   TestFrame frame = (TestFrame)(input.readObject()); //Ū�Jframe

   //���
   frame.setSize(200,200);//�j�p
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
   
   input.close();//�ɮ�����
  }
}

//��@��frame
class TestFrame extends JFrame
{
 public TestFrame()
  {
   add(new JLabel("Hello"));
  }
}

