//井字遊戲

import javax.swing.JOptionPane;

public class EX6_30
{
 public static void main(String args[])
  {
   int[][] TTT = new int[3][3]; //存放OX
   for(int i=0;i<3;i++)
    for(int j=0;j<3;j++)
     TTT[i][j] = 0;

   boolean XWin = false; //決定輸贏
   boolean OWin = false;
   boolean drop = false;

   //每次輸入要refresh
   boolean xToken = true;
   boolean oToken = false;
   boolean playInput = false;

   int count = 0;//輸入次數

   while(true)
    {
     playInput = false;

     for(int i=0;i<3;i++) //顯示遊戲盤
      {
       for(int j=0;j<3;j++)
        {
         if(TTT[i][j] == 1)
          System.out.print("X");
         else if(TTT[i][j] == 2)
          System.out.print("O");
         else
          System.out.print(" ");
         if(j<2)
          System.out.print("|");
        }
       System.out.println();
       System.out.println("------");
      }
     System.out.println();

     for(int i=0;i<3;i++) //偵測列
      {
       if(TTT[i][0]==TTT[i][1] && TTT[i][1]==TTT[i][2])
        {
         if(TTT[i][0]==1)
          XWin = true;
         else if(TTT[i][0]==2)
          OWin = true;
        }
      }

     for(int j=0;j<3;j++) //偵測行
      {
       if(TTT[0][j]==TTT[1][j] && TTT[1][j]==TTT[2][j])
        {
         if(TTT[0][j]==1)
          XWin = true;
         else if(TTT[0][j]==2)
          OWin = true;
        }
      }

      //偵測對角
     if(TTT[0][0]==TTT[1][1] && TTT[1][1]==TTT[2][2])
      {
       if(TTT[0][0]==1)
        XWin = true;
       else if(TTT[0][0]==2)
        OWin = true;
      }

     //偵測反對角
     if(TTT[0][2] == TTT[1][1] && TTT[1][1]==TTT[2][0])
      {
       if(TTT[0][2]==1)
        XWin = true;
       else if(TTT[0][2]==2)
        OWin = true;
      }
    
     if(XWin == true || OWin == true) //如果有結果跳出
      break;
     else if(XWin == false && OWin == false && count==9) //平手
      {
       drop = true;
       break;
      }
     else
      System.out.println("unfinish");
     
     //玩家輸入X
     while(count<9)
      {
       String sign;//現在誰輸入

       if(xToken)//X
        sign = "X";
       else//O輸入
        sign = "O"; 
       //決定位置 以訊息欄輸入
       String Row = JOptionPane.showInputDialog("Enter "+sign+"'s row (ex.0,1,2)");
       int row = Integer.parseInt(Row);//輸入列
    
       String Cloumn = JOptionPane.showInputDialog("Enter "+sign+"'s cloumn (ex.0,1,2)");
       int column = Integer.parseInt(Cloumn);//輸入行

       if(column>2 || row>2 || column<0 || row<0) //避免出格子
        JOptionPane.showMessageDialog(null,"Over the board");
       else 
        {   
         if(TTT[row][column]!=0) //避免重複
          JOptionPane.showMessageDialog(null,"This place had be entered");
         else
          {
           if(xToken)//X輸入
            {
             TTT[row][column] = 1;
             //換人
             xToken = false;
             oToken = true;
            }
           else//O輸入
            {
             TTT[row][column] = 2;
             xToken = true;
             oToken = false;
            }

           count++;//計數
           break;
          }
        }
      }
    }
 
   //顯示結果
   if(XWin)
    System.out.print("X win");
   else if(OWin)
    System.out.print("O win");
   else if(drop)
    System.out.print("Drop");
  }
}
    