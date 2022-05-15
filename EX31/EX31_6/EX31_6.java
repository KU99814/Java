//Converting dollars to other currencies

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.text.NumberFormat;

public class EX31_6 extends JFrame
{
 private JTextField jtfUSDollar = new JTextField(15);//��J����

 //�[���j�ײv�P���
 private JTextField jtfCanadian= new JTextField("1.5");
 private JTextField jtfCanadianConvert= new JTextField();

 //�w��ײv�P���
 private JTextField jtfGermanMarks= new JTextField("1.4");
 private JTextField jtfGermanMarksConvert= new JTextField(10);

 //�^��ײv�P��� 
 private JTextField jtfBritishPounds = new JTextField("1.6");
 private JTextField jtfBritishPoundsConvert = new JTextField();
 
 //�ഫ���s
 private JButton jbtConvert = new JButton("Convert");

 public EX31_6()
  {
   //��J�P�ާ@���O
   JPanel p1 = new JPanel();
   p1.setLayout(new GridLayout(1,3));
   p1.add(new JLabel("US Dollars"));
   p1.add(jtfUSDollar);
   p1.add(jbtConvert);
   
   p1.setBorder(new TitledBorder("Enter Dollar Amount"));

   //��J�ײv�P��ܭ��O
   JPanel p2 = new JPanel();
   p2.setLayout(new GridLayout(4,3));
   p2.add(new JLabel());
   p2.add(new JLabel("Exchange Rate"));
   p2.add(new JLabel("Converted Amount"));
   p2.add(new JLabel("Canadian Dollars"));
   p2.add(jtfCanadian);
   p2.add(jtfCanadianConvert);
   p2.add(new JLabel("German Marks"));
   p2.add(jtfGermanMarks);
   p2.add(jtfGermanMarksConvert);
   p2.add(new JLabel("British Pounds"));
   p2.add(jtfBritishPounds);
   p2.add(jtfBritishPoundsConvert);
   p2.setBorder(new TitledBorder("Display Exchange"));

   //��J����ܦ�m���k��
   jtfUSDollar.setHorizontalAlignment(JTextField.RIGHT);

   jtfCanadian.setHorizontalAlignment(JTextField.RIGHT);
   jtfCanadianConvert.setHorizontalAlignment(JTextField.RIGHT);

   jtfGermanMarks.setHorizontalAlignment(JTextField.RIGHT);
   jtfGermanMarksConvert.setHorizontalAlignment(JTextField.RIGHT);

   jtfBritishPounds.setHorizontalAlignment(JTextField.RIGHT);
   jtfBritishPoundsConvert.setHorizontalAlignment(JTextField.RIGHT);

   //��ܳ]�����i�s��   
   jtfCanadianConvert.setEditable(false);
   jtfGermanMarksConvert.setEditable(false);
   jtfBritishPoundsConvert.setEditable(false);

   add(p1,BorderLayout.NORTH);
   add(p2,BorderLayout.CENTER);

   //���s�ƥ�
   jbtConvert.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     double usDollars = Double.parseDouble(jtfUSDollar.getText());
     
     double canadian = Double.parseDouble(jtfCanadian.getText());
     double german = Double.parseDouble(jtfGermanMarks.getText());
     double british= Double.parseDouble(jtfBritishPounds.getText());
     
     //��ܮ榡
     NumberFormat currencyForm = NumberFormat.getCurrencyInstance(Locale.US);

     double canadianDollars = usDollars*canadian;
     double germanMarks = Double.parseDouble(jtfGermanMarks.getText());
     double britishPounds= Double.parseDouble(jtfBritishPounds.getText());

     jtfCanadianConvert.setText(currencyForm.format(usDollars*canadian));

     currencyForm = NumberFormat.getCurrencyInstance(Locale.GERMANY);
     jtfGermanMarksConvert.setText(currencyForm.format(usDollars*german));
     
     currencyForm = NumberFormat.getCurrencyInstance(Locale.UK);
     jtfBritishPoundsConvert.setText(currencyForm.format(usDollars*british));
    }
   });
  }

 public static void main(String args[])
  {
   //frame
   EX31_6 frame = new EX31_6();

   frame.setTitle("EX31_6");//���D
   frame.setSize(500,200);//�ؤo
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}