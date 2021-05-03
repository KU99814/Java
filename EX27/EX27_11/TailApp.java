//������ nine tail

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.io.*;

public class TailApp extends JFrame
{
 private InitialNodePanel initialNodePanel = new InitialNodePanel();//��ܪ�l���Apanel 
 private JButton jbtSolve = new JButton("Solve");//��ܸ��D���ǫ��s
 private JButton jbtStartOver = new JButton("Start Over");//���m���s

 private TailModel16 model;//tail Model ����
 //���Dpanel ��minitialNodePanel
 private JPanel solutionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));

 private static int num = TailModel16.DEMINION;//�ثe�����

 public TailApp() throws IOException,ClassNotFoundException
  {
   ObjectInputStream input = new ObjectInputStream(new FileInputStream("EX27_10.dat"));//Ū���ɮ�
   model = (TailModel16)(input.readObject());//��Jobject

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
     java.util.List<TailModel16.Node> list = 
        model.getShortestPath(new TailModel16.Node(initialNodePanel.getMatrix()));
    
     System.out.println(list.size());
     //�Ыبå[�Jnode panel �N�C�@�Ӹѵ�ø�X
     for(TailModel16.Node node: list)
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
   public NodePanel(int[][] matrix)
    {
     this.setLayout(new GridLayout(num,num));//�]�w�ƪ�gridlayout

     //�̧ǳЫبå[�Jcell panel
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
   ClickableCell[][] clickableCells = new ClickableCell[num][num];//cell�}�C ��ηƹ�����
   
   //default
   public InitialNodePanel()
    {
     this.setLayout(new GridLayout(num,num));//�]�w�ƪ�
     
     //��Jcell 
     for(int i=0;i<num;i++)
      for(int j=0;j<num;j++)
       add(clickableCells[i][j] = new ClickableCell("H"));
    }
   
   //�Ncell���e�ର�}�C
   public int[][] getMatrix()
    {
     int[][] matrix = new int[num][num];//�^�ǰ}�C
     
     //�j��
     for(int i =0;i<num;i++)
      for(int j =0;j<num;j++)
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
   public ClickableCell(String s)
    {
     super(s);

     //�[�J�ƹ��ƥ�
     addMouseListener(new MouseAdapter(){
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