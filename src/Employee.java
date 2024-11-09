import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

enum SecurityLevel {LOW_LEVEL(0), MID_LEVEL(1), HIGH_LEVEL(2);

    SecurityLevel(int i) {
    }
}

public class Employee {
    private static int lastEmployeeID = 120111;
    private final int employeeId;
    private final String employeeName;
    private final String stateName;
    private final boolean remoteEmployee;
    private final int ageHired;
    private final LocalDate dateHired;
    private SecurityLevel securityLevel;

    public Employee(String employeeName, String stateName, boolean remoteEmployee, int ageHired, LocalDate dateHired) {
        this.employeeId = lastEmployeeID++;
        this.employeeName = employeeName;
        this.stateName = stateName;
        this.remoteEmployee = remoteEmployee;
        this.ageHired = ageHired;
        this.dateHired = dateHired;
        this.setSecurityLevel();
    }

    private void setSecurityLevel() {
        long yearsEmployed = Period.between(dateHired, LocalDate.now()).toTotalMonths() / 12;
        if (yearsEmployed <= 1) {
            securityLevel = SecurityLevel.LOW_LEVEL;
        } else if (yearsEmployed <= 2) {
            securityLevel = SecurityLevel.MID_LEVEL;
        } else {
            securityLevel = SecurityLevel.HIGH_LEVEL;
        }
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getStateName() {
        return stateName;
    }

    public boolean isRemoteEmployee() {
        return remoteEmployee;
    }

    public int getAgeHired() {
        return ageHired;
    }

    public int getCurrentAge() {
        long timeElapsed = Period.between(dateHired, LocalDate.now()).toTotalMonths() / 12;
        return (int) (ageHired + timeElapsed);
    }

    @Override
    public String toString() {
        return "Name: %25s - ID: %5s - State: %s - Remote: %s".formatted(employeeName, employeeId, stateName, remoteEmployee);
    }

    public static Employee getRandomEmployee() {
        Random random = new Random();
        String randomState = NewEmployeeData.STATES[random.nextInt(0, NewEmployeeData.STATES.length)];
        int randomAge = random.nextInt(20, 70);
        LocalDate randomDate = LocalDate.of(random.nextInt(2008, 2024), random.nextInt(1, 13),
                random.nextInt(1, 28));
        return new Employee(NewEmployeeData.getRandomName(), randomState, random.nextBoolean()
        ,randomAge, randomDate);
    }
}
