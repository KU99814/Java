import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HeapView extends JPanel
{
 private Heap<Integer> heap;//heap
 private JTextField jtfKey = new JTextField(5);//��J��� ��J�n�j�M�Ʀr
 private PaintTree paintTree = new PaintTree();//��ı��heap����
 private JButton jbtInsert = new JButton("Insert");//���J���s
 private JButton jbtDelete = new JButton("Remove the root");//�������s

 //default
 public HeapView(Heap<Integer> heap)
  {
   this.heap = heap;//��Jheap
   setUI();//�]�wUI
  }

 //�]�wUI
 public void setUI()
  {
   this.setLayout(new BorderLayout());//��m�覡�]�w
   add(paintTree,BorderLayout.CENTER);//�[�Jø��panel
   JPanel panel = new JPanel();//���a����X
   
   //�Ncomponent��J���a���
   panel.add(new JLabel("Enter a key"));//��r
   panel.add(jtfKey);//��J���
   panel.add(jbtInsert);//���J���s
   panel.add(jbtDelete);//�������s
   add(panel,BorderLayout.SOUTH);//��Jframe
   
   //���s�ƥ� ���Jelement
   jbtInsert.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     int key = Integer.parseInt(jtfKey.getText());//���o��J�Ʀr
     heap.add(key);//�[�Jheap
     paintTree.repaint();//��ø
    }
   });

   //�����ƥ� ����root
   jbtDelete.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     heap.remove();//heap����
     paintTree.repaint();//��ø
    }
   });
  }

 //ø��panel
 class PaintTree extends JPanel
  {
   private int radius = 20;//��b�|
   private int vGap = 50;//�p��s�u�I��m
   
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //�N��ø�X
     if(heap.getSize() != 0)
      displayTree(g,0,getWidth() / 2,30,getWidth()/4);
    }

   //ø�X��
   private void displayTree(Graphics g,int index,int x,int y,int hGap)
    {
     g.drawOval(x - radius,y - radius,2 * radius,2*radius);//���
     g.drawString(heap.get(index) + "",x-6,y+4);//node���e
     
     //�Y�����l��
     if(index*2+1 <heap.getSize())
      {
       connectLeftChild(g,x-hGap,y+vGap,x,y);
       displayTree(g,index*2+1,x-hGap,y+vGap,hGap/2);
      }

     //�Y���k�l��
     if(index*2+2 <heap.getSize())
      {
       connectRightChild(g,x+hGap,y+vGap,x,y);
       displayTree(g,index*2+2,x+hGap,y+vGap,hGap/2);
      }
    }

   //ø��l��s���u
   private void connectLeftChild(Graphics g,int x1,int y1,int x2,int y2)
    {
     double d = Math.sqrt(vGap*vGap+(x2-x1)*(x2-x1));
     int x11 = (int)(x1+radius*(x2-x1)/d);
     int y11 = (int)(y1-radius*vGap/d);
     int x21 = (int)(x2-radius*(x2-x1)/d);
     int y21 = (int)(y2+radius*vGap/d);
     
     g.drawLine(x11,y11,x21,y21);//ø�u
    }

   //ø��k�l��s���u
   private void connectRightChild(Graphics g,int x1,int y1,int x2,int y2)
    {
     double d = Math.sqrt(vGap*vGap+(x2-x1)*(x2-x1));
     int x11 = (int)(x1-radius*(x1-x2)/d);
     int y11 = (int)(y1-radius*vGap/d);
     int x21 = (int)(x2+radius*(x1-x2)/d);
     int y21 = (int)(y2+radius*vGap/d);
     
     g.drawLine(x11,y11,x21,y21);//ø�u
    }
  }
}