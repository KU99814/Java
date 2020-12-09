//eight Queen solution

import java.awt.*;
import javax.swing.*;

public class EX20_37 extends JFrame
{
 public static final int SIZE = 8;//皇后數

 private int[] queens = new int[SIZE];//皇后位置陣列 因為每列一定不重複 只存行 
 private JPanel p = new JPanel();//顯示棋盤
 int count = 0;//解答數

 public EX20_37()
  {
   this.setLayout(new BorderLayout());//設定layout
   getContentPane().add(new JScrollPane(p), BorderLayout.CENTER);//設定拉條
   search(0);//搜尋解答並加入panel
  }

 public static void main(String args[])
  {
   EX20_37 frame = new EX20_37();
   
   frame.setTitle("EX20_37");
   frame.setSize(400,400);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 //判斷皇后位置是否OK
 private boolean isValid(int row,int column)
  {
   for(int i=1;i<=row;i++)//排序時從上到下 因此不考慮以後的列
    if(queens[row - i] == column || queens[row-i] == column -i 
       || queens[row-i] == column + i)
     return false;
   
   return true;
  }

 //搜尋解答
 private boolean search(int row)
  {
   if(row < SIZE)//沒放滿8個時
    {
     for(int column =0;column<SIZE;column++)
      {
       queens[row] = column;//先放一個位置
       if(isValid(row,column))//判斷是否有效
        if(search(row+1))//遞迴 搜尋下一列
         return true;
      }
    }
     
   else//超過8個 代表解答 顯示
    {
     count++;
     p.add(new ChessBoardWithLabel("Solution " + count, queens));//加入棋盤
     //return false;
    }
   
   return false;//回傳false 讓遞迴不會找到解答就結束
  }

 //顯示panel
 class ChessBoardWithLabel extends JPanel
  {
   private JLabel jlblCount = new JLabel("", JLabel.CENTER);//顯示解答數
   
   ChessBoardWithLabel(String c, int[] queen)
    {
     this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));//設框線
      setLayout(new BorderLayout());

      jlblCount.setText(c);//加入標題

      //整合
      add(jlblCount, BorderLayout.NORTH);
      add(new ChessBoard(queen), BorderLayout.CENTER);
    
    }
  }
 
 //棋盤
 class ChessBoard extends JPanel
  {
   private Image queenImage = new ImageIcon("queen.jpg").getImage();//皇后圖片
   private int[] queenSolution = new int[SIZE];//皇后解

   //建構子 取得解
   ChessBoard(int[] queen)
    {
     for(int i=0;i<SIZE;i++)
      queenSolution[i] = queen[i];
     this.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
    }

   //繪圖
   protected void paintComponent(Graphics g)
    {
     g.clearRect(0, 0, getWidth(), getHeight());
     
      //依照陣列放置皇后圖片
     for(int i=0;i<SIZE;i++)
      {
       int j=queenSolution[i];
       g.drawImage(queenImage,j*getWidth()/SIZE,i*getHeight()/SIZE,
                   getWidth()/SIZE,getHeight()/SIZE,this);
      }
     
     //畫分隔線分出格子
     for(int i=0;i<SIZE;i++)
      {
       g.drawLine(0,i*getHeight()/SIZE,
                  getWidth(),i*getHeight()/SIZE);
       g.drawLine(i*getWidth()/SIZE,0,
                  i*getWidth()/SIZE,getHeight());
      }
    }
     public Dimension getPreferredSize() {
        return new Dimension(200, 200);
      }
  }
}