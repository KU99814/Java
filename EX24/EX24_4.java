//Using the stack class

public class EX24_4
{
 public static void main(String args[])
  {
   java.util.Stack<Integer> st = new java.util.Stack<Integer>();//stack

   st.push(2);//材借计2

   int size = 1;//借计计
   int number = 3;//浪琩琌琌借计计

   while(size<50)//癹伴材50
    {
     boolean isPrime = true;//借计耞

     //stack程计ゎ 耞琌俱埃
     for(int i=1;i<st.peek();i++)
      {
       if(st.search(i)>=0 && number%i==0)
        {
         isPrime = false;
         break;
        }
      }
    
     if(isPrime)//璝琌借计 stack
      {
       st.push(number);
       size++;
      }
     
     number++;//传计
    }

   int count = 1;//陪ボ计传︽

   //陪ボstackず计
   while(!st.empty())
    {
     if(count%10==0)
      System.out.println(st.pop());
     else
      System.out.print(st.pop()+" ");

     count++;
    }
  }
}