HiVolts Project By Ashu Bhown/Amelia Mao/Sophia Vera

(github.com/ameliamao/hivolts is where this project is located)

Introduction:
This program runs a game called HiVolts designed using applet. In this game the player must move within a square of electric fences whilst dodging enemies (AKA Mhos) and randomly generated electric fences within the board.

Specifications:
This program meets the requirements presented by the assignment as it contains all the required keys and the mhos move according to what was specified. But we did add the additional 'u' key, for resetting the game.  

Errors:
After testing many times, we realized that sometimes the mhos did not move as they were supposed to and the player occasionally died when it also was not supposed to. We have tried to fix this problem, but have not yet found a concrete solution for it.

Code Overview:
Code Overview: This code is mainly focused around the Hivolts and Grid class.  Hivolts functions as user input, whereas Grid has the object field, which is a two dimensional array storing the elements of the blocks on the screen.  These elements are all either null or from classes extended from the abstract class Square, which is a basic mold of any block that has a place on the 12x12 grid and a coordinate on the screen.  The code originates in Hivolts' init, which sets up the grid and keylistener.  When a button is pressed, the code runs through the appropriate calculations for the new positions (most of which are is Grid) and updates them.  Then, it repaints, showing the updates, and depending on whether the game is won or lost, different pngs are displayed. If the user chooses to play again, they can press 'u' and the process repeats.

Code done by Ashu:
I developed the Fence class, the initial board design, the fence randomization, initialization of the game, draw methods as well as paint methods, the death mechanic of the player (checking for death, confirming death, etc.), and slight tweaks to Mho movement. I created the first revision of the HiVolts game setup, which was later developed on by all three of us in future revisions. Of course, I also engaged in a lot of debugging in the later versions.

Code done by Amelia:
I worked on the Mho class, the algorithm for Mho movement, and generally anything else relating to mhos. I also wrote many checker methods for the different death cases(i.e player death and mho death), drew several pngs, and rewrote the keyPressed class for readability. At the end I did some debugging and documented all the classes.

Code done by Sophia: 
I originally worked mainly on the movement code for player and the abstract class square. I also wrote the static random position function and helped implement it. After I completed this, I set out in writing the code structure: the 2D dimensional array and the corresponding creator methods. I also wrote the isDead, isAlive and reset methods.  After this, I added the pngs, and updated the color schemes and graphics.

Major Challenges:
During this project we have faced many challenges, and are still continuing to face many challenges. The first challenge we faced was in large part due to communication errors. We had just started the project when we decided the code structure would not be appropriate, even though one member had already finished writing a class. Rewriting the class and the rest of the code was very time consuming, causing us to have a late start on Hivolts. Another challenge that is still hindering us is the mho movement. It does not work perfectly and in the beginning caused us many errors because instead of the mho killing the player, the player would instead kill the mho. This caused a lot of problems in the later run, when we were debugging things. However overall, the largest challenge we faced was definitely time management. I believe that if we had managed our time better, the code would have worked and looked even better than it does now.

Acknowledgements:
We would like to thank our families for always supporting us, stackOverflow for giving us ideas when we were completely stuck on what to do, and the many others who helped support us through this large project.





