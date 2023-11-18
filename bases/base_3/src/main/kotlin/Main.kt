fun main() {
    print("Введите натуральное число в 10-ичной системе: ")
    val decimalNumber = readLine()?.toIntOrNull()
     if (decimalNumber != null && decimalNumber >= 0) {
         val binaryString = decimalToBinary(decimalNumber)
         println("Число $decimalNumber в двоичной системе: $binaryString")
     } else {
         println("Некорректный ввод. Введите натуральное число.")
     }
}

fun decimalToBinary(decimalNumber: Int): String {
    return Integer.toBinaryString(decimalNumber)
}