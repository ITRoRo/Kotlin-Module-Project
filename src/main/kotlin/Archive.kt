import java.util.Scanner

class Archive(val name: String) {
    val notes: MutableList<Note> = mutableListOf()
    fun oldNote() {
        while (true) {
            println("Содержимое архива: $name")
            if (notes.isEmpty() == true) {
                println("В этом архиве еще нет заметок!\nДля создания заметки нажмите '+' \nДля выхода нажмите '-'")
                while (true) {
                    when (Scanner(System.`in`).nextLine()) {
                        "+" -> {
                            println("Введите название новой заметки:")
                            newNote()
                            break
                        }

                        "-" -> return
                        else -> println("Неверный ввод, попробуйте снова")
                    }
                }
            }

            println(" \nВыберите заметку из списка\nДля выходы в предыдущее меню нажмите: -\nДля для создания новой заметки нажмите + ")
            println("СПИСОК ЗАМЕТОК:")

            notes.forEach { println("${notes.indexOf(it) + 1} ${it.name}") }
            var scan = Scanner(System.`in`).nextLine()
            when (scan) {
                "+" -> {
                    println("Введите название новой заметки:")
                    newNote()
                }

                in (1..notes.size).toString() -> notes[scan.toInt() - 1].contentsNote()
                "-" -> return
                else -> println("Такой заметки не существует. Попробуйте снова.")
            }
        }
    }

    fun newNote() {
        var nameNote = ""
        while (nameNote.isBlank()) {
            nameNote = readLine().orEmpty()
            if (nameNote.isBlank()) {
                println("Требуется заполнить название")
            }
        }

        println("Введите текст заметки: ")
        var textNote = ""
        while (textNote.isBlank()) {
            textNote = Scanner(System.`in`).nextLine()
            if (textNote.isBlank()) {
                println("Требуется заполнить текст заметки.")
            }
        }

        notes.add(Note(nameNote, textNote))
        println("Новая заметка: '${nameNote}'")

    }
}