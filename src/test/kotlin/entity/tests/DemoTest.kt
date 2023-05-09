package entity.tests

import core.BaseTest
import framework.MockDBService
import framework.PropertiesLoader
import kotlin.test.Test
import kotlin.test.assertEquals

class DemoTest: BaseTest(
    settings = PropertiesLoader(),
    dbService = MockDBService()
) {

    @Test
    fun `demo test func`(){
        assertEquals(properties["debug"], "false")
        println(properties)
    }

    @Test
    fun `get data from DB`(){
        val result = kotlin.run {
            service.connect("https://sqliteonline.com/")
            service.selectQuery("select * from test")
        }
        assertEquals(result[0]["status"], "active")
    }

}