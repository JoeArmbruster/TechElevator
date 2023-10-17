# Review Assignment

## Step One: Make the Student class

A student has:
* a firstName (String)
* a lastName (String)
* an array of grades (int[])

Write the following methods:
* getter methods for all instance variables
* a method `getAverage()` that returns a floating point average of the values in `grades`.
* a `toString()` method that displays `first, last`, the student's grade average,  then each grade. The format
should look something like this: 

Jackson, Joe
Average: 95.0
Grades: 	90	95	100

## Step Two: Test the Student class

Instaniate one or more Student objects in Main. Check to see if your methods work.

## Step Three: Make the Teacher class

A teacher has:
* a firstName (String)
* a lastName (String)
* a salary (double)

Write the following methods:
* getter methods for all instance variables
* a method `getWeeklySalary` that returns the amount that this teacher should be paid each week (52 week year).
* a `toString()` method that prints a teacher's information in a similar format to this:

    McTeach, Teachy
    Salary: $100,000.00*

(note to get the currency formatting you can declare a `NumberFormat` object in `Techer` as follows)

`private final static NumberFormat FORMATTER = NumberFormat.getCurrencyInstance();`

Then call on the `format()` method of `FORMATTER`, which accepts a double and returns a (formatted) String.

## Step Four: Test the Teacher class

Instantiate one or more Teacher objects in `Main`. Make sure all of the methods in teacher work correctly. 

## Step Five: Redesign your classes using inheritance

You likely have noticed that there are some common features between the`Student` and `Teacher` classes. 

Design a class `Person` that incorporates all of the common attributes. Refactor the child classes accordingly. 

**Thought question:** Should the `Person` class be abstract? Why or why not? 

## Step Six: Check your work

Confirm that both Student and Teacher objects still work as expected

## Step Seven: Create an `ArrayList` of type Student called `allStudents`. 

Make `allStudents` static, and declare it outside of any method. This will allow you to reference it any any of the methods that you write. 

In `main()`, populate `allStudents` with a minimum of 4 student objects.

## Step Eight: Create the following menu inside of `Main`:

1) show all students
2) find student by name
3) generate honor roll

Before you write the code that makes each menu option work, make the menu itself work:
- The menu must only accept the #s 1 through 3 (inclusive). 
- Any other value results in an error message
- An invalid selection results in the user getting the menu prompt again, with another chance to enter a proper value.
- 
## Step Nine. Write the method `showAllStudents()`

The method is called if the user selects option 1. It should iterate through `allStudents` and display each using a call to `toString()`

## Step Ten: Write the method `findStudentByName()`

This method is called if the user selects option 2. It accepts a String, then return the first student whose name (first or last) contains that String. If the search term is not found, 
the method returns `null`. 

## Step Eleven: Write the method `generateHonorRoll()`

This method is called if the user selects option 3. This method iterates through `allStudents` and returns a `List` of all Students whose average is above an 88.
