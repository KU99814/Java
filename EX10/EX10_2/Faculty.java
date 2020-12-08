public class Faculty extends Employee
{
 private int officeHour; //工時
 private String rank; //階級

 //建構子
 public Faculty()
  {
   officeHour = 1;
   rank = "E";
  }

 public Faculty(String name,String address,String phone,String eAddress,
                String office,int salary,MyDate date_hired,
                int officeHour,String rank)
  {
   super(name,address,phone,eAddress,office,salary,date_hired);
   this.officeHour = officeHour;
   this.rank = rank;
  }
 //override 
 public String toString()
  {
   return "Faculty " + getName();
  }
}
