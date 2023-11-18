fun main() {
    val alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЬЫЪЭЮЯ"
    print("Введите ключевое слово: ")
    val keyword = readLine()?.toUpperCase() ?: ""

    print("Введите текст для шифровки/дешифровки: ")
    val inputText = readLine()?.toUpperCase() ?: ""

    print("Выберите действия (1- Зашифровка, 2 - Расшифровка): ")
    val action = readLine()?.toIntOrNull() ?: 0

    val keywordIndexes = keyword.map { alphabet.indexOf(it) + 1 }

    val result = when (action) {
        1 -> processText(inputText, keywordIndexes, alphabet) { it.first + it.second }
        2 -> processText(inputText, keywordIndexes, alphabet) { it.first - it.second }
        else -> "Некорректное действие. "
    }

    println("Результат: $result")
}

fun processText(text: String, keywordIndexes: List<Int>, alphabet: String, operation: (Pair<Int, Int>) -> Int): String {
    val result = StringBuilder()

    for ((index, char) in text.withIndex()) {
        val alphabetIndex = alphabet.indexOf(char)
        val keywordIndex = keywordIndexes[index % keywordIndexes.size]
        val newIndex = (alphabetIndex + keywordIndex + alphabet.length) % alphabet.length
        result.append(alphabet[newIndex])
    }
    return result.toString()

}