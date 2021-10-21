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

### Creating a Git Repository and cloning it withb GitHub

Steps:
- `cd project_folder` project_folder is the directory where the project to be uploaded to git
- `git init` this command makes the directory git ready
- `git remote add origin <REMOTE_URL>` this command link the repository of the GitHub with the local repository that we have on our machine. The REMOTE_URL is the Url of the GitHub repo
- `git add.` this command adds all of the files in the directory to the staging area. The dot means that all files will be added.
- `git commit -m "Initial project setup for exercise 1_3"` this command saves the changes made in the staging area. The -m tag stands for the message, that is the part in aspas.
- `git push -u origin main` uploads the local commits to GitHub repo. We can also use `git push`
- `git pull` to update our local repo from the remote repo

## **Docker**

Docker functionalities:
- Portable deployment of applications as a single object
- Application-centric versus machine/server-centric
- Supports for automatic container builds
- Built-in version tracking
- Reusable components
- Public registry for sharing containers

> Container: a sandboxed process that is isolated from all other processes on the host machine.

> Container Image: contains everything needed to run an application - all dependencies, configuration, scripts, binaries, etc. It also contains other configuration for the container, such as environment variables, a default command to run, and other metadata.

> Conecting to an instance of postgres running in a container: `pgcli -h localhost -U postgres -d postgres -p 5433`

**Dockerfile**
A Dockerfile is simply a text-based script of instructions that is used to create a container image

To create a container image from a Dockerfile:
- `docker build -t getting-started .` this command must be used in the directory of the Dockerfile. 

To start a container:
- `docker run -dp 3000:3000 getting-started`

> WORKDIR: The WORKDIR instruction sets the working directory for any RUN, CMD, ENTRYPOINT, COPY and ADD instructions that follow it in the Dockerfile

> We can't specify the host directory for a volume in a Dockerfile. To do so, when we run the command to run the container we specify the mount using for example `-v $HOME/docker/volumes/postgres:/var/lib/postgresql/data`

**Docker compose**

To run an app with compose we use the command `docker-compose up`


## **Review Questions**

**A** The default cycle is compose of many phases. The main ones are validate, compile, test, package, verify, install and deploy. The validate phase is where maven validates the code that was written in terms of errors in code. The compile phase is where maven will compile all the project, ready to be executed. the test phase is a very important one, is where maven will run all the tests written and verify if the code passses them all, if not the cycle will end (same as the other phases). The package phase maven will package the project into whatever format we want, the most common is JAR.

**B** Yes. Maven is build tool but is also a tool used to run the project and do other things too, like deploy the project, test the project etc.

**C** The commands that I would use are: `git pull`, `git add .`, `git commit -m "message"`, `git push`

**D** Commit messages should be very readable in terms of other people being able to understand what that commit (increment) was all about. Commit messages should not be too long. Normaly, in team projects, there are rules to write commit messages, like key words, topics, etc to be able to localize better the commits if needed.

**E** It is important because the container data is temporary, meaning that it only is available if the container is running. If the container is down or even deleted we cant access the data, wheter is temporaraly or even forever. So its is important to map the data in a container to the data in the host machine. In the case of a production database, we want the data to persist, so that even when the container is down, or deleted the data is safely stored in the server that is running the container. 