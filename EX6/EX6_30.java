//���r�C��

import javax.swing.JOptionPane;

public class EX6_30
{
 public static void main(String args[])
  {
   int[][] TTT = new int[3][3]; //�s��OX
   for(int i=0;i<3;i++)
    for(int j=0;j<3;j++)
     TTT[i][j] = 0;

   boolean XWin = false; //�M�w��Ĺ
   boolean OWin = false;
   boolean drop = false;

   //�C����J�nrefresh
   boolean xToken = true;
   boolean oToken = false;
   boolean playInput = false;

   int count = 0;//��J����

   while(true)
    {
     playInput = false;

     for(int i=0;i<3;i++) //��ܹC���L
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

     for(int i=0;i<3;i++) //�����C
      {
       if(TTT[i][0]==TTT[i][1] && TTT[i][1]==TTT[i][2])
        {
         if(TTT[i][0]==1)
          XWin = true;
         else if(TTT[i][0]==2)
          OWin = true;
        }
      }

     for(int j=0;j<3;j++) //������
      {
       if(TTT[0][j]==TTT[1][j] && TTT[1][j]==TTT[2][j])
        {
         if(TTT[0][j]==1)
          XWin = true;
         else if(TTT[0][j]==2)
          OWin = true;
        }
      }

      //�����﨤
     if(TTT[0][0]==TTT[1][1] && TTT[1][1]==TTT[2][2])
      {
       if(TTT[0][0]==1)
        XWin = true;
       else if(TTT[0][0]==2)
        OWin = true;
      }

     //�����Ϲ﨤
     if(TTT[0][2] == TTT[1][1] && TTT[1][1]==TTT[2][0])
      {
       if(TTT[0][2]==1)
        XWin = true;
       else if(TTT[0][2]==2)
        OWin = true;
      }
    
     if(XWin == true || OWin == true) //�p�G�����G���X
      break;
     else if(XWin == false && OWin == false && count==9) //����
      {
       drop = true;
       break;
      }
     else
      System.out.println("unfinish");
     
     //���a��JX
     while(count<9)
      {
       String sign;//�{�b�ֿ�J

       if(xToken)//X
        sign = "X";
       else//O��J
        sign = "O"; 
       //�M�w��m �H�T�����J
       String Row = JOptionPane.showInputDialog("Enter "+sign+"'s row (ex.0,1,2)");
       int row = Integer.parseInt(Row);//��J�C
    
       String Cloumn = JOptionPane.showInputDialog("Enter "+sign+"'s cloumn (ex.0,1,2)");
       int column = Integer.parseInt(Cloumn);//��J��

       if(column>2 || row>2 || column<0 || row<0) //�קK�X��l
        JOptionPane.showMessageDialog(null,"Over the board");
       else 
        {   
         if(TTT[row][column]!=0) //�קK����
          JOptionPane.showMessageDialog(null,"This place had be entered");
         else
          {
           if(xToken)//X��J
            {
             TTT[row][column] = 1;
             //���H
             xToken = false;
             oToken = true;
            }
           else//O��J
            {
             TTT[row][column] = 2;
             xToken = true;
             oToken = false;
            }

           count++;//�p��
           break;
          }
        }
      }
    }
 
   //��ܵ��G
   if(XWin)
    System.out.print("X win");
   else if(OWin)
    System.out.print("O win");
   else if(drop)
    System.out.print("Drop");
  }
}
    