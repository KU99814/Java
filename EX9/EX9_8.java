//Financial: the Tax class

public class EX9_8
{
 public static void main(String args[])
  {
   int[][] bracket2001 = {{27050, 65550, 136750, 297350},
                          {45200, 109250, 166500, 297350},
                          {22600, 54625, 83250, 148675}, 
                          {36250, 93650, 151650, 297350}};  //2001�~��tax filing 
   int[][] bracket2002 = {{6000,27950,67700,141250,307050}, 
                          {12000,46700,112850,171950,307050},
                          {6000,23350,56425,85975,153525},
                          {10000,37450,96700,156600,307050}}; //2002�~��tax filing
   double[] rate2001 = {0.15, 0.275, 0.305, 0.355, 0.391}; 
   double[] rate2002 = {0.1, 0.15, 0.27, 0.30, 0.35, 0.386}; //�|�v
   
   Tax tax2001 = new Tax();
   Tax tax2002 = new Tax(0,bracket2002,rate2002,50000); 

   System.out.println();
   System.out.println("2001");
   System.out.println("income SINGLE_FILER JOINTLY SEPARATELY HOUSEHOLD");
   
   for(int i=50000;i<=60000;i+=1000) //���
    {
     tax2001.setTaxableIncome(i);//�]�w���J
          
     //��ܦU�Ҧ��|�v
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

   //���2002�~��
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

//�p��|��class
class Tax
{
 //�U�ؼҦ�
 public static int SINGLE_FILER = 0; //�樭
 public static int MARRIED_JOINTLY = 1; //���B
 public static int MARRIED_SEPARATELY = 2;//���B
 public static int HEAD_OF_HOUSEHOLD = 3; //�ΥD

 private int filingStatus = SINGLE_FILER;//�ϥμҦ�
 private int[][] brackets = {{27050, 65550, 136750, 297350},
                             {45200, 109250, 166500, 297350},
                             {22600, 54625, 83250, 148675}, 
                             {36250, 93650, 151650, 297350}}; //�|���k��
 private double[] rates = {0.15, 0.275, 0.305, 0.355, 0.391}; //�Q�v
 private double taxableIncome = 60000;

 //�غc�l
 public Tax()
  {}

 public Tax(int filingStatus,int[][] brackets,double[] rates,double taxableIncome)
  {
   this.filingStatus = filingStatus;
   this.brackets = brackets;
   this.rates = rates;
   this.taxableIncome = taxableIncome;
  }

 //�]�w�Ҧ�
 public void setFilingStatus(int filingStatus)
  {
   this.filingStatus = filingStatus;
  }

 //�]�w�|���k��
 public void setBrackets(int[][] brackets)
  {
   this.brackets = brackets;
  }

 //�]�w�Q�v
 public void setRates(double[] rates)
  {
   this.rates = rates;
  }

 //�]�w���J
 public void setTaxableIncome(double taxableIncome)
  {
   this.taxableIncome = taxableIncome;
  }

 //�^��
 public int getFilingStatus() //�Ҧ�
  {
   return filingStatus;
  }

 public int[][] getBrackets()//�|���k��
  {
   return brackets;
  }

 public double[] getRates()//�Q�v
  {
   return rates;
  }

 public double getTaxableIncome()//���J
  {
   return taxableIncome;
  }

 //�p��|
 public double getTax()
  {
   int incomeTo = 0;

   //�ھڼҦ��ϥΤ��P�|���k��
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

   //�p��|
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