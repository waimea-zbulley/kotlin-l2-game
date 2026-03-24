/**
 * =====================================================================
 * Programming Project for NCEA Level 2, Standard 91896
 * ---------------------------------------------------------------------
 * Project Name:   PROJECT NAME HERE
 * Project Author: PROJECT AUTHOR HERE
 * GitHub Repo:    GITHUB REPO URL HERE
 * ---------------------------------------------------------------------
 * Notes:
 * PROJECT NOTES HERE
 * =====================================================================
 */

val numBoxes = 12
val boxes = mutableListOf<String>()

fun main() {
    println("Welcome to Chain Reaction!")
    println("--------------------------")

    while (true) {
        val action = getUserActionMenu()
        when (action) {
            'R' -> showRules()
            'P' -> game()
            'Q' -> break
        }
    }
}


fun getUserActionMenu(): Char {
    println("What would you like to do?")
    println("[R]ules")
    println("[P]lay game")
    println("[Q]uit")
    var choice: Char?

    while (true) {
        print("Choice: ")
        choice = readlnOrNull()?.firstOrNull()?.uppercaseChar()

        if (choice != null && choice in "RPQ") {
            return choice
        }
    }
}

fun showRules() {
    println("Rules")
}

fun game() {
    createBoxes()

    println()
}

fun createBoxes() {

    // Sets the list to be clear for a new game
    boxes.clear()

    // Adds the empty values for boxes
    repeat(numBoxes) {
        boxes.add("-")
    }
}

fun showBoxes() {
    
}