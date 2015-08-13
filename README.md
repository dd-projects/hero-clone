# HeroClone v0.0

An adventure game for 2-5 players

## Where we're at
This project is being undertaken in the pursuit of familiarizing ourselves with Java-based web applications, Tomcat, and Spring WEBMVC/Security.

As of version 0.0, this is a simple proof of concept STS project that incorporates basic JSTL, and initializes a Spring WEBMVC application. Our hope is to keep this running and turn it into a real live game. Keep an eye out!

## Technologies:
- Java 7
- Tomcat
- MySQL 5.5
- Spring Tool Suite 3.7
- Spring Web MVC 4.1.6
- jQuery
- HTML5
- Hibernate 4

## Getting Started
### Install Gradle
```bash
brew install gradle 
```
### Install STS from https://spring.io/tools
##### Mac OSX
1. Download the tarball
2. Unzip to /opt/
3. Symlink sts.app into Applications
```bash
ln -s /opt/spring-tool-suite/sts.app /Applications/sts.app
```

##### Windows
1. Run installer

### Install required plugins
1. Launch STS
2. Help -> Eclipse Marketplace
3. Install the following
  1. Gradle Integration for Eclipse
  2. Minimalist Gradle Editor
  3. Nodeclipse/Endie Gradle for Eclipse (Optional)
  4. Gradle IDE Pack (Optional)

### Clone the repo

### Add project to STS
1. Launch STS
2. File -> Import -> General -> Existing Projects Into Workspace
3. Select repo folder
4. Right click project -> Gradle -> Refresh All (This will collect the dependencies)

### Building the project
##### Command-Line
```bash
cd sample-spring
gradle clean build
```
##### GUI

1. Right-click project
2. Gradle -> Build

### Deploying the WAR
Build artefacts are located in build/libs. Copy the WAR file to tomcat's webapps folder to deploy


## Contributors
- Prov
