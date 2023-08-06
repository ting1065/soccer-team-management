## About

An u10 soccer team player management program disigned under MVC pattern.

## List of Features

1. Add players into the player pool.
2. Create a team of 10 to 20 players.
3. Create a starting lineup of 7 players.

## How To Run

Double-click the U10SoccerTeam.jar file in the res/ folder. 

## How to Use the Program

1. Add Player
- Enter the player's information in the text field under the text "Enter a player's information:".
- Ensure the entered information should be in the format of "firstname lastname yyyy/mm/dd skill-level preferred-position". e.g. "david beckham 2015/12/31 3 midfielder".
- The letters of the name can be in any case. The program can convert the names into standard format.
- The birthdate must be a date that shows the player is at an age between 0 and 10.
- The skill level can be at most 5 and at least 1.
- The preferred position can be one from "Goalie", "Defender", "Midfielder", and "Forward" in any case.
- Press the button "add player" after the player's information is entered.
2. Create Team
- At least 10 valid players have been added to the player pool before creating the team.
- Press the button "create team".
- Pressing again after new players added to the pool can make a new team based on the new player pool.
3. Create Starting Lineup
- There must be an existing valid team before creating the starting lineup.
- Press the button "create starting lineup".
4. Exit
- Press the button "exit" or the "X" button of the window to end the program.

## Assumptions

1. A child can play soccer once born.
2. No two children can have both the same name and birthdate.

## Limitations

1. For the convenience of testing, the random seed for randomly assigning jersey numbers to players is fixed.
2. A team can have at most 20 players, and at least 10.
3. A starting lineup can only have exactly 7 players where 1 is goalie, 2 are defenders, 3 are midfielders, and 1 is forward.

## Citations
- “A Visual Guide to Layout Managers.” A Visual Guide to Layout Managers (The Java™ Tutorials &gt; Creating a GUI With Swing &gt; Laying Out Components Within a Container), https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html.