/**
 * =====================================================================
 * Programming Project for NCEA Level 2, Standard 91896
 * ---------------------------------------------------------------------
 * Project Name:   Chain Reaction
 * Project Author: Zach Bulley
 * GitHub Repo:    GITHUB REPO URL HERE
 * ---------------------------------------------------------------------
 * Notes:
 * PROJECT NOTES HERE
 * =====================================================================
 */

const val winScore = 10 // The score the player is required to reach in order to win
const val numBoxes = 12 // Max of 99 for proper formating. This is how many boxes for the playing area
val boxes = mutableListOf<String>() // The list for storing the values of the boxes

// Data class for defining all of the players variables/values.
data class Player(
    val token: String,
    var score: Int,
    val name: String,
    val colour: String
)

// Main function for introducing name and checking user action.
fun main() {
    println("Welcome to Chain Reaction!")
    println("--------------------------")

    while (true) {
        val action = getUserActionMenu()
        when (action) {
            'R' -> showRules() // R = rules
            'P' -> game()      // P = play
            'Q' -> break       // Q = quit
        }
    }
}

// Print's menu and get input for user choice on starting game/reading rules/ quiting
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

// Function to show the rules of the game
fun showRules() {
    println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────")
    println(
        "### Game Setup\n" +
                "\n" +
                "- A row of 12 squares, numbered 1 to 12 from left to right\n" +
                "- The board starts empty\n" +
                "- Both players have a supply of 'bombs' (counters) in their own colour\n" +
                "- Decide who goes first\n" +
                "\n" +
                "### Gameplay\n" +
                "\n" +
                "- Players take turns - You may not skip your turn\n" +
                "- On your turn you must place one of your bombs on an empty square, but ...\n" +
                "- You cannot place your bomb directly between two opponent bombs since it would immediately be 'defused' (see the defuse\n" +
                "  rule below)\n" +
                "- After placing, the following rules apply (in order):\n" +
                "    - Defuse rule:  if any opponent bomb now has one of your bombs on each side, it is 'defused' and removed from the\n" +
                "      board (note: two bombs can be defused in one go)\n" +
                "    - Chain reaction rule: if your bomb creates an unbroken chain of 3 or more of your own bombs, the entire chain '\n" +
                "      explodes' - all bombs in the chain are removed and you score points equal to the length of the chain\n" +
                "\n" +
                "### Win Condition\n" +
                "\n" +
                "- The first player to reach 10 points wins"
    )
    println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────")
}

// Main game function for adding score and running all other functions related to the game.
fun game() {
    val player1Token = "X"
    val player2Token = "O"
    val player1 = Player(name = playerNames("Player 1"), token = player1Token, score = 0, colour = "#FFFF00")
    val player2 = Player(name = playerNames("Player 2"), token = player2Token, score = 0, colour = "#D60BA8")

    var otherPlayer = player2
    var currentPlayer = player1

    createBoxes()

    println("──────────────────────────────")
    println("Hello ${player1.name} & ${player2.name}!")
    println("${player1.name.col(player1.colour)} will play as ${player1.token.col(player1.colour)}")
    println("${player2.name.col(player2.colour)} will play as ${player2.token.col(player2.colour)}")

    println("")

    showBoxes(player1, player2)
    while (player1.score < winScore && player2.score < winScore) {
        var scoreAdd = 0
        // Code for player turn
        playTurn(currentPlayer, otherPlayer)
        checkBoxesForPushToken(currentPlayer, otherPlayer)
        scoreAdd += checkBoxesForChain(currentPlayer)

        // Code to switch player
        if (currentPlayer == player1) {
            currentPlayer.score += scoreAdd

            currentPlayer = player2
            otherPlayer = player1
        } else {
            currentPlayer.score += scoreAdd

            currentPlayer = player1
            otherPlayer = player2
        }

        showScore(player1, player2)
        showBoxes(player1, player2)

        checkForPlayerWin(player1)
        checkForPlayerWin(player2)
    }

}

// Function for adding the boxes to the boxes list
fun createBoxes() {

    // Sets the list to be clear for a new game
    boxes.clear()

    // Adds the empty values for boxes
    repeat(numBoxes) {
        boxes.add("-")
    }
}

// Function for displaying the contents of the box list
fun showBoxes(player1: Player, player2: Player) {

    // Returns if list is empty in order to not print only ending and starting segments of boxes
    if (boxes.isEmpty()) return

    // Prints the top section of boxes
    print("┌")
    repeat(boxes.size - 1) {
        print("───┬")
    }
    println("───┐")

    // Prints the middle section of boxes
    for (i in boxes) {
        print("│")
        when (i) {
            player1.token -> print(" $i ".col(hex = player1.colour))
            player2.token -> print(" $i ".col(hex = player2.colour))
            else -> print(" $i ".padEnd(3))
        }
    }
    println("│")

    // Prints the bottom section of boxes
    print("└")
    repeat(boxes.size - 1) {
        print("───┴")
    }
    println("───┘")

    for (i in 1..<numBoxes) {
        print("  $i".padEnd(4))
    }
    println("  $numBoxes")

}

// Function for getting player's names
fun playerNames(currentPlayer: String): String {
    var playerInput: String?

    while (true) {
        print("$currentPlayer name: ")
        playerInput = readlnOrNull()

        if (playerInput == null) {
            println("Player name cannot be null".red())
        } else if (playerInput.length > 14) {
            println("Player name too long".red())
        } else return playerInput
    }
}

// Function for getting the input for the player's turn & asking what square they would like to put their peice in
fun playTurn(
    currentPlayer: Player,
    otherPlayer: Player
) {

    while (true) {

        print("${currentPlayer.name}'s".col(hex = currentPlayer.colour) + " turn please select what square you would like to place your token in (1-${boxes.size}): ")
        val turn = readln().toIntOrNull()

        when {
            turn == null -> println("Invalid input".red())
            turn > numBoxes -> println("Position does not exist (value too high)".red())
            turn < 1 -> println("Position does not exist (value too low)".red())
            // Need to check that...
            turn in 2..<boxes.size - 1 && boxes[turn] == otherPlayer.token && boxes[turn - 2] == otherPlayer.token -> println(
                "Invalid Spot".red()
            )
            // Only make move if blank
            boxes[turn - 1] == "-" -> {
                boxes[turn - 1] = currentPlayer.token
                println()
                break
            }

            else -> println("Invalid Spot".red())

        }
    }
}

// Function for checking whether a player has pushed another player's token out
fun checkBoxesForPushToken(
    currentPlayer: Player,
    otherPlayer: Player
) {
    for (i in 1..<boxes.size - 1) {
        if (boxes[i] == otherPlayer.token && boxes[i - 1] == currentPlayer.token && boxes[i + 1] == currentPlayer.token) {
            println(
                "${currentPlayer.name.col(currentPlayer.colour)} pushes out one of ${
                    otherPlayer.name.col(
                        otherPlayer.colour
                    )
                }'s tokens"
            )
            boxes[i] = "-"
        }
    }
}

// Checks whether the player has formed a chain and returns the value of how much score to add to the player
fun checkBoxesForChain(currentPlayer: Player): Int {
    var inChain = false
    var startPosition = -1
    var currentChainLeng = 0
    var biggestChainLeng = 0
    var playerScoreAdd = 0
    val minChainLeng = 3

    for (i in 0..<boxes.size) {
        // If the biggest detected chain is bigger than minimum chain length break out of the loop (as only one chain can be formed at once)
        if (biggestChainLeng >= minChainLeng) {
            break
        }
        // Check if the player is not and a chain and if they are not currently in a chain (then start a chain if true)
        else if (boxes[i] == currentPlayer.token && !inChain) {
            inChain = true
            currentChainLeng = 1
            startPosition = i
        }
        // If last square of boxes is the players token sets the current chain length + 1 to be the biggest chain length
        else if (i == boxes.size - 1 && boxes[i] == currentPlayer.token) {
            biggestChainLeng = currentChainLeng + 1
        }
        // If last square of boxes is not the players token sets the current chain length to be the biggest chain length
        else if (i == boxes.size - 1 && boxes[i] != currentPlayer.token) {
            biggestChainLeng = currentChainLeng
        }
        // Adds one to chain length if player is in a chain and current token in the players token
        else if (boxes[i] == currentPlayer.token && inChain) {
            currentChainLeng++
        }
        // If player is in a chain and the token is not theirs set them to not be in a chain and set the biggest chain to be current chain length
        else if (boxes[i] != currentPlayer.token && inChain) {
            inChain = false
            biggestChainLeng = currentChainLeng
            currentChainLeng = 0
        }
    }

    // If the biggest chain length is more than the minimum chain length add that value to player score and reset the tokens in the chain
    if (biggestChainLeng >= minChainLeng) {
        playerScoreAdd = biggestChainLeng
        boxes[startPosition] = "-"
        for (i in 1..<biggestChainLeng) {
            boxes[startPosition + i] = "-"
        }
    }

    return playerScoreAdd
}

fun showScore(player1: Player, player2: Player) {
    println("Scores")
    print("┌────────────────────┐")
    println("┌────────────────────┐")

    print("│")
    print(" ${player1.name} : ${player1.score.toString().padEnd(16 - player1.name.length).col(hex = player1.colour)}")
    print("│")

    print("│")
    print(" ${player2.name} : ${player2.score.toString().padEnd(16 - player2.name.length).col(hex = player2.colour)}")
    println("│")
    print("└────────────────────┘")
    println("└────────────────────┘")
}

fun checkForPlayerWin(currentPlayer: Player) {
    if (currentPlayer.score >= winScore) {
        println("")
        println("${currentPlayer.name.col(hex = currentPlayer.colour)} Wins!")
        println("")
    }
}