/*
 * Copyright (C) 2017 Lightbend Inc. <http://www.lightbend.com>
 */
package akka.demo

class DemoApp {

    init {

        val akkaCluster = AkkaCluster("akkajobcluster")

    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            DemoApp()
        }
    }
}

