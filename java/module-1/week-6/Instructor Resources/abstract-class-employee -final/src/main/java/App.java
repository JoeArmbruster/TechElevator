import Staff.Employee;
import Staff.HourlyEmployee;
import Staff.SalariedEmployee;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class App {

    static final DecimalFormat CURRENCY_FORMAT = new DecimalFormat("#.00");

    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new HourlyEmployee("Bob", "Roberts", "Sales", 22.5));
        employees.add(new HourlyEmployee("Susan", "Li", "Administration", 23.0));
        employees.add(new SalariedEmployee("Marc", "Statham", "Management", 90000.0));
        employees.add(new SalariedEmployee("Anna", "Whitman", "Administration", 120000.0));

        for (Employee employee : employees){
            System.out.println(employee + " is paid " + "$" + CURRENCY_FORMAT.format(employee.weeklyWage()));
        }
    }
}
