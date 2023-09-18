package Staff;

public class HourlyEmployee extends Employee {

    private double hourlyWage;
    private int hoursWorked;

    public HourlyEmployee(String firstName, String lastName, String department, double hourlyWage) {
        super(firstName, lastName, department);
        this.hourlyWage = hourlyWage;
        this.hoursWorked = 40;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double weeklyWage() {
        return hourlyWage * hoursWorked;
    }
}
