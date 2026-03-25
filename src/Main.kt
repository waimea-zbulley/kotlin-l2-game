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
    while (true) {
        playTurn(player1, player2)
    }

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


    while (true) {
        print("$player1's (X) turn please select what square you would like to place your token in (1-12): ")
        val player1Turn = readln().toInt()
        if (boxes[player1Turn - 1] == "-") {
            boxes[player1Turn - 1] = "X"
            break
        } else println("Invalid Spot")
    }
    checkBoxes(playerToken = "X")
    showBoxes()

    while (true) {
        print("$player2's (O) turn please select what square you would like to place your token in (1-12): ")
        val player2Turn = readln().toInt()
        if (boxes[player2Turn - 1] == "-") {
            boxes[player2Turn - 1] = "O"
            break
        } else println("Invalid Spot")
    }
    checkBoxes(playerToken = "O")

}

fun checkBoxes(playerToken: String): Int {
    var playerScoreAdd = 0
    // Loop to check if player1 has any valid chain reactions
    for (i in 1..boxes.size) {
        if (boxes[i] == playerToken) {
            if (boxes[i - 1] == playerToken && boxes[i + 1] == playerToken) {
                println("Point")
                boxes[i] = "-"
                boxes[i - 1] = "-"
                boxes[i + 1] = "-"
                playerScoreAdd += 3
            }
        }
        if (i == boxes.size - 1) {
            break
        }
    }
    return playerScoreAdd
}

fun showScores(player1: String, player2: String) {

}