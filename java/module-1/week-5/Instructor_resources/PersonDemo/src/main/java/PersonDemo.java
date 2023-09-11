public class PersonDemo {
    public static void main(String[] args) {

        Person fred = new Person();
        Person janet = new Person();

        fred.name = "Fred";
        fred.age = 33;

        janet.name = "Janet";
        janet.age = 40;

        System.out.println(fred.name + " is " + fred.age + " years old");
        System.out.println(janet.name + " is " + janet.age + " years old");

    }
}

class Person {
    public String name;
    public int age;
}
