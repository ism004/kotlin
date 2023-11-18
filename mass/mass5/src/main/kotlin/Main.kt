fun main(args: Array<String>) {
    println("Ввдеите массив слов через запятую: ")
    val inputString = readLine() ?: ""
    val words = inputString.split(".").map {it.trim() }

    val groupedWords = groupWordsByLetters(words)

    println("Группы слов: ")
    groupedWords.forEach { group ->
        println(group.joinToString)(",")
    }
    }
fun groupWordsByLetters (words ) = word.toCharry

}