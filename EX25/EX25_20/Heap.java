//Heap implement

public class Heap<E extends Comparable>
{
 private java.util.ArrayList<E> list = new java.util.ArrayList<E>();//儲存陣列

 //default
 public Heap()
  {}
 
 public Heap(E[] objects)
  {
   for(int i=0;i<objects.length;i++)
    add(objects[i]);
  }

 //加入element
 public void add(E newObject)
  {
   list.add(newObject);//先將element加入list
   
   int currentIndex = list.size()-1;//目前的index
   
   //跟parent node比較大小 直到所有parent node都較小
   while(currentIndex > 0)
    {
     int parentIndex = (currentIndex-1)/2;//parent node的index

     //比較大小 若較小即交換     
     if(list.get(currentIndex).compareTo(list.get(parentIndex)) > 0)
      {
       E temp = list.get(currentIndex);
       list.set(currentIndex,list.get(parentIndex));
       list.set(parentIndex,temp);
      }
     else//若較大即跳出迴圈
      break;
     
     currentIndex = parentIndex;//parent index變為目前index
    }
  }

 //取得指定element
 public E get(int index)
  {
   return list.get(index);
  }
 
 //移除element
 public E remove()
  {
   if(list.size()==0)//若樹為空 回傳null
    return null;
   //移除時從root開始
   E removedObject = list.get(0);//回傳element
   list.set(0,list.get(list.size() - 1));//將最後的node與root交換
   list.remove(list.size()-1);//移除root

   int currentIndex = 0;//目前index

   //重新比較大小 排序heap
   while(currentIndex < list.size())
    {
     //左右子樹index
     int leftChildIndex = 2*currentIndex + 1;
     int rightChildIndex = 2*currentIndex + 2;

     //若沒有子樹 跳出
     if(leftChildIndex >= list.size())
      break;

     int minIndex = leftChildIndex;//最小數index

     //先比較左右node誰最小
     if(rightChildIndex < list.size())
      {
       if(list.get(minIndex).compareTo(list.get(rightChildIndex)) < 0)
        minIndex = rightChildIndex;
      }
     
     //若是比最小的數還大 交換
     if(list.get(currentIndex).compareTo(list.get(minIndex)) < 0)
      {
       E temp = list.get(minIndex);
       list.set(minIndex,list.get(currentIndex));
       list.set(currentIndex,temp);
       currentIndex = minIndex; 
      }
     else//若已經是最小 跳出
      break;
    }
   
   return removedObject;//回傳
  }

 //回傳大小
 public int getSize()
  {
   return list.size();
  }
}