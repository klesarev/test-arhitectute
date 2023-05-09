package entity.tests

import core.BaseTest
import framework.MockDBService
import framework.PropertiesLoader
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class DemoTest: BaseTest(
    settings = PropertiesLoader(),
    dbService = MockDBService()
) {

    @Test
    fun `demo test func`(){
        val props = PropertiesLoader().loadParameters("application.properties")
        assertEquals(props["debug"], "false")
        println(properties)
    }

    @Test
    fun `get data from DB`(){
        service.connect("https://sqliteonline.com/")
        val result = service.selectQuery("select * from test")
        assertEquals(result[0]["status"], "active")
    }

}