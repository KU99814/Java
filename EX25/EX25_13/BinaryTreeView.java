//binary tree view

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BinaryTreeView extends JPanel
{
 private BinaryTree<Integer> tree;//binary tree
 private JTextField jtfKey = new JTextField(5);//輸入欄位 輸入要搜尋數字
 private PaintTree paintTree = new PaintTree();//視覺化binary tree視窗
 private JButton jbtSearch = new JButton("Search");//搜尋按紐

 private boolean isSearch = false;//判斷是否找到
 private boolean isPath = false;//判斷是否路徑
 private java.util.ArrayList path;//路徑list

 private int key;//從輸入欄取得的數字

 int count = 0;//目前顯示node數量

 Timer timer = new Timer(1000,new TimerListener());//計時器 1秒一動作

 //事件
 class TimerListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     //若目前數量小於路徑node數量
     if(count < path.size())
      count++;//+1
     paintTree.repaint();//重繪
     if(count == path.size())
      {
       if(!isSearch)//若沒有找到 在最後顯示
        JOptionPane.showMessageDialog(null,key+" is not in the tree");//顯示錯誤欄    
      }
    }
  }

 //default
 public BinaryTreeView(BinaryTree<Integer> tree)
  {
   this.tree = tree;//放入binary tree
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
   panel.add(jbtSearch);//搜尋按紐
   add(panel,BorderLayout.SOUTH);//放入frame

   //按鈕事件 搜尋輸入數字並顯示路徑   
   jbtSearch.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){

     key = Integer.parseInt(jtfKey.getText());//輸入的數字

     path = null;
     //判斷是否搜尋到數字
     if(tree.search(key))
      {
       isSearch = true;//有找到
       paintTree.repaint();//重繪顯示原始的樹
       path = tree.path(key);//取得路徑
       count = 0;//計數歸零
       timer.start();//開始計時動作
      }
     else
      {
       paintTree.repaint();//binary tree 重繪
       path = tree.path(key);//取得路徑
       isSearch = false;//沒有找到
       count = 0;//計數歸零
       timer.start();//開始計時動作
      }
    }
   });
  }

 //繪圖panel
 class PaintTree extends JPanel
  {
   private int radius = 20;//圓半徑
   private int vGap = 50;//計算連線點位置
   
   //繪圖
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //將樹繪出
     if(tree.getRoot() != null)
      displayTree(g,tree.getRoot(),getWidth() / 2,30,getWidth()/4);
    }

   //繪出樹
   private void displayTree(Graphics g,TreeNode root,int x,int y,int hGap)
    {
     //判斷目前node是否在路徑中
     for(int i=0;path!=null&&i<count;i++)
      {
       TreeNode n = (TreeNode)(path.get(i));//從list中取出node
       if((n.element).compareTo(root.element)==0)//比較是否相等來判斷是否在路徑中
        {
         isPath = true;
         break;
        }
      }

     //若是路徑中一node 繪成綠色
     if(isPath)
      {
       g.setColor(Color.GREEN);//設為綠色
       g.fillOval(x - radius,y - radius,2 * radius,2*radius);//繪圓 實心
       g.setColor(Color.BLACK);//設為黑色
       g.drawString(root.element + "",x-6,y+4);//文字
       isPath = false;//取消判斷
       
       //若顯示node數已到路徑長度
       if(count == path.size())
        {
         timer.stop();//關閉計時器
        }
      }
     else//若否 繪成空心
      {
       g.setColor(Color.black);//設為黑色
       g.drawOval(x - radius,y - radius,2 * radius,2*radius);//繪圓
       g.drawString(root.element + "",x-6,y+4);//文字
      }

     //若有左子樹
     if(root.left != null)
      {
       connectLeftChild(g,x-hGap,y+vGap,x,y);//繪制連接線
       displayTree(g,root.left,x-hGap,y+vGap,hGap/2);//繪樹
      }

     //若有右子樹
     if(root.right != null)
      {
       connectRightChild(g,x+hGap,y+vGap,x,y);//繪制連接線
       displayTree(g,root.right,x+hGap,y+vGap,hGap/2);//繪樹
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