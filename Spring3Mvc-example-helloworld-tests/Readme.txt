DESCRIPTION
===========

This is example project built by using framework Spring 3 MVC. It consists of two pages:
- input page		: here you can type your name;
- output page		: here your name is displayed after text "Hello World"

This project shows how to use framework Spring 3 MVC together with:
- java script;
- css;
- validation.

This project contains also unit and integration tests. 





PRECONDITIONS
=============

This example project requires:
- Java (tested for version 1.7.0_10);
- Maven (tested for version 3.0.4);
- Tomcat (tested for version 7.0.34).





DEPLOYMENT
==========

You can deploy this application in two ways:
1. Copy war file
2. Use Maven plugin for deployment


Ad 1\ Copy war file
===================
You can do it using following steps:
- Open console;
- Go to project folder "Spring3Mvc-example-helloworld";
- Use Maven command for building project. Command: 
  
  mvn clean install
  
- Copy file "Spring3Mvc-example-helloworld.war" from <project_home>/target to <tomcat_home>/webapp


Ad 2\ Use Maven plugin for deployment
=====================================  
You can do it using following steps:
- Go to <tomcat_home>/conf/tomcat-users.xml and add user in manager role. For instance:

  <user username='admin' password='admin' roles='manager-gui,admin-gui,manager-script'/>
  
- Set server informations in file: <project_home>/project.properties. You have to set:
  loc.server.url, loc.server.username, loc.server.password;  
- Open console;
- Go to project folder "Spring3Mvc-example-helloworld";
- Use Maven command for building and deployment project. Command:
 
  mvn clean install -Ploc,deploy  





USAGE
=====

Type in browser:

http://localhost:8080/Spring3Mvc-example-helloworld





UNIT TESTS
==========

To run unit tests you have to use maven command:

mvn clean install -Ploc,unit





INTEGRATION TESTS
=================

To run integration tests you have to:

- Configure embedded Tomcat
In file <project_home>/project.properties you have to set embedded Tomcat port.
Update property "loc.test.intg.port". By default it is "8181".

- Run integration tests
To run integration tests you have to use maven command:

mvn clean install -Ploc,intg