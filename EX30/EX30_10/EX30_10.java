//HTML editor with preview window

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class EX30_10 extends JFrame 
{
 private JButton jbtView = new JButton("View");//預覽按鈕
 
 private JTextArea jtaFile = new JTextArea();//輸入HTML視窗
 private JEditorPane jep = new JEditorPane();//網頁瀏覽器

 private MenuBar mb = new MenuBar(); //上方選單
 private Menu menuFile = new Menu("File");//檔案選單
 private Menu menuEdit = new Menu("Edit");//編輯選單

 private MenuItem mItemNew = new MenuItem("New");//新開檔案
 private MenuItem mItemOpen = new MenuItem("Open");//開起檔案
 private MenuItem mItemSave = new MenuItem("Save");//儲存檔案
 private MenuItem mItemSaveAs = new MenuItem("SaveAs");//另存新檔

 private MenuItem mItemCut = new MenuItem("Cut");//剪下
 private MenuItem mItemCopy = new MenuItem("Copy");//複製
 private MenuItem mItemPaste = new MenuItem("Pause");//貼上

 private JFrame frm;
 private JFileChooser fc =new JFileChooser();//檔案選擇
 private int flag;
 private File f;//目前檔案
 private String copyText = "";//複製文字內容

 public EX30_10()
  {
   //將單元加入選單
   menuFile.add(mItemNew);
   menuFile.add(mItemOpen);
   menuFile.add(mItemSave);
   menuFile.add(mItemSaveAs);

   menuEdit.add(mItemCut);
   menuEdit.add(mItemCopy);
   menuEdit.add(mItemPaste);

   //加入上方選單
   mb.add(menuFile);
   mb.add(menuEdit); 
   setMenuBar(mb);

   //網頁頁面
   JScrollPane spJep = new JScrollPane(jep);
   JScrollPane spJta = new JScrollPane(jtaFile);

   jep.setContentType("text/html");
   
   JPanel browerPanel = new JPanel(new GridLayout(1,2));

   browerPanel.add(spJta);
   browerPanel.add(spJep);
   
   jep.setEditable(false);//設為不可編輯

   JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
   buttonPanel.add(jbtView);

   //加入排版  
   setLayout(new BorderLayout());
   add(browerPanel,BorderLayout.CENTER);
   add(buttonPanel,BorderLayout.SOUTH);

   //新開檔案動作
   mItemNew.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     jtaFile.setText("");
     f = null;
    }
   });

   //開啟檔案動作
   mItemOpen.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     openFile();
    }
   });

   //儲存檔案動作
   mItemSave.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     //若還沒有檔案
     if(f==null)
      {
       //存檔
       saveFile();
       setTitle(f.getName());
      }
     else
      {
       //若有檔案 儲存到檔案中
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

   //另存新檔動作
   mItemSaveAs.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     saveFile();
    }
   });

   //剪下動作
   mItemCut.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     copyText = jtaFile.getText();
     jtaFile.setText("");
    }
   });

   //複製動作
   mItemCopy.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     copyText = jtaFile.getText();
    }
   });

   //貼上動作
   mItemPaste.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     if(!copyText.equals(""))
      {
       jtaFile.setText(copyText);
      }
    }
   });

   //預覽動作
   jbtView.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     showFile();
    }
   });
  }

 //開啟檔案
 public void openFile()
  {
   //設定開啟檔案對話方塊的標題   
   fc.setDialogTitle("Open File");   

   //這裡顯示開啟檔案的對話方塊   
   try{    
    flag=fc.showOpenDialog(frm);    
   }   
   catch(HeadlessException head){    
    System.out.println("Open File Dialog ERROR!");   
   }   
               
   //如果按下確定按鈕,則獲得該檔案。   
   if(flag==JFileChooser.APPROVE_OPTION)   
    {   
     //獲得該檔案   
     f=fc.getSelectedFile();
     setTitle(f.getName());

     String append = "";
     //輸入檔案內容
     try{
      DataInputStream input = new DataInputStream(new FileInputStream(f));

      //讀取檔案
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

 //儲存檔案
 public void saveFile()    
  {   
   String fileName;   

   //設定儲存檔案對話方塊的標題   
   fc.setDialogTitle("Save File");    

   //這裡將顯示儲存檔案的對話方塊   
   try{    
    flag=fc.showSaveDialog(this);   
   }   
   catch(HeadlessException he){   
    System.out.println("Save File Dialog ERROR!");    
   }   

   //如果按下確定按鈕,則獲得該檔案。   
   if(flag==JFileChooser.APPROVE_OPTION)   
    {   
     //獲得你輸入要儲存的檔案   
     f=fc.getSelectedFile();
     try{
      DataOutputStream outFile = new DataOutputStream(new FileOutputStream(f));
       
      outFile.writeUTF(jtaFile.getText());
      outFile.close();
     }
     catch(IOException ex){
      System.out.println("Save File Dialog ERROR!");   
     }
     //獲得檔名   
     fileName=fc.getName(f);   
     setTitle(fileName);   
    }
   else
    {
     System.out.println("not save file");
    }   
  }

 //顯示目前文本的網頁內容
 private void showFile()
  {
   jep.setText(jtaFile.getText());
  }

 public static void main(String args[])
  {
   EX30_10 frame = new EX30_10();//frame
   
   frame.setTitle("EX30_10");//標題
   frame.setSize(700,500);//大小
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setLocationRelativeTo(null);//相對位置
   frame.setVisible(true);//顯示
  }
}