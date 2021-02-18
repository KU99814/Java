import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HeapView extends JPanel
{
 private Heap<Integer> heap;//heap
 private JTextField jtfKey = new JTextField(5);//輸入欄位 輸入要搜尋數字
 private PaintTree paintTree = new PaintTree();//視覺化heap視窗
 private JButton jbtInsert = new JButton("Insert");//插入按鈕
 private JButton jbtDelete = new JButton("Remove the root");//移除按鈕

 //default
 public HeapView(Heap<Integer> heap)
  {
   this.heap = heap;//放入heap
   setUI();//設定UI
  }

 //設定UI
 public void setUI()
  {
   this.setLayout(new BorderLayout());//放置方式設定
   add(paintTree,BorderLayout.CENTER);//加入繪圖panel
   JPanel panel = new JPanel();//操縱欄位整合
   
   //將component放入操縱欄位
   panel.add(new JLabel("Enter a key"));//文字
   panel.add(jtfKey);//輸入欄位
   panel.add(jbtInsert);//插入按鈕
   panel.add(jbtDelete);//移除按鈕
   add(panel,BorderLayout.SOUTH);//放入frame
   
   //按鈕事件 插入element
   jbtInsert.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     int key = Integer.parseInt(jtfKey.getText());//取得輸入數字
     heap.add(key);//加入heap
     paintTree.repaint();//重繪
    }
   });

   //移除事件 移除root
   jbtDelete.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     heap.remove();//heap移除
     paintTree.repaint();//重繪
    }
   });
  }

 //繪圖panel
 class PaintTree extends JPanel
  {
   private int radius = 20;//圓半徑
   private int vGap = 50;//計算連線點位置
   
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //將樹繪出
     if(heap.getSize() != 0)
      displayTree(g,0,getWidth() / 2,30,getWidth()/4);
    }

   //繪出樹
   private void displayTree(Graphics g,int index,int x,int y,int hGap)
    {
     g.drawOval(x - radius,y - radius,2 * radius,2*radius);//圓圈
     g.drawString(heap.get(index) + "",x-6,y+4);//node內容
     
     //若有左子樹
     if(index*2+1 <heap.getSize())
      {
       connectLeftChild(g,x-hGap,y+vGap,x,y);
       displayTree(g,index*2+1,x-hGap,y+vGap,hGap/2);
      }

     //若有右子樹
     if(index*2+2 <heap.getSize())
      {
       connectRightChild(g,x+hGap,y+vGap,x,y);
       displayTree(g,index*2+2,x+hGap,y+vGap,hGap/2);
      }
    }

   //繪制左子樹連接線
   private void connectLeftChild(Graphics g,int x1,int y1,int x2,int y2)
    {
     double d = Math.sqrt(vGap*vGap+(x2-x1)*(x2-x1));
     int x11 = (int)(x1+radius*(x2-x1)/d);
     int y11 = (int)(y1-radius*vGap/d);
     int x21 = (int)(x2-radius*(x2-x1)/d);
     int y21 = (int)(y2+radius*vGap/d);
     
     g.drawLine(x11,y11,x21,y21);//繪線
    }

   //繪制右子樹連接線
   private void connectRightChild(Graphics g,int x1,int y1,int x2,int y2)
    {
     double d = Math.sqrt(vGap*vGap+(x2-x1)*(x2-x1));
     int x11 = (int)(x1-radius*(x1-x2)/d);
     int y11 = (int)(y1-radius*vGap/d);
     int x21 = (int)(x2+radius*(x1-x2)/d);
     int y21 = (int)(y2+radius*vGap/d);
     
     g.drawLine(x11,y11,x21,y21);//繪線
    }
  }
}