//use "Fan" class

public class EX7_2
{
 public static void main(String args[])
  {
   //�ŧi��ӭ���
   Fan Fan1 = new Fan();
   Fan Fan2 = new Fan();

   Fan1.setSpeed(10); //�]�w�t��
   Fan1.setRadius(10); //�]�w�b�|
   Fan1.setColor("yellow"); //�]�w�C��
   Fan1.setTurn(true); //�]�w�}�����A

   Fan2.setSpeed(5); //�]�w�t��
   Fan2.setRadius(5); //�]�w�b�|
   Fan2.setTurn(false); //�]�w�}�����A

   //��ܨ�ӭ����̪��ܼ�
   System.out.println("The Fan1 is "+Fan1.toString()); 
   System.out.println("The Fan2 is "+Fan2.toString());
  }
}