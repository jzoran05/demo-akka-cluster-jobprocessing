package akka.demo

import akka.actor.ActorSystem
import akka.actor.Props
import akka.cluster.Cluster
import akka.cluster.ClusterEvent
import akka.management.cluster.bootstrap.ClusterBootstrap
import akka.management.javadsl.AkkaManagement

/*
Custom class to abstract and encapsulate initialization of Akka Cluster.
Use the interface in various hosts (e.g. console, springboot, etc) to initialize the Akka Cluster and Akka System
 */
class AkkaCluster(akkaClusterName: String) {

    var cluster: Cluster? = null
    var system: ActorSystem? = null

    init {
        system = ActorSystem.create(akkaClusterName)
        cluster = Cluster.get(system)

        system?.log()?.info("Started [$system], cluster.selfAddress = $cluster.selfAddress()")

        //#start-akka-management
        AkkaManagement.get(system).start()

        //#start-akka-management
        ClusterBootstrap.get(system).start()

        cluster?.subscribe(system?.actorOf(Props.create(ClusterWatcher::class.java)),
            ClusterEvent.initialStateAsEvents(),
            ClusterEvent.ClusterDomainEvent::class.java)

        cluster?.registerOnMemberUp { system?.log()?.info("Cluster member is up!") }
    }


}