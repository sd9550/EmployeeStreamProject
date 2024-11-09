import java.util.HashMap;
import java.util.Map;

public class Business {

    private final String businessName;
    private int totalEmployees;
    private Map<Integer, Employee> employeeMap;

    public Business(String businessName) {
        this.businessName = businessName;
        this.totalEmployees = 0;
        this.employeeMap = new HashMap<>();
    }

    public String getBusinessName() {
        return businessName;
    }

    public int getTotalEmployees() {
        return totalEmployees;
    }

    public Map<Integer, Employee> getEmployeeMap() {
        return Map.copyOf(employeeMap);
    }

    public void addEmployees(Employee... employees) {
        for (Employee e : employees) {
            employeeMap.put(e.getEmployeeId(), e);
        }
        totalEmployees = employeeMap.size();
    }

    @Override
    public String toString() {
        return "Name: %s\nTotal Employees:%s\n".formatted(businessName, totalEmployees);
    }
}
