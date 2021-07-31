//����panle

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BallControl extends JPanel
{
 private BallPanel ballPanel = new BallPanel();//ø�X�y��panel

 private JButton jbtSuspend = new JButton("Suspend");//�Ȱ����s
 private JButton jbtResume = new JButton("Resume");//���s�}�l���s
 private JButton jbtStart = new JButton("Start");//���y�}�l�ʧ@���s
 private JButton jbtAdd = new JButton("+1");//�W�[�y���s
 private JButton jbtSubtract = new JButton("-1");//��ֲy���s
 
 private JScrollBar jsbDelay = new JScrollBar(JScrollBar.HORIZONTAL,0,0,0,100);//�վ�t�שԱ�

 //constructor
 public BallControl()
  {
   JPanel panel = new JPanel();//���spanel

   //�N���s�[�J
   panel.add(jbtSuspend);
   panel.add(jbtResume);
   panel.add(jbtStart);
   panel.add(jbtAdd);
   panel.add(jbtSubtract);

   ballPanel.setBorder(new javax.swing.border.LineBorder(Color.red));//�]�w�ؽu
   
   ballPanel.setDelay(jsbDelay.getMinimum());//delay�ɶ�

   //�N�Upanel��X 
   setLayout(new BorderLayout());
   add(jsbDelay,BorderLayout.NORTH);
   add(ballPanel,BorderLayout.CENTER);
   add(panel,BorderLayout.SOUTH);

   //�[�J�Ȱ����s�ƥ�  
   jbtSuspend.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
      ballPanel.suspend();//ball panel�Ȱ�
    }
   });

   //�[�J���s�}�l�ƥ�
   jbtResume.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     ballPanel.resume();//ball panel���s�}�lø��
    }
   });

   //�[�J���s�[�J�y�}�l�B�ʫ��s�ƥ�
   jbtStart.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     ballPanel.start();
    }
   });

   //�[�J�s�[�J�y���s�ƥ�
   jbtAdd.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     ballPanel.addNumber();
    }
   });

   //�[�J��ֲy���s�ƥ�
   jbtSubtract.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     ballPanel.subNumber();
    }
   });

   //�[�J�Ա�����t�רƥ�
   jsbDelay.addAdjustmentListener(new AdjustmentListener(){
    public void adjustmentValueChanged(AdjustmentEvent e){
     ballPanel.setDelay(e.getValue());
    }
   });

   new Thread(ballPanel).start();//������}�l����
  }
}