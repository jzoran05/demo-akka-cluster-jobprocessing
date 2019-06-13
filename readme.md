# Akka In Action - Cluster Sample in Kotlin

GitHub repo: akka-cluster-sample-distributedjob

- Convert Scala sample to Kotlin
- Use Akka Cluster Management (DNS or Kubernetes discovery)
- Build docker containers and publish to ACR
- Create Azure DevOps YAML Pipeline
- Create AKS cluster and deploy the Sample (by using Azure DevOps)


## Questions (internal)
- How to avoid creating different containers and be able to separate job processing (from example) on different nodes
  * How this should be designed from (event driven) DDD perspective (is Job separate aggregate / bounded context from workers? - I don't think so... This is generic Job->Worker hiearchy which could be translated to functional subdomain )
  * What is expected (in my opinion) is that I can spin multiple containers/nodes of the same (Micro)Service, an these instances could fan-out if needed additional Actors on different nodes for parallelize the processing
- Can Akka cluster partitioning (Partition points - actor system partitioned into actor subtrees located on different nodes)  

## History (newer on top)
- Added Springboot as an main entry point Actor host. Idea is to expose REST API and interact with Actors within the service 