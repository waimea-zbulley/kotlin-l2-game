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


fun main() {
    println("Welcome to Chain Reaction!")
    println("--------------------------")

    getUserActionMenu()
}

fun getUserActionMenu(): Char {
    println("What would you like to do?")
    println("[R]ules")
    println("[P]lay game")
    println("[Q]uit")
    var choice: Char?

    while (true) {
        print(">")
        choice = readlnOrNull()?.first()?.uppercaseChar()

        if (choice != null && choice in "RPQ") {
            return choice
        }
    }
}
