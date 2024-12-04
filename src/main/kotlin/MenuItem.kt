import java.util.*

abstract class MenuItem {
    var list: MutableList<MenuItem> = mutableListOf()
    protected val scanner: Scanner = Scanner(System.`in`)

    open val menuTitle: String = ""
    open val menuItemName: String = ""

    fun touch() {
        screenMenu()
        functionMenu()
    }

    protected open fun screenMenu() {
        println("\n$menuTitle меню выбора:\n")
        println("1. Создать ${menuItemName} с заметками")
        println("2. Список  ${menuItemName}ов с заметками")
        println("3. Выбрать ${menuItemName} с заметками")
        println("4. Выход\n")

    }

    protected open fun functionMenu() {
        while (true) {
            scanner.nextLine().toIntOrNull()
                ?.let { value ->
                    when (value) {
                        1 -> add()
                        2 -> show()
                        3 -> select()
                        4 -> return
                        else -> println("Некорректный ввод")
                    }
                    screenMenu()
                }
                ?: println("Некорректный ввод")
        }
    }

    abstract fun add()

    abstract fun select()

    abstract fun show()

    protected fun getText(): String? {
        var data: String? = null
        while (scanner.hasNext()) {
            data = scanner.nextLine()
            return data.ifEmpty { null }
        }
        return null
    }

    protected fun getIndex(): Int? {
        getText()
            ?.toIntOrNull()
            ?.let { index ->
                if ((index > 0) && (index <= list.size)) {
                    return index - 1
                } else {
                    return null
                }
            }
            ?: return null
                ?: return null
    }

    protected fun addItem(item: MenuItem) {
        list.add(item)
    }

    protected fun selectItem(index: Int) {
        list.elementAt(index).touch()
    }

    protected fun showItems() {
        var index: Int = 0
        if(list.size == 0) {
            println("Список пуст\n")
        } else {
            for (item in list)
                println("   ${++index}: $item")
        }
    }
}