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


## SpringBoot

### Developing an app with Springboot


> **Thymleaf** server-side rendering of HTML. Parses templates and render values passed to those templates.

> **Bean** [link to the definition](https://www.baeldung.com/spring-bean)

- **@Controller**: handles HTTP requests. In Spring we can use the annotation @Controller to mark a class as a Controller.
- **@GetMapping**: ensures that HTTP GET requests are mapped into their specific method.
- **@RequestParam**: binds a value from the query string to a parameter of the method. There are many options in this annotation
    - `required = boolean` tells if the parameters is required or not.
    - `defaultValue = "Some value"` is the value passed to the parameter if no value is passed in the query.
- **@SpringBootApplication** an annotation that adds other annotaions like:
    - **@Configuration** tags the class as a source of bean definitions for the application context.
    - **@EnableAutoConfiguration** tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings
    - **ComponentScan** tells Spring to look for other components, configurations, and services in the package, letting it find the controllers.

#### Running Spring App

To run the server we have to use the command `./mvnw spring-boot:run`