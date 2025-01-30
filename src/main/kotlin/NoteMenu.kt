class NoteMenu(val title: String, private var content: String = "") : MenuItem() {

    override fun toString(): String {
        return "Название заметки: $title\n" +
                "Текст заметки: $content"
    }

    override fun screenMenu() {
        println("\nНазвание заметки: $title")
        println("1. Просмотр заметки")
        println("2. Создать текст заметки")
        println("3. Выход")
    }

    override fun functionMenu() {
        while (true) {
            scanner.nextLine().toIntOrNull()
                ?.let { value ->
                    when (value) {
                        1 -> show()
                        2 -> add()
                        3 -> return
                        else -> println("Некорректный ввод")
                    }
                    screenMenu()
                }
                ?: println("Некорректный ввод")
        }
    }

    override fun add() {
        println("Напишите текст заметки")
        getText()?.let { text -> content = text }
    }

    override fun select() {}

    override fun show() {
        println(this)
    }
}