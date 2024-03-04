import java.util.ArrayList;
import java.util.List;

public class Utils {
    public String trim(String string) {
        String stringPart = string.split(":")[1];
        return stringPart.substring(1, stringPart.length() - 1);
    }

    public Employee getEmployeefromApi() {
        ApiService api = new ApiService();
        String json = api.getPeople();
        json = json.substring(1, json.length() - 1);
        return tranformStringToEmployee(json);
    }

    public List<Employee> getEmployeesFromApi() {
        ApiService api = new ApiService();
        String json = api.getPeoples();
        json = json.substring(2, json.length() - 2);
        String[] peoples = json.split("\\},\\{");
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < peoples.length; i++) {
            list.add(tranformStringToEmployee(peoples[i]));
        }
        return list;
    }

    public Employee tranformStringToEmployee(String json) {
        String[] array = json.split(",");
        String secondName = trim(array[0]);
        String firstName = trim(array[1]);
        String fatherName = trim(array[2]);
        String birth = trim(array[3]);
        String fullName = secondName + " " + firstName + " " + fatherName;
        String[] birthArray = birth.split("\\.");
        StringBuilder sb = new StringBuilder();
        sb.append(birthArray[2] + "-");
        sb.append(birthArray[1] + "-");
        sb.append(birthArray[0]);
        birth = sb.toString();
        String gender = trim(array[4]);
        if (gender.equals("Женщина")) {
            return new Employee(fullName, birth, Gender.FEMALE);
        }
        if (gender.equals("Мужчина")) {
            return new Employee(fullName, birth, Gender.MALE);
        }
        return new Employee(fullName, birth, Gender.UNDEFINED);
    }
}
