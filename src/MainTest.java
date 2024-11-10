import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainTest {

    public static void main(String[] args) {
        List<Employee> employeeList = Stream.generate(Employee::getRandomEmployee).limit(1000).toList();
        int totalHiredAge = employeeList.stream().map(Employee::getAgeHired).reduce(0, Integer::sum);
        var ageSummary = employeeList.stream().mapToInt(Employee::getCurrentAge).summaryStatistics();
        List<WorkAssignment> allWorkAssignments = new ArrayList<>();
        String lineBreak = "-".repeat(50);

        System.out.printf("Total Employees: %s\nTotal Age of all employees: %s\n", employeeList.size(), totalHiredAge);
        System.out.printf("\nStatistics for current age: %s", ageSummary);

        for (Employee e: employeeList) {
            WorkAssignment[] first = {WorkAssignment.getRandomWorkAssignment(), WorkAssignment.getRandomWorkAssignment()};
            e.addWorkAssignments(first);
        }

        var allHighPriority = employeeList.stream().map(Employee::getHighestPriority).toList();
        var totalPercent = allHighPriority.stream().mapToDouble(WorkAssignment::getPercentComplete).reduce(0, Double::sum);


        allHighPriority.forEach(w -> System.out.println(w.getWorkPriority()));
        System.out.printf("Average of most essential work assignments: %.2f%n", totalPercent / employeeList.size());

        System.out.println(lineBreak);

        for (Employee e: employeeList) {
            List<WorkAssignment> temp = e.getWorkAssignments();
            allWorkAssignments.addAll(temp);
        }

        List<Predicate<WorkAssignment>> workPriorityCount = List.of(w -> w.getWorkPriority() == WorkPriority.NON_ESSENTIAL,
                w -> w.getWorkPriority() == WorkPriority.MODERATE,
                w -> w.getWorkPriority() == WorkPriority.ESSENTIAL);

        long count = 0;
        for (int i = 0; i < workPriorityCount.size(); i++) {
            var listCount = allWorkAssignments.stream().filter(workPriorityCount.get(i));
            count = listCount.count();
            System.out.println("Count for round " + WorkPriority.values()[i] + ": " + count);
        }

        System.out.println(lineBreak);

        var securityLevelMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getSecurityLevel));
        securityLevelMap.forEach((k, v) -> System.out.println(k + ": " + v.size()));

        System.out.println(lineBreak);

        var stateMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getStateName));
        stateMap.forEach((k, v) -> System.out.println(k + ": " + v.size()));
    }
}
