import java.util.List;

public interface crud {
    void createTableOfEmloyees();
    void saveEmployee(Employee employee);
    List <Employee> getAllEmployees();
    void fillDb ();
    void fillDb (Employee [] employees);
    List<Employee> getEmployee (String gender, String letter);
}
