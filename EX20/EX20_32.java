//Knight tour

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX20_32 extends JFrame
{
 //��J���
 private JTextField jtfRow = new JTextField(2);//��J�}�l�C
 private JTextField jtfColumn = new JTextField(2);//��J�}�l��

 private JButton jbSearch = new JButton("Search");//�}�l�j�M���s

 private ChessBoard chessPanel = new ChessBoard();//�L��panel

 public EX20_32()
  {
   JPanel panel = new JPanel();//�ŧi�ާ@�L��
   
   //�[�Jcomponent
   panel.add(new JLabel("Specify a starting position,row: "));
   panel.add(jtfRow);
   panel.add(new JLabel("column: "));
   panel.add(jtfColumn);
   panel.add(jbSearch);

   //���
   jtfRow.setHorizontalAlignment(SwingConstants.CENTER);
   jtfColumn.setHorizontalAlignment(SwingConstants.CENTER);
   
   //�[�Jcomponent
   add(chessPanel);
   add(panel,BorderLayout.SOUTH);

   //�[�J���s�ʧ@
   jbSearch.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     //�}�lø�s���|
     chessPanel.setOrder(Integer.parseInt(jtfRow.getText()),Integer.parseInt(jtfColumn.getText()));
    }
   });
  }

 public static void main(String args[])
  {
   EX20_32 frame = new EX20_32();
   
   frame.setTitle("EX20_32");//�ŧi����
   frame.setSize(400,400);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 //�ѽLpanel
 class ChessBoard extends JPanel
  {
   //�}�l�y��
   private int startX = 0;
   private int startY = 0;

   private int SIZE = 8;//�̦h�M��
   private int[][] square = new int[SIZE][SIZE];//�L�����A
   private int[][] step = {{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}};//���| �T�w�K��
   private int[][] knight = new int[SIZE*SIZE][2];//�M�h�������| �C�N���`��� ��N��XY�y��

   int index = 0;//�{�b�b�ĴX�B
  
   boolean start = false;//�O�_�}�l

   ChessBoard()
    {
     this.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));//�ŧi�ؽu
    }

   //�}�l�j�M���|
   public void setOrder(int startX,int startY)
    {
     //�]�w�}�l�y��
     this.startX = startX;
     this.startY = startY;

     start = false;

     //�w�q�βM�ŽL���M���|
     for(int i=0;i<SIZE;i++)
      for(int j=0;j<SIZE;j++)
      {
       square[i][j]=0;
       knight[i*SIZE+j][0] = 0;
       knight[i*SIZE+j][1] = 0;
      }  
     repaint();//��ø
  
     start = true;//�}�lø�s���|

     //�N�Ĥ@��]���}�l�y��
     knight[0][0] = startX;
     knight[0][1] = startY;

     //�}�l�j�M���|
     search(startX,startY);
     repaint();//ø��
    }

   //�P�_��l�O�_����
   public boolean isValid(int r,int c)
    {
     if(r<0 || r>=SIZE || c<0 || c>=SIZE)//�Y�W�X�L��
      return false;
     else//�Y��l�w���L
      {
       if(square[r][c]==1)
        return false;
      }
     return true;
    }

   //�P�_�O�_�ѨM
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

   //�j�M���|
   public boolean search(int r,int c)
    {
     int count = 0;//���ĸ��|��
     int[][] may = new int[SIZE][2];//���ĸ��|��C

     if(index<SIZE*SIZE-1)//�p�Gindex�٨S��̤j��� 
      { 
       square[r][c] = 1;//�{�b�o��]�����L
       for(int i=0;i<SIZE;i++)
        {
         if(isValid(r+step[i][0],c+step[i][1]))//�P�_�{�b�o�榳�h�֥i�����|
          {
           //�s���i����l
           may[count][0] = r+step[i][0];
           may[count][1] = c+step[i][1];
           count++;
          }
        }
       
       //�N�i����l���ӤU�@�B�i����l�ƥѤp��j�Ƨ�
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
       
       //����
       for(int i=0;i<count;i++)
        {
         index++;//�n���ҤU�@�B ���[index
         //���j
         //�p�G����̫�@�B���S���D �^��true
         if(search(may[i][0],may[i][1]))
          {
           square[r][c] = 1;//�]�����L

           //�x�s���|
           knight[index][0] = may[i][0];
           knight[index][1] = may[i][1];

           index--;//��^�ӤW�@�B
           return true;//�^��
          }
         else//�p�G�줣�F�̫�@�B
          {
           square[r][c] = 0;//�o�@�B�]���S���L
           index--;//�h�@�B �קK�U�@�^���ƥ[
          }
        }
      }
     else//�F��̤j���
      {
       square[r][c] = 1;//�{�b��Ƴ]�����L
       return true;//!check();
      }
     square[r][c] = 0;//�����S���i��

     return false;
    }

   //�p��B��
   public int stepCount(int r,int c)
    {
     int count = 0;//�p��

     //���ҤU�@�B8��O�_�i��
     for(int i=0;i<SIZE;i++)
      {
       if(isValid(r+step[i][0],c+step[i][1]))
        {
         count++;//�i���p�ƥ[1
        }
      }
     
     return count;//�^��
    }

   //��ø
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //ø�s��u ������l
     for(int i=0;i<SIZE;i++)
      {
       g.drawLine(0,i*getHeight()/SIZE,
                  getWidth(),i*getHeight()/SIZE);
       g.drawLine(i*getWidth()/SIZE,0,
                  i*getWidth()/SIZE,getHeight());
      }

     if(start)//�p�G�}�l��
      {
       //�H�}�C�x�s��l����ø�s���u
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