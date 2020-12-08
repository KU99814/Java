import javax.swing.*;
import java.awt.*;

public class EX13_9 extends JFrame
{
 private int[] r =  new int[3];//要顯示的圖片號碼

 private ImageIcon card1;   //載入圖片
 private ImageIcon card2;
 private ImageIcon card3;              

 public EX13_9()
  {
   setLayout(new FlowLayout(FlowLayout.LEFT));              //設定layout
   setPicture();
   
   //讀取圖片
   card1 = new ImageIcon("card/"+r[0]+".png");   
   card2 = new ImageIcon("card/"+r[1]+".png");
   card3 = new ImageIcon("card/"+r[2]+".png"); 

   add(new JLabel(card1));                                     //插入圖片
   add(new JLabel(card2));
   add(new JLabel(card3));
  }

 //選取要顯示的圖片
 private void setPicture()
  {
   int i = 0;
   while(i<3)
    {
     boolean distinct = true;//判斷是否重複
     r[i] = (int)(Math.random()*54)+1;//54選1
     for(int j=0;j<i;j++)//避免重複
      {
       if(r[i]==r[j] && i!=j)
        distinct = false;
      }

     if(distinct)
      i++;
    }
  }

 public static void main(String args[])
  {
   EX13_9 frame = new EX13_9(); //宣告視窗
   frame.setTitle("EX13_9");//標題
   frame.setSize(300,150);//大小
   frame.setLocationRelativeTo(null);//位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}