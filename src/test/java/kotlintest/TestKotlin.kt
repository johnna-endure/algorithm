package kotlintest

import org.junit.Test

class TestClass {
    @Test
    fun testString() {
        val a = "1234"
        for (i in a.length - 1 downTo 0) {
            println(a[i])
        }
    }
}
