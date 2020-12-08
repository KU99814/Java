import java.util.*;

public class EX10_5
{
 public static void main(String args[])
  {
   MyStack stack1 = new MyStack(); //�ŧiMyStack1 �s��Ʀr
   MyStack stack2 = new MyStack(); //�ŧiMyStack2 //�s��B��Ÿ�

   Scanner input = new Scanner(System.in); //�ŧi��J

   System.out.print("��J�⦡�A��J�����}�l�B��: ");
   
   while(true)                        //��J�⦡
    {     
     stack1.push(input.nextInt());     //��J�Ʀr
     String peek = "";
     if(!stack2.isEmpty())//�ˬd�B��l
      peek = ((String)stack2.peek());

     //�]����������[�� �J�쭼�����B��     
     boolean signM = peek.equals("*");
     boolean signD = peek.equals("/");

     if((signM || signD) && stack1.getSize() > stack2.getSize())//�Y�O�����B�Ʀr����
      {
       //�ھڭ����i��B��
       if(signM)//��
        {
         stack2.pop();//���X�B��l
         int p1= ((Integer)stack1.pop()).intValue(); //���X�Ʀr
         int p2= ((Integer)stack1.pop()).intValue();
      
         int num = p1*p2;//�p��
         stack1.push(num);     //�N�Ʀr��^
        }
      
       if(signD)//��
        {
         stack2.pop(); 
         int p1= ((Integer)stack1.pop()).intValue();      //�ഫ
         int p2= ((Integer)stack1.pop()).intValue();
       
         int num = p2/p1;//�]��stack���i��X ��X���Ʀr�n��b�e��
         stack1.push(num);     //�N�Ʀr��^
        }
      }

     stack2.push(input.next());        //��J�B�⤸�@+ - * /
     if(((String)stack2.peek()).equals("="))      //��J��������
      break;
    }
   stack2.pop();  //�ư�����

   //�]���[��n���Ӷ��� �Nstack�����Ʀr�˥X��
   MyStack stack3 = new MyStack(); //�ŧiMyStack3 �Ψө�m�Ʀr

   while(stack1.getSize()!=0)//�N�Ʀr��J
    {
     stack3.push(stack1.pop());
    }

   while(stack2.getSize()!=0)//�N�B��l�]�˨�stack1
    {
     stack1.push(stack2.pop());
    }

   while(stack3.getSize() > 1)//�p�� ����ѤU�@�ӼƦr
    {
     String pop = ((String)stack1.pop());
     boolean signP = pop.equals("+");
     boolean signS = pop.equals("-");
       
     if(signP)
      {        
       int p1= ((Integer)stack3.pop()).intValue();      //�ഫ
       int p2= ((Integer)stack3.pop()).intValue();
      
       int num = p1+p2;
       stack3.push(num);     //��J�Ʀr
      }
      
     if(signS)
      {
       int p1= ((Integer)stack3.pop()).intValue();      //�ഫ
       int p2= ((Integer)stack3.pop()).intValue();
      
       int num = p1-p2;
        System.out.println(num);
       stack3.push(num);     //��J�Ʀr        
      }
    }
     
   System.out.print("the result is "+stack3.pop());              //��ܵ��G
  }
}