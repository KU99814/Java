//�ϧΤ� knight tour

import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KnightTourApp extends JFrame
{
 private KnightTourModel model = new KnightTourModel();//knight tour object
 private PaintKnightTour paintKnightTour = new PaintKnightTour();//ø�Xpanel
 private JButton jbtSearch = new JButton("Search");//�}�l���X���s
 static int num = 6;//���
 
 public KnightTourApp()
  {
   JPanel panel = new JPanel();//�ާ@panel �[�J�U�ؾާ@component
   panel.add(new JLabel("start knight tour by Hamiltonian Cycle "));//������r
   panel.add(jbtSearch);//�[�J���X���s
   add(paintKnightTour,BorderLayout.CENTER);//�[�Jø��panel
   add(panel,BorderLayout.SOUTH);//�[�J�ާ@panel

   //���s�ƥ�
   jbtSearch.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){

     //���oHamiltonian Cycle ���|
     List<Integer> path =model.getHamiltonianCycle();

     paintKnightTour.displayPath(path);//�N���|�פJø��panel

     //�p�G���|���s�b ���null
     if(path==null)
      System.out.println("null");
    }
   });
  }

 //ø��panel
 private static class PaintKnightTour extends JPanel
  {
   private List<Integer> path;//Hamiltonian Cycle���|
   
   //default
   public PaintKnightTour()
    {
     setBorder(BorderFactory.createLineBorder(Color.black,1));//�[�J���
    }

   //�[�J���|
   public void displayPath(List<Integer> path)
    {
     this.path = path;
     repaint();
    }

   //ø��
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //ø�X��u ��u
     for(int i=0;i<num;i++)
      g.drawLine(0,i*getHeight()/num,getWidth(),i*getHeight()/num);
     
     //ø�X��u �a�u
     for(int i=0;i<num;i++)
      g.drawLine(i*getWidth()/num,0,i*getWidth()/num,getHeight());
     
     //�Y�L���| ����
     if(path == null)
      return;
     
     //ø�X���|
     for(int i=0;i<path.size()-1;i++)
      {
       int u=path.get(i);//�_�l�I
       int v = path.get(i+1);//���I
       
       //�u�� �_�I����I
       g.drawLine((u%num)*getWidth()/num+getWidth()/(num*2),
          (u/num)*getHeight()/num+getHeight()/(num*2),
          (v%num)*getWidth()/num+getWidth()/(num*2),
          (v/num)*getHeight()/num+getHeight()/(num*2));
      }
    }
  }
}