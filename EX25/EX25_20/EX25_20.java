//Heap visualization

import javax.swing.*;

public class EX25_20 extends JFrame
{
 public EX25_20()
  {
   Heap<Integer> tree = new Heap<Integer>();//��heap

   add(new HeapView(tree));//��J����
  }

 public static void main(String args[])
  {
   EX25_20 frame = new EX25_20();//�ŧi
   
   frame.setSize(500,500);//�j�p
   frame.setTitle("EX25_20");//���D
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}