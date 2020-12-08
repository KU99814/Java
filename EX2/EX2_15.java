//computing future tuition

public class EX2_15
{
 public static void main(String args[])
  {
   double tuition = 5000; //學費
   
   double firstTuition = tuition+tuition*0.045; //第一年

   double secondTuition = firstTuition+firstTuition*0.045; //第二年

   double thirdTuition = secondTuition+secondTuition*0.045; //第三年

   double finalTuition = thirdTuition+thirdTuition*0.045; //第四年

   //下面步驟是將小數點後兩位以後的數省去
   finalTuition *= 100;//先乘以100將後兩位變為整數
   
   finalTuition = (int)finalTuition;//轉為int將小數點捨去

   finalTuition/=100;//除以100變回原來的數

   System.out.print("the tuition for a university for the next four year are:"+finalTuition); //輸出結果
  }
}