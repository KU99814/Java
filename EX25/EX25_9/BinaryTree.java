//binary tree

import java.util.*;

public class BinaryTree<E extends Comparable<E>> extends AbstractTree<E>
{
 protected TreeNode<E> root;//第一個node
 protected int size = 0;//node總數

 //default
 public BinaryTree()
  {}

 public BinaryTree(E[] objects)
  {
   for(int i=0;i<objects.length;i++)
    insert(objects[i]);
  }

 //搜尋element
 public boolean search(E e)
  {
   TreeNode<E> current = root;//目前node 從root開始

   //按大小逐步尋找
   while(current!=null)
    {
     if(e.compareTo(current.element) < 0)//若較小 找左子樹
      current = current.left;
     else if(e.compareTo(current.element) > 0)//若較大 找右子樹
      current = current.right;
     else//若找到 傳true
      return true;
    }

   return false;//若找到最後為null 傳false
  }

 //插入node
 public boolean insert(E e)
  {
   if(root == null)//若樹為空 直接設為root 
    root = createNewNode(e);
   else
    {
     //親node與子node
     TreeNode<E> parent = null;
     TreeNode<E> current = root;

     //尋訪到最下一level的子node
     while(current!=null)
      {
       if(e.compareTo(current.element) < 0)//若較小 往左子樹
        {
         parent = current;
         current = current.left;
        }
       else if(e.compareTo(current.element) > 0)//若較大 往右子樹
        {
         parent = current;
         current = current.right;
        }
       else//若有相等的 回傳false
        return false;
      }
     //依大小判斷加為左或右子樹
     if(e.compareTo(parent.element) < 0)
      parent.left = createNewNode(e);
     else
      parent.right = createNewNode(e);
    }   

   size++;//大小+1

   return true;
  }

 //創新node
 protected TreeNode<E> createNewNode(E e)
  {
   return new TreeNode<E>(e);
  }

 //中序
 public void inorder()
  {
   inorder(root);//遞迴
  }
 //中序 recursion helper method
 protected void inorder(TreeNode<E> root)
  {
   //若為空 不顯示
   if(root == null)
    return;
   inorder(root.left);//先遞迴左子樹
   System.out.print(root.element + " ");//顯示node
   inorder(root.right);//再遞迴右子樹
  }

 //後序
 public void postorder()
  {
   postorder(root);//遞迴
  }

 //後序 recursion helper method
 protected void postorder(TreeNode<E> root)
  {
   if(root == null)//若為空 不顯示
    return;
   postorder(root.left);//遞迴左子樹
   postorder(root.right);//遞迴右子樹
   System.out.print(root.element + " ");//顯示
  }

 //前序
 public void preorder()
  {
   preorder(root);//遞迴
  }

 //前序 recursion helper method
 protected void preorder(TreeNode<E> root)
  {
   if(root == null)//若為空 不顯示
    return;
   System.out.print(root.element + " ");//顯示
   preorder(root.left);//遞迴左子樹
   preorder(root.right);//遞迴右子樹
  }

 //回傳大小
 public int getSize()
  {
   return size;
  }

 //回傳root
 public TreeNode<E> getRoot()
  {
   return root;
  }

//回傳路徑
 public java.util.ArrayList<TreeNode<E>> path(E e)
  {
   java.util.ArrayList<TreeNode<E>> list = 
    new java.util.ArrayList<TreeNode<E>>();//儲存所有途經node
   TreeNode<E> current = root;//目前node 從root開始

   //開始尋訪
   while(current != null)
    {
     list.add(current);//加入目前node
     
     //比大小找出下一node
     if(e.compareTo(current.element)<0)
      current = current.left;
     else if(e.compareTo(current.element) > 0)
      current = current.right;
     else//相符即結束
      break;
    }

   //若沒有找到 回傳null
   if(current == null)
    list = null;
   return list;
  }

 //刪除node
 public boolean delete(E e)
  {
   //目前node及親node
   TreeNode<E> parent = null;
   TreeNode<E> current = root;

   //尋訪至目標node
   while(current!=null)
    {
     if(e.compareTo(current.element) < 0)
      {
       parent = current;
       current = current.left;
      }
     else if(e.compareTo(current.element) > 0)
      {
       parent = current;
       current = current.right;
      }
     else
      break;
    }
   
   if(current == null)//若找不到 false
    return false;
   
   //刪除分為兩種狀況
   //case1:沒有左子樹
   if(current.left==null)
    {
     if(parent == null)//若刪除node即為root 
      root = current.right;//直接將右node設為root
     else
      {
       //比較大小 判斷刪除的是左node還是右node
       if(e.compareTo(parent.element) < 0)
        parent.left = current.right;
       else
        parent.right = current.right;
      }
    }
   //case2:有左子樹
   else
    {
     //左子樹中最右node 以目標node和其左node開始
     TreeNode<E> parentOfRightMost = current;
     TreeNode<E> rightMost = current.left;

     //尋訪最右node
     while(rightMost.right != null)
      {
       parentOfRightMost = rightMost;
       rightMost = rightMost.right;
      }

     //將要刪除node用最右node替代
     current.element = rightMost.element;

     //將原本的最右node替代為他的子node
     if(parentOfRightMost.right == rightMost)
      parentOfRightMost.right = rightMost.left;
     else
      parentOfRightMost.left = rightMost.left;
    }

   size--;//大小-1
   return true;
  }

 //迭代
 public java.util.Iterator iterator()
  {
   return inorderIterator();//呼叫 method
  }

 //中序迭代 
 public java.util.Iterator inorderIterator()
  {
   return new InorderIterator();//回傳迭代器
  }

//迭代器
 class InorderIterator implements java.util.Iterator
  {
   private java.util.ArrayList<E> list = 
    new java.util.ArrayList<E>();//儲存尋訪的node

   private int current = 0;//尋訪的node數

   //default
   public InorderIterator()
    {
     inorder();//呼叫
    }
   
   //中序迭代
   public void inorder()
    {
     inorder(root);
    }

   ////中序迭代 recursion helper method
   private void inorder(TreeNode<E> root)
    {
     if(root == null)
      return;
     inorder(root.left);//遞迴左子樹
     list.add(root.element);//list放入node
     inorder(root.right);//遞迴右子樹
    }

   //是否有下一個
   public boolean hasNext()
    {
     if(current < list.size())//若尋訪數量沒到最大 回傳true
      return true;
     
     return false;
    }

   //到下一個object
   public Object next()
    {
     return list.get(current++);
    }

   //移除   
   public void remove()
    {
     delete(list.get(current));
     list.clear();
     inorder();//移除後重新尋訪
    }
  }

 //listiterator 呼叫method
 public java.util.ListIterator listIterator()
  {
   return inorderListIterator();
  }

 //list iterator
 public java.util.ListIterator inorderListIterator()
  {
   return new BidirectionalIterator();
  }

 //Bidirectional list Iterator
 class BidirectionalIterator implements java.util.ListIterator
  {
   private java.util.ArrayList<E> list = new java.util.ArrayList<E>();//儲存路徑

   private int current = 0;//目前第幾個node

   //default
   public BidirectionalIterator()
    {
     inorder();//中序排列
    }

   //中序排列
   public void inorder()
    {
     inorder(root);
    }

   //Recursive helper method
   private void inorder(TreeNode<E> root)
    {
     current=0;
     if(root == null)//若tree為空 回傳null
      return;
     //按左中右順序放入list
     inorder(root.left);
     list.add(root.element);
     inorder(root.right);
    }

   //加入element
   public void add(Object e)
    {
     insert((E)e);//加入
     list.clear();//清空list
     inorder(); //重新尋訪
    }

   //判斷是否有下一個
   public boolean hasNext()
    {
     //若目前index小於size 回傳true
     if(current < list.size())
      return true;
     
     return false;//若否 傳false
    }

   //判斷是否有前一個
   public boolean hasPrevious()
    {
     //若目前index不小於0 回傳true
     if(current >0 )
      return true;
     
     return false;//若否 回傳false
    }

   //回傳目前element並前進到下一個
   public Object next()
    {
     return list.get(current++);
    }

   //取得目前index之後的index
   public int nextIndex()
    {
     return current+1;
    }

   //往回移動並取得element
   public Object previous()
    {
     return list.get(--current);
    }

   //取得目前index之後的index
   public int previousIndex()
    {
     return current-1;
    }

   //移除目前element
   public void remove()
    {
     delete(list.get(current));//從樹裡移除element
     list.clear();//清空list
     inorder();//重新尋訪
    }

   
   public void set(Object e)
    {
     delete(list.get(current));//從樹裡移除element
     insert((E)e);//加入element
     list.clear();//清空
     inorder();//重新尋訪
    }
  }

 //清空
 public void clear()
  {
   root = null;
   size = 0;
  }
}