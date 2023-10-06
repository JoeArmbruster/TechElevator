public class Runner {
    private String firstName;
    private String lastName;
    private int bibNumber;

    public Runner(String firstName, String lastName, int bibNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bibNumber = bibNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBibNumber() {
        return bibNumber;
    }

    @Override
    public String toString() {
        String s =  "Runner # " + bibNumber +
        "\n" + firstName + ", " + lastName;
        return s;
    }

    public String singleLineString() {
        String s = bibNumber + "\t" + firstName + "\t" + lastName;
        return s;
    }
}
