import java.sql.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class DbService implements crud {
    private Utils utils;
    private final Connection connection;

    public DbService() {
        this.connection = new DataBaseConnector().connect();
        this.utils = new Utils();
    }

    @Override
    public void createTableOfEmloyees() {
        String sql = "CREATE TABLE IF NOT EXISTS employees" +
                " (id SERIAL PRIMARY KEY,name VARCHAR(50),birth_date DATE,gender VARCHAR(10),age INT);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveEmployee(Employee employee) {
        String sql = "INSERT INTO Employees (name, birth_date,gender,age) VALUES (?, ?, ?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setDate(2, Date.valueOf(employee.getBirthDay()));
            preparedStatement.setString(3, employee.getGender());
            preparedStatement.setInt(4, employee.getAge());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void printAllEmployees() {
        String sql = "SELECT DISTINCT ON (name) * FROM employees ORDER BY name";
        printSqlAnswer(sql);
    }

    @Override
    public void save100Employee(List<Employee> employees) {
        StringBuilder sql = new StringBuilder("");
        StringBuilder sb = new StringBuilder("INSERT INTO Employees (name, birth_date,gender,age) VALUES ");
        for (int i = 0; i < employees.size(); i++) {
            StringBuilder row = new StringBuilder();
            row.append("(");
            row.append("'" + employees.get(i).getName() + "'" + ",");
            row.append("'" + employees.get(i).getBirthDay() + "'" + ",");
            row.append("'" + employees.get(i).getGender() + "'" + ",");
            row.append(employees.get(i).getAge());
            row.append("),");
            sb.append(row);
        }
        sql.append(sb);
        sql.setLength(sql.length() - 1);
        sql.append(";");
        System.out.println(sql);
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void fillDb(List<Employee> employees) {
        employees.stream().forEach((x) -> saveEmployee(x));
    }

    @Override
    public void printFemployee() {
        String sql = "SELECT * FROM Employees WHERE gender = 'Male' AND name LIKE 'Ф%'";
        long startTime = System.currentTimeMillis();
        printSqlAnswer(sql);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Продолжительность " + duration);
    }

    public void fillDb() {
        for (int i = 0; i < 10000; i++) {
            save100Employee(utils.getEmployeesFromApi());
        }
    }

    public void printSqlAnswer(String sql) {
        String header = "|%-20s |%-20s |%-20s | %-20s | %-20s |%n";
        String row = "|%-20s |%-20s |%-20s | %-20s | %-20s |%n";
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        System.out.printf(header, "id", "name", "birth_date", "gender", "age");
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String birthDay = rs.getString("birth_date");
                String gender = rs.getString("gender");
                String age = rs.getString("age");
                System.out.printf(row, id, name, birthDay, gender, age);
            }
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createIndexEmployee() {
        String index = "CREATE INDEX idx_gender_name ON Employees (gender, name)";
        printFemployee();
    }
}
