import kotlin.random.Random

fun main() {
    println("Добро пожаловать в игру Камень-Ножницы-Бумага!")
    println("1 - Камень, 2 - Ножницы, 3 - Бумага")

    print("Ваш выбор: ")
    val playerChoice = readLine()?.toIntOrNull()
    if (playerChoice in 1..3) {
        val computerChoice = Random.nextInt(1, 3)
        println("Выбор компьютера: $computerChoice")

        val result = when {
            playerChoice == computerChoice -> "Ничья"
            (playerChoice == 1 && computerChoice == 2) ||
                    (playerChoice == 2 && computerChoice == 3) ||
                    (playerChoice == 3 && computerChoice == 1) -> "Вы победили"

            else -> "Компьютер победил"
        }

        println(result)
    } else {
        println("Некорректный ввод. Пожалуйста, выберите число от 1 до 3.")
    }

}