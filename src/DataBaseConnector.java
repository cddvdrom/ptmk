import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnector {
    public Connection connect () {
    Connection connection = null;
    try {
            Properties properties = new Properties();
            InputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\db.properties");
            properties.load(inputStream);
            inputStream.close();
            String url = properties.getProperty("url");
            String login = properties.getProperty("login");
            String password = properties.getProperty("password");
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,login,password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch ( FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Ошибка SQL !");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
        return connection;
    }
}
