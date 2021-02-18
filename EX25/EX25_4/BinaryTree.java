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
   postorder(root);//呼叫
  }

 //後序 非遞迴
 protected void postorder(TreeNode<E> root)
  {
   if(root == null)//若為空 中止
    return;
   
   //儲存node stack
   java.util.Stack<TreeNode<E>> st = new java.util.Stack<TreeNode<E>>();

   st.push(root);//放入root

   //分為目前node與前node 
   TreeNode<E> current = null;
   TreeNode<E> perv = null;//親node用來判別是否尋訪所有子樹

   boolean findLeft = true;//判斷是否有左子樹

   //開始尋訪
   while(!st.empty())
    {
     while(findLeft)//先找左子樹
      {
       current = (TreeNode<E>)(st.peek());

       //先處理左子樹 若無 處理右子樹
       if(current.left !=null)
        {
         st.push(current.left);
        }
       else if(current.right !=null)
        {
         st.push(current.right);
        }
       else//若是leaf
        {
         System.out.print(current.element + " ");//顯示
         st.pop();
         perv = (TreeNode<E>)(st.peek());//上一個node 
         if(perv.left == current)//若目前的是左node 接下來處理右node
          {
           if(perv.right !=null)
            st.push(perv.right);
           else//若無右node 跳出處理親node
            {
             findLeft = false;
             break;
            }
          }

         else if(perv.right == current)//若是右node 顯示後跳出
          {
           System.out.print(perv.element + " ");

           st.pop();
           findLeft = false;
           break;
          }
        }
      }

     if(st.empty())//stack為空即跳出
      break;
     
     current = (TreeNode<E>)(st.pop());
     
     //判斷是否將左右子樹皆顯示 
     if(current.right !=null && current.right!=perv)
      {
       findLeft = true;
       st.push(current);
       st.push(current.right);
      }
     else
      {
       System.out.print(current.element + " ");
       perv = current;
      }
    }
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

 //清空
 public void clear()
  {
   root = null;
   size = 0;
  }
}