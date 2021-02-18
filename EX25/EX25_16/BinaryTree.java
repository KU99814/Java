//binary tree using comparator

import java.util.Comparator;

public class BinaryTree<E> extends AbstractTree<E>
{
 protected TreeNode<E> root;//�Ĥ@��node
 protected int size = 0;//node�`��

 private Comparator<? super E> comparator;

 //default
 public BinaryTree() 
 {}

 //default ���J�����
 public BinaryTree(Comparator<? super E> comparator) 
 {
  this.comparator = comparator;
 }

 //���Jelement
 public BinaryTree(E[] objects)
  {
   for(int i=0;i<objects.length;i++)
    insert(objects[i]);
  }

 
//�j�Melement
 public boolean search(E e)
  {
   TreeNode<E> current = root;//�ثenode �qroot�}�l

    //���j�p�v�B�M��
   while(current!=null)
    {
     if(comparator.compare(e,current.element) < 0)//�Y���p �䥪�l��
      current = current.left;
     else if(comparator.compare(e,current.element) > 0)//�Y���j ��k�l��
      current = current.right;
     else//�Y��� ��true
      return true;
    }

   return false;//�Y���̫ᬰnull ��false
  }

 //���Jnode
 public boolean insert(E e)
  {
   if(root == null)//�Y�𬰪� �����]��root 
    root = createNewNode(e);
   else
    {
     //��node�P�lnode
     TreeNode<E> parent = null;
     TreeNode<E> current = root;

     //�M�X��̤U�@level���lnode
     while(current!=null)
      {
       if(comparator.compare(e,current.element) < 0)//�Y���p �����l��
        {
         parent = current;
         current = current.left;
        }
       else if(comparator.compare(e,current.element) > 0)//�Y���j ���k�l��
        {
         parent = current;
         current = current.right;
        }
       else//�Y���۵��� �^��false
        return false;
      }

     //�̤j�p�P�_�[�����Υk�l��
     if(comparator.compare(e,parent.element) < 0)
      parent.left = createNewNode(e);
     else
      parent.right = createNewNode(e);
    }   

   size++;//�j�p+1

   return true;
  }
//�зsnode
 protected TreeNode<E> createNewNode(E e)
  {
   return new TreeNode<E>(e);
  }

 //����
 public void inorder()
  {
   inorder(root);//���j
  }
 //���� recursion helper method
 protected void inorder(TreeNode<E> root)
  {
   //�Y���� �����
   if(root == null)
    return;
   inorder(root.left);//�����j���l��
   System.out.print(root.element + " ");//���node
   inorder(root.right);//�A���j�k�l��
  }

 //���
 public void postorder()
  {
   postorder(root);//���j
  }

 //��� recursion helper method
 protected void postorder(TreeNode<E> root)
  {
   if(root == null)//�Y���� �����
    return;
   postorder(root.left);//���j���l��
   postorder(root.right);//���j�k�l��
   System.out.print(root.element + " ");//���
  }

 //�e��
 public void preorder()
  {
   preorder(root);//���j
  }

 //�e�� recursion helper method
 protected void preorder(TreeNode<E> root)
  {
   if(root == null)//�Y���� �����
    return;
   System.out.print(root.element + " ");//���
   preorder(root.left);//���j���l��
   preorder(root.right);//���j�k�l��
  }

 //�^�Ǥj�p
 public int getSize()
  {
   return size;
  }

 //�^��root
 public TreeNode<E> getRoot()
  {
   return root;
  }

 //�^�Ǹ��|
 public java.util.ArrayList<TreeNode<E>> path(E e)
  {
   java.util.ArrayList<TreeNode<E>> list = 
    new java.util.ArrayList<TreeNode<E>>();//�x�s�Ҧ��~�gnode
   TreeNode<E> current = root;//�ثenode �qroot�}�l

   //�}�l�M�X
   while(current != null)
    {
     list.add(current);//�[�J�ثenode
     
     //��j�p��X�U�@node
     if(comparator.compare(e,current.element)<0)
      current = current.left;
     else if(comparator.compare(e,current.element) > 0)
      current = current.right;
     else//�۲ŧY����
      break;
    }
    
   //�Y�S���ؼ� �^�Ǫ�list
   if(current==null)
    list = null;

   return list;
  }

 //�R��node
 public boolean delete(E e)
  {
   //�ثenode�ο�node
   TreeNode<E> parent = null;
   TreeNode<E> current = root;

   //�M�X�ܥؼ�node
   while(current!=null)
    {
     if(comparator.compare(e,current.element) < 0)//�����l��
      {
       parent = current;
       current = current.left;
      }
     else if(comparator.compare(e,current.element) > 0)//���k�l��
      {
       parent = current;
       current = current.right;
      }
     else//���ؼЩΨ��node
      break;
    }
   
   if(current == null)//�p�G��null �ؼФ��s�b
    return false;

   //�R��������ت��p
   //case1:�S�����l��   
   if(current.left==null)
    {
     if(parent == null)//�Y�R��node�Y��root 
      root = current.right;//�����N�knode�]��root
     else
      {
       //����j�p �P�_�R�����O��node�٬O�knode
       if(comparator.compare(e,parent.element) < 0)
        parent.left = current.right;
       else
        parent.right = current.right;
      }
    }
   //case2:�����l��
   else
    {
     //���l�𤤳̥knode �H�ؼ�node�M�䥪node�}�l
     TreeNode<E> parentOfRightMost = current;
     TreeNode<E> rightMost = current.left;

     //�M�X�̥knode
     while(rightMost.right != null)
      {
       parentOfRightMost = rightMost;
       rightMost = rightMost.right;
      }

     //�N�n�R��node�γ̥knode���N
     current.element = rightMost.element;

     //�N�쥻���̥knode���N���L���lnode
     if(parentOfRightMost.right == rightMost)
      parentOfRightMost.right = rightMost.left;
     else
      parentOfRightMost.left = rightMost.left;
    }

   size--;//�j�p-1
   return true;
  }

 //���N
 public java.util.Iterator iterator()
  {
   return inorderIterator();//�I�s method
  }

 //���ǭ��N 
 public java.util.Iterator inorderIterator()
  {
   return new InorderIterator();//�^�ǭ��N��
  }

 //���N��
 class InorderIterator implements java.util.Iterator
  {
   private java.util.ArrayList<E> list = 
    new java.util.ArrayList<E>();//�x�s�M�X��node

   private int current = 0;//�M�X��node��

   //default
   public InorderIterator()
    {
     inorder();//�I�s
    }
   
   //���ǭ��N
   public void inorder()
    {
     inorder(root);
    }

   ////���ǭ��N recursion helper method
   private void inorder(TreeNode<E> root)
    {
     if(root == null)
      return;
     inorder(root.left);//���j���l��
     list.add(root.element);//list��Jnode
     inorder(root.right);//���j�k�l��
    }

   //�O�_���U�@��
   public boolean hasNext()
    {
     if(current < list.size())//�Y�M�X�ƶq�S��̤j �^��true
      return true;
     
     return false;
    }

   //��U�@��object
   public Object next()
    {
     return list.get(current++);
    }

   //����   
   public void remove()
    {
     delete(list.get(current));
     list.clear();
     inorder();//�����᭫�s�M�X
    }
  }

 //�M��
 public void clear()
  {
   root = null;
   size = 0;
  }
}