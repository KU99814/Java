//��ı��binary tree

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BinaryTreeView extends JPanel
{
 private BinaryTree<Integer> tree;//binary tree
 private JTextField jtfKey = new JTextField(5);//��J��� ��J�n�j�M�Ʀr
 private PaintTree paintTree = new PaintTree();//��ı��binary tree����
 private JButton jbtSearch = new JButton("Search");//�j�M����
 private JButton jbtInsert = new JButton("Insert");//���J���s
 private JButton jbtDelete = new JButton("Delete");//�������s

 private boolean isSearch = false;//�P�_�O�_���
 private boolean isPath = false;//�P�_�O�_���|
 private boolean isDelete = false;
 private boolean isAnimate = false;//�P�_�O�_�ʵe
 private java.util.ArrayList path;//���|list

 private int key;//�q��J����o���Ʀr

 int count = 0;//�ثe���node�ƶq

 /*

 class TimerListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     if(count < path.size())
      count++;
     if(isInsert && count == path.size())
      {
       TreeNode n = (TreeNode)(path.get(count-1));
       tree.insert((Integer)(n.element));
       path = tree.path((Integer)(n.element));
       isInsert = false;
      }
     else if(isDelete && count == path.size())
      {
       TreeNode d = (TreeNode)(path.get(count-1));
       TreeNode l = d.left;
       TreeNode r = d.right;
       tree.delete((Integer)(d.element));

       if(l!=null)
        {
         path = tree.path((Integer)(l.element));
         count= path.size();
        }
       else if(r!=null)
        {
         path = tree.path((Integer)(r.element));
         count= path.size();
        }

       isDelete = false;
      }
     paintTree.repaint();
    }
  }*/

 Timer timerSearch = new Timer(1000,new TimerSearchListener()); //�p�ɾ� �j�M�ƥ�

 Timer timerInsert = new Timer(1000,new TimerInsertListener()); //�p�ɾ� ���J�ƥ�

 Timer timerDelete = new Timer(1000,new TimerDeleteListener()); //�p�ɾ� �����ƥ�

 //�j�M�ʵe�ƥ�
 class TimerSearchListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     //�Y�ثe�ƶq�p����|node�ƶq
     if(count < path.size())
      count++;//+1
     
     else if(count == path.size())
      {
       if(!isSearch)//�Y�S����� �b�̫����
        {
         JOptionPane.showMessageDialog(null,key+" is not in the tree");//��ܿ��~��    
        }
       isSearch = false;
       timerSearch.stop();//����ʧ@
      }
     paintTree.repaint();//��ø
    }
  }

 //���J�ʵe�ƥ�
 class TimerInsertListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     //�Y�ثe�ƶq�p����|node�ƶq
     if(count < path.size())
      {
       count++;//+1
       paintTree.repaint();
      }
     
     else if(count == path.size())//��F���J��parent
      {
       if(isSearch)//�Y�w�s�b ��ܿ��~�T����
        {
         JOptionPane.showMessageDialog(null,key+" is already in the tree");
         isSearch = false;
        }
       else
        {
         path.add(new TreeNode(key));//�[�J����|
       
         tree.insert(key);//�[�J���
         count++;//�n��ܺ�� count+1
         paintTree.repaint();//��ø
        }

       timerInsert.stop();//����ʧ@
      }
    }
  }

 //�����ʵe�ƥ�
 class TimerDeleteListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     //�Y�ثe�ƶq�p����|node�ƶq
     if(count < path.size())
      {
       count++;//+1
       paintTree.repaint();
      }
     
     else if(count == path.size())//��F������parent
      {
       if(!isSearch)//�Y�w�s�b ��ܿ��~�T����
        {
         JOptionPane.showMessageDialog(null,key+" is not in the tree");
         isSearch = false;
        }
       else
        {
         tree.delete(key);//�q�𲾰�
         paintTree.repaint();//��ø
        }

       timerDelete.stop();//����ʧ@
      }
    }
  }

 //default
 public BinaryTreeView(BinaryTree<Integer> tree)
  {
   this.tree = tree;//��Jbinary tree
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
   panel.add(jbtSearch);//�j�M����
   panel.add(jbtInsert);//���J���s
   panel.add(jbtDelete);//�������s
   add(panel,BorderLayout.SOUTH);//��Jframe
   
   //���s�ƥ� �j�M��J�Ʀr����ܸ��|   
   jbtSearch.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){

     key = Integer.parseInt(jtfKey.getText());//��J���Ʀr

     path = null;
     isAnimate = true;//�}�l�ʵe
     isSearch = tree.search(key);//�P�_�O�_���
     paintTree.repaint();//��ø��ܭ�l����
     path = tree.path(key);//���o���|
     count = 0;//�p���k�s
     timerSearch.start();//�}�l�p�ɰʧ@
    }
   });

   //���J�ƥ�
   jbtInsert.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     key = Integer.parseInt(jtfKey.getText());//�n���J����
     
     isSearch = tree.search(key);//�P�_�O�_�w�b��
     
     paintTree.repaint();//���m����
     path = tree.path(key);//���o���|
     isAnimate = true;//�}�l�ʵe
     count = 0;//�p���k�s
     timerInsert.start();//�}�l�ƥ�
    }
   });

   //�����ƥ�
   jbtDelete.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     key = Integer.parseInt(jtfKey.getText());//�n��������
     
     paintTree.repaint();//���m����
     isSearch = tree.search(key);//�P�_�O�_�b��
     isAnimate = true;//�}�l�ʵe
     path = tree.path(key);//���o���|
     count = 0;//�p���k�s
     timerDelete.start();//�}�l�ƥ�
    }
   });
  }

 //ø��panel
 class PaintTree extends JPanel
  {
   private int radius = 20;//��b�|
   private int vGap = 50;//�p��s�u�I��m
   
   //ø��
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //�N��ø�X
     if(tree.getRoot() != null)
      displayTree(g,tree.getRoot(),getWidth() / 2,30,getWidth()/4);
    }

   //ø�X��
   private void displayTree(Graphics g,TreeNode root,int x,int y,int hGap)
    {
     //�P�_�ثenode�O�_�b���|��
     for(int i=0;path!=null&&i<count;i++)
      {
       TreeNode n = (TreeNode)(path.get(i));//�qlist�����Xnode
       if((n.element).compareTo(root.element)==0)//����O�_�۵��ӧP�_�O�_�b���|��
        {
         isPath = true;
         break;
        }
      }

     //�Y�O�ʵe�� �N�g�L���|��nodeø�����
     if(isAnimate && isPath)
      {
       g.setColor(Color.GREEN);//�]�����
       g.fillOval(x - radius,y - radius,2 * radius,2*radius);//ø�� ���
       g.setColor(Color.BLACK);//�]���¦�
       g.drawString(root.element + "",x-6,y+4);//��r
       isPath = false;//�����P�_
      }

     else//�Y�_ ø���Ť�
      {
       g.setColor(Color.black);//�]���¦�
       g.drawOval(x - radius,y - radius,2 * radius,2*radius);//ø��
       g.drawString(root.element + "",x-6,y+4);//��r
      }

     //�Y�����l��
     if(root.left != null)
      {
       connectLeftChild(g,x-hGap,y+vGap,x,y);//ø��s���u
       displayTree(g,root.left,x-hGap,y+vGap,hGap/2);//ø��
      }

     //�Y���k�l��
     if(root.right != null)
      {
       connectRightChild(g,x+hGap,y+vGap,x,y);//ø��s���u
       displayTree(g,root.right,x+hGap,y+vGap,hGap/2);//ø��
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