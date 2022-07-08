package br.com.lambdateam.myinvest

import org.junit.Assert
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MyinvestApplicationTests {

	@Test
	fun testExample() {
		val result = (1 + 1) / 2
		Assert.assertEquals(1, result)
	}

}
