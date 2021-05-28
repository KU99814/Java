//������ 16 tail

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.io.*;

public class WeightedTailApp16 extends JFrame
{
 private InitialNodePanel initialNodePanel = new InitialNodePanel();//��ܪ�l���Apanel 
 private JButton jbtSolve = new JButton("Solve");//��ܸ��D���ǫ��s
 private JButton jbtStartOver = new JButton("Start Over");//���m���s

 //���Dpanel ��minitialNodePanel
 private JPanel solutionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));
 private WeightedTailModel16 model;//16 tail����
 private static int n = WeightedTailModel16.DEMINION;

 //default
 public WeightedTailApp16() throws IOException,ClassNotFoundException
  {
   ObjectInputStream input = new ObjectInputStream(new FileInputStream("EX28_6.dat"));//Ū���ɮ�
   model = (WeightedTailModel16)(input.readObject());//��Jobject

   solutionPanel.add(initialNodePanel);//�N��ܸѵ�panel��J���Dpanel
   add(new JScrollPane(solutionPanel), BorderLayout.CENTER);//
   
   JPanel buttonPanel = new JPanel();//���spanel
   buttonPanel.add(jbtSolve);//�[�J���D���s
   buttonPanel.add(jbtStartOver);//�[�J���m���s
   add(buttonPanel,BorderLayout.SOUTH);//�[�J�Dpanel
   
   //���D���s�ƥ�
   jbtSolve.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     solutionPanel.removeAll();//�M���e��

     //���o�ѵ����|    
     java.util.List<WeightedTailModel16.Node> list = 
        model.getShortestPath(new WeightedTailModel16.Node(initialNodePanel.getMatrix()));
    
     //�Ыبå[�Jnode panel �N�C�@�Ӹѵ�ø�X
     for(WeightedTailModel16.Node node: list)
      solutionPanel.add(new NodePanel(node.getMatrix()));
     
     solutionPanel.revalidate();
    }
   });

   //���m���s�ƥ�
   jbtStartOver.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     solutionPanel.removeAll();//�M���e��
     solutionPanel.add(initialNodePanel);//�[�J��lpanel
     solutionPanel.repaint();//��ø
    }
   });
  }

 //��ܰ}�Cpanel
 static class NodePanel extends JPanel
  {
   //default
   public NodePanel(int[][] matrix)
    {
     this.setLayout(new GridLayout(n,n));//�]�w�ƪ�gridlayout

     //�̧ǳЫبå[�Jcell panel
     for(int i=0;i<n;i++)
      for(int j=0;j<n;j++)
       {
        if(matrix[i][j] ==0)
         add(new Cell("H"));
        else
         add(new Cell("T"));
       }
    }
  }

 //��ܨC�@�檺�r
 static class Cell extends JLabel
  {
   public Cell(String s)
    {
     this.setBorder(new LineBorder(Color.black,1));//�]�w��u
     this.setHorizontalAlignment(JLabel.CENTER);//�]�w�������
     this.setFont(new Font("TimesRoman",Font.BOLD,20));//�]�w�r��
     setText(s);//�]�w��r
    }
  }

 //��lpanel �������nine tail�t�m
 static class InitialNodePanel extends JPanel
  {
   ClickableCell[][] clickableCells = new ClickableCell[n][n];//cell�}�C ��ηƹ�����

   //default   
   public InitialNodePanel()
    {
     this.setLayout(new GridLayout(n,n));//�]�w�ƪ�

     //��Jcell     
     for(int i=0;i<n;i++)
      for(int j=0;j<n;j++)
       add(clickableCells[i][j] = new ClickableCell("H"));
    }
   
   //�Ncell���e�ର�}�C
   public int[][] getMatrix()
    {
     int[][] matrix = new int[n][n];//�^�ǰ}�C

     //�j��     
     for(int i =0;i<n;i++)
      for(int j =0;j<n;j++)
       {
        //�ھ�cell���r�P�_�}�C���e��0��1
        if(clickableCells[i][j].getText().equals("H"))
         matrix[i][j] = 0;
        else
         matrix[i][j] = 1;
       }
     
     return matrix;//�^��
    }
  }

 //�[�J�ƹ��ƥ�cell class
 static class ClickableCell extends Cell
  {
   //default
   public ClickableCell(String s)
    {
     super(s);//cell(s)
    
     //�[�J�ƹ��ƥ�
     addMouseListener(new MouseAdapter(){
      //�I���ƹ�
      public void mouseClicked(MouseEvent e){
       //�Ncell����r����
       if(getText().equals("H"))
        setText("T");
       else
        setText("H");
      }
     });
    }
  }
}