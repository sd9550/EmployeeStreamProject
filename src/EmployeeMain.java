import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class EmployeeMain {

    public static void main(String[] args) {
        Employee[] employees = new Employee[100];

        for (int i = 0; i < employees.length; i++) {
            employees[i] = Employee.getRandomEmployee();
        }

        List<Predicate<Employee>> remoteStatus = List.of(Employee::isRemoteEmployee, e -> !e.isRemoteEmployee());
        for (int i = 0; i < remoteStatus.size(); i++) {
            var testCount = Arrays.stream(employees).filter(remoteStatus.get(i));
            long count = testCount.count();
            System.out.printf("Count total for %s: %s\n", i == 0 ? "TRUE" : "FALSE", count);
        }

        var californiaEmployees = Arrays.stream(employees).filter(e -> e.getStateName().equals("California"));
        californiaEmployees.forEach(System.out::println);

        var lessThan40 = Arrays.stream(employees).filter(e -> e.getCurrentAge() < 40).sorted(Comparator.comparing(Employee::getCurrentAge));
        lessThan40.forEach(e -> System.out.println(e.getEmployeeName() + " - Current Age: " + e.getCurrentAge() + " - Hired Age: " + e.getAgeHired()));
    }
}
