//Knight tour

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX20_33 extends JFrame
{
 private JButton jbSolve = new JButton("Solve");//開始按鈕
 private ChessBoard chessPanel = new ChessBoard(); //棋盤panel

 public EX20_33()
  {
   JPanel panel = new JPanel();//按鈕panel
   panel.add(jbSolve);//加入按鈕
   jbSolve.setHorizontalAlignment(SwingConstants.CENTER);//對齊
      
   //整合
   add(chessPanel);
   add(panel,BorderLayout.SOUTH);

   //加入按鈕動作
   jbSolve.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     chessPanel.setOrder();//繪製路徑
    }
   });
  }

 public static void main(String args[])
  {
   EX20_33 frame = new EX20_33();
   
   frame.setTitle("EX20_33");//標題
   frame.setSize(500,500);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 //棋盤繪製panel
 static class ChessBoard extends JPanel
  {
   //開始座標
   private int startX = 0;
   private int startY = 0;

   //終點座標
   private int endX = 0;
   private int endY = 0;

   private int SIZE = 8;//步數
   private int[][] square = new int[SIZE][SIZE];//棋盤狀態
   private int[][] step = {{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}};//下一步路徑
   private int[][] knight = new int[SIZE*SIZE][2];//儲存路徑
   
   Image knightImage = new ImageIcon("knight.jpg").getImage();//騎士圖片

   //圖片是否顯示
   public boolean startImage = false;//起點
   public boolean endImage = false;//終點

   int index = 0;//現在第幾步
  
   boolean start = false;//是否開始繪製路徑

   ChessBoard()
    {
     //宣告框線
     this.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

     //加入滑鼠動作 點擊顯示圖片
     addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
       //取得滑鼠座標
       int x = e.getY()/(getHeight()/SIZE);
       int y = e.getX()/(getWidth()/SIZE);

       if(startImage)//判斷起點是否顯示 來顯示或取消起點
        {
         if(endImage)//判斷終點是否顯示 來顯示或取消終點
          {
           if(x==endX&&y==endY)
            endImage = false;
          }
         else
          {
           if(x!=startX||y!=startY)//判斷起點與終點是否相同
            {
             endX = x;
             endY = y; 
             endImage = true;
            }
           else if(x==startX&&y==startY)
            startImage = false;
          }
        }
       else
        {
         startX = x;
         startY = y; 
         startImage = true;
        }
       System.out.println(startX+" "+startY+" "+startImage+" "+endX+" "+endY+" "+endImage);
       repaint();
      }
     });
    }

   //開始繪製路徑
   public void setOrder()
    {
     start = false;//關閉開始狀態

     //將所有狀態清空
     for(int i=0;i<SIZE;i++)
      for(int j=0;j<SIZE;j++)
      {
       square[i][j]=0;
       knight[i*SIZE+j][0] = 0;
       knight[i*SIZE+j][1] = 0;
      }  
     repaint();//繪製盤面
  
     //開始搜尋路徑
     start = true;

     //將起點設為第一格
     knight[0][0] = startX;
     knight[0][1] = startY;

     if(startImage&&endImage)//如果起點與終點都OK
      {
       search(startX,startY);//搜尋路徑
      }
     repaint();
    }

   //判斷是否有效
   public boolean isValid(int r,int c)
    {
     if(r<0 || r>=SIZE || c<0 || c>=SIZE)//判斷是否超出範圍
      return false;
     else
      {
       if(square[r][c]==1)//判斷是否走過
        return false;
      }
     return true;
    }

   //搜尋路徑
   public boolean search(int r,int c)
    {
     int count = 0;//可走步數計數
     int[][] may = new int[SIZE][2];//可走路徑

     //判斷是否走到終點
     if(r!=endX||c!=endY)
      { 
       square[r][c] = 1;
       for(int i=0;i<SIZE;i++)
        {
         if(isValid(r+step[i][0],c+step[i][1]))//判斷下一步是否可走
          {
           may[count][0] = r+step[i][0];
           may[count][1] = c+step[i][1];
           count++;
          }
        }
        
       //排序 由步數少到步數多
       for(int i=0;i<count;i++)
        {
         for(int j=i+1;j<count;j++)
          {
           if(stepCount(may[i][0],may[i][1])>stepCount(may[j][0],may[j][1]))//比較下一步可行步數
            {
             int temp1 = may[i][0];
             int temp2 = may[i][1];
             may[i][0] = may[j][0];
             may[i][1] = may[j][1];
             may[j][0] = temp1;
             may[j][1] = temp2;
            }
          }
        }
       
       //判斷路徑是否可行
       for(int i=0;i<count;i++)
        {
         index++;//要判斷下一步
         if(search(may[i][0],may[i][1]))//遞迴 直到找到終點或無路可走
          {
           square[r][c] = 1;//設為走過

           //紀錄路徑
           knight[index][0] = may[i][0];
           knight[index][1] = may[i][1];
           index--;//減回上一步
           return true;
          }
         else//若無 回上一步
          {
           square[r][c] = 0;
           index--;
          }
        }
      }
     else//若走到終點
      {
       square[r][c] = 1;
       return true;//check
      }
     square[r][c] = 0;

     return false;
    }

   //計算可行步數
   public int stepCount(int r,int c)
    {
     int count = 0;//回傳值

     //判斷各步是否可行
     for(int i=0;i<SIZE;i++)
      {
       if(isValid(r+step[i][0],c+step[i][1]))
        {
         count++;
        }
      }
     
     return count;//回傳
    }

   //繪圖
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);

     //繪製盤面
     for(int i=0;i<SIZE;i++)
      {
       g.drawLine(0,i*getHeight()/SIZE,
                  getWidth(),i*getHeight()/SIZE);
       g.drawLine(i*getWidth()/SIZE,0,
                  i*getWidth()/SIZE,getHeight());
      }

     //繪製起點與終點圖案
     if(startImage)
      {
       g.drawImage(knightImage,startY*getWidth()/SIZE,startX*(getHeight()/SIZE),
                   getWidth()/SIZE,getHeight()/SIZE,this);
      }

     if(endImage)
      {
       g.drawImage(knightImage,endY*getWidth()/SIZE,endX*(getHeight()/SIZE),
                   getWidth()/SIZE,getHeight()/SIZE,this);
      }
     

     if(startImage && endImage && start)//若起點與終點皆有
      {
       int i=0;
       while(i<SIZE*SIZE-1)//繪製路徑
        {
         g.drawLine(knight[i][1]*getWidth()/SIZE+(getWidth()/SIZE)/2,
                    knight[i][0]*getHeight()/SIZE+(getHeight()/SIZE)/2,
                    knight[i+1][1]*getWidth()/SIZE+(getWidth()/SIZE)/2,
                    knight[i+1][0]*getHeight()/SIZE+(getHeight()/SIZE)/2);
         if(knight[i+1][0] == endX && knight[i+1][1] == endY)
          break;
         i++;
        }
       start = false;//關閉搜尋動作
      }
     
    }
  }
}