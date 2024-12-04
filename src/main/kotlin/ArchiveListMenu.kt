class ArchiveListMenu : MenuItem() {
    override val menuTitle: String = "Архивы заметок,"
    override val menuItemName: String = "архив"



    override fun add() {
        println("Введите название архива для заметок")
        getText()
            ?.let { title ->
                addItem(ArchiveMenu(title))
                println("Создан архив \"$title\"")
            }
            ?: println("Некорректный ввод названия архива")
    }

    override fun select() {
        println("Введите индекс архива")
        if(list.size == 0){
            println("У вас нет созданных архивов с заметками")
        } else {
            getIndex()
                ?.let { index -> selectItem(index) }
                ?: println("Введен неверный индекс")
        }

    }

    override fun show() {
        println("Архивы:")
        showItems()
    }
}