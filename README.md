# Java Projects
This is a collection of Java projects.

## Projects

### [DNA](../master/DNA)

The DNA language has an alphabet of four symbols or “letters”, A, C, G and T, which are ordered to convey a specific piece of information. In our cells, these four DNA letters are linked together in a precise order in very long molecular chains, which convey genetic information to our cells.

The program randomly generates two DNA pieces (each with length 21) and stores them as two separate **“Queue”s** and then carried outs the following DNA operations: 
-	Complement of the first DNA piece 
-	Amino Acids of the first DNA piece 
-	Crossover of two DNA pieces

### [GoFish Game](../master/GoFish)
The game is played with 24-card deck (4 times numbered from 1 to 6) and 2 players (human vs computer). 

#### Objective
The objective of the game is to collect as many "books" as possible. A book is four cards of the same rank. The player with the most books at the end of the game wins.

#### Dealing and setup
First, cards are dealt to the players, each player gets 7 cards. Once the dealing is done, the rest of the deck is put in a random pile on the table.

There are three stacks:\
1- Stack1 to hold the cards of the first player (human)\
2- Stack2 to hold the cards of the second player (computer)\
3- Stack3 to hold the cards on the table 

#### Asking and fishing
You should open the game. You asks the computer for a particular rank. For example, you might ask if it has any sixes. You may only ask for ranks that you already have at least one card of. For instance, if you don't have any sixes yourself you can't ask for them.\
- If the computer has any sixes, then it must give them to you, and you get another turn and can ask again. \
- If the computer doesn't have any sixes then it will tell you to "Go Fish" which means that you will draw one card from the pile on the table. If you get a six from the table, then you may get a book. 

When the computer plays, it randomly selects and asks a rank that it already has at least one card of. The rest of the game is the same.   

#### Scoring
If you have 4 of the same rank then you show the cards to the other player, and then place the four cards in a pile next to you. This is called a book. The player with the most books at the end of the game wins. 

#### End of the game 
If one of the players (human or computer) finishes all the cards in his hand, the game is over. 
The winner should be displayed, if exists. The game may be ended without any winner (in the case of tie). 

### [Hangman Game](../master/Hangman)
The computer randomly identifies a word and the user tries to guess it by suggesting letters, within a certain number of guesses.
The word to guess is represented by a row of dashes, representing each letter of the word.
The word should be the name of a country in English such as Germany, Brazil, China, etc.
		
If the user suggests a letter which can be found in the word, the computer writes it in all its correct positions. 
If the suggested letter cannot be found in the word, the computer increases the count of guesses. 

In addition, in the project, **Multi-Linked List (MLL)** structure to sort words by length, **Double Linked List (DLL)** structure to sort words alphabetically, **Single Linked List (SLL)** structure to sort high score table, **Circular Single List (CSLL)** structure to keep the word to be guessed has been implemented and used.

### [Magic Numbers](../master/MagicNumbers)
MagicNumbers is a game played by two players: user1 and user2. There are three single linked lists (SLL) with 8 in size. At the beginning of the game, all SLLs are empty. Players take turns to add a digit (randomly generated between 1 and 5) to any list (randomly determined). In other words, the program should determine the digit and list randomly.

The aim of the game is for each player to attempt to create a triple consecutive sequence (incremental or decremental) among connected squares (horizontally or vertically or diagonally). 

If a player succeeds in creating a sequence, the game is over. The winner is the player who made the first sequence. Otherwise turns alternate between players after each move. If all lists are filled up and there is no any sequence, then the game is a draw.

The program displays all steps until the game is over. 

### [Magical Series](../master/MagicalSeries)
Magical Series is a card game played by two players: user1 and user2. 

The game is played with a deck of cards. The deck has 52 cards including hearts, diamonds, spades and clubs suits and each suit has A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K. The players will try to win the game by turning over the face-down cards and expanding the series.

#### Start of the Game

The cards are shuffled and laid out face down at random positions on a QUEUE.\
For example:
Queue: H5 CA S1 S10 D5 DJ D3 S3 D6 HK DQ D1 S8 C7 C5 H4 S9 ... C2 

The game is played in series of randomly turning over cards. A series starts by turning over a card. If the last opened card and the previous one are of the same suit or rank, there is a relation. 

As long as there is a relation between the last two cards, the player can continue to turn over cards. The turned over cards should be stored in a STACK. If there is no relation between the last two cards, the player gets the points of the series and the game turns to the other player. Always the user1 starts the game. 

#### Calculating the Points of a Series
The points of a series in the stack should be calculated as follows:
- Same suit: 1 point
- Same rank: 3 points

#### End of the Game 
All the turned over cards are removed from the queue. The game finishes when a player reaches at least 10 points or all the cards are turned over. If all the cards are turned over, the points of the current series are added to his/her score.

### [Implementation of Data Structures](../master/Implementation-of-Data-Structures)
This section covers implementing and testing many data structures with applets.\
Data structures used:
* [CircularLinkedList](../master/Implementation-of-Data%20Structures/CircularLinkedList)
* [CircularQueue](../master/Implementation-of-Data%20Structures/CircularQueue)
* [DoubleLinkedList](../master/Implementation-of-Data%20Structures/DoubleLinkedList)
* [LinkedStack and LinkedQueue](../master/Implementation-of-Data%20Structures/LinkedStack_and_LinkedQueue)
* [MultiLinkedList](../master/Implementation-of-Data%20Structures/MultiLinkedList)
* [PriorityQueue](../master/Implementation-of-Data%20Structures/PriorityQueue)
* [SingleLinkedList](../master/Implementation-of-Data%20Structures/SingleLinkedList)

## Built With
* Java

## Contact
Mail: enessah200@gmail.com\
LinkedIn: [linkedin.com/in/enes-sahinn](https://www.linkedin.com/in/enes-sahinn/)\
Project Link: [Implementation of Data Structures](https://github.com/enes-sahinn/Implementation-of-Data-Structures)
