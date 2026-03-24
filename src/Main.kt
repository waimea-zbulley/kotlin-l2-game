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
    val (player1, player2) = playerNames()

    createBoxes()

    println("──────────────────────────────")
    println("Hello $player1 & $player2!")
    println("$player1 will play as X")
    println("$player2 will play as O")

    println("")
    showBoxes()
    playTurn(player1, player2)

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

    // Returns if list is empty in order to not print only ending and starting segments of boxes
    if (boxes.isEmpty()) return

    // Prints the top section of boxes
    print("┌")
    for (i in 1..boxes.size - 1) {
        print("───┬")
    }
    println("───┐")

    // Prints the middle section of boxes
    for (i in boxes) {
        print("│")
        print(" $i".padEnd(3))
    }
    println("│")

    // Prints the bottom section of boxes
    print("└")
    for (i in 1..boxes.size - 1) {
        print("───┴")
    }
    println("───┘")
}

fun playerNames(): Pair<String, String> {
    var player1: String?
    var player2: String?

    while (true) {
        print("Player 1 name: ")
        player1 = readlnOrNull()
        print("Player 2 name: ")
        player2 = readlnOrNull()

        if (player1 != null && player2 != null) {
            break
        }
    }
    return Pair(player1, player2)
}

fun playTurn(player1: String, player2: String) {
    print("$player1's turn please select what square you would like to place your token in (1-12): ")
}
