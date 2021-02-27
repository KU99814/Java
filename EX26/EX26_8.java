//Execution time for external sort

import java.io.*;

public class EX26_8
{
 public static final int MAX_ARRAY_SIZE = 100000;//��X�ɮ׳̤j�ؤo�}�C
 public static final int BUFFER_SIZE = 100000;//IO stream buffer size

 public static void main(String args[]) throws Exception
  {
   //�I�s���ե�method
   testSort(5000000);
   testSort(10000000);
   testSort(15000000);
   testSort(20000000);
   testSort(25000000);
   testSort(30000000);
   
  }

 //��ܱƧǮɶ�
 public static void testSort(int number) throws Exception
  {
   long startTime = System.currentTimeMillis();//�}�l�ɶ�
   externalSort(number);//external sort
   long endTime = System.currentTimeMillis();//�����ɶ�
   long exTime = endTime - startTime;//����ɶ�

   System.out.println("Size: "+number+" Time: "+exTime);

   //�ƧǹL�{���ͪ��ɮ�
   File largedataFile = new File("largedata.dat");//��l���
   File f1File = new File("f1.dat");//�L�{�ɮ�1
   File sortedFile = new File("sortedlargedata.dat");//�Ƨǵ��G
   File f3File = new File("f3.dat");//�L�{�ɮ�2
   File f2File = new File("f2.dat");//�L�{�ɮ�3

   //�N�����ɮקR��
   largedataFile.delete();
   f1File.delete();
   sortedFile.delete();
   f3File.delete();
   f2File.delete();
  }

 //external sort
 public static void externalSort(int number) throws Exception
  {
   DataOutputStream output = new DataOutputStream(new BufferedOutputStream(
                              new FileOutputStream("largedata.dat")));//��X�ɮ� ��l���
   //��X�H�����ͼƦr
   for(int i=0;i<number;i++)
    output.writeInt((int)(Math.random()*number));

   output.close();//�ɮ�����

   //�i��Ĥ@���q�Ƨ� �o���Ƥ��q��
   int numberOfSegments = initializeSegments(MAX_ARRAY_SIZE,"largedata.dat","f1.dat");

   //�i��ĤG���q
   merge(numberOfSegments,MAX_ARRAY_SIZE,"f1.dat","f2.dat","f3.dat");
  }

 //�Ĥ@���q�Ƨ�
 private static int initializeSegments
    (int segmentSize,String originalFile,String f1) throws Exception
  {
   int[] list = new int[segmentSize];//�@���i��ƧǪ��}�C

   DataInputStream input = new DataInputStream(new BufferedInputStream(
                              new FileInputStream(originalFile)));//��J����l�ɮ�
   DataOutputStream output = new DataOutputStream(new BufferedOutputStream(
                              new FileOutputStream(f1)));//��X���Ƨ��ɮ�

   int numberOfSegments = 0;//���q��

   //�j����ƿ�J��
   while(input.available()>0)
    {
     numberOfSegments++;//���q��+1
     int i = 0;
     //��J��̤j�ؤo�θ�ƨ���
     for(;input.available()>0 && i < segmentSize;i++)
      list[i] = input.readInt();

     java.util.Arrays.sort(list,0,i);//�Ƨ�

     //��X�ɮ�
     for(int j=0;j<i;j++)
      output.writeInt(list[j]);
    }
   
   input.close();//������J
   
   output.close();//������X

   return numberOfSegments;//�^��
  }

 //�ĤG���q�Ƨ�
 private static void merge(int numberOfSegments,int segmentSize,String f1,String f2,String f3) 
                           throws Exception
  {
   //�Y���h��@�Ӥ��q merge sort
   if(numberOfSegments > 1)
    {
     mergeOneStep(numberOfSegments,segmentSize,f1,f2,f3);//��X�ñƧǸ��
     merge((numberOfSegments+1)/2,segmentSize*2,f3,f1,f2);//���j
    }
   else//�u���@�Ӥ��q ��������
    {
     File sortedFile = new File("sortedlargedata.dat");
     if(sortedFile.exists())
      sortedFile.delete();
     new File(f1).renameTo(sortedFile);
    }
  }

 //��X�ÿ�X�ɮ�
 private static void mergeOneStep(int numberOfSegments,int segmentSize,String f1,String f2,String f3) 
                           throws Exception
  {
   DataInputStream f1Input = new DataInputStream(new BufferedInputStream(
                              new FileInputStream(f1),BUFFER_SIZE));
   DataOutputStream f2Output = new DataOutputStream(new BufferedOutputStream(
                              new FileOutputStream(f2),BUFFER_SIZE));

   copyHalfToF2(numberOfSegments,segmentSize,f1Input,f2Output);//f1�ƻs
   f2Output.close();//������J�ɮ�
   
   DataInputStream f2Input = new DataInputStream(new BufferedInputStream(
                              new FileInputStream(f2),BUFFER_SIZE));//��X�ɮ�
   DataOutputStream f3Output = new DataOutputStream(new BufferedOutputStream(
                              new FileOutputStream(f3),BUFFER_SIZE));//��J�ɮ�
   mergeSegments(numberOfSegments/2,segmentSize,f1Input,f2Input,f3Output);//�Nf1�U�b���ɮ׻Pf2��X��Jf3
   
   //�����ɮ�Ū��
   f1Input.close();
   f2Input.close();
   f3Output.close();
  }

 //�ƻs�@�b�����q
 private static void copyHalfToF2(int numberOfSegments,int segmentSize,
                               DataInputStream f1,DataOutputStream f2) throws Exception
  {
   //�N�@�b���q�ƶq���ɮ׿�X
   for(int i=0;i<(numberOfSegments/2)*segmentSize;i++)
    f2.writeInt(f1.readInt());
  }

 //�X�֤��q
 private static void mergeSegments(int numberOfSegments,int segmentSize,
                           DataInputStream f1,DataInputStream f2,DataOutputStream f3) throws Exception
  {
   
   for(int i=0;i<numberOfSegments;i++)
    mergeTwoSegments(segmentSize,f1,f2,f3);//�N���q���X��
   while(f1.available()>0)
    f3.writeInt(f1.readInt());//��X���
  }

 //�X�֨���q
 private static void mergeTwoSegments(int segmentSize,DataInputStream f1,
                             DataInputStream f2,DataOutputStream f3) throws Exception
  {
   int intFromF1 = f1.readInt();//f1���X�����
   int intFromF2 = f2.readInt();//f2���X�����
   int f1Count = 1;//f1���X��ƭӼ�
   int f2Count = 1;//f2���X��ƭӼ�

   //����j�p �N���p����ƥ���X�ɮ�
   //�Y�䤤�@�����J���� ���X�j��
   while(true)
    {
     if(intFromF1 < intFromF2)
      {
       f3.writeInt(intFromF1);//��J�ɮ�
       if(f1.available()==0 || f1Count++>=segmentSize)
        {
         //�����e�N�t�@�ӿ�J�ɮ�
         f3.writeInt(intFromF2);
         break;
        }
       else
        intFromF1 = f1.readInt();//�S���� �~��U�@�����
      }
     else
      {
       f3.writeInt(intFromF2);//��J�ɮ�
       if(f2.available()==0 || f2Count++>=segmentSize)
        {
         //�����e�N�t�@�ӿ�J�ɮ�
         f3.writeInt(intFromF1);
         break;
        }
       else
        intFromF2 = f2.readInt();//�S���� �~��U�@�����
      }
    }
    
   //�N�ѤU�S����J����Ʃ�J�ɮ�
   while(f1.available()>0 && f1Count++ < segmentSize)
    f3.writeInt(f1.readInt());
   
   while(f2.available()>0 && f2Count++ < segmentSize)
    f3.writeInt(f2.readInt());
  }
}