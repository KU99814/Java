//Guessing month

import javax.swing.JOptionPane;

public class EX3_17
{
 public static void main(String args[])
  {
   int num = 0;//�̲׿�X���G
   
   //���ͰT������ܰ��D�çP�_�O�D
   int ch1 = JOptionPane.showConfirmDialog(null,"Is your birth month in set1?"+" \n1  3  5  7"+"\n9  11");
   int ch2 = JOptionPane.showConfirmDialog(null,"Is your birth month in set2?"+" \n2  3  6  7"+"\n10  11");
   int ch3 = JOptionPane.showConfirmDialog(null,"Is your birth month in set3?"+" \n4  5  6  7"+"\n12");
   int ch4 = JOptionPane.showConfirmDialog(null,"Is your birth month in set4?"+" \n8  9  10  11"+"\n12");

   //�H��J���קP�_���G
   
   if(ch1 == JOptionPane.YES_OPTION)
    num += 1;

   if(ch2 == JOptionPane.YES_OPTION)
    num += 2;

   if(ch3 == JOptionPane.YES_OPTION)
    num += 4;
   
   if(ch4 == JOptionPane.YES_OPTION)
    num += 8;
  
   //�H�T�����X���G
   JOptionPane.showMessageDialog(null,"Your birth month is "+num+"!");
  }
}
