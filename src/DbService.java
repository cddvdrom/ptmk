import java.sql.Connection;
import java.util.List;

public class DbService implements crud{
    private final Connection connection;
    public DbService (){
        connection = new DataBaseConnector().connect();
    }

    @Override
    public void createTableOfEmloyees() {

    }

    @Override
    public void saveEmployee(Employee employee) {

    }

    @Override
    public List <Employee> getAllEmployees() {
return null;
    }

    @Override
    public void fillDb() {

    }

    @Override
    public void fillDb(Employee[] employees) {

    }

    @Override
    public List<Employee> getEmployee(String pol, String letter) {
        return null;
    }
}
