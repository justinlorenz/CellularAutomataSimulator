# Simulation Lab Discussion
## Names and NetIDs
Justin Lorenz (jml166)
Grace Llewellyn (gal16)
Luisa Silva (lps23)

## Rock Paper Scissors

### High Level Design Ideas

If we were to create a Rock, Paper, Scissor game, we would follow the MVC model to implement the game. The model section of the game would hold the classes that hold the data of the game such as the weapons class, rock class, scissors class, etc. The view section would hold the javaFx classes that have the role of displaying the actual game to the player such as the icons of rock, paper scissors, score etc. The controller section would then serve as the middle man between these by letting these two classes interact with each other. For example, if the user inputs their choice in a textfield in the view class, the controller would take in this input and send it to the model. Then the model would take this input and update the result based on the inputted string. This interaction allows each class to abide by the correct design principles that were discussed in class.  

Classes: User, Controller, View class, Abstract weapon class, Rock class that implements abstract weapon class, Paper class that implements abstract weapon class, Scissors class that implements abstract weapon class, Interactions class (determines who wins a hit), a directed graph to indicate who beats what


### CRC Card Classes


Class name: User
method : getInput(string), 
return integer value for rock/scissor/paper

Class name: Interactions class
*method: determineWinner, return winner

```java

Public class Interaction {
    Public void determineWinner(Weapon weapon1, Weapon weapon2);
}
```


### Use Case 1
*User input string (“rock”, “paper”, “scissor”) and the  getInput class takes that string and turns it into integers to be compared later

* A player chooses his RPS "weapon" with which he wants to play for this round.
```java
weapon weapon = getInput(string user input);
```

### Use Case 2

*2 Players are playing the game one inputs rock and the other scissor
```java
weapon weapon1 = getInput(string user 1 input);
weapon weapon2 = getInput(string user 2 input);
determineWinner(weapon1, weapon2)
```


## Cell Society

### High Level Design Ideas
For our design, we want to follow the model, view, controller format where the model will store the data of the simulation such as the states of the cells, the grid, etc, the view will hold the ability to display the GUI and view that the user will be seeing, and the controller will be the “middle-man” between the two classes are do things such as tell the view to display something different if the model has changed. 

Subtopics:
Model Classes:
Class to read in data from a file (i.e CSV file)
Board class (has a matrix of Cell items that corresponds to the matrix described below in BoardDisplay)
Cell class (we will likely make this abstract and it will have a simple boolean determining if it is on or off) 
User class clas maintains a score

View classes 
BoardDisplay- contains a matrix of squares (has methods to change the colors of squares)

Controller responsibilities:
- Determine when a square is supposed to be marked to on or off and change both the matrix in the BoardDisplay class and the Board class 





### CRC Card Classes

Class Type: Cell Class
Constructor(int i, int j, boolean state)
Takes in a row, col and stores these positions and also stores the state of this cell, returns nothing
Void setState(boolean state)
Sets the state of the current cell to the state sent in, returns nothing
Boolean getState() 
Returns the current state of the cell
Int getX/getY() 
Returns the current int x/int y of the cell 
Void changeState()
Using the given rules to decide whether to change the current state of this cell, returns nothing


### Use Cases

* Apply the rules to a cell: set the next state of a cell to dead by counting its number of neighbors using the Game of Life rules for a cell in the middle (i.e., with all of its neighbors)
The Board class counts all the neighbors (Cells) and has access to make the Cells marked as on or off and lets the BoardDisplay class know to mark the call as white or dark 





