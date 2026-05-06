# Plan for Testing the Program

The test plan lays out the actions and data I will use to test the functionality of my program.

Terminology:

- **VALID** data values are those that the program expects
- **BOUNDARY** data values are at the limits of the valid range
- **INVALID** data values are those that the program should reject

---

## Input: Main menu (play game) - Valid

I will attempt to play the game from the main menu

### Test Data To Use

I will input the character **'p'**

### Expected Test Result

The game should start

---

## Input: Main menu (rules) - Valid

I will attempt to show the rules from the main menu

### Test Data To Use

I will input the character **'r'**

### Expected Test Result

The rules should display

---

## Input: Main menu (quit) - Valid

I will attempt to quit the game from the main menu

### Test Data To Use

I will input the character **'q'**

### Expected Test Result

The game should exit

---

## Input: Main menu - Invalid

I will attempt to input several invalid inputs to the main menu

### Test Data To Use

I will input the values **'l'**, **'ghr'** as well as **blank**

### Expected Test Result

Reject the input and ask for an input again

---

## Input: Main menu (play game) when characters after first - Valid

I will attempt to play the game with more characters after the initial

### Test Data To Use

I will input the string **"pfdg"**

### Expected Test Result

The game should start

---

## Input: Main menu (play game) using uppercase char - Valid

I will attempt to play the game using an uppercase character to start the game

### Test Data To Use

I will input the character **'P'**

### Expected Test Result

The game should start

---

## Input: Player names - Valid

I will test that a valid player name can be entered and accepted

### Test Data To Use

I will try to enter a valid player names Dave, Bob for player 1 and 2

### Expected Test Result

The names should be accepted

---

## Input: Player names - Boundary

I will test when the player name is the maximum characters (14) as well as the minimum (1)

### Test Data To Use

I will test the inputs

- **"a"** (player 1)
- **"Alexanderjames"** (player 2)

### Expected Test Result

Both names should be accepted

---

## Input: Player names - Invalid

I will test invalid player names (when blank and too long)

### Test Data To Use

I will test the inputs

- **" "**
- **"JefferyJefferson"**

### Expected Test Result

The names should be rejected and inform the user they are invalid

---

## Input: Player counter selection - Valid

I will test placing player tokens in valid locations

### Test Data To Use

I will test the inputs

- **'2'**
- **'10'**
- **'7'**

### Expected Test Result

The inputs should be accepted

---

## Input: Player counter selection - Boundary

I will test placing player tokens in boundary locations

### Test Data To Use

I will test the inputs

- **'1'**
- **"12"**

### Expected Test Result

The values should be accepted

---

## Input: Player counter selection - Invalid

I will test invalid inputs for player counter selection

### Test Data To Use

I will test the inputs:

- **"0"**
- **"-5"**
- **"13"**
- **"784"**
- **" "**
- **"Dave"**

### Expected Test Result

The values should be rejected and an error should be shown to the user depending on the invalid entry

---

## Gameplay: Placing a token

I will attempt to place a token in a valid location

### Test Data To Use

I will test the inputs

- **'2'**
- **'10'**
- **'7'**

### Expected Test Result

A token should be placed

---

## Gameplay: Placing a token - Boundary

I will attempt to place tokens at boundary locations

### Test Data To Use

I will test the inputs

- **'1'**
- **"12"**

### Expected Test Result

A token should be placed

---

## Gameplay: Forming a chain of 3

I will test forming a chain of 3

### Test Data To Use

I will play Bob's tokens in slot **4**, **5** and **6**

### Expected Test Result

A chain should form (the players pieces removed from the board)

---

## Gameplay: Forming a chain of 4

I will test forming a chain of 4

### Test Data To Use

I will play Bob's tokens in slot 4, 5, 7 and 6

### Expected Test Result

A chain should form and the players pieces should be removed

---

## Gameplay: Forming a chain at the start of the board - Boundary

I will form a chain at the start of the board

### Test Data To Use

I will play Bob's tokens in slot **1**, **2** and **3**

### Expected Test Result

A chain should form and the players pieces should be removed


---

## Gameplay: Forming a chain at the end of the board - Boundary

I will form a chain at the end of the board

### Test Data To Use

I will play Bob's tokens in slot **10**, **11**, **12**

### Expected Test Result

A chain should form and the players pieces should be removed

---

## Gameplay: The board forming

When the game starts the board should form

### Test Data To Use

Play from the main menu (entering the second players name to start the game "Dave")

### Expected Test Result

The game should start and the board should form

---

## Gameplay: Player gaining score

I will form a chain with Bob's counters and they should gain points

### Test Data To Use

I will form a chain in position 4, 5 and 6

### Expected Test Result

Bob should gain score (3 points)

---

## Gameplay: Player winning with exactly 10 points - boundary

Testing player winning (reaching 10 points)

### Test Data To Use

I will test when bob reaches 10 points

### Expected Test Result

Bob should win (and the game should go back to the main menu)

---

## Gameplay: Player winning with >10 points - Valid

I will test player winning (reaching 10 points)

### Test Data To Use

I will test when bob reaches 11 points

### Expected Test Result

Bob should win (and the game should go back to the main menu)

---

## Gameplay: Player pushing another players token out

I will test pushing another players token out by using 2 adjacent tokens of the other player

### Test Data To Use

I will have Dave's token in position 4 and Dave's tokens in position 3 and 5

### Expected Test Result

Dave's token should be pushed out

---

## Input: Placing a token between 2 of the other player's - Invalid

I will test placing a token in an invalid place due to being blocked by the other players

### Test Data To Use

I will attempt to put Dave's token in slot 5 when Bob's tokens are in 4 and 6

### Expected Test Result

The game should reject the move and inform them the place is invalid

---