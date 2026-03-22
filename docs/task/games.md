# Game Choices

Your task is to create a simple two-player game board game. The game will play out on a one-dimensional grid and involve placing or moving counters. 

|⬤|◯|   |⬤|⬤|◯|⬤|   |   |⬤|   |◯|   |
|-|-|-|-|-|-|-|-|-|-|-|-|-|

You have the choice of four different games. Each one has different play mechanics, different strategies for winning, and different things to puzzle out in terms of programming them. However, they are all similar in the difficulty of programming them.

| Game                |Size|Counters|Setup|Movement|Special Mechanic|Win Condition|
|---------------------|----|--------|-----|--------|----------------|-------------|
| **Pinned 📌**       |16|4 white, 1 black|Random|Slide left, any distance, no hops|Remove from square 1|Remove the back counter|
| **The Squeeze 🗜️** |15|3 per player|Fixed|Move, either way; swap adjacent|Board shrinks|Last player standing|
| **Leap Frog 🐸**       |11|2 'frogs' per player|Fixed|Hop or jump forward|Jump over opponent|First frog past both opponents|
| **Chain Reaction 💣**  |12|Unlimited per player|Empty|Place counters|Defuse; chains of 3+ explode|First to 10 points|


## Pinned 📌

### Game Setup
- A row of 16 squares, numbered 1 to 16 from left to right
- 5 counters (total) are placed randomly on the board - 4 white and 1 black 
- Decide who goes first

### Gameplay
- Players take turns - You may not skip your turn
- On your turn you must do exactly one of the following:
    - Slide any counter (black or white) any number of squares to the left, as long as no other counter is in the way and the destination square is empty, or... 
    - Remove the counter on square 1 (only if a counter is there)

### Win Condition
- The player who removes the black counter from square 1 wins

### Variant
- Counters can slide either left or right (but still can't jump other counters)


## The Squeeze🗜️

### Game Setup
- A row of 15 squares, numbered 1 to 15 from left to right
- Player 1 places 3 counters at squares 5, 7, and 9
- Player 2 places 3 counters at squares 6, 8, and 10
- Decide who goes first

### Gameplay
- Players take turns. You may not skip your turn
- On your turn you must do exactly one of the following:
    - Move one of your counters exactly one square left or right into an empty square
    - Swap one of your counters with an adjacent opponent counter, moving your counter into their square and their counter into yours, but...
    - You may not swap an opponent counter into a danger zone square (the end squares)
- After both players have taken their turn, the board shrinks - the square at each end is removed. Any counter on a removed square is 'crushed' and eliminated

### Win Condition
- The last player with at least one counter remaining on the board wins


## Leap Frog 🐸

### Game Setup
- A row of 11 squares, numbered 1 to 11 from left to right
- Player 1 places 2 'frogs' (counters) at squares 1 and 2 - they only ever move right
- Player 2 places 2 'frogs' (counters) at squares 10 and 11 - they only ever move left
- Decide who goes first

### Gameplay
- Players take turns - You may not skip your turn
- On your turn you must move one of your frogs using exactly one of the following moves:
    - Hop - move one square forward into the empty square directly ahead
    - Jump - leap over exactly one opponent frog that is directly in front of you, landing in the empty square immediately beyond them
- You may not move backward
- You may not jump over your own frogs
- You may not jump over more than one frog at a time

### Win Condition
- The first player to move one of their frogs past both opponent frogs wins
- If a player has no legal move on their turn, their opponent wins


## Chain Reaction 💣

### Game Setup
- A row of 12 squares, numbered 1 to 12 from left to right
- The board starts empty
- Both players have a supply of 'bombs' (counters) in their own colour
- Decide who goes first

### Gameplay
- Players take turns - You may not skip your turn
- On your turn you must place one of your bombs on an empty square, but ...
- You cannot place your bomb directly between two opponent bombs since it would immediately be 'defused' (see the defuse rule below)
- After placing, the following rules apply (in order):
    - Defuse rule:  if any opponent bomb now has one of your bombs on each side, it is 'defused' and removed from the board (note: two bombs can be defused in one go)
    - Chain reaction rule: if your bomb creates an unbroken chain of 3 or more of your own bombs, the entire chain 'explodes' - all bombs in the chain are removed and you score points equal to the length of the chain

### Win Condition
- The first player to reach 10 points wins
