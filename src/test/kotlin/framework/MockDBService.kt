package framework

import core.services.DatabaseService

class MockDBService: DatabaseService {
    override fun connect(connectionString: String) {
        println("Connected to $connectionString with [${this::class.simpleName} class]")
    }

    override fun selectQuery(queryString: String, closable: Boolean): List<HashMap<String, Any>> {
       return listOf(hashMapOf("status" to "active"))
    }

    override fun updateQuery(queryString: String): Boolean {
        return true
    }

    override fun closeConnection() {
        println("Closed connection with [${this::class.simpleName} class]")
    }
}