public class PersonDemo {
    public static void main(String[] args) {

        Person fred = new Person("Fred", 33);
        Person janet = new Person("Janet", 40);

        System.out.println(fred.getName() + " is " + fred.getAge() + " years old");
        System.out.println(janet.getName() + " is " + janet.getAge() + " years old");

        janet.setAge(-40); // do we want to allow this???
        fred.ageOneYear();

        System.out.println(fred.getName() + " is " + fred.getAge() + " years old");
        System.out.println(janet.getName() + " is " + janet.getAge() + " years old");

    }
}

