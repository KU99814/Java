import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EX16_20 extends JFrame
{
 //��a�W��
 private String[] flagTitles = {"Canada","China","Denmark","France","Germany",
                                "India","Norway","United Kingdom","United States of America"};
 //��X�ɦW
 private ImageIcon[] flagImage = {new ImageIcon("image/ca.gif"),
                                  new ImageIcon("image/China.gif"),
                                  new ImageIcon("image/denmark.gif"),
                                  new ImageIcon("image/fr.gif"),
                                  new ImageIcon("image/germany.gif"),
                                  new ImageIcon("image/india.gif"),
                                  new ImageIcon("image/norway.gif"),
                                  new ImageIcon("image/uk.gif"),
                                  new ImageIcon("image/us.gif")};

 //�奻�}�C
 private String[] flagDescription = new String[9];
 private DescriptionPanel descriptionPanel = new DescriptionPanel();//�ŧi��a����panel

 private JComboBox jcbo = new JComboBox(flagTitles);//�U�Կ�� ���X
 
 public EX16_20()
  {
   //�ŧi�y�z�}�C
   for(int i=0;i<9;i++)
    flagDescription[i] = ""; 
   try
    {
     //Ū���y�z�奻
     for(int i=0;i<9;i++)
      {
       Scanner input = new Scanner(new File("text/description"+i+".txt"));
       while(input.hasNext())
        {
         flagDescription[i]+= input.next()+" ";
        }
      }
    }
   catch(Exception ex){}
   
   setDisplay(0);//��ܲ�1�Ӥ奻
   
   //��X
   add(jcbo,BorderLayout.NORTH);
   add(descriptionPanel,BorderLayout.CENTER);

   //�[�J���ʧ@ ��ܰ�a
   jcbo.addItemListener(new ItemListener(){
    public void itemStateChanged(ItemEvent e){
     setDisplay(jcbo.getSelectedIndex());
    }
   });
  }

 public static void main(String args[])
  {
   EX16_20 frame = new EX16_20();//�ŧi����
   frame.setTitle("EX16_20");//���D
   frame.setSize(400,300);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
 
 //�]�w�奻
 public void setDisplay(int index)
  {
   //�]�w�n��ܪ���a
   descriptionPanel.setTitle(flagTitles[index]);
   descriptionPanel.setImageIcon(flagImage[index]);
   descriptionPanel.setDescription(flagDescription[index]);
  }
}