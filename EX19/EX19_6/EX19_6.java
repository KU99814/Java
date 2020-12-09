//Object IO

import java.awt.*;
import javax.swing.*;
import java.io.*;

public class EX19_6
{
 public static void main(String args[]) throws Exception
  {
   //檔案輸出
   ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("EX19_6.dat"));

   output.writeObject(new TestFrame()); //輸出frame
   output.close();//檔案關閉

   //檔案輸入
   ObjectInputStream input = new ObjectInputStream(new FileInputStream("EX19_6.dat"));

   TestFrame frame = (TestFrame)(input.readObject()); //讀入frame

   //顯示
   frame.setSize(200,200);//大小
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
   
   input.close();//檔案關閉
  }
}

//實作的frame
class TestFrame extends JFrame
{
 public TestFrame()
  {
   add(new JLabel("Hello"));
  }
}

