import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Employee {

  private String empId;
  private String name;
  private int age;
  private int salary;

  public Employee(String empId, String name, int age, int salary) {
    this.empId = empId;
    this.name = name;
    this.age = age;
    this.salary = salary;
  }

  public String getEmpId() {
    return empId;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public int getSalary() {
    return salary;
  }

  @Override
  public String toString() {
    return empId + "\t|\t" + name + "\t|\t" + age + "\t|\t" + salary;
  }
}

class EmployeeTable {

  private List<Employee> employees;

  public EmployeeTable(List<Employee> employees) {
    this.employees = employees;
  }

  public void displayTable() {
    for (Employee employee : employees) {
      System.out.println(employee);
    }
  }

  public void sortTable(int key) {
    switch (key) {
      case 1:
        Collections.sort(employees, Comparator.comparingInt(Employee::getAge));
        break;
      case 2:
        Collections.sort(employees, Comparator.comparing(Employee::getName));
        break;
      case 3:
        Collections.sort(
          employees,
          Comparator.comparingInt(Employee::getSalary)
        );
        break;
      default:
        System.out.println("Invalid sorting parameter");
    }
  }

  public void getUserInput() {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.print(
        "Enter sorting parameter (1. Age, 2. Name, 3. Salary): "
      );
      int sortingOption = scanner.nextInt();
      sortTable(sortingOption);
      displayTable();
    } catch (Exception e) {
      System.out.println("Invalid input. Please enter a number.");
    }
  }
}

public class Sorting {

  public static void main(String[] args) {
    // Create Employee objects
    Employee employee1 = new Employee("161E90", "Ramu", 35, 59000);
    Employee employee2 = new Employee("171E22", "Tejas", 30, 82100);
    Employee employee3 = new Employee("171G55", "Abhi", 25, 100000);
    Employee employee4 = new Employee("152K46", "Jaya", 32, 85000);

    // Create EmployeeTable object
    List<Employee> employeeList = new ArrayList<>();
    employeeList.add(employee1);
    employeeList.add(employee2);
    employeeList.add(employee3);
    employeeList.add(employee4);

    EmployeeTable employeeTable = new EmployeeTable(employeeList);

    // Get user input and sort the table accordingly
    employeeTable.getUserInput();
  }
}
