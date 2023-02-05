# Spring-Boot-Microservices-With-JPA
Spring Boot Microservices with JPA Communicate two microservices


# SQL data

use mydb;



# Server port
 for couponservice = 9091<br>
#for productservice = 9090

# url for fetch discount from couponservice
http://localhost:9090/productapi/products

try JSON:
      {
   "name":"MAC",
    "description":"Cool",
    "price":  "2000",
    "couponCode":"SUPERSALE"
}

for couponservice itself
http://localhost:9091/couponapi/coupons

try JSON for inserting data into database
  {
  "code":SUPERSALE",
  "discount:10
  
}

<p class="has-line-data" data-line-start="0" data-line-end="1">Github repo for the course: Spring Boot Microservices with JPA</p>
<p class="has-line-data" data-line-start="2" data-line-end="3">Snippet and resources</p>


<p class="has-line-data" data-line-start="37" data-line-end="40">Snippets and useful links:<br>
Spring Initializer<br>
<a href="https://start.spring.io/">https://start.spring.io/</a></p>

# Database micoservices db
<p class="has-line-data" data-line-start="45" data-line-end="53">create table product(
id int AUTO_INCREMENT PRIMARY KEY,
name varchar(20),
description varchar(100),
price decimal(8,3) 
);
<br>
create table coupon(
id int AUTO_INCREMENT PRIMARY KEY,
code varchar(20) UNIQUE,
discount decimal(8,3),
exp_date varchar(100) 
);

pom.xml of couponservice<br>
&lt;?xml version=“1.0” encoding=“UTF-8”?&gt;<br>
&lt;project xmlns=&quot;<a href="http://maven.apache.org/POM/4.0.0">http://maven.apache.org/POM/4.0.0</a>&quot; xmlns:xsi=&quot;<a href="http://www.w3.org/2001/XMLSchema-instance">http://www.w3.org/2001/XMLSchema-instance</a>&quot;<br>
xsi:schemaLocation=&quot;<a href="http://maven.apache.org/POM/4.0.0">http://maven.apache.org/POM/4.0.0</a> <a href="http://maven.apache.org/xsd/maven-4.0.0.xsd">http://maven.apache.org/xsd/maven-4.0.0.xsd</a>&quot;&gt;<br>
&lt;modelVersion&gt;4.0.0&lt;/modelVersion&gt;</p>
<p class="has-line-data" data-line-start="54" data-line-end="58">&lt;groupId&gt;com.quicktutorialz.learnmicroservices&lt;/groupId&gt;<br>
&lt;artifactId&gt;ToDoMicroservice&lt;/artifactId&gt;<br>
&lt;version&gt;0.0.1-SNAPSHOT&lt;/version&gt;<br>
&lt;packaging&gt;jar&lt;/packaging&gt;</p>
<p class="has-line-data" data-line-start="59" data-line-end="61">&lt;name&gt;ToDoMicroservice&lt;/name&gt;<br>
&lt;description&gt;Demo project for Spring Boot&lt;/description&gt;</p>
<p class="has-line-data" data-line-start="62" data-line-end="68">&lt;parent&gt;<br>
&lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;<br>
&lt;artifactId&gt;spring-boot-starter-parent&lt;/artifactId&gt;<br>
&lt;version&gt;1.5.7.RELEASE&lt;/version&gt;<br>
&lt;relativePath/&gt; &lt;!-- lookup parent from repository --&gt;<br>
&lt;/parent&gt;</p>
<p class="has-line-data" data-line-start="69" data-line-end="74">&lt;properties&gt;<br>
&lt;project.build.sourceEncoding&gt;UTF-8&lt;/project.build.sourceEncoding&gt;<br>
&lt;project.reporting.outputEncoding&gt;UTF-8&lt;/project.reporting.outputEncoding&gt;<br>
&lt;java.version&gt;1.8&lt;/java.version&gt;<br>
&lt;/properties&gt;</p>
<p class="has-line-data" data-line-start="75" data-line-end="84">&lt;dependencies&gt;<br>
&lt;dependency&gt;<br>
&lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;<br>
&lt;artifactId&gt;spring-boot-starter-data-jpa&lt;/artifactId&gt;<br>
&lt;/dependency&gt;<br>
&lt;dependency&gt;<br>
&lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;<br>
&lt;artifactId&gt;spring-boot-starter-web&lt;/artifactId&gt;<br>
&lt;/dependency&gt;</p>
<pre><code>&lt;dependency&gt;
    &lt;groupId&gt;com.h2database&lt;/groupId&gt;
    &lt;artifactId&gt;h2&lt;/artifactId&gt;
    &lt;scope&gt;runtime&lt;/scope&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
    &lt;groupId&gt;org.projectlombok&lt;/groupId&gt;
    &lt;artifactId&gt;lombok&lt;/artifactId&gt;
    &lt;optional&gt;true&lt;/optional&gt;
    &lt;version&gt;1.16.10&lt;/version&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
    &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
    &lt;artifactId&gt;spring-boot-starter-test&lt;/artifactId&gt;
    &lt;scope&gt;test&lt;/scope&gt;
&lt;/dependency&gt;
&lt;!-- added --&gt;
&lt;dependency&gt;
    &lt;groupId&gt;org.jasypt&lt;/groupId&gt;
    &lt;artifactId&gt;jasypt&lt;/artifactId&gt;
    &lt;version&gt;1.9.2&lt;/version&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
    &lt;groupId&gt;io.jsonwebtoken&lt;/groupId&gt;
    &lt;artifactId&gt;jjwt&lt;/artifactId&gt;
    &lt;version&gt;0.7.0&lt;/version&gt;
&lt;/dependency&gt;
</code></pre>
<p class="has-line-data" data-line-start="112" data-line-end="113">&lt;/dependencies&gt;</p>
<p class="has-line-data" data-line-start="114" data-line-end="128">&lt;build&gt;<br>
&lt;plugins&gt;<br>
&lt;plugin&gt;<br>
&lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;<br>
&lt;artifactId&gt;spring-boot-maven-plugin&lt;/artifactId&gt;<br>
&lt;/plugin&gt;<br>
&lt;/plugins&gt;<br>
&lt;/build&gt;<br>
&lt;/project&gt;<br>
pom.xml of productservice<br>
&lt;?xml version=“1.0” encoding=“UTF-8”?&gt;<br>
&lt;project xmlns=&quot;<a href="http://maven.apache.org/POM/4.0.0">http://maven.apache.org/POM/4.0.0</a>&quot; xmlns:xsi=&quot;<a href="http://www.w3.org/2001/XMLSchema-instance">http://www.w3.org/2001/XMLSchema-instance</a>&quot;<br>
xsi:schemaLocation=&quot;<a href="http://maven.apache.org/POM/4.0.0">http://maven.apache.org/POM/4.0.0</a> <a href="http://maven.apache.org/xsd/maven-4.0.0.xsd">http://maven.apache.org/xsd/maven-4.0.0.xsd</a>&quot;&gt;<br>
&lt;modelVersion&gt;4.0.0&lt;/modelVersion&gt;</p>
<p class="has-line-data" data-line-start="129" data-line-end="133">&lt;groupId&gt;com.quicktutorialz.learnmicroservices&lt;/groupId&gt;<br>
&lt;artifactId&gt;StatisticsMicroservice&lt;/artifactId&gt;<br>
&lt;version&gt;0.0.1-SNAPSHOT&lt;/version&gt;<br>
&lt;packaging&gt;jar&lt;/packaging&gt;</p>
<p class="has-line-data" data-line-start="134" data-line-end="136">&lt;name&gt;StatisticsMicroservice&lt;/name&gt;<br>
&lt;description&gt;Demo project for Spring Boot&lt;/description&gt;</p>
<p class="has-line-data" data-line-start="137" data-line-end="143">&lt;parent&gt;<br>
&lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;<br>
&lt;artifactId&gt;spring-boot-starter-parent&lt;/artifactId&gt;<br>
&lt;version&gt;1.5.7.RELEASE&lt;/version&gt;<br>
&lt;relativePath/&gt; &lt;!-- lookup parent from repository --&gt;<br>
&lt;/parent&gt;</p>
<p class="has-line-data" data-line-start="144" data-line-end="149">&lt;properties&gt;<br>
&lt;project.build.sourceEncoding&gt;UTF-8&lt;/project.build.sourceEncoding&gt;<br>
&lt;project.reporting.outputEncoding&gt;UTF-8&lt;/project.reporting.outputEncoding&gt;<br>
&lt;java.version&gt;1.8&lt;/java.version&gt;<br>
&lt;/properties&gt;</p>
<p class="has-line-data" data-line-start="150" data-line-end="159">&lt;dependencies&gt;<br>
&lt;dependency&gt;<br>
&lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;<br>
&lt;artifactId&gt;spring-boot-starter-data-jpa&lt;/artifactId&gt;<br>
&lt;/dependency&gt;<br>
&lt;dependency&gt;<br>
&lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;<br>
&lt;artifactId&gt;spring-boot-starter-web&lt;/artifactId&gt;<br>
&lt;/dependency&gt;</p>
<pre><code>&lt;dependency&gt;
    &lt;groupId&gt;mysql&lt;/groupId&gt;
    &lt;artifactId&gt;mysql-connector-java&lt;/artifactId&gt;
    &lt;scope&gt;runtime&lt;/scope&gt;
    &lt;version&gt;5.1.39&lt;/version&gt; &lt;!-- MySQL version - without it gives errors--&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
    &lt;groupId&gt;org.projectlombok&lt;/groupId&gt;
    &lt;artifactId&gt;lombok&lt;/artifactId&gt;
    &lt;optional&gt;true&lt;/optional&gt;
    &lt;version&gt;1.16.10&lt;/version&gt; &lt;!-- lombok added --&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
    &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
    &lt;artifactId&gt;spring-boot-starter-test&lt;/artifactId&gt;
    &lt;scope&gt;test&lt;/scope&gt;
&lt;/dependency&gt;
</code></pre>
<p class="has-line-data" data-line-start="177" data-line-end="178">&lt;/dependencies&gt;</p>
<p class="has-line-data" data-line-start="179" data-line-end="198">&lt;build&gt;<br>
&lt;plugins&gt;<br>
&lt;plugin&gt;<br>
&lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;<br>
&lt;artifactId&gt;spring-boot-maven-plugin&lt;/artifactId&gt;<br>
&lt;/plugin&gt;<br>
&lt;/plugins&gt;<br>
&lt;/build&gt;<br>
&lt;/project&gt;<br>


 
