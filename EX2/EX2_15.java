//computing future tuition

public class EX2_15
{
 public static void main(String args[])
  {
   double tuition = 5000; //�ǶO
   
   double firstTuition = tuition+tuition*0.045; //�Ĥ@�~

   double secondTuition = firstTuition+firstTuition*0.045; //�ĤG�~

   double thirdTuition = secondTuition+secondTuition*0.045; //�ĤT�~

   double finalTuition = thirdTuition+thirdTuition*0.045; //�ĥ|�~

   //�U���B�J�O�N�p���I����H�᪺�Ƭ٥h
   finalTuition *= 100;//�����H100�N�����ܬ����
   
   finalTuition = (int)finalTuition;//�ରint�N�p���I�˥h

   finalTuition/=100;//���H100�ܦ^��Ӫ���

   System.out.print("the tuition for a university for the next four year are:"+finalTuition); //��X���G
  }
}