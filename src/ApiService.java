import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ApiService {
    private final String APIURL100 = "http://api.randomdatatools.ru?count=1&params=LastName,FirstName," +
            "FatherName,DateOfBirth,Gender&unescaped=false&typename=all&count=100";
    private final String APIURLONE = "http://api.randomdatatools.ru?count=1&params=LastName,FirstName," +
            "FatherName,DateOfBirth,Gender&unescaped=false&typename=all";

    public String getPeople() {
        return getJsonFromApi(APIURLONE);
    }

    public String getPeoples() {
        return getJsonFromApi(APIURL100);
    }

    public String getJsonFromApi(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            URLConnection connection = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                json.append(line);
            }
            return json.toString();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
