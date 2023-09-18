package Staff;

public class SalariedEmployee extends Employee {

    private double annualSalary;

    public SalariedEmployee(String firstName, String lastName, String department, double annualSalary) {
        super(firstName, lastName, department);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    @Override
    public double weeklyWage() {
        return annualSalary / 52;
    }
}
