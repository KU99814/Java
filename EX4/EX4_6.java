//Conversion from miles to kilometers

public class EX4_6
{
 public static void main(String args[])
  {
   System.out.println("Miles\t\tKilometers\t\tKilometer\t    Miles"); //��ܯ@�P�����������ഫ
   
   for(int i =1,j=20;i<11;i++,j+=5) //i���@ j������
    {
     double kilo = i*1.609; //�@�ऽ��
     double mile = j/1.609; //������@
     System.out.print(i+"\t\t"+kilo+"\t\t\t");
     System.out.printf("%d\t\t%10.3f\n",j,mile);
    }
  }
}