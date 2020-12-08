public class Student extends Person implements Comparable
{
 private String major; //主科系

 //建構子
 public Student()
  {
   super();
   major = "non";
  }

 public Student(Name name,String major)
  {
   super(name);
   this.major = major;
  }

 //取得主科系
 public String getMajor()
  {
   return major;
  }

 //比較
 public int compareTo(Object o)
  {
   return (super.compareTo(o)) + major.compareTo(((Student)o).getMajor());
  }

 //取得狀態
 public String toString()
  {
   return super.toString() + major;
  }
}