# STUDENT-FEE-MANAGEMENT-SYSTEM
The Student Fee Management System is a console-based Core java application designed to manage student fee details. This system allows the user to enter student information, set total fees, make fee payments and check the remaining balance.


# Student Fee Management System (Core Java)

## Overview
This is a console-based Core Java application for managing a student's fee details. It allows users to:
- Enter student details (ID and Name)
- Set the total fee amount
- Make fee payments
- View paid amount and remaining balance

The program uses basic Core Java concepts such as classes, objects, methods, loops, conditional statements, encapsulation, exception handling, and the `Scanner` class for user input.

## Technologies
- Core Java
- JDK 21
- Console-based application

## Project Structure
- `MainApp.java`  
  Contains the `main()` method, displays the menu, and handles user interaction.
- `Student.java`  
  Holds student details and performs fee calculations.

## Features and Rules
- Student ID and Name are mandatory.
- Total fee must be set before making any payment.
- If payment is attempted without setting total fee, a warning is shown.
- On every valid payment:
  - Paid amount increases
  - Balance decreases
- If paid amount equals total fee, the system displays: `Fee paid completely.`
- If the user enters an amount greater than the balance, an error message is shown.
- User can repeat operations until exit.

## Menu Options
1. Set Total Fee  
2. Pay Fee  
3. View Fee Details  
4. Exit  

## How to Compile and Run
Open a terminal and run:

```bash
cd "/Users/barath/Java Project"
javac MainApp.java Student.java
java MainApp
```

## Sample Flow
1. Enter student ID and name.
2. Set total fee.
3. Pay fee in one or more payments.
4. View fee details at any time.
5. Exit when done.

## Learning Goals
This project strengthens understanding of:
- Object-Oriented Programming (OOP)
- User input handling with `Scanner`
- Basic validation and error handling
- State management (total fee, paid amount, balance)

