//Heap visualization

import javax.swing.*;

public class EX25_20 extends JFrame
{
 public EX25_20()
  {
   Heap<Integer> tree = new Heap<Integer>();//空heap

   add(new HeapView(tree));//放入視窗
  }

 public static void main(String args[])
  {
   EX25_20 frame = new EX25_20();//宣告
   
   frame.setSize(500,500);//大小
   frame.setTitle("EX25_20");//標題
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}