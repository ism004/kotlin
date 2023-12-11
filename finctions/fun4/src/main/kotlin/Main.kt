fun main() {
    // Определение алфавита для шифрования
    val alphabet = "?АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ ?"
    val alphabetsArray = alphabet.toCharArray()

    // Коды символов в алфавите
    val codesArray = arrayOf(
        0, 69, 13, 38, 14, 24, 71, 7, 16, 64, 10, 29, 39, 27, 57, 94, 26, 42, 46, 54, 23, 3, 8,
        5, 12, 6, 4, 1, 15, 13, 2, 5, 17, 146, 0
    )

    val alphabetLength = alphabet.length

    // Создание массива changedCodesArray для хранения измененных кодов символов
    val changedCodesArray = Array(alphabetLength) { i -> i.toInt() }
    for (i in 0 until alphabetLength) changedCodesArray[i] = codesArray[i]

    // Суммирование значений changedCodesArray
    var sum = 0
    for (i in 0 until alphabetLength) {
        changedCodesArray[i] += sum
        sum = changedCodesArray[i]
    }

    // Создание двумерного массива encryptedTable для хранения кодированных символов
    val encryptedTable = Array(alphabetLength) { IntArray(150) }

    // Функция getLetterCode возвращает код символа из алфавита
    fun getLetterCode(letter: Char): Int {
        var code = alphabetsArray.indexOf(letter)
        if (code == -1) return 0
        if (changedCodesArray[code] == 0) return 1
        return changedCodesArray[code]
    }

    // Функция getLetterNumber возвращает позицию символа в алфавите
    fun getLetterNumber(letter: Char): Int {
        var code = alphabetsArray.indexOf(letter)
        if (code == -1) return 0
        return code
    }

    // Функция getLetterCodePercent возвращает код символа по таблице Виженера
    fun getLetterCodePercent(letter: Char): Int {
        var code = alphabetsArray.indexOf(letter)
        if (code == -1) return 0
        return codesArray[code]
    }

    // Функция getCodeToLetter возвращает символ по коду из таблицы Виженера
    fun getCodeToLetter(code: Int): Char {
        var index = 0
        while (index < 32) {
            if (changedCodesArray[index] < code && changedCodesArray[index + 1] > code) break
            index++
        }
        if (index == alphabetLength - 1) return '?'
        return alphabetsArray[index + 1]
    }

    // Запрос пользователю для выбора шифрования или дешифрования
    println("Введите\n1, чтобы зашифровать текст,\n2, чтобы дешифровать")
    var decision = readln()

    if (decision == "1") {
        // Шифрование текста
        println("Введите слово")
        var word = readln()
        word = word.uppercase()

        var current = 0
        println("Закодированная строка")
        for (i in 0 until word.length) {
            if (word[i] == 'Ё') word = word.replace('Ё', 'Е')
            current = getLetterCode(word[i])
            if (getLetterCodePercent(word[i]) > 0) current -= (1..getLetterCodePercent(word[i])).random()

            encryptedTable[getLetterNumber(word[i])][i] = current

            if (current < 10) print("00$current ")
            else if (current < 100) print("0$current ")
            else print("$current ")
        }
        println("\nШифровальная таблица")
        var exists = false
        for (i in 0 until alphabetLength) {
            // Проверка на наличие значения в ячейках
            for (j in 0 until 150)
                if (encryptedTable[i][j] > 0) {
                    exists = true
                    break
                }

            if (exists) {
                if (alphabetsArray[i] == ' ') print("Пробел")
                if (alphabetsArray[i] == 'Е') print("Ё, ")
                print(alphabetsArray[i])
                print(" ")
                for (j in 0 until 150)

                    if (encryptedTable[i][j] > 0) {
                        current = encryptedTable[i][j]
                        if (current < 10) print("00$current ")
                        else if (current < 100) print("0$current ")
                        else print("$current ")
                    }
                //Затем выводится символ alphabetsArray[i].
                //  - Затем происходит цикл, который перебирает значения в таблице encryptedTable[i].
                //  - Если текущее значение encryptedTable[i][j] больше 0, то присваивается переменной current.
                //  - Затем осуществляется проверка значения current и, в зависимости от его длины, выводятся соответствующие добавочные нули и само значение current.
                println()
            }
            exists = false
        }//выводит каждую строку в зашифрованной таблице, если в строке есть коды символов, и пропускает пустые строки, в которых отсутствуют значения
    } else {
        // Дешифрование текста
        println("Введите код")
        var codeString = readln()
        val codesArray = codeString.split(' ')
        var temp = 0

        println("Исходная строка")
        for (i in 0 until codesArray.size) {
            temp = codesArray[i].toInt()
            print(getCodeToLetter(temp))
        }
    }
    println()
    return
}