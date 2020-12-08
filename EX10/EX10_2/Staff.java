public class Staff extends Employee
{
 private String title;//組名

 //建構子
 public Staff()
  {
   title = "none";
  }

 public Staff(String name,String address,String phone,String eAddress,
                String office,int salary,MyDate date_hired,String title)
  {
   super(name,address,phone,eAddress,office,salary,date_hired);
   this.title = title;
  }

 //override
 public String toString()
  {
   return "staff " + getName();
  }
}
