import java.time.LocalDate;
import java.time.Period;

public class Employee {
    private String name;
    private LocalDate birthDay;
    private Gender gender;

    public Employee() {
    }

    public Employee(String name, String birthDay, Gender gender) {
        this.name = name;
        this.birthDay = LocalDate.parse(birthDay);
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = LocalDate.parse(birthDay);
    }

    public String getGender() {
        return gender.getTitle();
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void sendToDb() {
    }

    public int calculateAge() {
        return 1;
    }

    public int getAge() {
        if ((birthDay != null)) {
            return Period.between(birthDay, LocalDate.now()).getYears();
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", gender=" + gender +
                '}';
    }
}