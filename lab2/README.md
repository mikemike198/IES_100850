# **Lab2**

## Server-side programming with servlets

> **Servelet**: Java Class that runs at the server, handles (client) requests, processes them, and reply with a response. Must be deployed to a Servelet Container (diferent from Docker Container, no virtualization).
> Servlets are not static web pages; they are dynamic, and that is arguably their biggest strength.

### Instalation of Tomcat (macOS)

- Download the zip from the [Tomcat Website](https://tomcat.apache.org/download-90.cgi), the core -> zip binary.
- Unzip the folder in the chosen directory
- Give persmissions to all the shell files `chmod +x bin/*.sh`
- Run the startup script `bin/startup.sh`
- To shutdown run the command `bin/shutdown.sh`

### Configure Tomcat User for management

- Go to file `conf/tomcat-users.xml`
- Add this block of code to that file, this will create a user that cable to access the manager GUI and to run scripts also
    ``` xml
    <role rolename="manager-gui"/>
    <role rolename="manager-script"/>
    <user username="admin" password="secret" roles="manager-gui,manager-script"/>
    ```

### Deploying an app to Tomcat

First we need to put our app in a war file. To do that we need:
- Run the command `mvn install`, this will run every maven phase until the install phase, that will package our app in a war file.

Then, the option more user friendly is to upload our war app file is:
- Access `http://localhost:8080/manager`
- Go to the Deploy -> War file to deploy
- Choose the war file that is in the folder target of the maven project
- And check if the app was deployed correctly going to the list of apps and seeing if you app is in that list

## Review Questions

- **A** - **What are the responsabilities/services of a "servelet container**
    - A Servelet Container is reponsable to instantiate a servelet and also responsable to create a new thread to handle request from the web, mostle HTTP request. A Servelet container works as an interface between the servelet and the outside world, that receives request and sends responses based on the requests made. A Servelet Container can handle multiple requests by creating multiple threads.

- **B** - **Explain, in brief, the “dynamics” of Model-View-Controller approach used in Spring Boot to serve web content. (You may exemplify with the context of the previous exercises.)**
    - Model is the representation of the data used by the Controller to serve that data throught a "view", a method or class that is used to create the logic behind a system. In other words, in the example of Random Quotes that we have done in this lab, we created a Controller class that maps http requests to http responses. In that Controller class we use 2 representations of data, a Quote class and a Show class. Both of this classes are uses as models to delivery information in the http response in a json format. The class Shows works as a View, it creates the objects, and filters them out so that we can use that curated data to meet the request need.

- **C** - **Inspect the POM.xml for the previous Spring Boot projects. What is the role of the “starters” dependencies?**
    - The spring-boot-starter-web is used to build a web application using Spring MVC. It also uses Tomcat as the default servelet container. 

- **D** - **Which annotations are transitively included in the @SpringBootApplication?**
    - @Configuration, @EnableAutoConfiguration and @ComponentScan

- **E** - **Search online for the topic “Best practices for REST API design”. From what you could learn, select your “top 5” practices, and briefly explain them in you own words.**
    - The first and basic practice is to accept and respond all requests with JSON format. This is very important because JSON is the standard for transferring data and the machine that requested the information will most likely decode it thinking that it in JSON. JSON is also a very easy way to transform data into an organized state and a state that is easy to send via http.
    - Another important practice is to use nouns instead of verbs in endpoint paths. When we use a rest api, we mostly need to get data from a server or something similar. To fecth that data we need to know where to fetch it from. To do so we use the api endpoints. If those endpoints use nouns instead of verbs, it will help clients to know what data they are fetching from that endpoint by only reading the name of the endpoint.
    - Handle errors gracefully and return standard error codes is also a very good practice when working on REST api's. Errors occur, and to handle those errors in a very explanatory way there are standarts and protocols that are in place to help better understand what went wrong in that request. Those codes can be used be the server side to generate usefull and helpfull error messages that can elucidate the client to know what went wrong. 
    - Allow filtering, sorting, and pagination is very important pillar when talking about REST API's. Most of the time when we talk about API's, talk about data, and when we talk about data, we talk about databases. The more the requests and the more the data, the more the server needs to overwork. If we give the options to filter and sort the requests, the more refined the results will be and also the less work the server will have to handle those requests.
    - Cache data to improve performance also enters in the last practice but is also good to mention. When dealing with a lot of similar requests its much easier if we keep recent results cached in a more easily and effortless way so that the server doesnt need to access the database every time that same request is made
