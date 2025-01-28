# Game-4
Game-4 project for COMP55

Team:
    - Samuel Wan
    - Andrew Lewis
    - Juan Cuevas
    - Christopher Chew

This is a java based open world exploration sandbox game.
In this game the player fights enemies and explores castles, collecting fun and powerful items
along the way. Eventually, the player will come face-to-face with the boss in one of the castles.
Once defeated, the boss will drop a special trophy to commemorate the endgame challenge and the player can either continue to explore the world or end their game.

The game is in a complete state. All features that have been planned to be implemented were made such as
saving, randomly generating structures and biomes as the player progresses, a functioning main menu, inventory menu with hotbar extension, and more.

Of course, there can always be more things to add. For example:

  - A resource meter for magic when using the ice and fire rods to mitigate spamming.

  - Addtional unique items to keep the players invested.

  - More enemies and bosses to increase the challege within the game.

  - More structures and locations to expand the identity of the world generated.
    
  - Cleaner and more organized UI

  - More animations

Maybe in the future, someone from the team (or maybe even everyone that was involved) can come back together to
have fun improving the game and seeing where they take the game from there.

You can play the game by downloading the game4_final_final.zip folder, extracting it, and running the jar.


![alt text](https://github.com/comp55/final-project-team-4/blob/main/media/Screenshot1.png)
![alt text](https://github.com/comp55/final-project-team-4/blob/main/media/Screenshot2.png)
![alt text](https://github.com/comp55/final-project-team-4/blob/main/media/Screenshot3.png)

----------------------------------------------------------------------------------------------------------------------
Controls:

  W - Move Up
  S - Move Down
  A - Move Left
  D - Move Right

  Left Click - Attack / Use
  E - Inventory
    -> Click and drag items within the inventory to either organize or throw away items.
    -> Combine identical weapons to create a slightly more powerful version of it.
  Num Keys (0 - 9) - Select Item

  Escape - Pause Menu

Game4-Ressurection UPDATES

Section 1: Overview
The feature I will be adding is sound effects along with music. All things from getting hurt to swinging your sword everything will have a sound attached to it. MP3 files will be gathered from online and to make it modular I will be making a separate class along with the AudioPlayer class given by previous classes. Making it modular by only having to change either the string when using the playSound() function or changing the file in the new class. The sound files will be put into a separate “sounds” folder for organization purposes. The feature will be heavily relying on the JAVAFX library to function. The music that will be added are for the main menu, general game, and dungeons/castles. As for side effects, anything that can be interacted with within the in-game content. Enemies and certain items will have sounds on them. 

Section 2: Pseudocode
This routine is a class that plays or stops sounds based on the input parameter. The sound obtains a string that is then linked to a keyword. This is where the routine would interact with the AudioPlayer class to play the corresponding sound. This will take advantage of the switch statement that allows for a multitude of cases to be implemented.

keywords along with corresponding sounds…

initalize AudioPlayer

playSound()
check input sound keyword
	if keyword is found
		call AudioPlayer to play corresponding sound file
	else 
		do nothing

stopSound()
Check input sound keyword
	if keyword is found
		Call AudioPlayer to stop corresponding sound file

Section 3: Steps of Assurance
Multiple steps were needed to provide the full feature and to make it fully operational. This is a result of the many problems that were faced during the construction process. One of those problems was that the sound would end after a certain amount of time. For example if you were in the menu and were idle, if the following mp3 file finished, it would stop playing. To fix this a new function was implemented called repeatSound() which took advantage of a function made by AudioPlayer that had a loop option parameter. Another problem I faced is that for some reason my computer was not able to play any mp3 files that had a less than a total time of 8 seconds. I counteracted this error by making a new function called shortSound(). It took clips that were playable (anything above 8 seconds) and shortened it to a set duration such as 1, 2 or 3 seconds. To do this I took advantage of more JAVAFX imports like Duration and PauseTransition. The last step I needed to take is to make the classes associated with the sounds available to folders that needed it. The original plan was to only put it into the game file, but after further investigation some behaviors were implemented in folders outside of the game folder. After copying the classes associated and importing it to the folders that needed it. The sound behaviors that were needed were implemented.

