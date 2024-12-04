class ArchiveMenu(val name: String) : MenuItem() {
    override val menuTitle: String = "Архив $name"
    override val menuItemName: String = "замет"

    override fun screenMenu() {
        println("\n$menuTitle меню выбора:\n")
        println("1. Создать ${menuItemName}ку")
        println("2. Список  ${menuItemName}ок")
        println("3. Выбрать ${menuItemName}ку")
        println("4. Выход\n")
    }

    override fun add() {
        println("Введите название заметки")
        getText()
            ?.let { title ->
                addItem(NoteMenu(title))
                println("Создана заметка \"$title\"")
            }
            ?: println("Неверное название заметки")
    }

    override fun select() {
        if(list.size == 0) {
            println("Заметок не создано\n")
        } else {
            println("Введите индекс заметки")
            getIndex()
                ?.let { index -> selectItem(index) }
                ?: println("Такого индекса заметки не существует")
        }

    }

    override fun show() {
        println("Заметка:")
        showItems()
    }
}