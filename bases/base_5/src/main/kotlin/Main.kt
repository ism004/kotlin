fun main() {
    println("Введите целое число n: ")
    val n = readLine()?.toIntOrNull()

    println("Введите основание степени x: ")
    val x = readLine()?.toIntOrNull()

    if (n != null && x != null && x > 1) {
        var exponent = 0
        var result = 1

        while (result < n) {
            exponent++
            result *= x

            if (result == n) {
                println("Целочисленный показатель степени: $exponent")
                return
            }
        }

        println("Целочисленный показатель не существует.")
    } else {
        println("Некорректный ввод. Введите целые числа n > 0 и x > 1.")
    }
}