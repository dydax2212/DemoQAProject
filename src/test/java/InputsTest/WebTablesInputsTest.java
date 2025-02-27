package InputsTest;

public class WebTablesInputsTest {
    private String firstName;
    private String lastName;
    private String email;
    private String age;
    private String salary;
    private String departament;

    public WebTablesInputsTest(String firstName, String lastName, String email, String age, String salary, String departament) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.departament = departament;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }

    public String getSalary() {
        return salary;
    }

    public String getDepartament() {
        return departament;
    }

   }
