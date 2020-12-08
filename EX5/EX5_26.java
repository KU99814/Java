//發現Emirp

public class EX5_26
{
 public static void main(String args[])
  {
   int count = 0;
   int number = 2;//初始的數
   while(count <100) 
    {
     if(isPrime(number)) //檢查是否質數
      if(isEmirp(number)) //檢查是否Emirp
       {
        System.out.print(number+" "); //若是就顯示
        count++;
        if(count%10==0)
         System.out.println();
       }
     number++;
    }
   }

 public static boolean isPrime(int number) //檢查是否質數
  {
   for(int i = 2;i<=number/2;i++)
    if(number%i==0)
      return false;
   
   return true;
  }

 public static boolean isEmirp(int number) //檢查是否Emirp
  {
   int number2 = reverse(number);//將數字反轉
   if(isPrime(number2))//檢查是否質數以及與原數是否相同
    return true;
   else
    return false;
  }
 
 public static int reverse(int number) //倒反
  {
   int re = 0;//回傳值
   while(true)
    {
     re*=10; //往左進一位
     re += number%10; 
     number/=10; //往右進一位
     if(number==0)
      break;
    }
   return re;
  }
}