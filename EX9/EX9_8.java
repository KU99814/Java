//Financial: the Tax class

public class EX9_8
{
 public static void main(String args[])
  {
   int[][] bracket2001 = {{27050, 65550, 136750, 297350},
                          {45200, 109250, 166500, 297350},
                          {22600, 54625, 83250, 148675}, 
                          {36250, 93650, 151650, 297350}};  //2001年的tax filing 
   int[][] bracket2002 = {{6000,27950,67700,141250,307050}, 
                          {12000,46700,112850,171950,307050},
                          {6000,23350,56425,85975,153525},
                          {10000,37450,96700,156600,307050}}; //2002年的tax filing
   double[] rate2001 = {0.15, 0.275, 0.305, 0.355, 0.391}; 
   double[] rate2002 = {0.1, 0.15, 0.27, 0.30, 0.35, 0.386}; //稅率
   
   Tax tax2001 = new Tax();
   Tax tax2002 = new Tax(0,bracket2002,rate2002,50000); 

   System.out.println();
   System.out.println("2001");
   System.out.println("income SINGLE_FILER JOINTLY SEPARATELY HOUSEHOLD");
   
   for(int i=50000;i<=60000;i+=1000) //顯示
    {
     tax2001.setTaxableIncome(i);//設定收入
          
     //顯示各模式稅率
     tax2001.setFilingStatus(0);
     System.out.print(i+" ");
     System.out.print(tax2001.getTax()+" ");

     tax2001.setFilingStatus(1);
     System.out.print(tax2001.getTax()+" ");

     tax2001.setFilingStatus(2);
     System.out.print(tax2001.getTax()+" ");
     
     tax2001.setFilingStatus(3);
     System.out.println(tax2001.getTax());
    }

   System.out.println();
   System.out.println("2002");
   System.out.println("income SINGLE_FILER JOINTLY SEPARATELY HOUSEHOLD");

   //顯示2002年版
   for(int i=50000;i<=60000;i+=1000)
    {
     tax2002.setTaxableIncome(i);
          
     tax2002.setFilingStatus(0);
     System.out.print(i+" ");
     System.out.print(tax2002.getTax()+" ");

     tax2002.setFilingStatus(1);
     System.out.print(tax2002.getTax()+" ");

     tax2002.setFilingStatus(2);
     System.out.print(tax2002.getTax()+" ");
     
     tax2002.setFilingStatus(3);
     System.out.println(tax2002.getTax());
    }
  }
}

//計算稅的class
class Tax
{
 //各種模式
 public static int SINGLE_FILER = 0; //單身
 public static int MARRIED_JOINTLY = 1; //結婚
 public static int MARRIED_SEPARATELY = 2;//離婚
 public static int HEAD_OF_HOUSEHOLD = 3; //屋主

 private int filingStatus = SINGLE_FILER;//使用模式
 private int[][] brackets = {{27050, 65550, 136750, 297350},
                             {45200, 109250, 166500, 297350},
                             {22600, 54625, 83250, 148675}, 
                             {36250, 93650, 151650, 297350}}; //稅級攀升
 private double[] rates = {0.15, 0.275, 0.305, 0.355, 0.391}; //利率
 private double taxableIncome = 60000;

 //建構子
 public Tax()
  {}

 public Tax(int filingStatus,int[][] brackets,double[] rates,double taxableIncome)
  {
   this.filingStatus = filingStatus;
   this.brackets = brackets;
   this.rates = rates;
   this.taxableIncome = taxableIncome;
  }

 //設定模式
 public void setFilingStatus(int filingStatus)
  {
   this.filingStatus = filingStatus;
  }

 //設定稅級攀升
 public void setBrackets(int[][] brackets)
  {
   this.brackets = brackets;
  }

 //設定利率
 public void setRates(double[] rates)
  {
   this.rates = rates;
  }

 //設定收入
 public void setTaxableIncome(double taxableIncome)
  {
   this.taxableIncome = taxableIncome;
  }

 //回傳
 public int getFilingStatus() //模式
  {
   return filingStatus;
  }

 public int[][] getBrackets()//稅級攀升
  {
   return brackets;
  }

 public double[] getRates()//利率
  {
   return rates;
  }

 public double getTaxableIncome()//收入
  {
   return taxableIncome;
  }

 //計算稅
 public double getTax()
  {
   int incomeTo = 0;

   //根據模式使用不同稅級攀升
   for(int i=0;i<brackets[filingStatus].length;i++) 
    {
     if(taxableIncome <= brackets[filingStatus][i])
      {
       incomeTo = i;
       break;
      }
     if(taxableIncome > brackets[filingStatus][brackets[filingStatus].length-1])
      incomeTo = i;      
    }

   //計算稅
   double tax = 0;
   for(int i=0;i<incomeTo+1;i++)
    {
     if(incomeTo == 0)
      tax = taxableIncome*rates[i];
     else
      {
       if(i == 0)
        tax += brackets[filingStatus][i]*rates[i];
       else if(i < incomeTo)
        tax += (brackets[filingStatus][i] - brackets[filingStatus][i-1])*rates[i];
       else if(i == incomeTo)
        tax += (taxableIncome - brackets[filingStatus][i-1])*rates[i];
      }
    }
   
   return tax;
  }
}