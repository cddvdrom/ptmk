import java.sql.Connection;

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
    public void getAllEmployees() {

    }

    @Override
    public void fillDb() {

    }

    @Override
    public void fillDb(Employee[] employees) {

    }

    @Override
    public void getEmployee(String pol, String letter) {

    }
}
