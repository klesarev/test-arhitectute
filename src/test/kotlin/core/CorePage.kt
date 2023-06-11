package core

abstract class CorePage {

    abstract val pageUrl: String
    abstract fun loadPage()

}