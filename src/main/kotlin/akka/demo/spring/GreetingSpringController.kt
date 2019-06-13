package akka.demo.spring

import akka.demo.spring.Greeting
import org.springframework.web.bind.annotation.GetMapping
import java.util.concurrent.atomic.AtomicLong
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController {

    val counter = AtomicLong()

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) =
        Greeting(counter.incrementAndGet(), "Hello, $name")

}