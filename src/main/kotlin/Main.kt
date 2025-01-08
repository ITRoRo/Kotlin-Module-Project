import java.util.Scanner


fun main() {
    val archiveMenu = ArchiveMenu()
    while (true) {
        println("ВЫБЕРИТЕ ДЕЙСТВИЕ: \n1 - Создать архив. \n2 - Открыть имеющийся архив. \n3 - Выход.")
        when (Scanner(System.`in`).nextLine()) {
            1.toString() -> {
                println("Введите название нового архива:")
                archiveMenu.newArh(Archive(Scanner(System.`in`).nextLine()))
            }

            2.toString() -> archiveMenu.oldArh()
            3.toString() -> {
                println("Программа завершина.")
                break
            }

            else -> println("\nНеверный ввод!\nПопробуйте снова\n")
        }
    }
}

