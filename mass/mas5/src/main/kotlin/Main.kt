import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    // Ввод массива элементов
    println("Введите элементы массива через пробел:")
    val input = scanner.nextLine()
    val words = input.split(" ")

    // Создание словаря для хранения групп слов с одинаковыми буквами
    val wordGroups = mutableMapOf<String, MutableList<String>>()

    // Перебор каждого слова в массиве
    for (word in words) {
        // Создание "ключа" для группировки слов по составу букв (буквы отсортированы в алфавитном порядке для сравнения)
        val key = word.toCharArray().sorted().joinToString("")

        // Добавление слова в соответствующую группу в словаре
        if (wordGroups.containsKey(key)) {
            wordGroups[key]?.add(word)
        } else {
            wordGroups[key] = mutableListOf(word)
        }
    }

    // Вывод групп слов с одинаковыми буквами
    for (group in wordGroups.values) {
        println(group.joinToString(", "))
    }
}