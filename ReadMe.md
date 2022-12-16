PROBLEM : MARS ROVERS

A squad of robotic rovers are to be landed by NASA on a plateau on Mars. This plateau, which is curiously rectangular, must be navigated by the rovers so that their on-board cameras can get a complete view of the surrounding terrain to send back to Earth.

A rover's position and location is represented by a combination of x and y co-ordinates and a letter representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the rover is in the bottom left corner and facing North.

In order to control a rover, NASA sends a simple string of letters. The possible letters are 'L', 'R' and 'M'. 'L' and 'R' makes the rover spin 90 degrees left or right respectively, without moving from its current spot. 'M' means move forward one grid point, and maintain the same heading.

Assume that the square directly North from (x, y) is (x, y+1).

INPUT:
The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0.
The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of input. The first line gives the rover's position, and the second line is a series of instructions telling the rover how to explore the plateau.
The position is made up of two integers and a letter separated by spaces, corresponding to the x and y co-ordinates and the rover's orientation.
Each rover will be finished sequentially, which means that the second rover won't start to move until the first one has finished moving.
OUTPUT
The output for each rover should be its final co-ordinates and heading.
INPUT AND OUTPUT

Test Input:
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM

Expected Output:
1 3 N
5 1 E



SOLUTION: MARS ROVERS

Our solution is pretty simple if we look at the x and y graph below, given a scenario that we deployed a robot at position X,Y (0,0)  North, I noted the following interesting states and our final solution will be revolving around these rules.

1) Any move from point (X,Y) and the rover facing towards North will increment	++Y
2) Any move from point (X,Y) and the rover facing towards South will decrement   --Y
3) Any move from point (X,Y) and the rover facing towards East will increment     ++X
4) Any move from point (X,Y) and the rover facing towards West will decrement   --X

Finally any change in state of the rover in terms of direction will not affect the positioning of the rover in terms of X,Y location, so let’s say we pass a command string "MM" for a rover positioned at X,Y(0,0) facing North. The final destination of the Rover will be X,Y(0,2) and any state change in direction with command "L" or "R" will only cause the rover to face a new direction in this case West and East respectively but position according to X and Y will remain X,Y(0,2). So with our task clearly defined, Let’s look at the design.
 
 
 
