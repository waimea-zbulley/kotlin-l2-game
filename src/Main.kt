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

const val numBoxes = 12
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
    var player1Score = 0
    var player2Score = 0
    var currentPlayer = player1
    var otherPlayer = player2
    var currentPlayerToken = "X"
    var otherPlayerToken = "O"

    createBoxes()

    println("──────────────────────────────")
    println("Hello $player1 & $player2!")
    println("$player1 will play as X")
    println("$player2 will play as O")

    println("")

    showBoxes()
    while (player1Score < 10 && player2Score < 10) {
        var scoreAdd = 0

        // Code for player turn
        playTurn(currentPlayer, currentPlayerToken, otherPlayerToken)
        checkBoxesForPushToken(currentPlayerToken, otherPlayerToken, currentPlayer, otherPlayer)
        scoreAdd += checkBoxesForChain(currentPlayerToken)


        // Code to switch player
        if (currentPlayer == player1) {
            player1Score += scoreAdd
            currentPlayer = player2
            otherPlayer = player1
            currentPlayerToken = "O"
            otherPlayerToken = "X"

        } else {
            player2Score += scoreAdd
            currentPlayer = player1
            otherPlayer = player2
            currentPlayerToken = "X"
            otherPlayerToken = "O"
        }
        showScore(player1, player2, player1Score, player2Score)
        showBoxes()
    }

    if (player1Score >= 10) {
        println("")
        println("$player1 Wins!")
        println("")
    }
    if (player2Score >= 10) {
        println("")
        println("$player2 Wins!")
        println("")
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
    for (i in 1..<boxes.size) {
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
    for (i in 1..<boxes.size) {
        print("───┴")
    }
    println("───┘")

//    for (i in 0..<boxes.size) {
//        print("${i + 1}".padEnd(2))
//    }

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

fun playTurn(currentPlayer: String, currentPlayerToken: String, otherPlayerToken: String) {

    while (true) {
        print("$currentPlayer's ($currentPlayerToken) turn please select what square you would like to place your token in (1-${boxes.size}): ")
        val turn = readln().toInt()

        if (turn in 2..<boxes.size - 1 && boxes[turn] == otherPlayerToken && boxes[turn - 2] == otherPlayerToken) {
            println("Invalid Spot")
        } else if (boxes[turn - 1] == "-") {
            boxes[turn - 1] = currentPlayerToken
            break
        } else println("Invalid Spot")
    }

}

fun checkBoxesForPushToken(
    currentPlayerToken: String,
    otherPlayerToken: String,
    currentPlayer: String,
    otherPlayer: String
) {
    for (i in 1..<boxes.size - 1) {
        if (boxes[i] == otherPlayerToken && boxes[i - 1] == currentPlayerToken && boxes[i + 1] == currentPlayerToken) {
            println("$currentPlayer pushes out one of $otherPlayer's tokens")
            boxes[i] = "-"
        }
    }
}

fun checkBoxesForChain(playerToken: String): Int {
    var playerScoreAdd = 0
    var count = 0
    // Loop to check if player1 has any valid chain reactions
    for (i in 0..<boxes.size) {
        if (boxes[i] == playerToken) {
            count += 1
        }
        if (boxes[i] != playerToken && count >= 3) {
            playerScoreAdd += count

            while (count != 0) {
                boxes[i - 1] = "-"
                boxes[i - (count)] = "-"

                count -= 1
            }
        }
        if (boxes[i] != playerToken) {
            count = 0
        }
    }
    return playerScoreAdd
}

fun showScore(player1: String, player2: String, player1Score: Int, player2Score: Int) {
    println("Scores")
    print("┌────────────────────┐")
    println("┌────────────────────┐")

    print("│")
    print(" $player1 : $player1Score".padEnd(20))
    print("│")

    print("│")
    print(" $player2 : $player2Score".padEnd(20))
    println("│")
    print("└────────────────────┘")
    println("└────────────────────┘")
}