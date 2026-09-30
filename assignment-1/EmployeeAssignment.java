import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    private final int id;
    private final String name;
    private final double salary;
    private final String department;

    Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name + " (ID: " + id + ", " + department + ", Salary: "
                + String.format("%.2f", salary) + ")";
    }
}

public class EmployeeAssignment {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(101, "Aditi", 50000, "IT"),
                new Employee(102, "Rahul", 62000, "HR"),
                new Employee(103, "Neha", 75000, "IT"),
                new Employee(104, "Vikram", 48000, "Finance"),
                new Employee(105, "Priya", 68000, "IT")
        );

        Employee lowestPaid = employees.stream()
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new IllegalStateException("No employees found"));

        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);

        double totalSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();

        List<Employee> ascending = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.toList());

        List<Employee> descending = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());

        double secondHighestSalary = employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(0.0);

        Employee highestPaidInIt = employees.stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase("IT"))
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new IllegalStateException("No IT employees found"));

        System.out.println("Employee Salary Report");
        System.out.println("1. Lowest paid: " + lowestPaid);
        System.out.printf("2. Average salary: %.2f%n", averageSalary);
        System.out.printf("3. Total salary: %.2f%n", totalSalary);
        System.out.println("4. Salary ascending: " + ascending);
        System.out.println("5. Salary descending: " + descending);
        System.out.printf("6. Second-highest salary: %.2f%n", secondHighestSalary);
        System.out.println("7. Highest paid in IT: " + highestPaidInIt);
    }
}
