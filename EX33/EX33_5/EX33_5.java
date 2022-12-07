//Using null layout

import java.awt.*;
import javax.swing.*;

public class EX33_5 extends JFrame
{
 //擺放的元件
 private JLabel jlLastName = new JLabel("Last Name");
 private JLabel jlFirstName = new JLabel("First Name");
 private JLabel jlStreet = new JLabel("Street");
 private JLabel jlCity = new JLabel("City");
 private JLabel jlState = new JLabel("State");
 private JLabel jlZip = new JLabel("Zip");
 private JLabel jlPhone = new JLabel("Phone");
 private JLabel jlEmail = new JLabel("Email");

 private JTextField jtfLastName = new JTextField();
 private JTextField jtfFirstName = new JTextField();
 private JTextField jtfStreet = new JTextField();
 private JTextField jtfCity = new JTextField();
 private JComboBox jcbState = new JComboBox(new String[]{"All"});
 private JTextField jtfZip = new JTextField();
 private JTextField jtfPhone = new JTextField();
 private JTextField jtfEmail = new JTextField(); 

 private JButton jbtOk = new JButton("Ok");
 private JButton jbtCancel = new JButton("Cancel");

 public EX33_5()
  {
   setLayout(null);//設為null layout

   //以下按照指定座標擺放元件

   //Last Name
   add(jlLastName);
   jlLastName.setBounds(50,50,100,50);
   add(jtfLastName);
   jtfLastName.setBounds(150,60,250,30);

   //First Name
   add(jlFirstName);
   jlFirstName.setBounds(50,100,100,50);
   add(jtfFirstName);
   jtfFirstName.setBounds(150,110,270,30);

   //Street
   add(jlStreet);
   jlStreet.setBounds(50,150,100,50);
   add(jtfStreet);
   jtfStreet.setBounds(150,160,400,30);

   //City
   add(jlCity);
   jlCity.setBounds(50,200,100,50);
   add(jtfCity);
   jtfCity.setBounds(150,210,400,30);

   //State
   add(jlState);
   jlState.setBounds(50,250,100,50);
   add(jcbState);
   jcbState.setBounds(150,260,50,30);

   //Zip
   add(jlZip);
   jlZip.setBounds(50,300,100,50);
   add(jtfZip);
   jtfZip.setBounds(150,310,250,30);

   //Phone
   add(jlPhone);
   jlPhone.setBounds(50,350,100,50);
   add(jtfPhone);
   jtfPhone.setBounds(150,360,250,30);

   //Email
   add(jlEmail);
   jlEmail.setBounds(50,400,100,50);
   add(jtfEmail);
   jtfEmail.setBounds(150,410,400,30);

   add(jbtOk);
   jbtOk.setBounds(250,450,80,30);
   add(jbtCancel);
   jbtCancel.setBounds(350,450,80,30);
  }

 public static void main(String args[])
  {
   EX33_5 frame = new EX33_5();
   
   frame.setTitle("EX33_5");//標題
   frame.setSize(600,568);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}