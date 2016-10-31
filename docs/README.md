# TicTacToe [![Build Status](https://travis-ci.com/OArnarsson/TicTacToe.svg?token=cXTkx6Qw1Hk5t2yqmrmW&branch=master)](https://travis-ci.com/OArnarsson/TicTacToe)

### About the project
The object of TicTacToe is to get three of your mark('X' or 'O') in a row.  
You play on a three by three game board. The first player is known as X and the second is O.  
Players alternate placing Xs and Os on the game board until either oppent has three in a row or all nine squares are filled.  

The project currently runs on the console of your choosing using the <code>./gradlew run</code> command.  
The players picks a cell on board, marked 1-9, if the cell is available, it is marked with an 'X'.  
The AI is programmed to choose a random, available, number on the board and marks it with an 'O'.  
<br><br>

### Development manual
You can download the game from [**our repository**](https://github.com/OArnarsson/TicTacToe) or fork it to you own, after downloading, unzip the game to a folder of your choosing. 
In order to run the application it´s required to have **Java jdk 1.8** or greater. If you do not have **java 1.8** or greater installed you will need to download and install it to you computer. Java can be downloaded from the [**Oracle website**](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html). 
The game comes packed with a Gradle wrapper(gradlew 3.1) to set up the game follow the administration direction here below.
<br><br>

### Administration manual
If you are using windows command prompt, run the following commands to start the program: If you are using bash or shell insert <code>./   </code> before each command.
1. Open up cmd and navigate to where you unzipped Tic Tac Toe repository. eg. <code>cd  C:\users\'username'\Desktop\TicTacToe</code>
2. Execute the command: <code> gradlew build</code>
    * <code>gradlew build</code> Gradle runs all test cases and checks if the program is ready to run.
3. Execute the command: <code> gradlew run</code>
    *<code>gradlew run</code> will run the game. A greeting from the game will appear in the console and awaits you to make your first move against the computer.
<br><br>

### Useful gradle commands
This project comes packed with a Gradle wrapper (gradlew 3.1), so there is no need for local gradle setup.
Simply run these simple commands in the project root directory <code>~/TicTacToe</code>
~~~~
./gradlew assemble - Assembles the outputs of the project.
*./gradlew build" - Builds the project and runs test in /src/test folder.
./bin/build_test - For cmd/powershell users. - Runs the application and displays output in shell.
./gradlew tasks - Displays list of tasks.
gradlew assemble - For cmd/powershell users.
*gradlew build - For cmd/powershell users.
bin/build_test - For cmd/powershell users.
gradlew tasks - For cmd/powershell users.
~~~~
<br><br>

### Design report
The design of the game is aimed to please the lovers of old fashioned console games.
In the first stages of the design process we decided to concentrate on the architecture and logic of the game. All functions were made with that in mind that they would be easily testable and consistent. With the use of continuous integration tool called [**Travis**](https://travis-ci.org/) we were able to thoroughly test the functions as they were implemented.
<br><br>

### Team members
- Andri Andrésson 
- Orri Arnarsson
- Orri Axelsson
- Þórarinn Gunnar Árnason
- Sverrir Vilhjálmur Hermannsson
- Jón H Júlíusson
- Barði Freyr Þorsteinsson

