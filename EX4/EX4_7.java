//computing future tuition

public class EX4_7
{
 public static void main(String args[])
  {
   double tuition = 40000; //�ǶO
   double total = 0; //�`�B
   double increase = 0; //�W�B

   for(int i = 1;i<11;i++) //i���~��
    {
     if(i==1) //�Ĥ@�~��
      {
       System.out.println("The tuition in "+i+" year is "+tuition);
      }
     else //�ĤG�~�H��
      {
       increase = tuition*0.03;
       tuition += increase;
       System.out.println("The tuition in "+i+" year is "+tuition);
      }
    }
   for(int i = 0;i<3;i++) //�W������|�~
    {
     increase = tuition*0.03;
     tuition += increase;
     total += tuition;
    }

   //��X���G
   System.out.println("The total tuition in four year starting the ten year are: "+total);
  }
}