HBCProject
==========

Note:

The user add url in this project,
http://localhost:8080/sample/user/add/<name>
is written as a GET mehod, as the requirement mandates the arguement should be passed with the url.
However, this should be ideally implemented as a POST request. 



Please do the following steps to build this project

1. Clone the repository

    git clone https://github.com/thomanna16/HBCProject.git
    
2. Goto sample folder and execute maven package command
 
    cd sample

    mvn package
  
   This will create sample.war file in sample/target folder
  
3. Deploy the generated sample.war file into Tomcat
 
  

