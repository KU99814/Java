//eight Queen solution

import java.awt.*;
import javax.swing.*;

public class EX20_37 extends JFrame
{
 public static final int SIZE = 8;//�ӦZ��

 private int[] queens = new int[SIZE];//�ӦZ��m�}�C �]���C�C�@�w������ �u�s�� 
 private JPanel p = new JPanel();//��ܴѽL
 int count = 0;//�ѵ���

 public EX20_37()
  {
   this.setLayout(new BorderLayout());//�]�wlayout
   getContentPane().add(new JScrollPane(p), BorderLayout.CENTER);//�]�w�Ա�
   search(0);//�j�M�ѵ��å[�Jpanel
  }

 public static void main(String args[])
  {
   EX20_37 frame = new EX20_37();
   
   frame.setTitle("EX20_37");
   frame.setSize(400,400);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 //�P�_�ӦZ��m�O�_OK
 private boolean isValid(int row,int column)
  {
   for(int i=1;i<=row;i++)//�ƧǮɱq�W��U �]�����Ҽ{�H�᪺�C
    if(queens[row - i] == column || queens[row-i] == column -i 
       || queens[row-i] == column + i)
     return false;
   
   return true;
  }

 //�j�M�ѵ�
 private boolean search(int row)
  {
   if(row < SIZE)//�S��8�Ӯ�
    {
     for(int column =0;column<SIZE;column++)
      {
       queens[row] = column;//����@�Ӧ�m
       if(isValid(row,column))//�P�_�O�_����
        if(search(row+1))//���j �j�M�U�@�C
         return true;
      }
    }
     
   else//�W�L8�� �N��ѵ� ���
    {
     count++;
     p.add(new ChessBoardWithLabel("Solution " + count, queens));//�[�J�ѽL
     //return false;
    }
   
   return false;//�^��false �����j���|���ѵ��N����
  }

 //���panel
 class ChessBoardWithLabel extends JPanel
  {
   private JLabel jlblCount = new JLabel("", JLabel.CENTER);//��ܸѵ���
   
   ChessBoardWithLabel(String c, int[] queen)
    {
     this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));//�]�ؽu
      setLayout(new BorderLayout());

      jlblCount.setText(c);//�[�J���D

      //��X
      add(jlblCount, BorderLayout.NORTH);
      add(new ChessBoard(queen), BorderLayout.CENTER);
    
    }
  }
 
 //�ѽL
 class ChessBoard extends JPanel
  {
   private Image queenImage = new ImageIcon("queen.jpg").getImage();//�ӦZ�Ϥ�
   private int[] queenSolution = new int[SIZE];//�ӦZ��

   //�غc�l ���o��
   ChessBoard(int[] queen)
    {
     for(int i=0;i<SIZE;i++)
      queenSolution[i] = queen[i];
     this.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
    }

   //ø��
   protected void paintComponent(Graphics g)
    {
     g.clearRect(0, 0, getWidth(), getHeight());
     
      //�̷Ӱ}�C��m�ӦZ�Ϥ�
     for(int i=0;i<SIZE;i++)
      {
       int j=queenSolution[i];
       g.drawImage(queenImage,j*getWidth()/SIZE,i*getHeight()/SIZE,
                   getWidth()/SIZE,getHeight()/SIZE,this);
      }
     
     //�e���j�u���X��l
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