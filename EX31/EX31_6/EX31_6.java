//Converting dollars to other currencies

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.text.NumberFormat;

public class EX31_6 extends JFrame
{
 private JTextField jtfUSDollar = new JTextField(15);//輸入美元

 //加拿大匯率與顯示
 private JTextField jtfCanadian= new JTextField("1.5");
 private JTextField jtfCanadianConvert= new JTextField();

 //德國匯率與顯示
 private JTextField jtfGermanMarks= new JTextField("1.4");
 private JTextField jtfGermanMarksConvert= new JTextField(10);

 //英國匯率與顯示 
 private JTextField jtfBritishPounds = new JTextField("1.6");
 private JTextField jtfBritishPoundsConvert = new JTextField();
 
 //轉換按鈕
 private JButton jbtConvert = new JButton("Convert");

 public EX31_6()
  {
   //輸入與操作面板
   JPanel p1 = new JPanel();
   p1.setLayout(new GridLayout(1,3));
   p1.add(new JLabel("US Dollars"));
   p1.add(jtfUSDollar);
   p1.add(jbtConvert);
   
   p1.setBorder(new TitledBorder("Enter Dollar Amount"));

   //輸入匯率與顯示面板
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

   //輸入框顯示位置為右邊
   jtfUSDollar.setHorizontalAlignment(JTextField.RIGHT);

   jtfCanadian.setHorizontalAlignment(JTextField.RIGHT);
   jtfCanadianConvert.setHorizontalAlignment(JTextField.RIGHT);

   jtfGermanMarks.setHorizontalAlignment(JTextField.RIGHT);
   jtfGermanMarksConvert.setHorizontalAlignment(JTextField.RIGHT);

   jtfBritishPounds.setHorizontalAlignment(JTextField.RIGHT);
   jtfBritishPoundsConvert.setHorizontalAlignment(JTextField.RIGHT);

   //顯示設為不可編輯   
   jtfCanadianConvert.setEditable(false);
   jtfGermanMarksConvert.setEditable(false);
   jtfBritishPoundsConvert.setEditable(false);

   add(p1,BorderLayout.NORTH);
   add(p2,BorderLayout.CENTER);

   //按鈕事件
   jbtConvert.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     double usDollars = Double.parseDouble(jtfUSDollar.getText());
     
     double canadian = Double.parseDouble(jtfCanadian.getText());
     double german = Double.parseDouble(jtfGermanMarks.getText());
     double british= Double.parseDouble(jtfBritishPounds.getText());
     
     //顯示格式
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

   frame.setTitle("EX31_6");//標題
   frame.setSize(500,200);//尺寸
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}