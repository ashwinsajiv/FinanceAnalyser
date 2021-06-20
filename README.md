### Introduction

This project is a finance analyzer that takes in a .csv file with a list of transactions and gets an account Id and a time frame from the user to show the relative account balance. 

### Requirements

To run this application, you will need Java (preferably the latest).

### Design

The entry to this project is at `./src/financeAnalyser/FinanceAnalyser.java`. This class has the main function and parses the .csv file. 
Once that is parsed, we then load it into an array of Transanction object. This object can be found in `./src/transaction` and contains all the 
necessary attributes, setters and getters.
The main function requests the user for extra information on the account and the time frame. This is then passed into a helper function present in
`./src/financeAnalyser/FinanceAnalyserHelper.java`.
This function has the logic, that deals with the addition and subtraction of all the amounts in transactions within a given time frame. 
There is also a hand made Tuple.java class which I needed to return a tuple that has the amount and number of transactions as output. 
The tests are present in `./src/financeAnalyser/Test_FinanceAnalyser.java`.


### Installation

Please open the project in your IDE, preferably Eclipse to get this project started. For reference on how to do this http://pages.cs.wisc.edu/~cs302/labs/EclipseTutorial/Step_04.html.

### Testing 

All the tests are present in `./src/financeAnalyser/Test_FinanceAnalyser.java` with the class name `Test_FinanceAnalyser`. 
