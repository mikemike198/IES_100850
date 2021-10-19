# LAB 1
## **Maven**
**INSTALATION OF MAVEN IN MACOS CATALINA OR HIGHER**

- Download the MAVEN instalation from the [Maven download Site](https://maven.apache.org/download.cgi) the tar.gz option
- Extract the files to the desired folder.
- In the terminal move to the folder where the apache-maven is
- Remove the tar.gz file `rm apache-maven*bin.tar.gz` (substitute the * with the version of the )
- Give the file permissions `chown -R root:wheel apache-maven*` (substitute the * with the version of the )
- Move the folder apache-maven* `mv apache-maven* /opt/apache-maven`
- Open the file .zshenv `nano ~/.zshenv `, this file is where we store the bins to use generaly
- Write in the file the following line `export PATH=$PATH:/opt/apache-maven/bin`, this will add to the path the maven commands so we can use in all areas of the computer
- And reload the enviroment `source ~/.zshenv `
- Now the command `mvn --version` should show the information about the maven installation

**Maven -> agregador de bibliotecas**

**ARTIFACT == LIBRARY**

### Build lifecycle basics

**Lifecycles** 
- default (handles project deployment)
- clean (handles project cleaning)(limpar o codigo compilado)
- site (creates a web site for the project)

In the **default** lifecycle:
- validate 
- compile
- test
- package
- verify `mvn verify`
- install 
- deploy


### Build tools

- Maven (more widely used)
- Gradle

## Starting a simple Maven project 

- Create a directory to the project reside.

groud id: nome projeto ou organização
archetipe: nome app

**cache local maven -> ~/.m2/repository**

### POM

In the POM we can add inforamtion about:
- name of the project 

    ```xml 
    <name>My Weather Radar</name>
    ```
- dependencies (libraries that we want to include in the project)(JARs are most of the times fetched from Maven Central Repository)

    ```xml
    <dependencies>
        <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.11</version>
        <scope>test</scope>
        </dependency>
    </dependencies>    
    ```

- licenses

    ``` xml
    <licenses>
        <license>
            <name>Apache 2</name>
            <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
            <distribution>repo</distribution>
            <comments>A business-friendly OSS license</comments>
        </license>
    </licenses>
    ```
- organization information

    ```xml
    <organization>
        <name>Universidade Aveiro</name>
        <url>http://www.ua.pt</url>
    </organization>
    ```
- developer information

    ``` xml
    <developers>
        <developer>
            <id>mike</id>
            <name>Miguel Garcia Marques</name>
            <email>m.garcia.marques@ua.pt</email>
            <url>http://www.ua.pt</url>
            <organization>Universidade Aveiro</organization>
            <roles>
                <role>student</role>
            </roles>
        </developer>
    </developers>    
    ```
- character encoding
    ```xml
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        ...
    </properties>
    ```
- Java version
    ```xml
    <properties>
        <maven.compiler.source>1.7</maven.compiler.source>
        <maven.compiler.target>1.7</maven.compiler.target>
        ...
    </properties>
    ```

### Useful Artifacts

- [Retrofit](https://square.github.io/retrofit/)
    - Http client for Java
- [Gson](https://github.com/google/gson)
    - Library used to convert Java Objets into JSON representations


> If we run the command `mvn package`, the **package** word means it is a phase, a step in the build lifecycle. Running the mvn command with this phase, means that every phase in the sequence until this one (this one included )
<!-- http://api.ipma.pt/open-data/forecast/meteorology/cities/daily/1010500.json  -->


> If we want to pass arguments to a program by executing with the maven command `mvn exec:java` we can pass them by using the tag `-Dexec.args="arg1 arg2 arg3"`. To pass multiple arguments we just need to separate them with a space in the tag.


## **GIT**

### .gitignore file

Some important rules:
- blank line dont mean nothing, they can be used for separation purposes (readability)
- for comments `#`, to use this symbol as part of a file name or path use `\`
- the prefix `!` is used for negate a pattern, if used a file is included again, not removed