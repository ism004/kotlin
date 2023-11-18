fun main() {

    println("Введите строку символов: ")
    val str = readln()
    println()
    var currentChar: Char? = null
    var count = 0

    for (char in str) {
        if (char == currentChar) {
            count ++
        } else {
            if (count > 1) {
                print("$currentChar$count")
            } else if (count == 1) {
                print("$currentChar")
            }
            currentChar = char
            count = 1
        }
    }
    if (count > 1) {
        print("$currentChar$count")
    } else if (count == 1) {
        print("$currentChar")
    }
}