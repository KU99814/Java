//The Course class

public class EX9_9
{
 public static void main(String args[])
  {
   Course course = new Course("Math"); //宣告一個Course

   //新增學生
   course.addStudent("Sam");
   course.addStudent("John");
   course.addStudent("Honk");

   //移除一個學生
   course.dropStudent("Honk");
   
   String[] students = course.getStudents();
   for(int i=0;i<course.getNumberOfStudents();i++) //顯示
    System.out.println(students[i]);
  }
}

//課程class
class Course
{
 private String courseName; //課程姓名
 private String[] students = new String[16]; //學生
 private int numberOfStudents = 0; //學生人數

 //建構子
 public Course(String courseName)
  {
   this.courseName = courseName;
  }

 public void addStudent(String student) //新增學生
  {
   if(numberOfStudents ==students.length)//若陣列太小 加大長度
    {
     String[] newStudent = new String[numberOfStudents*2+1]; //創新陣列
     for(int i=0;i<numberOfStudents;i++) //將學生移入新陣列
      newStudent[i] = students[i];
     students = newStudent;//指向新陣列
    }

   students[numberOfStudents] = student; //將新學生加入陣列
   numberOfStudents++;//增加學生數
  }

 public String[] getStudents() //回傳學生陣列
  {
   return students;
  }

 public int getNumberOfStudents() //回傳學生數
  {
   return numberOfStudents;
  }

 public String getCourseName() //回傳課程名稱
  {
   return courseName;
  }

 public void dropStudent(String student) //移除學生
  {
   //創一個減少的新陣列
   numberOfStudents--;
   String[] newStudent = new String[numberOfStudents];
   //將要移除以外的加入新陣列
   int j = 0;
   for(int i=0;i<numberOfStudents+1;i++) 
    {
     if(!students[i].equals(student))
      {
       newStudent[j] = students[i];
       j++;
      }
    }

   students = newStudent;//指向新陣列
  }
 
 public void clear() //清空
  {
   students = new String[16];
  }
}