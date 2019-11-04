Information Management System:
	
	Technologies requirement: 
		servlet + jsp + mvc + jdbc
	
	Software requirement: 
		develop tools: myEclipse
		database: mySql
		Server: tomcat
		Browser: Firefox
		
	Hardware requirement:
		Just computer
		
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