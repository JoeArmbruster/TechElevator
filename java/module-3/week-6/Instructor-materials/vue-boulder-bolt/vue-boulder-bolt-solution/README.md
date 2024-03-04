# Boulder Bolt Project

This project is designed to walk you through many of the most common features you'll be asked to put together using the Vue framework.

![Final version Boulder Bolt Project](.\resources\final_version_Boulder_Bolt.png)


## Race Registration Component

### 1. Add the Race Registration Component to the App component

The registration component is the aqua-colored box at the top of the screen, immediately after the "Boulder Bolt" heading. Note that this involves 3 different changes you must make to the App file.

### 2. One-way binding

Use one way binding to display the value of `raceDateString` in the appropriate place in the `info-2024` section. 

### 3. add button to show / hide element

Add an anchor tag immediately below the `raceDateString` in the `info-2024` section. Style this as a button by adding the class `title-btn`. 

As a temporary measure, add text to the button that says "hide registration". 

Modify this button so that clicking it hides the entire registration form. Clicking it again restores the form to the page. 

HINT: create a boolean variable in `data()` that dictates whether the form is visible or hidden. 

### 4. Toggle button text

Modify the button text so that it shows "hide registration" when the form is visible, and "show registration" when it is not visible. 

### 5. Add a computed property value

Currently the value displayed for the number of days remaining before the race is fixed at 999. Replace this by writing a computed value called `getDaysTilRace()`.

HINT: The code below gives numeric values for the two dates that you need to compare. Use these values to identify the difference in those times, then convert this difference to the proper unit (days).

``// date of the race as measured in milliseconds since Jan. 1, 1970``

``const raceDate = new Date (this.raceDateString); ``

 ``// today's date as measured in milliseconds since Jan. 1, 1970``

``const today = new Date();``




## Race Results Component

### 1. Add the Race Results Component

Add the `RaceRegistration` component in the appropriate location in the `App` component

### 2. Add data

* Add a variable to store the distance of the Boulder Bolt (26.2 miles).
* Add a variable to store the data for all of the runners. This value needs to be retrieved from the `RunnerData.js` file. 

### 3. Use `v-for` to add rows to the table.

Each row should display the information associated with one runner. Note that, for the moment, you will list the runner's time in the given value of seconds. 

HINT: [HTML syntax for a table](https://www.w3schools.com/html/html_tables.asp)


### 4. Use the `getRaceTime()` method

Look at the provided method `getRaceTime()`, which takes a parameter of seconds and returns as a string representation of that number of seconds converted to "hours: minutes: seconds". Take the time to understand how this method works. Then apply this method so that your table now displays the correct format for each runner's time. 



### 5. Write the `getPace()` method

Like `getRaceTime()`, `getPace()` takes a number of seconds as a parameter. Using this parameter, and the distance of the race, it calculates the average race pace. It returns this pace as a string in the format "minutes: seconds". 

### 6. Add capability to buttons.

Currently the `See Time` and `See Pace` buttons do not work. Modify your code so that clicking either button results in the appropriate value (pace or time) being displayed in the table below. 

### 7. Change table heading

Modify the table so that it displays the appropriate heading ("Pace" or "Time") for the data being displayed. 
