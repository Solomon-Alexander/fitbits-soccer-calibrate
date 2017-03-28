### Introduction

* A group of members are using Fitbits to train on a soccer pitch with a fitness coach. 
* At the start of their session the trainees must navigate the pitch to calibrate their Fitbits.

* A trainee's position and location is represented by a combination of x and y co-ordinates and a 
letter representing one of the four cardinal compass points. 

* The pitch is divided up into a grid to simplify orientation. 
* An example position might be 0, 0, N, which means the trainee is in the bottom left corner and facing North.
* In order to calibrate the Fitbits the fitness coach gets the trainees to move to various locations on 
the pitch using a simple string of letters. 

* The possible letters are 'L', 'R' and 'M'. 'L' and 'R' tells the trainee to turn 90 degrees left or right respectively, without moving from their current spot. 

* 'M' means move forward one grid position, and maintain the same heading.
* Assume that directly North from (x, y) is (x, y+1).

### INPUT:

* The first line of input is the upper-right coordinates of the pitch, the lower-left coordinates are 
assumed to be 0,0.

* The rest of the input is information pertaining to the trainees that are on the pitch.
* Each trainee has two lines of input from the coach.
* The first line gives the trainee's position.
* The second line is a series of instructions telling the trainee how to move on the pitch.
* The position is made up of two integers and a letter separated by spaces, corresponding to the x 
and y co-ordinates and the trainee's orientation.

* Each trainee will be finished sequentially, which means that the second trainee won't start to 
move until the first one has finished the calibration.

## Design
### Objects
* Pitch - represents the soccer field.
  Contains the size of the pitch and when moving if it's a valid position
  Ex: Out of bounds, cannot move there.
  
* Member - represents a member on the pitch. Handles turning left, right and moving forward.
  A member is also aware of the Pitch and the size of the pitch.

* Direction - Encapsulate valid directions. (N, S, E, W)

* FileParser - handle taking input from a file.
  Handles validating whether the coordinates of pitch are valid, whether member
  coordinates are valid and if directions and movements are valid.

## Testing

### Test Classes
* FileParserTest.java
  * Test valid file input
  * Test throws IOException if file doesn't exist
  * Test valid uppercoordinates of pitch
  * Test if bad member directions or bad member coordinates throw IOException
  
* MemberTest.java
  * Test valid board placement
  * Test if invalid board placement, throws an error
  * Test valid movement
  * Test member cannot move off top right, left corner of pitch.
  * Test member cannot move off bottom right and bottom left corner of pitch


### Test Input Files
* inputData.txt
* Other input files for bad input tests start with the word "bad"

## Things to do
* Make Pitch class an interface so it can be reused and extended as Pitch shape changes
* Performance of the code can be tweaked

### To run the code
* Run Maven build using the command "mvn clean install" at the root of the project. This will compile source code, run tests and create a jar file.
* Execute the built jar file using the command 
"java -jar target/fitbits-soccer-calibrate-0.0.1-SNAPSHOT.jar inputData.txt"
* The output will be 
1 3 N
5 1 E 