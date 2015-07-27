# adbrain.test.001

No lib directory committed as too many big jars  
Not a mvn or sbt project  
Why not - ask me tuesday - have sufferred a world of pain  
  
Went here
  
https://www.ncdc.noaa.gov/cdo-web/  
  
to get sample data sets  
The one in this project has been truncated to save space  

Next I evaluated scala APIs for cassandra  
From google it seemed like Phantom was a good fit  
Spent half a day working with that   
and gave up because examples never worked.  

Then discovered this  
https://github.com/datastax/spark-cassandra-connector  

Then began 2 days of torture  
So many problems with versions and compatiblity : scala compiler + spark + spark-cassandra-connector  + hadoop  
Maven could not handle this combination  
Then when I got past build ok - got run time errors  
The exceptions were so misleading but eventually I learned it came down to incompatible  
versions  
<br />
In the end I had to build every component from source - spark and the cassandra connector  
Finally got a build working and running system on sunday afternoon but by then  
had to rush to airport.
<br />
Also it was becoming increasingly harder to work on my machine  
Have a linuxmint OS on only a 4gig machine  
Running cassandra+spark+akka+ide+hadoop was killing me  

Not sure if you wanted to look at my problem solving skills or dev/build  
The hardest part was selecting a decent scala api to cassandra  
The code that is there reads a data file and inserts into db.  
<br />
Ran out of time to do spark analytics.  
I have included to source file in cheatsheet from the book quoted above  
Would have used these as a template to code the spark part.  
<br />
Sorry for the late arrival of this project  
Had to dump everything on a disk last night and then port it all again to windows on my laptop.  
All in all probably spent half a day doing reasearch, an hour coding and 3 days trying  
to get a stable working system up and running.  
<br />
<br />


FYI here is the jar file list with compatible versions using hadoop 2.6.0 with scala 2.11 
<br />

<br />
akka-actor_2.11-2.3.12.jar  
akka-agent_2.11-2.3.12.jar  
akka-file-mailbox_2.11-2.3.12.jar  
akka-kernel_2.11-2.3.12.jar  
akka-mailboxes-common_2.11-2.3.12.jar  
akka-remote_2.11-2.3.12.jar  
akka-slf4j_2.11-2.3.12.jar  
apache-cassandra-2.2.0.jar  
apache-cassandra-clientutil-2.2.0.jar  
apache-cassandra-thrift-2.2.0.jar  
benchmarks.jar  
cassandra-driver-core-2.1.7.1.jar  
cassandra-driver-core-2.2.0-rc2-SNAPSHOT-20150617-shaded.jar  
cassandra-driver-mapping-2.1.7.1.jar  
commons-collections-3.2.1.jar  
commons-configuration-1.6.jar  
commons-lang-2.6.jar  
commons-lang3-3.3.2.jar  
commons-logging-1.1.3.jar  
config-1.2.1.jar  
config-1.3.0-M3.jar  
fred
google-collections-1.0.jar  
guava-14.0.1.jar  
hadoop-auth-2.6.0.jar  
hadoop-common-2.6.0.jar  
hadoop-hdfs-2.6.0.jar  
hadoop-mapreduce-client-app-2.6.0.jar  
hadoop-mapreduce-client-common-2.6.0.jar  
hadoop-mapreduce-client-core-2.6.0.jar  
hadoop-mapreduce-client-hs-2.6.0.jar  
hadoop-mapreduce-client-hs-plugins-2.6.0.jar  
hadoop-mapreduce-client-jobclient-2.6.0.jar  
hadoop-mapreduce-client-shuffle-2.6.0.jar  
jackson-annotations-2.4.0.jar  
jackson-core-2.4.4.jar  
jackson-databind-2.4.4.jar  
jackson-jaxrs-base-2.4.0.jar  
jackson-jaxrs-json-provider-2.4.0.jar  
jackson-module-jaxb-annotations-2.4.0.jar  
jackson-module-scala_2.11-2.4.4.jar  
javax.ws.rs-api-2.0.1.jar  
jersey-client-1.19.jar  
jersey-core-1.19.jar  
jersey-json-1.19.jar  
jersey-server-1.19.jar  
jersey-servlet-1.19.jar  
joda-time-2.7.jar  
json4s-ast_2.11-3.2.10.jar  
json4s-core_2.11-3.2.10.jar  
json4s-jackson_2.11-3.2.10.jar  
log4j-1.2.17.jar  
metrics-annotation-4.0.0-SNAPSHOT.jar  
metrics-benchmarks-4.0.0-SNAPSHOT.jar  
metrics-core-3.0.2.jar  
metrics-core-3.1.2.jar  
metrics-core-4.0.0-SNAPSHOT.jar  
metrics-ehcache-4.0.0-SNAPSHOT.jar  
metrics-graphite-3.1.2.jar  
metrics-graphite-4.0.0-SNAPSHOT.jar  
metrics-healthchecks-4.0.0-SNAPSHOT.jar  
metrics-httpasyncclient-4.0.0-SNAPSHOT.jar  
metrics-httpclient-4.0.0-SNAPSHOT.jar  
metrics-influxdb-4.0.0-SNAPSHOT.jar  
metrics-jdbi-4.0.0-SNAPSHOT.jar  
metrics-jersey2-4.0.0-SNAPSHOT.jar  
metrics-jetty9-4.0.0-SNAPSHOT.jar  
metrics-json-3.1.2.jar  
metrics-json-4.0.0-SNAPSHOT.jar  
metrics-jvm-3.1.2.jar  
metrics-jvm-4.0.0-SNAPSHOT.jar  
metrics-log4j2-4.0.0-SNAPSHOT.jar  
metrics-logback-4.0.0-SNAPSHOT.jar  
metrics-servlet-4.0.0-SNAPSHOT.jar  
metrics-servlets-4.0.0-SNAPSHOT.jar  
metrics.Z
netty-3.8.0.Final.jar  
netty-all-4.0.23.Final.jar  
nscala-time_2.12.0-M2-2.0.0.jar  
protobuf-java-2.5.0.jar  
scala-cassandra_2.10-0.1.0.0.jar  
scala-cql-0.1.0.0-SNAPSHOT.jar  
scala-library-2.11.5.jar  
servlet-api.jar  
slf4j-api-1.7.10.jar  
slf4j-api-1.7.5.jar  
slf4j-log4j12-1.7.10.jar  
spark-cassandra-connector-java_2.11-1.5.0-M1-SNAPSHOT.jar  
spark-cassandra-connector_2.11-1.5.0-M1-SNAPSHOT.jar  
spark-core_2.11-1.4.2-SNAPSHOT.jar  
spark-examples-1.4.2-SNAPSHOT-hadoop2.6.0.jar  
spark-examples_2.11-1.4.2-SNAPSHOT.jar  
spark-network-common_2.11-1.4.2-SNAPSHOT.jar  
spark-network-shuffle_2.11-1.4.2-SNAPSHOT.jar  
spark-unsafe_2.11-1.4.2-SNAPSHOT.jar  
