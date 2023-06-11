package entity.tests

import framework.BaseTest
import kotlin.test.Test
import kotlin.test.assertEquals

class DemoTest: BaseTest() {

    @Test
    fun `demo test func`(){
        assertEquals(properties["debug"], "false")
        println(properties)
    }

    @Test
    fun `get data from DB`(){
        val result = kotlin.run {
            service.selectQuery("select * from test")
        }
        assertEquals(result[0]["status"], "active")
    }

}