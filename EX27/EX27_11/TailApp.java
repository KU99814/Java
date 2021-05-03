//視窗化 nine tail

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.io.*;

public class TailApp extends JFrame
{
 private InitialNodePanel initialNodePanel = new InitialNodePanel();//顯示初始狀態panel 
 private JButton jbtSolve = new JButton("Solve");//顯示解題順序按鈕
 private JButton jbtStartOver = new JButton("Start Over");//重置按鈕

 private TailModel16 model;//tail Model 物件
 //解題panel 放置initialNodePanel
 private JPanel solutionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));

 private static int num = TailModel16.DEMINION;//目前的格數

 public TailApp() throws IOException,ClassNotFoundException
  {
   ObjectInputStream input = new ObjectInputStream(new FileInputStream("EX27_10.dat"));//讀取檔案
   model = (TailModel16)(input.readObject());//輸入object

   solutionPanel.add(initialNodePanel);//將顯示解答panel放入解題panel
   add(new JScrollPane(solutionPanel), BorderLayout.CENTER);//
   
   JPanel buttonPanel = new JPanel();//按鈕panel
   buttonPanel.add(jbtSolve);//加入解題按鈕
   buttonPanel.add(jbtStartOver);//加入重置按鈕
   add(buttonPanel,BorderLayout.SOUTH);//加入主panel
   
   //解題按鈕事件
   jbtSolve.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     solutionPanel.removeAll();//清除畫面
    
     //取得解答路徑 
     java.util.List<TailModel16.Node> list = 
        model.getShortestPath(new TailModel16.Node(initialNodePanel.getMatrix()));
    
     System.out.println(list.size());
     //創建並加入node panel 將每一個解答繪出
     for(TailModel16.Node node: list)
      solutionPanel.add(new NodePanel(node.getMatrix()));
     
     solutionPanel.revalidate();
    }
   });

   //重置按鈕事件
   jbtStartOver.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     solutionPanel.removeAll();//清除畫面
     solutionPanel.add(initialNodePanel);//加入初始panel
     solutionPanel.repaint();//重繪
    }
   });
  }

 //顯示陣列panel
 static class NodePanel extends JPanel
  {
   public NodePanel(int[][] matrix)
    {
     this.setLayout(new GridLayout(num,num));//設定排版gridlayout

     //依序創建並加入cell panel
     for(int i=0;i<num;i++)
      for(int j=0;j<num;j++)
       {
        if(matrix[i][j] ==0)
         add(new Cell("H"));
        else
         add(new Cell("T"));
       }
    }
  }

 //顯示每一格的字
 static class Cell extends JLabel
  {
   public Cell(String s)
    {
     this.setBorder(new LineBorder(Color.black,1));//設定邊線
     this.setHorizontalAlignment(JLabel.CENTER);//設定水平對齊
     this.setFont(new Font("TimesRoman",Font.BOLD,20));//設定字體
     setText(s);//設定文字
    }
  }

 //初始panel 能夠改變nine tail配置
 static class InitialNodePanel extends JPanel
  {
   ClickableCell[][] clickableCells = new ClickableCell[num][num];//cell陣列 能用滑鼠改變
   
   //default
   public InitialNodePanel()
    {
     this.setLayout(new GridLayout(num,num));//設定排版
     
     //放入cell 
     for(int i=0;i<num;i++)
      for(int j=0;j<num;j++)
       add(clickableCells[i][j] = new ClickableCell("H"));
    }
   
   //將cell內容轉為陣列
   public int[][] getMatrix()
    {
     int[][] matrix = new int[num][num];//回傳陣列
     
     //迴圈
     for(int i =0;i<num;i++)
      for(int j =0;j<num;j++)
       {
        //根據cell的字判斷陣列內容為0或1
        if(clickableCells[i][j].getText().equals("H"))
         matrix[i][j] = 0;
        else
         matrix[i][j] = 1;
       }
     
     return matrix;//回傳
    }
  }

 //加入滑鼠事件的cell class
 static class ClickableCell extends Cell
  {
   public ClickableCell(String s)
    {
     super(s);

     //加入滑鼠事件
     addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
       //將cell內文字改變
       if(getText().equals("H"))
        setText("T");
       else
        setText("H");
      }
     });
    }
  }
}