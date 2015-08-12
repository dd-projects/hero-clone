# Project Structure

## src/main/java  ###
- Java source code, gets compiled into .class files
- Each package should be a subdirectory
  - _com/project/api/controller/SampleController.java_

## src/main/resources
- Gets packed into the WEB-INF/classes (classpath) directory
- Non-web-accessible files such as configs
  - _log4j.properties_

## src/main/webapp 
- Gets packed into the root of the WAR.
- Static resources should be located in WEB-INF/resources, this directory is mapped to /resources/ by the application initializer
- JSP pages should be located in _jsp/_
