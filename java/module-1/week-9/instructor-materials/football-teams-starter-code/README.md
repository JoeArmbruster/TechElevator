# Football Season Tracker

## Application

## Starting code

Begin by opening the _Football Season Tracker_ project in IntelliJ and reviewing the starting code.

The starting code provides you with a menu user interface that handles user input, displays data, and calls to methods in the application.

The Football Season Tracker contains these files:

* `App.java` - The "main" class of the application
* `util/FileStorageService.java` - A File I/O class for you to put your I/O logic in and use in your code
* `util/exception/FileStorageException.java` - A custom exception for the `FileStorageService` class

### `App.java`

The `App` class contains two primary methods:

* `initialize()` - This method is empty to start, but you'll use this method to load the data of the application.
* `run()` - The run-loop which is responsible for the application menus and search results display.

The `main()` method of the `App` class calls both of these methods. In other words, when the application starts.

The `App` class contains other methods after `initialize()` and `run()` that comprise the application UI and called on from within the run-loop. You won't need to change any of this code, but you can feel free to browse it. The method names are descriptive of their purpose. **These methods are complete and you shouldn't modify them.**

### `util/FileStorageService.java`

You can use this class to define your File I/O code. Two empty methods have been provided to you with recommended parameters, return types, and throws. You can feel free to change the provided code here, but you shouldn't have to.

## Data files

You can find the data files for this application in the `src/main/resources/` directory within the project.

There are two types of files:

* `teams.dat` - you'll read this file first to determine the teams within the football league.
* `_date_files_.dat` - each one of these files describes the games that took place on a particular date.

## Requirements

There are a number of requirements you need to complete. They're grouped under class design, file I/O, and data transformation.

### Requirement: Class design

Create these two classes in the `model` folder/package. Each class has a list of members and methods that it must implement:

Team class
* Data members
    * `String city`
    * `String mascot`
    * `String coach`
* Methods
    * getter methods
    * a `toString()` method that displays _city mascot_, as in Cleveland Browns.

Game class
* Data members
    * `LocalDate date` // The date of the game
    * `Team firstTeam`
    * `Team secondTeam`
    * `int firstTeamScore`
    * `int secondTeamScore`

* Methods
    * getter methods
    * a `toString()` method that displays all information from the game on a single line.

Example: 2023-10-08 Los Angeles Rams 31 San Diego Chargers 28

Each class must have the appropriate constructor to create a new instance of the object with the fields from the data files.

#### Implementation of interface methods

### File I/O

The `FileStorageService` class provides two `static` methods, one to write to a file, the other to read from a file. These methods can be called in your code without instantiating a `FileStorageService` object, you can just call `FileStorageService.writeContentsToFile(...)` and `FileStorageService.readContentsOfFile(...)` with the appropriate parameters.

You must implement the appropriate logic to read and write from files, along with handling any issues that may arise.

### Data transformation

The `initialize()` method in the `App` class is for setting up the data for the application. You can create other methods to assist with processing the data if you wish, as long as everything occurs from the call of `initialize()` and before the call to `run()`.

#### Requirement 1: Populate the `teams` ArrayList. 

Store the data you import from the `teams.dat` files in the collection `List<Team> teams` defined near the top of the `App` class:

The `teams.dat` file contains three fields separated by a pipe character—`|`. The fields are in the order of:

1) City
2) Mascot
3) Coach

Example contents of `teams.dat`:

```
Los Angeles|Rams|Sean
San Diego|Chargers|Brandon
Cleveland|Browns|Kevin
Pittsburgh|Steelers|Mike
```

#### Requirement 2: Populate the allGames ArrayList.

Store the data from the series of `_date_.dat` files in the array list `allGames`

The `_date_.dat` files have

a) A first line representing the date on which the games were played.
b) A series of lines describing the games themselves. Each line contains four fields separated by a pipe character—`|`. The fields are in the order of:

First team mascot | first team score | Second team mascot | second team score

Example contents of an `date` file:

```
2023-10-08
Rams|31|Chargers|28
Browns|22|Steelers|13
```

>Recommendation: Use the provided `FIELD_DELIMITER` constant when splitting.

#### Requirement 3: Your code for processing the items must make sure to handle:

* Empty lines
* Lines that have too many or too few fields

## Running the project

The project provides a basic menu interface to retrieve and print data. Option 1 gives you the ability to display all teams.
Option 2 gives you the option to display all games.

#### Requirement 4 (BONUS): Have each team store information about its own games

This is a somewhat open-ended task, have fun with it. Have each team store an ArrayList of its own games. 
Or, alternatively, each team can store only its wins and losses thus far through the season.

