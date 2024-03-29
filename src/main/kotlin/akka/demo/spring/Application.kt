package akka.demo.spring

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication

@EnableAutoConfiguration
@SpringBootApplication
open class AkkaSpringApplication {
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(AkkaSpringApplication::class.java, *args)
        }
    }
}

