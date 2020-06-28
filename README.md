# Tic_Tac_Toe_with_AI

### This project is a console version of a Tic-Tac-Toe game.
### The game is played on the 3x3 board. Player needs to provide coordinates between 1 and 3. Fields on the board have the following coordinates:
### (1, 3) (2, 3) (3, 3)
### (1, 2) (2, 2) (3, 2)
### (1, 1) (2, 1) (3, 1)

### In order to start the game, the user needs to provide starting command in the following form: start level level. In order to stop the game user needs to provide exit when prompt to provide the command.
### Program recognises 4 levels:
#### 1) user - user plays itself.
#### 2) easy - it is a computer using easy level of difficulty (computer makes random moves base on random numbers generator).
#### 3) medium - it is a computer using medium level of difficulty (computer analyses the current state of the board and base on that analyses it's next move in the following way: 1) if it can win in one move (if it has two in a row), it places a third to get three in a row and win. 2) if the opponent can win in one move, it plays the third itself to block the opponent to win. 3) otherwise, it makes a random move.).
#### 4) hard - it is a computer using hard level of difficulty (computer uses MinMax algorithm to choose optimal move against the opponent).

### Program enables to play game in the following combinations:

#### Example 1 (user against other user)
#### Input command: start user user

#### Example 2 (user against computer (easy, medium or hard))
#### Input command: start user medium

#### Example 3 (computer (easy, medium or hard) against user)
#### Input command: start easy user

#### Example 4 (computer (easy, medium or hard) against computer (easy, medium or hard))
#### Input command: start easy hard

### In order to stop the game:
#### Input command: exit
