import java.util.List;

public interface crud {
    void createTableOfEmloyees();

    void saveEmployee(Employee employee);

    void printAllEmployees();

    void fillDb();

    void fillDb(List<Employee> employees);

    void printFemployee();

    void save100Employee(List<Employee> employees);
}
