# TicTacToe [![Build Status](https://travis-ci.com/OArnarsson/TicTacToe.svg?token=cXTkx6Qw1Hk5t2yqmrmW&branch=master)](https://travis-ci.com/OArnarsson/TicTacToe)

### Design report
The design of the game is aimed to please the lovers of old fashioned console games.
In the first stages of the design process we decided to concentrate on the architecture and logic of the game. All functions were made with that in mind that they would be easily testable and consistent. With the use of continuous integration tool called [**Travis**](https://travis-ci.org/) we were able to thoroughly test the functions as they were implemented.
<br><br>

#### GUI
All function are loosly-coupled in order to create a graphical user interface for the next version of the game. This version of the game is just a console application, but for next version it should be very simple to switch out current interface for more graphical user-friendly interface. 