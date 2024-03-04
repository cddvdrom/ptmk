import java.util.Date;

public class Main {
    public static void main(String[] args) {
        DbService service = new DbService();
        try {
            int mode = Integer.parseInt(args[0]);
            switch (mode) {
                case 1:
                    service.createTableOfEmloyees();
                    break;
                case 2:
                    Employee employee = new Employee();
                    if (args[3] == null || (args[3] == Gender.MALE.getTitle() || args[3] == Gender.FEMALE.getTitle())) {
                        employee.setGender(Gender.UNDEFINED);
                    }
                    employee.setName(args[1]);
                    employee.setBirthDay(args[2]);
                    service.saveEmployee(employee);
                    break;
                case 3:
                    service.printAllEmployees();
                    break;
                case 4:
                    service.fillDb();
                    break;
                case 5:
                    service.printFemployee();
                    break;
                case 6:
                    service.createIndexEmployee();
                    break;
                default:
                    System.out.println("Неверные данные в строке запуска приложения");
                    break;

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Запуск приложения только из командной строки");
        }
    }
}