fun main() {
    print("Введите строку: ")
    val str = readLine() ?: ""
    println()
    val unicChars = str.toCharArray().distinct().sorted()

    for (char in unicChars) {
        val count = str.count {it == char}
        println("$char - $count")
    }
}