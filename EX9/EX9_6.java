//Displaying the prime numbers

public class EX9_6
{
 public static void main(String args[])
  {
   StackOfIntegers stack = new StackOfIntegers(); //��stack

   for(int i=2;i<=120;i++)
    {
     boolean prime = true;
     int[] num = new int[stack.size()+1];  //����ΰ}�C
  
     for(int j=0;j<num.length-1;j++) //�Nstack�ƿ�J�}�C��
      num[j] = stack.push(); 

     for(int j = 0;j<num.length-1;j++) //���
      {
       if(i%num[j] == 0)
        {
         prime = false;
         break;
        }
      }

     if(prime) //�p�ŦX
      {
       num[num.length-1] = i;
       
       for(int j=0;j<num.length;j++)
        stack.pop(num[j]);
      }
     else //�p���ŦX
      {
       for(int j=0;j<num.length-1;j++)
        stack.pop(num[j]);
      }
    }
   stack.in();
  }
}

//�ۧ@stack
class StackOfIntegers
{
 private int[] stack = new int[16];//�x�s�}�C
 private int numSize = 0;//�ثe��Ƽ�

 //�غc�l
 public StackOfIntegers()
  {}

 public int size()//�j�p
  {
   return numSize;
  }

 //��ܤ��e
 public void in()
  {
   System.out.println();
   for(int i=0;i<numSize;i++)
    System.out.print(stack[i]+" ");
  }

 public void pop(int n) //��J
  {
   //�e�q��������
   if(stack.length==numSize)
    {
     int[] newStack = new int[stack.length*2+1];//�зs�}�C
   
     for(int i=0;i<stack.length;i++)//��J�ª����e
      newStack[i] = stack[i];
     stack = newStack;//���V�s���e
    }
    
   stack[numSize] = n;//��J�̷s���e
   numSize++;
  }

 public int push() //��X
  {
   if(numSize==0)
    {
     System.out.println("The stack is empty");
     return -1;
    }
   numSize--;
   int num = stack[numSize];//�^�ǭ� �^�ǳ̫��J���e

   return num;
  }
}   