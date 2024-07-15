public class Test {
    public static void main(String[] args) {
        Employee employee1 = new Employee(001, "Ali", 20, 12000);
        Employee employee2 = new Employee(002, "Ahmedani", 21, 65000);
        Employee employee3 = new Employee(003, "Aaraiz", 19, 89000);
        Employee employee4 = new Employee(004, "Ali Saeed", 22, 32000);

        MyArrayList<Employee> employees = new MyArrayList<>();

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);

        employees.toString();
    }
}
