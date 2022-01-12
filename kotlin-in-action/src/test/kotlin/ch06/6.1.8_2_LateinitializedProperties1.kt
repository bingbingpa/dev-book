package ch06.ex1_8_2_LateinitializedProperties1

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MyService {
    fun performAction(): String = "foo"
}

class MyTest {
    private lateinit var myService: MyService

    @BeforeEach fun setUp() {
        myService = MyService()
    }

    @Test fun testAction() {
        assertEquals("foo", myService.performAction())
    }
}
