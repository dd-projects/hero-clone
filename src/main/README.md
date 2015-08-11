##Project Structure
- src/main/java will be compiled into classes
  - Each package should be a subdirectory
  - _com/heroclone/api/controller/SampleController.java_
- src/main/resources will be placed into the WEB-INF/classes (classpath) directory and be accessible to the application
  - _log4j.properties_
- src/main/webapp will be placed into the root of the WAR.
  - Static resources should be located in WEB-INF/resources, this directory is mapped to /resources/ by the application initializer
  - JSP pages should be located in _jsp/_
