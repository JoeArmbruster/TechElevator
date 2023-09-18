package Staff;

public class HourlyEmployee {

    private String firstName;
    private String lastName;
    private String department;
    private double hourlyWage;
    private int hoursWorked;

    public HourlyEmployee(String firstName, String lastName, String department, double hourlyWage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.hourlyWage = hourlyWage;
        this.hoursWorked = 40;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    public double weeklyWage() {
        return hourlyWage * hoursWorked;
    }
}
