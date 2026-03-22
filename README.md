# Chain Reaction Game

by Zach Bulley

---

This is a programming project for **NCEA Level 2**, assessed against standard [91896](task/as91896.pdf).

The project is written in the [Kotlin](https://kotlinlang.org) programming language and demonstrates a number of *
*advanced programming techniques**:

- Modifying data stored in collections
- Storing multi-dimensional data in collections
- Creating functions that use parameters and/or return values
- Using non-trivial string manipulation
- Using additional non-core libraries

** EDIT LIST ABOVE TO MATCH YOUR PROJECT**

---

## Project Files

- Program source code can be found in the [src](src/) folder
- Program test plan is in [test-plan.md](docs/test-plan.md) in the docs folder
- Program test evidence is in [test-results.md](docs/test-results.md) in the docs folder

---

## Project Description

The game rules...

## Chain Reaction 💣

### Game Setup

- A row of 12 squares, numbered 1 to 12 from left to right
- The board starts empty
- Both players have a supply of 'bombs' (counters) in their own colour
- Decide who goes first

### Gameplay

- Players take turns - You may not skip your turn
- On your turn you must place one of your bombs on an empty square, but ...
- You cannot place your bomb directly between two opponent bombs since it would immediately be 'defused' (see the defuse
  rule below)
- After placing, the following rules apply (in order):
    - Defuse rule:  if any opponent bomb now has one of your bombs on each side, it is 'defused' and removed from the
      board (note: two bombs can be defused in one go)
    - Chain reaction rule: if your bomb creates an unbroken chain of 3 or more of your own bombs, the entire chain '
      explodes' - all bombs in the chain are removed and you score points equal to the length of the chain

### Win Condition

- The first player to reach 10 points wins




