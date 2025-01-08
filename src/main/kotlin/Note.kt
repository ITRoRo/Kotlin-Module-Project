import java.util.Scanner

class Note(val name: String, val text: String) {
    fun contentsNote() {
        println("Заметка: $name\nТекс заметки: $text \nДля выходы в предыдущее меню введите любой символ")
        Scanner(System.`in`).nextLine()
    }
}