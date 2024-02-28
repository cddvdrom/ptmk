public interface crud {
    void createTableOfEmloyees();
    void saveEmployee(Employee employee);
    void getAllEmployees();
    void fillDb ();
    void fillDb (Employee [] employees);
    void getEmployee (String gender,String letter);
}
