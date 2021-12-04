//HTML editor with preview window

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class EX30_10 extends JFrame 
{
 private JButton jbtView = new JButton("View");//�w�����s
 
 private JTextArea jtaFile = new JTextArea();//��JHTML����
 private JEditorPane jep = new JEditorPane();//�����s����

 private MenuBar mb = new MenuBar(); //�W����
 private Menu menuFile = new Menu("File");//�ɮ׿��
 private Menu menuEdit = new Menu("Edit");//�s����

 private MenuItem mItemNew = new MenuItem("New");//�s�}�ɮ�
 private MenuItem mItemOpen = new MenuItem("Open");//�}�_�ɮ�
 private MenuItem mItemSave = new MenuItem("Save");//�x�s�ɮ�
 private MenuItem mItemSaveAs = new MenuItem("SaveAs");//�t�s�s��

 private MenuItem mItemCut = new MenuItem("Cut");//�ŤU
 private MenuItem mItemCopy = new MenuItem("Copy");//�ƻs
 private MenuItem mItemPaste = new MenuItem("Pause");//�K�W

 private JFrame frm;
 private JFileChooser fc =new JFileChooser();//�ɮ׿��
 private int flag;
 private File f;//�ثe�ɮ�
 private String copyText = "";//�ƻs��r���e

 public EX30_10()
  {
   //�N�椸�[�J���
   menuFile.add(mItemNew);
   menuFile.add(mItemOpen);
   menuFile.add(mItemSave);
   menuFile.add(mItemSaveAs);

   menuEdit.add(mItemCut);
   menuEdit.add(mItemCopy);
   menuEdit.add(mItemPaste);

   //�[�J�W����
   mb.add(menuFile);
   mb.add(menuEdit); 
   setMenuBar(mb);

   //��������
   JScrollPane spJep = new JScrollPane(jep);
   JScrollPane spJta = new JScrollPane(jtaFile);

   jep.setContentType("text/html");
   
   JPanel browerPanel = new JPanel(new GridLayout(1,2));

   browerPanel.add(spJta);
   browerPanel.add(spJep);
   
   jep.setEditable(false);//�]�����i�s��

   JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
   buttonPanel.add(jbtView);

   //�[�J�ƪ�  
   setLayout(new BorderLayout());
   add(browerPanel,BorderLayout.CENTER);
   add(buttonPanel,BorderLayout.SOUTH);

   //�s�}�ɮװʧ@
   mItemNew.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     jtaFile.setText("");
     f = null;
    }
   });

   //�}���ɮװʧ@
   mItemOpen.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     openFile();
    }
   });

   //�x�s�ɮװʧ@
   mItemSave.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     //�Y�٨S���ɮ�
     if(f==null)
      {
       //�s��
       saveFile();
       setTitle(f.getName());
      }
     else
      {
       //�Y���ɮ� �x�s���ɮפ�
       try{
        DataOutputStream outFile = new DataOutputStream(new FileOutputStream(f));
       
        outFile.writeUTF(jtaFile.getText());
        outFile.close();
       }
       catch(IOException ex){
        System.out.println("Save File Dialog ERROR!");   
       }
      }
    }
   });

   //�t�s�s�ɰʧ@
   mItemSaveAs.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     saveFile();
    }
   });

   //�ŤU�ʧ@
   mItemCut.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     copyText = jtaFile.getText();
     jtaFile.setText("");
    }
   });

   //�ƻs�ʧ@
   mItemCopy.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     copyText = jtaFile.getText();
    }
   });

   //�K�W�ʧ@
   mItemPaste.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     if(!copyText.equals(""))
      {
       jtaFile.setText(copyText);
      }
    }
   });

   //�w���ʧ@
   jbtView.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     showFile();
    }
   });
  }

 //�}���ɮ�
 public void openFile()
  {
   //�]�w�}���ɮ׹�ܤ�������D   
   fc.setDialogTitle("Open File");   

   //�o����ܶ}���ɮת���ܤ��   
   try{    
    flag=fc.showOpenDialog(frm);    
   }   
   catch(HeadlessException head){    
    System.out.println("Open File Dialog ERROR!");   
   }   
               
   //�p�G���U�T�w���s,�h��o���ɮסC   
   if(flag==JFileChooser.APPROVE_OPTION)   
    {   
     //��o���ɮ�   
     f=fc.getSelectedFile();
     setTitle(f.getName());

     String append = "";
     //��J�ɮפ��e
     try{
      DataInputStream input = new DataInputStream(new FileInputStream(f));

      //Ū���ɮ�
      while(true)
       {
        append += input.readUTF()+"\n";
       }
     }
     catch(IOException ex){
      jtaFile.setText(append);
     }
    }
   else 
    {
     System.out.println("not open file");   
    }   
  }

 //�x�s�ɮ�
 public void saveFile()    
  {   
   String fileName;   

   //�]�w�x�s�ɮ׹�ܤ�������D   
   fc.setDialogTitle("Save File");    

   //�o�̱N����x�s�ɮת���ܤ��   
   try{    
    flag=fc.showSaveDialog(this);   
   }   
   catch(HeadlessException he){   
    System.out.println("Save File Dialog ERROR!");    
   }   

   //�p�G���U�T�w���s,�h��o���ɮסC   
   if(flag==JFileChooser.APPROVE_OPTION)   
    {   
     //��o�A��J�n�x�s���ɮ�   
     f=fc.getSelectedFile();
     try{
      DataOutputStream outFile = new DataOutputStream(new FileOutputStream(f));
       
      outFile.writeUTF(jtaFile.getText());
      outFile.close();
     }
     catch(IOException ex){
      System.out.println("Save File Dialog ERROR!");   
     }
     //��o�ɦW   
     fileName=fc.getName(f);   
     setTitle(fileName);   
    }
   else
    {
     System.out.println("not save file");
    }   
  }

 //��ܥثe�奻���������e
 private void showFile()
  {
   jep.setText(jtaFile.getText());
  }

 public static void main(String args[])
  {
   EX30_10 frame = new EX30_10();//frame
   
   frame.setTitle("EX30_10");//���D
   frame.setSize(700,500);//�j�p
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setVisible(true);//���
  }
}