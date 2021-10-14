# INSTALATION OF MAVEN IN MACOS CATALINA OR HIGHER

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

## Build management 

### Build lifecycle basics

**Lifecycles** 
- default (handles project deployment)
- clean (handles project cleaning) (limpa o codigo que foi compilado) (cleans up artifacts created by prior builds)
- site (creates a web site for the project)

In the **default** lifecycle:
- validate (validates if the projet is correct and the information needed is available)
- compile (compiles the source code of the project)
- test 
- package (take the compiled code and package it in its distributable format, such as a JAR.)
- verify `mvn verify`
- install (install the package into the local repository)
- deploy (copies the final package to the remote repository)


### Build tools

- Maven (more widely used)
- Gradle


### Creating a Maven Project

- Create a directory for the project to reside
- Run the following maven goal `mvn archetype:generate -DgroupId=com.mycompany.staring -DartifactId=starting_maven -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false` the groupId its the company name and the artifactId its the project name, so in this case we can put the names we like, but it has a naming covenction to follow. In this case the _archetype:generate_ its a plugin that provides a goal.
- A directory was created with the artifactId name 
- The pom.xml its the Project Object Model. Its the core project configuration, contains the majority of the information to build the project
> A plugin is a collection of goals with a general purpose

If we run the command `mvn package`, the **package** word means it is a phase, a step in the build lifecycle. Running the mvn command with this phase, means that every phase in the sequence until this one (this one included )

http://api.ipma.pt/open-data/forecast/meteorology/cities/daily/1010500.json 