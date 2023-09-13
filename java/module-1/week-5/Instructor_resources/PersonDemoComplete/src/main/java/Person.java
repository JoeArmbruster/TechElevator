class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        if (age > 0) {
            this.age = age;
        } else {
            this.age = 0;
        }
    }

    // getters aka accessors
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // setters aka modifiers
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Cannot assign a negative age");
        }
    }

    public void ageOneYear() {
        age++;
    }
}
