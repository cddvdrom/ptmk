import java.util.Date;

public class Employee {
    private String name;
    private Date birthDay;
    private String gender;
public Employee(String name,Date birthDay,String gender){
    this.name=name;
    this.birthDay=birthDay;
    this.gender=gender;
}
    public void sendToDb (){
    }
    public int calculateAge (){
        return 1;
    }
}
