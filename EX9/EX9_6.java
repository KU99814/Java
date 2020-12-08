//Displaying the prime numbers

public class EX9_6
{
 public static void main(String args[])
  {
   StackOfIntegers stack = new StackOfIntegers(); //創stack

   for(int i=2;i<=120;i++)
    {
     boolean prime = true;
     int[] num = new int[stack.size()+1];  //比較用陣列
  
     for(int j=0;j<num.length-1;j++) //將stack數輸入陣列中
      num[j] = stack.push(); 

     for(int j = 0;j<num.length-1;j++) //比較
      {
       if(i%num[j] == 0)
        {
         prime = false;
         break;
        }
      }

     if(prime) //如符合
      {
       num[num.length-1] = i;
       
       for(int j=0;j<num.length;j++)
        stack.pop(num[j]);
      }
     else //如不符合
      {
       for(int j=0;j<num.length-1;j++)
        stack.pop(num[j]);
      }
    }
   stack.in();
  }
}

//自作stack
class StackOfIntegers
{
 private int[] stack = new int[16];//儲存陣列
 private int numSize = 0;//目前資料數

 //建構子
 public StackOfIntegers()
  {}

 public int size()//大小
  {
   return numSize;
  }

 //顯示內容
 public void in()
  {
   System.out.println();
   for(int i=0;i<numSize;i++)
    System.out.print(stack[i]+" ");
  }

 public void pop(int n) //放入
  {
   //容量不足的話
   if(stack.length==numSize)
    {
     int[] newStack = new int[stack.length*2+1];//創新陣列
   
     for(int i=0;i<stack.length;i++)//放入舊的內容
      newStack[i] = stack[i];
     stack = newStack;//指向新內容
    }
    
   stack[numSize] = n;//放入最新內容
   numSize++;
  }

 public int push() //放出
  {
   if(numSize==0)
    {
     System.out.println("The stack is empty");
     return -1;
    }
   numSize--;
   int num = stack[numSize];//回傳值 回傳最後放入內容

   return num;
  }
}   