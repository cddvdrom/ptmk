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
                    service.saveEmployee(new Employee(args[1], new Date(args[2]), args[3]));
                    break;
                case 3:
                    service.getAllEmployees();
                    break;
                case 4:
                    service.fillDb();
                    break;
                case 5:
                    service.getEmployee(args[1], args[2]);
                    break;
                default:
                    System.out.println("Неверные данные в строке запуска приложения");
                    break;

            }
        } catch (Exception e) {
            System.out.println("Запуск приложения только из командной строки");
        }
    }
}