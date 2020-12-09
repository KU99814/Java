//Knight tour

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX20_32 extends JFrame
{
 //輸入欄位
 private JTextField jtfRow = new JTextField(2);//輸入開始列
 private JTextField jtfColumn = new JTextField(2);//輸入開始行

 private JButton jbSearch = new JButton("Search");//開始搜尋按鈕

 private ChessBoard chessPanel = new ChessBoard();//盤面panel

 public EX20_32()
  {
   JPanel panel = new JPanel();//宣告操作盤面
   
   //加入component
   panel.add(new JLabel("Specify a starting position,row: "));
   panel.add(jtfRow);
   panel.add(new JLabel("column: "));
   panel.add(jtfColumn);
   panel.add(jbSearch);

   //對齊
   jtfRow.setHorizontalAlignment(SwingConstants.CENTER);
   jtfColumn.setHorizontalAlignment(SwingConstants.CENTER);
   
   //加入component
   add(chessPanel);
   add(panel,BorderLayout.SOUTH);

   //加入按鈕動作
   jbSearch.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     //開始繪製路徑
     chessPanel.setOrder(Integer.parseInt(jtfRow.getText()),Integer.parseInt(jtfColumn.getText()));
    }
   });
  }

 public static void main(String args[])
  {
   EX20_32 frame = new EX20_32();
   
   frame.setTitle("EX20_32");//宣告視窗
   frame.setSize(400,400);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 //棋盤panel
 class ChessBoard extends JPanel
  {
   //開始座標
   private int startX = 0;
   private int startY = 0;

   private int SIZE = 8;//最多騎路
   private int[][] square = new int[SIZE][SIZE];//盤面狀態
   private int[][] step = {{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}};//路徑 固定八種
   private int[][] knight = new int[SIZE*SIZE][2];//騎士走路路徑 列代表總格數 行代表XY座標

   int index = 0;//現在在第幾步
  
   boolean start = false;//是否開始

   ChessBoard()
    {
     this.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));//宣告框線
    }

   //開始搜尋路徑
   public void setOrder(int startX,int startY)
    {
     //設定開始座標
     this.startX = startX;
     this.startY = startY;

     start = false;

     //定義或清空盤面和路徑
     for(int i=0;i<SIZE;i++)
      for(int j=0;j<SIZE;j++)
      {
       square[i][j]=0;
       knight[i*SIZE+j][0] = 0;
       knight[i*SIZE+j][1] = 0;
      }  
     repaint();//重繪
  
     start = true;//開始繪製路徑

     //將第一格設為開始座標
     knight[0][0] = startX;
     knight[0][1] = startY;

     //開始搜尋路徑
     search(startX,startY);
     repaint();//繪圖
    }

   //判斷格子是否有效
   public boolean isValid(int r,int c)
    {
     if(r<0 || r>=SIZE || c<0 || c>=SIZE)//若超出盤面
      return false;
     else//若格子已走過
      {
       if(square[r][c]==1)
        return false;
      }
     return true;
    }

   //判斷是否解決
   public boolean check()
    {
     for(int i=0;i<SIZE;i++)
      for(int j=0;j<SIZE;j++)
       {
        if(square[i][j]==0)
         return true;
       }
     return false;
    }

   //搜尋路徑
   public boolean search(int r,int c)
    {
     int count = 0;//有效路徑數
     int[][] may = new int[SIZE][2];//有效路徑行列

     if(index<SIZE*SIZE-1)//如果index還沒到最大格數 
      { 
       square[r][c] = 1;//現在這格設為走過
       for(int i=0;i<SIZE;i++)
        {
         if(isValid(r+step[i][0],c+step[i][1]))//判斷現在這格有多少可走路徑
          {
           //存取可走格子
           may[count][0] = r+step[i][0];
           may[count][1] = c+step[i][1];
           count++;
          }
        }
       
       //將可走格子按照下一步可走格子數由小到大排序
       //bubble sort
       for(int i=0;i<count;i++)
        {
         for(int j=i+1;j<count;j++)
          {
           if(stepCount(may[i][0],may[i][1])>stepCount(may[j][0],may[j][1]))
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
       
       //驗證
       for(int i=0;i<count;i++)
        {
         index++;//要驗證下一步 先加index
         //遞迴
         //如果直到最後一步都沒問題 回傳true
         if(search(may[i][0],may[i][1]))
          {
           square[r][c] = 1;//設為走過

           //儲存路徑
           knight[index][0] = may[i][0];
           knight[index][1] = may[i][1];

           index--;//減回來上一步
           return true;//回傳
          }
         else//如果到不了最後一步
          {
           square[r][c] = 0;//這一步設為沒走過
           index--;//退一步 避免下一回重複加
          }
        }
      }
     else//達到最大格數
      {
       square[r][c] = 1;//現在格數設為走過
       return true;//!check();
      }
     square[r][c] = 0;//完全沒路可走

     return false;
    }

   //計算步數
   public int stepCount(int r,int c)
    {
     int count = 0;//計數

     //驗證下一步8格是否可走
     for(int i=0;i<SIZE;i++)
      {
       if(isValid(r+step[i][0],c+step[i][1]))
        {
         count++;//可走計數加1
        }
      }
     
     return count;//回傳
    }

   //重繪
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //繪製欄線 劃分格子
     for(int i=0;i<SIZE;i++)
      {
       g.drawLine(0,i*getHeight()/SIZE,
                  getWidth(),i*getHeight()/SIZE);
       g.drawLine(i*getWidth()/SIZE,0,
                  i*getWidth()/SIZE,getHeight());
      }

     if(start)//如果開始走
      {
       //以陣列儲存格子順序繪製路線
       for(int i=0;i<SIZE*SIZE-1;i++)
        {
         g.drawLine(knight[i][1]*getWidth()/SIZE+(getWidth()/SIZE)/2,
                    knight[i][0]*getHeight()/SIZE+(getHeight()/SIZE)/2,
                    knight[i+1][1]*getWidth()/SIZE+(getWidth()/SIZE)/2,
                    knight[i+1][0]*getHeight()/SIZE+(getHeight()/SIZE)/2);
         
        }
      }
     
    }
  }
}