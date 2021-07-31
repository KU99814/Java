import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.io.*;

public class EX29_14 extends JFrame
{
 private JProgressBar jpb = new JProgressBar();//�i�ױ�
 private JTextField jtfInput = new JTextField(50);//��J�n�ƻs�ɮ׸��|
 private JTextField jtfOutput = new JTextField(50);//��X�n�ƻs�ɮ׸��|
 private JButton jbtCopy = new JButton("Copy");//�}�l�ƻs���s

 static boolean start = false;//�P�_�ƻs�O�_�}�l �קK���ƽƻs

 //constructor
 public EX29_14()
  {
   //�i�ױ��]�w
   jpb.setStringPainted(true);//ø�X�ʤ���
   jpb.setValue(0);//�_�l�]���s
   jpb.setMaximum(100);//�̤j�ȳ]��100
   
   //��J�ɮת�panel
   JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
   p1.setBorder(BorderFactory.createTitledBorder("From"));//�ؽu
   p1.add(jtfInput);//�[�Jtextfield

   //��X�ɮת�panel
   JPanel p2 = new JPanel();
   p2.add(jtfOutput);
   p2.setBorder(BorderFactory.createTitledBorder("To"));//�ؽu

   //���spanel
   JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
   p3.add(jbtCopy);

   //��Jframe
   setLayout(new GridLayout(4,1,5,5));
   add(jpb);
   add(p1);
   add(p2);
   add(p3);

   //���s�ʧ@
   jbtCopy.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
     {
      //�Y�٨S�}�l �}�l�ƻs
      if(!start)
       {
        //���o�ɮ׸��|
        String input = jtfInput.getText();
        String output = jtfOutput.getText();

        //���A�]���}�l
        start = true;
        CopyTask task = new CopyTask(input,output);//�Ы�thread task

        //���A�ܰʮ� ���i�ױ������ܶi��        
        task.addPropertyChangeListener(new PropertyChangeListener(){
         public void propertyChange(PropertyChangeEvent e){
          if("progress".equals(e.getPropertyName()))
           {
            jpb.setValue((Integer)e.getNewValue());//��ܶi��
           }
         }
        });

        task.execute();//�}�l����
       }
     }
    });
  }

 static class CopyTask extends SwingWorker<Integer,Integer>
  {
   //�ɮ׸��|
   private String input;//��J
   private String output;//��X

   //file stream
   private BufferedInputStream fileInput;//��J
   private BufferedOutputStream fileOutput;//��X

   //constructor
   public CopyTask(String input,String output)
    {
     //���o�ɮ׸��|
     this.input = input;
     this.output = output;
    }

   protected Integer doInBackground() throws Exception
    {
     File iFile = new File(input);
     File oFile = new File(output);
 
     //�Y�ɮפ��s�b ��ܿ��~��T��
     if(!iFile.exists())
      {
       JOptionPane.showMessageDialog(null,"�ɮפ��s�b",
                                  "���~", JOptionPane.ERROR_MESSAGE);
       start = false;
       return 0;
      }

     //�إ�IO stream
     fileInput = new BufferedInputStream(new FileInputStream(iFile));
     fileOutput = new BufferedOutputStream(new FileOutputStream(oFile));
         
     int max = fileInput.available();//�ɮפj�p(byte)
     int count = 0;//�ثe�ƻs�j�p(byte)

     int r;
     
     //�ƻs���
     while((r=fileInput.read())!=-1)
      {
       fileOutput.write((byte)r);//�Ninput�ɮ�Ū�� �g�Joutput�ɮ�
       count++;//�ثebyte��
       setProgress(100*count/max);//��ܦʤ���
      }

     //Ū�������������ɮ�
     fileInput.close();
     fileOutput.close();
     
     return 0;  
    }
   
   //������ʧ@
   protected void done()
    {
     if(start)
      {
       //��ܸ�T�� ��ܧ���
       JOptionPane.showMessageDialog(null,"�ƻs����","�T��",JOptionPane.INFORMATION_MESSAGE);
       start = false;
      }
    } 
   
  }

 public static void main(String args[])
  {
   SwingUtilities.invokeLater(new Runnable(){
    public void run(){
     EX29_14 frame = new EX29_14();//frame����
     frame.setTitle("EX29_14");//���D
     frame.setSize(600,280);//�j�p
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
     frame.setLocationRelativeTo(null);//�۹�ʧ@
     frame.setVisible(true);//���
    }
   });
  }
}