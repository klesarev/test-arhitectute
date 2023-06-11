package framework

import core.CoreTest
import core.services.DatabaseService
import framework.gateway.MockDBService
import framework.loaders.PropertiesLoader
import kotlin.test.AfterTest
import kotlin.test.BeforeTest

open class BaseTest: CoreTest(settings = PropertiesLoader()) {

    protected val service: DatabaseService = MockDBService()

    @BeforeTest
    fun loadServices(){
        service.connect(properties["host"] as String)
    }

    @AfterTest
    fun terminate(){
        // function for close services
        service.closeConnection()
    }
}