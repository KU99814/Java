//computing future tuition

public class EX4_7
{
 public static void main(String args[])
  {
   double tuition = 40000; //學費
   double total = 0; //總額
   double increase = 0; //增額

   for(int i = 1;i<11;i++) //i為年數
    {
     if(i==1) //第一年時
      {
       System.out.println("The tuition in "+i+" year is "+tuition);
      }
     else //第二年以後
      {
       increase = tuition*0.03;
       tuition += increase;
       System.out.println("The tuition in "+i+" year is "+tuition);
      }
    }
   for(int i = 0;i<3;i++) //上面之後四年
    {
     increase = tuition*0.03;
     tuition += increase;
     total += tuition;
    }

   //輸出結果
   System.out.println("The total tuition in four year starting the ten year are: "+total);
  }
}