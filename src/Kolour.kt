/***************************************************************************************
 * Console Colours for Kotlin
 * Steve Copley 2022
 * https://github.com/stevecopley/kotlin-kolour
 ***************************************************************************************/


// Styles
//--------------------------------------------------------------------------------------
fun String.bold() = "\u001b[1m${this}\u001b[0m"
fun String.italic() = "\u001b[3m${this}\u001b[0m"
fun String.underline() = "\u001b[4m${this}\u001b[0m"

// Foreground Colours
//--------------------------------------------------------------------------------------
fun String.normal() = "${this}\u001b[0m"
fun String.white() = "\u001b[37m${this}\u001b[0m"  // White is essentially grey, so...
fun String.grey() = "\u001b[37m${this}\u001b[0m"   // ... I've also called it grey here!
fun String.black() = "\u001b[30m${this}\u001b[0m"
fun String.red() = "\u001b[31m${this}\u001b[0m"
fun String.yellow() = "\u001b[33m${this}\u001b[0m"
fun String.green() = "\u001b[32m${this}\u001b[0m"
fun String.cyan() = "\u001b[36m${this}\u001b[0m"
fun String.blue() = "\u001b[34m${this}\u001b[0m"
fun String.magenta() = "\u001b[35m${this}\u001b[0m"

// Background Colours
//--------------------------------------------------------------------------------------
fun String.bgNone() = "${this}\u001b[0m"
fun String.bgBlack() = "\u001b[40m${this}\u001b[0m"
fun String.bgGrey() = "\u001b[47m${this}\u001b[0m"
fun String.bgRed() = "\u001b[41m${this}\u001b[0m"
fun String.bgYellow() = "\u001b[43m${this}\u001b[0m"
fun String.bgGreen() = "\u001b[42m${this}\u001b[0m"
fun String.bgCyan() = "\u001b[46m${this}\u001b[0m"
fun String.bgBlue() = "\u001b[44m${this}\u001b[0m"
fun String.bgMagenta() = "\u001b[45m${this}\u001b[0m"


// RGB colours, where each value is an Int from 0 to 255
//--------------------------------------------------------------------------------------
fun String.col(r: Int, g: Int, b: Int): String {
    val rValid = r.coerceIn(0, 255)
    val gValid = g.coerceIn(0, 255)
    val bValid = b.coerceIn(0, 255)
    return "\u001b[38;2;${rValid};${gValid};${bValid}m${this}\u001b[0m"
}

fun String.bgCol(r: Int, g: Int, b: Int): String {
    val rValid = r.coerceIn(0, 255)
    val gValid = g.coerceIn(0, 255)
    val bValid = b.coerceIn(0, 255)
    return "\u001b[48;2;${rValid};${gValid};${bValid}m${this}\u001b[0m"
}

// HSV colours, where each value is a Double from 0.0 to 1.0
//--------------------------------------------------------------------------------------
fun String.col(h: Double, s: Double, v: Double): String {
    // hsvToRgb coerces values to 0.0 to 1.0, so no need here
    val (r, g, b) = hsvToRgb(h, s, v)
    return this.col(r, g, b)
}

fun String.bgCol(h: Double, s: Double, v: Double): String {
    // hsvToRgb coerces values to 0.0 to 1.0, so no need here
    val (r, g, b) = hsvToRgb(h, s, v)
    return this.bgCol(r, g, b)
}

// Hex colours, where hex is a String of the form "#rrggbb" or "#rgb"
//--------------------------------------------------------------------------------------
fun String.col(hex: String): String {
    // hexToRgb checks for invalid hex strings, so no need here
    val (r, g, b) = hexToRgb(hex)
    return this.col(r, g, b)
}

fun String.bgCol(hex: String): String {
    // hexToRgb checks for invalid hex strings, so no need here
    val (r, g, b) = hexToRgb(hex)
    return this.bgCol(r, g, b)
}


// Hex string to RGB conversion, either #RRGGBB or #RGB
//--------------------------------------------------------------------------------------
private fun hexToRgb(hex: String): Triple<Int, Int, Int> {
    val fullHex = "#[0-9a-fA-F]{6}".toRegex()
    val shortHex = "#[0-9a-fA-F]{3}".toRegex()

    return if (fullHex.matches(hex))
        Triple(
            hex.substring(1, 3).toInt(16),
            hex.substring(3, 5).toInt(16),
            hex.substring(5, 7).toInt(16)
        )
    else if (shortHex.matches(hex))  // #69c is short for #6699cc, hence the repeat(2)s
        Triple(
            hex.substring(1, 2).repeat(2).toInt(16),
            hex.substring(2, 3).repeat(2).toInt(16),
            hex.substring(3, 4).repeat(2).toInt(16)
        )
    else
        throw RuntimeException("Hex to RGB conversion - Invalid Hex colour: $hex")
}


// HSV to RGB conversion, based on https://stackoverflow.com/questions/7896280/
//--------------------------------------------------------------------------------------
private fun hsvToRgb(hue: Double, saturation: Double, value: Double): Triple<Int, Int, Int> {
    val hueValid = hue.coerceIn(0.0, 1.0)
    val satValid = saturation.coerceIn(0.0, 1.0)
    val valValid = value.coerceIn(0.0, 1.0)

    val h = (hueValid * 6).toInt()
    val f = hueValid * 6 - h
    val p = (valValid * (1 - satValid) * 255).toInt()
    val q = (valValid * (1 - f * satValid) * 255).toInt()
    val t = (valValid * (1 - (1 - f) * satValid) * 255).toInt()
    val v = (valValid * 255).toInt()

    return when (h) {
        0 -> Triple(v, t, p)
        1 -> Triple(q, v, p)
        2 -> Triple(p, v, t)
        3 -> Triple(p, q, v)
        4 -> Triple(t, p, v)
        else -> Triple(v, p, q)
    }
}
