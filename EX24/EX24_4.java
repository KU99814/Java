//Using the stack class

public class EX24_4
{
 public static void main(String args[])
  {
   java.util.Stack<Integer> st = new java.util.Stack<Integer>();//�ŧistack

   st.push(2);//��J�Ĥ@�ӽ��2

   int size = 1;//��ƭӼ�
   int number = 3;//�ˬd�O�_�O��ƪ���

   while(size<50)//�j�骽���50��
    {
     boolean isPrime = true;//��ƧP�_

     //�Hstack�̤W�@�ӼƬ��� �P�_�O�_��㰣
     for(int i=1;i<st.peek();i++)
      {
       if(st.search(i)>=0 && number%i==0)
        {
         isPrime = false;
         break;
        }
      }
    
     if(isPrime)//�Y�O��� ��Jstack
      {
       st.push(number);
       size++;
      }
     
     number++;//���U�@�Ӽ�
    }

   int count = 1;//��ܤQ�Ӽƴ���

   //���stack������
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