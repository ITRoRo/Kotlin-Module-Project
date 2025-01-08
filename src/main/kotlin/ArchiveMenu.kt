import java.util.Scanner

class ArchiveMenu {
    val archives: MutableList<Archive> = mutableListOf()

    fun newArh(arh: Archive) {
        if (arh.name.isBlank()) {
            println("Введите название архива!")
            return
        }
        archives.add(arh)
        println("Архив '${arh.name}' успешно добавлен в хранилище.")
    }

    fun oldArh() {
        while (true) {
            if (archives.isEmpty() == true) {
                println("Ни одного архива не найдено!")
                break
            } else println(" \nВыберите архив из списка\nДля для создания нового архива нажмите: '+'\nДля выходы в предыдущее меню нажмите: '-' ")
            println("СПИСОК АРХИВОВ:")

            archives.forEach { println("${archives.indexOf(it) + 1} ${it.name}") }
            var scan = Scanner(System.`in`).nextLine()
            when (scan) {
                in (1..archives.size).toString() -> archives[scan.toInt() - 1].oldNote()
                "+" -> {
                    println("Введите название нового архива:")
                    newArh(Archive(Scanner(System.`in`).nextLine()))
                }

                "-" -> return
                else -> println("Такого архива не существует. Попробуйте снова.")
            }
        }
    }
}