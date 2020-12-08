public class Person implements Comparable
{
 private Name name;//姓名

 //建構子
 public Person()
  {
   name = new Name("Jill",'S',"Barr");
  }

 public Person(Name name)
  {
   this.name = name;
  }

 //取得姓名
 public Name getName()
  {
   return name;
  }

 //設定姓名
 public void setName(Name name)
  {
   this.name = name;
  }

 //取得狀態
 public String toString()
  {
   return "\n" + name.getFullName() + "\n";
  }

 //比較
 public int compareTo(Object o)
  {
   return name.compareTo(((Person)o).name);
  }
}