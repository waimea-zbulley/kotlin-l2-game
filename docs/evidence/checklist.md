# Success Criteria Checklist

This checklist can be used to gauge progress towards different levels of success. Note that to pass, *all* of the Achieve Criteria must be met; for Merit, you need all Achieve, plus all the Merit Criteria, and so on for Excellence too.

---

## Achieve Criteria

### Program Functionality

The game functions correctly and meets the specification:
- [ ] The game is **playable**
- [ ] The **instructions** for the game are available in-game
- [ ] **Two players** can play
- [ ] Player **names** are used to identify each player
- [ ] Players **take turns** to play
- [ ] Players provides **input data** to the game (e.g. moves to make)
- [ ] The **current status** of the game is shown after each play
- [ ] A **winner is detected** correctly

### Program Code

The program stores data using:
- [ ] **Variables** of at least two types (e.g. int, text, boolean)
- [ ] At least one **data collection** (array / list) to store some elements of the game data

The program structure:
- [ ] Is broken up into **functions**: a main function, plus other supporting functions 
- [ ] Contains **sequences** of instructions
- [ ] Uses **conditional** instructions to control the program flow
- [ ] Uses program **branches** (if...else, when, etc.)
- [ ] Uses **iteration** (loops) to repeat things (for, while, etc.)

### Program Documentation

The program code:
- [ ] Is **indented** correctly
- [ ] Is **laid-out clearly**
- [ ] Contains **comments** that help in understanding how it works

### Program Testing

The program has been tested and there is documented evidence that:
- [ ] The game is **fully functional**, showing testing of:
  - [ ] game setup
  - [ ] player moves
  - [ ] players taking turns
  - [ ] scoring (if any)
  - [ ] players winning
  - [ ] final feedback (if appropriate)
- [ ] **Valid (expected) data** has been used to test **all data inputs**
- [ ] Where tests have failed, **fixes** are discussed and **tests re-run**

---

## Merit Criteria

### Program Code

The program stores data using variables, where:
- [ ] Variable **names are well-chosen** (relating to their purpose)
- [ ] Variable names **begin with lowercase**
- [ ] Naming is consistent, either **camelCase or snake_case**
- [ ] Variables are **scoped appropriately** (global or local to a function)
- [ ] **Global** variables are only used if **genuinely needed**

The program uses functions appropriately, where:
- [ ] At least one uses **parameters** to pass data into it
- [ ] At least one provides a **return value** to the calling code
- [ ] The function **names are well-chosen**, relating to their functionality 

### Program Documentation

The program code is well-commented:
- [ ] **JavaDoc Block comments** are used at the top of each **file** and **function**
- [ ] Comments accurately describe the **function and behaviour** of the code:
  - [ ] Defining the **purpose** of functions / key blocks of code
  - [ ] Explaining the **reason** (the '**why**') of key parts of the code
  - [ ] Defining function **parameters** and/or **return values**

### Program Testing

The program has been tested using:
- [ ] A test plan **prepared in advance** of the coding
- [ ] A test plan that **defines test data values** to be used
- [ ] Test values that cover **boundary** (limit / edge) cases

---

## Excellence Criteria

### Program Code

Program flexibility and maintainability is aided by:
- [ ] **Constants** being used to define key values, and used throughout the program
- [ ] Variable values being **derived at run-time** (from other variables / constants)
- [ ] Literal values only being used if they **make sense**, and they don't impact program flexibility

Program flexibility and maintainability is aided by good program structure:
- [ ] Conditions, branching, loops and functions are used **effectively**
- [ ] Procedures are **efficient** (minimal iterations, etc.)
- [ ] **Minimal duplication of code** (instead using loops, or having multiple calls to a single function)
- [ ] Functions are **well-chosen and logical**, with a clearly defined purpose
- [ ] The functions chosen represent a **logical decomposition** of the task

### Program Documentation

The program code:
- [ ] Code is laid-out and organised **logically and concisely**

### Program Testing

The program has been tested to be **robust**:
- [ ] With a **comprehensive and thorough** test plan
- [ ] Testing **regularly** throughput development, allowing **time for debugging**
- [ ] Using test values that cover **invalid** (unexpected) cases
- [ ] Resulting in a program that **copes appropriately** with invalid inputs
