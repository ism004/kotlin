fun main() {
    print("Введите количество строк в массиве: ")
    val rows = readLine()?.toIntOrNull()?: 0
    print("Введите количество столбцов в массиве: ")
    val columns = readLine()?.toIntOrNull()?: 0

    if (rows <= 0 || columns <= 0) {
        println("Некоректный ввод размеров массива.")
        return
    }

    val matrix = Array (rows) {IntArray(columns) }

    println("Введите трёхзначные числа: ")

    val digitSet = mutableSetOf<Int>()

    for (i in 0 until rows) {
        for (j in 0 until columns) {
            print("[$i][$j]: ")
            val number = readLine()?.toIntOrNull() ?: 0
            matrix[i][j] = number

            val digits = number.toString().toCharArray().map { it.toString().toInt() }
            digitSet.addAll(digits)
        }
    }
    println("Двумерный массив:")

    for (row in matrix) {
        for (element in row) {
            print("$element\t")
        }
        println()
    }
    println("В массиве использовано ${digitSet.size} различных цифр.")
}