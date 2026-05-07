/**
 * =====================================================================
 * Programming Project for NCEA Level 2, Standard 91896
 * ---------------------------------------------------------------------
 * Project Name:   Chain Reaction
 * Project Author: Zach Bulley
 * GitHub Repo:    https://github.com/waimea-zbulley/kotlin-l2-game
 * ---------------------------------------------------------------------
 * Notes:
 * PROJECT NOTES HERE
 * =====================================================================
 */

const val winScore = 10 // The score the player is required to reach in order to win
const val numBoxes = 12 // Max of 99 for proper formating. This is how many boxes for the playing area
val boxes = mutableListOf<String>() // The list for storing the values of the boxes

const val blankToken = "-" // Token to use for the blank space

/**
 * Data class for defining all the players variables/values.
 *  This is done to make the data regarding the player clearer
 */
data class Player(
    val token: String,
    var score: Int,
    val name: String,
    val colour: String
)

/**
 * Main function for introducing game name and checking user action.
 * This function used for calling the main game function or rules function (or quiting)
 */
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

/**
 *  Print's menu and get input for user choice on starting game/reading rules/ quiting
 *  I have used this function to get the users input for the main menu
 */
fun getUserActionMenu(): Char {
    println("What would you like to do?")
    println("[R]ules")
    println("[P]lay game")
    println("[Q]uit")
    var choice: Char?

    while (true) {
        // Getting players input
        print("Choice: ")
        choice = readlnOrNull()?.firstOrNull()?.uppercaseChar()

        //Error checking
        if (choice != null && choice in "RPQ") {
            return choice
        }
    }
}

/**
 * Function to show the rules of the game
 */
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

/**
 * Main game function for adding score and running all other functions related to the game.
 *  This function will run until one of the players win
 */
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
    // Main loop for the game (only runs while a player has not won)
    while (player1.score < winScore && player2.score < winScore) {
        var scoreAdd = 0
        // Code for player turn
        playTurn(currentPlayer, otherPlayer)
        checkBoxesForPushToken(currentPlayer, otherPlayer)
        scoreAdd += checkBoxesForChain(currentPlayer)

        // Code to switch player
        if (currentPlayer == player1) {
            currentPlayer.score += scoreAdd // Adds score to player

            currentPlayer = player2
            otherPlayer = player1
        } else {
            currentPlayer.score += scoreAdd // Adds score to player

            currentPlayer = player1
            otherPlayer = player2
        }

        showScore(player1, player2)
        showBoxes(player1, player2)

        checkForPlayerWin(player1)
        checkForPlayerWin(player2)
    }

}

/**
 *  Function for adding the boxes to the boxes list
 *  This sets up the list to be manipulated and shown
 */
fun createBoxes() {

    // Sets the list to be clear for a new game
    boxes.clear()

    // Adds the empty values for boxes
    repeat(numBoxes) {
        boxes.add(blankToken)
    }
}


/**
 *  Function for displaying the contents of the box list.
 *  This function reads the box lists the print's out the data in a readable form for the user to see.
 *  player1/2 are player objects - required to access the tokens/colour/name/score of the players.
 */
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

/**
 *  This gets the players names so that the players have names throughout the code
 *  currentPlayer is an object -  required to access the tokens/colour/name/score of the players
 */
fun playerNames(currentPlayer: String): String {
    var playerInput: String?
    val maxPlayerNameLeng = 14

    while (true) {
        // Getting player input
        print("$currentPlayer name: ")
        playerInput = readlnOrNull()

        // Error checking
        if (playerInput == null) {
            println("Player name cannot be null".red())
        } else if (playerInput.isBlank()) {
            println("Player name cannot be blank".red())
        }
        // Checking if player name is too long
        else if (playerInput.length > maxPlayerNameLeng) {
            println("Player name too long, please enter a name less than 15 characters.".red())
        } else return playerInput
    }
}

/**
 *  This function is for managing the players turn
 *  Gets the input for the player's turn & asking what square they would like to put their piece in
 *  Then manipulates the list to put the player's token in if the move is valid
 *  currentPlayer/otherPlayer are objects - required to access the tokens/colour/name/score of the players
 */
fun playTurn(
    currentPlayer: Player,
    otherPlayer: Player
) {

    while (true) {

        // Print's to asks player about their turn and reads their input
        print("${currentPlayer.name}'s".col(hex = currentPlayer.colour) + " turn please select what square you would like to place your token in (1-${boxes.size}): ")
        val turn = readln().toIntOrNull()

        when {
            turn == null -> println("Invalid input".red())

            // Error checking for values greater or less than the amount of boxes
            turn > numBoxes -> println("Position does not exist (value too high)".red())
            turn < 1 -> println("Position does not exist (value too low)".red())

            // Checks if the other player is blocking the spot
            turn in 2..<boxes.size - 1 && boxes[turn] == otherPlayer.token && boxes[turn - 2] == otherPlayer.token -> println(
                "Invalid Spot (${otherPlayer.name} is blocking you)".red()
            )
            // Only make move if blank
            boxes[turn - 1] == blankToken -> {
                boxes[turn - 1] = currentPlayer.token
                println()
                break
            }

            else -> println("Invalid Spot".red())
        }
    }
}

/**
 *  Function for checking whether a player has pushed another player's token out
 *  Then if the player has pushed out a token manipulates the list to remove that token
 */
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
            boxes[i] = blankToken
        }
    }
}

/**
 *  Checks whether the player has formed.
 *  If the player has formed a chain then removes the tokens from the list.
 *  Returns the amount of score to add to the player.
 *  currentPlayer is an object - required to access the tokens/colour/name/score of the current player.
 */
fun checkBoxesForChain(currentPlayer: Player): Int {
    var inChain = false // Whether the player is in a chain
    var startPosition = -1 // Invalid start position set in order to signify a chain has not yet started
    var currentChainLeng = 0 // Length of the current chain
    var biggestChainLeng = 0 // Length of the biggest chain
    var playerScoreAdd = 0 // The amount of score to add to the player
    val minChainLeng = 3 // The minimum length that a chain can be

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
        boxes[startPosition] = blankToken
        for (i in 1..<biggestChainLeng) {
            boxes[startPosition + i] = blankToken
        }
    }

    return playerScoreAdd // Returns the amount of score to add to the player
}

/**
 *  Shows the players scores is a readable format for the user.
 *  player1/2 are objects - required to access the tokens/colour/name/score of the players.
 */
fun showScore(player1: Player, player2: Player) {
    // Print's the top part of the boxes
    println("Scores")
    print("┌────────────────────┐")
    println("┌────────────────────┐")

    // Print's the middle part of the boxes
    print("│")
    print(" ${player1.name} : ${player1.score.toString().padEnd(16 - player1.name.length).col(hex = player1.colour)}")
    print("│")

    // Print's the bottom part of the boxes
    print("│")
    print(" ${player2.name} : ${player2.score.toString().padEnd(16 - player2.name.length).col(hex = player2.colour)}")
    println("│")
    print("└────────────────────┘")
    println("└────────────────────┘")
}

/**
 *  Checks if the player has won and print's if they have
 *  currentPlayer is an object - required to access the tokens/colour/name/score of the players
 */
fun checkForPlayerWin(currentPlayer: Player) {
    if (currentPlayer.score >= winScore) {
        println("")
        println("${currentPlayer.name.col(hex = currentPlayer.colour)} Wins!")
        println("")
    }
}