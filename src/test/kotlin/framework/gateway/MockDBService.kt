package framework.gateway

import core.services.DatabaseService
import java.util.logging.Level
import java.util.logging.Logger

class MockDBService: DatabaseService {

    private val logger = Logger.getLogger(this::class.simpleName)

    override fun connect(connectionString: String) {
        logger.log(Level.INFO, "Connected to $connectionString with [${this::class.simpleName} class]")
    }

    override fun selectQuery(queryString: String, closable: Boolean): List<HashMap<String, Any>> {
       return listOf(hashMapOf("status" to "active"))
    }

    override fun updateQuery(queryString: String): Boolean {
        return true
    }

    override fun closeConnection() {
        logger.log(Level.INFO, "Closed connection with [${this::class.simpleName} class]")
    }
}