package com.in28minutes.springboot.web;

public class Text {
	
	
	/*
	 First we will pull a docker image 
	 docker run mysql:5.7 --->we want 5.7 version if we dont have mysql image 
	 so first it will pull docker image like docker pull mysql then run it is merged command insted of 2 commands
	  
	  after this u will get error db is uninitialized and pw option is not specifed
	  you need to specify MYSQL ROOT PW
	  
	  MYSQL_ROOT_PASSWORD ---this variable is mandatory and specifies the pw that will be set for mysqlroot superuser account
	  MYSQL_DATABASE----Optional allows you to specify the name of the db to be created at image start up
	  see mysql docker hub u will see various environment variables and their usage
	  -e to specify environment variable
	  MYSQL_ROOT_PASSWORD i have set to dummypassword
docker run -d -e MYSQL_ROOT_PASSWORD= dummypassword  -e MYSQL_DATABASE=todos -e MYSQL_ USER= todos-user -e MYSQL_PASSWORD=todos mysql:5.7
	it create an id 12345abc and container is exposing to port 3306/tcp
In summary, MYSQL_ROOT_PASSWORD is used to set the root user's password, which is crucial for managing the MySQL server. MYSQL_PASSWORD is used to set the password for additional non-root MySQL users, providing more granular control over user access to databases.
	  
	  docker container list ---u can see 12345abc the id of mysql container
so mysql server has been started now we will install My SQL Shell Client so that we can write queries in this 	  
	  
	  MySQL  JS > \connect todos-user@localhost:3306 we are telling to connect to server which is running with user name todos-user which is in local host with port 3306 
	  but fails because we not map container port 3306 to local host
	  so stop container docker container stop 12345abc
	  docker rm 12345abc it will remove the container 
docker run -d -e MYSQL_ROOT_PASSWORD= dummypassword  -e MYSQL_DATABASE=todos -e MYSQL_ USER= todos-user -e MYSQL_PASSWORD=dummytodos -p 3306:3306 mysql:5.7	 
	MySQL  JS > \connect todos-user@localhost:3306 
	Creating a session to 'todos-user@localhost:3306'
Please provide the password for 'todos-user@localhost:3306': 
Save password for 'todos-user@localhost:3306'? :dummytodos
MySQL  localhost:3306 ssl  JS > \sql
Switching to SQL mode... Commands end with ;

 MySQL  localhost:3306 ssl  SQL > use todos
 select * from todos ; no data start spring boot app and insert data
	 
	 */

}
