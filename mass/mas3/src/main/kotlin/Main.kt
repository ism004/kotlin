import java.util.Scanner//Импортируется класс Scanner из пакета java.util, который позволяет считывать ввод с консоли

fun main() {
    val scanner = Scanner(System.`in`)

    val alphabet = arrayOf('а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л',
        'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш',
        'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я')//алфавит

    while (true) {//Запускается бесконечный цикл while для повторения программы до выбора операции выхода
        println("Выберите операцию:")
        println("1 - Зашифровать текст")
        println("2 - Расшифровать текст")
        println("0 - Выйти из программы")

        val operation = scanner.nextInt()//Считывается выбранная операция

        // Проверка условия выхода из программы
        if (operation == 0) {
            println("Программа завершена")
            break
        }

        scanner.nextLine() //  Очищается буфер чтения для предотвращения проблем со считыванием текста и ключевого слова

        println("Введите текст:")
        val text = scanner.nextLine().toLowerCase()//Считывается введенный текст и приводится к нижнему регистру

        println("Введите ключевое слово:")
        val keyword = scanner.nextLine().toLowerCase()//Считывается введенный текст и приводится к нижнему регистру

        var result = ""

        for (i in 0 until text.length) {//Проходится по каждому символу в тексте с помощью цикла for
            val char = text[i]

            if (char !in alphabet) {//Проверяется, является ли символ символом алфавита
                result += char//Если символ не является символом алфавита, он добавляется в результат без изменений
            } else {//Иначе, определяется индекс символа в алфавите и индекс ключевого слова для текущего символа
                val index = alphabet.indexOf(char)
                val keywordIndex = i % keyword.length//Вычисляется сдвиг (shift), который равен индексу символа ключевого слова плюс 1
                val shift = alphabet.indexOf(keyword[keywordIndex]) + 1

                val adjustedShift = if (operation == 1) shift else -shift // Определение сдвига в зависимости от операции

                val shiftedIndex = (index + adjustedShift + alphabet.size) % alphabet.size // Вычисление нового индекса символа

                result += alphabet[shiftedIndex] // Добавление зашифрованного или расшифрованного символа в результат
            }
        }

        println("Результат:")
        println(result)
    }
}