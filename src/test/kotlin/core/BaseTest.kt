package core

import core.loaders.EnvironmentLoader
import core.services.DatabaseService
import kotlin.test.AfterTest

abstract class BaseTest (
    private val settings: EnvironmentLoader,
    private val dbService: DatabaseService
) {

    /**
     * Settings from EnvironmentLoader
    */
    val properties: HashMap<String, String> get() = settings.loadParameters()

    val service: DatabaseService get() = dbService

    @AfterTest
    fun terminate(){
        // function for close services
    }
}