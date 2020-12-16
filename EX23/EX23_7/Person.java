import java.util.*;

public class Person
{
 private String name; //姓名
 private Date birthdate; //生日
 private Person mother = null; //母親
 private Person father = null; //父親

 //建構子
 public Person()
  {
   name = "null";
   birthdate = new Date();
  }

 public Person(String name,Date birthdate,Person mother,Person father)
  {
   this.name = name;
   this.birthdate = birthdate;
   this.mother = mother;
   this.father = father;
  }

 //設定姓名
 public void setName(String name)
  {
   this.name = name;
  }

 //顯示姓名
 public String toString()
  {
   return name;
  }

 //取得所有祖先    
 public Set<Person> getAllKnownAncestors()
  {
   Set<Person> set = new LinkedHashSet<Person>();

   if(mother != null)
    {
     set.add(mother);
     set.addAll(mother.getAllKnownAncestors());//遞迴取得媽媽祖先
    }

   if(father != null)
    {
     set.add(father);
     set.addAll(father.getAllKnownAncestors());//遞迴取得爸爸祖先
    }

   return set;
  }
}