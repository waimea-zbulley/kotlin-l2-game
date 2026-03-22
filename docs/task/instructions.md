# NCEA Level 2 Programming Project Instructions

| Standard | Version | Level | Credits |
|----------|---------|-------|---------|
| 91896    | 2       | 2     | 6       |

## Contents

- [Introduction](#introduction)
- [Assessment Conditions](#assessment-conditions)
- [Detailed Game Specification](#detailed-game-specification)
- [Achievement Criteria](#achievement-criteria)
- [What You Need to Hand In](#what-you-need-to-hand-in)


---

## Introduction

You are required to construct a computer program that will allow two people to play a simple, one-dimensional board game. The choice of games can be found in the [Games](games.md) document.

You will be assessed on how skilfully and effectively you construct, test, debug and document the program.

## Assessment Conditions

This is an 'open book' task. You may look at previous programs that you have written, and you may use the notes provided (e.g. the language reference documents). You may not however, simply modify a previous project - all code must be original.

### Plagiarism and the Use of AI

This is an individual assessment activity: All the work that you produce must be your own. Do not copy blocks of code from other people, nor use an AI code-generation tool to write blocks of code.

You will be asked to explain the workings of any/all of your code to assess whether you wrote and understand the code.

## Detailed Game Specification

The game that you program should:

1. Be for **two (or more) players**

2. Be **turn-based**, players taking turns to perform actions / play moves

3. Be **non-trivial to play**, i.e. there should be an element of difficulty / challenge for players

4. Have a **clear outcome**, e.g. a winner based on score / survival / etc

5. Provide clear and simple **instructions** on how to play the game (either at the start, or as play progresses)

6. Provide an **interface that is well-designed and easy-to-use**. The interface should:
   - Show the status of the game as it progresses
   - Prompt players for input as needed 
   - Provide feedback on result of player actions / moves 
   - Give an overall summary at the end-of-play (winner, points, etc.)


## Achievement Criteria

| Level          | Criteria                                                                         |
|----------------|----------------------------------------------------------------------------------|
| **Achieve**    | Use advanced programming techniques to develop a computer program.               |
| **Merit**      | Use advanced programming techniques to develop an **informed** computer program. |
| **Excellence** | Use advanced programming techniques to develop an **refined** computer program.  |

*To help you keep track of how successfully you are meeting the criteria, use the [Checklist document](checklist.md)*

### Achieve Criteria

Use advanced programming techniques to develop a computer program means:

1. You need to write code for a program that:
   - Uses **variables** - at least two types (e.g. numeric, text, boolean)
   - Uses **sequence** - a series of instructions
   - Uses **selection** (branches) - making decisions (e.g. if...then, when, etc.)
   - Uses **iteration** (loops) - repeating things
   - Takes **input** from the user 
   - Produces **output** for the user to read

2. You need to use at least two 'advanced' techniques, for example:
   - Using **collections** (lists) to store and update data
   - Storing **multi-dimensional data** in collections
   - Creating **functions** that use parameters and/or return values
   - Using non-trivial **string manipulation**
   - Using additional **non-core libraries** 

3. You need to set out your **program code clearly** and document the program with **comments** 

4. You need to **test** and **debug** your program to ensure that it works with **expected** (valid) data values (this needs to be documented)

*Note: You must satisfy **all** of the criteria above to pass*

### Merit Criteria

Use advanced programming techniques to develop an informed computer program means **all the criteria for Achieved**, plus:

1. Your program must be well-documented with:
   - appropriate and well-considered **variable / function names**
   - comments that **describe code function and behaviour**

2. Your code should follow **common conventions** for the Kotlin language (e.g. indentation, use of upper/lowercase, comment blocks, etc.)

3. You must test and debug your program **effectively** to ensure that as well as valid data, it also works with relevant **boundary** (edge/limit) data values (this needs to be documented)

### Excellence Criteria

Use advanced programming techniques to develop a refined computer program means **all of the criteria for Merit**, plus:

1. Your program should be **well-structured** and a **logical** response to the task

2. You must make your program **flexible**, including:
   - Using **constants** and **derived values** in place of literal values
   - Using conditions, branching, loops and functions **effectively**

3. You must make your program **robust**, correctly handling **invalid** (unexpected) data values

4. You need to **comprehensively test** and **debug** your program to ensure that as well as valid / boundary data, it also copes wit **invalid** data (this needs to be documented)


## What You Need to Hand In

At the end of this project you will need to submit the following:

1. **Program Source Code** - a copy of your [program source](../../src) file(s)

2. **Runnable Program** - an executable file (e.g. a JAR or EXE)

3. **Evidence of Testing** - [planning](test-plan.md) and [evidence](test-results.md) template have been provided for you to use for this
