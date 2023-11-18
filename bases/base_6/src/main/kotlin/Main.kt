fun main(args: Array<String>) {
    println("Введите первую цифру: ")
    val digit1 = readLine()?.toIntOrNull()

    print("Введите вторую цифру (не повторяйте с первой): ")
    val digit2 = readLine()?.toIntOrNull()

    if (digit1 != null && digit2 != null && digit1 !=digit2) {
        val result = digit1 + digit2

        if (result % 2 != 0) {
            println("Результат: $result (нечётное число)")
        } else {
            println("Создать нечётное число невозможно.")
        }
    } else {
        println("Некорректный ввод. Введите две различные цифры.")
    }
}