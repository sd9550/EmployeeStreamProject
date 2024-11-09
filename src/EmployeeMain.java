import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

public class EmployeeMain {

    public static void main(String[] args) {
        Employee[] employees = new Employee[100];
        Employee[] anotherEmployees = new Employee[100];
        Business firstBusiness = new Business("DEALS DEALS DEALS");
        Business secondBusiness = new Business("SLICKDEALS");
        List<Employee> employeeList = new ArrayList<>(100);
        SecretEmployee secretEmployee = new SecretEmployee("Alex Murphy", "Ohio", true, 22, LocalDate.now());

        for (int i = 0; i < employees.length; i++) {
            employees[i] = Employee.getRandomEmployee();
            anotherEmployees[i] = Employee.getRandomEmployee();
            employeeList.add(Employee.getRandomEmployee());
        }

        employeeList.add(secretEmployee);
        firstBusiness.addEmployees(employees);
        secondBusiness.addEmployees(anotherEmployees);
        compareBusinessesState(firstBusiness.getEmployeeMap(), secondBusiness.getEmployeeMap(), "California");
        employeeChecker(employeeList);

        List<Predicate<Employee>> ageChecker = List.of(e -> e.getCurrentAge() < 30, e -> e.getCurrentAge() > 60);
        for (int i = 0; i < ageChecker.size(); i++) {
            var testCount = Arrays.stream(employees).filter(ageChecker.get(i));
            long count = testCount.count();
            System.out.printf("Count total for %s: %s\n", i == 0 ? " < 30" : " > 60", count);
        }

        var californiaEmployees = Arrays.stream(employees).filter(e -> e.getStateName().equals("California"));
        californiaEmployees.forEach(System.out::println);

        var lessThan40 = Arrays.stream(employees).filter(e -> e.getCurrentAge() < 40).sorted(Comparator.comparing(Employee::getCurrentAge));
        lessThan40.forEach(e -> System.out.println(e.getEmployeeName() + " - Current Age: " + e.getCurrentAge() + " - Hired Age: " + e.getAgeHired()));
    }

    public static void compareBusinessesState(Map<Integer, Employee> first, Map<Integer, Employee> second, String state) {
        int total = 0;
        List<Employee> firstList = new ArrayList<>(first.values());
        List<Employee> secondList = new ArrayList<>(second.values());
        List<Employee> mergedList;
        Map<Integer, Employee> mergedMap = new HashMap<>();
        mergedMap.putAll(first);
        mergedMap.putAll(second);
        for (Employee e : mergedMap.values()) {
            if (e.getStateName().equals(state)) {
                total++;
            }
        }
        System.out.printf("Total number of employees in %s: %s\n", state, total);
    }

    public static void employeeChecker(List<? extends Employee> list) {
        for (Employee e: list) {
            System.out.println(e);
        }
    }
}
