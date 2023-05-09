package core.services

interface DatabaseService {
    fun connect(connectionString: String)
    fun selectQuery(queryString: String, closable: Boolean = false): List<HashMap<String, Any>>
    fun updateQuery(queryString: String): Boolean
    fun closeConnection()
}