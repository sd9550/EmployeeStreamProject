import java.time.LocalDate;

public class SecretEmployee extends Employee {

    private final boolean isSecretEmployee;

    public SecretEmployee(String employeeName, String stateName, boolean remoteEmployee, int ageHired, LocalDate dateHired) {
        super(employeeName, stateName, remoteEmployee, ageHired, dateHired);
        this.isSecretEmployee = true;
    }

    @Override
    public String toString() {
        if (isSecretEmployee) {
            System.out.println("---------------------Secret Employee toString-------------------------");
        }
        return super.toString();
    }


}
