# tutorial-microservices-dataflow

> sudo service zookeeper start <br>
> sudo service kafak start <br>


Download Dafllow jar <br>
http://repo.spring.io/milestone/org/springframework/cloud/spring-cloud-dataflow-server-local/1.3.0.M1/spring-cloud-dataflow-server-local-1.3.0.M1.jar <br>

> java -jar spring-cloud-dataflow-server-local-1.3.0.M1.jar <br>

<b>For Data flow Server UI:</b> <br>
http://localhost:9393/ <br>
Register and Deploy from UI <br>

OR

<b>for Shell commands:</b> <br>
Download http://repo.spring.io/milestone/org/springframework/cloud/spring-cloud-dataflow-shell/1.3.0.M1/spring-cloud-dataflow-shell-1.3.0.M1.jar <br>
> java -jar spring-cloud-dataflow-shell-1.3.0.M1.jar <br>
 
dataflow:>app register --name source-app --type source --uri maven://com.javainuse:source:jar:0.0.1-SNAPSHOT <br>
dataflow:>app register --name processor-app --type processor --uri maven://com.javainuse:processor:jar:0.0.1-SNAPSHOT <br>
dataflow:>app register --name sink-app --type sink --uri maven://com.javainuse:sink:jar:0.0.1-SNAPSHOT <br>

<b>uri Types:</b>

dataflow:>app register --name mysource --type source --uri maven://com.example:mysource:0.0.1-SNAPSHOT <br>

dataflow:>app register --name myprocessor --type processor --uri file:///Users/example/myprocessor-1.2.3.jar <br>

dataflow:>app register --name mysink --type sink --uri http://example.com/mysink-2.0.1.jar <br>

stream create --name log-data --definition 'source-app | processor-app | sink-app' <br>

stream deploy --name log-data <br>

for Log: log /tmp/spring-cloud-deployer-8696918380487588935/... <br>

