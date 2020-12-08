//calculating PI

public class EX4_25
{
 public static void main(String args[])
  {
   int plus = 1;// 決定正負數
   int count2 = 0;//第二程式用 計算次數 
   double pai = 0;//第一程式用 PI
   double pai2 = 0;;//第二程式用 PI
   
   //第一程式 計算i=10000到i=100000
   for(int i = 10000;i<=100000;i+=10000)
    {
     for(int j = 1;j <= (2*i) +1;j+=2)
      {
       double k = 1;
       k /= j;
       k*=plus;
        pai += k;
       plus*=-1;
      }
     pai *= 4;
     System.out.printf("The Pai is %.7f",pai);
     System.out.println();
     plus = 1;
     pai = 0;
    }

   plus = 1;
   //第二程式 計算到逼近3.14159
   for(int i = 10000;true;i+=10000)
    {
     for(int j = 1;j <= (2*i) +1;j+=2)
      {
       double k = 1;
       k /= j;

       k*=plus;

       pai2 += k;
       plus *= -1;
      }
     pai2 *= 4;
     count2++;
     if(pai2 < 3.141595 && pai2>0)
      {
       System.out.printf("The count of PI less 3.14159 is %d %10.5f",count2,pai2);
       break;
      } 
     pai2 = 0;
    }
  }
}

