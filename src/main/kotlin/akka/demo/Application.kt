package akka.demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication

@EnableAutoConfiguration
@SpringBootApplication
open class BlogApplication {
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(BlogApplication::class.java, *args)
        }
    }
}

