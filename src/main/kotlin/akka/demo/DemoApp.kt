/*
 * Copyright (C) 2017 Lightbend Inc. <http://www.lightbend.com>
 */
package akka.demo

import akka.actor.ActorSystem
import akka.actor.Props
import akka.cluster.Cluster
import akka.cluster.ClusterEvent
import akka.http.javadsl.ConnectHttp
import akka.http.javadsl.Http
import akka.http.javadsl.server.AllDirectives
import akka.management.cluster.bootstrap.ClusterBootstrap
import akka.management.javadsl.AkkaManagement
import akka.stream.ActorMaterializer
import akka.stream.Materializer

class DemoApp  {

    init {
        val system = ActorSystem.create("akkajobcluster")
        val cluster = Cluster.get(system)

        system.log().info("Started [$system], cluster.selfAddress = $cluster.selfAddress()")

        //#start-akka-management
        AkkaManagement.get(system).start()

        //#start-akka-management
        ClusterBootstrap.get(system).start()

        cluster.subscribe(system.actorOf(Props.create(ClusterWatcher::class.java)),
                ClusterEvent.initialStateAsEvents(),
                ClusterEvent.ClusterDomainEvent::class.java)

        cluster.registerOnMemberUp { system.log().info("Cluster member is up!") }
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            DemoApp()
        }
    }
}

