package entity.tests

import core.BaseTest
import framework.PropertiesLoader
import kotlin.test.Test
import kotlin.test.assertEquals

class DemoTest {

    @Test
    fun `demo test func`(){
        val props = PropertiesLoader().loadParameters("application.properties")
        assertEquals(props["debug"], "false")
    }

}