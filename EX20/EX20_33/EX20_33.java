//Knight tour

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX20_33 extends JFrame
{
 private JButton jbSolve = new JButton("Solve");//�}�l���s
 private ChessBoard chessPanel = new ChessBoard(); //�ѽLpanel

 public EX20_33()
  {
   JPanel panel = new JPanel();//���spanel
   panel.add(jbSolve);//�[�J���s
   jbSolve.setHorizontalAlignment(SwingConstants.CENTER);//���
      
   //��X
   add(chessPanel);
   add(panel,BorderLayout.SOUTH);

   //�[�J���s�ʧ@
   jbSolve.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     chessPanel.setOrder();//ø�s���|
    }
   });
  }

 public static void main(String args[])
  {
   EX20_33 frame = new EX20_33();
   
   frame.setTitle("EX20_33");//���D
   frame.setSize(500,500);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 //�ѽLø�spanel
 static class ChessBoard extends JPanel
  {
   //�}�l�y��
   private int startX = 0;
   private int startY = 0;

   //���I�y��
   private int endX = 0;
   private int endY = 0;

   private int SIZE = 8;//�B��
   private int[][] square = new int[SIZE][SIZE];//�ѽL���A
   private int[][] step = {{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}};//�U�@�B���|
   private int[][] knight = new int[SIZE*SIZE][2];//�x�s���|
   
   Image knightImage = new ImageIcon("knight.jpg").getImage();//�M�h�Ϥ�

   //�Ϥ��O�_���
   public boolean startImage = false;//�_�I
   public boolean endImage = false;//���I

   int index = 0;//�{�b�ĴX�B
  
   boolean start = false;//�O�_�}�lø�s���|

   ChessBoard()
    {
     //�ŧi�ؽu
     this.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

     //�[�J�ƹ��ʧ@ �I����ܹϤ�
     addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
       //���o�ƹ��y��
       int x = e.getY()/(getHeight()/SIZE);
       int y = e.getX()/(getWidth()/SIZE);

       if(startImage)//�P�_�_�I�O�_��� ����ܩΨ����_�I
        {
         if(endImage)//�P�_���I�O�_��� ����ܩΨ������I
          {
           if(x==endX&&y==endY)
            endImage = false;
          }
         else
          {
           if(x!=startX||y!=startY)//�P�_�_�I�P���I�O�_�ۦP
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

   //�}�lø�s���|
   public void setOrder()
    {
     start = false;//�����}�l���A

     //�N�Ҧ����A�M��
     for(int i=0;i<SIZE;i++)
      for(int j=0;j<SIZE;j++)
      {
       square[i][j]=0;
       knight[i*SIZE+j][0] = 0;
       knight[i*SIZE+j][1] = 0;
      }  
     repaint();//ø�s�L��
  
     //�}�l�j�M���|
     start = true;

     //�N�_�I�]���Ĥ@��
     knight[0][0] = startX;
     knight[0][1] = startY;

     if(startImage&&endImage)//�p�G�_�I�P���I��OK
      {
       search(startX,startY);//�j�M���|
      }
     repaint();
    }

   //�P�_�O�_����
   public boolean isValid(int r,int c)
    {
     if(r<0 || r>=SIZE || c<0 || c>=SIZE)//�P�_�O�_�W�X�d��
      return false;
     else
      {
       if(square[r][c]==1)//�P�_�O�_���L
        return false;
      }
     return true;
    }

   //�j�M���|
   public boolean search(int r,int c)
    {
     int count = 0;//�i���B�ƭp��
     int[][] may = new int[SIZE][2];//�i�����|

     //�P�_�O�_������I
     if(r!=endX||c!=endY)
      { 
       square[r][c] = 1;
       for(int i=0;i<SIZE;i++)
        {
         if(isValid(r+step[i][0],c+step[i][1]))//�P�_�U�@�B�O�_�i��
          {
           may[count][0] = r+step[i][0];
           may[count][1] = c+step[i][1];
           count++;
          }
        }
        
       //�Ƨ� �ѨB�Ƥ֨�B�Ʀh
       for(int i=0;i<count;i++)
        {
         for(int j=i+1;j<count;j++)
          {
           if(stepCount(may[i][0],may[i][1])>stepCount(may[j][0],may[j][1]))//����U�@�B�i��B��
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
       
       //�P�_���|�O�_�i��
       for(int i=0;i<count;i++)
        {
         index++;//�n�P�_�U�@�B
         if(search(may[i][0],may[i][1]))//���j ��������I�εL���i��
          {
           square[r][c] = 1;//�]�����L

           //�������|
           knight[index][0] = may[i][0];
           knight[index][1] = may[i][1];
           index--;//��^�W�@�B
           return true;
          }
         else//�Y�L �^�W�@�B
          {
           square[r][c] = 0;
           index--;
          }
        }
      }
     else//�Y������I
      {
       square[r][c] = 1;
       return true;//check
      }
     square[r][c] = 0;

     return false;
    }

   //�p��i��B��
   public int stepCount(int r,int c)
    {
     int count = 0;//�^�ǭ�

     //�P�_�U�B�O�_�i��
     for(int i=0;i<SIZE;i++)
      {
       if(isValid(r+step[i][0],c+step[i][1]))
        {
         count++;
        }
      }
     
     return count;//�^��
    }

   //ø��
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);

     //ø�s�L��
     for(int i=0;i<SIZE;i++)
      {
       g.drawLine(0,i*getHeight()/SIZE,
                  getWidth(),i*getHeight()/SIZE);
       g.drawLine(i*getWidth()/SIZE,0,
                  i*getWidth()/SIZE,getHeight());
      }

     //ø�s�_�I�P���I�Ϯ�
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
     

     if(startImage && endImage && start)//�Y�_�I�P���I�Ҧ�
      {
       int i=0;
       while(i<SIZE*SIZE-1)//ø�s���|
        {
         g.drawLine(knight[i][1]*getWidth()/SIZE+(getWidth()/SIZE)/2,
                    knight[i][0]*getHeight()/SIZE+(getHeight()/SIZE)/2,
                    knight[i+1][1]*getWidth()/SIZE+(getWidth()/SIZE)/2,
                    knight[i+1][0]*getHeight()/SIZE+(getHeight()/SIZE)/2);
         if(knight[i+1][0] == endX && knight[i+1][1] == endY)
          break;
         i++;
        }
       start = false;//�����j�M�ʧ@
      }
     
    }
  }
}