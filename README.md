HiVolts Project By Ashu Bhown/Amelia Mao/Sophia Vera

(github.com/ameliamao/hivolts is where this project is located)

Introduction:
This program runs a game called HiVolts designed using applet. In this game the player must move within a square of electric fences whilst dodging enemies (AKA Mhos) and randomly generated electric fences within the board.

Specifications:
This program meets the requirements presented by the assignment as it contains all the required keys and the mhos move according to what was specified. But we did add the additional 'u' key, for resetting the game.  

Errors:
After testing many times, we realized that sometimes the mhos did not move as they were supposed to and the player occasionally died when it also was not supposed to. We have tried to fix this problem, but have not yet found a concrete solution for it.

Code Overview:

Code done by Ashu:
Fence, Board design, Fence Randomization, Initialization of the game, draw methods, paint methods, player death mechanic, slight tweaks to Mho movement

Code done by Sophia:

Code done by Amelia:

This code is divided into seven files: HiVolts (the game itself), Square, Player, Mho, Fence, Grid and DeadScreen. Square is the parent class of Player, Mho and Fence. It creates the shape and size of each, with getter and setter methods. Player has methods to define its coordinates as well 

Major Challenges:
During this project we have faced many challenges, and are still continuing to face many challenges. The first challenge we faced was in large part do to communication errors. We had just started the project when we decided the code structure would not be appropriate, even though one member had already finished writing a class. Rewriting the class and the rest of the code was very time consuming, causing us to have a late start on Hivolts. Another challenge that is still hindering us is the mho movement. It does not work perfectly and in the beginning caused us many errors because instead of the mho killing the player, the player would instead kill the mho. This caused a lot of problems in the later run, when we were debugging things. Overall, the largest challenge we faced was definitely time management. I believe that if we had managed our time better, the code would have worked much more nicely, and player would not have as many issues as it currently has.

Acknowledgements:
We would like to thank our families for always supporting us and giving us food, stackOverflow for giving us ideas when we were completely stuck on what to do, and the many others who helped support us through this large project.






















