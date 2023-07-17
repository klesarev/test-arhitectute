import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.logging.*

fun main(args: Array<String>) {
    Box()

}

enum class LogColor(val color: String) {
    ANSI_RESET ("\u001B[0m"),
    ANSI_BLACK ("\u001B[30m"),
    ANSI_RED ("\u001B[31m"),
    ANSI_GREEN ("\u001B[32m"),
    ANSI_YELLOW ("\u001B[33m"),
    ANSI_BLUE ("\u001B[34m"),
    ANSI_PURPLE ("\u001B[35m"),
    ANSI_CYAN ("\u001B[36m"),
    ANSI_WHITE ("\u001B[37m")

}

class LoggerFormatter : Formatter() {
    override fun format(record: LogRecord?): String {
        val sb = StringBuilder()
        val current = LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        )

        sb.apply {
            append(LogColor.ANSI_GREEN.color)
            append("[$current ${record!!.sourceClassName}.class]")
            append(LogColor.ANSI_GREEN.color)
            append(" - ${record.message}")
        }

        return sb.toString()
    }

}

class Box {

    val logger = Logger.getLogger(this::class.simpleName)

    init {
        println("init")
        
        logger.useParentHandlers = false;

        val handler = ConsoleHandler()
        handler.formatter = LoggerFormatter()

        logger.addHandler(handler)

        logger.log(Level.WARNING, "ll")
    }
}

