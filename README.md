# eclipsePojo
It contains a lot of small project that can be used  in personal or industry

Project 1: Login (Easy)
  Simulate a Login system that using cookie technology. It implement password-free login within 3 days by using cookies and sessions.
  You will need tomcat server built on your computer. Then you can try the password-free login within 3 days function
 
Project 2: Information Management System (Easy)
  It is an basic function of Management system that can store the human resources you need. 
  Information Management System:
	  Technologies requirement: 
		  servlet + jsp + mvc + jdbc
	  Software requirement: 
      develop tools: myEclipse
      database: mySql
      Server: tomcat
      Browser: Firefox
    Hardware requirement:
	  	Just a worked computer	
	  Function implementation:
      User Login
      User Registry
      User LoginOut
      User Information
      User change Password
      Check all information of user
  	Design of Database:
      create table: t_user
      table :
        uid   	 	int(10)     	primary key, not null, auto increment
        uname  		varchar(50)		not null
        pwd 		varchar(50)		not null
        sex 		char(2)			not null
        age			int(3)			
        birth		date	
    Additional:
      Use log4j	

Project 3: Bank Simulation
  Simulating a function of bank. What you need is a database that stored the client information, and implement the basic function what 	   bank need
